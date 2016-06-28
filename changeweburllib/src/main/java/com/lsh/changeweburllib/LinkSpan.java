package com.lsh.changeweburllib;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

/**
 * Created by hua on 2016/6/28.
 */
public class LinkSpan extends ClickableSpan {
    private String url;

    public LinkSpan(String url) {
        this.url = url;
        Log.e("tt", "url:" + url);
    }

    @Override
    public void onClick(View widget) {
        Log.e("tt", "url:" + url);
        mOnClickUrl.onClick(widget, url);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(Color.RED);
        ds.setUnderlineText(false);
    }

    public void setOnClickUrl(OnClickUrl mOnClickUrl) {
        this.mOnClickUrl = mOnClickUrl;
    }

    public OnClickUrl mOnClickUrl;

    public interface OnClickUrl {
        void onClick(View widget, String url);
    }
}
