package com.zky.basics.main.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xuexiang.xupdate.XUpdate;
import com.zky.basics.api.config.API;
import com.zky.basics.common.BR;
import com.zky.basics.common.mvvm.BaseMvvmActivity;
import com.zky.basics.common.util.Contants;
import com.zky.basics.main.MainActivity;
import com.zky.basics.main.R;
import com.zky.basics.main.databinding.ActivityLoginBinding;
import com.zky.basics.main.mvvm.factory.MainViewModelFactory;
import com.zky.basics.main.mvvm.viewmodel.SplashViewModel;

@Route(path = "/app/login", group = "app")
public class LoginActivity extends BaseMvvmActivity<ActivityLoginBinding, SplashViewModel> {

    @Override
    public Class<SplashViewModel> onBindViewModel() {
        return SplashViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MainViewModelFactory.getInstance(getApplication());
    }

    @Override
    public void initViewObservable() {
        //check app versionCode if versionCode less than server versionCode  then  app update

        XUpdate.newBuild(this)
                .updateUrl(API.URL_APP_UPDATE)
                .isWifiOnly(false)
                .updateAppUrl(API.ImageFolderPath)
                .update();

        mViewModel.getmVoidSingleLiveEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String aVoid) {
                //online login
                if ("login".equals(aVoid)) {
                    Contants.isNet = true;
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    showTransLoadingView(false);
                    finishActivity();
                } else if ("loadShow".equals(aVoid)) {
                    showTransLoadingView(true);
                } else if ("noNet".equals(aVoid)) {
                    //school level can offline login
                    Contants.isNet = false;
                    ARouter.getInstance().build("/app/mine", "mine").navigation();
                    showTransLoadingView(false);
                    finishActivity();
                } else if("miss".equals(aVoid)){
                    showTransLoadingView(false);
                }


            }
        });
    }


    @Override
    public int onBindVariableId() {
        return BR.loginViewModel;
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_login;
    }


    @Override
    public boolean enableToolbar() {
        return false;
    }

    @Override
    public Boolean isFullScreen() {
        return true;
    }


}
