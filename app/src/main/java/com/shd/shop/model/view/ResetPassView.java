package com.shd.shop.model.view;

import com.shd.shop.api.MvpView;
import com.shd.shop.entity.SmsModel;

public interface ResetPassView extends MvpView {
    void CallPassWordSuccess(SmsModel sms);

    void CallPassWordFailure();

    void CallPhone(String phone);


}
