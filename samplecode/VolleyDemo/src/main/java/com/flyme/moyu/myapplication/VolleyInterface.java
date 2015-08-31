package com.flyme.moyu.myapplication;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2015/8/31.
 * 建立一个抽象类来封装请求成功和失败的监听
 */
public abstract class VolleyInterface {

    public Context mContext;
    public static Response.Listener<String> mListener;
    public static Response.ErrorListener mErrorListener;

    public VolleyInterface(Context context, Response.Listener<String> Listener, Response.ErrorListener ErrorListener) {
        this.mContext = context;
        this.mListener = Listener;
        this.mErrorListener = ErrorListener;
    }

    public abstract void onMySuccess(String result);

    public abstract void onMyError(VolleyError error);

    //监听请求成功的方法
    public Response.Listener<String> loadingListener() {
        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //弹出加载
                onMySuccess(response);
            }
        };
        return mListener;
    }

    //监听请求失败的放方法
    public Response.ErrorListener errorListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
                //提示请求失败
            }
        };
        return mErrorListener;
    }
}

