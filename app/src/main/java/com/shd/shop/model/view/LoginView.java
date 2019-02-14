package com.shd.shop.model.view;


import com.shd.shop.api.MvpView;
import com.shd.shop.entity.UserModel;

public interface LoginView extends MvpView {
    void loginSuccess(UserModel user);
    void loginError(Throwable e);
}
