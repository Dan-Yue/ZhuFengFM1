/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cain.zhufengfm1.fragment.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 16-4-5.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        int ret=0;
        if (mFragments!=null) {
            ret =mFragments.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return  mFragments.get(position).getFragmentTitle();
    }

}
