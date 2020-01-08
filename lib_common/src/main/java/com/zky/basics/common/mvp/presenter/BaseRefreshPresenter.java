package com.zky.basics.common.mvp.presenter;

import android.content.Context;

import com.zky.basics.common.mvp.contract.BaseRefreshContract;
import com.zky.basics.common.mvp.view.BaseRefreshView;
import com.zky.basics.common.mvp.model.BaseModel;

/**
 * Description: <BaseRefreshPresenter><br>
 *
 * Date:        2018/2/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public abstract class BaseRefreshPresenter<M extends BaseModel,V extends BaseRefreshView<T>,T> extends BasePresenter<M,V> implements BaseRefreshContract.Presenter {

    public BaseRefreshPresenter(Context context, V view, M model) {
        super(context, view, model);
    }
}
