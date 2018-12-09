package com.comers.sdk.base;

/**
 * Created by 79653 on 2018/7/2.
 * 描述：
 */
public enum CrashHelper {
    INSTANCE;

    public void init() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }

    /**
     * 全局捕获异常类
     */
    class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread thread, final Throwable ex) {
            ex.printStackTrace();
            //需要保存本地，或者上传服务器
            upload(ex);
        }
    }

    private void upload(Throwable ex) {
        //收集错误信息
        StringBuffer exceptionStr = new StringBuffer();
        exceptionStr.append(ex.getLocalizedMessage());
        exceptionStr.append("\n");
        exceptionStr.append(ex.getMessage());
        StackTraceElement[] elements = ex.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            exceptionStr.append(elements[i].toString());
            exceptionStr.append("\n");
        }
        String str=exceptionStr.toString();
        //判断如果是自己的SDK异常否则认定是用户端异常我们不予处理！
        if(str.contains("com.donews.sdk")){
            //异常处理机制
        }
    }
}
