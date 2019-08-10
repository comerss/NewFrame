package com.comers.shenwu.instant_run.android.tools.ir.server;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Restarter {
    public static void restartActivityOnUiThread(Activity activity) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                if (Log.isLoggable("InstantRun", 2)) {
                    Log.v("InstantRun", "Resources updated: notify activities");
                }
                Restarter.updateActivity(this.val$activity);
            }
        });
    }

    private static void restartActivity(Activity activity) {
        if (Log.isLoggable("InstantRun", 2)) {
            Log.v("InstantRun", "About to restart " + activity.getClass().getSimpleName());
        }


        while (activity.getParent() != null) {
            if (Log.isLoggable("InstantRun", 2)) {
                Log.v("InstantRun", activity

                        .getClass().getSimpleName() + " is not a top level activity; restarting " + activity

                        .getParent().getClass().getSimpleName() + " instead");
            }

            activity = activity.getParent();
        }


        activity.recreate();
    }


    public static void restartApp(Context appContext, Collection<Activity> knownActivities, boolean toast) {
        if (!knownActivities.isEmpty()) {
            Activity foreground = getForegroundActivity(appContext);

            if (foreground != null) {

                if (toast) {
                    showToast(foreground, "Restarting app to apply incompatible changes");
                }
                if (Log.isLoggable("InstantRun", 2)) {
                    Log.v("InstantRun", "RESTARTING APP");
                }

                Context context = foreground;
                Intent intent = new Intent(context, foreground.getClass());
                int intentId = 0;
                PendingIntent pendingIntent = PendingIntent.getActivity(context, intentId, intent, 268435456);

                AlarmManager mgr = (AlarmManager) context.getSystemService("alarm");
                mgr.set(1, System.currentTimeMillis() + 100L, pendingIntent);
                if (Log.isLoggable("InstantRun", 2)) {
                    Log.v("InstantRun", "Scheduling activity " + foreground + " to start after exiting process");
                }


            } else {
                showToast((Activity) knownActivities.iterator().next(), "Unable to restart app");
                if (Log.isLoggable("InstantRun", 2)) {
                    Log.v("InstantRun", "Couldn't find any foreground activities to restart for resource refresh");
                }
            }


            System.exit(0);
        }
    }

    static void showToast(Activity activity, final String text) {
        if (Log.isLoggable("InstantRun", 2)) {
            Log.v("InstantRun", "About to show toast for activity " + activity + ": " + text);
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    Context context = this.val$activity.getApplicationContext();
                    if ((context instanceof ContextWrapper)) {
                        Context base = ((ContextWrapper) context).getBaseContext();
                        if (base == null) {
                            if (Log.isLoggable("InstantRun", 5)) {
                                Log.w("InstantRun", "Couldn't show toast: no base context");
                            }
                            return;
                        }
                    }


                    int duration = 0;
                    if ((text.length() >= 60) || (text.indexOf('\n') != -1)) {
                        duration = 1;
                    }


                    Toast.makeText(this.val$activity, text, duration).show();
                } catch (Throwable e) {
                    if (Log.isLoggable("InstantRun", 5)) {
                        Log.w("InstantRun", "Couldn't show toast", e);
                    }
                }
            }
        });
    }

    public static Activity getForegroundActivity(Context context) {
        List<Activity> list = getActivities(context, true);
        return list.isEmpty() ? null : (Activity) list.get(0);
    }


    public static List<Activity> getActivities(Context context, boolean foregroundOnly) {
        List<Activity> list = new ArrayList();
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Object activityThread = MonkeyPatcher.getActivityThread(context, activityThreadClass);
            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            activitiesField.setAccessible(true);


            if (hasAppCrashed(context, activityThreadClass, activityThread)) {
                return new ArrayList();
            }


            Object collection = activitiesField.get(activityThread);
            Collection c;
            if ((collection instanceof HashMap)) {
                Map activities = (HashMap) collection;
                c = activities.values();
            } else {
                Collection c;
                if ((Build.VERSION.SDK_INT >= 19) && ((collection instanceof ArrayMap))) {
                    activities = (ArrayMap) collection;
                    c = activities.values();
                } else {
                    return list;
                }
            }
            Collection c;
            for (Object activityClientRecord : c) {
                Class activityClientRecordClass = activityClientRecord.getClass();
                if (foregroundOnly) {
                    Field pausedField = activityClientRecordClass.getDeclaredField("paused");
                    pausedField.setAccessible(true);
                    if (pausedField.getBoolean(activityClientRecord)) {
                    }
                } else {
                    Field activityField = activityClientRecordClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    Activity activity = (Activity) activityField.get(activityClientRecord);
                    if (activity != null)
                        list.add(activity);
                }
            }
        } catch (Throwable e) {
            ArrayMap activities;
            if (Log.isLoggable("InstantRun", 5)) {
                Log.w("InstantRun", "Error retrieving activities", e);
            }
        }
        return list;
    }


    private static boolean hasAppCrashed(Context context, Class activityThreadClass, Object activityThread)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if ((context == null) || (activityThread == null)) {
            return false;
        }

        String currentPackageName = getPackageName(activityThreadClass, activityThread);


        ActivityManager manager = (ActivityManager) context.getSystemService("activity");

        List<ProcessErrorStateInfo> processesInErrorState = manager.getProcessesInErrorState();
        if (processesInErrorState != null) {
            for (ProcessErrorStateInfo info : processesInErrorState) {
                if ((info.processName.equals(currentPackageName)) && (info.condition != 0)) {
                    if (Log.isLoggable("InstantRun", 2)) {
                        Log.v("InstantRun", "App Thread has crashed, return empty activity list.");
                    }
                    return true;
                }
            }
        }
        return false;
    }


    private static String getPackageName(Class activityThreadClass, Object activityThread)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method currentPackageNameMethod = activityThreadClass.getDeclaredMethod("currentPackageName", new Class[0]);
        return (String) currentPackageNameMethod.invoke(activityThread, new Object[0]);
    }


    private static void updateActivity(Activity activity) {
        restartActivity(activity);
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/server/Restarter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */