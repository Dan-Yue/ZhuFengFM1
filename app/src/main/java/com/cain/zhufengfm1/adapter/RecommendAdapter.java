/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
import com.cain.zhufengfm1.model.BoutiqueMenu;
import com.cain.zhufengfm1.model.BoutiqueMenuInfo;
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
        Log.d(TAG, "getItemViewType: 执行了");
        if (item instanceof RecommendAlbums){
            ret = 1;
        }else if (item instanceof BoutiqueMenu){
            ret = 2;
        }
        return ret;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View ret = null;
        DiscoveryRecommendItem item = mItems.get(i);
        if (item instanceof RecommendAlbums){
            //小编推荐的内容
            Log.d(TAG, "getView: item instanceof RecommendAlbums = true" );
            ret = bindRecommendAlbums(i,view,viewGroup);
        }else if (item instanceof  BoutiqueMenu){
            Log.d(TAG, "getView: item instanceof  BoutiqueMenu = true" );
            ret = bindBoutiqueMenu(i, view, viewGroup);
        }
        return ret;
    }
    private View bindBoutiqueMenu(int position,View convertView,ViewGroup parent){
        if (convertView == null){
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_hasmore_vertical, parent, false);
        ViewHolder2 holder2 = new ViewHolder2();
            holder2.discovery_recommend_menu_title = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_title);

            holder2.discovery_recommend_menu_image1 = (ImageView) convertView.findViewById(R.id.discovery_recommend_menu_image1);
            holder2.discovery_recommend_menu_title1 = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_title1);
            holder2.discovery_recommend_menu_subtitle = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_subtitle);
            holder2.discovery_recommend_menu_footnote = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_footnote);

            holder2.discovery_recommend_menu_image2 = (ImageView) convertView.findViewById(R.id.discovery_recommend_menu_image2);
            holder2.discovery_recommend_menu_title2 = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_title2);
            holder2.discovery_recommend_menu_subtitle2 = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_subtitle2);
            holder2.discovery_recommend_menu_footnote2 = (TextView) convertView.findViewById(R.id.discovery_recommend_menu_footnote2);
            convertView.setTag(holder2);
        }
        ViewHolder2 holder2 = (ViewHolder2) convertView.getTag();

        Log.d(TAG, "bindBoutiqueMenu: holder2"+holder2);

        BoutiqueMenu menus = (BoutiqueMenu) mItems.get(position);

        BoutiqueMenuInfo info1 = menus.getMenu().get(0);
        BoutiqueMenuInfo info2 = menus.getMenu().get(1);

        holder2.discovery_recommend_menu_title.setText(menus.getTitle());

        holder2.discovery_recommend_menu_title1.setText(info1.getTitle());
        holder2.discovery_recommend_menu_subtitle.setText(info1.getSubtitle());
        holder2.discovery_recommend_menu_footnote.setText(info1.getFootnote());

        holder2.discovery_recommend_menu_title2.setText(info2.getTitle());
        holder2.discovery_recommend_menu_subtitle2.setText(info2.getSubtitle());
        holder2.discovery_recommend_menu_footnote2.setText(info2.getFootnote());

        Picasso.with(mContext).load(info1.getCoverPath()).into(holder2.discovery_recommend_menu_image1);
        Picasso.with(mContext).load(info2.getCoverPath()).into(holder2.discovery_recommend_menu_image2);

        return convertView;
    }
    /**
     * 小编推荐和热门推荐的内容视图
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private View bindRecommendAlbums(int position,View convertView,ViewGroup parent){

        if(convertView==null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_hasmore_horizontal, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.discovery_recommend_item_title = (TextView) convertView.findViewById(R.id.discovery_recommend_item_title);

            holder.discovery_recommend_unit_image1 = (ImageView) convertView.findViewById(R.id.discovery_recommend_unit_image1);
            holder.discovery_recommend_unit_title1 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_title1);
            holder.Discovery_recommend_unit_track_title1 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_track_title1);
            holder.musicId1 = new long[2];

            holder.discovery_recommend_unit_image2 = (ImageView) convertView.findViewById(R.id.discovery_recommend_unit_image2);
            holder.discovery_recommend_unit_title2 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_title2);
            holder.Discovery_recommend_unit_track_title2 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_track_title2);
            holder.musicId2 = new long[2];

            holder.discovery_recommend_unit_image3 = (ImageView) convertView.findViewById(R.id.discovery_recommend_unit_image3);
            holder.discovery_recommend_unit_title3 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_title3);
            holder.Discovery_recommend_unit_track_title3 = (TextView) convertView.findViewById(R.id.discovery_recommend_unit_track_title3);
            holder.musicId3 = new long[2];

            convertView.findViewById(R.id.discovery_recommend_unit1).setTag(holder);
            convertView.findViewById(R.id.discovery_recommend_unit2).setTag(holder);
            convertView.findViewById(R.id.discovery_recommend_unit3).setTag(holder);

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

        holder.Discovery_recommend_unit_track_title1.setText(info1.getTrackTitle());
        holder.Discovery_recommend_unit_track_title2.setText(info2.getTrackTitle());
        holder.Discovery_recommend_unit_track_title3.setText(info3.getTrackTitle());

        Picasso.with(mContext).load(info1.getCoverLarge()).into(holder.discovery_recommend_unit_image1);
        Picasso.with(mContext).load(info2.getCoverLarge()).into(holder.discovery_recommend_unit_image2);
        Picasso.with(mContext).load(info3.getCoverLarge()).into(holder.discovery_recommend_unit_image3);

        //绑定音乐id
        //AlbumId和TrackId的数组便于Tag传递
        long[] musicId1 = new long[2];
        musicId1[0] = info1.getAlbumId();
        musicId1[1] = info1.getTrackId();
        holder.musicId1 = musicId1;
        Log.d(TAG, "bindRecommendAlbums: holder.musicId1"+holder.musicId1);

        long[] musicId2 = new long[2];
        musicId2[0] = info2.getAlbumId();
        musicId2[1] = info2.getTrackId();
        holder.musicId2 = musicId2;
        Log.d(TAG, "bindRecommendAlbums: holder.musicId2"+holder.musicId2);

        long[] musicId3 = new long[2];
        musicId3[0] = info3.getAlbumId();
        musicId3[1] = info3.getTrackId();
        holder.musicId3 = musicId3;
        Log.d(TAG, "bindRecommendAlbums: holder.musicId3"+holder.musicId3);

        return convertView;

    }

    /**
     * 小编推荐和热门推荐的内容
     */
    public class ViewHolder{
        private TextView discovery_recommend_item_title;

        private ImageView discovery_recommend_unit_image1;
        private TextView discovery_recommend_unit_title1;
        private TextView Discovery_recommend_unit_track_title1;
        public long[] musicId1;

        private ImageView discovery_recommend_unit_image2;
        private TextView discovery_recommend_unit_title2;
        private TextView Discovery_recommend_unit_track_title2;
        public long[] musicId2;

        private ImageView discovery_recommend_unit_image3;
        private TextView discovery_recommend_unit_title3;
        private TextView Discovery_recommend_unit_track_title3;
        public long[] musicId3;
    }

    /**
     * 精品听单
     */
    public class ViewHolder2{
        private TextView discovery_recommend_menu_title;

        private ImageView discovery_recommend_menu_image1;
        private TextView discovery_recommend_menu_title1;
        private TextView discovery_recommend_menu_subtitle;
        private TextView discovery_recommend_menu_footnote;

        private ImageView discovery_recommend_menu_image2;
        private TextView discovery_recommend_menu_title2;
        private TextView discovery_recommend_menu_subtitle2;
        private TextView discovery_recommend_menu_footnote2;
    }
}
