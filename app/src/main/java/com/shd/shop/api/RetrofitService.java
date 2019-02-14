package com.shd.shop.api;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.Logger;
import com.shd.shop.ApplicationLike;
import com.shd.shop.api.http.LogInterceptor;
import com.shd.shop.base.global.AppConfig;
import com.shd.shop.base.global.Contanls;
import com.shd.shop.base.global.SPEngine;
import com.shd.shop.utils.NetUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Map<String, String> map = new HashMap<>();
    private static final long CACHE_STALE_SEC = 60 * 5;
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    private static final int DEFAULT_TIMEOUT = 10;

    @Inject
     RetrofitService() {
        init();
    }

    /**
     * 公共参数
     */
    private static Interceptor addQueryParameterInterceptor = chain -> {
        Request originalRequest = chain.request();
        Request request;
        String method = originalRequest.method();
//            Headers headers = originalRequest.headers();
        Headers.Builder builder = originalRequest.headers().newBuilder();
        builder.add("Content-Type", "application/json; charset=utf-8");
        builder.add("Accept", "application/json");
        builder.add("Connection", "close");
        String token = Hawk.get(Contanls.X_TOKEN);
        Log.d("请求Body", "token--->" + token);
        if (!TextUtils.isEmpty(token)) {
            builder.add("X-Token", token);
        }
        Headers headers = builder.build();

        HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                .build();
        request = originalRequest.newBuilder().url(modifiedUrl).headers(headers).build();

        return chain.proceed(request);
    };

    /**
     * 响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private static final Interceptor sRewriteCacheControlInterceptor = chain -> {
        Request request = chain.request();
        if (!NetUtil.isNetworkAvailable(ApplicationLike.getContext())) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            Logger.e("no network");
        }
        Response originalResponse = chain.proceed(request);
        if (NetUtil.isNetworkAvailable(ApplicationLike.getContext())) {
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, " + CACHE_CONTROL_CACHE)
                    .removeHeader("Pragma")
                    .build();
        }
    };
    /**
     * 初始化网络通信服务
     */
    public Retrofit init() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        File httpCacheDirectory = new File(ApplicationLike.getContext().getCacheDir(), "okhttpCache");
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        httpClientBuilder
                .addInterceptor(new LogInterceptor(map))
                .addInterceptor(addQueryParameterInterceptor)
                .addInterceptor(sRewriteCacheControlInterceptor)
                .addNetworkInterceptor(sRewriteCacheControlInterceptor)
                .cache(cache)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return new Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AppConfig.domain)
                .build();
    }

}
