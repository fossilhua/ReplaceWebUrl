# ReplaceWebUrl

仿微博文本中web url替换成图文效果，可自定义文字效果。

First of all, a screenshot:

![screenshot1](https://raw.githubusercontent.com/fossilhua/ReplaceWebUrl/master/raw/gif1.gif)

[Demo APK下载](https://raw.githubusercontent.com/fossilhua/ReplaceWebUrl/master/raw/app-debug.apk)

## How to Use

###### 1.Integration jcenter

Please follow the latest publishing aar on jcenter.

follow by the gradle code
```gradle
dependencies{
    compile 'com.lsh:ReplaceWebUrl:1.0.1'
}
```

###### 2.Usage:

``` 
LinkUtil linkUtil = new LinkUtil(this);
linkUtil.setReplaceStr("这是个网络链接");
linkUtil.setTextPaint(Color.BLUE, false);
linkUtil.applyUrl(textView, des);
linkUtil.setOnClickUrl(new LinkUtil.OnClickUrl() {
    @Override
    public void onClick(View widget, String url) {
        Toast.makeText(MainActivity.this, "url:" + url, Toast.LENGTH_SHORT).show();
    }
});
```
### Version Log
* ***v1.0.0*** 

添加更改文字方法

* ***v1.0.1*** 

添加设置链接样式方法 

修改设置替换文字样式方法



