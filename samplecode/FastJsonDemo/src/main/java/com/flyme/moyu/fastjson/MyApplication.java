package com.flyme.moyu.fastjson;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2015/9/6.
 */
public class MyApplication extends Application {

    public static RequestQueue queue;

    @Override
    public void onCreate() {

        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());

    }
    public static RequestQueue getHttpQueue(){
        return queue;
    }
}
