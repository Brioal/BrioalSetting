package com.brioal.settingview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.brioal.settingview.R;
import com.brioal.settingview.entity.SettingEntity;

import java.util.List;

/**
 * Created by Brioal on 2016/9/13.
 */
public class SettingViewAdapter extends RecyclerView.Adapter<SettingViewAdapter.SettingViewHolder> {
    private Context mContext;
    private List<SettingEntity> mList;

    public SettingViewAdapter(Context context, List<SettingEntity> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public SettingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SettingViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_setting, parent, false));
    }

    @Override
    public void onBindViewHolder(final SettingViewHolder holder, int position) {
        final SettingEntity entity = mList.get(position);
        if (entity.isSwitchEnable()) { //允许开关
            if (entity.isChecked()) {
                holder.mSwitch.setChecked(true);
            } else {
                holder.mSwitch.setChecked(false);
            }
            holder.mSwitch.setVisibility(View.VISIBLE);
            if (entity.getSwitchChangedListener() != null) {
                holder.mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        entity.getSwitchChangedListener().change(isChecked);
                    }
                });
            }
            holder.mBtnMore.setVisibility(View.GONE); //更多不显示
            holder.mTvValue.setVisibility(View.GONE);//当前值不显示
        }

        //Desc 显示
        if (entity.getDesc() != null && !entity.getDesc().isEmpty()) {//存在描述的时候显示
            holder.mTvDesc.setText(entity.getDesc());
        } else {
            holder.mTvDesc.setVisibility(View.GONE);
        }
        //Title显示
        holder.mTvTitle.setText(entity.getTitle()); //显示标题

        //BtnMore显示  无点击事件时候不显示
        if (entity.getItemClickListener() == null) {
            holder.mBtnMore.setVisibility(View.GONE);
        } else {
            holder.mBtnMore.setVisibility(View.VISIBLE);
        }
        //Value 显示  无当前值得时候不显示
        if (entity.getCurrentValue() != null && !entity.getCurrentValue().isEmpty()) {
            holder.mTvValue.setText(entity.getCurrentValue());
        } else {
            holder.mTvValue.setVisibility(View.GONE);
        }

        //点击时间设置
        if (entity.getItemClickListener() != null || entity.getSwitchChangedListener() != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (entity.getItemClickListener() != null) {
                        entity.getItemClickListener().clicked(entity);
                    }
                    if (entity.isSwitchEnable()) {
                        if (holder.mSwitch.isChecked()) {
                            holder.mSwitch.setChecked(false);
                        } else {
                            holder.mSwitch.setChecked(true);
                        }
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class SettingViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTitle; //标题
        TextView mTvDesc;//描述
        TextView mTvValue; //当前值
        Switch mSwitch; //开关
        ImageButton mBtnMore; //更多

        View itemView;

        public SettingViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.item_setting_tv_title);
            mTvDesc = (TextView) itemView.findViewById(R.id.item_setting_tv_desc);
            mTvValue = (TextView) itemView.findViewById(R.id.item_setting_tv_value);
            mSwitch = (Switch) itemView.findViewById(R.id.item_setting_switch);
            mBtnMore = (ImageButton) itemView.findViewById(R.id.item_setting_btn_more);
            this.itemView = itemView;
        }
    }
}
