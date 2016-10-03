package com.brioal.settingview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.brioal.settingview.adapter.SettingLayoutManager;
import com.brioal.settingview.adapter.SettingViewAdapter;
import com.brioal.settingview.entity.SettingEntity;

import java.util.List;

/**
 * Created by Brioal on 2016/10/3.
 */

public class SettingView extends RecyclerView {
    private Context mContext;

    public SettingView(Context context) {
        super(context);
        this.mContext = context;

    }

    public SettingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setData(List<SettingEntity> list) {
        setLayoutManager(new SettingLayoutManager(mContext));
        setAdapter(new SettingViewAdapter(mContext, list));
    }

}
