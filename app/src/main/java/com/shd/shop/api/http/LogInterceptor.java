package com.shd.shop.api.http;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class LogInterceptor implements Interceptor {
    String TAG = "ndy";
    private String content = "-1";
    private Map<String, String> map;

    public LogInterceptor(Map<String, String> map){
        super();
        this.map = map;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.e(TAG, "request:" + request.toString()+"    "+map.toString());
        long t1 = System.nanoTime();
        okhttp3.Response response = null;
        try{
            response = chain.proceed(chain.request());
        }catch (Exception e1){
            Log.e(TAG+"==========",e1+"");
        }
        long t2 = System.nanoTime();
        //LogUtils.v(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        okhttp3.MediaType mediaType = response.body().contentType();
        ResponseBody originalBody = response.body();
        if (null != originalBody) {
            try {
                content = AESOperator.getInstance().decrypt(originalBody.string());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.e(TAG,  "url-->"+request.toString()+"  response body:" + content);
        return response.
                newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();
    }
}
