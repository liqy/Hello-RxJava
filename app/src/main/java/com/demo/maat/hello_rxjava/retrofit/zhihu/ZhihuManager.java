package com.demo.maat.hello_rxjava.retrofit.zhihu;

import com.demo.maat.hello_rxjava.common.logger.Log;
import com.demo.maat.hello_rxjava.retrofit.ZhihuApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xinghongfei on 16/10/5.
 */

public class ZhihuManager {

    private ZhihuApi zhihuApi;

    private ZhihuManager() {
        this.zhihuApi = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com")//基础URL
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//绑定RxJava
                .addConverterFactory(GsonConverterFactory.create())//Gson解析
                .build()
                .create(ZhihuApi.class);
        Log.d("ZhihuManager","初始化");
    }

    private static class SingletonInstance {
        private static final ZhihuManager INSTANCE = new ZhihuManager();
    }

    public static ZhihuApi getInstance() {
        return SingletonInstance.INSTANCE.zhihuApi;
    }


}
