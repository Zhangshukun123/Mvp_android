package com.shd.shop.model.models;




import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.PerActivity;
import com.shd.shop.model.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/19.
 * Activity Module
 */
@Module
public class LoginModule {
    @Provides
    @PerActivity
    LoginPresenter proverPresenter(ShaoHuaDiModel model){
        return new LoginPresenter(model);
    }
}
