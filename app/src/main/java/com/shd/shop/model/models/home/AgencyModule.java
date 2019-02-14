package com.shd.shop.model.models.home;


import android.app.Activity;
import android.util.Log;

import com.shd.shop.adapter.MenuItemAdapter;
import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.PerActivity;
import com.shd.shop.model.SmallScoped;
import com.shd.shop.model.main.home.MainActivity;
import com.shd.shop.model.models.home.factory.AgencyFragmentFactory;
import com.shd.shop.model.presenter.MainPresenter;
import com.shd.shop.server.DataServer;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/19.
 * Activity Module
 */
@Module
public class AgencyModule {

    private final MainActivity mActivity;

    public AgencyModule(MainActivity activity) {
        mActivity = activity;
    }

    @Provides
    @SmallScoped
    MainActivity getActivity() {
        return mActivity;
    }





}
