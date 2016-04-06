package com.cain.zhufengfm1.fragment.discovery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.fragment.BaseFragment;

/**
 * Created by Administrator on 16-4-6.
 */
public class DiscoveryRecommendFragment extends BaseFragment{
    public DiscoveryRecommendFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discovery_recommend,container,false);
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }
}
