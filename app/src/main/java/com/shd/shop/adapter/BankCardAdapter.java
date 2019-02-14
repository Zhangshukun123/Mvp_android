package com.shd.shop.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shd.shop.R;
import com.shd.shop.entity.BankCard;

import java.util.List;

public class BankCardAdapter extends BaseQuickAdapter<BankCard, BaseViewHolder> {

    private boolean showPattern;

    public BankCardAdapter(boolean showPattern, @Nullable List<BankCard> data) {
        super(R.layout.bank_card_item, data);
        this.showPattern = showPattern;
    }

    @Override
    protected void convert(BaseViewHolder helper, BankCard item) {

        if (showPattern) {
            helper.getView(R.id.line_mail).setVisibility(View.VISIBLE);
            helper.getView(R.id.line1).setVisibility(View.VISIBLE);
            helper.getView(R.id.line_choose_bankCard).setVisibility(View.GONE);
            helper.getView(R.id.line_choose_bankCard_c).setVisibility(View.GONE);
        }else {
            helper.getView(R.id.line_mail).setVisibility(View.GONE);
            helper.getView(R.id.line1).setVisibility(View.GONE);
            helper.getView(R.id.line_choose_bankCard).setVisibility(View.VISIBLE);
            helper.getView(R.id.line_choose_bankCard_c).setVisibility(View.VISIBLE);
        }

    }
}
