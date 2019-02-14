package com.shd.shop.model.presenter;


import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.presenter.base.RxMvpPresenter;
import com.shd.shop.model.view.LoginView;

import javax.inject.Inject;

public class LoginPresenter extends RxMvpPresenter<LoginView> {

    private ShaoHuaDiModel model;

    @Inject
    public LoginPresenter(ShaoHuaDiModel model) {
        this.model = model;
    }

    public void login(String username, String password) {
        invoke(model.login(username, password, null), userModel -> {
            getMvpView().loginSuccess(userModel);
        });
    }


}
