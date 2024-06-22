package com.example.portfolio;

public class TechItem {
    private int imageResId;
    private String title;
    private String url;

    public TechItem(int imageResId, String title, String url) {
        this.imageResId = imageResId;
        this.title = title;
        this.url = url;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}


