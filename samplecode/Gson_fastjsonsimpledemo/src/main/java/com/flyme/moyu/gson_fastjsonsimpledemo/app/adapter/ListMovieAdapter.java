package com.flyme.moyu.gson_fastjsonsimpledemo.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.flyme.moyu.gson_fastjsonsimpledemo.R;
import com.flyme.moyu.gson_fastjsonsimpledemo.app.MyApplication;
import com.flyme.moyu.gson_fastjsonsimpledemo.app.bean.Movie;
import com.flyme.moyu.gson_fastjsonsimpledemo.app.utils.BitmapCache;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/9/7.
 */
public class ListMovieAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Movie> list;
    LayoutInflater inflater;

    public ListMovieAdapter(Context context, ArrayList<Movie> movies) {
        this.mContext = context;
        this.list = movies;
        inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.item_moive, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        Movie m=list.get(i);
        holder.mTvId.setText(m.getMovieId());
        holder.mTvName.setText(m.getMovieName());

        volley_netWorkImageView(holder.mNwIvPic, m.getPic_url());

        return view;
    }

    private void volley_netWorkImageView(NetworkImageView imageView,String imageUrl) {

        ImageLoader imageLoader = new ImageLoader(MyApplication.getHttpQueue(), new BitmapCache());
        imageView.setDefaultImageResId(R.mipmap.ic_launcher);
        imageView.setErrorImageResId(R.mipmap.ic_launcher);
        imageView.setImageUrl(imageUrl, imageLoader);


    }

    static class ViewHolder {

        @Bind(R.id.tv_id)
        TextView mTvId;
        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.nwiv_pic)
        NetworkImageView mNwIvPic;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


    }
}
