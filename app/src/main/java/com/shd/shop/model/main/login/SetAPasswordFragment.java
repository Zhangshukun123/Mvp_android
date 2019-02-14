package com.shd.shop.model.main.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.base.BaseFragment;
import com.shd.shop.model.component.login.DaggerSetAPassComponent;
import com.shd.shop.model.component.login.ResetPassComponent;
import com.shd.shop.utils.SoftInputUtils;
import com.shd.shop.widget.CountDownView;

import butterknife.BindView;

public class SetAPasswordFragment extends BaseFragment {

    @BindView(R.id.countDownView)
    CountDownView countDownView;

    @BindView(R.id.tv_mes)
    TextView tvMes;

    @BindView(R.id.tv_code)
    EditText etCode;

    @BindView(R.id.back)
    ImageButton back;


    ResetPassComponent component;
    private String phone;

    @Override
    public int LayoutView() {
        return R.layout.set_pass_fragment;
    }

    @Override
    protected void doDoes() {
        Bundle arguments = getArguments();
        phone = arguments.getString("phone");
        if (!TextUtils.isEmpty(phone)) {
            SoftInputUtils.showSoftInputFromWindow(activity,etCode);
            String format = getResources().getString(R.string.hint_code);
            String result= String.format(format ,phone);
            tvMes.setText(result);
            countDownView.start();
        }
        RxView.clicks(back).subscribe(aVoid -> getActivity().onBackPressed());
    }

    @Override
    protected void initInjector() {
        DaggerSetAPassComponent.builder().resetPassComponent(component).build().inject(this);
    }

    public void setComponent(ResetPassComponent component) {
        this.component = component;
    }
}
