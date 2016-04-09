/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.task;

import android.util.Log;

import com.cain.zhufengfm1.client.ClientAPI;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 获取发现模块中，推荐栏目的数据
 * 接口 11
 */
public class DiscoveryRecommendTask extends BaseTask{

    private static final String TAG = DiscoveryRecommendTask.class.getSimpleName();

    public DiscoveryRecommendTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... strings) {
        TaskResult ret = new TaskResult();
        String str = ClientAPI.getDiscoveryRecommends(true,true);
        Log.d(TAG, "doInBackground: str = "+str);
        if (str != null){
            try {
                ret.data= new JSONObject(str);
                Log.d(TAG, "doInBackground:  ret.data= new JSONObject(str) 执行了");
            } catch (JSONException e) {
                e.printStackTrace();
                ret.state =9;//9代表JSON解析失败
            }
        }else {
            ret.state = 8;//8代表网络没有数据
        }
        return ret;
    }
}
