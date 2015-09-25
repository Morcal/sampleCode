package com.flyme.moyu.gson_fastjsonsimpledemo.app.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2015/9/1.
 */
public class BitmapCache implements ImageLoader.ImageCache {

    public BitmapCache() {
        cache = new LruCache<String, Bitmap>(max) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };

    }

    public LruCache<String, Bitmap> cache;
    public int max = 10 * 1024 * 1024;//定义最大缓存量为10M

    @Override
    public Bitmap getBitmap(String url) {

        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }
}
