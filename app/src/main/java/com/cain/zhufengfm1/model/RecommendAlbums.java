/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 小编推荐和听新闻...
 */
public class RecommendAlbums extends DiscoveryRecommendItem{
    private static final String TAG = RecommendAlbums.class.getSimpleName();
    private List<RecommendAlbumInfo> albums;

    /**
     * 用于解析小编推荐和热门推荐的内容
     * @param json
     */
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
        super.parseJson(json);
            JSONArray array = json.optJSONArray("list");
            albums = new LinkedList<>();
            int len = array.length();
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                RecommendAlbumInfo info = new RecommendAlbumInfo();
                info.parseJson(jsonObject);
                albums.add(info);
            }
            Log.d(TAG, "parseJson: 用于解析小编推荐和热门推荐的内容");
        }

    }
    public List<RecommendAlbumInfo> getAlbums() {
        Log.d(TAG, "getAlbums: albums"+albums);
        return albums;
    }
}
