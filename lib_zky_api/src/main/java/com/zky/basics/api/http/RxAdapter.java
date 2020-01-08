package com.zky.basics.api.http;

import android.widget.Toast;
import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.zky.basics.api.RetrofitManager;
import com.zky.basics.api.dto.RespDTO;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Description: <Rx适配器><br>
 */
public class RxAdapter {
    /**
     * 生命周期绑定
     *
     * @param lifecycle Activity
     */
    public static <T> LifecycleTransformer<T> bindUntilEvent(@NonNull LifecycleProvider lifecycle) {
        if (lifecycle != null) {
            return lifecycle.bindUntilEvent(ActivityEvent.DESTROY);
        } else {
            throw new IllegalArgumentException("context not the LifecycleProvider type");
        }
    }

    /**
     * 线程调度器
     */
    public static SingleTransformer singleSchedulersTransformer() {
        return new SingleTransformer() {
            @Override
            public SingleSource apply(Single upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static SingleTransformer singleExceptionTransformer() {

        return new SingleTransformer() {
            @Override
            public SingleSource apply(Single observable) {
                return observable
                        .map(new HandleFuc())  //这里可以取出BaseResponse中的Result
                        .onErrorResumeNext(new HttpResponseFunc());
            }
        };
    }

    /**
     * 线程调度器
     */
    public static ObservableTransformer schedulersTransformer() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static ObservableTransformer exceptionTransformer() {

        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable observable) {
                return observable
                        .map(new HandleFuc())  //这里可以取出BaseResponse中的Result
                        .onErrorResumeNext(new HttpResponseFunc());
            }
        };
    }

    private static class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
        @Override
        public Observable<T> apply(Throwable t) {
            ResponseThrowable exception = ExceptionHandler.handleException(t);
            if (exception.code == ExceptionHandler.SYSTEM_ERROR.TIMEOUT_ERROR) {
                Toast.makeText(RetrofitManager.mContext, "网络不给力哦！", Toast.LENGTH_SHORT).show();
            } else {

            }
            return Observable.error(exception);
        }
    }

    private static class HandleFuc implements Function<Object, Object> {

        @Override
        public Object apply(Object o) throws Exception {
            if (o instanceof RespDTO) {

                RespDTO respDTO = (RespDTO) o;
                if (respDTO.code == 408) {
                    //token 过期 返回登入界面
                    ARouter.getInstance().build("/app/login", "app").navigation();
                    Toast.makeText(RetrofitManager.mContext, "长时间未操作，需要重写登入", Toast.LENGTH_SHORT).show();
                }else
                if (respDTO.code != ExceptionHandler.APP_ERROR.SUCC) {
                    Toast.makeText(RetrofitManager.mContext, respDTO.msg + "", Toast.LENGTH_SHORT).show();
                }
            }
            return o;
        }
    }

}
