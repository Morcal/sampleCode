package com.flyme.moyu.imageprocess;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2015/9/1.
 * ͼ��������
 */
public class ImageHelper {
    /**
     * @param bm             :������ͼƬ
     * @param hue��ɫ��
     * @param saturation�����Ͷ�
     * @param lum            ������
     * @return
     */

    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
        //���ݹ�����bitmapĬ���ǲ����޸ĵ�
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        //��ǰ�����õ������������
        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bm, 0, 0, paint);

        return bmp;
    }

    //���ص���
    public static Bitmap handleImageNegative(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r, g, b, a;
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        //�������ص����鵽ͼ��
        int[] oldPx = new int[width * height];

        int[] newPx = new int[width * height];//��������任������ص�
        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i = 0; i < width * height; i++) {
            //ȡ��ĳһ���ص��RGBA
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            //�㷨����
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (r < 0) {
                b = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (r < 0) {
                g = 0;
            }

            newPx[i] = Color.argb(a, r, g, b);//�������㷨�任��argb���ºϳ�

        }
        bmp.setPixels(newPx, 0, width, 0, 0, width, height);
        return bmp;
    }
}
