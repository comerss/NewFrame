package com.liangyibang.baselibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.liangyibang.baselibrary.R;
import com.liangyibang.baselibrary.utils.UIUtils;

/**
 * Created by Comers on 2017/11/20.
 * 描述：虚线控件
 */

public class DashView extends View {
    private static final String TAG = "DashView";
    public static final int DEFAULT_DASH_WIDTH = 100;
    public static final int DEFAULT_LINE_WIDTH = 100;
    public static final int DEFAULT_LINE_HEIGHT = 10;
    public static final int DEFAULT_LINE_COLOR = 0x9E9E9E;

    /**虚线的方向*/
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    /**默认为水平方向*/
    public static final int DEFAULT_DASH_ORIENTATION = ORIENTATION_HORIZONTAL;
    /**间距宽度*/
    private float dashWidth= UIUtils.dip2px(3);
    /**线段高度*/
    private float lineHeight=UIUtils.dip2px(1);
    /**线段宽度*/
    private float lineWidth=UIUtils.dip2px(3);
    /**线段颜色*/
    private int lineColor= Color.parseColor("#cccccc");
    private int dashOrientation;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int widthSize;
    private int heightSize;

    public DashView(Context context) {
        this(context,null);
    }

    public DashView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DashView);
        dashWidth = typedArray.getDimension(R.styleable.DashView_dashWidth,DEFAULT_DASH_WIDTH);
        lineHeight = typedArray.getDimension(R.styleable.DashView_lineHeight, DEFAULT_LINE_HEIGHT);
        lineWidth = typedArray.getDimension(R.styleable.DashView_lineWidth, DEFAULT_LINE_WIDTH);
        lineColor = typedArray.getColor(R.styleable.DashView_lineColor, DEFAULT_LINE_COLOR);
        dashOrientation = typedArray.getInteger(R.styleable.DashView_dashOrientation,DEFAULT_DASH_ORIENTATION);
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineHeight);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec)-getPaddingLeft()-getPaddingRight();
        heightSize = MeasureSpec.getSize(heightMeasureSpec - getPaddingTop() - getPaddingBottom());
        Log.d(TAG, "onMeasure: "+widthSize+"----"+heightSize);
        Log.d(TAG, "dashOrientation: "+dashOrientation);
        if(dashOrientation == ORIENTATION_HORIZONTAL){
            //不管在布局文件中虚线高度设置为多少，虚线的高度统一设置为实体线段的高度
            setMeasuredDimension(widthSize, (int) lineHeight);
        }else{
            setMeasuredDimension((int) lineHeight, heightSize);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (dashOrientation){
            case ORIENTATION_VERTICAL:
                drawVerticalLine(canvas);
                break;
            default:
                drawHorizontalLine(canvas);
        }
    }

    /**
     * 画水平方向虚线
     * @param canvas
     */
    public void drawHorizontalLine(Canvas canvas){
        float totalWidth = 0;
        canvas.save();
        float[] pts = {0,0,lineWidth,0};
        //在画线之前需要先把画布向下平移办个线段高度的位置，目的就是为了防止线段只画出一半的高度
        //因为画线段的起点位置在线段左下角
        canvas.translate(0,lineHeight/2);
        while(totalWidth<=widthSize){
            canvas.drawLines(pts,mPaint);
            canvas.translate(lineWidth + dashWidth,0);
            totalWidth += lineWidth + dashWidth;
        }
        canvas.restore();
    }

    /**
     * 画竖直方向虚线
     * @param canvas
     */
    public void drawVerticalLine(Canvas canvas){
        float totalWidth = 0;
        canvas.save();
        float[] pts = {0,0,0,lineWidth};
        //在画线之前需要先把画布向右平移半个线段高度的位置，目的就是为了防止线段只画出一半的高度
        //因为画线段的起点位置在线段左下角
        canvas.translate(lineHeight/2,0);
        while(totalWidth<=heightSize){
            canvas.drawLines(pts,mPaint);
            canvas.translate(0,lineWidth + dashWidth);
            totalWidth += lineWidth + dashWidth;
        }
        canvas.restore();
    }
}
