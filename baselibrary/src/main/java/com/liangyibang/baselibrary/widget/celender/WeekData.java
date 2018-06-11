package com.liangyibang.baselibrary.widget.celender;

/**
 * Created by human on 2017/6/21.
 */

public class WeekData {
    public String Time;
    public String Date;
    public boolean isChecked;
    public int weekPosition;
    public boolean thisMonthWeek;

    public WeekData(String time, String date, boolean isChecked, int weekPosition, boolean thisMonthWeek) {
        Time = time;
        Date = date;
        this.isChecked = isChecked;
        this.weekPosition = weekPosition;
        this.thisMonthWeek = thisMonthWeek;
    }
}
