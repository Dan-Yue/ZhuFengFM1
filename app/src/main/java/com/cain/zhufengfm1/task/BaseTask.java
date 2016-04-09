/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.task;

import android.os.AsyncTask;
import android.util.Log;

/**
 * 公共的异步任务的定义，主要处理接口回调的操作
 */
public abstract class BaseTask extends AsyncTask<String,Integer,TaskResult>{
    private static final String TAG = BaseTask.class.getSimpleName();
    private TaskCallback mCallback;
    public BaseTask(TaskCallback callback) {
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(TaskResult result) {
        Log.d(TAG, "onPostExecute: result ="+result);
        if (mCallback != null){
            mCallback.onTaskFinished(result);
        }
    }
}
