package com.brioal.settingview.entity;

import com.brioal.settingview.interfaces.OnItemClickListener;
import com.brioal.settingview.interfaces.OnSwitchChangedListener;

/**
 * Setting Item Entity
 * Created by Brioal on 2016/9/13.
 */
public class SettingEntity {
    private String mTitle; //标题
    private String mDesc; //描述
    private String mCurrentValue; //当前值
    private boolean isSwitchEnable = false; //是否显示开关
    private boolean isChecked = false;
    private OnItemClickListener mItemClickListener;
    private OnSwitchChangedListener mSwitchChangedListener;


    public SettingEntity(String title, String desc, String currentValue) {
        mTitle = title;
        mDesc = desc;
        mCurrentValue = currentValue;
    }
    //设置Switch默认状态
    public SettingEntity setChecked(boolean checked) {
        isChecked = checked;
        isSwitchEnable = true;
        return this;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public OnItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    public SettingEntity setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
        return this;
    }

    public OnSwitchChangedListener getSwitchChangedListener() {
        return mSwitchChangedListener;
    }

    public SettingEntity setSwitchChangedListener(OnSwitchChangedListener switchChangedListener) {
        mSwitchChangedListener = switchChangedListener;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getCurrentValue() {
        return mCurrentValue;
    }

    public void setCurrentValue(String currentValue) {
        mCurrentValue = currentValue;
    }

    public boolean isSwitchEnable() {
        return isSwitchEnable;
    }

    public void setSwitchEnable(boolean switchEnable) {
        isSwitchEnable = switchEnable;
    }
}
