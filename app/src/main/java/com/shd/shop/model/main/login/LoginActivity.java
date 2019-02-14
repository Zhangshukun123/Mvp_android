package com.shd.shop.model.main.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.orhanobut.hawk.Hawk;
import com.shd.shop.api.Agency;
import com.shd.shop.base.global.Contanls;
import com.shd.shop.model.main.home.MainActivity;
import com.shd.shop.R;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.entity.UserModel;
import com.shd.shop.model.component.DaggerLoginComponent;
import com.shd.shop.model.presenter.LoginPresenter;
import com.shd.shop.model.view.LoginView;
import com.shd.shop.server.DataServer;
import com.shd.shop.utils.HttpErrorToast;
import com.shd.shop.utils.L;
import com.shd.shop.utils.ToastUtils;
import com.shd.shop.utils.VerifyUtils;

import junit.framework.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;


public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView {


    @BindView(R.id.et_account)
    EditText etAccount;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_login)
    Button btnLogin;


    @BindView(R.id.tv_forgetpassword)
    TextView forgetPassword;


    @Inject
    DataServer server;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInjector() {
        DaggerLoginComponent.builder().applicationComponent(getAppComponent()).build().inject(this);
    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        mSwipeBackLayout.setEnableGesture(false);
        String acc = Hawk.get(Contanls.ACCOUNT);
        if (!TextUtils.isEmpty(acc)) {
            etAccount.setText(acc);
        }

        int me = android.uniaip.com.testmodul.Test.me();
        Log.i("", "doDoes: " + me);

        setOnClickListener();

    }

    private void setOnClickListener() {
//        server.setAgency(Agency.SUPPLER_AGENCY);
//        startActivity(new Intent(this, MainActivity.class));
//        finish();
        RxTextView.textChanges(etPassword)
                .subscribe(charSequence -> {
                    if (charSequence.length() > 0) {
                        btnLogin.setBackgroundResource(R.drawable.button);
                    } else {
                        btnLogin.setBackgroundResource(R.drawable.yuanjiao);
                    }
                });
        RxView.clicks(btnLogin)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    String acc = etAccount.getText().toString();
                    String pass = etPassword.getText().toString();
                    if (TextUtils.isEmpty(acc)) {
                        toast("账号不能为空");
                        return;
                    }
                    if (TextUtils.isEmpty(pass)) {
                        toast("密码不能为空");
                        return;
                    }
                    boolean mobileNO = VerifyUtils.isMobileNO(etAccount.getText().toString());
                    if (!mobileNO) {
                        toast("手机格式不正确！");
                        return;
                    }
                    showLoadingDialog(null, null);
                    mPresenter.login(acc, pass);
                });

        RxView.clicks(forgetPassword)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> ResetPasswordActivity.launch(this));
    }


    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void loginSuccess(UserModel user) {
        dismissLoadingDialog();
        if (user.isSuccess()) {
            UserModel.DataBean data = user.getData();
            if (data != null) {
                Hawk.chain().put(Contanls.X_TOKEN, user.getData().token)
                        .put(Contanls.ACCOUNT, etAccount.getText().toString())
                        .commit();
                //设置代理首页 代理模式
                server.setAgency(Agency.SUPPLER_AGENCY);
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                toast("该用户不存在");
            }
        } else {
            toast(user.getMessage());
        }
    }

    @Override
    public void loginError(Throwable e) {
        ResponseBody responseBody = ((HttpException) e).response().errorBody();
        try {
            String string = responseBody.string();
            L.d(string);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Throwable throwable = HttpErrorToast.unifiedError(e, this);
        ToastUtils.showToast(throwable.getMessage());
    }
}
