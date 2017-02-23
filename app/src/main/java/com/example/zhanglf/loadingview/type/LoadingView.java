package com.example.zhanglf.loadingview.type;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;

import com.example.zhanglf.loadingview.Interface.CancelListener;

import static android.R.string.cancel;

/**
 * Created by zhanglf on 2017/2/23.
 */

public abstract class LoadingView {
    protected int color;
    protected int width,height;
    protected int desiredWidth,desiredHeight;
    protected PointF center;
    protected CancelListener cancelListener;

    public LoadingView() {
        this.desiredHeight = 150;
        this.desiredWidth = 150;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.center = new PointF(width / 2.0f, height / 2.0f);
    }

    public void setCancelListener(CancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    public int getDesiredWidth() {
        return desiredWidth;
    }

    public int getDesiredHeight() {
        return desiredHeight;
    }

    public abstract void initializeObjects();

    public abstract void setUpAnimation();

    public abstract void draw(Canvas canvas);

}
