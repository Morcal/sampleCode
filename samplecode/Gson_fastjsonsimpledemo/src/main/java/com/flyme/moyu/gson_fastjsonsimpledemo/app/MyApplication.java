package com.flyme.moyu.gson_fastjsonsimpledemo.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.thinkland.sdk.android.JuheSDKInitializer;

/**
 * Created by Administrator on 2015/9/7.
 */
public class MyApplication extends Application {

    public static String JuheSdkKey = "76ab54fce14181efa6d46cb521f30b9b";
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化全局的请求队列
        queue = Volley.newRequestQueue(getApplicationContext());
        //初始化聚合数据SDK
        JuheSDKInitializer.initialize(getApplicationContext());

    }

    /**
     * Volley向外部暴露方法
     */
    public static RequestQueue getHttpQueue() {
        return queue;
    }
}
