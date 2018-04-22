package com.minminaya.base.componet;

import android.os.Bundle;

import com.trello.navi2.component.support.NaviAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <p>Activity基类的封装，由于考虑到要使用RxJava，这里封装了RxLifecycle</p>
 * <p>执行顺序为1-2-3-4-5，注意使用
 * <p>Created by LGM on 2018/4/22 18:42</p>
 * <p>Email:minminaya@gmail.com</p>
 */
public abstract class BaseActivity extends NaviAppCompatActivity {
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewLayout_1());
        mUnbinder = ButterKnife.bind(this);
        initView_2();
        bindLogic_3();
        setListeners_4();
        excuteOthers_5();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBindLogic();
        mUnbinder.unbind();
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
    protected abstract void setListeners_4();

    /**
     * 绑定
     */
    protected abstract void bindLogic_3();

    /**
     * 必要的逻辑
     */
    protected abstract void excuteOthers_5();

    /**
     * 在onDestroy中的解绑
     */
    protected abstract void unBindLogic();
}
