package com.liangyibang.baselibrary.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Comers on 2017/11/25.
 * 描述：
 */

public class CircleView extends View {
    private int circleColor = Color.parseColor("#c03e3e");
    private float radio = 6;
    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.FILL);
    }
}
