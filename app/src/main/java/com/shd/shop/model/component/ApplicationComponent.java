package com.shd.shop.model.component;

import android.app.Application;


import com.shd.shop.api.API;
import com.shd.shop.model.ApplicationScope;
import com.shd.shop.model.models.ApplicationModule;
import com.shd.shop.server.DataServer;

import javax.inject.Singleton;

import dagger.Component;

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
//    void inject(Application application);

    Application application();

    API getApi();

    DataServer provideHeater();


}
