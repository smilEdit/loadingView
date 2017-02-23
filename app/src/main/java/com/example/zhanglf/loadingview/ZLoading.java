package com.example.zhanglf.loadingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhanglf.loadingview.Interface.CancelListener;
import com.example.zhanglf.loadingview.type.EyeView;
import com.example.zhanglf.loadingview.type.LoadingView;

/**
 * Created by zhanglf on 2017/2/23.
 */

public class ZLoading extends View implements CancelListener{
    private LoadingView mLoadingView;

    public ZLoading(Context context) {
        super(context);
        initialize(context, null, 0);
    }

    public ZLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs, 0);
    }

    public ZLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ZLoading);

//        String loaderType = typedArray.getString(R.styleable.ZLoading_mk_type);
//        if (loaderType == null) loaderType = "ClassicSpinner";
        mLoadingView = new EyeView();
        mLoadingView.setColor(typedArray.getColor(R.styleable.ZLoading_mk_color, Color.parseColor("#ffffff")));
        mLoadingView.setCancelListener(this);

        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int measuredWidth = resolveSize(mLoadingView.getDesiredWidth(), widthMeasureSpec);
        final int measuredHeight = resolveSize(mLoadingView.getDesiredHeight(), heightMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mLoadingView.setSize(getWidth(), getHeight());
        mLoadingView.initializeObjects();
        mLoadingView.setUpAnimation();
    }

    @Override
    public void reDraw() {
        invalidate();
    }
}
