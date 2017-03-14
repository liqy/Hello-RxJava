package com.demo.maat.hello_rxjava.retrofit.zhihu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by 蔡小木 on 2016/3/6 0006.
 */
public class ZhihuDaily {

    @SerializedName("date")
    private String date;

    @SerializedName("top_stories")
    private ArrayList<ZhihuDailyItem> mZhihuDailyItems;

    @SerializedName("stories")
    private ArrayList<ZhihuDailyItem> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ZhihuDailyItem> getZhihuDailyItems() {
        return mZhihuDailyItems;
    }

    public void setZhihuDailyItems(ArrayList<ZhihuDailyItem> zhihuDailyItems) {
        this.mZhihuDailyItems = zhihuDailyItems;
    }

    public ArrayList<ZhihuDailyItem> getStories() {
        return stories;
    }

    public ArrayList<ZhihuDailyItem> getmZhihuDailyItems() {
        return mZhihuDailyItems;
    }

    public void setStories(ArrayList<ZhihuDailyItem> stories) {
        this.stories = stories;
    }
}
