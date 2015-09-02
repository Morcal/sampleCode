package com.flyme.moyu.imageprocess;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/1.
 * 通过调节SeekBard的进度来设置图片的色相、饱和度、亮度
 */
public class PrimaryColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    @Bind(R.id.iv_show)
    ImageView showImageView;
    @Bind(R.id.seekbarHue)
    SeekBar hueSeekBar;
    @Bind(R.id.seekbarstu)
    SeekBar stuSeekBar;
    @Bind(R.id.seekbarlun)
    SeekBar lunSeekBar;
    public static int MAX_VALUE = 255;
    public static int MID_VALUE = 127;
    public float mHun, mStaurtion, mLum;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_color);
        ButterKnife.bind(this);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        hueSeekBar.setOnSeekBarChangeListener(this);
        stuSeekBar.setOnSeekBarChangeListener(this);
        lunSeekBar.setOnSeekBarChangeListener(this);


        hueSeekBar.setMax(MAX_VALUE);
        stuSeekBar.setMax(MAX_VALUE);
        lunSeekBar.setMax(MAX_VALUE);

        hueSeekBar.setProgress(MID_VALUE);
        stuSeekBar.setProgress(MID_VALUE);
        lunSeekBar.setProgress(MID_VALUE);

        showImageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.seekbarHue:
                mHun = (i - MID_VALUE) * 1.0f / MID_VALUE * 180;
                break;
            case R.id.seekbarstu:
                mStaurtion = i * 1.0f / MID_VALUE;
                break;
            case R.id.seekbarlun:
                mLum = i * 1.0f / MID_VALUE;
                break;
        }

        showImageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap,mHun,mStaurtion,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
