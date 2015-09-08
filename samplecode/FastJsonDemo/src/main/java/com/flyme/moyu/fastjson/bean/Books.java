package com.flyme.moyu.fastjson.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
public class Books {
    private String title;
    private String image;
    private List<String> author;
    private String publisher;
    private ArrayList<Tag> tags;

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", tags=" + tags +
                '}';
    }
}
