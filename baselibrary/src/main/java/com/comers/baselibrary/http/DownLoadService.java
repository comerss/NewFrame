package com.comers.baselibrary.http;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;

import com.comers.baselibrary.R;
import com.comers.baselibrary.utils.ConstantsPool;
import com.comers.baselibrary.utils.ToastUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 79653 on 2018/7/17.
 * 描述：
 */
public class DownLoadService extends Service {
    NotificationManager notificationManager;
    NotificationBroadcastReceiver mReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String url = intent.getStringExtra("updateservice");
            Log.i("url------>", url);
            if (!TextUtils.isEmpty(url)) {
                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (UrlManager.INSTANCE.contains(url)) {

                } else {
                    mReceiver = new NotificationBroadcastReceiver();
                    buildDown(url);
                    UrlManager.INSTANCE.add(url);
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void buildDown(final String url) {
        final long[] totalBytesReads = new long[1];
        final long[] contentLengths = new long[1];
        final int[] currentProgress = {0};
        ToastUtils.showToast("开始下载");
        final Notification notification = new Notification(getIcon(this), "下载进度条...",
                System.currentTimeMillis());
        notification.contentView = new RemoteViews(getApplication()
                .getPackageName(), R.layout.progress_update);
        notification.contentView.setProgressBar(R.id.progress_update, 100, 0,
                false);
        notification.contentView.setTextViewText(R.id.progress_pro, "进度"
                + 0 + "%");




        notification.flags = Notification.FLAG_AUTO_CANCEL;
        String filename = getFilePath(url);
        String filePath = ConstantsPool.FILE_ROOT + File.separator + filename;

        IntentFilter filter_click = new IntentFilter();
        filter_click.addAction("click");
        //注册广播
        registerReceiver(mReceiver, filter_click);
        Intent Intent_pre = new Intent("click");
        Intent_pre.putExtra("path",filePath);
        Intent_pre.putExtra("url",url);
        //得到PendingIntent
        PendingIntent pendIntent_click = PendingIntent.getBroadcast(this, 0, Intent_pre, 0);
        //设置监听
        notification.contentView.setOnClickPendingIntent(R.id.click, pendIntent_click);


//        notificationManager.notify(UrlManager.INSTANCE.get(url), notification);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateProgress(notification, currentProgress[0], "进度" + getNetFileSizeDescription(totalBytesReads[0]) + "/" + getNetFileSizeDescription(contentLengths[0]), url);
            }
        };
        final Timer timer = new Timer();
        timer.schedule(task, 500, 1000);
        HttpHelper.downLoad(url, filePath, new ProgressResponseListener() {
            @Override
            public void onResponseProgress(long totalBytesRead, long contentLength, boolean done) {
                currentProgress[0] = (int) (totalBytesRead * 100 / contentLength);
                totalBytesReads[0] = totalBytesRead;
                contentLengths[0] = contentLength;

                if (totalBytesRead>0&&totalBytesRead == contentLength) {
                    timer.cancel();
                    updateProgress(notification, currentProgress[0], "进度" + getNetFileSizeDescription(totalBytesRead) + "/" + getNetFileSizeDescription(contentLength), url);
                    notification.contentView.setTextViewText(
                            R.id.progress_pro, "点击安装");
                    notificationManager.notify(UrlManager.INSTANCE.get(url), notification);
                    UrlManager.INSTANCE.remove(url);
                    mReceiver.isFinished=true;
                }
            }

            @Override
            public void onLoad(File file, boolean isExist) {
                if (isExist) {
                    timer.cancel();
                    notificationManager.cancel(UrlManager.INSTANCE.get(url));
                }
                install(file);
                UrlManager.INSTANCE.remove(url);
            }

            @Override
            public void onFail(String msg) {
                Log.i("TAG", "下载失败了");
                ToastUtils.showToast( msg);
                notification.contentView.setTextViewText(
                        R.id.progress_pro, "下载失败");
                UrlManager.INSTANCE.remove(url);
                timer.cancel();
            }
        });
    }

    private void updateProgress(Notification notification, int currentProgress, String text, String url) {
        notification.contentView.setProgressBar(
                R.id.progress_update, 100, currentProgress, false);
        notification.contentView.setTextViewText(
                R.id.progress_pro, "正在下载");
        notification.contentView.setTextViewText(
                R.id.txSizeInfo, text);
        notificationManager.notify(UrlManager.INSTANCE.get(url), notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
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

    private void install(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        startActivity(intent);
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

    public class NotificationBroadcastReceiver extends BroadcastReceiver {
        public boolean isFinished=false;
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String url=intent.getStringExtra("url");
            String path=intent.getStringExtra("path");
            if (action.equals("click")) {
                //处理点击事件
                if(!TextUtils.isEmpty(path)&&isFinished){
                    install(new File(path));
                    if (!TextUtils.isEmpty(url)) {
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.cancel(UrlManager.INSTANCE.get(url));
                    }
                }
            }
        }
    }
    private int getIcon(Context context) {

        final PackageManager packageManager = context.getPackageManager();
        ApplicationInfo appInfo = null;
        try {
            appInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (appInfo != null) {
            return appInfo.icon;
        }
        return 0;
    }
}
