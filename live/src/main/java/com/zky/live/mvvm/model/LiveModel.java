package com.zky.live.mvvm.model;

import android.app.Application;
import com.zky.basics.api.RetrofitManager;
import com.zky.basics.api.apiservice.CommonService;
import com.zky.basics.api.dto.RespDTO;
import com.zky.basics.api.http.RxAdapter;
import com.zky.basics.api.mine.entity.Userinfo;
import com.zky.basics.api.mine.service.MineService;
import com.zky.basics.common.mvvm.model.BaseModel;
import io.reactivex.Observable;

/**
 * Created by lk
 * Date 2019-11-08
 * Time 10:55
 * Detail:
 */
public class LiveModel extends BaseModel {
    private CommonService mCommonService;
    private MineService mineService;


    public LiveModel(Application application) {
        super(application);
        mCommonService = RetrofitManager.getInstance().getCommonService();
        mineService = RetrofitManager.getInstance().getMineService();

    }

    public Observable<RespDTO> updateUserPassword(String oprationType, String phone, String oldPassword, String password, String smsCode) {
        return mCommonService.updateUserPassword(oprationType, phone, oldPassword, password, smsCode)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }

    public Observable<RespDTO<Userinfo>> getUser(String phone) {
        return mCommonService.getUser(phone)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }



}
