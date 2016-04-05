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
public class DiscoveryFragment extends Fragment implements TabLayout.OnTabSelectedListener{


    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);
        //1.获取TabLayout
        TabLayout tabBar = (TabLayout) view.findViewById(R.id.discovery_tab_bar);
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

        //TODO:TabLayout 与 ViewPager 联动
//        ViewPager pager = null;
////        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener());
//        tabBar.setupWithViewPager(pager);
        return view;
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
