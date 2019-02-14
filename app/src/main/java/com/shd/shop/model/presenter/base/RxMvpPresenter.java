package com.shd.shop.model.presenter.base;


import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.shd.shop.api.MvpView;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.utils.HttpErrorToast;
import com.shd.shop.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static org.greenrobot.eventbus.EventBus.TAG;

/**
 * Created by mingjun on 16/7/20.
 */
public class RxMvpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {

    @Inject
    Application mCx;

    private BaseActivity activity;

    private CompositeSubscription mCompositeSubscription;


    @Inject
    public RxMvpPresenter() {
    }

    public void setActivity(Activity activity) {
        this.activity = (BaseActivity) activity;
    }


    protected <T> void invoke(Observable<T> observable, workResult<T> result) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.bindToLifecycle())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Throwable throwable = HttpErrorToast.unifiedError(e, mCx);
                        ToastUtils.showToast(throwable.getMessage());
                    }

                    @Override
                    public void onNext(T t) {
                        result.callBackResult(t);
                    }
                });
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(V mvpView) {
        super.attachView(mvpView);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }

    public interface workResult<T> {
        void callBackResult(T t);
    }


}
