package com.comers.shenwu.instant_run.android.tools.ir.server;

import android.util.Log;


import java.util.logging.Level;


public class Logging {
    public static final String LOG_TAG = "InstantRun";

    static {
        com.android.tools.ir.common.Log.logging = new Log.Logging() {
            public void log(Level level, String string) {
                log(level, string, null);
            }

            public boolean isLoggable(Level level) {
                if (level == Level.SEVERE)
                    return Log.isLoggable("InstantRun", 6);
                if (level == Level.FINE)
                    return Log.isLoggable("InstantRun", 2);
                return Log.isLoggable("InstantRun", 4);
            }


            public void log(Level level, String string, Throwable throwable) {
                if (level == Level.SEVERE) {
                    if (throwable == null) {
                        Log.e("InstantRun", string);
                    } else {
                        Log.e("InstantRun", string, throwable);
                    }
                } else if (level == Level.FINE) {
                    if (Log.isLoggable("InstantRun", 2)) {
                        if (throwable == null) {
                            Log.v("InstantRun", string);
                        } else {
                            Log.v("InstantRun", string, throwable);
                        }
                    }
                } else if (Log.isLoggable("InstantRun", 4)) {
                    if (throwable == null) {
                        Log.i("InstantRun", string);
                    } else {
                        Log.i("InstantRun", string, throwable);
                    }
                }
            }
        };
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/server/Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */