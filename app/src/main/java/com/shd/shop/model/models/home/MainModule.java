package com.shd.shop.model.models.home;


import android.app.Activity;

import com.shd.shop.adapter.MenuItemAdapter;
import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.PerActivity;
import com.shd.shop.model.SmallScoped;
import com.shd.shop.model.models.home.factory.AgencyFragmentFactory;
import com.shd.shop.model.presenter.LoginPresenter;
import com.shd.shop.model.presenter.MainPresenter;
import com.shd.shop.server.DataServer;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/19.
 * Activity Module
 */
@Module
public class MainModule {
    private Activity activity;

    public MainModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    MainPresenter proverPresenter(ShaoHuaDiModel model) {
        return new MainPresenter(model);
    }

    @Provides
    @PerActivity
    MenuItemAdapter proverAdapter(DataServer dataServer) {
        return new MenuItemAdapter(activity, dataServer);
    }

    @Provides
    @PerActivity
    AgencyFragmentFactory proverAgencyFragmentFactory(DataServer server) {
        return new AgencyFragmentFactory(server);
    }

}
