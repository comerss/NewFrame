package com.comers.sdk.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;

/**
 * Created by YJ on 2016/4/18.
 */
public class RoundRectDradable extends Drawable {
    private static final float DEFAULT_RADIUS = 20.f;
    private Paint mPaint = new Paint();
    private RoundRectShape mShape;
    private float[] mOuter;
    private int mColor;
    private int mPressColor;
    private float mTopLeftRadius = DEFAULT_RADIUS;
    private float mTopRightRadius = DEFAULT_RADIUS;
    private float mBottomLeftRadius = DEFAULT_RADIUS;
    private float mBottomRightRadius = DEFAULT_RADIUS;
    public RoundRectDradable() {
        mColor = Color.WHITE;
        mPressColor = Color.WHITE;
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
    }
    public float getTopLeftRadius() {
        return mTopLeftRadius;
    }
    public void setTopLeftRadius(float topLeftRadius) {
        this.mTopLeftRadius = topLeftRadius;
    }
    public float getTopRightRadius() {
        return mTopRightRadius;
    }
    public void setTopRightRadius(float topRightRadius) {
        this.mTopRightRadius = topRightRadius;
    }
    public float getBottomLeftRadius() {
        return mBottomLeftRadius;
    }
    public void setBottomLeftRadius(float bottomLeftRadius) {
        this.mBottomLeftRadius = bottomLeftRadius;
    }
    public float getBottomRightRadius() {
        return mBottomRightRadius;
    }
    public void setBottomRightRadius(float bottomRightRadius) {
        this.mBottomRightRadius = bottomRightRadius;
    }
    public int getPressColor() {
        return mPressColor;
    }
    public void setPressColor(int pressColor) {
        this.mPressColor = pressColor;
    }
    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        refreshShape();
        mShape.resize(bounds.right - bounds.left, bounds.bottom - bounds.top);
    }
    private void refreshShape(){
        mOuter = new float[]{mTopLeftRadius, mTopLeftRadius
                , mTopRightRadius, mTopRightRadius
                , mBottomLeftRadius, mBottomLeftRadius
                , mBottomRightRadius, mBottomLeftRadius};
        mShape = new RoundRectShape(mOuter, null, null);
    }
    public void setColor(int color){
        mColor = color;
        mPaint.setColor(color);
    }
    @Override
    public void draw(Canvas canvas) {
        mShape.draw(canvas, mPaint);
    }
    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }
    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }
    @Override
    public int getOpacity() {
        return mPaint.getAlpha();
    }
}
