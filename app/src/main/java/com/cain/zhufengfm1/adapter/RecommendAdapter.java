package com.cain.zhufengfm1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cain.zhufengfm1.model.DiscoveryRecommendItem;
import com.cain.zhufengfm1.model.RecommendAlbums;

import java.util.List;

/**
 * Created by Administrator on 16-4-6.
 */
public class RecommendAdapter extends BaseAdapter{
    private Context mContext;
    private List<DiscoveryRecommendItem> mItems;
    //TODO:定制推荐适配器
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
    public int getViewTypeCount() {
        //返回支持的布局类型的最大数量
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        //当Item需要创建或者需要复用的时候，ListView自动
        //调用这个方法，来检查，缓冲区中是否有相同类型的View
        //如果有 才能够复用，如果没有，那么创建新的布局
        //返回的数值 应该是0到getViewTypeCount()-1
        //因为内部采用类型数值作为缓存区的数组下标
        int ret = 0;
        DiscoveryRecommendItem item = mItems.get(position);
        if (item instanceof RecommendAlbums){
            ret = 1;
        }
        return ret;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View ret = null;



        DiscoveryRecommendItem item = mItems.get(i);
        if (item instanceof RecommendAlbums){
            //小编推荐的内容
            ret = bindRecommendAlbums(i,view,viewGroup);
        }
        return ret;
    }
    private View bindRecommendAlbums(int position,View convertView,ViewGroup parent){
        //!!!convertView 可以直接使用
        return null;

    }
}
