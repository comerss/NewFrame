package com.comers.baselibrary.widget.celender;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by human on 2017/6/22.
 */

public class WeekPager extends ViewPager {
    List<WeekView.WeekData> mWeekDataList = new ArrayList<>();
    List<WeekView> mWeekViewList = new ArrayList<>();
    private int mSelectWeek;
    SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
    Context mContext;
    private int mWeekNum_1;
    private int mWeekNum_2;
    private int mWeekNum_3;

    public WeekPager(Context context) {
        this(context, null);
    }

    public WeekPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initWeekNum();
        initTimesss();
        initAdapter();
    }

    private void initTimesss() {
        Calendar calendar = Calendar.getInstance();
        initTime(calendar, 1);
        calendar.add(Calendar.MONTH, 1);
        initTime(calendar, 2);
        calendar.add(Calendar.MONTH, 1);
        initTime(calendar, 3);
    }

    private void initWeekNum() {
        Calendar calendar = Calendar.getInstance();
        mWeekNum_1 = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        calendar.add(Calendar.MONTH, 1);
        mWeekNum_2 = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        calendar.add(Calendar.MONTH, 1);
        mWeekNum_3 = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);

    }

    private void initAdapter() {
        setAdapter(mPagerAdapter);
    }

    private void initTime(Calendar calendar, int flag) {
        mWeekDataList = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
        WeekView.WeekData weekData = null;
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int maxWeek = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        WeekView weekView = null;
        for (int j = 1; j <= maxWeek; j++) {
            weekView = new WeekView(mContext);
            mWeekDataList = new ArrayList<>();
            for (int i = 1; i <= maxDay; i++) {
                calendar.set(year, month, i);
                if (flag == 1) {
                    weekData = new WeekView.WeekData(String.valueOf(i), sFormat.format(calendar.getTime()),
                            calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.WEEK_OF_MONTH), false);
                } else if (flag == 2) {
                    weekData = new WeekView.WeekData(String.valueOf(i), sFormat.format(calendar.getTime()),
                            calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.WEEK_OF_MONTH) + mWeekNum_1, false);
                } else if (flag == 3) {
                    weekData = new WeekView.WeekData(String.valueOf(i), sFormat.format(calendar.getTime()),
                            calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.WEEK_OF_MONTH) + mWeekNum_1 + mWeekNum_2, false);
                }
                int week_of_month = calendar.get(Calendar.WEEK_OF_MONTH);
                int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
                if (week_of_month == j) {
                    mWeekDataList.add(weekData);
                }
                if (week_of_month == j && (day_of_week == Calendar.SATURDAY || i == maxDay)) {
                    weekView.setList(mWeekDataList);
                    mWeekViewList.add(weekView);
                }
            }
        }
    }

    public void setOnDateClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public OnClickListener mOnClickListener;

    public void setCurrentTime(String time) {
        //这里只做了三个月的，如何是全部的与月份的可以根据滑动的页面获对应的日期View
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.MONTH, 1);
        int month1 = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.MONTH, 1);
        int month2 = calendar.get(Calendar.MONTH);
        Date date = null;
        try {
            date = sFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            date = new Date();
        }
        Calendar ca = (Calendar) calendar.clone();
        if (date.getMonth() == month) {
            ca.setTime(date);
            setCurrentItem(ca.get(Calendar.WEEK_OF_MONTH) - 1);
            mWeekViewList.get(ca.get(Calendar.WEEK_OF_MONTH) - 1).setSelectedWeek(time);
        } else if (date.getMonth() == month1) {
            ca.setTime(date);
            setCurrentItem(ca.get(Calendar.WEEK_OF_MONTH) + mWeekNum_1 - 1);
            mWeekViewList.get(ca.get(Calendar.WEEK_OF_MONTH) + mWeekNum_1 - 1).setSelectedWeek(time);

        } else if (date.getMonth() == month2) {
            ca.setTime(date);
            setCurrentItem(ca.get(Calendar.WEEK_OF_MONTH) + mWeekNum_1 + mWeekNum_2 - 1);
            mWeekViewList.get(ca.get(Calendar.WEEK_OF_MONTH) + mWeekNum_1 + mWeekNum_2 - 1).setSelectedWeek(time);

        }
    }

    public interface OnClickListener {
        void onDateClick(WeekView.WeekData workDates);
    }

    public void refreshAll(int position) {
        for (int i = 0; i < mWeekViewList.size(); i++) {
            if (i != position) {
                mWeekViewList.get(i).unSelectAll();
            }
        }
    }

    PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            Log.i("size1", "size------------>" + mWeekNum_1);
            return mWeekNum_1 + mWeekNum_2 + mWeekNum_3;///*+ size2 + size3*/;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            Log.i("postion", "postion---------->" + position);
            WeekView weekView = mWeekViewList.get(position);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            weekView.setLayoutParams(params);
            container.addView(weekView);
            weekView.setOnClickListener(new WeekView.OnClickListener() {
                @Override
                public void onDateClick(WeekView.WeekData workDates) {
                    if (mOnClickListener != null)
                        mOnClickListener.onDateClick(workDates);
                    refreshAll(position);
                }
            });
            return weekView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mWeekViewList.get(position));
        }
    };
}
