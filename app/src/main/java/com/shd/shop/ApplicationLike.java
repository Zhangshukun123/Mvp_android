package com.shd.shop;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.shd.shop.model.component.ApplicationComponent;
import com.shd.shop.model.component.DaggerApplicationComponent;
import com.shd.shop.model.models.ApplicationModule;
import com.shd.shop.server.InitializeService;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;


@DefaultLifeCycle(application = "com.shd.shop.IApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class ApplicationLike extends DefaultApplicationLike {

    private static ApplicationComponent sAppComponent;
    private static Context sContext;

    public ApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                           long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        TinkerInstaller.install(this);

    }


    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplication();
        if (sAppComponent == null) {
            sAppComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(getApplication()))
                    .build();
        }

        if (LeakCanary.isInAnalyzerProcess(getApplication())) {//1
            return;
        }
        LeakCanary.install(getApplication());

        InitializeService.start(getApplication());

    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }


    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }

    public static Context getContext() {
        return sContext;
    }


}
