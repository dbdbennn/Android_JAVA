package com.cookandroid.and0803_01_carlist;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Car {
    private Drawable image;
    private String title;

    public Car(Drawable imgae, String title) {
        this.image = imgae;
        this.title = title;
    }


    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
