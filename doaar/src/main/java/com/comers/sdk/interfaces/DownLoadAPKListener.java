package com.comers.sdk.interfaces;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public interface DownLoadAPKListener {
     void onDownloadFailed(String msg);

     void onDownloadFinished();

     void onInstalled(String var1, String var2);
}