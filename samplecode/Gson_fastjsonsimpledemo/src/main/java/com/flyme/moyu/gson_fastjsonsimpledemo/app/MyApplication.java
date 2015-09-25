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

        //��ʼ��ȫ�ֵ��������
        queue = Volley.newRequestQueue(getApplicationContext());
        //��ʼ���ۺ�����SDK
        JuheSDKInitializer.initialize(getApplicationContext());

    }

    /**
     * Volley���ⲿ��¶����
     */
    public static RequestQueue getHttpQueue() {
        return queue;
    }
}
