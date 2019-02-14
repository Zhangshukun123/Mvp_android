package com.shd.shop.model.presenter;

import com.shd.shop.api.ShaoHuaDiModel;
import com.shd.shop.model.presenter.base.RxMvpPresenter;
import com.shd.shop.model.view.OrderView;

public class OrderPresenter extends RxMvpPresenter<OrderView> {

    private ShaoHuaDiModel model;

    public OrderPresenter(ShaoHuaDiModel model) {
        this.model = model;
    }


}
