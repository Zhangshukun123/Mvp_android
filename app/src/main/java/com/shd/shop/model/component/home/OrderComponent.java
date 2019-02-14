package com.shd.shop.model.component.home;


import com.shd.shop.model.PerActivity;
import com.shd.shop.model.component.ApplicationComponent;
import com.shd.shop.model.main.home.OrderActivity;
import com.shd.shop.model.models.OrderModule;

import dagger.Component;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = { OrderModule.class})
public interface OrderComponent {
     void inject(OrderActivity activity);

}
