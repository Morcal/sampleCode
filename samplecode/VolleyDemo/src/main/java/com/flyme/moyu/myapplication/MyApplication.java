package com.flyme.moyu.myapplication;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2015/8/31.
 * 在Application中建立全局的请求队列
 */
public class MyApplication extends Application {
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public  static  RequestQueue getHttpQueues(){
        return queue;
    }
}
