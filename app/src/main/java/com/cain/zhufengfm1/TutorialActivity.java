package com.cain.zhufengfm1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        //TODO:更新教程页显示的设置，下一次不再显示
        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(Constants.SP_KEY_TUTORIAL_SHOWN,BuildConfig.VERSION_CODE);
        edit.apply();
    }
    public void btnGoNext(View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
