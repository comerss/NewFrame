package com.comers.shenwu.instant_run.android.tools.ir.runtime;


public final class Paths {
    public static final String DEVICE_TEMP_DIR = "/data/local/tmp";


    public static final String BUILD_ID_TXT = "build-id.txt";


    public static final String RESOURCE_FILE_NAME = "resources.ap_";


    public static final String RELOAD_DEX_FILE_NAME = "classes.dex.3";


    public static String getMainApkDataDirectory(String applicationId) {
        return "/data/data/" + applicationId;
    }

    public static String getDataDirectory(String applicationId) {
        return "/data/data/" + applicationId + "/files/instant-run";
    }

    public static String getDeviceIdFolder(String pkg) {
        return "/data/local/tmp/" + pkg + "-" + "build-id.txt";
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/runtime/Paths.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */