package com.flyme.moyu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/30.
 */
public class MeiziAdapter extends BaseAdapter {

    Context mContext;
    int[] drawableId = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
    String[] describtaion = {"今生我们弄丢的，来生要在哪里寻", "也许，机遇不会出现在前进的路上，但返回不是我们的方向。",
            "你会长大，我会回来", "漂洋过海的来看你，为了这次相聚，我连见面时的呼吸，都曾反复练习，言语从来没能将我的情意，表达千万分之一。",
            "眼睛为她下着雨，心却为她打着伞，这就是爱情。", "有走的理由，却愿意停留，才是爱的最好理由。"};

    public MeiziAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.meizi_item, null);
            viewHolder = new ViewHolder(view);
        }
        viewHolder.mzImageView.setImageResource(drawableId[new Random().nextInt(6)]);
        viewHolder.jjTextView.setText(describtaion[new Random().nextInt(6)]);
        viewHolder.talkTextView.setText(describtaion[new Random().nextInt(6)]);

        return view;
    }

    public static class ViewHolder {
        @Bind(R.id.iv_mz_photo)
        ImageView mzImageView;
        @Bind(R.id.tv_jianjie)
        TextView jjTextView;
        @Bind(R.id.tv_talk)
        TextView talkTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
