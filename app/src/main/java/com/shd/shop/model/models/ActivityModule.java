package com.shd.shop.model.models;

import android.app.Activity;
import android.util.Log;



import dagger.Module;
import dagger.Provides;


/**
 * Created by long on 2016/8/19.
 * Activity Module
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
        String localClassName = activity.getLocalClassName();
        Log.i("123", "ActivityModule: " + localClassName);
    }

    @Provides
    Activity getActivity() {
        return mActivity;
    }
}
