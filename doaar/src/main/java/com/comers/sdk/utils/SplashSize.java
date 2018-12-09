package com.comers.sdk.utils;

import android.content.Context;


/**
 * Created by yujuan on 2017/11/15.
 */
public class SplashSize {
    public static void requestSize(Context context){
//        SplashSizeModel model=new SplashSizeModel(context);
//        List<SizeEntity> sizeEntities=model.querySize();
        int oldTime=ADFileUtils.getOldTime(context);
//        if(sizeEntities!=null && sizeEntities.size()>0){
            int curTime= (int) (System.currentTimeMillis()/1000/60);
//            int oldTime=sizeEntities.get(0).getTimestamp();
            if(curTime-oldTime>24*60){
                URLUtils.getSplashSize(context);
//            }
        }else {
            URLUtils.getSplashSize(context);
        }
    }
}
