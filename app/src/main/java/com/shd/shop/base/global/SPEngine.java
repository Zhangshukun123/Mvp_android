package com.shd.shop.base.global;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.shd.shop.ApplicationLike;
import com.shd.shop.entity.UserModel;
import com.shd.shop.utils.L;


/**
 * Created by Administrator on 2017/5/27.
 */

public class SPEngine {
    private static SPEngine spEngine = new SPEngine();

    public static SPEngine getSPEngine() {
        return spEngine;
    }

    @SuppressLint("CommitPrefEdits")
    private SPEngine() {
        sharedPreferences = ApplicationLike.getContext().getSharedPreferences("commondata", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        loadInfo();
    }

    /**
     * 加载需要进入内存的信息
     */
    private void loadInfo() {
        loginState = sharedPreferences.getBoolean("loginState", false);
        recordKeyboardHeight = sharedPreferences.getInt("recordKeyboardHeight", 600);

        WX_code = sharedPreferences.getString("WX_code", "");
        WX_access_token = sharedPreferences.getString("WX_access_token", "");
        WX_refresh_token = sharedPreferences.getString("WX_refresh_token", "");
        WX_wxopenid = sharedPreferences.getString("WX_wxopenid", "");

        isFirst = sharedPreferences.getBoolean("isFirst", true);
        isFirstMain = sharedPreferences.getBoolean("isFirstMain", true);
        {//加载用户信息
            try {
                String str = sharedPreferences.getString("userModel", "");
                L.d("xxx", "用户信息：" + str);
                if (!TextUtils.isEmpty(str)) {
                    userModel = new Gson().fromJson(str, UserModel.class);
                }
            } catch (Exception e) {
                L.d("加载用户信息失败" + e.toString());
            }
            if (null == userModel || null == userModel.data) {
//                L.d("用户数据为空");
//                userModel = new UserModel();
//                userModel.data = new UserModel.DataBean();
//                setUserModel(userModel);
//                setLoginState(false);
            }
        }
    }


    private SharedPreferences sharedPreferences;
    private Editor editor;
    private boolean loginState;
    private int recordKeyboardHeight;//记录的软键盘高度
    private boolean isFirst; //是否第一次启动app
    private boolean isFirstMain; //是否第一次启动app

    private String WX_code;//微信授权code
    private String WX_access_token;//微信access_token
    private String WX_refresh_token;//微信
    private String WX_wxopenid;//微信

    private UserModel userModel;//用户信息

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
        editor.putBoolean("isFirst", first).apply();
    }

    public boolean isFirstMain() {
        return isFirstMain;
    }

    public void setFirstMain(boolean firstMain) {
        isFirstMain = firstMain;
        editor.putBoolean("isFirstMain", isFirstMain).apply();
    }

    public String getLanguage() {
        return sharedPreferences.getString("language", "zh_CN");
    }

    public void setLanguage(String language) {
        editor.putString("language", language).apply();
    }

    //是否为登录状态
    public boolean isLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
        editor.putBoolean("loginState", loginState).apply();
    }

    public int getRecordKeyboardHeight() {
        return recordKeyboardHeight;
    }

    public void setRecordKeyboardHeight(int recordKeyboardHeight) {
        this.recordKeyboardHeight = recordKeyboardHeight;
        editor.putInt("recordKeyboardHeight", recordKeyboardHeight).apply();
    }

    public String getWX_code() {
        return WX_code;
    }

    public void setWX_code(String WX_code) {
        this.WX_code = WX_code;
        editor.putString("WX_code", WX_code).apply();
    }

    public String getWX_access_token() {
        return WX_access_token;
    }

    public void setWX_access_token(String WX_access_token) {
        this.WX_access_token = WX_access_token;
        editor.putString("WX_access_token", WX_access_token).apply();
    }

    public String getWX_refresh_token() {
        return WX_refresh_token;
    }

    public void setWX_refresh_token(String WX_refresh_token) {
        this.WX_refresh_token = WX_refresh_token;
        editor.putString("WX_refresh_token", WX_refresh_token).apply();
    }

    public String getWX_wxopenid() {
        return WX_wxopenid;
    }

    public void setWX_wxopenid(String WX_wxopenid) {
        this.WX_wxopenid = WX_wxopenid;
        editor.putString("WX_wxopenid", WX_wxopenid).apply();
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        try {
            if (null != userModel && null != userModel.data) {
                this.userModel = userModel;
                editor.putString("userModel", new Gson().toJson(userModel)).apply();
                UserConfig.setXToken(ApplicationLike.getContext(),userModel.data.token);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 清除用户信息,只保留手机
     */
    public void clearUserInfo() {
//        try {
//            UserModel model = new UserModel();
//            model.data = new UserModel.DataBean();
//            model.data.phone = userModel.data.phone;
//            setUserModel(model);
//        }catch (Exception e){}
    }
}



