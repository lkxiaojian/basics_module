package com.zky.basics.api.apiservice;

import com.zky.basics.api.dto.RespDTO;
import com.zky.basics.api.mine.entity.Userinfo;
import com.zky.basics.api.splash.RegionOrSchoolBean;
import com.zky.basics.api.user.OssToken;
import com.zky.basics.api.user.entity.UpdataBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface CommonService {
    @GET("login.do")
    Observable<RespDTO<Userinfo>> login(@Query("phone") String phone, @Query("password") String pwd);

    //获取最新app信息
    @GET("getAppInfo.do")
    Observable<RespDTO<UpdataBean>> getAppInfo();


    //忘记密码
    @GET("updateUserPassword.do")
    Observable<RespDTO> updateUserPassword(@Query("oprationType") String oprationType,
                                           @Query("phone") String phone,
                                           @Query("oldPassword") String oldPassword,
                                           @Query("password") String password,
                                           @Query("smsCode") String smsCode
    );

    @GET("getUser.do")
    Observable<RespDTO<Userinfo>> getUser(@Query("phone") String phone);

    //获取app token
    @GET("getAppToken.do")
    Observable<RespDTO<OssToken>> getAppToken(@Query("phone") String phone, @Query("password") String password);

    //等级列表省市 县学校
    @GET("getRegionOrSchool.do")
    Observable<RespDTO<List<RegionOrSchoolBean>>> getRegionOrSchool(@Query("regLevel") String regLevel, @Query("regCode") String regCode);


    @GET("getSchoolDownload.do")
    Observable<RespDTO<Object>> getSchoolDownload(@Query("schoolId") String schoolId);



    @POST("deleteProjectFile.do")
    Observable<RespDTO> deleteProjectFile(@Query("code") String code);


}
