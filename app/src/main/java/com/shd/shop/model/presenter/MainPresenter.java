package com.shd.shop.model.presenter;


import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.presenter.base.RxMvpPresenter;
import com.shd.shop.model.view.MainView;

public class MainPresenter extends RxMvpPresenter<MainView> {

    ShaoHuaDiModel model;

    public MainPresenter(ShaoHuaDiModel model) {
        this.model = model;
    }
}
