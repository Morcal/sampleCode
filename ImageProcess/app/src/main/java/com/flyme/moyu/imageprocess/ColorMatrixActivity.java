package com.flyme.moyu.imageprocess;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2015/9/1.
 * 矩阵变换来进行图像处理
 */
public class ColorMatrixActivity extends Activity {

    @Bind(R.id.iv_color_matrix)
    ImageView mImageView;
    @Bind(R.id.gl_matrix)
    GridLayout mGridLayout;

    private Bitmap bitmap;
    private int mEtWidth, mEtHeight;
    private EditText[] editTexts = new EditText[20];
    private float[] mColorMetrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_matrix);
        Log.i("tag","加载界面");
        ButterKnife.bind(this);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);

        mImageView.setImageBitmap(bitmap);
        Log.i("tag","iv已显示");

        //此处用来获取mGridlayout的宽高
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGridLayout.getWidth() / 5;
                mEtHeight = mGridLayout.getHeight() / 4;
                addEts();
                initMatrix();
            }
        });
    }

    public void getMatrix() {
        for (int i = 0; i < 20; i++) {
            mColorMetrix[i] = Float.valueOf(editTexts[i].getText().toString());
        }
    }

    public void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMetrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        mImageView.setImageBitmap(bmp);
    }

    @OnClick(R.id.btn_change)
    public void btnChange() {
        getMatrix();//获取矩阵的值
        setImageMatrix();//设置矩阵的值
    }

    @OnClick(R.id.btn_reset)
    public void btnReset() {

        initMatrix();//初始化矩阵
        getMatrix();
        setImageMatrix();
    }


    //初始化EditView
    private void addEts() {
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(this);
            editText.setGravity(Gravity.CENTER);
            editTexts[i] = editText;
            mGridLayout.addView(editText, mEtWidth, mEtHeight);
        }
    }

    //初始化矩阵
    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                editTexts[i].setText(String.valueOf(1));
            } else {
                editTexts[i].setText(String.valueOf(0));

            }
        }
    }
}
