package com.asukim.recyclerview;

public class RecyclerItem {

    int image;
    String title;

    RecyclerItem(int image, String title) {
        this.image = image;
        this.title = title;
    }

    int getImage() {
        return this.image;
    }

    String getTitle() {
        return this.title;
    }
}
