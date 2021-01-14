package com.fei.listscreenview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @ClassName: ListScreenView
 * @Description: 下拉筛选菜单和内容
 * @Author: Fei
 * @CreateDate: 2021-01-12 21:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2021-01-12 21:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ListScreenView extends LinearLayout {

    //适配器
    private BaseScreenAdapter mAdapter;
    //头部
    private LinearLayout mTabParentView;
    //内容父布局
    private LinearLayout mContentParentView;
    //内容布局
    private FrameLayout mContentView;
    //阴影
    private View mShadowView;
    private Context mContext;
    //阴影颜色
    private int mContentParentBgColor = Color.parseColor("#88000000");
    //移动高度
    private int mTranslateY;

    public ListScreenView(Context context) {
        this(context, null);
    }

    public ListScreenView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListScreenView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //可以增加头部背景颜色，内容背景颜色，阴影颜色

        mContext = context;
        //初始化子View
        initChild();
    }

    /**
     * 初始化布局内容
     */
    private void initChild() {
        //设置为垂直方向
        setOrientation(VERTICAL);
        mTabParentView = new LinearLayout(mContext);
        mTabParentView.setOrientation(HORIZONTAL);
        //添加头部
        addView(mTabParentView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        mContentParentView = new LinearLayout(mContext);
        mContentParentView.setOrientation(VERTICAL);
        //添加内容父布局
        addView(mContentParentView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mContentView = new FrameLayout(mContext);
        mContentView.setBackgroundColor(Color.WHITE);
        //将内容布局添加入内容父布局
        mContentParentView.addView(mContentView);
        mShadowView = new View(mContext);
        mShadowView.setBackgroundColor(mContentParentBgColor);
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
        params.weight = 1;
        //将阴影添加入内容父布局
        mContentParentView.addView(mShadowView, params);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            //获取总高度，内容布局是整个布局的70%高度
            int measuredHeight = getMeasuredHeight();
            //重新设置内容布局高度
            ViewGroup.LayoutParams layoutParams = mContentView.getLayoutParams();
            layoutParams.height = (int) (measuredHeight * 0.7f);
            mContentView.setLayoutParams(layoutParams);
            mTranslateY = layoutParams.height;
            //移出画面
            mContentParentView.setVisibility(GONE);
        }
    }

    /**
     * 设置适配器
     */
    public void setAdapter(BaseScreenAdapter adapter) {
        this.mAdapter = adapter;
        for (int i = 0; i < adapter.getCount(); i++) {
            //获取自定义tabView
            View tabView = adapter.getTabView(i, mTabParentView);
            if (tabView != null) {
                LinearLayout.LayoutParams layoutParams = (LayoutParams) tabView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1;
                mTabParentView.addView(tabView, layoutParams);
                setTabViewClickListener(i,tabView);
            }
            //获取自定义内容menuView
            View menuView = adapter.getMenuView(i, mContentView);
            if (menuView != null) {
                //先隐藏
                menuView.setVisibility(GONE);
                mContentView.addView(menuView);
            }
        }
    }

    /**
     * 设置头部点击事件
     * @param position
     * @param tabView
     */
    private void setTabViewClickListener(int position, View tabView) {

    }
}
