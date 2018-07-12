package com.bytedance.sdk.openadsdk.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by 79653 on 2018/7/12.
 * 描述：
 */
public class TTDownloadProvider extends ContentProvider {
    public TTDownloadProvider() {
    }

    public boolean onCreate() {
        return false;
    }

    @Nullable
    public Cursor query(@NonNull Uri var1, @Nullable String[] var2, @Nullable String var3, @Nullable String[] var4, @Nullable String var5) {
        return null;
    }

    @Nullable
    public String getType(@NonNull Uri var1) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri var1, @Nullable ContentValues var2) {
        return null;
    }

    public int delete(@NonNull Uri var1, @Nullable String var2, @Nullable String[] var3) {
        return 0;
    }

    public int update(@NonNull Uri var1, @Nullable ContentValues var2, @Nullable String var3, @Nullable String[] var4) {
        return 0;
    }
}

