package com.cain.zhufengfm1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.cain.zhufengfm1.fragment.CustomFragment;
import com.cain.zhufengfm1.fragment.DiscoveryFragment;
import com.cain.zhufengfm1.fragment.DownloadTingFragment;
import com.cain.zhufengfm1.fragment.PersonalFragment;

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
                fragment=mFragments[0];
                break;
            case R.id.main_tab_item_custom:
                fragment=mFragments[1];
                break;
            case R.id.main_tab_item_download:
                fragment=mFragments[2];
                break;
            case R.id.main_tab_item_personal:
                fragment=mFragments[3];
                break;
        }
        if (fragment!=null) {
            transaction.show(fragment);
            transaction.commit();
        }
    }
}































