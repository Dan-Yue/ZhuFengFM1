/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 发现模块 推荐部分的 抽象的数据结构
 * 定义这个类，就是为让ListView能够显示不同数据格式的
 * 布局，实际的数据结构，需要继承这个类
 */
public class DiscoveryRecommendItem {
    private static final String TAG = DiscoveryRecommendItem.class.getSimpleName();
    private String title;
    private boolean hasMore;

    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            title = json.getString("title");
            hasMore = json.optBoolean("hasMore", false);
        Log.d(TAG, "parseJson: json ="+json);
        }
    }
    public String getTitle() {
        return title;
    }

    public boolean isHasMore() {
        return hasMore;
    }
}
