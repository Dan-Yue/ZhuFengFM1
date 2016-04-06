package com.cain.zhufengfm1.client;

import com.cain.zhufengfm1.utils.HttpUtils;

import java.io.UnsupportedEncodingException;

/**
 * 工具类
 * 内部就是所有需要调用的接口网络请求
 * 每一个接口，实现一个方法
 * 便于统一管理 网址，参数和内容
 * 对于异步任务而言，只要调用方法就好了
 * 不需要考虑网址的问题
 */
public class ClientAPI {
    //通常 软件上线之前，都是使用测试服务器的，
    //上线的时候就需要使用正式服务器
    public static final String API_POINT = "http://mobile.ximalaya.com/mobile";
    private ClientAPI(){}

    /**
     * 获取发现部分的分类
     * 接口 12
     * @return
     */
    public static String getDiscoveryCategories(){
        //1.拼网址
        String ret = null;
        StringBuffer sb = new StringBuffer(API_POINT);
        sb.append("/discovery/v1/categories");
        sb.append("?device=android");
        sb.append("&picVersion=10");
        sb.append("&scale=2");
        String url = sb.toString();
        //2.请求
        byte[] data = HttpUtils.doGet(url);
        //3.返回结果
        if (data != null) {
            try {
                ret = new String(data,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
    /**
     * 获取发现部分的推荐内容
     * 对应接口：11
     * @return
     */
    public static String getDiscoveryRecommends(boolean includeActivity,boolean includeSpecial){
        String ret = null;
        //1.拼网址
        StringBuffer sb = new StringBuffer(API_POINT);
        sb.append("/discovery/v1/recommends");
        sb.append("?channel=and-f6");
        sb.append("&device=android");
        sb.append("&includeActivity=").append(includeActivity);
        sb.append("&includeSpecial=").append(includeSpecial);
        sb.append("&scale=2");
        sb.append("&version=4.1.7.1");
        String url = sb.toString();
        //2.请求
        byte[] data = HttpUtils.doGet(url);
        //3.返回结果
        if (data != null) {
            try {
                ret = new String(data,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}





















