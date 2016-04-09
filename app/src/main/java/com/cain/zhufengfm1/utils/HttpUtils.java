/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.utils;

import android.os.Build;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * 网络请求的工具类
 * 1.final 型
 */
public final class HttpUtils {
    private static final int TIMEOUT_CONNECT = 3000;
    //数据读取的超时时间
    private static final int TIMEOUT_READ = 5000;
    public static final String USER_AGENT = "ting_4.1.7(" + Build.MODEL + "," + Build.VERSION.SDK_INT + ")";

    private  HttpUtils(){

    }
    public static byte[] doGet(String url){
        byte[] datas = null;
        if (url != null) {
            HttpURLConnection conn = null;
            InputStream is = null;
            try {
                URL urlStr = new URL(url);
                conn = (HttpURLConnection) urlStr.openConnection();

                //1.请求的方法,常见的请求方法 GET, POST, PUT, DELETE, HEAD
                conn.setRequestMethod("GET");
                //2.超时设置
                conn.setConnectTimeout(TIMEOUT_CONNECT);
                conn.setReadTimeout(TIMEOUT_READ);
                //3.网络请求的附加信息；称作HTTP头字段
                //User-Agent 也有简称为UA代表客户端的类型
                //通常电脑上的浏览器，都会发送这个字段
                //听书要求的格式:
                //ting_应用程序版本号(手机型号，手机的API级别)
                conn.setRequestProperty(
                        "User-Agent",
                        USER_AGENT);

                //3.2 请求内容压缩
                conn.setRequestProperty("Accept-Encoding","gzip");
                conn.connect();
                int code = conn.getResponseCode();

                //[200,300) 成功
                //[300,400) 大部分是重定向，304是缓存内容没有改变
                //[400,500) 客户端错误，请求失败
                //[500,600) 服务器错误

                if (code == HttpURLConnection.HTTP_OK) {
                    //关于服务器与客户端之间数据的压缩
                    //1.在请求发送HTTP头字段的时候，需要添加字段
                    //  Accept-Encoding 对应数值 "gzip"
                    //  服务器就会根据这个内容，压缩JSON数据
                    is = conn.getInputStream();
                    //检测服务器返回的数据是否经过了压缩
                    //获取内容的编码，如果是"gzip"那么就是压缩的
                    String encoding = conn.getContentEncoding();
                    if ("gzip".equals(encoding)) {
                        //GZIPInputStream用于解压缩的
                        is = new GZIPInputStream(is);
                    }
                    datas = StreamUtil.readStream(is);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtil.close(is);
            }
        }
        return datas;
    }
}






















