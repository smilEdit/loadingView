package com.example.zhanglf.loadingview.model;

import android.graphics.Canvas;
import android.graphics.PointF;

/**
 * Created by zhanglf on 2017/2/23.
 */

public class Circle extends GraphicObject {
    private PointF center;
    private float radius;

    public Circle() {
        center = new PointF();
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setCenter(float x, float y) {
        center.set(x, y);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(center.x, center.y, radius, paint);
    }

}
