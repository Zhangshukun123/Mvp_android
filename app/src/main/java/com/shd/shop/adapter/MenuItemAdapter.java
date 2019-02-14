package com.shd.shop.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.model.main.drawmoney.DrawingMoneyActivity;
import com.shd.shop.model.main.home.FansActivity;
import com.shd.shop.model.main.home.FundDetailsActivity;
import com.shd.shop.model.main.home.OrcodeActivity;
import com.shd.shop.model.main.home.OrderActivity;
import com.shd.shop.model.main.home.OrderMessageActivity;
import com.shd.shop.model.main.home.SettingActivity;
import com.shd.shop.model.wrapper.ImageLoader;
import com.shd.shop.server.DataServer;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MenuItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private List<Integer> icon_path;
    private Activity activity;

    public MenuItemAdapter(Activity activity, DataServer server) {
        super(R.layout.item_fun, server.supplier_item());
        icon_path = server.supplier_icon();
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item, item);
        ImageView icon = helper.getView(R.id.iv_icon);
        ImageLoader.load(icon_path.get(helper.getAdapterPosition()), icon);

        RxView.clicks(helper.getView(R.id.con_item))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    switch (item) {
                        case "我的订单":
                            activity.startActivity(new Intent(activity, OrderActivity.class));
                            break;
                        case "资金明细":
                            activity.startActivity(new Intent(activity, FundDetailsActivity.class));
                            break;
                        case "二维码":
                            activity.startActivity(new Intent(activity, OrcodeActivity.class));
                            break;
                        case "发起提现":
                            DrawingMoneyActivity.LoandMyBankCard(false);
                            activity.startActivity(new Intent(activity, DrawingMoneyActivity.class));
                            break;
                        case "银行卡":
                            DrawingMoneyActivity.LoandMyBankCard(true);
                            activity.startActivity(new Intent(activity, DrawingMoneyActivity.class));
                            break;
                        case "我的粉丝":
                            activity.startActivity(new Intent(activity, FansActivity.class));
                            break;
                        case "消息中心":
                            activity.startActivity(new Intent(activity, OrderMessageActivity.class));
                            break;
                        case "设置":
                            activity.startActivity(new Intent(activity, SettingActivity.class));
                            break;

                    }
                });
        Log.i(TAG, "convert: " + item);
    }


}
