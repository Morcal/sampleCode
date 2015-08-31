package com.flyme.moyu.myapplication;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2015/8/31.
 * ����һ������������װ����ɹ���ʧ�ܵļ���
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

    //��������ɹ��ķ���
    public Response.Listener<String> loadingListener() {
        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //��������
                onMySuccess(response);
            }
        };
        return mListener;
    }

    //��������ʧ�ܵķŷ���
    public Response.ErrorListener errorListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
                //��ʾ����ʧ��
            }
        };
        return mErrorListener;
    }
}

