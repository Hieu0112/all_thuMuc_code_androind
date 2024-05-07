package com.example.image_view;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Image implements Serializable {
    private int id;
    private String url;
    private Bitmap bitmap;

    public Image(int id, String url, Bitmap bitmap) {
        this.id = id;
        this.url = url;
        this.bitmap = bitmap;
    }

    public Image(String url, Bitmap bitmap) {
        this.url = url;
        this.bitmap = bitmap;
    }

    public Image(String url) {
        this.url = url;
        this.bitmap=null;
    }

    public Image(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.url="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
