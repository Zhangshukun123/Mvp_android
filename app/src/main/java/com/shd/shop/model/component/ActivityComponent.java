package com.shd.shop.model.component;

import android.app.Activity;

import com.shd.shop.model.models.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
