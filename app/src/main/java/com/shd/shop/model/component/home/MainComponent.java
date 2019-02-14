package com.shd.shop.model.component.home;



import com.shd.shop.adapter.MenuItemAdapter;
import com.shd.shop.model.main.home.MainActivity;
import com.shd.shop.model.PerActivity;
import com.shd.shop.model.component.ApplicationComponent;
import com.shd.shop.model.models.home.MainModule;
import com.shd.shop.server.DataServer;

import dagger.Component;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = { MainModule.class})
public interface MainComponent {
     void inject(MainActivity activity);

     MenuItemAdapter getAdapter();

     DataServer getServer();
}
