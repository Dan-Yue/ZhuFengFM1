package com.cain.zhufengfm1;

/**
 * Created by Administrator on 16-4-5.
 */
public final class Constants {
    /**
     * 约定 startService的时候，特定的操作参数，每次startService
     * 都进行设置，服务就根据 operation 进行不同的操作，获取不同的参数
     * 和 Handler 以及 Message中 的 what 类似；
     * 代表加载接口 20
     */
    public static final String EXTRA_OPERATION = "op";
    public static final int OPERATION_PLAYLIST = 1;

    private Constants(){

    }
    public static final String SP_NAME ="app";


    public static final String SP_KEY_TUTORIAL_SHOWN = "tutorial.shown";

    public static final String EXTRA_ALBUM_ID = "albumId";

    public static final String EXTRA_TRACK_ID = "trackId";
}
