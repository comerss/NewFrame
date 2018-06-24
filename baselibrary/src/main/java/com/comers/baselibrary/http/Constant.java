package com.comers.baselibrary.http;

public class Constant {

    //------------------------------------接口线上线下配置----------------------------------------------------------------
    //是否上线  影响   友盟、bugly  账号
    public static final boolean IS_DEBUG = true;
    //线上
//    public static final String Host = "https://app.liangyibang.com/";//默认线上
    //测试
    public static final String Host = "http://app2.zanchina.com/";
    //本地
//    public static final String Host = "http://10.0.0.21:8080/";
//    public static final String Host = "http://192.168.1.2:8080/";
    //--------------------------------登录------------------------------------------------------------
    /***
     * 登陆模块
     */
    //登陆接口
    //认证
    public static final String SIGN = "/verification/register";
    public static final String LOGIN_PASS = "/doctor/login/pass";
    //获取验证码接口
    public static final String VERIFY_CODE = "/verification/login";
    //验证码登陆接口
    public static final String VERIFY_LOGIN = "/doctor/login/validate";
    //退出登陆接口
    public static final String LOGINOUT = "/doctor/logout";
    //忘记密码的验证码
    public static final String VERIFICATION_FORGET = "/verification/forget";
    //忘记密码登陆
    public static final String FORGET_LOGIN = "/doctor/forget/pass";
    //app 崩溃日志
    public static final String CRASH_LOG = "/app/error";
    //获取科室、支撑
    public static final String DOCTOR_INFO = "/system/constant";
    //注册
    public static final String REGIST = "/doctor/register";
    //更新擅长
    public static final String UPDATE_SKILL = "/doctor/skill/update";
    //申请试用
    public static final String FORUSE_APPLY = "/doctor/apply/foruse";
    //认证信息
    public static final String SIGN_DOCTOR = "/doctor/authInfo/one";
    //修改图文问诊的开关
    public static final String SWITCN_GRAPHIC = "/doctor/switch/graphic";
    //专家面诊
    public static final String SWITCN_CLINIC = "/doctor/switch/clinic";
    //修改电话问诊的开关
    public static final String SWITCN_PHONE = "/doctor/switch/phone";
    //修改诊后咨询
    public static final String SWITCN_AFTER = "/doctor/switch/consultAfter";
    //修改免打扰时间
    public static final String UPDATE_ONDISTURB = "/doctor/unDisturb/update";
    //移除黑名单
    public static final String BLACK_REMOVE = "/doctor/black/remove";

    //------------------------------------------------------------------------------------------------
    /*首页接口
    * */
    public static class Home {
        //版本更新
        public static final String APP_UPDATE = "/app/version";
        //联系我们
        public static final String CUSTOM_SERVICE = "/system/customService";
        //黑名单列表
        public static final String BLACK_LIST = "/doctor/black/list";
        //擅长列表
        public static final String GET_SYMPTOS = "/symptoms/list";
        //消息已读
        public static final String READ = "/push/read/msg";
        //获取医生基本配置
        public static final String GET_DOCTOR_CONFIG = "/doctor/config";
        //获取医生基本信息
        public static final String GET_DOCTOR_INFO = "/doctor/baseInfo";
        //首页隐藏显示克数
        public static final String HIDE = "/doctor/switch/hideRecipel";
        //修改免打扰时间
        public static final String UPDATE_ONDISTURB = "/doctor/unDisturb/update";
        //修改服务开关
        public static final String SWITCH_SERVICE = "/doctor/switch/service";
        //退出登陆接口
        public static final String LOGINOUT = "/doctor/logout";
        //获取咨询列表
        public static final String GET_BOOKS_HOSTORY = "/doctor/books/history";
        //邀请医生获取邀请的个数
        public static final String INVITE_COUNT = "/doctor/invite/detail";
        //极光注册
        public static final String JPUSH = "/push/register/device";


        //获取已结算
        public static final String GET_BANK_PAYED = "/doctor/income/payed/list";
        //获取未结算
        public static final String GET_BANK_UNPAYED = "/doctor/income/unpay/list";
        //添加更新医生银行卡信息
        public static final String ADD_DOCTOR_BANKCARD = "/doctor/bankCard/update";
        //获取银行列表
        public static final String BANK_LIST = "/dict/list";
        //获取银行卡信息
        public static final String GET_DOCTOR_BACKCORD = "/doctor/bankCard";
        //获取流水明细
        public static final String GET_FLOW_DETAIL = "/doctor/flow/detail";

        //获取预约
        public static final String GET_APPOINTMENT_LIST = "/appointment/list";
        //获取预约列表
        public static final String GET_APPOINTMENT = "/appointment/detail";

        //获取通讯录
        public static final String GET_BOOKS = "/doctor/books";


        //公告列表
        public static final String GET_NOTICES = "/notices/list";
        //添加公告
        public static final String ADD_NOYICE = "/notices/add";
        //删除公告
        public static final String DELETE_NOTICE = "/notices/delete";
        //获取单个公告
        public static final String UPDATE_NOTICE = "/notices/update";

        //订单列表
        public static final String GET_ORDER_LIST = "/record/order/list";

        //诊后提问回答 patient/question/update?id=&answer=
        public static final String ANSWER = "/patient/question/update";
        //诊后提问详情 id
        public static final String QUESTION_DETAILS = "/patient/question/detail";
        //诊后提问列表
        public static final String QUESTION_LIST = "/patient/question/list";

        //消息列表
        public static final String MESSAGE_LIST = "/push/message/list";
        //修改简介
        public static final String UPDATE_INTRODUCTION = "/doctor/introduction/update";
        //修改关于我
        public static final String UPDATE_ABOUT = "/doctor/about/update";
        //忘记密码登陆
        public static final String FORGET_LOGIN = "/doctor/forget/pass";

    }

    /*模板接口*/
    public static class Template {
        //获取药方模板列表
        public static final String GET_TEMPLATE_LIST = "/recipel/template/list";
        //模板分组列表
        public static final String GROUP_LIST = "/recipel/template/group/list";
        //更新分组
        public static final String UPDATE_GROUP = "/recipel/template/group/update";
        //删除分组
        public static final String DELETE_GROUP = "/recipel/template/group/delete";
        //添加分组
        public static final String ADD_GROUP = "/recipel/template/group/add";
        //移动到分组
        public static final String MOVE_GROUP = "/recipel/template/move/group";
        //获取药方信息
        public static final String GET_TEMPLATE_ONE = "/recipel/template/one";
        //更新药方信息
        public static final String UPDATE_TEMPLATE = "/recipel/template/update";
    }

    /*开方接口*/
    public static class Evolution {
        //药房列表  /pharmacy/list
        public static final String HOSPITAL_LIST = "/pharmacy/list";
        //获取药方模板列表
        public static final String GET_TEMPLATE_LIST = "/recipel/template/list";
        //获取总价格
        public static final String GET_TOTAL_PRICE = "/drug/get/totalPrice";
        //根据拼音码获取药材名
        public static final String DRUG_LIST = "/drug/list";
        //获取服药时间。禁忌。忌口
        public static final String GET_DICT_LIST = "/dict/list";
        //汤剂毫升数
        public static final String ML = "/dict/list";
        //更新药方信息
        public static final String UPDATE_TEMPLATE = "/recipel/template/update";
        //添加药方模板
        public static final String ADD_TEMPLATE = "/recipel/template/add";
        //新建开方
        public static final String UPDATE_PRESC_ONEPRESC = "/recipel/presc/updatePresc";
        public static final String UPDATEPRESC = "/recipel/byMobile/presc/updatePresc";
        //获取辅料
        public static final String GET_ACCESS = "/drug/excipient/list";

        //获取辩证开方内容
        public static final String GET_RECIPEL_PRESC = "/recipel/presc/prescribe";
        public static final String GET_RECIPEL_BY_MOBILE = "/recipel/byMobile/presc/prescribe";

        //删除方子
        public static final String DELETE_PRESC = "/recipel/presc/deletePresc";

        //获取辨证开方编辑药方
        public static final String EDIT_PRESC_ONEPRESC = "/recipel/presc/onePresc";
        public static final String ONEPRESC_BY_MOBILE = "/recipel/byMobile/presc/onePresc";
        //预览页面数据
        public static final String GET_PREVIEW = "/recipel/presc/preview/detail";
        public static final String PREVIEW = "/recipel/presc/preview";
        public static final String PREVIEW_BY = "/recipel/byMobile/presc/preview";
        //复诊时间
        public static final String SECOND_TIME = "/recipel/presc/update/furtherTime";
        //预览发送给患者
        public static final String SEND_PREVIEW = "/recipel/presc/send";
        public static final String SEND_PREVIEW_BY = "/recipel/byMobile/presc/send";
        //开方记录
        public static final String TEM_HIS = "/recipel/history/list";
        //历史调理方案
        public static final String HISTORYS = "/record/history/list";

        //未完成订单详情
        public static final String UN_FINISHED = "/electron/recipel/detail";
        //拍方列表
        public static final String UN_FINISHED_LIST = "/electron/recipel/list";
        //拍照开方
        public static final String CREATE_CAMERA = "/electron/recipel/add";
        public static final String CREATE_CAMERA_BY_MOBILE = "/electron/recipel/byMobile/add";
        //新建患者
        public static final String CREATE_PATIENT = "/patient/findByMobileAndName";

        //获取患者详情
        public static final String GET_PATIENT_ARCHIVE = "/patient/archive";
        public static final String GET_PATIENT_WX = "/patient/archiveNoWx";

        //选择调理历史调理方案  ?choiceId=&patientId=&wxId=
        public static final String GET_HISTORY = "/record/choice/history";
        //获取颗粒剂药方的所有药的配比pharmacyId;
        public static final String GET_SCALE = "/drug/conversion/proportion";
        //拉黑患者
        public static final String BLACK = "/doctor/black/add";
    }

    /*聊天页面所有的接口*/
    public static class Chat {
        //获取历史消息
        public static final String HISTORY = "/sysMessage/get/history";
        //进入聊天界面请求接口
        public static final String DOCTOR_ONLINE = "/doctor/books/chat/online";
        //退出聊天界面
        public static final String DOCTOR_OFFLINE = "/doctor/books/chat/offline";
        //顶部的通知条
        public static final String STATUS = "/doctor/books/chat/electronStatus";
        //发送消息
        public static final String SEND_MESSAGE = "/sysMessage/save";
        //结束通话
        public static final String END_CHAT = "/doctor/end/chat";
        //补填问诊单
        public static final String FILL_LATE = "/inquiry/reInquiry";
        //赠送提问
        public static final String GIVE = "/doctor/consultAfter/largess";
        //邀请评价
        public static final String EVALUATE = "/comments/invitation";
        //坐诊信息
        public static final String SEND_SIT_INFO = "/schedule/send2patient";
        //退款
        public static final String REFUND = "/order/service/refund";
        //退款金额接口
        public static final String REFUND_PRICE = "/order/service/refundPrice";

        //获取快捷回复类别
        public static final String GET_QUICKREPLY_CATEGORY = "/quickReply/category";
        //添加快捷回复
        public static final String ADD_QUICKREPLY_CATEGORY = "/quickReply/add";
        //获取快捷回复消息
        public static final String GET_QUICKREPLY_INFO = "/quickReply/list";
        //删除快捷回复消息
        public static final String DELETE_QUICKREPLY_INFO = "/quickReply/delete";
        //更新快捷回复消息
        public static final String UPDATE_QUICKREPLY_INFO = "/quickReply/update";
        //拨打电话
        public static final String DOCTOR_CALL_PATIENT = "/doctor/call/patient";//
        //修改备注
        public static final String SET_PATIENT_REMARK = "/doctor/books/update/remark";
        //拍方订单 聊天页面
        public static final String SHOW_DETAILS = "/doctor/books/chat/electronStatus";
    }
}
