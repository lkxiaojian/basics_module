package com.zky.basics.api.http;

import android.widget.Toast;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.zky.basics.api.RetrofitManager;
import com.zky.basics.api.dto.ErrorDto;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

/**
 * Created by lk
 * Date 2019-11-13
 * Time 17:10
 * Detail:
 */

class StringResponseBodyConverter implements Converter<ResponseBody, Object> {
    public static final StringResponseBodyConverter INSTANCE = new StringResponseBodyConverter();


    @Override
    public Object convert(ResponseBody value) throws IOException {
        String string = value.string();
        if (string != null) {
            ErrorDto respDTO = new Gson().fromJson(string, ErrorDto.class);
            if (respDTO.code == 200) {
            } else if (respDTO.code == 408) {
                ARouter.getInstance().build("/app/login", "app").navigation();
                Toast.makeText(RetrofitManager.mContext, "长时间未操作，需要重写登入", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RetrofitManager.mContext, respDTO.msg, Toast.LENGTH_SHORT).show();
            }
        }
        return string;
    }


}