package com.donews.frame.sdk;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import com.comers.baselibrary.download.UrlManager;
import com.comers.baselibrary.utils.ConstantsPool;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 79653 on 2018/8/10.
 * 描述：
 */
public class DownLoadHelper {
    private static DownLoadHelper mDbHelper;
    static Map<Long, String> mAddresss = new HashMap<>();
    static Map<String, Long> mIds = new HashMap<>();

    private DownLoadHelper() {
    }

    public static DownLoadHelper instance() {
        if (mDbHelper == null) {
            synchronized (DownLoadHelper.class) {
                if (mDbHelper == null) {
                    mDbHelper = new DownLoadHelper();
                }
            }
        }
        return mDbHelper;
    }

    static Set<Long> Loading = new HashSet<>();

    public void download(Context context, String url) {
        /*DownloadManager.STATUS_SUCCESSFUL: 下载成功
         * DownloadManager.STATUS_FAILED: 下载失败
         * DownloadManager.STATUS_PENDING: 等待下载
         * DownloadManager.STATUS_RUNNING: 正在下载
         * DownloadManager.STATUS_PAUSED: */
        if (mIds.containsKey(url)) {
            int isLoad = isLoad(context, mIds.get(url));
            if (isLoad == DownloadManager.STATUS_SUCCESSFUL) {
                installApk(context, mIds.get(url));
                return;
            } else if (isLoad == DownloadManager.STATUS_RUNNING) {
//                ToastUtil.showToast("正在下载");
                return;
            }
        }
        Toast.makeText(context, "开始下载", Toast.LENGTH_SHORT).show();
        UrlManager.INSTANCE.add(url);
        DownloadManager dManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        // 设置下载路径和文件名
        String filePath = ConstantsPool.FILE_ROOT + File.separator + System.currentTimeMillis() + ".apk";
//        request.setDestinationInExternalPublicDir(FileUtils.DOWNLOAD_FILE, filePath);
        request.setDestinationUri(Uri.fromFile(new File(filePath)));
        request.setDescription("应用下载");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.allowScanningByMediaScanner();
        // 设置为可见和可管理
        request.setVisibleInDownloadsUi(true);

        long refernece = dManager.enqueue(request);
        Loading.add(refernece);
        mIds.put(url, refernece);
        mAddresss.put(refernece, filePath);
    }

    private int isLoad(Context context, Long aLong) {
        // 创建一个查询对象
        DownloadManager dManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        DownloadManager.Query query = new DownloadManager.Query();
// 根据 下载ID 过滤结果
        query.setFilterById(aLong);
// 还可以根据状态过滤结果
// query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL);
// 执行查询, 返回一个 Cursor (相当于查询数据库)
        Cursor cursor = dManager.query(query);
        if (!cursor.moveToFirst()) {
            cursor.close();
            return DownloadManager.STATUS_FAILED;
        }
// 下载ID
        try {
            long id = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_ID));
// 下载请求的状态
            int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
// 下载文件在本地保存的路径
            String localFilename = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
// 已下载的字节大小
            long downloadedSoFar = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
// 下载文件的总字节大小
            long totalSize = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
            cursor.close();
            //判断是否下载成功,其中状态 status 的值有 5 种:
            /* DownloadManager.STATUS_SUCCESSFUL: 下载成功
             * DownloadManager.STATUS_FAILED: 下载失败
             * DownloadManager.STATUS_PENDING: 等待下载
             * DownloadManager.STATUS_RUNNING: 正在下载
             * DownloadManager.STATUS_PAUSED: 下载暂停*/
            return status;
        } catch (Exception e) {

        }
        return DownloadManager.STATUS_FAILED;
    }


    public static class DownLoadBroadcastReceiver extends BroadcastReceiver {

        @SuppressLint("NewApi")

        public void onReceive(Context context, Intent intent) {
            long myDwonloadID = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (Loading.contains(myDwonloadID)) {
                File file = new File(mAddresss.get(new Long(myDwonloadID)));
                file.renameTo(new File(file.getName().replace("temp", "apk")));
                installApk(context, myDwonloadID);
            }

        }
    }

    private static void installApk(Context context, long myDwonloadID) {
        Intent install = new Intent(Intent.ACTION_VIEW);
        File file = new File(mAddresss.get(new Long(myDwonloadID)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            install.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, "com.donews.firsthot.fileprovider", file);
            install.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(install);
    }

    public static void setPermission(String filePath) {
        String command = "chmod " + "777" + " " + filePath;
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
