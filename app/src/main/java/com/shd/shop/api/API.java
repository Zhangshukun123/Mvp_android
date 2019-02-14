package com.shd.shop.api;

import com.shd.shop.entity.RegisterModel;
import com.shd.shop.entity.UserModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;


public interface API {

    /***
     * 注册接口
     */
//    @Headers(CACHE_CONTROL_NETWORK)
    @POST("login/register")
    Observable<RegisterModel> register(@QueryMap Map<String, String> urlMap, @Body RequestBody body);

    /**
     * 登陆接口
     */
//    @Headers(CACHE_CONTROL_NETWORK)
    @POST("login/login")
    Observable<UserModel> login(@QueryMap Map<String, String> urlMap, @Body RequestBody body);

}
