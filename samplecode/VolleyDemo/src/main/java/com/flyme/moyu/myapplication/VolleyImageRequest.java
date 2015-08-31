package com.flyme.moyu.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/31.
 */
public class VolleyImageRequest extends Activity {

    String url = "";

    @Bind(R.id.iv_volley_Req)
    ImageView imageViewReq;

    @Bind(R.id.iv_network)
    NetworkImageView networkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_req);

        ButterKnife.bind(this);

        Volley_imgReq();
        //volley_imageLoder();
        //volley_netWorkImageView();
    }

    /**
     * 通过imageRequest来加载网络图片
     */
    public void Volley_imgReq() {
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageViewReq.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageViewReq.setImageResource(R.mipmap.ic_launcher);//加载默认图片
            }
        });
        MyApplication.getHttpQueues().add(imageRequest);
    }

    /**
     * 通过ImageLoader
     */
    public void volley_imageLoder() {
        ImageLoader imageLoader = new ImageLoader(MyApplication.getHttpQueues(),
                new BitmapCache());
        ImageLoader.ImageListener listener = imageLoader.getImageListener(imageViewReq,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        imageLoader.get(url, listener);
    }

    /**
     * 通过NetWorkImageView
     */
    public void volley_netWorkImageView(){


        ImageLoader imageLoader = new ImageLoader(MyApplication.getHttpQueues(),
                new BitmapCache());
        networkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
        networkImageView.setImageUrl(url,imageLoader);
    }
}
