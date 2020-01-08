package com.zky.basics.common.mvp.view;

import com.zky.basics.common.mvp.contract.BaseRefreshContract;

import java.util.List;

/**
 * Description: <BaseRefreshView><br>
 *
 * Date:        2018/2/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public interface BaseRefreshView<T> extends BaseRefreshContract.View {
    //刷新数据
    void refreshData(List<T> data);
    //加载更多
    void loadMoreData(List<T> data);
}
