package com.cain.zhufengfm1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cain.zhufengfm1.media.PlayService;

public class AlbumDetailActivity extends AppCompatActivity {
    private long mAlbumId;
    private long mTrackId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);
        Intent intent = getIntent();

        //专辑ID
        mAlbumId = intent.getLongExtra(Constants.EXTRA_ALBUM_ID, -1);
        //曲目ID
        mTrackId = intent.getLongExtra(Constants.EXTRA_TRACK_ID, -1);

        //TODO:调用接口

        //TODO:调用接口 接口17 用于显示界面中的曲目列表,和一部分专辑信息

        //TODO:调用接口 接口18 用于显示专辑详情部分的用户信息，和详细信息

        //TODO:接口20，将专辑ID传递给Service，让Service开始加载新的播放列表
        if (mAlbumId != -1 && mTrackId != -1) {

            Intent service = new Intent(this, PlayService.class);
            //用于给服务传递参数
            service.putExtra(Constants.EXTRA_ALBUM_ID, mAlbumId);
            service.putExtra(Constants.EXTRA_TRACK_ID, mTrackId);

            service.putExtra(Constants.EXTRA_OPERATION,Constants.OPERATION_PLAYLIST);

            startService(service);

        }
    }
}
