package com.cookandroid.and0802_06_cuslist;

import android.graphics.drawable.Drawable;

public class Movie {
    private Drawable imgae;
    private String title;
    private String genre;

    public Movie(Drawable imgae, String title, String genre) {
        this.imgae = imgae;
        this.title = title;
        this.genre = genre;
    }

    public Drawable getImgae() {
        return imgae;
    }

    public void setImgae(Drawable imgae) {
        this.imgae = imgae;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
