package com.shd.shop.model.component.home;


import android.app.Activity;

import com.shd.shop.model.SmallScoped;
import com.shd.shop.model.main.home.AgencyBaseFragment;
import com.shd.shop.model.main.home.MainActivity;
import com.shd.shop.model.models.home.AgencyModule;
import com.shd.shop.model.models.home.MainModule;

import dagger.Component;

@Component(
        dependencies = MainComponent.class,
        modules = {AgencyModule.class})
@SmallScoped
public interface AgencyBaseComponent {
    void inject(AgencyBaseFragment fragment);
    MainActivity getActivity();
}
