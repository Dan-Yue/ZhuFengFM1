/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.adapter.ViewPagerAdapter;
import com.cain.zhufengfm1.fragment.discovery.DiscoveryClassificationFragment;
import com.cain.zhufengfm1.fragment.discovery.DiscoveryHostFragment;
import com.cain.zhufengfm1.fragment.discovery.DiscoveryListFragment;
import com.cain.zhufengfm1.fragment.discovery.DiscoveryRadioFragment;
import com.cain.zhufengfm1.fragment.discovery.DiscoveryRecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment{

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.fragment_discovery, container, false);
        TabLayout tabBar = (TabLayout) ret.findViewById(R.id.discovery_tab_bar);


        List<BaseFragment> fragments = new ArrayList<>();
        ViewPager pager = (ViewPager) ret.findViewById(R.id.discovery_tab_content);
        fragments.add(new DiscoveryRecommendFragment());
        fragments.add(new DiscoveryClassificationFragment());
        fragments.add(new DiscoveryRadioFragment());
        fragments.add(new DiscoveryListFragment());
        fragments.add(new DiscoveryHostFragment());
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), fragments);

        pager.setAdapter(pagerAdapter);
        tabBar.setupWithViewPager(pager);
        return ret;
    }
}