package com.cain.zhufengfm1.task;

import com.cain.zhufengfm1.client.ClientAPI;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 16-4-6.
 */
public class DiscoveryClassificationTask extends BaseTask{

    public DiscoveryClassificationTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... strings) {
        TaskResult ret = new TaskResult();
        String str = ClientAPI.getDiscoveryCategories();
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
