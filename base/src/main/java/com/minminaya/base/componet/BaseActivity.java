package com.minminaya.base.componet;

import android.os.Bundle;

import com.trello.navi2.component.support.NaviAppCompatActivity;

import butterknife.ButterKnife;

/**
 * <p>Activity基类的封装，由于考虑到要使用RxJava，这里封装了RxLifecycle</p>
 * <p>执行顺序为1-2-3-4-5，注意使用
 * <p>Created by LGM on 2018/4/22 18:42</p>
 * <p>Email:minminaya@gmail.com</p>
 */
public abstract class BaseActivity extends NaviAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewLayout_1());
        ButterKnife.bind(this);
        initView_2();
        setListeners_3();
        bindLogic_4();
        excuteOthers_5();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBind();
    }

    /**
     * 设置布局文件
     */
    public abstract int setContentViewLayout_1();

    /**
     * 对各个View的初始化
     */
    protected abstract void initView_2();

    /**
     * view的监听器绑定
     */
    protected abstract void setListeners_3();

    /**
     * 绑定
     */
    protected abstract void bindLogic_4();

    /**
     * 必要的逻辑
     */
    protected abstract void excuteOthers_5();

    /**
     * 在onDestroy中的解绑
     */
    protected abstract void unBind();
}
