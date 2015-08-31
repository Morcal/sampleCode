package com.flyme.moyu.myapplication;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/31.
 * Volley���ʹ��
 */
public class VolleyRequest {

    /**
     * Volley_Get
     * StringRequest
     */
    public static void volley_GetStr() {
        String url = "";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //�ɹ�ʱ����

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //����ʧ��ʱ����

            }
        });
        request.setTag("VolleyGetString");//����Tag���ڲ���
        MyApplication.getHttpQueues().add(request);//��������ӵ�ȫ�ֶ���
    }

    /**
     * Volley_Get
     * JsonObjectRequest
     */
    public static void volley_GteJsonObj() {
        String url = "";
        JsonObjectRequest objRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        objRequest.setTag("VolleyGetJsonObjReq");
        MyApplication.getHttpQueues().add(objRequest);
    }

    /**
     * Volley_post
     * StringRequest
     */
    public static void volley_PostStr() {
        String url = "";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            //����ʱЯ��idea����
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", "qdh");
                map.put("age", "23");
                return map;
            }
        };
        request.setTag("VolleyPostStrReq");
        MyApplication.getHttpQueues().add(request);

    }

    /**
     * Volley_post
     * JsonObjectRequest
     */

    public static void volley_PostJsonObj() {
        String url = "";
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "qdh");
        map.put("age", "23");
        JSONObject requestBody = new JSONObject(map);
        //���췽���е���������requestBodyΪ����ʱЯ���Ĳ���
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        jsonObjReq.setTag("VolleyPostJsonObjectReq");
        MyApplication.getHttpQueues().add(jsonObjReq);
    }
}
