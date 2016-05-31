Android-District-Picker
==========

再android-pickerView 的基础上进行了部分修改， 主要添加了对字体长度的判读已达到字长时显示小字体字短时显示打字体
```java
         String contentText = getContentText(visibles[counter]);
         // my added code here
         if (contentText.length() < 5) setTextSize(18);
         else if (contentText.length() >= 5 && contentText.length() < 7) setTextSize(15);
         else if (contentText.length() >= 7) setTextSize(11);

```
## Demo 图片
![](https://github.com/saiwu-bigkoo/PickerView/blob/master/preview/pick-demo.gif)

- [demo code here](https://github.com/1212300114/Android-District-Picker/blob/master/app/src/main/java/com/bigkoo/pickerviewdemo/MainActivity.java)


>## 更新说明

>v2.0.0 不需修改任何代码就可以兼容1.x
 - 外观大整改  <br />
 - 支持反射获取getPickerViewText()来获取要展示数据，以前只能传String的对象，现在可以传任意对象只要有getPickerViewText()函数即可显示对应的字符串，如果没有getPickerViewText()函数则使用对象toString作为显示  <br />
 - 加入setTitle  <br />
 
>v2.0.1
 - 去掉popupWindow，改用View，类名也对应修改为TimePickerView和 OptionsPickerView <br />
 - 加入遮罩效果  <br />

>v2.0.2
 - 修复不循环模式下点击空白item处出现数组越界问题 <br />
 - 修复循环模式下只有一条数据的时候只显示三条而不是填充满高度问题  <br />

>v2.0.3
 - 修复时间选择的时候部分数字选不到直接跳到下一个数字的问题 <br />

>v2.0.4
 - 修复不循环模式下顶部超出范围问题 <br />
 - wheel view文字颜色通过xml配置 <br />

>v2.0.5
 - 修复不循环模式下底部超出范围问题 <br />

>v2.0.6
 - 修复不循环模式下点击超出范围问题，修复后点击空白的地方，只能滚到最顶或最底，不会滚出数据范围。 <br />

>v2.0.7
 - 修复设置初始化position ，第三级数据不对的BUG。 <br />
 
>v2.0.8
 - 修复＃41 未选中项有错乱数据问题。<br />
 - 加入pickerview_customTextSize 和 pickerview_textsize 到 xml 中 来控制自定义文字大小<br />

-－－－－－－－－－－－－－－－－－－－－华丽丽的分割线－－－－－－－－－－－－－－－－－－－－－－－－－－

PickerView1.x (我已经把1.0.3版本分到v1.x的分支去了，停止维护1.x的分支)
==========

####使用gradle 依赖:
```java
   compile 'com.bigkoo:pickerview:1.0.3'
```

## Demo 图片（招行信用卡的“掌上生活”里面条件选择器他们用的就是我这个库，大家可以当实际项目参考）
![](https://github.com/saiwu-bigkoo/PickerView/blob/master/preview/pickerdemo1x.gif)
![](https://github.com/saiwu-bigkoo/Android-PickerView/blob/master/preview/pickerdemo_zhangshangshenghuo.gif)


## Thanks

- WheelView
- [androidWheelView](https://github.com/weidongjian/androidWheelView/)
- [Android-PickerView](https://github.com/saiwu-bigkoo/Android-PickerView)
