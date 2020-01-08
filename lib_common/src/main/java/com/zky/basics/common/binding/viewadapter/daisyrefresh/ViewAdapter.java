package com.zky.basics.common.binding.viewadapter.daisyrefresh;

import android.databinding.BindingAdapter;
import com.refresh.lib.DaisyRefreshLayout;
import com.zky.basics.common.binding.command.BindingCommand;

/**
 * Description: <ViewAdapter><br>
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onRefreshCommand","onLoadMoreCommand","onAutoRefreshCommand"},requireAll = false)
    public static void onRefreshCommand(DaisyRefreshLayout refreshLayout, final BindingCommand onRefreshCommand,final BindingCommand onLoadMoreCommond,final BindingCommand onAutoRerefeshCommond) {
        refreshLayout.setOnRefreshListener(() -> {
            if (onRefreshCommand != null) {
                onRefreshCommand.execute();
            }
        });
        refreshLayout.setOnLoadMoreListener(() -> {
            if (onLoadMoreCommond != null) {
                onLoadMoreCommond.execute();
            }
        });
        refreshLayout.setOnAutoLoadListener(() -> {
            if (onAutoRerefeshCommond != null) {
                onAutoRerefeshCommond.execute();
            }
        });
    }
}
