package com.comers.shenwu.sdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.comers.baselibrary.download.DownDbHelper;
import com.comers.baselibrary.download.DownLoadInfo;
import com.comers.baselibrary.download.UrlManager;
import com.comers.baselibrary.utils.ToastUtils;
import com.comers.baselibrary.utils.UIUtils;
import com.comers.shenwu.R;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by 79653 on 2018/7/26.
 * 描述：
 */
public class DeadService extends Service {
    NotificationBroadcastReceiver  mReceiver;
    @Override
    public void onCreate() {
        super.onCreate();
        //注册广播
        mReceiver = new NotificationBroadcastReceiver();
        IntentFilter filter_click = new IntentFilter();
        filter_click.addAction("click");
        registerReceiver(mReceiver, filter_click);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String url=intent.getStringExtra("url");
        download(url);
        return super.onStartCommand(intent, flags, startId);
    }

    private void download(final String url) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    private void updateProgress(Notification notification, long totalBytesRead, long contentLength, int currentProgress, String text, String url) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//        LogUtils.mOnClick("DownLoad",totalBytesRead+ "--------"+ contentLength+ "-----"+ currentProgress);

        notification.contentView.setProgressBar(
                R.id.progress_update, 100, currentProgress, false);
        if(totalBytesRead==contentLength&&totalBytesRead>0){
            notification.contentView.setTextViewText(
                    R.id.progress_pro, "点击安装");
        }else{
            notification.contentView.setTextViewText(
                    R.id.progress_pro, "正在下载");
        }
        notification.contentView.setTextViewText(
                R.id.txSizeInfo, text);
        notificationManager.notify(UrlManager.INSTANCE.get(url), notification);
        DownLoadInfo info = DownDbHelper.instance().getInfo(url);
        if (info != null) {
            info.currentLength = totalBytesRead;
            info.totoalLength = contentLength;
            info.isFinished = currentProgress == totalBytesRead;
            DownDbHelper.instance().update(info);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(mReceiver);
    }

    @NonNull
    private String getFilePath(String url) {
        String filename;
        if (url.contains("DonewsHot_")) {//引力资讯的安装下载包
            filename = System.currentTimeMillis() + ".apk";
        } else {
            filename = url.substring(url.lastIndexOf("/") + 1);
            if (TextUtils.isEmpty(filename)) {
                filename = System.currentTimeMillis() + ".apk";
            } else {
                if (filename.length() > 15) {
                    filename = filename.substring(filename.length() - 15);
                }
                if (!filename.endsWith(".apk")) {
                    filename = filename + ".apk";
                }
            }
        }
        return filename;
    }

    private static void install(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        UIUtils.getContext().startActivity(intent);
    }

    public static String getNetFileSizeDescription(long size) {
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("###.0");
        if (size >= 1024 * 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("GB");
        } else if (size >= 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0));
            bytes.append(format.format(i)).append("MB");
        } else if (size >= 1024) {
            double i = (size / (1024.0));
            bytes.append(format.format(i)).append("KB");
        } else if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B");
            } else {
                bytes.append((int) size).append("B");
            }
        }
        return bytes.toString();

    }
    public static class NotificationBroadcastReceiver extends BroadcastReceiver {
        public boolean isFinished = false;
        long clickFilter=0;
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("click")&&(System.currentTimeMillis()-clickFilter)>1000) {
                clickFilter=System.currentTimeMillis();
                String url = intent.getStringExtra("url");
                String path = intent.getStringExtra("path");
                DownLoadInfo info = DownDbHelper.instance().getInfo(url);
                if (info == null)
                    return;
                isFinished = info.currentLength == info.totoalLength && info.totoalLength > 0;
                //处理点击事件
//                LogUtils.mOnClick("onReceive",url);
//                LogUtils.mOnClick("onReceive",info.toString());
                if (!TextUtils.isEmpty(path) && isFinished) {
                    File file = new File(path);
                    if (file.exists()) {
                        install(file);
                        ToastUtils.showToast("安装");
                    }
                    if (!TextUtils.isEmpty(url)) {
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.cancel(UrlManager.INSTANCE.get(url));
                    }
                    return;
                }
                if (info.isLoading) {
                    Intent intent1 = new Intent(context, DeadService.class);
                    intent1.putExtra("updateservice", info.url);
                    intent1.putExtra("exist", true);
                    context.startService(intent1);
                    info.isLoading = !info.isLoading;
                    DownDbHelper.instance().update(info);
                    ToastUtils.showToast( "恢复下载");
                } else {
                    info.isLoading = !info.isLoading;
                    ToastUtils.showToast( "暂停下载");
                    UrlManager.INSTANCE.cancelCall(url);
                    DownDbHelper.instance().update(info);
                }
            }
        }

    }
}
