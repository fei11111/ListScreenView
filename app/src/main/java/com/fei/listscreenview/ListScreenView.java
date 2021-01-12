package com.fei.listscreenview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @ClassName: ListScreenView
 * @Description: java类作用描述
 * @Author: Fei
 * @CreateDate: 2021-01-12 21:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-01-12 21:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ListScreenView extends LinearLayout {

    private BaseScreenAdapter mAdapter;

    public ListScreenView(Context context) {
        this(context, null);
    }

    public ListScreenView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListScreenView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
}
