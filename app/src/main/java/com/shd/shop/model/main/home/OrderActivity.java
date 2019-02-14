package com.shd.shop.model.main.home;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.jakewharton.rxbinding.view.RxView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shd.shop.R;
import com.shd.shop.adapter.OrderAdapter;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.model.component.home.DaggerOrderComponent;
import com.shd.shop.model.models.OrderModule;
import com.shd.shop.model.presenter.OrderPresenter;
import com.shd.shop.model.view.OrderView;

import javax.inject.Inject;

import butterknife.BindView;

public class OrderActivity extends BaseActivity<OrderPresenter, OrderView> implements OrderView {

    @BindView(R.id.rl_order)
    RecyclerView rlOrder;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @BindView(R.id.ib_back)
    ImageButton ib_back;


    @Inject
    OrderPresenter presenter;

    @Inject
    OrderAdapter adapter;


    @Override
    protected int attachLayoutRes() {
        return R.layout.order_activity;
    }

    @Override
    protected void initInjector() {
        DaggerOrderComponent.builder().
                applicationComponent(getAppComponent())
                .orderModule(new OrderModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        rlOrder.setLayoutManager(new LinearLayoutManager(this));
        rlOrder.setAdapter(adapter);
        refreshLayout.autoRefresh();
        refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));

        RxView.clicks(ib_back).subscribe(aVoid -> finish());

    }



    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
