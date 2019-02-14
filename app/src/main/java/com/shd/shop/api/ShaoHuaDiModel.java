package com.shd.shop.api;

import android.text.TextUtils;


import com.shd.shop.api.http.AESOperator;
import com.shd.shop.base.global.AppConfig;
import com.shd.shop.base.global.Contanls;
import com.shd.shop.entity.UserModel;
import com.shd.shop.utils.UrLMdUtlis;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

public class ShaoHuaDiModel {

    private API api;

    @Inject
    public ShaoHuaDiModel(API api) {
        this.api = api;
    }

    private RequestBody getBody(String parameter) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), parameter);
    }

    //接口=======================
    private Map<String, String> getUrlMap(String parameter) {
        Map<String, String> map = new HashMap<>();
        long time = System.currentTimeMillis();
        String lol = "\"\"";
        if (!TextUtils.isEmpty(parameter)) {
            lol = UrLMdUtlis.digest(parameter, "MD5");
        }
        String skey = UrLMdUtlis.generateSignature(AppConfig.net_appid, AppConfig.net_token, lol, time);
        map.put("a", AppConfig.net_appid);
        map.put("t", String.valueOf(time));
        map.put("l", lol);
        map.put("s", skey);
        return map;
    }


    /**
     * 登录
     *
     * @param phone    账号
     * @param password 密码
     */
    public Observable<UserModel> login(String phone, String password, String openId) {
        JSONObject bodyParams = new JSONObject();
        try {
            if (!TextUtils.isEmpty(phone)) {
                bodyParams.put("phone", phone);
            }
            if (!TextUtils.isEmpty(password)) {
                bodyParams.put("password", password);
            }
            if (!TextUtils.isEmpty(openId)) {
                bodyParams.put("openId", openId);
            }
            bodyParams.put("productSerialNumber", Contanls.productSerialNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String encryptParams = AESOperator.getInstance().encrypt(bodyParams.toString());
        RequestBody body = getBody(encryptParams);
//        Map<String, String> queryMap =;
//        Log.i(TAG, "login: " + queryMap.toString());
        return api.login(getUrlMap(encryptParams), body);
    }


}
