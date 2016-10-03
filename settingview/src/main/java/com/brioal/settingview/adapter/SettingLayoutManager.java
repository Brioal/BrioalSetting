package com.brioal.settingview.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Brioal on 2016/10/3.
 */

public class SettingLayoutManager extends LinearLayoutManager {
    private Context mContext;
    public SettingLayoutManager(Context context) {
        super(context);
        this.mContext = context;
    }

    public SettingLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.mContext = context;
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        super.onMeasure(recycler, state, widthSpec, heightSpec);
        int width = View.MeasureSpec.getSize(widthSpec);
        float itemHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 65, mContext.getResources().getDisplayMetrics());
        int height = (int) (getItemCount() * itemHeight);
        setMeasuredDimension(width,height);
    }
}
