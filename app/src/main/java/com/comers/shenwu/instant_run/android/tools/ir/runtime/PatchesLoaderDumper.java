package com.comers.shenwu.instant_run.android.tools.ir.runtime;


public class PatchesLoaderDumper {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.android.tools.ir.runtime.AppPatchesLoaderImpl");
            PatchesLoader patchesLoader = (PatchesLoader) aClass.newInstance();
            patchesLoader.load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/runtime/PatchesLoaderDumper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */