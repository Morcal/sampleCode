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


    //���������ղ�������װ��Button�ؼ���ֻΪ��ʾЧ����ʵ�ʿ����в��Ƽ�ʹ��
    private LinearLayout llButtonM1;
    private LinearLayout llButtonM2;
    private LinearLayout llButtonM3;
    //��������ButtonM����
    private ButtonM[] buttonM1;
    private ButtonM[] buttonM2;
    private ButtonM[] buttonM3;
    //����������ɫֵ��������δ���µİ�ť����ɫ
    private static final String[] colorList = {"#7067E2","#FF618F","#B674D2","#00C2EB"};
    private static final String[] colorSelectedList = {"#3C3779","#88354C","#613E70","#00677D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //��ʼ���ؼ�
    private void initView() {
        //ʵ�������ֿؼ�
        llButtonM1 = (LinearLayout) findViewById(R.id.ll_button1);
        llButtonM2 = (LinearLayout) findViewById(R.id.ll_button2);
        llButtonM3 = (LinearLayout) findViewById(R.id.ll_button3);
        //ʵ�����ؼ����飬������4��
        buttonM1 = new ButtonM[4];
        buttonM2 = new ButtonM[4];
        buttonM3 = new ButtonM[4];
        //��ȡ��Ļ�Ŀ�ȣ�ÿ���ĸ�Button����϶Ϊ60��300����4Ϊÿ���ؼ��Ŀ��
        @SuppressWarnings("deprecation")
        int btnWidth = (getWindowManager().getDefaultDisplay().getWidth() - 300)/4;
        //�����һ������
        LinearLayout.LayoutParams lp1;
        for (int i = 0; i < 4; i++) {
            //ΪbuttonM1������ʽ��ֱ�Ǿ���
            buttonM1[i] = new ButtonM(this);
            //������ɫ
            buttonM1[i].setTextColori(android.graphics.Color.WHITE);
            //�����С
            buttonM1[i].setTextSize(14);
            //����ɫ
            buttonM1[i].setBackColor(Color.parseColor(colorList[i]));
            //ѡ�еı���ɫ
            buttonM1[i].setBackColorSelected(Color.parseColor(colorSelectedList[i]));
            //������ʾ
            buttonM1[i].setText("TEXT" + i);
            //�����ı�����
            buttonM1[i].setGravity(Gravity.CENTER);
            //�˴�����Id��ֵΪi������onClick��v.getId()����ԶΪ-1
            buttonM1[i].setId(i);
            //����buttonM1�Ĳ��֣��������Ӧ���߶�Ϊ��ȵ�0.6����Ȩ��Ϊ1
            //Ҳ����д��lp1 = new LinearLayout.LayoutParams(btnWidth,(int) (btnWidth * 0.6));
            lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(int) (btnWidth * 0.6), 1.0f);
            //�ؼ��������Ҳ�ؼ��ľ��룬�˴�Ϊ60
            lp1.setMargins(0,0,60,0);
            buttonM1[i].setLayoutParams(lp1);
            //����buttonM1�ĵ���¼�
            buttonM1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "��ѡ����" + v.getId() + "��", Toast.LENGTH_SHORT).show();
                }
            });
            //����PaddingLeftΪ60
            llButtonM1.setPadding(60, 0, 0, 0);
            //��buttonM1��ӵ�llButtonM1��
            llButtonM1.addView(buttonM1[i]);
        }

        //����ڶ�������
        LinearLayout.LayoutParams lp2;
        for (int i = 0; i < 4; i++) {
            //ΪbuttonM2������ʽ��Բ�Ǿ���
            buttonM2[i] = new ButtonM(this);
            buttonM2[i].setTextColori(android.graphics.Color.WHITE);
            buttonM2[i].setTextSize(14);
            //�����Ƿ�ΪԲ��
            buttonM2[i].setFillet(true);
            //����Բ�ǵİ뾶��С
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
                    Toast.makeText(MainActivity.this, "��ѡ����" + v.getId() + "��", Toast.LENGTH_SHORT).show();
                }
            });
            llButtonM2.setPadding(60, 0, 0, 0);
            llButtonM2.addView(buttonM2[i]);
        }
        //�������������
        LinearLayout.LayoutParams lp3;
        for (int i = 0; i < 4; i++) {
            //ΪbuttonM3������ʽ��Բ��
            buttonM3[i] = new ButtonM(this);
            buttonM3[i].setTextColori(android.graphics.Color.WHITE);
            buttonM3[i].setTextSize(14);
            //����ΪԲ�Σ�Ĭ��Ϊ���Σ�GradientDrawable.RECTANGLE
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
                    Toast.makeText(MainActivity.this, "��ѡ����" + v.getId() + "��", Toast.LENGTH_SHORT).show();
                }
            });
            llButtonM3.setPadding(60, 0, 0, 0);
            llButtonM3.addView(buttonM3[i]);
        }
    }

}
