package com.zky.basics.api.map;

import com.zky.basics.api.dto.RespDTO;
import com.zky.basics.api.map.entity.JYBSchool;
import com.zky.basics.api.map.entity.ProjectCountBean;
import com.zky.basics.api.map.entity.SchoolProjectBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by lk
 * Date 2019-11-14
 * Time 15:43
 * Detail:
 */
public interface MapService {
    @GET("getNotComplicatedQuery.do")
    Observable<RespDTO<JYBSchool>> getNotComplicatedQuery(@Query("pageIndex") int pageIndex,
                                                          @Query("pageSize") int pageSize,
                                                          @Query("orgPro") String orgPro,
                                                          @Query("orgCity") String orgCity,
                                                          @Query("orgCounty") String orgCounty,
                                                          @Query("schoolName") String schoolName);


    @GET("getAppGpsLocation.do")
    Observable<RespDTO<List<JYBSchool.Data>>> getAppGpsLocation(
            @Query("orgPro") String orgPro,
            @Query("orgCity") String orgCity,
            @Query("orgCounty") String orgCounty,
            @Query("schoolName") String schoolName);

    /**
     * 学校信息 查询
     *
     * @param schoolId
     * @return
     */
    @GET("getAppNotComplicatedQuerySchoolInformation.do")
    Observable<RespDTO<Object>> getAppNotComplicatedQuerySchoolInformation(
            @Query("schoolId") String schoolId);


    /**
     * 基本信息查询
     *
     * @param schoolId
     * @return
     */

    @GET("getAppComplicatedQueryBasicInformation.do")
    Observable<RespDTO<Object>> getAppComplicatedQueryBasicInformation(
            @Query("schoolId") String schoolId);


    @POST("uploadSchoolLocation.do")
    Observable<RespDTO<Object>> uploadSchoolLocation(
            @Query("schoolId") String schoolId,
            @Query("longitude") String longitude,
            @Query("latitude") String latitude
    );


    @GET("getSchoolProjectNum.do")
    Observable<RespDTO<List<ProjectCountBean>>> getSchoolProjectNum(
            @Query("schoolId") String schoolId
    );


    @GET("getSchoolProject.do")
    Observable<RespDTO<List<SchoolProjectBean>>> getSchoolProject(
            @Query("schoolId") String schoolId,
            @Query("xmType") String xmType
    );
}
