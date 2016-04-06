package com.cain.zhufengfm1.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 发现模块 推荐部分的 抽象的数据结构
 * 定义这个类，就是为让ListView能够显示不同数据格式的
 * 布局，实际的数据结构，需要继承这个类
 */
public class DiscoveryRecommendItem {
    private String title;
    private boolean hasMore;

    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            title = json.getString("title");
            hasMore = json.optBoolean("hasMore",false);
        }
    }
    public String getTitle() {
        return title;
    }

    public boolean isHasMore() {
        return hasMore;
    }
}
