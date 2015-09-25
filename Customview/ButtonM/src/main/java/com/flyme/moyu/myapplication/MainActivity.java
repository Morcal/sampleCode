package com.flyme.moyu.myapplication;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    //定义三个空布局用来装载Button控件，只为演示效果，实际开发中不推荐使用
    private LinearLayout llButtonM1;
    private LinearLayout llButtonM2;
    private LinearLayout llButtonM3;
    //定义三个ButtonM数组
    private ButtonM[] buttonM1;
    private ButtonM[] buttonM2;
    private ButtonM[] buttonM3;
    //定义两组颜色值，按下与未按下的按钮背景色
    private static final String[] colorList = {"#7067E2","#FF618F","#B674D2","#00C2EB"};
    private static final String[] colorSelectedList = {"#3C3779","#88354C","#613E70","#00677D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化控件
    private void initView() {
        //实例化布局控件
        llButtonM1 = (LinearLayout) findViewById(R.id.ll_button1);
        llButtonM2 = (LinearLayout) findViewById(R.id.ll_button2);
        llButtonM3 = (LinearLayout) findViewById(R.id.ll_button3);
        //实例化控件数组，各定义4个
        buttonM1 = new ButtonM[4];
        buttonM2 = new ButtonM[4];
        buttonM3 = new ButtonM[4];
        //获取屏幕的宽度，每行四个Button，间隙为60共300，除4为每个控件的宽度
        @SuppressWarnings("deprecation")
        int btnWidth = (getWindowManager().getDefaultDisplay().getWidth() - 300)/4;
        //定义第一个布局
        LinearLayout.LayoutParams lp1;
        for (int i = 0; i < 4; i++) {
            //为buttonM1设置样式，直角矩形
            buttonM1[i] = new ButtonM(this);
            //字体颜色
            buttonM1[i].setTextColori(android.graphics.Color.WHITE);
            //字体大小
            buttonM1[i].setTextSize(14);
            //背景色
            buttonM1[i].setBackColor(Color.parseColor(colorList[i]));
            //选中的背景色
            buttonM1[i].setBackColorSelected(Color.parseColor(colorSelectedList[i]));
            //文字提示
            buttonM1[i].setText("TEXT" + i);
            //设置文本居中
            buttonM1[i].setGravity(Gravity.CENTER);
            //此处设置Id的值为i，否则onClick中v.getId()将永远为-1
            buttonM1[i].setId(i);
            //定义buttonM1的布局，宽度自适应，高度为宽度的0.6倍，权重为1
            //也可以写成lp1 = new LinearLayout.LayoutParams(btnWidth,(int) (btnWidth * 0.6));
            lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(int) (btnWidth * 0.6), 1.0f);
            //控件距离其右侧控件的距离，此处为60
            lp1.setMargins(0,0,60,0);
            buttonM1[i].setLayoutParams(lp1);
            //设置buttonM1的点击事件
            buttonM1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "您选择了" + v.getId() + "个", Toast.LENGTH_SHORT).show();
                }
            });
            //设置PaddingLeft为60
            llButtonM1.setPadding(60, 0, 0, 0);
            //将buttonM1添加到llButtonM1中
            llButtonM1.addView(buttonM1[i]);
        }

        //定义第二个布局
        LinearLayout.LayoutParams lp2;
        for (int i = 0; i < 4; i++) {
            //为buttonM2设置样式，圆角矩形
            buttonM2[i] = new ButtonM(this);
            buttonM2[i].setTextColori(android.graphics.Color.WHITE);
            buttonM2[i].setTextSize(14);
            //设置是否为圆角
            buttonM2[i].setFillet(true);
            //设置圆角的半径大小
            buttonM2[i].setRadius(18);
            buttonM2[i].setBackColor(Color.parseColor(colorList[i]));
            buttonM2[i].setBackColorSelected(Color.parseColor(colorSelectedList[i]));
            buttonM2[i].setText("TEXT" + i);
            buttonM2[i].setGravity(Gravity.CENTER);
            buttonM2[i].setId(i);
            lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(int) (btnWidth * 0.6), 1.0f);
            lp2.setMargins(0,0,60,0);
            buttonM2[i].setLayoutParams(lp2);
            buttonM2[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "您选项了" + v.getId() + "个", Toast.LENGTH_SHORT).show();
                }
            });
            llButtonM2.setPadding(60, 0, 0, 0);
            llButtonM2.addView(buttonM2[i]);
        }
        //定义第三个布局
        LinearLayout.LayoutParams lp3;
        for (int i = 0; i < 4; i++) {
            //为buttonM3设置样式，圆形
            buttonM3[i] = new ButtonM(this);
            buttonM3[i].setTextColori(android.graphics.Color.WHITE);
            buttonM3[i].setTextSize(14);
            //设置为圆形，默认为矩形，GradientDrawable.RECTANGLE
            buttonM3[i].setShape(GradientDrawable.OVAL);
            buttonM3[i].setFillet(true);
            buttonM3[i].setBackColor(Color.parseColor(colorList[i]));
            buttonM3[i].setBackColorSelected(Color.parseColor(colorSelectedList[i]));
            buttonM3[i].setText("TEXT" + i);
            buttonM3[i].setGravity(Gravity.CENTER);
            buttonM3[i].setId(i);
            lp3 = new LinearLayout.LayoutParams(btnWidth,btnWidth);
            lp3.setMargins(0,0,60,0);
            buttonM3[i].setLayoutParams(lp3);
            buttonM3[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "您选项了" + v.getId() + "个", Toast.LENGTH_SHORT).show();
                }
            });
            llButtonM3.setPadding(60, 0, 0, 0);
            llButtonM3.addView(buttonM3[i]);
        }
    }

}
