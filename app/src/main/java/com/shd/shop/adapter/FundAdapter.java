package com.shd.shop.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shd.shop.R;
import com.shd.shop.entity.OrderDate;

import java.util.ArrayList;
import java.util.List;

public class FundAdapter extends BaseQuickAdapter<OrderDate, BaseViewHolder> {

    private Activity activity;

    public FundAdapter(Activity activity, @Nullable List<OrderDate> data) {
        super(R.layout.order_item, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderDate item) {
        RecyclerView rl_item = helper.getView(R.id.order_item);
        helper.getView(R.id.line_c).setVisibility(View.GONE);
        rl_item.setLayoutManager(new LinearLayoutManager(activity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        List<OrderDate> data = new ArrayList<>();
        data.add(new OrderDate());
        data.add(new OrderDate());
        data.add(new OrderDate());
        data.add(new OrderDate());
        rl_item.setAdapter(new OrderItemAdapter(data));
    }
}
