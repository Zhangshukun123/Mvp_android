package com.shd.shop.model.presenter;

import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.presenter.base.RxMvpPresenter;
import com.shd.shop.model.view.ResetPassView;

public class ResetPasswordPresenter extends RxMvpPresenter<ResetPassView> {
    private ShaoHuaDiModel model;

    public ResetPasswordPresenter(ShaoHuaDiModel model) {
        this.model = model;
    }

    public void requestAccount(String acc) {
        getMvpView().CallPhone(acc);
    }

}
