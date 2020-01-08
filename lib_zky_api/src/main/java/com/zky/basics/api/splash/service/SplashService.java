package com.zky.basics.api.splash.service;

import com.zky.basics.api.dto.RespDTO;
import com.zky.basics.api.splash.ImageUrl;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lk
 * Date 2019-11-06
 * Time 17:49
 * Detail:
 */
public interface SplashService {
    //图形验证
    @GET("getCaptcha.do")
    Observable<RespDTO<ImageUrl>> getCaptcha();



    // 验证码
    @GET("sendSms.do")
    Observable<RespDTO> sendSms(@Query("token") String token,
                                @Query("verCode") String verCode,
                                @Query("phone") String phone,
                                @Query("smsType") String smsType);

    //组册
    @GET("regist.do")
    Observable<RespDTO> regist(@Query("userName") String userName,
                               @Query("password") String password,
                               @Query("accountLevel") String accountLevel,
                               @Query("province") String province,
                               @Query("city") String city,
                               @Query("county") String county,
                               @Query("college") String college,
                               @Query("smsCode") String smsCode,
                               @Query("phone") String phone
    );



}
