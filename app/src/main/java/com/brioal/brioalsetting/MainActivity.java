package com.brioal.brioalsetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.brioal.settingview.adapter.SettingViewAdapter;
import com.brioal.settingview.entity.SettingEntity;
import com.brioal.settingview.interfaces.OnItemClickListener;
import com.brioal.settingview.interfaces.OnSwitchChangedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    private List<SettingEntity> mList;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        mList.add(new SettingEntity("查找手环", null, null).setItemClickListener(new OnItemClickListener() {
            @Override
            public void clicked(SettingEntity entity) {
                showToast("查找手环");
            }
        }));
        mList.add(new SettingEntity("佩戴方式", null, "左手").setItemClickListener(new OnItemClickListener() {
            @Override
            public void clicked(SettingEntity entity) {
                showToast("佩戴方式选择");
            }
        }));
        mList.add(new SettingEntity("手环显示设置", "设置信息是否在手环上显示", null).setItemClickListener(new OnItemClickListener() {
            @Override
            public void clicked(SettingEntity entity) {
                showToast("显示信息设置");
            }
        }));
        mList.add(new SettingEntity("时间样式", "选择时间显示样式", null).setItemClickListener(new OnItemClickListener() {
            @Override
            public void clicked(SettingEntity entity) {
                showToast("时间样式选择");
            }
        }));
        mList.add(new SettingEntity("抬腕亮屏幕", "抬起手腕查看手环信息", null).setChecked(true).setSwitchChangedListener(new OnSwitchChangedListener() {
            @Override
            public void change(boolean checked) {
                if (checked) {
                    showToast("抬腕显示开关打开");
                } else {
                    showToast("抬腕显示开关关闭");
                }
            }
        }));
        mList.add(new SettingEntity("心率辅助睡眠监测", "用以提高睡眠监测精度(开启会降低续航时长)", null).setChecked(false).setSwitchChangedListener(new OnSwitchChangedListener() {
            @Override
            public void change(boolean checked) {
                if (checked) {
                    showToast("心率监测辅助开启");

                } else {
                    showToast("心率监测辅助关闭");
                }
            }
        }));
        mList.add(new SettingEntity("玩转小米手环2", null, null).setItemClickListener(new OnItemClickListener() {
            @Override
            public void clicked(SettingEntity entity) {
                showToast("玩转小米手环2");
            }
        }));
        mList.add(new SettingEntity("固件版本号", null, "V1.0.0.39"));
        mList.add(new SettingEntity("手环MAC地址", null, "FA:83:CB:51:16:26"));
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SettingViewAdapter(this, mList));
    }

    public void showToast(String tip) {
        if (mToast == null) {
            mToast = Toast.makeText(this, tip, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(tip);
        }
        mToast.show();
    }
}
