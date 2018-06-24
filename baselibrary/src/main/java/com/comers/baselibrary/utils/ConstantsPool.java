package com.comers.baselibrary.utils;

import android.os.Environment;

/**
 * Created by human on 2017/5/28.
 * 常量池
 */
public class ConstantsPool {

    public static  boolean SCALE_FAIL =true ;
    //File root
    public static String FILE_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath() + "/liangyiabng/";

    //是否登录过
    public static final String IS_LOGIN ="IS_LOGIN";
    //储存token
    public static final String TOKEN="TOKEN";
    //存储用户手机号
    public static final String DOCTOR_PHONE ="DOCTOR_PHONE";
    //存储环信ID和账号
    public static final String IM_ID ="IM_ID";
    public static final String IM_PASSWORD ="IM_PASSWORD";
    //用户协议URL1
    public static final String USE_RAGREEMENT_URL ="USE_RAGREEMENT_URL";
    //常见问题URL1
    public static final String FAQURL="FAQURL";
    //结算说明URL1
    public static final String BALANCEE_URL ="BALANCEE_URL";
    //通话时间
    public static final String CALL_MOBIL_ESECOND ="CALL_MOBIL_ESECOND";
    //调理方案1
    public static final String RECIPEL_URL ="RECIPEL_URL";
    //订单详情// 开方数
    public static final String ORDER_DETAILS ="ORDER_DETAILS";
    //问诊单详情
    public static final String INQURY_DETAILURL ="INQURY_DETAILURL";
    //退款详情1
    public static final String REFUND_DETIALS ="REFUND_DETIALS";
    //坐诊信息
    public static final String DIAGNOSE_DETAILS ="DIAGNOSE_DETAILS";
    //如何开膏方1
    public static final String PASTE_PRESC_URL ="PASTE_PRESC_URL";
    //页面的SIze
    public static final int PAGE_SIZE=10;
    //账号的头像地址
    public static final String DOCTOR_HEAD_URL="DOCTOR_HEAD_URL";
    //医生姓名
    public static final String DOCTOR_NAME="DOCTOR_NAME";
    //首页服务开关
    public static final String SWITCH_STATUS="SWITCH_STATUS";
    //存储服务电话
    public static final String SERVICE_PHONENUM="SERVICE_PHONENUM";
    public static final String RECIPEL_EXAMPLEURL="RECIPE_LEXAMPLEURL";

    //---------聊天--
    public static final int SEND_TXT=1;
    public static final int SEND_IMG=2;
    public static final int SEND_CUSTOM=3;

    public static final int FROM_TXT=5;
    public static final int FROM_IMG=6;
    public static final int FROM_CUSTOM=7;

    public static final int SYSTEM=8;
    //应用宝下载地址
    public static final String DOWNLOAD_URL="http://a.app.qq.com/o/simple.jsp?pkgname=com.liangyibang.lyb";

    //receiver
    public static final String RECEIVER_ACTION="com.liangyibang.wake";

    public static final String Local="Local";
    public static final String SCALE="SCALE";
}
