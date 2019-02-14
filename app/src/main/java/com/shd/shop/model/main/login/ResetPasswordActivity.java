package com.shd.shop.model.main.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.entity.SmsModel;
import com.shd.shop.model.component.login.DaggerResetPassComponent;
import com.shd.shop.model.component.login.ResetPassComponent;
import com.shd.shop.model.presenter.ResetPasswordPresenter;
import com.shd.shop.model.view.ResetPassView;

import javax.inject.Inject;

import butterknife.BindView;
import me.yokeyword.swipebackfragment.SwipeBackLayout;

public class ResetPasswordActivity extends BaseActivity<ResetPasswordPresenter, ResetPassView> implements ResetPassView {


    public static void launch(Context context) {
        context.startActivity(new Intent(context, ResetPasswordActivity.class));
    }


    @BindView(R.id.frame)
    FrameLayout frame;

    VerifyAccFragment verifyAccFragment;
    SetAPasswordFragment setAPasswordFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.reset_pass_activity;
    }

    @Override
    protected void initInjector() {
        ResetPassComponent component = DaggerResetPassComponent.builder().applicationComponent(getAppComponent()).build();
        component.inject(this);
        verifyAccFragment = new VerifyAccFragment();
        verifyAccFragment.setComponent(component);

        setAPasswordFragment = new SetAPasswordFragment();
        setAPasswordFragment.setComponent(component);


    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        mSwipeBackLayout.setEdgeOrientation(SwipeBackLayout.EDGE_LEFT);
        loadFragment(R.id.frame, verifyAccFragment);
    }



    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void CallPassWordSuccess(SmsModel sms) {

    }

    @Override
    public void CallPassWordFailure() {

    }

    @Override
    public void CallPhone(String phone) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", phone);
        setAPasswordFragment.setArguments(bundle);
        addFragment(R.id.frame, verifyAccFragment,setAPasswordFragment);
    }
}
