package com.shd.shop.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

public class HttpErrorToast {

    public static Throwable unifiedError(Throwable e, Context m_con) {
       L.d("OkHttp", "异常：" + e.toString());
        Throwable throwable;
        if (e instanceof UnknownHostException) {
            //无网络的情况，或者主机挂掉了。返回，对应消息  Unable to resolve host "m.app.haosou.com": No address associated with hostname
            if (!isNetworkConnected(m_con)) {
                //无网络
                throwable = new Throwable("当前没有网络连接！", e.getCause());
            } else {
                //主机挂了，也就是你服务器关了
                throwable = new Throwable("服务器开小差,请稍后重试！", e.getCause());
            }
        } else if (e instanceof ConnectException || e instanceof SocketTimeoutException || e instanceof SocketException) {
            //连接超时等
            throwable = new Throwable("网络连接超时，请检查您的网络状态！", e.getCause());
        } else if (e instanceof NumberFormatException || e instanceof IllegalArgumentException || e instanceof JsonSyntaxException) {
            //也就是后台返回的数据，与你本地定义的Gson类，不一致，导致解析异常 (ps:当然这不能跟客户这么说)
            throwable = new Throwable("服务器数据异常，攻城狮正在修复!", e.getCause());
        } else {
            //其他 未知
            throwable = new Throwable("哎呀故障了，攻城狮正在修复！", e.getCause());
        }
        return throwable;
    }


    private static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
