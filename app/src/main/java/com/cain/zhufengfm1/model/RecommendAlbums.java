package com.cain.zhufengfm1.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 小编推荐和听新闻...
 */
public class RecommendAlbums extends DiscoveryRecommendItem{
    private List<RecommendAlbumInfo> albums;

    /**
     * 用于解析小编推荐和热门推荐的内容
     * @param json
     */
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
        super.parseJson(json);
            JSONArray array = json.getJSONArray("list");
            albums = new LinkedList<>();
            int len = array.length();
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                RecommendAlbumInfo info = new RecommendAlbumInfo();
                info.parseJson(jsonObject);
                albums.add(info);
            }
        }

    }
    public List<RecommendAlbumInfo> getAlbums() {
        return albums;
    }
}
