package com.comers.shenwu.instant_run.android.tools.ir.runtime;


import com.comers.shenwu.instant_run.android.tools.ir.common.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;


public abstract class AbstractPatchesLoaderImpl
        implements PatchesLoader {
    private final Method get;
    private final Method set;

    public AbstractPatchesLoaderImpl()
            throws NoSuchMethodException {
        this.get = AtomicReference.class.getMethod("get", new Class[0]);
        this.set = AtomicReference.class.getMethod("set", new Class[]{Object.class});
    }

    public abstract String[] getPatchedClasses();

    public boolean load() {
        for (String className : getPatchedClasses()) {
            try {
                ClassLoader cl = getClass().getClassLoader();
                Class<?> aClass = cl.loadClass(className + "$override");
                Object o = aClass.newInstance();

                Class<?> originalClass = cl.loadClass(className);
                Field changeField = originalClass.getDeclaredField("$change");


                changeField.setAccessible(true);


                Object previous = originalClass.isInterface() ? patchInterface(changeField, o) : patchClass(changeField, o);


                if (previous != null) {
                    Field isObsolete = previous.getClass().getDeclaredField("$obsolete");
                    if (isObsolete != null) {
                        isObsolete.set(null, Boolean.valueOf(true));
                    }
                }

                if ((Log.logging != null) && (Log.logging.isLoggable(Level.FINE))) {
                    Log.logging.log(Level.FINE, String.format("patched %s", new Object[]{className}));
                }
            } catch (Exception e) {
                if (Log.logging != null) {
                    Log.logging.log(Level.SEVERE,

                            String.format("Exception while patching %s", new Object[]{className}), e);
                }

                return false;
            }
        }
        return true;
    }


    private Object patchInterface(Field changeField, Object patch)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object atomicReference = changeField.get(null);
        Object previous = this.get.invoke(atomicReference, new Object[0]);
        this.set.invoke(atomicReference, new Object[]{patch});
        return previous;
    }


    private Object patchClass(Field changeField, Object patch)
            throws IllegalAccessException {
        Object previous = changeField.get(null);
        changeField.set(null, patch);
        return previous;
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/runtime/AbstractPatchesLoaderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */