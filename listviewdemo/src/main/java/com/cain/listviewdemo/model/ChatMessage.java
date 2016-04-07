package com.cain.listviewdemo.model;

/**
 * Created by Administrator on 16-4-7.
 */
public class ChatMessage {
    private String from;
    private String content;
    private long time;
    //是否是发出的
    private boolean isOut;

    public ChatMessage(String from, String content) {
        this.from = from;
        this.content = content;
        time = System.currentTimeMillis();
        //默认代表收的
        isOut = false;
    }

    public void setIsOut(boolean isOut) {
        this.isOut = isOut;
    }

    public boolean isOut() {
        return isOut;
    }

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public long getTime() {
        return time;
    }
}
