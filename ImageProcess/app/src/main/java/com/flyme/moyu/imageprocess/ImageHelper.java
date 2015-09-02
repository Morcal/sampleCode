package com.flyme.moyu.imageprocess;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2015/9/1.
 * 图像处理工具类
 */
public class ImageHelper {
    /**
     * @param bm             :待处理图片
     * @param hue：色调
     * @param saturation：饱和度
     * @param lum            ：亮度
     * @return
     */

    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
       //传递过来的bitmap默认是不可修改的
        Bitmap bmp=Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bmp);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix=new ColorMatrix();
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMatrix=new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix=new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        //将前面设置的三个揉和起来
        ColorMatrix imageMatrix=new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bm,0,0,paint);

        return bmp;
    }
}
