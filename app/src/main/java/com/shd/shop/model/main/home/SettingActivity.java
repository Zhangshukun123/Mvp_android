package com.shd.shop.model.main.home;

import android.graphics.Color;
import android.os.Build;

import com.shd.shop.R;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.model.presenter.base.RxMvpPresenter;

public class SettingActivity extends BaseActivity {
    @Override
    protected int attachLayoutRes() {
        return R.layout.setting_activity;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.WHITE);
        }


    }



    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
