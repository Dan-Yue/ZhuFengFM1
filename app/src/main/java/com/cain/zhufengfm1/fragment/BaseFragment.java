/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.fragment;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Administrator on 16-4-6.
 */
public class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();

    /**
     * 要求Fragment返回自身的标题，默认情况下，标题是一样的，只有
     * 在Adapter需要获取标题时候，才调用这个方法
     * @return
     */
    public String getFragmentTitle(){
        Log.d(TAG, "getFragmentTitle: 执行了");
        return "No Title";
    }
}
