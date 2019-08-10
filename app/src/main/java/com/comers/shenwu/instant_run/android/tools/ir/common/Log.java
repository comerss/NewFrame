package com.comers.shenwu.instant_run.android.tools.ir.common;

import java.util.logging.Level;


public class Log {
    public static Logging logging = null;

    public static abstract interface Logging {
        public abstract void log(Level paramLevel, String paramString);

        public abstract boolean isLoggable(Level paramLevel);

        public abstract void log(Level paramLevel, String paramString, Throwable paramThrowable);
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/common/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */