package com.shd.shop.model.component.login;


import com.shd.shop.model.SmallScoped;
import com.shd.shop.model.main.login.SetAPasswordFragment;

import dagger.Component;

@Component(
        dependencies = {ResetPassComponent.class}
       )
@SmallScoped
public interface SetAPassComponent {
    void inject(SetAPasswordFragment fragment);
}
