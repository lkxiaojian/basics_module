package com.zky.basics.api.mine.service;

import com.zky.basics.api.dto.RespDTO;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lk
 * Date 2019-11-11
 * Time 09:36
 * Detail:
 */
public interface MineService {
    // 验证码
    @GET("updateUserByCode.do")
    Observable<RespDTO> updateUserByCode(@Query("userName") String userName,
                                         @Query("headImg") String headImg,
                                         @Query("code") String code);
}
