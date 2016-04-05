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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomFragment extends Fragment{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    public CustomFragment(){
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, container, false);
        //1.获取TabLayout
        mTabLayout = (TabLayout) view.findViewById(R.id.custom_tab_bar);
        mViewPager = (ViewPager) view.findViewById(R.id.custom_tab_content);
        mInflater = LayoutInflater.from(getActivity());
        //TODO:TabLayout 与 ViewPager 联动

        view1 = mInflater.inflate(R.layout.activity_test, null);
        view2 = mInflater.inflate(R.layout.activity_test, null);
        view3 = mInflater.inflate(R.layout.activity_test, null);


        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //添加页卡标题
        mTitleList.add("推荐");
        mTitleList.add("订阅");
        mTitleList.add("历史");


        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        ViewPagerAdapter mAdapter = new ViewPagerAdapter(mViewList,mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
        return view;
    }
}
