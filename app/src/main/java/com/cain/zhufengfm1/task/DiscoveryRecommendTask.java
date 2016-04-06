package com.cain.zhufengfm1.task;

import com.cain.zhufengfm1.client.ClientAPI;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 获取发现模块中，推荐栏目的数据
 * 接口 11
 */
public class DiscoveryRecommendTask extends BaseTask{

    public DiscoveryRecommendTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... strings) {
        TaskResult ret = new TaskResult();
        String str = ClientAPI.getDiscoveryRecommends(true,true);
        if (str != null){
            try {
                ret.data= new JSONObject(str);
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
