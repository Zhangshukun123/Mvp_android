package com.shd.shop.utils;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.shd.shop.base.global.AppConfig;


public class L {
    private static final String DEFAULT_TAG = "SHD_TAG";

    public static void e(String tag, String msg) {
        if (AppConfig.printLog) {
            if (AppConfig.logAll) {
                Logger.t(tag).e(msg);
            } else {
                Log.e(tag, msg);
            }
        }
    }

    public static void d(String msg) {
        if (AppConfig.printLog) {
            if (AppConfig.logAll) {
                Logger.t(DEFAULT_TAG).d(msg);
            } else {
                Log.d(DEFAULT_TAG, msg);
            }
        }
    }

    public static void d(String tag, String msg) {
        if (AppConfig.printLog) {
            if (AppConfig.logAll) {
                Logger.t(tag).d(msg);
            } else {
                Log.d(tag, msg);
            }
        }
    }

    public static void i(String tag, String msg) {
        if (AppConfig.printLog) {
            if (AppConfig.logAll) {
                Logger.t(tag).i(msg);
            } else {
                Log.i(tag, msg);
            }
        }
    }

    public static void w(String tag, String msg) {
        if (AppConfig.printLog) {
            if (AppConfig.logAll) {
                Logger.t(tag).w(msg);
            } else {
                Log.w(tag, msg);
            }
        }
    }
}
