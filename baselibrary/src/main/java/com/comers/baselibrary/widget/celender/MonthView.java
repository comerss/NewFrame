package com.comers.baselibrary.widget.celender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.comers.baselibrary.R;
import com.comers.baselibrary.utils.UIUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by human on 2017/6/3.
 */

public class MonthView extends View {
    private String[] weekString = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    private Paint mLinePaint;
    private TextPaint mTextPaint;
    private Context mContext;
    //日期高度
    private int mDateHeight;
    private List<WorkDates> mWorkDates = new ArrayList<>();
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Paint mCirclePaint;
    private int mTodayTextColors = Color.parseColor("#ffffff");
    private int mTodayColors = Color.parseColor("#E5C081");
    private int G_COLOR = Color.parseColor("#E6E6E6");
    private int monthTextColor = Color.parseColor("#dbab7c");
    private int monthLineColor = Color.parseColor("#E6E6E6");
    private Calendar mCalendar = Calendar.getInstance();
    private float mColumnWidth;
    int[][] monthDays = new int[6][7];
    private int paddingLeft = 0;
    private int paddingTop = 0;
    private int paddingRight = 0;
    private int paddingBottom = 0;
    private int monthTextPadding = dip2px(14);
    private int mDaysColor = Color.parseColor("#000000");
    private int mWeekendColor = Color.parseColor("#999999");
    private int mRadius = dip2px(12);
    private int mShowTextColor = Color.parseColor("#c03e3e");
    private int mShowTextSize = dip2px(10);
    private int mCircleColor=Color.parseColor("#ebebeb");
    private int mDayTextSize=dip2px(16);
    private int mBaseHeight;
    private String mShowText;
    private Paint mPaint;

    public MonthView(Context context) {
        this(context, null);
    }

    public MonthView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mDateHeight = dip2px(54);
        initPatint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.AT_MOST) {
            mCalendar.set(Calendar.DAY_OF_MONTH, mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            heightSize = mDateHeight * (mCalendar.get(Calendar.WEEK_OF_MONTH) + 1);
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            mCalendar.set(Calendar.DAY_OF_MONTH, mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            heightSize = mDateHeight * (mCalendar.get(Calendar.WEEK_OF_MONTH) + 1);
        }
        setMeasuredDimension(widthSize, heightSize);
        paddingLeft = getPaddingLeft();
        paddingTop = getPaddingTop();
        paddingRight = getPaddingRight();
        paddingBottom = getPaddingBottom();
    }

    //初始化画笔
    private void initPatint() {
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setColor(Color.parseColor("#CFD4DB"));//weekTheme.colorTopLinen()
        mLinePaint.setStrokeWidth(1);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.parseColor("#000000"));
        mTextPaint.setTextSize(35);

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL);
       //绘制今日带阴影背景的画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mTodayColors);
        mPaint.setShadowLayer(dip2px(10),0F,dip2px(4),Color.parseColor("#80E9C29C"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBaseHeight = drawMonth(canvas);
        drawDate(mBaseHeight, canvas, mCalendar);
    }

    private void drawDate(int baseHeight, Canvas canvas, Calendar calendar) {
        mColumnWidth = getWidth() / 7F;

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Log.i("month", month + "");
        calendar.set(year, month, 1);
        drawDays(canvas, baseHeight, calendar, year, month, maxDay);
    }

    private void drawDays(Canvas canvas, int baseHeight, Calendar calendar, int year, int month, int maxDay) {
        Rect rect;
        Rect textRect;
        for (int i = 1; i <= maxDay; i++) {
            textRect=new Rect();
            String text=String.valueOf(i);
            mTextPaint.getTextBounds(text, 0, text.length(), textRect);
            mTextPaint.setTextSize(dip2px(16));

            calendar.set(year, month, i);
            //星期几
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            //绘制网络请求的数据，那些天有预约的人，绘制不同背景和人数
            if (mWorkDates != null) {
                try {
                    String date = mFormat.format(calendar.getTime());
                    for (int j = 0; j < mWorkDates.size(); j++) {
                        if (mWorkDates.get(j).getDayText().equals(date)) {
                            rect = new Rect();
                            mShowText = mWorkDates.get(j).getShowText();
                            mTextPaint.setColor(mShowTextColor);
                            mTextPaint.setTextSize(mShowTextSize);
                            mTextPaint.getTextBounds(mShowText, 0, mShowText.length(), rect);
                            float x = mColumnWidth * (calendar.get(Calendar.DAY_OF_WEEK) - 1) + mColumnWidth / 2 - rect.width() / 2;
                            canvas.drawText(mShowText, 0, mShowText.length(), x, mDateHeight * calendar.get(Calendar.WEEK_OF_MONTH) + baseHeight - rect.height() / 2+dip2px(6), mTextPaint);
                            float rx = mColumnWidth * (calendar.get(Calendar.DAY_OF_WEEK) - 1) + mColumnWidth / 2 ;
                            mCirclePaint.setColor(mCircleColor);
                            if(!mWorkDates.get(j).isToday()){
                                //这个 + 6 其实就是把内容区下移6dp 确保看起来基本是在中间，内容的高度有基本的DateHeight决定
                                //如果 想要改变高度这改这个就好了，至于padding值暂时没有提供，加上也是很简单的事情
                                canvas.drawCircle(rx , mDateHeight * calendar.get(Calendar.WEEK_OF_MONTH) - mDateHeight / 2 + baseHeight +dip2px(6) , mRadius, mCirclePaint);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mTextPaint.setTextSize(mDayTextSize);
            if (i == new Date().getDate() && month == new Date().getMonth()) {
                //今日
                mTextPaint.setColor(mTodayTextColors);
                mCirclePaint.setColor(mTodayColors);
                float x = mColumnWidth * (calendar.get(Calendar.DAY_OF_WEEK) - 1) + mColumnWidth / 2 ;
                canvas.drawCircle(x , mDateHeight * calendar.get(Calendar.WEEK_OF_MONTH) - mDateHeight / 2 + baseHeight+dip2px(6)  , mRadius, mPaint);
                //今日的背景圆
            } else {
                //今日的字色和其他日期的字色不同
                if (week == Calendar.SUNDAY || week == Calendar.SATURDAY) {
                    mTextPaint.setColor(mWeekendColor);
                } else {
                    mTextPaint.setColor(mDaysColor);
                }
            }
            float startX = mColumnWidth * (calendar.get(Calendar.DAY_OF_WEEK) - 1) + (mColumnWidth - textRect.width()) / 2 ;//加上距左边的padding值
            canvas.drawText(text, 0, text.length(), startX, mDateHeight * calendar.get(Calendar.WEEK_OF_MONTH) - mDateHeight / 2 + baseHeight + dip2px(6)+textRect.height()/2, mTextPaint);
            monthDays[calendar.get(Calendar.WEEK_OF_MONTH) - 1][calendar.get(Calendar.DAY_OF_WEEK) - 1] = i;

        }
    }

    //绘制月份
    private int drawMonth(Canvas canvas) {
        //绘制第一条线
        mLinePaint.setColor(monthLineColor);
//        canvas.drawLine(0, 0, getWidth(), dip2px(1), mLinePaint);
        mLinePaint.setColor(Color.parseColor("#50dbba7c"));
        Rect monthRect = new Rect();
        mTextPaint.setTextSize(dip2px(18));
        mTextPaint.getTextBounds(getMonthText(), 0, getMonthText().length(), monthRect);
        Rect rect = new Rect(0, 0, getScreenWith(), monthRect.height() + monthTextPadding * 2);
        mLinePaint.setStyle(Paint.Style.FILL);
        //绘制背景bitmap
        Bitmap bitmap=BitmapFactory.decodeResource(mContext.getResources(),R.drawable.yuefen);
//        canvas.drawRect(rect, mLinePaint);
        Rect src=new Rect(0,0,getScreenWith(),rect.height());
        canvas.drawBitmap(bitmap,src,rect,mLinePaint);
//        canvas.drawLine(0, rect.bottom, getScreenWith(), rect.bottom, mLinePaint);
        mTextPaint.setColor(monthTextColor);
//        mTextPaint.setTypeface()
        canvas.drawText(getMonthText(), 0, getMonthText().length(), getScreenWith() / 2 - monthRect.width() / 2, rect.height() / 2 + monthRect.height() / 2, mTextPaint);
        return rect.bottom;
    }

    public int dip2px(float dpValue) {
        final float scale = UIUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void setData(List<WorkDates> data) {
        mWorkDates = data;
        invalidate();
    }

    public void setCalender(Calendar calender) {
        mCalendar = calender;
        invalidate();
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
                break;
            case MotionEvent.ACTION_MOVE:
                float dx1 = event.getX() - startX;
                float dy1 = event.getY() - startY;
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
        Log.i("xy","startX---->"+startX+"---startY---"+startY);
        int x = (int) ((startX / mColumnWidth) - 0.3);
        int y = (int) (((startY-mBaseHeight/2) / mDateHeight) - 0.5);
        Log.i("xy","x----"+x+"--y--"+y);
        //如果y小于100则小于点击范围，不响应事件
        if(startY<mBaseHeight){
            return;
        }
        if (x >= 0 && x < 7 && y >= 0 && y < 6) {
            if (mOnClickListener != null) {
                if (mWorkDates == null)
                    return;
                for (int i = 0; i < mWorkDates.size(); i++) {
                    String year = mCalendar.get(Calendar.YEAR) + "";
                    String month = (mCalendar.get(Calendar.MONTH) + 1) + "";
                    String day = monthDays[y][x] + "";
                    if (month.length() == 1) {
                        month = "0" + month;
                    }
                    if (day.length() == 1) {
                        day = "0" + day;
                    }
                    String time = year + "-" + month + "-" + day;
                    if (TextUtils.equals(mWorkDates.get(i).day, time)) {
                        mOnClickListener.onDateClick(mWorkDates.get(i));
                    }
                }
            }
//            Log.i("i", "x-->" + x + "--y-" + y + "---" + mCalendar.get(Calendar.MONTH) + "." + monthDays[y][x]);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public OnClickListener mOnClickListener;

    public interface OnClickListener {
        void onDateClick(WorkDates workDates);
    }

    public String getMonthText() {
        if (mCalendar.get(Calendar.MONTH) == 0) {
            return "一月";
        } else if (mCalendar.get(Calendar.MONTH) == 1) {
            return "二月";
        } else if (mCalendar.get(Calendar.MONTH) == 2) {
            return "三月";
        } else if (mCalendar.get(Calendar.MONTH) == 3) {
            return "四月";
        } else if (mCalendar.get(Calendar.MONTH) == 4) {
            return "五月";
        } else if (mCalendar.get(Calendar.MONTH) == 5) {
            return "六月";
        } else if (mCalendar.get(Calendar.MONTH) == 6) {
            return "七月";
        } else if (mCalendar.get(Calendar.MONTH) == 7) {
            return "八月";
        } else if (mCalendar.get(Calendar.MONTH) == 8) {
            return "九月";
        } else if (mCalendar.get(Calendar.MONTH) == 9) {
            return "十月";
        } else if (mCalendar.get(Calendar.MONTH) == 10) {
            return "十一月";
        } else if (mCalendar.get(Calendar.MONTH) == 11) {
            return "十二月";
        }
        return "";
    }

    public int getScreenWith() {
        WindowManager wm = (WindowManager) UIUtils.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
