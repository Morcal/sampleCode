package com.flyme.moyu.myapplication;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/31.
 */
public class VolleyRequest2 {

    public static StringRequest stringRequest;
    public static Context context;

    //Get请求
    //第四个参数为请求成功或者请求失败的回调接口
    public static void RequestGet(Context mContext, String url, String tag, VolleyInterface vif) {
        //在请求之前先取消该tag对应的请求，已免造成不必要的系统资源消耗
        MyApplication.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener());
        stringRequest.setTag(tag);
        MyApplication.getHttpQueues().add(stringRequest);
        MyApplication.getHttpQueues().start();
    }

    //Post请求
    public static void RequestPost(Context mContext, String url, String tag, final Map<String, String> params, VolleyInterface vif) {

        MyApplication.getHttpQueues().cancelAll(tag);//在请求之前先取消该tag对应的请求，已免造成不必要的系统资源消耗
        stringRequest = new StringRequest(Request.Method.POST, url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getHttpQueues().add(stringRequest);
        MyApplication.getHttpQueues().start();
    }

}
