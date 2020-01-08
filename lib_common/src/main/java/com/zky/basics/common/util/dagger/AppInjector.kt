package com.zky.basics.common.util.dagger

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import com.zky.basics.common.BaseKotlinApplication
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector


object AppInjector {
    fun init(application: BaseKotlinApplication) {
        DaggerAppComponent.builder().application(application)
            .build().inject(application)
        application
            .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//                    fullScreen(activity)
                    activity.requestWindowFeature(Window.FEATURE_NO_TITLE)

                    handleActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {
                }

                override fun onActivityResumed(activity: Activity) {
                }

                override fun onActivityPaused(activity: Activity) {
                }

                override fun onActivityStopped(activity: Activity) {
                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
                }

                override fun onActivityDestroyed(activity: Activity) {
                    fixSoftInputLeaks(activity)
                }
            })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector || activity is Injectable) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fragmentManager: FragmentManager,
                            fragment: Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            if (fragment is Injectable) {
                                AndroidSupportInjection.inject(fragment)
                            }
                        }
                    }, true
                )
        }
    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */

//    private fun fullScreen(activity: Activity) {
//        var isSplash = activity is SplashActivity
//        if (isSplash) {
//            if (activity.intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0) {
//                activity.finish()
//                return
//            }
//        }
//        isSplash = isSplash || activity is UpdateActivity
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                var option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    val whiteStatus = activity.intent.getIntExtra("whiteStatus", 1)
//                    (whiteStatus == 0).yes {
//                        option = option or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                    } otherwise {
//                        option = option or View.SYSTEM_UI_FLAG_VISIBLE
//                    }
//                }
//                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
//                val window = activity.window
//                val decorView = window.decorView
//                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                window.statusBarColor = Color.TRANSPARENT
//                //导航栏颜色也可以正常设置
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    option = option or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
//                }
//                if (isSplash) {
//                    //隐藏虚拟导航键
//                    val uiOptions =
//                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                    option = option or uiOptions
//                }
//                window.navigationBarColor = Color.TRANSPARENT
//                decorView.systemUiVisibility = option
//            } else {
//                val window = activity.window
//                val attributes = window.attributes
//                val flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                val flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
//                attributes.flags = attributes.flags or flagTranslucentStatus
//                attributes.flags = attributes.flags or flagTranslucentNavigation
//                window.attributes = attributes
//
//                val decorView = window.decorView
//                val uiOptions =
//                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                decorView.systemUiVisibility = uiOptions
//            }
//        } else if (isSplash) {
//            val decorView = activity.window.decorView
//            decorView.systemUiVisibility = View.GONE
//        }
//    }

    private fun fixSoftInputLeaks(activity: Activity?) {
        if (activity == null) return
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
        val leakViews = arrayOf("mLastSrvView", "mCurRootView", "mServedView", "mNextServedView")
        for (leakView in leakViews) {
            try {
                val leakViewField = InputMethodManager::class.java.getDeclaredField(leakView) ?: continue
                if (!leakViewField.isAccessible) {
                    leakViewField.isAccessible = true
                }
                val obj = leakViewField.get(imm) as? View ?: continue
                if (obj.rootView === activity.window.decorView.rootView) {
                    leakViewField.set(imm, null)
                }
            } catch (ignore: Throwable) {/**/
            }

        }
    }
}
