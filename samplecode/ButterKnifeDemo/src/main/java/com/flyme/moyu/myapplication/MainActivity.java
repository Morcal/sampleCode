package com.flyme.moyu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

    /*
    * 在Activity中是使用ButterKnife
    */
public class MainActivity extends Activity {

    //绑定View控件
    @Bind(R.id.iv_showAmi)
    ImageView showAmiIv;

//    @Bind(R.id.tv_click_skip)
//    TextView clickSkipTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //设置点击事件
    @OnClick(R.id.tv_click_ami)
    public void ivSHowAmi(TextView textView) {
        showAmiIv.animate().scaleXBy(0.5f).scaleYBy(0.5f).alpha(0.3f).setDuration(2000).start();
        textView.setText("缩放成功");
    }

    @OnClick(R.id.tv_click_skip)
    public void skipSecondPager() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        com.orhanobut.logger.Logger.d("skip",MainActivity.this);
    }

}
