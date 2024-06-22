package com.example.portfolio;

public class EduItem {
    private int imageResId;
    private String title;
    private String desc;
    private String url;

    public EduItem(int imageResId, String title, String desc, String url) {
        this.imageResId = imageResId;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }
}
