package com.cain.zhufengfm1.fragment.discovery;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.fragment.BaseFragment;
import com.cain.zhufengfm1.task.DiscoveryRecommendTask;
import com.cain.zhufengfm1.task.TaskCallback;
import com.cain.zhufengfm1.task.TaskResult;

import org.json.JSONObject;

/**
 * 发现 推荐部分
 */
public class DiscoveryRecommendFragment extends BaseFragment implements TaskCallback{
    private static final String TAG = DiscoveryRecommendFragment.class.getSimpleName();

    public DiscoveryRecommendFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DiscoveryRecommendTask task = new DiscoveryRecommendTask(this);
        task.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discovery_recommend,container,false);
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null){
            int state = result.state;

            if (state ==0){
                Object data = result.data;
                if (data != null) {
                    if(data instanceof JSONObject){
                        JSONObject jsonObject = (JSONObject) data;
                        Log.d(TAG, "onTaskFinished: "+jsonObject.toString());
                    }
                }
            }else if (state == 8) {
                Snackbar.make(getView(),"网络无响应",Snackbar.LENGTH_SHORT).show();
            }else if (state == 9) {
                Snackbar.make(getView(),"服务器数据错误",Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}


































