package com.comers.baselibrary.widget.celender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.widget.ScrollerCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.comers.baselibrary.utils.LogUtil;
import com.comers.baselibrary.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by human on 2017/6/21.
 */

public class WeekView extends View {
    private Context mContext;
    private List<WeekData> mWeekDataList;
    private float mColumnWidth;
    private TextPaint mTextPaint;
    private ScrollerCompat mScroller;
    private int mWidth;
    public int selectWeek = 0;
    private int mDateHeight = 0;
    private Paint mPaint;
    private int mTextSize = dip2px(16);

    public WeekView(Context context) {
        this(context, null);
    }

    public WeekView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeekView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mDateHeight = dip2px(45);
        mWidth = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
//        mColumnWidth = dip2px(54);
        mColumnWidth = mWidth / 7;
//        initTime();
        initPaint();
    }

    private void initPaint() {
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(dip2px(14));
        mTextPaint.setColor(Color.parseColor("#191919"));
        mScroller = ScrollerCompat.create(mContext);
        //选中的红色背景
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#c03e3e"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = dip2px(45);
            widthSize = mWidth;
            mDateHeight = heightSize;

//            widthSize = mWeekDataList.get(mWeekDataList.size()-1).weekPosition * mColumnWidth;
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            heightSize = dip2px(45);
            widthSize = mWidth;
            mDateHeight = heightSize;
//            widthSize = mWeekDataList.get(mWeekDataList.size()-1).weekPosition * mColumnWidth;
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        if (mWeekDataList.size() == 0) {
            return;
        }
        Rect rect;
        for (int i = 1; i <= mWeekDataList.size(); i++) {
            String text = mWeekDataList.get(i - 1).date;
            rect= new Rect();
            mTextPaint.getTextBounds(text, 0, text.length(), rect);
            mTextPaint.setTextSize(mTextSize);
            if (mWeekDataList.get(i - 1).weekend == 1 || mWeekDataList.get(i - 1).weekend == 7) {
                mTextPaint.setColor(Color.parseColor("#999999"));
                if (mWeekDataList.get(i - 1).isChecked) {
                    mTextPaint.setColor(Color.parseColor("#ffffff"));
                }
            } else if (mWeekDataList.get(i - 1).isChecked) {
                mTextPaint.setColor(Color.parseColor("#ffffff"));
            } else {
                mTextPaint.setColor(Color.parseColor("#3f3f3f"));
            }
            if (mWeekDataList.get(i - 1).isChecked) {
                canvas.drawCircle(mWeekDataList.get(i - 1).weekend * mColumnWidth - mColumnWidth / 2 , getMeasuredHeight() / 2, dip2px(12), mPaint);
            }
            canvas.drawText(text, mWeekDataList.get(i - 1).weekend * mColumnWidth - mColumnWidth / 2-rect.width()/2, getMeasuredHeight() / 2 + rect.height() / 2, mTextPaint);
        }
    }

    public int dip2px(float dpValue) {
        final float scale = UIUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static class WeekData {
        public String date; //日期
        public String time;//具体时间 年月日
        public int weekPosition;//一个月的第几周
        public boolean isChecked;
        public int weekend;//周几

        public WeekData(String date, String time, int weekend, int weekPosition, boolean isChecked) {
            this.date = date;
            this.time = time;
            this.weekPosition = weekPosition;
            this.isChecked = isChecked;
            this.weekend = weekend;
        }
    }

    float startX = 0;
    float startY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                LogUtil.i("i", "--------2-------按下了");
                break;
            case MotionEvent.ACTION_MOVE:
                float dx1 = event.getX() - startX;
                float dy1 = event.getY() - startY;
                LogUtil.i("i", "-----------3-----滑动了------");
                if (Math.abs(dx1) > 10 || Math.abs(dy1) > 10) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(true);
                float dx = event.getX() - startX;
                float dy = event.getY() - startY;
                LogUtil.i("i", "---------7---抬起了");
                if (Math.abs(dx) < mColumnWidth && Math.abs(dy) < mDateHeight) {
                    doOnClick(event.getX(), event.getY());
                    return true;
                } else {
                    return false;
                }
        }
        return true;
    }

    private void doOnClick(float startX, float startY) {
        LogUtil.i("xy", "startX-->" + (startX / mColumnWidth) + "startY-->" + (startY / mDateHeight));
        int x = (int) ((startX / mColumnWidth) - 0.3);
        int y = (int) ((startY / mDateHeight) - 0.5);
        if (x >= 0 && x < 7 && y >= 0 && y < 6) {
            if (mOnClickListener != null) {
                if (mWeekDataList == null)
                    return;
                if (mWeekDataList.size() == 7) {
                    mOnClickListener.onDateClick(mWeekDataList.get(x));
                } else {
                    if (Integer.valueOf(mWeekDataList.get(mWeekDataList.size() - 1).date) > 20) {
                        if (x < mWeekDataList.size()) {
                            mOnClickListener.onDateClick(mWeekDataList.get(x));
                        } else {
                            return;
                        }
                    } else {
                        if (x - (7 - mWeekDataList.size()) >= 0) {
                            mOnClickListener.onDateClick(mWeekDataList.get(x - (7 - mWeekDataList.size())));
                        } else {
                            return;
                        }
                    }
                }
                for (int i = 0; i < mWeekDataList.size(); i++) {
                    if (mWeekDataList.size() == 7 && x == i) {
                        mWeekDataList.get(x).isChecked = true;
                    } else {
                        mWeekDataList.get(i).isChecked = false;
                        if (Integer.valueOf(mWeekDataList.get(mWeekDataList.size() - 1).date) > 20) {
                            if (x < mWeekDataList.size()) {
                                mWeekDataList.get(x).isChecked = true;
                                selectWeek = x;
                            }
                        } else {
                            if (x - (7 - mWeekDataList.size()) >= 0) {
                                mWeekDataList.get(x - (7 - mWeekDataList.size())).isChecked = true;
                                selectWeek = x - (7 - mWeekDataList.size());
                            }
                        }
                    }
                }
                invalidate();
            }
        }
    }

    public void setSelectedWeek(String time) {
        mWeekDataList.get(selectWeek).isChecked = false;
        for (int i = 0; i < mWeekDataList.size(); i++) {
            if (mWeekDataList.get(i).time.equals(time)) {
                mWeekDataList.get(i).isChecked = true;
                selectWeek = i;
            } else {
                mWeekDataList.get(i).isChecked = false;
            }
        }
        invalidate();
    }

    public void setList(List<WeekData> list) {
        mWeekDataList = new ArrayList<>();
        mWeekDataList.addAll(list);
        invalidate();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public OnClickListener mOnClickListener;

    public interface OnClickListener {
        void onDateClick(WeekView.WeekData workDates);
    }

    public void unSelectAll() {
        for (WeekData weekData : mWeekDataList) {
            weekData.isChecked = false;
        }
        invalidate();
    }
}
