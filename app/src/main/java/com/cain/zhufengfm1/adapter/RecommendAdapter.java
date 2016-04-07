package com.cain.zhufengfm1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cain.zhufengfm1.R;
import com.cain.zhufengfm1.model.DiscoveryRecommendItem;
import com.cain.zhufengfm1.model.RecommendAlbumInfo;
import com.cain.zhufengfm1.model.RecommendAlbums;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 16-4-6.
 */
public class RecommendAdapter extends BaseAdapter{
    private static final String TAG = RecommendAdapter.class.getSimpleName();
    private Context mContext;
    private List<DiscoveryRecommendItem> mItems;
    //TODO:定制推荐适配器
    public RecommendAdapter(Context context, List<DiscoveryRecommendItem> items) {
        mContext = context;
        mItems = items;
        Log.d(TAG, "RecommendAdapter: 执行了");
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
        return mItems.get(i);
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

        Log.d(TAG, "getItemViewType: item instanceof RecommendAlbums"+(item instanceof RecommendAlbums));

        if (item instanceof RecommendAlbums){
            ret = 1;
        }
        //TODO:参考代码mItems.get(position).getTypeId();
        return ret;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View ret = null;
        DiscoveryRecommendItem item = mItems.get(i);
//        if (item instanceof RecommendAlbums){
            //小编推荐的内容
            Log.d(TAG, "getView: item instanceof RecommendAlbums = true" );
            ret = bindRecommendAlbums(i,view,viewGroup);
//        }
        return ret;
    }
    private View bindRecommendAlbums(int position,View convertView,ViewGroup parent){
        //!!!convertView 可以直接使用
        if(convertView==null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_hasmore_horizontal, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.discovery_recommend_item_title = (TextView) convertView.findViewById(R.id.discovery_recommend_item_title);
            holder.discovery_recommend_unit_image1 = (ImageView) convertView.findViewById(R.id.discovery_recommend_unit_image1);
            holder.discovery_recommend_unit_title1 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_title1);
            holder.discovery_recommend_unit_image2 = (ImageView) convertView.findViewById(R.id.discovery_recommend_unit_image2);
            holder.discovery_recommend_unit_title2 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_title2);
            holder.discovery_recommend_unit_image3 = (ImageView) convertView.findViewById(R.id.discovery_recommend_unit_image3);
            holder.discovery_recommend_unit_title3 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_title3);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();

        Log.d(TAG, "bindRecommendAlbums: holder"+holder);

        RecommendAlbums albums = (RecommendAlbums) mItems.get(position);
        RecommendAlbumInfo info1 = albums.getAlbums().get(0);
        RecommendAlbumInfo info2 = albums.getAlbums().get(1);
        RecommendAlbumInfo info3 = albums.getAlbums().get(2);

        holder.discovery_recommend_item_title.setText(albums.getTitle());
        holder.discovery_recommend_unit_title1.setText(info1.getTitle());
        holder.discovery_recommend_unit_title2.setText(info2.getTitle());
        holder.discovery_recommend_unit_title3.setText(info3.getTitle());

        Picasso.with(mContext).load(info1.getCoverLarge()).into(holder.discovery_recommend_unit_image1);
        Picasso.with(mContext).load(info2.getCoverLarge()).into(holder.discovery_recommend_unit_image2);
        Picasso.with(mContext).load(info3.getCoverLarge()).into(holder.discovery_recommend_unit_image3);
        return convertView;

    }
    class ViewHolder{
        TextView discovery_recommend_item_title;
        ImageView discovery_recommend_unit_image1;
        TextView discovery_recommend_unit_title1;
        ImageView discovery_recommend_unit_image2;
        TextView discovery_recommend_unit_title2;
        ImageView discovery_recommend_unit_image3;
        TextView discovery_recommend_unit_title3;
    }
}
