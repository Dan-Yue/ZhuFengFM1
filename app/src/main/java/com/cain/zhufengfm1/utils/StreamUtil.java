/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cain.zhufengfm1.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流的工具类
 */
public final class StreamUtil {
    private StreamUtil(){

    }

    /**
     * 关闭IO流
     * Closeable Java中，对于所有的IO流，都让这些流实现Closeable
     * 这个接口中只有一个方法，close()就是用于关流的
     * @param stream
     */
    public static void close(Closeable stream){
        if (stream != null){
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static byte[] readStream(InputStream is){
        byte[] stream = null;
        if (is != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            readStream(is,baos);
            stream = baos.toByteArray();
            close(baos);
        }
        return stream;
    }
    public static long readStream(InputStream is,OutputStream os){

        long size = 0;
        if (is != null && os != null) {
            byte[] b = new byte[10<<10];
            int len = 0;
            try {
                while(true){
                    len = is.read(b);
                    if (len == -1){
                        break;
                    }
                    os.write(b,0,len);
                    size += len;
                }
            } catch (IOException e) {
                size = -1;
            }
            //当请求量非常大时，网络请求次数非常多的时候
            //即使较大的数组也会频繁创建，导致内存崩溃
            b = null;
        }
        return size;
    }

}























