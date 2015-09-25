package com.flyme.moyu.gson_fastjsonsimpledemo.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.flyme.moyu.gson_fastjsonsimpledemo.R;
import com.flyme.moyu.gson_fastjsonsimpledemo.app.adapter.ListMovieAdapter;
import com.flyme.moyu.gson_fastjsonsimpledemo.app.bean.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {
    private String url = "http://v.juhe.cn/movie/movies.today?cityid=123&dtype=&key=" + MyApplication.JuheSdkKey;
    public ListMovieAdapter movieAdapter;

    @Bind(R.id.lv_move_info)
    ListView moiveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定注解ButterKnife
        ButterKnife.bind(this);
        getReuest();
    }

    private void getReuest() {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

//                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

                Log.i("info", "返回结果" + response);
//                getData(response);
                getDataJsonPre(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();

                Log.i("info", error.toString());
            }
        });
        request.setTag("StringRequestMovie");
        MyApplication.getHttpQueue().add(request);
    }

    /**
     * 用fastJson来解析Json
     * @param response
     */
    private void getDataJsonPre(String response) {
        ArrayList<Movie> movies = null;
        JSONObject object= null;
        try {
            object = new JSONObject(response);
            movies= (ArrayList<Movie>) JSON.parseArray(object.getString("result"),Movie.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        movieAdapter = new ListMovieAdapter(this, movies);
        moiveList.setAdapter(movieAdapter);

    }

    /**
     * 用Gson来解析Json
     * @param result
     */
    private void getData(String result) {
        ArrayList<Movie> movies = null;
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Movie>>() {
        }.getType();
        try {
            JSONObject object = new JSONObject(result);
            movies = gson.fromJson(object.getString("result"), listType);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        movieAdapter = new ListMovieAdapter(this, movies);
        moiveList.setAdapter(movieAdapter);

    }


}
