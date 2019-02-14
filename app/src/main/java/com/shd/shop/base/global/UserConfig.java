package com.shd.shop.base.global;

import android.content.Context;

import com.shd.shop.utils.SharedPreferencesUtils;


/**
 * 用户个性化配置
 * Created by 陈自强 on 2017/8/14 0014.
 */

public class UserConfig {

    public static void saveUserId(Context mContext, String userId) {
        SharedPreferencesUtils.getInstance(mContext, AppConfig.APP_SHARED_ID).put(AppConfig.USER_ID, userId);
    }

    public static String getUserId(Context mContext) {
        return SharedPreferencesUtils.getInstance(mContext, AppConfig.APP_SHARED_ID).getString(AppConfig.USER_ID);
    }

    public static String getXToken(Context mContext) {
        String token = (String) SharedPreferencesUtils.getInstance(mContext, AppConfig.APP_SHARED_ID).get(AppConfig.USER_TOKEN, "");
        return token;
    }

    public static void setXToken(Context mContext, String xToken) {
        SharedPreferencesUtils.getInstance(mContext, AppConfig.APP_SHARED_ID).put(AppConfig.USER_TOKEN, xToken);
    }

//    public static UserInfoResultEntity getUserInfo(Context mContext) {
//        return new UserDao().findById(UserConfig.getUserId(mContext));
//    }
//
//    public static void userInfoUpData(UserInfoResultEntity entity) {
//        UserDao dao = new UserDao();
//        dao.update(entity);
//    }
}
