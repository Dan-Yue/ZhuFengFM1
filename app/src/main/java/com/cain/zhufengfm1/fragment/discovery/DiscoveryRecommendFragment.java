package com.cain.zhufengfm1.fragment.discovery;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.adapter.RecommendAdapter;
import com.cain.zhufengfm1.fragment.BaseFragment;
import com.cain.zhufengfm1.model.DiscoveryRecommendItem;
import com.cain.zhufengfm1.model.RecommendAlbums;
import com.cain.zhufengfm1.task.DiscoveryRecommendTask;
import com.cain.zhufengfm1.task.TaskCallback;
import com.cain.zhufengfm1.task.TaskResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 发现 推荐部分
 */
public class DiscoveryRecommendFragment extends BaseFragment implements TaskCallback{
    private static final String TAG = DiscoveryRecommendFragment.class.getSimpleName();
    private RecommendAdapter mAdapter;
    private List<DiscoveryRecommendItem> mItems;
    public DiscoveryRecommendFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = new LinkedList<>();
        mAdapter = new RecommendAdapter(getContext(),mItems);

        DiscoveryRecommendTask task = new DiscoveryRecommendTask(this);
        task.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_discovery_recommend,container,false);
        ListView listView = (ListView) ret.findViewById(R.id.discovery_recommend_listview);
        listView.setAdapter(mAdapter);

        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onTaskFinished(TaskResult result){
        if (result != null){
            int state = result.state;

            if (state ==0){
                Object data = result.data;
                if (data != null) {
                    if(data instanceof JSONObject){
                        JSONObject jsonObject = (JSONObject) data;
                        Log.d(TAG, "onTaskFinished: "+jsonObject.toString());

                        try {
                            JSONObject object = jsonObject.getJSONObject("editorRecommendAlbums");
                            RecommendAlbums albums = new RecommendAlbums();
                            albums.parseJson(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mAdapter.notifyDataSetChanged();
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


































