package com.donews.frame.download;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by 79653 on 2018/9/4.
 * 描述：
 */
public class NotificationManager  {
    public  void createNotify(Context context){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        builder.setAutoCancel(true)
                .setSmallIcon(getIcon(context));
    }

    private int getIcon(Context context) {
        return 0;
    }
}
