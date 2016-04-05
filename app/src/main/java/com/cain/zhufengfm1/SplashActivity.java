package com.cain.zhufengfm1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //TODO:检查是否显示教程页

        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
//        boolean shown = sp.getBoolean("tutorial.shown",false);
        //获取上一次显示教程的版本号
        int vc = sp.getInt(Constants.SP_KEY_TUTORIAL_SHOWN, 0);

        //如果和当前程序版本号不一致

        if (vc != BuildConfig.VERSION_CODE) {
            startActivity(new Intent(this, TutorialActivity.class));
        } else {

            startActivity(new Intent(this, MainActivity.class));
        }
        finish();
    }
}































