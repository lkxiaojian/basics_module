package com.zky.basics.common.binding.viewadapter.recycleview;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Description: <ViewAdapter><br>
 *
 * Date:        2019/7/4<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ViewAdapter {
    @BindingAdapter({"linearLayoutManager"})
    public static void setLinearLayoutManager(RecyclerView recyclerView,boolean b) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        layoutManager.setOrientation(b?LinearLayoutManager.HORIZONTAL:LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}
