package com.donews.sdk.base;


import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

public class TouchDelegateImpl extends TouchDelegate {
    private View mView;
    private Rect mRect;
    private Rect mRect1;
    private boolean mBoolean;
    private int mTouchSlop;

    public TouchDelegateImpl(Rect paramRect, View paramView) {
        super(paramRect, paramView);

        this.mRect = paramRect;

        this.mTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
        this.mRect1 = new Rect(paramRect);
        this.mRect1.inset(-this.mTouchSlop, -this.mTouchSlop);
        this.mView = paramView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i = (int) paramMotionEvent.getX();
        int j = (int) paramMotionEvent.getY();
        boolean bool1 = false;
        int k = 1;
        boolean bool2 = false;
        Object localObject;
        switch (paramMotionEvent.getAction()) {
            case 0:
                localObject = this.mRect;

                if (((Rect) localObject).contains(i, j)) {
                    this.mBoolean = true;
                    bool1 = true;
                } else {
                    this.mBoolean = false;
                    bool1 = false;
                }
                break;
            case 1:
            case 2:
                bool1 = this.mBoolean;
                if (bool1) {
                    Rect localRect = this.mRect1;
                    if (!localRect.contains(i, j))
                        k = 0;
                }
                break;

            case 3:
                bool1 = this.mBoolean;
                this.mBoolean = false;
        }

        if (bool1) {
            localObject = this.mView;

            if (k != 0) {
                paramMotionEvent.setLocation(((View) localObject).getWidth() / 2, ((View) localObject).getHeight() / 2);
            } else {
                int m = this.mTouchSlop;
                paramMotionEvent.setLocation(-(m * 2), -(m * 2));
            }
            if (((View) localObject).getVisibility() == View.VISIBLE) {
                bool2 = ((View) localObject).dispatchTouchEvent(paramMotionEvent);
            }
        }
        /* 147 */
        return bool2;
    }
}