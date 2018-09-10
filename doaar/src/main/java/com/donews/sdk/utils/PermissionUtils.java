package com.donews.sdk.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.PermissionChecker;

/**
 * Created by YJ on 2016/5/16.
 */
public class PermissionUtils {
    // 所需的手机权限
    public static final String[] PERMISSIONS_PHONE = new String[]{
            Manifest.permission.READ_PHONE_STATE
    };
    // 所需的读写权限
    public static final String[] PERMISSIONS_FILE = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static final String[] PERMISSION_LOCATION=new String[]{
      Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
//    private final Context mContext;
//
//    public PermissionUtils(Context context) {
//        mContext = context.getApplicationContext();
//    }
//
//    // 判断权限集合
//    public boolean lacksPermissions(String... permissions) {
//        for (String permission : permissions) {
//            if (lacksPermission(permission)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // 判断是否缺少权限
//    private boolean lacksPermission(String permission) {
//        PackageManager pm = mContext.getPackageManager();
//        boolean isPermission = (PackageManager.PERMISSION_GRANTED ==
//                pm.checkPermission(permission, PhoneInfoUtils.getPkg(mContext)));
////        return ContextCompat.checkSelfPermission(mContext, permission) ==
////                PackageManager.PERMISSION_DENIED;
//        return !isPermission;
//    }

    public static boolean checkPermission(Context context, String... permissions) {
        for (String permission : permissions) {
            int granted = PermissionChecker.checkCallingPermission(context.getApplicationContext(),permission, context.getPackageName());
            if (granted == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
}
