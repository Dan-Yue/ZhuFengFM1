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
