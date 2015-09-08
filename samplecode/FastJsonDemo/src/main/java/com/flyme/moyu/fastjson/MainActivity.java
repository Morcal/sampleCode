package com.flyme.moyu.fastjson;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.flyme.moyu.fastjson.bean.Books;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {


    public String url = "https://api.douban.com/v2/book/1220566";

    @Bind(R.id.iv_image)
    NetworkImageView mNetworkImageView;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_author)
    TextView mTvAuthor;
    @Bind(R.id.tv_publisher)
    TextView mTvPublisher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                dealData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        request.setTag("GsonTag");
        MyApplication.getHttpQueue().add(request);

    }

    /**
     * @param result:�����json��
     */
    private void dealData(String result) {
        //��Gson����
        //Gson gson = new Gson();
        //Books book = gson.fromJson(result, Books.class);

        //��FastJson��������һ��
        Books book = JSON.parseObject(result, Books.class);

        //��result���ص���һ����ļ��ϣ����ǾͿ�����
        List<Books> books = JSON.parseObject(result, new TypeReference<List<Books>>() {
        });

        //����json
        Books book1 = new Books();
        book1.setTitle("book1");
        Books book2 = new Books();
        book1.setTitle("book1");
        Books book3 = new Books();
        book1.setTitle("book1");

        //��book1����ת��ΪJson
        JSON.toJSON(book1);

        //��һϵ��bookת��Ϊjson
        List<Books> lists = new ArrayList<>();
        lists.add(book1);
        lists.add(book2);
        lists.add(book3);
        JSON.toJSON(lists);


        Log.i("info", book.toString());
        mTvTitle.setText(book.getTitle());
        mTvPublisher.setText(book.getPublisher());
        List list = book.getAuthor();
        String authors = "";
        for (int i = 0; i < list.size(); i++) {
            authors += list.get(i);
        }
        mTvAuthor.setText(authors);

        volley_netWorkImageView(book.getImage());

    }

    private void volley_netWorkImageView(String imageUrl) {

        ImageLoader imageLoader = new ImageLoader(MyApplication.getHttpQueue(), new BitmapCache());

        mNetworkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        mNetworkImageView.setErrorImageResId(R.mipmap.ic_launcher);
        mNetworkImageView.setImageUrl(imageUrl, imageLoader);

    }
}
