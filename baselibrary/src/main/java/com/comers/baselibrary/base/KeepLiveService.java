package com.comers.baselibrary.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.comers.baselibrary.utils.ConstantsPool;


/**
 * Created by Comers on 2017/9/20.
 */

public class KeepLiveService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new IllegalArgumentException(" no bind to back");
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Intent blackIntent = new Intent();
        blackIntent.setAction(ConstantsPool.RECEIVER_ACTION);
        sendBroadcast(blackIntent);
        super.onDestroy();
    }
}
