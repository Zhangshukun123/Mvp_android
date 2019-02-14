package com.shd.shop.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shd.shop.R;
import com.shd.shop.entity.OrderDate;

import java.util.List;

public class OrderItemAdapter extends BaseQuickAdapter<OrderDate,BaseViewHolder> {

    public OrderItemAdapter(@Nullable List<OrderDate> data) {
        super(R.layout.order_item_child, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderDate item) {

    }
}
