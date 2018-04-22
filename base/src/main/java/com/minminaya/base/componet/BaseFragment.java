package com.minminaya.base.componet;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.navi2.component.NaviFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <p>Fragment基类的封装，由于考虑到要使用RxJava，这里封装了RxLifecycle </p>
 * <p><strong>代码生命周期从上到下严格按照执行顺序</strong></p>
 * <p>
 * <p>Created by LGM on 2018/4/22 19:15</p>
 * <p>Email:minminaya@gmail.com</p>
 */
public abstract class BaseFragment extends NaviFragment {

    /**
     * 编制已经初始化完成
     */
    private boolean isPrepared;
    private boolean isVisibleToUser;

    private Unbinder mUnbinder;
    private BaseActivity mBaseActivity;


    public BaseActivity getmBaseActivity() {
        return mBaseActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mBaseActivity = (BaseActivity) activity;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //懒加载
        if (getUserVisibleHint()) {
            this.isVisibleToUser = true;
            onVisible_00();
        } else {
            this.isVisibleToUser = false;
            onInVisible_01();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(setContentViewLayout_0(), container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        initView_1(rootView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;

        bindLogic_2();
        lazyLoad();
        setListeners_4();
        excuteOthers_5();
    }

    protected void onVisible_00() {
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isVisibleToUser || !isPrepared) {
            //如果界面还没可见或者View还没准备好
            return;
        }
        loadData_3();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBindLogic();
        mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isPrepared = false;
    }

    /**
     * 设置layout xml
     */
    protected abstract int setContentViewLayout_0();

    /**
     * 对各个View的初始化
     */
    protected abstract void initView_1(View rootView);

    //--------------onViewCreated()-----------------

    /**
     * 绑定
     */
    protected abstract void bindLogic_2();

    /**
     * 懒加载的逻辑
     */
    protected abstract void loadData_3();

    /**
     * view的监听器绑定
     */
    protected abstract void setListeners_4();

    /**
     * 必要的逻辑
     */
    protected abstract void excuteOthers_5();

    //------------------------分割-------------------

    protected abstract void onInVisible_01();

    /**
     * 在onDestroy中的解绑
     */
    protected abstract void unBindLogic();

}
