/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
import com.cain.zhufengfm1.model.BoutiqueMenu;
import com.cain.zhufengfm1.model.DiscoveryRecommendItem;
import com.cain.zhufengfm1.model.RecommendAlbums;
import com.cain.zhufengfm1.task.DiscoveryRecommendTask;
import com.cain.zhufengfm1.task.TaskCallback;
import com.cain.zhufengfm1.task.TaskResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 发现 推荐部分
 */
public class DiscoveryRecommendFragment extends BaseFragment implements TaskCallback {
    private static final String TAG = DiscoveryRecommendFragment.class.getSimpleName();
    private RecommendAdapter mAdapter;
    private List<DiscoveryRecommendItem> mItems;

    public DiscoveryRecommendFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = new LinkedList<>();
        mAdapter = new RecommendAdapter(getContext(), mItems);

        DiscoveryRecommendTask task = new DiscoveryRecommendTask(this);
        task.execute();
        Log.d(TAG, "onCreate: DiscoveryRecommend Task 线程开启了");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_discovery_recommend, container, false);
        ListView listView = (ListView) ret.findViewById(R.id.discovery_recommend_listview);
        listView.setAdapter(mAdapter);
        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        Log.d(TAG, "onTaskFinished: result" + result);
        if (result != null) {
            int state = result.state;

            if (state == 0) {
                Object data = result.data;
                if (data != null) {
                    if (data instanceof JSONObject) {
                        JSONObject jsonObject = (JSONObject) data;
                        try {
                            //获取小编推荐
                            JSONObject object = jsonObject.getJSONObject("editorRecommendAlbums");
                            Log.d(TAG, "onTaskFinished: object " + (object != null));
                            RecommendAlbums albums = new RecommendAlbums();
                            albums.parseJson(object);
                            mItems.add(albums);
                            //热门推荐
                            JSONObject object1 = jsonObject.getJSONObject("hotRecommends");
                            JSONArray array = object1.getJSONArray("list");
                            RecommendAlbums hotalbums;
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject obj = array.getJSONObject(i);
                                hotalbums = new RecommendAlbums();
                                hotalbums.parseJson(obj);
                                mItems.add(hotalbums);
                            }

                            //精品听单
                            JSONObject object2 = jsonObject.getJSONObject("specialColumn");
                            BoutiqueMenu menus = new BoutiqueMenu();
                            menus.parseJson(object2);
                            mItems.add(menus);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                }
            } else if (state == 8) {
                Snackbar.make(getView(), "网络无响应", Snackbar.LENGTH_SHORT).show();
                Log.d(TAG, "onTaskFinished: 网络无响应");
            } else if (state == 9) {
                Snackbar.make(getView(), "服务器数据错误", Snackbar.LENGTH_SHORT).show();
                Log.d(TAG, "onTaskFinished: 服务器数据错误或JSON解析失败");
            }
        }
    }
}


































