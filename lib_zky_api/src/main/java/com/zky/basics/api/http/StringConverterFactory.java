package com.zky.basics.api.http;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by lk
 * Date 2019-11-13
 * Time 16:19
 * Detail:
 */
public class StringConverterFactory extends Converter.Factory {

    public static final StringConverterFactory INSTANCE = new StringConverterFactory();

    public static StringConverterFactory create() {
        return INSTANCE;
    }
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {


//        if (type == String.class) {
            return StringResponseBodyConverter.INSTANCE;
//        }
        //其它类型我们不处理，返回null就行
//        return null;
    }

}
