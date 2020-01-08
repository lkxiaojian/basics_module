package com.zky.basics.api;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.zky.basics.api.apiservice.CommonService;
import com.zky.basics.api.config.API;
import com.zky.basics.api.map.MapService;
import com.zky.basics.api.mine.service.MineService;
import com.zky.basics.api.splash.service.SplashService;
import com.zky.basics.api.util.SSLContextUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;


public class RetrofitManager {
    public static RetrofitManager retrofitManager;
    public static Context mContext;
    private Retrofit mRetrofit;
    public static String TOKEN="";
    OkHttpClient.Builder okHttpBuilder;

    private RetrofitManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("OKHttp----->", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder = new OkHttpClient.Builder();
//        if (TOKEN != null) {
            addToken();
//        }
        okHttpBuilder.interceptors().add(logging);

        SSLContext sslContext = SSLContextUtil.getDefaultSLLContext();
        if (sslContext != null) {
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            okHttpBuilder.sslSocketFactory(socketFactory);
        }
        okHttpBuilder.hostnameVerifier(SSLContextUtil.HOSTNAME_VERIFIER);
        mRetrofit = new Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(API.URL_HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//
    }

    public static void init(Application application) {
        mContext = application;
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    /**
     * 创建一个公共服务
     *
     * @return
     */
    public CommonService getCommonService() {
        return mRetrofit.create(CommonService.class);
    }

    /**
     * 创建登入
     *
     * @return
     */
    public SplashService getSplashService() {
        return mRetrofit.create(SplashService.class);
    }


    /**
     * 创建我的服务
     *
     * @return
     */
    public MineService getMineService() {
        return mRetrofit.create(MineService.class);
    }


    /**
     * 创建我的服务
     *
     * @return
     */
    public MapService getMapService() {
        return mRetrofit.create(MapService.class);
    }




    public void addToken() {
        if (okHttpBuilder != null)
            okHttpBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
//                            .header("Authorization", "Bearer " + token);
                            .header("token", TOKEN);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
    }
}