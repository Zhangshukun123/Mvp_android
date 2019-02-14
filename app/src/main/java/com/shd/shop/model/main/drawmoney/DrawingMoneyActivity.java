package com.shd.shop.model.main.drawmoney;

import android.graphics.Color;
import android.os.Build;

import com.shd.shop.R;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.model.main.bankcard.ChooseBankCardFragment;
import com.shd.shop.model.main.bankcard.MyBankCardFragment;
import com.shd.shop.model.presenter.base.RxMvpPresenter;

public class DrawingMoneyActivity extends BaseActivity {


    private static boolean isIntoBankCard;

    public static void LoandMyBankCard(boolean enter) {
        isIntoBankCard = enter;
    }

    public static boolean isIsIntoBankCard() {
        return isIntoBankCard;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.drawing_money;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        if (isIntoBankCard) {
            loadFragment(R.id.frame_c, new MyBankCardFragment());
        } else {
            loadFragment(R.id.frame_c, new ChooseBankCardFragment());
        }
    }


    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
