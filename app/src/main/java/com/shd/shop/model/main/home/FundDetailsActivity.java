package com.shd.shop.model.main.home;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shd.shop.R;
import com.shd.shop.adapter.FundAdapter;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.entity.OrderDate;
import com.shd.shop.model.presenter.base.RxMvpPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FundDetailsActivity extends BaseActivity {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @BindView(R.id.rl_fund)
    RecyclerView rl_fund;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fund_details_activity;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        rl_fund.setLayoutManager(new LinearLayoutManager(this));
        List<OrderDate> dates=new ArrayList<>();
        dates.add(new OrderDate());
        dates.add(new OrderDate());
        dates.add(new OrderDate());
        dates.add(new OrderDate());
        rl_fund.setAdapter(new FundAdapter(this,dates));
    }



    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
