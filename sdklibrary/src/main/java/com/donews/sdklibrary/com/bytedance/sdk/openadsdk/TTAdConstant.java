package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TTAdConstant
{
  public static final int INTERACTION_TYPE_BROWSER = 2;
  public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
  public static final int INTERACTION_TYPE_DOWNLOAD = 4;
  public static final int INTERACTION_TYPE_DIAL = 5;
  public static final int INTERACTION_TYPE_UNKNOWN = -1;
  public static final int IMAGE_MODE_LARGE_IMG = 3;
  public static final int IMAGE_MODE_SMALL_IMG = 2;
  public static final int IMAGE_MODE_GROUP_IMG = 4;
  public static final int IMAGE_MODE_VIDEO = 5;
  public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
  public static final int IMAGE_MODE_UNKNOWN = -1;
  public static final String TAG = "TT_AD_SDK";
  public static final int GENDER_UNKNOWN = 0;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_FEMALE = 2;
  public static final int TITLE_BAR_THEME_LIGHT = 0;
  public static final int TITLE_BAR_THEME_DARK = 1;
  public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
  public static final int NETWORK_STATE_MOBILE = 1;
  public static final int NETWORK_STATE_2G = 2;
  public static final int NETWORK_STATE_3G = 3;
  public static final int NETWORK_STATE_WIFI = 4;
  public static final int NETWORK_STATE_4G = 5;
  public static final int VERTICAL = 1;
  public static final int HORIZONTAL = 2;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ORIENTATION_STATE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NETWORK_STATE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TITLE_BAR_THEME {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface USER_GENDER {}
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TTAdConstant.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */