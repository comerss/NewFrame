package com.comers.baselibrary.base;

import android.util.Log;

/**
 * Created by 79653 on 2018/11/7.
 * 描述：
 */
public class LogUtils {
    private static final int VERBOSE = 2;
    private static final int DEBUG = 3;
    private static final int INFO = 4;
    private static final int WARN = 5;
    private static final int ERROR = 6;
    private static final int ASSERT = 7;

    public static class IsRelease {
        public static boolean DEBUG = true;
    }

    private static void log(int logType, String tagStr, Object objects) {
        String[] contents = wrapperContent(tagStr, objects);
        String tag = contents[0];
        String msg = contents[1];
        String headString = contents[2];
        if (IsRelease.DEBUG) {
            switch (logType) {
                case VERBOSE:
                case DEBUG:
                case INFO:
                case WARN:
                case ERROR:
                case ASSERT:
                    printDefault(logType, tag, headString + msg);
                    break;
                default:
                    break;
            }
        }
    }

    private static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int maxLength = 4000;
        int countOfSub = msg.length() / maxLength;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + maxLength);
                printSub(type, tag, sub);
                index += maxLength;
            }
        } else {
            printSub(type, tag, msg);
        }

    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case VERBOSE:
                Log.v(tag, sub);
                break;
            case DEBUG:
                Log.d(tag, sub);
                break;
            case INFO:
                Log.i(tag, sub);
                break;
            case WARN:
                Log.w(tag, sub);
                break;
            case ERROR:
                Log.e(tag, sub);
                break;
            case ASSERT:
                Log.wtf(tag, sub);
                break;
            default:
                break;
        }
    }

    private static String[] wrapperContent(String tag, Object... objects) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement targetElement = stackTrace[5];
        String className = targetElement.getClassName();
        String[] classNameInfo = className.split("\\.");
        if (classNameInfo.length > 0) {
            className = classNameInfo[classNameInfo.length - 1] + ".java";
        }
        String methodName = targetElement.getMethodName();
        int lineNumber = targetElement.getLineNumber();
        if (lineNumber < 0) {
            lineNumber = 0;
        }
        String methodNameShort = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        String msg = (objects == null) ? "Log with null object" : getObjectsString(objects);
        String headString = "[(" + className + ":" + lineNumber + ")#" + methodNameShort + " ] ";
        return new String[]{tag, msg, headString};
    }

    private static String getObjectsString(Object... objects) {

        if (objects.length > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];
                if (object == null) {
                    stringBuilder.append("param").append("[").append(i).append("]").append(" = ").append("null").append("\n");
                } else {
                    stringBuilder.append("param").append("[").append(i).append("]").append(" = ").append(object.toString()).append("\n");
                }
            }
            return stringBuilder.toString();
        } else {
            Object object = objects[0];
            return object == null ? "null" : object.toString();
        }
    }


    public static void v(String tag, String msg) {
        if (IsRelease.DEBUG) {
            log(VERBOSE, tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (IsRelease.DEBUG) {
            log(DEBUG, tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (IsRelease.DEBUG) {
            log(INFO, tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (IsRelease.DEBUG) {
            log(WARN, tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (IsRelease.DEBUG) {
            log(ERROR, tag, msg);
        }
    }

    public static void a(String tag, String msg) {
        if (IsRelease.DEBUG) {
            log(ASSERT, tag, msg);
        }
    }
}