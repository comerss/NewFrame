package com.liangyibang.baselibrary.widget.celender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.liangyibang.baselibrary.utils.UIUtils;

/**
 * Created by Comers on 2017/11/19.
 * 描述：显示星期几的View
 */

public class WeekDaysView extends View {
    String[] weeks=new String[]{"日","一","二","三","四","五","六"};
    private TextPaint mPaint;
    private int mWidth;
    private float mColumWidth;
    int mWeekColor= Color.parseColor("#666666");
    int mWeekDayColor= Color.parseColor("#0d0d0d");
    public WeekDaysView(Context context) {
        this(context,null);
    }

    public WeekDaysView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public WeekDaysView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(UIUtils.dip2px(16));
        mWidth = UIUtils.getScreenWith();
        mColumWidth = mWidth/7;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int maxHeight=getMaxHeight();
        for(int i = 0 ; i<weeks.length;i++){
            Rect rectF=new Rect();
            mPaint.getTextBounds(weeks[i],0,weeks[i].length(),rectF);
            canvas.drawText(weeks[i],mColumWidth*i+mColumWidth/2-rectF.width()/2,maxHeight/2+rectF.height()/2,mPaint);
        }
    }
    public int getMaxHeight(){
        Rect rect ;
        int maxHeight=0;
        for (int i = 0 ; i < weeks.length;i++){
            rect=new Rect();
            mPaint.getTextBounds(weeks[i],0,weeks[i].length(),rect);
            if(rect.height()>maxHeight){
                maxHeight=rect.height();
            }
        }
        return maxHeight;
    }
}
