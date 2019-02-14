package com.shd.shop.model.component;



import com.shd.shop.model.PerActivity;
import com.shd.shop.model.main.login.LoginActivity;
import com.shd.shop.model.models.LoginModule;

import dagger.Component;
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = { LoginModule.class})
public interface LoginComponent {
     void inject(LoginActivity activity);
}
