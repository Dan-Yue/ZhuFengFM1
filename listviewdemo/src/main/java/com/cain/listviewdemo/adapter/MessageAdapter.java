package com.cain.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cain.listviewdemo.R;
import com.cain.listviewdemo.model.ChatMessage;

import java.util.List;

/**
 * Created by Administrator on 16-4-7.
 */
public class MessageAdapter extends BaseAdapter{
    private Context mContext;
    private List<ChatMessage> mChatMessages;

    public MessageAdapter(Context context, List<ChatMessage> chatMessages) {
        mContext = context;
        mChatMessages = chatMessages;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (mChatMessages != null) {
            ret = mChatMessages.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int i) {
        return mChatMessages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
    //ListView多布局展示的核心方法


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    /**
     * 根据数据结构不同，显示不同的布局，
     * 因此，需要根据布局和数据类型，返回数值
     * 数值的取值范围 0~getViewTypeCount()-1
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int ret = 0;
        ChatMessage message = mChatMessages.get(position);
        if (message.isOut()){
            ret = 1;
        }else{
            ret = 0;
        }
        return ret;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View ret = null;
        ChatMessage message = mChatMessages.get(i);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (message.isOut()){
            ret = binOutView(i,view,viewGroup);
        }else{
            ret = binInView(i,view,viewGroup);
        }
        return ret;
    }
    private View binOutView(int position,View convertView,ViewGroup parent){

        View ret = null;

        ChatMessage message = mChatMessages.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        //代表是自己发出去的
        if (convertView != null) {
            ret = convertView;
        }else {
            ret = inflater.inflate(R.layout.item_chat_out, parent, false);
        }
        //2.ViewHolder
        OutViewHolder holder = (OutViewHolder) ret.getTag();
        if (holder==null){
            holder = new OutViewHolder(ret);
            ret.setTag(holder);
        }
        TextView txtContent = (TextView) ret.findViewById(R.id.item_chat_out_content);

        txtContent.setText(message.getContent());
        return ret;
    }
    private View binInView(int position,View convertView,ViewGroup parent){
        //代表是从其他人收到的 应该使用 item_chat_in

        View ret = null;

        ChatMessage message = mChatMessages.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
            if (convertView != null) {
                ret = convertView;
            }else {
                ret = inflater.inflate(R.layout.item_chat_in, parent, false);
            }
        //2.ViewHolder
        InViewHolder holder = (InViewHolder) ret.getTag();
        if (holder==null){
            holder = new InViewHolder(ret);
            ret.setTag(holder);
        }
            TextView txtFrom = (TextView) ret.findViewById(R.id.item_chat_in_from);

            TextView txtContent = (TextView) ret.findViewById(R.id.item_chat_in_content);

            txtFrom.setText(message.getFrom());
            txtContent.setText(message.getContent());
        return ret;
    }
    private static class OutViewHolder{
        public ImageView imgIcon;
        public TextView txtContent;
        public OutViewHolder(View itemView){
            imgIcon = (ImageView) itemView.findViewById(R.id.item_chat_out_image);
            txtContent = (TextView) itemView.findViewById(R.id.item_chat_out_content);
        }
    }
    private static class InViewHolder{
        public ImageView imgIcon;
        public TextView txtFrom;
        public TextView txtContent;
        public InViewHolder(View itemView){
            imgIcon = (ImageView) itemView.findViewById(R.id.item_chat_in_image);
            txtFrom = (TextView) itemView.findViewById(R.id.item_chat_in_from);
            txtContent = (TextView) itemView.findViewById(R.id.item_chat_in_content);
        }
    }
}
