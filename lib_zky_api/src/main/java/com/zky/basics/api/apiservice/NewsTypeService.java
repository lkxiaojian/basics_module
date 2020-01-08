package com.zky.basics.api.apiservice;


import com.zky.basics.api.config.API;
import com.zky.basics.api.dto.RespDTO;
import com.zky.basics.api.newstype.entity.NewsType;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;

public interface NewsTypeService {
    @POST(API.URL_HOST + "/newstype/query/all")
    Observable<RespDTO<List<NewsType>>> getListNewsType(@Header("Authorization") String tolen);

    @GET(API.URL_HOST + "/newstype/{id}/delete")
    Observable<RespDTO> deleteNewsTypeById(@Header("Authorization") String tolen, @Path("id") int id);

    @POST(API.URL_HOST + "/newstype/save")
    Observable<RespDTO<NewsType>> addNewsType(@Header("Authorization") String tolen, @Body NewsType type);
}
