package com.comers.baselibrary.download;


import com.comers.baselibrary.utils.UIUtils;

import org.greenrobot.greendao.database.Database;

import java.util.List;

/**
 * Created by 79653 on 2018/7/25.
 * 描述：
 */
public class DownDbHelper {

    private static DaoSession mDaoSession;
    private static DownDbHelper mDbHelper;

    private DownDbHelper() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext(), "donewss.db");
        Database database = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public static DownDbHelper instance() {
        if (mDbHelper == null) {
            synchronized (DownDbHelper.class) {
                if (mDbHelper == null) {
                    mDbHelper = new DownDbHelper();
                }
            }
        }
        return mDbHelper;
    }

    public void inserOrReplace(DownLoadInfo info) {
        if(contains(info.url)){
            mDaoSession.getDownLoadInfoDao().update(info);
        }else{
            mDaoSession.getDownLoadInfoDao().insert(info);
        }
    }
    public void update(DownLoadInfo info){
        mDaoSession.insertOrReplace(info);
    }
    public boolean contains(String url) {
        List<DownLoadInfo> infos = mDaoSession.getDownLoadInfoDao().queryBuilder().where(DownLoadInfoDao.Properties.Url.eq(url)).list();
       if(infos!=null&&!infos.isEmpty()){
           return true;
       }
       return false;
    }

    public DownLoadInfo getInfo(String url) {
//        mDaoSession.getDownLoadInfoDao().queryBuilder().where(DownLoadInfoDao.Properties.Url.eq(url)).distinct();
        List<DownLoadInfo> infos = mDaoSession.getDownLoadInfoDao().queryBuilder().where(DownLoadInfoDao.Properties.Url.eq(url)).list();
        if (infos == null || infos.isEmpty()) {
            DownLoadInfo info=new DownLoadInfo();
            info.url=url;
            info.notifyID= UrlManager.INSTANCE.get(url);
            return null;
        }
        return infos.get(0);
    }
}
