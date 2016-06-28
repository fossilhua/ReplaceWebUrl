package com.lsh.changeweburllib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by hua on 2016/6/27.
 */
public class LinkUtil {
    private String replaceStr = "\ue620链接";
    private Typeface fontFace;

    public LinkUtil(Context context) {
        fontFace = Typeface.createFromAsset(context.getAssets(), "iconfont/iconfont.ttf");
    }

    public String getReplaceStr() {
        return replaceStr;
    }

    public void setReplaceStr(String replaceStr) {
        this.replaceStr = replaceStr;
    }

    public void applyUrl(TextView tv, String str) {
        List<UrlSpec> mUrlSpecList = matchUrl(str);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        int totalSize = mUrlSpecList.size();
        for (int i = 0; i < totalSize; i++) {
            UrlSpec urlSpec = mUrlSpecList.get(i);
            UrlSpec oldurlSpec;
            if (i == 0) {
                stringBuilder.append(str.substring(0, urlSpec.start));
                stringBuilder.append(replaceStr);
                stringBuilder.setSpan(new LinkSpan(urlSpec.value), stringBuilder.length() - replaceStr.length(), stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                oldurlSpec = mUrlSpecList.get(i - 1);
                stringBuilder.append(str.substring(oldurlSpec.end, urlSpec.start));
                stringBuilder.append(replaceStr);
                stringBuilder.setSpan(new LinkSpan(urlSpec.value), stringBuilder.length() - replaceStr.length(), stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }


        }
        if (totalSize > 0) {
            UrlSpec urlSpec = mUrlSpecList.get(totalSize - 1);
            stringBuilder.append(str.substring(urlSpec.end));
            tv.setMovementMethod(LinkMovementMethod.getInstance());
            tv.setHighlightColor(Color.parseColor("#36969696"));
            tv.setText(stringBuilder);
        }
        tv.setTypeface(fontFace);
    }

    private List<UrlSpec> matchUrl(String str) {
        List<UrlSpec> mUrlSpecList = new ArrayList<>();
        Pattern pattern = Patterns.WEB_URL;
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String value = str.substring(start, end);
            UrlSpec urlSpec = new UrlSpec();
            urlSpec.start = start;
            urlSpec.end = end;
            urlSpec.value = value;
            mUrlSpecList.add(urlSpec);
        }
        return mUrlSpecList;
    }

    private class UrlSpec {
        int start;
        int end;
        String value;
    }

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

    }

    public void setOnClickUrl(OnClickUrl mOnClickUrl) {
        this.mOnClickUrl = mOnClickUrl;
    }

    public OnClickUrl mOnClickUrl;

    public interface OnClickUrl {
        void onClick(View widget, String url);
    }
}
