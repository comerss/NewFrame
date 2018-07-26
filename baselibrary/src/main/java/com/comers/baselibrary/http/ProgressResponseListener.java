package com.comers.baselibrary.http;

import java.io.File;

/**
 * Created by Comers on 2017/10/30.
 */

public interface ProgressResponseListener {
    void onResponseProgress(long totalBytesRead, long contentLength, boolean done);
    void onFail(String msg);
    void onLoad(File file);
    void onPause();
}
