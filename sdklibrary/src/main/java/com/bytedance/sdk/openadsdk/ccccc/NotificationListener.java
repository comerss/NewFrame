package com.bytedance.sdk.openadsdk.ccccc;

import android.app.Notification;
import android.app.PendingIntent;

abstract interface NotificationListener
{
  public abstract NotificationListener setContentIntent(PendingIntent paramPendingIntent);
  
  public abstract NotificationListener setOngoing(boolean paramBoolean);
  
  public abstract NotificationListener setAutoCancel(boolean paramBoolean);
  
  public abstract NotificationListener setDeleteIntent(PendingIntent paramPendingIntent);
  
  public abstract NotificationListener setWhen(long paramLong);
  
  public abstract NotificationListener setSmallIcon(int paramInt);
  
  public abstract Notification build();
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\VideoManager\NotificationListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */