package com.shd.shop.server;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.util.Log;

import com.shd.shop.ApplicationLike;
import com.shd.shop.R;
import com.shd.shop.api.Agency;
import com.shd.shop.entity.OrderDate;
import com.shd.shop.utils.L;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static com.shd.shop.api.Agency.CITY_AGENCY;
import static com.shd.shop.api.Agency.COM_AGENCY;
import static com.shd.shop.api.Agency.PROVINEC_AGENCY;
import static com.shd.shop.api.Agency.SHOP_AGENCY;
import static com.shd.shop.api.Agency.SUPPLER_AGENCY;

public class DataServer {


    private Agency agency;

    private List<OrderDate> orderDates;

    @Inject
    public DataServer() {
        Log.i("123", "DataServer: " + this.toString());
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Agency getAgency() {
        return agency;
    }

    /**
     * 供货商 item
     * @return
     */
    @SuppressLint("LongLogTag")
    public List<String> supplier_item() {
        if (agency == SUPPLER_AGENCY) {
            return Arrays.asList(ApplicationLike.getContext().getResources().getStringArray(R.array.home_supplier_title));
        }
        if (agency == COM_AGENCY) {
            return Arrays.asList(ApplicationLike.getContext().getResources().getStringArray(R.array.home_com_title));
        }
        if (agency == SHOP_AGENCY) {
            return Arrays.asList(ApplicationLike.getContext().getResources().getStringArray(R.array.home_shop_title));
        }
        if (agency == PROVINEC_AGENCY) {
            return Arrays.asList(ApplicationLike.getContext().getResources().getStringArray(R.array.home_pro_title));
        }
        if (agency == CITY_AGENCY) {
            return Arrays.asList(ApplicationLike.getContext().getResources().getStringArray(R.array.home_city_title));
        }
        return null;
    }

    /**
     * 供货商 icom
     *
     * @return
     */
    public List<Integer> supplier_icon() {
        List<Integer> array = new ArrayList<>();
        if (agency == SUPPLER_AGENCY) {
            array.add(R.drawable.zijin);
            array.add(R.drawable.tixian);
            array.add(R.drawable.fensi);
            array.add(R.drawable.yinhangka);
            array.add(R.drawable.shezhi);
        }
        if ((agency == COM_AGENCY)) {
            array.add(R.drawable.zijin);
            array.add(R.drawable.tixian);
            array.add(R.drawable.fensi);
            array.add(R.drawable.shanghu);
            array.add(R.drawable.yinhangka);
            array.add(R.drawable.shezhi);
        }
        if ((agency == PROVINEC_AGENCY)) {
            array.add(R.drawable.zijin);
            array.add(R.drawable.tixian);
            array.add(R.drawable.fensi);
            array.add(R.drawable.shidai);
            array.add(R.drawable.yinhangka);
            array.add(R.drawable.shezhi);
        }
        if (agency == CITY_AGENCY) {
            array.add(R.drawable.zijin);
            array.add(R.drawable.tixian);
            array.add(R.drawable.fensi);
            array.add(R.drawable.shidai);
            array.add(R.drawable.yinhangka);
            array.add(R.drawable.shezhi);
        }
        if (agency == SHOP_AGENCY) {
            array.add(R.drawable.dingdan);
            array.add(R.drawable.shouyi);
            array.add(R.drawable.tixian_shop);
            array.add(R.drawable.fensi_shop);
            array.add(R.drawable.xiaoxi);
            array.add(R.drawable.erweima);
            array.add(R.drawable.yinhangka_shop);
            array.add(R.drawable.dianpu_shop);
            array.add(R.drawable.shezhi_shop);
        }
        return array;
    }

    /**
     * 我的订单数据
     *
     * @return
     */
    public List<OrderDate> getOrderDate() {
        if (orderDates == null) {
            orderDates = new ArrayList<>();
            orderDates.add(new OrderDate());
            orderDates.add(new OrderDate());
            orderDates.add(new OrderDate());
        }
        return orderDates;
    }
}
