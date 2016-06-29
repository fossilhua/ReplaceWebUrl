package com.lsh.spandemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lsh.changeweburllib.LinkUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTvBefore;
    private TextView mTvAfter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvBefore = (TextView) findViewById(R.id.tv_before);
        mTvAfter = (TextView) findViewById(R.id.tv_after);
        mTvBefore.setText(getString(R.string.text_test_str));
    }

    public void ChangeText(View v) {
        String des = mTvBefore.getText().toString().trim();
        if (TextUtils.isEmpty(des)) {
            return;
        }
        LinkUtil linkUtil = new LinkUtil(this);
        linkUtil.setReplaceStr("\uE620网络链接");
        linkUtil.applyUrl(mTvAfter, des);
        linkUtil.setOnClickUrl(new LinkUtil.OnClickUrl() {
            @Override
            public void onClick(View widget, String url) {
                Toast.makeText(MainActivity.this, "url:" + url, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
