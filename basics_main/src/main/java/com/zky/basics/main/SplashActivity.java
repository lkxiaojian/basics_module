package com.zky.basics.main;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zky.basics.common.mvvm.BaseMvvmActivity;
import com.zky.basics.main.mvvm.factory.MainViewModelFactory;
import com.zky.basics.main.mvvm.viewmodel.SplashViewModel;


public class SplashActivity extends BaseMvvmActivity<ViewDataBinding, SplashViewModel> {

    @Override
    public int onBindLayout() {
        return R.layout.activity_splash;
    }

    @SuppressLint("CheckResult")
    @Override
    public void initView() {
                        handler.sendEmptyMessageDelayed(1, 2000);

//        new RxPermissions(this).request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .subscribe(permission -> {
//                    if (permission) {
//                        handler.sendEmptyMessageDelayed(1, 2000);
//                        //同意sd 权限后创建room 数据库
//                        TestRoomDbDao testRoomDbDao = AppDatabase.getDatabase(this).testRoomDbDao();
//                        TestRoomDb testRoomDb = new TestRoomDb();
//                        testRoomDb.setAge(1);
//                        testRoomDb.setName("name");
//                        testRoomDb.setU_id(3);
//                        testRoomDb.setType("3");
//                        testRoomDbDao.insertAll(testRoomDb);
//                        List<TestRoomDb> all = testRoomDbDao.getAll();
//                        System.out.println(all);
//
//                    } else {
//                        ToastUtil.showToast("读取sd卡权限被拒绝");
//                    }
//                });

    }

    @Override
    public boolean enableToolbar() {
        return false;
    }

    @Override
    public void initData() {
//        mViewModel.login();
    }

    public void startMainActivity() {

        ARouter.getInstance().build("/app/login", "app").navigation();

//        startActivity(new Intent(this, LoginActivity.class));
        finishActivity();
    }

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
        mViewModel.getmVoidSingleLiveEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String aVoid) {
                startMainActivity();
            }
        });
    }

    @Override
    public int onBindVariableId() {
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
        handler = null;
        finish();
    }

    @Override
    public Boolean isFullScreen() {
        return true;
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startMainActivity();
        }
    };


}