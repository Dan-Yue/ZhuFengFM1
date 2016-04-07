package com.cain.zhufengfm1.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 16-4-7.
 */
public class BoutiqueMenu extends DiscoveryRecommendItem{
    private static final String TAG = BoutiqueMenu.class.getSimpleName();
    private List<BoutiqueMenuInfo> soundMenus;

    /**
     * 精品听单
     * @param json
     */
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            super.parseJson(json);
            JSONArray array = json.optJSONArray("list");
            soundMenus = new LinkedList<>();
            int len = array.length();
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                BoutiqueMenuInfo info = new BoutiqueMenuInfo();
                info.parseJson(jsonObject);
                soundMenus.add(info);
            }
            Log.d(TAG, "精品听单");
        }
    }
    public List<BoutiqueMenuInfo> getMenu() {
        Log.d(TAG, "getAlbums: albums"+soundMenus);
        return soundMenus;
    }
}
