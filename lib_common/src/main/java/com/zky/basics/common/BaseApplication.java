package com.zky.basics.common;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.Stetho;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.utils.UpdateUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zky.basics.common.util.OKHttpUpdateHttpService;
import com.zky.basics.common.util.log.KLog;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

import static com.xuexiang.xupdate.entity.UpdateError.ERROR.CHECK_NO_NEW_VERSION;

public class BaseApplication extends Application {
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        KLog.init(BuildConfig.IS_DEBUG);
        //web 调试
        Stetho.initializeWithDefaults(this);
        //ali 路由
        if (BuildConfig.IS_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
        initOKHttpUtils();
        initUpdate();

    }

    public static BaseApplication getInstance() {
        return mApplication;
    }

    //app 更新
    private void initUpdate() {
        //设置版本更新出错的监听
        XUpdate.get()
                .debug(true)
                .isWifiOnly(true)                                               //默认设置只在wifi下检查版本更新
                .isGet(true)                                                    //默认设置使用get请求检查版本
                .isAutoMode(false)                                              //默认设置非自动模式，可根据具体使用配置
                .param("versionCode", UpdateUtils.getVersionCode(this))  //设置默认公共请求参数
                .param("appKey", getPackageName())
                .setOnUpdateFailureListener(error -> {
                    if (error.getCode() != CHECK_NO_NEW_VERSION) {
                        //对不同错误进行处理

                    }
                })
                .supportSilentInstall(true)                                     //设置是否支持静默安装，默认是true
                .setIUpdateHttpService(new OKHttpUpdateHttpService())           //这个必须设置！实现网络请求功能。
                .init(this);                                          //这个必须初始化

    }

    private void initOKHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
                .readTimeout(20000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

}
