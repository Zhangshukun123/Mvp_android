package com.shd.shop.model.models;

import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.PerActivity;
import com.shd.shop.model.main.login.VerifyAccFragment;
import com.shd.shop.model.presenter.ResetPasswordPresenter;

import dagger.Module;
import dagger.Provides;
@Module
public class ResetPasswordModule {

    @Provides
    @PerActivity
    ResetPasswordPresenter proverPresenter(ShaoHuaDiModel model){
        return new ResetPasswordPresenter(model);
    }

}
