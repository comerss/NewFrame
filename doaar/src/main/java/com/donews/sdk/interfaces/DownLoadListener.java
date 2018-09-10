package com.donews.sdk.interfaces;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public interface DownLoadListener {
     void onIdle();

     void onDownloadActive(long var1, long var3, String var5, String var6);

     void onDownloadPaused(long var1, long var3, String var5, String var6);

     void onDownloadFailed(long var1, long var3, String var5, String var6);

     void onDownloadFinished(long var1, String var5, String var6);

     void onInstalled(String var1, String var2);
}