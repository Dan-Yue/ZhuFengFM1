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
 * 单个推荐的专辑
 */
public class RecommendAlbumInfo {


    private static final String TAG = RecommendAlbumInfo.class.getSimpleName();
    /**
     * albumId : 344497
     * coverLarge : http://fdfs.xmcdn.com/group6/M02/35/45/wKgDhFTg4w_SDkc9AAT-fXngGBY184_mobile_large.jpg
     * title : 黑先生在麦田咖啡馆
     * tags : 民谣,80后,文艺
     * tracks : 117
     * playsCounts : 917714
     * isFinished : 0
     * trackId : 7898099
     * trackTitle : 几米：音乐与绘本的美好邂逅
     */

    private long albumId;
    private String coverLarge;
    private String title;
    private String tags;
    private long tracks;
    private long playsCounts;
    private int isFinished;
    private long trackId;
    private String trackTitle;

    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {

//            title.nn//post fix

            albumId = json.getLong("albumId");
            coverLarge = json.getString("coverLarge");
            title = json.getString("title");
            tags = json.getString("tags");
            tracks = json.getLong("tracks");
            playsCounts = json.getLong("playsCounts");
            isFinished = json.getInt("isFinished");
            trackId = json.getLong("trackId");
            trackTitle = json.getString("trackTitle");
            Log.d(TAG, "parseJson: albumId"+albumId+" tackTitle"+trackTitle);
        }
    }
    public long getAlbumId() {
        return albumId;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tags;
    }

    public long getTracks() {
        return tracks;
    }

    public long getPlaysCounts() {
        return playsCounts;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public long getTrackId() {
        return trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }
}
