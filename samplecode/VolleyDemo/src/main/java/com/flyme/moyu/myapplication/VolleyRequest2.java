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

    //Get����
    //���ĸ�����Ϊ����ɹ���������ʧ�ܵĻص��ӿ�
    public static void RequestGet(Context mContext, String url, String tag, VolleyInterface vif) {
        //������֮ǰ��ȡ����tag��Ӧ������������ɲ���Ҫ��ϵͳ��Դ����
        MyApplication.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener());
        stringRequest.setTag(tag);
        MyApplication.getHttpQueues().add(stringRequest);
        MyApplication.getHttpQueues().start();
    }

    //Post����
    public static void RequestPost(Context mContext, String url, String tag, final Map<String, String> params, VolleyInterface vif) {

        MyApplication.getHttpQueues().cancelAll(tag);//������֮ǰ��ȡ����tag��Ӧ������������ɲ���Ҫ��ϵͳ��Դ����
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
