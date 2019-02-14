package com.shd.shop.model.main.home.fragment;


import com.shd.shop.entity.DialogMessage;
import com.shd.shop.model.main.home.AgencyBaseFragment;
import com.shd.shop.model.main.home.MainActivity;


public class ShopAgencyFragment extends AgencyBaseFragment {
    MainActivity activity;

    @Override
    protected void doDoes() {
        super.doDoes();
        activity = (MainActivity) getActivity();
    }

    private void showHintDialog() {
        DialogMessage message = new DialogMessage();
        message.setCancel("返回");
        message.setSure("前往");
        message.setTitle("设置支付密码");
        message.setContext("请前往完成支付密码设置");
        activity.showLoadingDialog(message, () -> {
            toast("123456");
        });
    }
}
