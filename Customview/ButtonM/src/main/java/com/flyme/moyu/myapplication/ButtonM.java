package com.flyme.moyu.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/9/25.
 * �Զ���Button��ʽ
 */
public class ButtonM extends Button {

    private GradientDrawable gradientDrawable;//�ؼ�����ʽ
    private String backColors = "";//����ɫ��String����
    private int backColori = 0;//����ɫ��int����
    private String backColorSelecteds = "";//���º�ı���ɫ��String����
    private int backColorSelectedi = 0;//���º�ı���ɫ��int����
    private int backGroundImage = 0;//����ͼ��ֻ�ṩid
    private int backGroundImageSelected = 0;//���º�ı���ͼ��ֻ�ṩid
    private int textColori = 0;//���ֵ���ɫ��int����
    private String textColors = "";//������ɫ��String����
    private int textColorSelectedi = 0;//���º��������ɫ��//int����
    private String textColorSelecteds = "";//���º��������ɫ��String����
    private float radius = 8;//Բ�ǰ뾶
    private int shape = 0;//Բ����ʽ�����Ρ�Բ�εȣ�Ĭ��0Ϊ����
    private Boolean fillet = false;//�Ƿ�����Բ��

    public ButtonM(Context context) {
        this(context, null);
    }

    public ButtonM(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtonM(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        //��ButtonĬ�ϵı���ɫ��Ϊ͸��
        if (fillet) {
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setColor(Color.TRANSPARENT);
        } else {
            setBackgroundColor(Color.TRANSPARENT);
        }
        //��������Ĭ�Ͼ���
        setGravity(Gravity.CENTER);
        //����Touch�¼�
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //���¸ı���ʽ
                setColor(motionEvent.getAction());
                //�˴�����Ϊfalse,��ֹclick�¼�������
                return false;
            }
        });

    }

    //�ñ���ʽ
    private void setColor(int state) {
        if (state == MotionEvent.ACTION_DOWN) {
            //����
            if (backColorSelectedi != 0) {
                //���ж��Ƿ������˰��µı���ɫint��
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColorSelectedi);
                } else {
                    setBackgroundColor(backColorSelectedi);
                }
            } else if (!backColorSelecteds.equals("")) {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.parseColor(backColorSelecteds));
                } else {
                    setBackgroundColor(Color.parseColor(backColorSelecteds));
                }
            }
            //�ж��Ƿ������˰��º����ֵ���ɫ
            if (textColorSelectedi != 0) {
                setTextColor(textColorSelectedi);
            } else if (!textColorSelecteds.equals("")) {
                setTextColor(Color.parseColor(textColorSelecteds));
            }
            //�ж��Ƿ������˰��º�ı���ͼ
            if (backGroundImageSelected != 0) {
                setBackgroundResource(backGroundImageSelected);
            }
        }
        if (state == MotionEvent.ACTION_UP) {
            //̧��
            if (backColori == 0 && backColors.equals("")) {
                //���û�����ñ���ɫ��Ĭ�ϸ�Ϊ͸��
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.TRANSPARENT);
                } else {
                    setBackgroundColor(Color.TRANSPARENT);
                }
            } else if (backColori != 0) {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColori);
                } else {
                    setBackgroundColor(backColori);
                }
            } else {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.parseColor(backColors));
                } else {
                    setBackgroundColor(Color.parseColor(backColors));
                }
            }
            //���Ϊ����������ɫ��Ĭ��Ϊ��ɫ
            if (textColori == 0 && textColors.equals("")) {
                setTextColor(Color.BLACK);
            } else if (textColori != 0) {
                setTextColor(textColori);
            } else {
                setTextColor(Color.parseColor(textColors));
            }
            if (backGroundImage != 0) {
                setBackgroundResource(backGroundImage);
            }
        }
    }

    /**
     * ���ð�ť�ı���ɫ,���δ������Ĭ��Ϊ͸��
     *
     * @param backColor
     */
    public void setBackColor(String backColor) {
        this.backColors = backColor;
        if (backColor.equals("")) {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.TRANSPARENT);
            } else {
                setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.parseColor(backColor));
            } else {
                setBackgroundColor(Color.parseColor(backColor));
            }
        }
    }

    /**
     * ���ð�ť�ı���ɫ,���δ������Ĭ��Ϊ͸��
     *
     * @param backColor
     */
    public void setBackColor(int backColor) {
        this.backColori = backColor;
        if (backColori == 0) {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.TRANSPARENT);
            } else {
                setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(backColor);
            } else {
                setBackgroundColor(backColor);
            }
        }
    }

    /**
     * ���ð�ť���º����ɫ
     *
     * @param backColorSelected
     */
    public void setBackColorSelected(int backColorSelected) {
        this.backColorSelectedi = backColorSelected;
    }

    /**
     * ���ð�ť���º����ɫ
     *
     * @param backColorSelected
     */
    public void setBackColorSelected(String backColorSelected) {
        this.backColorSelecteds = backColorSelected;
    }


    /**
     * ���ð�ť�ı���ͼ
     *
     * @param backGroundImage
     */
    public void setBackGroundImage(int backGroundImage) {
        this.backGroundImage = backGroundImage;
        if (backGroundImage != 0) {
            setBackgroundResource(backGroundImage);
        }
    }

    /**
     * ���ð�ť���µı���ͼ
     *
     * @param backGroundImageSeleted
     */
    public void setBackGroundImageSeleted(int backGroundImageSeleted) {
        this.backGroundImageSelected = backGroundImageSeleted;
    }

    /**
     * ���ð�ťԲ�ǰ뾶��С
     *
     * @param radius
     */
    public void setRadius(float radius) {
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }
        gradientDrawable.setCornerRadius(radius);
    }

    /**
     * ���ð�ť������ɫ
     *
     * @param textColor
     */
    public void setTextColors(String textColor) {
        this.textColors = textColor;
        setTextColor(Color.parseColor(textColor));
    }

    /**
     * ���ð�ť������ɫ
     *
     * @param textColor
     */
    public void setTextColori(int textColor) {
        this.textColori = textColor;
        setTextColor(textColor);
    }

    /**
     * ���ð�ť���µ�������ɫ
     *
     * @param textColor
     */
    public void setTextColorSelected(String textColor) {
        this.textColorSelecteds = textColor;
    }

    /**
     * ���ð�ť���µ�������ɫ
     *
     * @param textColor
     */
    public void setTextColorSelected(int textColor) {
        this.textColorSelectedi = textColor;
    }

    /**
     * ��ť����״
     *
     * @param shape
     */
    public void setShape(int shape) {
        this.shape = shape;
    }

    /**
     * �������Ƿ�ΪԲ��
     *
     * @param fillet
     */
    @SuppressWarnings("deprecation")
    public void setFillet(Boolean fillet) {
        this.fillet = fillet;
        if (fillet) {
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            //GradientDrawable.RECTANGLE
            gradientDrawable.setShape(shape);
            gradientDrawable.setCornerRadius(radius);
            setBackgroundDrawable(gradientDrawable);
        }
    }


}
