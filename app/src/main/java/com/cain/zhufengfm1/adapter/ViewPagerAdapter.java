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
