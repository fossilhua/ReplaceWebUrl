# ReplaceWebUrl
First of all, a screenshot:

![screenshot1](https://raw.githubusercontent.com/fossilhua/ReplaceWebUrl/master/raw/gif1.gif)

[Demo APK下载](https://raw.githubusercontent.com/fossilhua/ReplaceWebUrl/master/raw/app-debug.apk)

## How to Use

###### 1.Integration jcenter

Please follow the latest publishing aar on jcenter.

follow by the gradle code
```gradle
dependencies{
    compile 'com.lsh:ReplaceWebUrl:1.0.0'
}
```

###### 2.Usage:

``` 
LinkUtil linkUtil = new LinkUtil(this);
linkUtil.setReplaceStr("\uE620网络链接");
linkUtil.applyUrl(textView, des);
linkUtil.setOnClickUrl(new LinkUtil.OnClickUrl() {
    @Override
    public void onClick(View widget, String url) {
        Toast.makeText(MainActivity.this, "url:" + url, Toast.LENGTH_SHORT).show();
    }
});
```
### Version Log
* ***v1.0.0*** ...


