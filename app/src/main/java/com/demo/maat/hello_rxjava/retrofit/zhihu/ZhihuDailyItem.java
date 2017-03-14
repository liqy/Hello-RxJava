package com.demo.maat.hello_rxjava.retrofit.zhihu;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by 蔡小木 on 2016/3/6 0006.
 */
public class ZhihuDailyItem {
    public boolean hasFadedIn = false;
    @SerializedName("images")
    private String[] images;
    @SerializedName("type")
    private int type;
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    private String date;
    public String ga_prefix;

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ZhihuDailyItem{" +
                "hasFadedIn=" + hasFadedIn +
                ", images=" + Arrays.toString(images) +
                ", type=" + type +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", ga_prefix='" + ga_prefix + '\'' +
                '}';
    }
}
