/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.cain.zhufengfm1.adapter.RecommendAdapter;
import com.cain.zhufengfm1.fragment.CustomFragment;
import com.cain.zhufengfm1.fragment.DiscoveryFragment;
import com.cain.zhufengfm1.fragment.DownloadTingFragment;
import com.cain.zhufengfm1.fragment.PersonalFragment;
import com.cain.zhufengfm1.media.PlayService;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DiscoveryFragment mDiscoveryFragment;
    private CustomFragment mCustomFragment;
    private DownloadTingFragment mDownloadTingFragment;
    private PersonalFragment mPersonalFragment;

    private Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 启动音乐播放后台的服务
        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
        //-------------------------------------

        ImageButton btn = (ImageButton) findViewById(R.id.main_tab_item_btn);

        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AlbumDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_ALBUM_ID, 344497L);
                    intent.putExtra(Constants.EXTRA_TRACK_ID, 7898099L);
                    startActivity(intent);
                }
            });
        }
        //-------------------------------------

        //采用Fragment显示和隐藏的方式，来管理第一级Fragment
        //默认添加到容器中，之后，切换RadioButton，进行显示和隐藏
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        mDiscoveryFragment = new DiscoveryFragment();
        mCustomFragment = new CustomFragment();
        mDownloadTingFragment = new DownloadTingFragment();
        mPersonalFragment = new PersonalFragment();

        mFragments = new Fragment[4];
        mFragments[0] = mDiscoveryFragment;
        mFragments[1] = mCustomFragment;
        mFragments[2] = mDownloadTingFragment;
        mFragments[3] = mPersonalFragment;
        for (Fragment fragment : mFragments) {
            transaction.add(R.id.main_fragment_container, fragment);
            transaction.hide(fragment);
        }
        transaction.show(mFragments[0]);
        transaction.commit();

        RadioGroup tabBar = (RadioGroup) findViewById(R.id.main_tab_bar);
        if (tabBar != null) {
            tabBar.setOnCheckedChangeListener(this);
        }
    }

    private AlertDialog mExitDialog;

    @Override
    public void onBackPressed() {
        if (mExitDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("温馨提示").setMessage("确认退出珠峰FM吗?");
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Intent intent = new Intent(MainActivity.this, PlayService.class);
                    stopService(intent);
                    finish();
                }
            });
            builder.setNeutralButton("最小化", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    finish();
                }
            });
            mExitDialog = builder.create();
        }
        mExitDialog.show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        //第一步隐藏所有的Fragment
        for (Fragment fragment : mFragments) {
            transaction.hide(fragment);
        }
        //第二部，显示切换的Fragment
        Fragment fragment = null;
        switch (i) {
            case R.id.main_tab_item_discovery:
                fragment = mFragments[0];
                break;
            case R.id.main_tab_item_custom:
                fragment = mFragments[1];
                break;
            case R.id.main_tab_item_download:
                fragment = mFragments[2];
                break;
            case R.id.main_tab_item_personal:
                fragment = mFragments[3];
                break;
        }
        if (fragment != null) {
            transaction.show(fragment);
        }
        transaction.commit();
    }
    public void playMusic(View view) {
        RecommendAdapter.ViewHolder holder = (RecommendAdapter.ViewHolder) view.getTag();
        long[] musicId = new long[2];
        switch (view.getId()) {
            case R.id.discovery_recommend_unit1:
                Log.d(TAG, "playMusic: holder.musicId" + holder.musicId1);
                musicId = holder.musicId1;
                break;
            case R.id.discovery_recommend_unit2:
                Log.d(TAG, "playMusic: holder.musicId"+holder.musicId2);
                musicId = holder.musicId2;
                break;
            case R.id.discovery_recommend_unit3:
                Log.d(TAG, "playMusic: holder.musicId"+holder.musicId3);
                musicId = holder.musicId3;
                break;
        }
        Log.d(TAG, "playMusic: 执行了");
        Intent intent = new Intent(MainActivity.this, AlbumDetailActivity.class);
        intent.putExtra(Constants.EXTRA_ALBUM_ID, musicId[0]);
        intent.putExtra(Constants.EXTRA_TRACK_ID, musicId[1]);
        startActivity(intent);
    }
}































