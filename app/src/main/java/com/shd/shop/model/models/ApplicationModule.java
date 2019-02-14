package com.shd.shop.model.models;

import android.app.Application;
import android.content.Context;


import com.shd.shop.api.API;
import com.shd.shop.api.RetrofitService;
import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.ApplicationContext;
import com.shd.shop.model.ApplicationScope;
import com.shd.shop.server.DataServer;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @ApplicationScope
    API provideAPI(RetrofitService retrofit) {
        return retrofit.init().create(API.class);
    }

    @Provides
    @ApplicationScope
    ShaoHuaDiModel provideShaoHuaDiModel(API api){
        return new ShaoHuaDiModel(api);
    }

    @Provides
    @ApplicationScope
    DataServer provideDataServer(){
        return new DataServer();
    }




}
