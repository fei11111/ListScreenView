package com.fei.listscreenview;

import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName: BaseScreenAdapter
 * @Description: 筛选条目适配器
 * @Author: Fei
 * @CreateDate: 2021-01-12 21:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-01-12 21:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseScreenAdapter {

    /**
     * 这里只弄一个观察者
     */
    private BaseMenuObserver mObserver;

    /**
     * 注册观察者
     *
     * @param observer
     */
    public void registerMenuObserver(BaseMenuObserver observer) {
        this.mObserver = observer;
    }

    /**
     * 注销观察者
     *
     * @param observer
     */
    public void unregisterMenuObserver(BaseMenuObserver observer) {
        mObserver = null;
    }

    /**
     * 条目个数
     */
    public abstract int getCount();

    /**
     * 头部布局
     */
    public abstract View getTabView(int position, ViewGroup parent);

    /**
     * 内容布局
     */
    public abstract View getMenuView(int position, ViewGroup parent);

    /**
     * 打开回调，如果在打开的状态下，切换其它tab，就会还是打开状态
     *
     * @param previousTabView 之前点击的tabView
     * @param currentTabView  当前点击的tabView
     * @param currentPosition 当前位置
     */
    public void openMenu(View previousTabView, View currentTabView, int currentPosition) {

    }

    /**
     * 关闭回调，关闭后当前tabView状态处理
     *
     * @param tabView
     * @param currentPosition
     */
    public void closeMenu(View tabView, int currentPosition) {
    }

    /**
     * 通知关闭内容
     */
    public void notifyCloseMenu() {
        if (mObserver != null) {
            mObserver.closeMenu();
        }
    }

}
