package com.flyme.moyu.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


import com.android.volley.VolleyError;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Volley用法详解
 */

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get_str_req)
    public void getStrReq() {
        VolleyRequest.volley_GetStr();
    }

    @OnClick(R.id.btn_get_jobj_req)
    public void getJobjReq() {
        VolleyRequest.volley_GteJsonObj();
    }

    @OnClick(R.id.btn_post_str_req)
    public void postStrReq() {
        VolleyRequest.volley_PostStr();
    }

    @OnClick(R.id.btn_post_jobj_req)
    public void postJobjReq() {
        VolleyRequest.volley_PostJsonObj();
    }

    @OnClick(R.id.btn_packag_get_volley)
    public void packGetVolley() {
        String url = "";
        VolleyRequest2.RequestGet(this, url, "PackGetVolley", new VolleyInterface(this,
                VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                //请求成功时
            }

            @Override
            public void onMyError(VolleyError error) {
                //请求失败时
            }
        });
    }

    @OnClick(R.id.btn_pack_post_volley)
    public void packPostVolley() {
        String url = "";
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "qdh");
        map.put("age", "23");
        VolleyRequest2.RequestPost(this, url, "PackPostVolley", map, new VolleyInterface(this,
                VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {

            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
    }


}
