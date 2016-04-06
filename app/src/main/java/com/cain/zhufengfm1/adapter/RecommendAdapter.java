package com.cain.zhufengfm1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cain.zhufengfm1.model.DiscoveryRecommendItem;

import java.util.List;

/**
 * Created by Administrator on 16-4-6.
 */
public class RecommendAdapter extends BaseAdapter{
    private Context mContext;
    private List<DiscoveryRecommendItem> mItems;

    public RecommendAdapter(Context context, List<DiscoveryRecommendItem> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (mItems!= null){
            ret = mItems.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
