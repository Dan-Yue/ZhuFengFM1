package com.cain.zhufengfm1.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cain.zhufengfm1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment implements TabLayout.OnTabSelectedListener {


    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_discovery, container, false);
        TabLayout tabBar = (TabLayout) ret.findViewById(R.id.discovery_tab_bar);
        //必须设置监听 否则出错
        tabBar.setOnTabSelectedListener(this);

        TabLayout.Tab tab = tabBar.newTab();
        tab.setText("推荐");
        tabBar.addTab(tab);

        tab = tabBar.newTab();
        tab.setText("分类");
        tabBar.addTab(tab);

        tab = tabBar.newTab();
        tab.setText("广播");
        tabBar.addTab(tab);

        tab = tabBar.newTab();
        tab.setText("榜单");
        tabBar.addTab(tab);

        tab = tabBar.newTab();
        tab.setText("主播");
        tabBar.addTab(tab);

//        //TODO:TabLayout 与ViewPager联动
//        ViewPager pager = null;
//        tabBar.setupWithViewPager(pager);
        return ret;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}