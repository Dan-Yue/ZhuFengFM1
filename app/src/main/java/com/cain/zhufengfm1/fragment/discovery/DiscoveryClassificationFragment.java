package com.cain.zhufengfm1.fragment.discovery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.fragment.BaseFragment;
import com.cain.zhufengfm1.task.DiscoveryClassificationTask;
import com.cain.zhufengfm1.task.TaskCallback;
import com.cain.zhufengfm1.task.TaskResult;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryClassificationFragment extends BaseFragment implements TaskCallback{

    public DiscoveryClassificationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DiscoveryClassificationTask task = new DiscoveryClassificationTask(this);
        task.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discovery_classification,container,false);
    }

    @Override
    public String getFragmentTitle() {
        return "分类";
    }

    @Override
    public void onTaskFinished(TaskResult result) {

    }
}
