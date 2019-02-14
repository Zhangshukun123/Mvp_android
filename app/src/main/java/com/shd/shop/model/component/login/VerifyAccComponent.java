package com.shd.shop.model.component.login;


import com.shd.shop.model.SmallScoped;
import com.shd.shop.model.main.login.VerifyAccFragment;

import dagger.Component;

@Component(
        dependencies = {ResetPassComponent.class}
       )
@SmallScoped
public interface VerifyAccComponent {
    void inject(VerifyAccFragment fragment);
}
