package com.flyme.moyu.gson_fastjsonsimpledemo.app.bean;

/**
 * Created by Administrator on 2015/9/7.
 * "movieId": "226955",
 * "movieName": "´¿ÕæÄê´ú",
 * "pic_url": "http://v.juhe.cn/movie/picurl?28137515"
 */
public class Movie {

    private String movieId;
    private String movieName;
    private String pic_url;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }


}
