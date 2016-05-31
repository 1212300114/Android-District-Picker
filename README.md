Android-District-Picker
==========

在android-pickerView 的基础上进行了部分修改， 主要添加了对字体长度的判读已达到字长时显示小字体字短时显示打字体
```java
         String contentText = getContentText(visibles[counter]);
         // my added code here
         if (contentText.length() < 5) setTextSize(18);
         else if (contentText.length() >= 5 && contentText.length() < 7) setTextSize(15);
         else if (contentText.length() >= 7) setTextSize(11);

```
## Demo image
![](https://github.com/1212300114/Android-District-Picker/blob/master/preview/pick-demo.gif)

- [All demo code is here](https://github.com/1212300114/Android-District-Picker/blob/master/app/src/main/java/com/bigkoo/pickerviewdemo/MainActivity.java)




## Thanks

- WheelView
- [androidWheelView](https://github.com/weidongjian/androidWheelView/)
- [Android-PickerView](https://github.com/saiwu-bigkoo/Android-PickerView)
