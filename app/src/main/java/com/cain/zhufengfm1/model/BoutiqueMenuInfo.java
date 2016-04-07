package com.cain.zhufengfm1.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 16-4-7.
 */
public class BoutiqueMenuInfo {
    private static final String TAG = BoutiqueMenuInfo.class.getSimpleName();
    /**
     * columnType : 1
     * specialId : 562
     * title : 童声合唱！听，这里有天籁
     * subtitle : 撸到<放牛班的春天>主题曲，瞬间切入单曲循环模式
     * footnote : 7首声音
     * coverPath : http://fdfs.xmcdn.com/group9/M00/36/21/wKgDYlb-PkfQyclOAAWuLgju_As847_mobile_small.jpg
     * contentType : 2
     */

    public int columnType;
    public long specialId;
    public String title;
    public String subtitle;
    public String footnote;
    public String coverPath;
    public int contentType;
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            columnType = json.getInt("columnType");
            specialId = json.getLong("specialId");
            title = json.getString("title");
            subtitle = json.getString("subtitle");
            footnote = json.getString("footnote");
            coverPath = json.getString("coverPath");
            contentType = json.getInt("contentType");
            Log.d(TAG, "parseJson: column ="+columnType+" title = "+title);
        }
    }

    public int getColumnType() {
        return columnType;
    }

    public long getSpecialId() {
        return specialId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getFootnote() {
        return footnote;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public int getContentType() {
        return contentType;
    }
}
