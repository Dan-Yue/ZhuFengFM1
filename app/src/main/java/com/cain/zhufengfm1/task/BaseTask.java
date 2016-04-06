package com.cain.zhufengfm1.task;

import android.os.AsyncTask;

/**
 * 公共的异步任务的定义，主要处理接口回调的操作
 */
public abstract class BaseTask extends AsyncTask<String,Integer,TaskResult>{
    private TaskCallback mCallback;
    public BaseTask(TaskCallback callback) {
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(TaskResult result) {
        if (mCallback != null){
            mCallback.onTaskFinished(result);
        }
    }
}
