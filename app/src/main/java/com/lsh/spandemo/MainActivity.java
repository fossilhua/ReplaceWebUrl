package com.lsh.spandemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lsh.changeweburllib.LinkUtil;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    String str = "\uD83D\uDE03测试http://baidu.com 测试http://ddddd.com \uD83D\uDE03";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_des);
        LinkUtil linkUtil=new LinkUtil(this);
        linkUtil.setReplaceStr("\uE620网络链接");
        linkUtil.applyUrl(tv,str);
        linkUtil.setOnClickUrl(new LinkUtil.OnClickUrl() {
            @Override
            public void onClick(View widget, String url) {
                Toast.makeText(MainActivity.this,"url:"+url,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
