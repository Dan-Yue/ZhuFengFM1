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