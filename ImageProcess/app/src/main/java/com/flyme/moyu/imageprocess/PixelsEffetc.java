package com.flyme.moyu.imageprocess;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/2.
 * ÏñËØ¾ØÕó£¬ÏñËØµã·ÖÎö
 */
public class PixelsEffetc extends Activity {

    @Bind(R.id.imageView1)
    ImageView imageView1;
    @Bind(R.id.imageView2)
    ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pixels_effetc);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);

        imageView1.setImageBitmap(bitmap);
        imageView2.setImageBitmap(ImageHelper.handleImageNegative(bitmap));

    }
}
