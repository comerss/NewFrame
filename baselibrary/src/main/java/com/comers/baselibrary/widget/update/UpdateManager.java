package com.comers.baselibrary.widget.update;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;

import com.comers.baselibrary.base.UpdateService;
import com.comers.baselibrary.http.HttpHelper;
import com.comers.baselibrary.utils.ToastUtils;

/**
 * Created by Comers on 2017/11/15.
 * 描述：版本更新服务 和updateService 配合使用
 */

public class UpdateManager {
    private static final UpdateManager ourInstance = new UpdateManager();
    private String downloadUrl = "";
    private UpdateDialog updateDialog;

    public static synchronized UpdateManager getInstance() {
        return ourInstance;
    }

    private UpdateManager() {
    }

    public Dialog getUpdateDialog() {
        if (updateDialog == null && HttpHelper.mContext != null)
            updateDialog = new UpdateDialog(HttpHelper.mContext, UpdateDialog.UpdateType.FORCE_UPDATE);
        return updateDialog;
    }

    public void setDownloadUrl(String url) {
        downloadUrl = url;
    }

    public void initDialog(final Activity activity) {
        updateDialog = new UpdateDialog(activity, UpdateDialog.UpdateType.FORCE_UPDATE);
        updateDialog.setOnSureListener(new UpdateDialog.onSureListener() {
            @Override
            public void onSure() {
                UpdateService.Builder.create(downloadUrl)//获取下载路径url
                        .setStoreDir("update/flag")//设置存储路径
                        .setDownloadSuccessNotificationFlag(Notification.DEFAULT_ALL)//设置下载成功的提醒
                        .setDownloadErrorNotificationFlag(Notification.DEFAULT_ALL)//设置下载失败的提醒
                        .build(activity);
                ToastUtils.showToastCenter("正在更新，可以在通知栏查看下载进度！");
            }
        });
    }
}
