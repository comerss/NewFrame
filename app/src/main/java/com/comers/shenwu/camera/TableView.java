package com.comers.shenwu.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;


public class TableView extends View {

    private Paint paint;
    private TextPaint textPaint;

    public TableView(Context context) {
        this(context, null);
    }

    public TableView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(dip2px(15));
        textPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    int[] datas = new int[]{1, 16, 70, 100, 25, 30, 50};
    int width;
    int SWitdh = getScreenWith();
    int lWith = 2;
    int lHeight = 900;
    Path path = new Path();
    Path lpath = new Path();
    String[] days = new String[]{"10.1", "10.2", "10.3", "10.4", "10.5", "10.6", "10.7"};
    int baseY = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = SWitdh / 7;
        for (int i = 0; i < 7; i++) {

            paint.setColor(Color.BLACK);
            Rect rect = new Rect();
            textPaint.getTextBounds(days[i], 0, days[i].length(), rect);
            baseY = rect.bottom - rect.top;
            textPaint.setTypeface(Typeface.DEFAULT);
            canvas.drawText(days[i], getX(i) - (rect.right - rect.left) / 2, baseY, textPaint);

            paint.setColor(Color.RED);
            paint.setPathEffect(null);
            int x = getX(i);
            int y = getY(i);
            canvas.drawLine(x, baseY, x + lWith, lHeight, paint);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x + lWith / 2, y, dip2px(2), paint);
            paint.setStyle(Paint.Style.STROKE);
            float cx;
            if (i < 6) {
                cx = getX(i) + (getX(i + 1) - getX(i)) / 2;
                if (i == 0) {
                    path.moveTo(getX(0), getY(0));
                    lpath.moveTo(getX(0), getY(0));
                }
                path.cubicTo(cx, getY(i), cx, getY(i + 1), getX(i + 1), getY(i + 1));
                lpath.cubicTo(cx, getY(i), cx, getY(i + 1), getX(i + 1), getY(i + 1));
            }
            paint.setColor(Color.RED);
            setLayerType(LAYER_TYPE_SOFTWARE, null);
            paint.setPathEffect(new DashPathEffect(new float[]{5, 5}, 0));
            canvas.drawLine(0, getY(i), SWitdh, getY(i), paint);
        }
        paint.setPathEffect(null);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(lpath, paint);

        path.lineTo(getX(6), getY(6));
        path.lineTo(getX(6), lHeight);
        path.lineTo(getX(0), lHeight);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#9fcffb"));
        canvas.drawPath(path, paint);
    }

    private int getY(int data) {
        return (int) (lHeight - lHeight * (datas[data] / 100.0)) + 50;
    }

    private int getX(int i) {
        return width / 4 + i * width + lWith / 2;
    }

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public int getScreenWith() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
