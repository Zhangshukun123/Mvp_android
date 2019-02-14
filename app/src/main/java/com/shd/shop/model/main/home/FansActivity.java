package com.shd.shop.model.main.home;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shd.shop.R;
import com.shd.shop.adapter.OrderItemAdapter;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.entity.OrderDate;
import com.shd.shop.model.presenter.base.RxMvpPresenter;
import com.shd.shop.utils.Utils;
import com.shd.shop.widget.ScrollInterceptScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FansActivity extends BaseActivity {

    @BindView(R.id.rl_myFans)
    RecyclerView rl_myFans;

    @BindView(R.id.my_fans)
    TextView my_fans;

    @BindView(R.id.scroll)
    ScrollInterceptScrollView scroll;

    @BindView(R.id.line_header_layout)
    LinearLayout line_header;

    @BindView(R.id.line_c)
    LinearLayout line_c;

    String TAG = "11222";

    @Override
    protected int attachLayoutRes() {
        return R.layout.fans_activity;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        rl_myFans.setLayoutManager(new LinearLayoutManager(this));
        List<OrderDate> dates = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dates.add(new OrderDate());
        }
        rl_myFans.setAdapter(new OrderItemAdapter(dates));
        scroll.setOnScrollListener(scrollY -> {
            int i = Utils.px2dp(this, scrollY);
            Log.i(TAG, "doDoes: " + i);
            if (i > 28) {
                line_header.setVisibility(View.VISIBLE);
                line_c.setVisibility(View.GONE);
            } else {
                line_header.setVisibility(View.GONE);
                line_c.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
