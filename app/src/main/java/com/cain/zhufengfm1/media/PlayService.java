/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.media;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.cain.zhufengfm1.Constants;
import com.cain.zhufengfm1.task.PlayListTask;
import com.cain.zhufengfm1.task.TaskCallback;
import com.cain.zhufengfm1.task.TaskResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class PlayService extends Service implements TaskCallback, MediaPlayer.OnPreparedListener {
    private static final String TAG = PlayService.class.getSimpleName();
    private MediaPlayer mPlayer;

    public PlayService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mPlayer = new MediaPlayer();

        mPlayer.setOnPreparedListener(this);
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result.state == 0){

            Object data = result.data;

            if (data != null){

                if (data instanceof JSONObject){
                    //简化解析，只解一个
                    JSONObject jsonObject = (JSONObject) data;

                    try {
                        JSONArray array = jsonObject.getJSONArray("data");

                        int len = array.length();

                        for (int i = 0; i < len; i++) {
                            //TODO:解析多个
                        }
                        if (len>0){
                            JSONObject playListItem = array.getJSONObject(0);
                            String playUrl32 = playListItem.getString("playUrl32");
                            playMusic(playUrl32);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 进行播放，音频
     * @param url
     */
    public void playMusic(String url){
        if (url != null){
            Log.d(TAG, "playMusic: play Url = "+ url);
            //1.在播放之前，应该停止播放中的内容，并且重置所有的MediaPlayer的状态
            if (mPlayer.isPlaying()){
                mPlayer.stop();
            }
            //清空所有的状态，成为初始状态，才可以继续设置新的地址
            mPlayer.reset();
            //2.设置MediaPlayer的数据源
            try {
                mPlayer.setDataSource(url);
                //3.设置好数据源，需要进行缓冲，预先加载网络数据
                //mPlayer.prepare();//同步代码，会阻塞线程不要再子线程使用

                mPlayer.prepareAsync();//异步代码，准备成功，将会调用OnPrepareListener的回调方法
                //4.需要注意,在onCreate中设置OnPrepareListener

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 当MediaPlayer已经准备成功，可以进行播放的时候，回调
     * @param mediaPlayer
     */
    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    public class Controller extends Binder{
        /**
         * 继续播放
         */
        public void play(){

        }
        /**
         * 暂停播放
         */
        public void pause(){

        }
        /**
         * 停止播放
         */
        public void stop(){

        }

        /**
         * 上一首
         */
        public void prev(){

        }

        /**
         * 下一首
         */
        public void next(){

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Controller();
    }

    /**
     * onStartCommand运行在主线程的，
     * 因此执行长时间的操作时，必须在子线程中完成
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent!=null){
            //TODO:处理请求
            int op = intent.getIntExtra(Constants.EXTRA_OPERATION,-1);
            switch (op){
                case Constants.OPERATION_PLAYLIST:
                    //TODO:调用接口20，并且播放第一个曲目

                    //专辑 ID
                    long aid = intent.getLongExtra(Constants.EXTRA_ALBUM_ID,-1);
                    //曲目 ID
                    long tid = intent.getLongExtra(Constants.EXTRA_TRACK_ID,-1);

                    PlayListTask task = new PlayListTask(this);
                    task.execute(Long.toString(aid),Long.toString(tid));

                    break;
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (mPlayer!=null){
            if (mPlayer.isPlaying()){
                mPlayer.stop();
            }
            mPlayer.release();
            mPlayer = null;
        }
        super.onDestroy();
    }
}
