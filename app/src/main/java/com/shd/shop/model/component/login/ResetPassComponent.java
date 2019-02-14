package com.shd.shop.model.component.login;


import com.shd.shop.model.PerActivity;
import com.shd.shop.model.component.ApplicationComponent;
import com.shd.shop.model.main.login.ResetPasswordActivity;
import com.shd.shop.model.models.ResetPasswordModule;
import com.shd.shop.model.presenter.ResetPasswordPresenter;

import dagger.Component;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {ResetPasswordModule.class})
public interface ResetPassComponent {
    void inject(ResetPasswordActivity activity);

    ResetPasswordPresenter getPresenter();

}
