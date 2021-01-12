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

}
