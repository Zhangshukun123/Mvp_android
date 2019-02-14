package com.shd.shop.model.models;


import android.app.Activity;

import com.shd.shop.adapter.MenuItemAdapter;
import com.shd.shop.adapter.OrderAdapter;
import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.PerActivity;
import com.shd.shop.model.models.home.factory.AgencyFragmentFactory;
import com.shd.shop.model.presenter.MainPresenter;
import com.shd.shop.model.presenter.OrderPresenter;
import com.shd.shop.server.DataServer;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/19.
 * Activity Module
 */
@Module
public class OrderModule {
    private Activity activity;

    public OrderModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    OrderPresenter proverPresenter(ShaoHuaDiModel model) {
        return new OrderPresenter(model);
    }

    @Provides
    @PerActivity
    OrderAdapter proverAdapter(DataServer dataServer) {
        return new OrderAdapter(activity, dataServer.getOrderDate());
    }


}
