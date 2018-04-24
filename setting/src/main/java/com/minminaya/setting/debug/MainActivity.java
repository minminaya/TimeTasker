package com.minminaya.setting.debug;

import android.graphics.Color;
import android.os.Bundle;

import com.minminaya.aau.utils.BarsHelper;
import com.minminaya.base.componet.BaseActivity;
import com.minminaya.setting.R;

/**
 * <p> </p>
 * <p>
 * <p>Created by LGM on 2018/4/24 20:57</p>
 * <p>Email:minminaya@gmail.com</p>
 */
public class MainActivity extends BaseActivity {
    @Override
    public int setContentViewLayout_1() {
        return R.layout.module_setting_activity_login;
    }

    @Override
    protected void initView_2(Bundle savedInstanceState) {

    }

    @Override
    protected void setListeners_4() {

    }

    @Override
    protected void bindLogic_3() {

    }

    @Override
    protected void excuteOthers_5() {
        BarsHelper.setStatusTransparentAndColor(this, Color.TRANSPARENT, 0.0f);
        BarsHelper.setNavBarVisibility(this, false);
    }

    @Override
    protected void unBindLogic() {

    }

}
