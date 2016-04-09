/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.task;

import com.cain.zhufengfm1.client.ClientAPI;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 16-4-8.
 */
public class PlayListTask extends BaseTask {
    public PlayListTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... strings) {
        TaskResult ret = new TaskResult();

        if (strings != null && strings.length >= 2) {
            long albumId = -1;
            long trackId = -1;
            try {
                albumId = Long.parseLong(strings[0]);
                trackId = Long.parseLong(strings[1]);
                String str = ClientAPI.getPlayList(albumId, trackId);
                if (str != null) {
                    try {
                        ret.data = new JSONObject(str);
                    } catch (JSONException e) {
                        ret.state = 9;
                    }
                }else{
                    ret.state = 8;
                }
            } catch (NumberFormatException e) {
                ret.state = 7;//参数错误
            }

        }
        return ret;
    }
}
