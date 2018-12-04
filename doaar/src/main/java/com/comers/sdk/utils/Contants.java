package com.comers.sdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by YJ on 2015/11/6.
 */
public class Contants {
    public static final int BANNER_REFRESHAD=112;
    public static final int SPLASH_FINISH=113;
    public static final int GETAD_SUCCESS=114;
    public static final int GETSPLASHAD_SUCCESS=116;
    public static final int GETNATIVEAD_SUCCESS=115;


    public static final int GETSWITCHAD_SUCCESS=117;
    public static final int GETSWITCHAD_FINISH=118;

    public static final int GETEXITAD_SUCCESS=119;
    public static final int GETEXITAD_FINISH=120;

    public static final int GET_NIUER_SPLASH_SUCCESS=121;

    public static final String AUTHKEY="tagtic";
    public static final String AUTHSECRET="9507acdf858c112e78a88dd5ac205ba3";
    public static final String AUTHKEY2="tagtic_2";
    public static final String AUTHSECRET2="08129b447495edbdbb2e0bb0e390d57a";
    public static final String AUTHKEY1="tagtic_1";
    public static final String AUTHSECRET1="8177ef5a76e8bd9705f557a7df558f75";

    public static final String AUTHKEY4="tagtic_4";
    public static final String AUTHSECRET4="828bca1d35fc936c714e7737c37fa992";
    public static String getDonewsKey(Context context) {
        String code = getMetaData(context, "DONEWS_AUTHKEY");
        if (code != null) {
            return code;
        }
        return "0";
    }
    public static String getDonewsSecret(Context context){
        String code=getMetaData(context,"DONEWS_AUTHSECRET");
        if(!TextUtils.isEmpty(code)){
            return code;
        }
        return "0";
    }
    public static String getDonewsDBName(Context context){
        String code=getMetaData(context,"DONEWS_DBNAME");
        if(!TextUtils.isEmpty(code)){
            return code;
        }
        return "donews";
    }

    private static String getMetaData(Context context, String key) {

        try {

            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(

                    context.getPackageName(), PackageManager.GET_META_DATA);

            Object value = ai.metaData.get(key);

            if (value != null) {

                return value.toString();

            }

        } catch (Exception e) {

            //

        }

        return null;

    }
}
