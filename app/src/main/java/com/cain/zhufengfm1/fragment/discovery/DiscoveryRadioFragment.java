package com.cain.zhufengfm1.fragment.discovery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryRadioFragment extends BaseFragment {
    public DiscoveryRadioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discovery_radio,container,false);
    }

    @Override
    public String getFragmentTitle() {
        return "广播";
    }
}
