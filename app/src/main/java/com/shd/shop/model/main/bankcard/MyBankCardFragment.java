package com.shd.shop.model.main.bankcard;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.adapter.BankCardAdapter;
import com.shd.shop.base.BaseFragment;
import com.shd.shop.entity.BankCard;
import com.shd.shop.model.main.drawmoney.DrawingMoneyActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.functions.Action1;

public class MyBankCardFragment extends BaseFragment {

    @BindView(R.id.rl_bank_card)
    RecyclerView rl_bank_card;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_add_bankCard)
    TextView addBankCard;


    @Override
    public int LayoutView() {
        return R.layout.bank_card_fragment;
    }

    @Override
    protected void doDoes() {

        if (DrawingMoneyActivity.isIsIntoBankCard()) {
            tvTitle.setText("我的银行卡");
        } else {
            tvTitle.setText("选择银行卡");
        }
        rl_bank_card.setLayoutManager(new LinearLayoutManager(activity));
        List<BankCard> cards = new ArrayList<>();
        cards.add(new BankCard());
        rl_bank_card.setAdapter(new BankCardAdapter(DrawingMoneyActivity.isIsIntoBankCard(), cards));

        RxView.clicks(addBankCard)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> mAddFragmentListener.onAddFragment(R.id.frame_c, this, new AddBankCardFragment()));
    }

    @Override
    protected void initInjector() {

    }
}
