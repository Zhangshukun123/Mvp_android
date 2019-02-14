package com.shd.shop.model.main.login;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.base.BaseFragment;
import com.shd.shop.model.component.login.DaggerVerifyAccComponent;
import com.shd.shop.model.component.login.ResetPassComponent;
import com.shd.shop.model.presenter.ResetPasswordPresenter;
import com.shd.shop.utils.SoftInputUtils;
import com.shd.shop.utils.VerifyUtils;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;

public class VerifyAccFragment extends BaseFragment {
    ResetPassComponent component;

    @BindView(R.id.tv_acc)
    EditText etAcc;

    @BindView(R.id.btn_next)
    Button btnNext;

    @BindView(R.id.back)
    ImageButton back;

    @Inject
    ResetPasswordPresenter presenter;

    @Override
    public int LayoutView() {
        return R.layout.fragment_verify;
    }

    @Override
    protected void doDoes() {
        SoftInputUtils.showSoftInputFromWindow(activity, etAcc);

        RxView.clicks(btnNext).subscribe(aVoid -> {
            String acc = etAcc.getText().toString();
            if (TextUtils.isEmpty(acc)) {
                toast("手机号码不能为空");
                return;
            }
            if (!VerifyUtils.isMobileNO(acc)) {
                toast("手机号码格式不正确");
                return;
            }
            presenter.requestAccount(acc);
        });
        RxView.clicks(back).subscribe(aVoid -> getActivity().onBackPressed());
    }

    @Override
    protected void initInjector() {
        DaggerVerifyAccComponent.builder().resetPassComponent(component).build().inject(this);
    }


    public void setComponent(ResetPassComponent component) {
        this.component = component;
    }
}
