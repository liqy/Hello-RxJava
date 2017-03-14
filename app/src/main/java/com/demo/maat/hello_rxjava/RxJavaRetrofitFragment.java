package com.demo.maat.hello_rxjava;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.demo.maat.hello_rxjava.common.logger.Log;
import com.demo.maat.hello_rxjava.retrofit.zhihu.ZhihuDaily;
import com.demo.maat.hello_rxjava.retrofit.zhihu.ZhihuDailyItem;
import com.demo.maat.hello_rxjava.retrofit.zhihu.ZhihuManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public class RxJavaRetrofitFragment extends Fragment {


    static final String TAG = "RxJavaRetrofitFragment";
    @BindView(R.id.btn_get)
    Button mBtnGet;
    private Subscription subscription;

    private CompositeSubscription mCompositeSubscription;
    ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.retrofit_fragment, container, false);
        ButterKnife.bind(this, view);
        mCompositeSubscription = new CompositeSubscription();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @OnClick(R.id.btn_get)
    public void onClick() {
        getData();
//        getData();
//        getData();
    }

    void getData() {
        subscription = ZhihuManager.getInstance()
                .getLastDaily()//被观察者
                .map(new Func1<ZhihuDaily, ArrayList<ZhihuDailyItem>>() {
                    @Override
                    public ArrayList<ZhihuDailyItem> call(ZhihuDaily zhihuDaily) {
                        ArrayList<ZhihuDailyItem> list = new ArrayList<ZhihuDailyItem>();
                        if (zhihuDaily.getmZhihuDailyItems() != null)
                            list.addAll(zhihuDaily.getmZhihuDailyItems());
                        if (zhihuDaily.getStories() != null)
                            list.addAll(zhihuDaily.getStories());
                        return list;
                    }
                })
                .subscribeOn(Schedulers.io())//
                .observeOn(AndroidSchedulers.mainThread())//
                .subscribe(new Subscriber<ArrayList<ZhihuDailyItem>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArrayList<ZhihuDailyItem> daily) {

                        Observable.from(daily).filter(new Func1<ZhihuDailyItem, Boolean>() {
                            @Override
                            public Boolean call(ZhihuDailyItem item) {
                                return item.ga_prefix.equals("031407");
                            }
                        }).subscribe(new Subscriber<ZhihuDailyItem>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ZhihuDailyItem item) {
                            printLog(item.ga_prefix+":"+item.getTitle());
                            }
                        });

                    }
                });
        mCompositeSubscription.add(subscription);
    }

    private void printLog(String s) {
        Log.i(TAG, s);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
    }


}


