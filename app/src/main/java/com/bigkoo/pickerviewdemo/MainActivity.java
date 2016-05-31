package com.bigkoo.pickerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.OnDismissListener;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends Activity {

    private TextView tvOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOption = (TextView) findViewById(R.id.tvOptions);
        tvOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDistrictSelect();
            }
        });
    }


    public void showDistrictSelect() {
        Log.e("click", "click");
        try {
            InputStream input = getAssets().open("province_data.xml");
            // 创建一个解析xml的工厂对象
            SAXParserFactory spf = SAXParserFactory.newInstance();
            // 解析xml
            SAXParser parser = spf.newSAXParser();
            XmlParserHandler handler = new XmlParserHandler();
            parser.parse(input, handler);
            input.close();
            // 获取解析出来的数据
            List<ProvinceModel> provinceList = handler.getDataList();
            final ArrayList<String> provinceNames = new ArrayList<>();
            final ArrayList<ArrayList<String>> cityDatas = new ArrayList<>();
            final ArrayList<ArrayList<ArrayList<String>>> districtDatas = new ArrayList<>();
            for (int i = 0; i < provinceList.size(); i++) {
                // add province names
                provinceNames.add(provinceList.get(i).getName());
                // get cities of province
                List<CityModel> cityList = provinceList.get(i).getCityList();
                //current province's city info
                ArrayList<String> cityNames = new ArrayList<>();
                ArrayList<ArrayList<String>> districtsInfo = new ArrayList<>();
                for (int j = 0; j < cityList.size(); j++) {
                    // add city names to current province's list
                    cityNames.add(cityList.get(j).getName());
                    List<DistrictModel> districtList = cityList.get(j).getDistrictList();
                    ArrayList<String> distrinctNames = new ArrayList<>();
                    for (int k = 0; k < districtList.size(); k++) {
                        // add district names to array
                        // 区/县对于的邮编，保存到mZipcodeDatasMap
                        distrinctNames.add(districtList.get(k).getName());
                    }
                    districtsInfo.add(distrinctNames);
                    // 市-区/县的数据，保存到mDistrictDatasMap
                }

                cityDatas.add(cityNames);
                districtDatas.add(districtsInfo);
            }
            //选项选择器
            OptionsPickerView pvOptions = new OptionsPickerView(this);
            //三级联动效果
            pvOptions.setPicker(provinceNames, cityDatas, districtDatas, true);
            //设置选择的三级单位
//        pwOptions.setLabels("省", "市", "区");
            pvOptions.setTitle("选择城市");
            pvOptions.setCyclic(false, false, false);
            //设置默认选中的三级项目
            //监听确定选择按钮
            pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {

                @Override
                public void onOptionsSelect(int options1, int option2, int options3) {
                    //返回的分别是三个级别的选中位置
                    String address = provinceNames.get(options1) +
                            cityDatas.get(options1).get(option2) +
                            districtDatas.get(options1).get(option2).get(options3);
                    Toast.makeText(MainActivity.this, "address = " + address, Toast.LENGTH_SHORT).show();
                    tvOption.setText(address);
                }
            });
            //点击弹出选项选择器
            pvOptions.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(Object o) {
                }
            });
            pvOptions.show();
            // 省-市的数据，保存到mCitisDatasMap

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }


    }

}
