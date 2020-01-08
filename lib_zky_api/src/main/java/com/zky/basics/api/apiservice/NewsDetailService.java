package com.zky.basics.api.apiservice;


import com.zky.basics.api.config.API;
import com.zky.basics.api.dto.RespDTO;
import com.zky.basics.api.news.entity.NewsDetail;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;

public interface NewsDetailService {
    @POST(API.URL_HOST + "/newsdetail/query/all")
    Observable<RespDTO<List<NewsDetail>>> getListNewsDetailByType(@Header("Authorization") String tolen, @Query("typid") int typeid);

    @GET(API.URL_HOST + "/newsdetail/{id}/detail")
    Observable<RespDTO<NewsDetail>> getNewsDetailById(@Header("Authorization") String tolen, @Path("id") int id);

    @POST(API.URL_HOST + "/newsdetail/save")
    Observable<RespDTO<NewsDetail>> addNewsDetail(@Header("Authorization") String tolen, @Body NewsDetail newsDetail);
}
