package com.shd.shop.model.main.bankcard;

import android.widget.ImageButton;

import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.base.BaseFragment;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class ChooseBankCardFragment extends BaseFragment {

    @BindView(R.id.ib_bank_card)
    ImageButton ibBankCard;


    @Override
    public int LayoutView() {
        return R.layout.chos_card;
    }

    @Override
    protected void doDoes() {
        RxView.clicks(ibBankCard)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> mAddFragmentListener.onAddFragment(R.id.frame_c, this, new MyBankCardFragment()));
    }

    @Override
    protected void initInjector() {

    }
}
