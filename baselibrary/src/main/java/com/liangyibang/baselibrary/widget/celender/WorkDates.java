package com.liangyibang.baselibrary.widget.celender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by human on 2017/6/3.
 */

public class WorkDates {
    /**
     * count : 1
     * day : 2017-05-29
     */
    SimpleDateFormat mFormat=new SimpleDateFormat("yyyy-MM-dd");
    public int count;
    public String day;
    public String showText;
    public String getDayText() throws ParseException {
        mFormat=new SimpleDateFormat("yyyy-MM-dd");
        return mFormat.format(mFormat.parse(day));
    }
    public boolean isToday() throws ParseException {
        Date date =mFormat.parse(mFormat.format(new Date()));
        return date.compareTo(getDate())==0?true:false;
    }
    public Date getDate() throws ParseException {
        mFormat=new SimpleDateFormat("yyyy-MM-dd");
        return mFormat.parse(day);
    }

    public WorkDates(int count, String day) {
        this.count = count;
        this.day = day;
    }
    public String getShowText(){
        return count+"人";
    }
}
