package com.cain.zhufengfm1.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 16-4-6.
 */
public class BaseFragment extends Fragment {
    /**
     * 要求Fragment返回自身的标题，默认情况下，标题是一样的，只有
     * 在Adapter需要获取标题时候，才调用这个方法
     * @return
     */
    public String getFragmentTitle(){
        return "No Title";
    }
}
