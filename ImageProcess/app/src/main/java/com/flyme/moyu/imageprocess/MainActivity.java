package com.flyme.moyu.imageprocess;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_prycolor)
    public void priparyColor() {
        Intent intent = new Intent(this, PrimaryColorActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_colormatrix)
    public void colorMatrix() {
        Intent intent = new Intent(this, ColorMatrixActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_pixels)
    public void pixelsEffetc() {
        Intent intent = new Intent(this, PixelsEffetc.class);
        startActivity(intent);
    }


}
