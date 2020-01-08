package com.zky.basics.common

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.app.Service
import android.content.Context
import android.os.Process
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.stetho.Stetho
import com.xuexiang.xupdate.XUpdate
import com.xuexiang.xupdate.entity.UpdateError.ERROR.CHECK_NO_NEW_VERSION
import com.zhy.http.okhttp.OkHttpUtils
import com.zky.basics.common.util.OKHttpUpdateHttpService
import com.zky.basics.common.util.dagger.AppInjector
import com.zky.basics.common.util.log.KLog
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by lk
 * Date 2019-11-04
 * Time 16:28
 * Detail:
 */
class BaseKotlinApplication : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

    //Service注入
    override fun serviceInjector(): AndroidInjector<Service> = dispatchingServiceInjector

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    //activity注入
    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        mApplication = this
        MultiDex.install(this)
        if (true) {
            KLog.init(BuildConfig.IS_DEBUG)
            Stetho.initializeWithDefaults(this)
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.init(this)
            AppInjector.init(this)
            initOKHttpUtils()
            initUpdate()
        }



    }

    companion object {
        @JvmStatic
        private var mApplication: BaseKotlinApplication? = null

        @JvmStatic
        fun getInstance(): BaseKotlinApplication {
            return mApplication!!
        }
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)


    }

    private fun shouldInit(): Boolean {
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val processInfos = am.runningAppProcesses
        val mainProcessName = applicationInfo.processName
        val myPid = Process.myPid()
        for (info in processInfos) {
            if (info.pid == myPid && mainProcessName == info.processName) {
                return true
            }
        }
        return false
    }


    private fun initUpdate() {
        XUpdate.get()
            .debug(true)
            .isWifiOnly(true)
            .isGet(true)
            .isAutoMode(false)
//            .param("versionCode", UpdateUtils.getVersionCode(this))
//            .param("appKey", packageName)
            .setOnUpdateFailureListener { error ->
                //设置版本更新出错的监听
                if (error.code != CHECK_NO_NEW_VERSION) {          //对不同错误进行处理
                }
            }
            .supportSilentInstall(true)
            .setIUpdateHttpService(OKHttpUpdateHttpService())
            .init(this)

    }

    private fun initOKHttpUtils() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(20000L, TimeUnit.MILLISECONDS)
            .readTimeout(20000L, TimeUnit.MILLISECONDS)
            .build()
        OkHttpUtils.initClient(okHttpClient)
    }

}