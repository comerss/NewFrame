package com.comers.shenwu.instant_run.android.tools.ir.server;

import android.util.Log;

import com.android.tools.ir.runtime.Paths;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class FileManager {
    static final boolean USE_EXTRACTED_RESOURCES = false;
    private static final String RESOURCE_FILE_NAME = "resources.ap_";
    private static final String RESOURCE_FOLDER_NAME = "resources";
    private static final String FILE_NAME_ACTIVE = "active";
    private static final String FOLDER_NAME_LEFT = "left";
    private static final String FOLDER_NAME_RIGHT = "right";
    private static final String RELOAD_DEX_PREFIX = "reload";
    public static final String CLASSES_DEX_SUFFIX = ".dex";
    private static boolean havePurgedTempDexFolder;

    private static File getDataFolder() {
        return new File(Paths.getDataDirectory(AppInfo.applicationId));
    }


    private static File getResourceFile(File base) {
        return new File(base, "resources.ap_");
    }


    private static File getTempDexFileFolder(File base) {
        return new File(base, "dex-temp");
    }

    public static File getNativeLibraryFolder() {
        return new File(Paths.getMainApkDataDirectory(AppInfo.applicationId), "lib");
    }


    public static File getReadFolder() {
        String name = leftIsActive() ? "left" : "right";
        return new File(getDataFolder(), name);
    }


    public static void swapFolders() {
        setLeftActive(!leftIsActive());
    }


    public static File getWriteFolder(boolean wipe) {
        String name = leftIsActive() ? "right" : "left";
        File folder = new File(getDataFolder(), name);
        if ((wipe) && (folder.exists())) {
            delete(folder);
            boolean mkdirs = folder.mkdirs();
            if (!mkdirs) {
                Log.e("InstantRun", "Failed to create folder " + folder);
            }
        }
        return folder;
    }

    private static void delete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File child : files) {
                    delete(child);
                }
            }
        }


        boolean deleted = file.delete();
        if (!deleted) {
            Log.e("InstantRun", "Failed to delete file " + file);
        }
    }

    private static boolean leftIsActive() {
        File folder = getDataFolder();
        File pointer = new File(folder, "active");
        if (!pointer.exists()) {
            return true;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pointer));
            try {
                String line = reader.readLine();
                return "left".equals(line);
            } finally {
                reader.close();
            }

            return true;
        } catch (IOException ignore) {
        }
    }

    private static void setLeftActive(boolean active) {
        File folder = getDataFolder();
        File pointer = new File(folder, "active");
        if (pointer.exists()) {
            boolean deleted = pointer.delete();
            if (!deleted) {
                Log.e("InstantRun", "Failed to delete file " + pointer);
            }
        } else if (!folder.exists()) {
            boolean create = folder.mkdirs();
            if (!create) {
                Log.e("InstantRun", "Failed to create directory " + folder);
            }
            return;
        }
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pointer), "UTF-8"));
            try {
                writer.write(active ? "left" : "right");
            } finally {
                writer.close();
            }
        } catch (IOException localIOException) {
        }
    }


    public static File getExternalResourceFile() {
        File file = getResourceFile(getReadFolder());
        if (!file.exists()) {
            if (Log.isLoggable("InstantRun", 2)) {
                Log.v("InstantRun", "Cannot find external resources, not patching them in");
            }
            return null;
        }

        return file;
    }


    public static File getTempDexFile() {
        File dataFolder = getDataFolder();
        File dexFolder = getTempDexFileFolder(dataFolder);
        if (!dexFolder.exists()) {
            boolean created = dexFolder.mkdirs();
            if (!created) {
                Log.e("InstantRun", "Failed to create directory " + dexFolder);
                return null;
            }


            havePurgedTempDexFolder = true;


        } else if (!havePurgedTempDexFolder) {
            purgeTempDexFiles(dataFolder);
        }


        File[] files = dexFolder.listFiles();
        int max = -1;


        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                if ((name.startsWith("reload")) && (name.endsWith(".dex"))) {
                    String middle = name.substring("reload".length(), name
                            .length() - ".dex".length());
                    try {
                        int version = Integer.decode(middle).intValue();
                        if (version > max) {
                            max = version;
                        }
                    } catch (NumberFormatException localNumberFormatException) {
                    }
                }
            }
        }

        String fileName = String.format("%s0x%04x%s", new Object[]{"reload", Integer.valueOf(max + 1), ".dex"});

        File file = new File(dexFolder, fileName);

        if (Log.isLoggable("InstantRun", 2)) {
            Log.v("InstantRun", "Writing new dex file: " + file);
        }

        return file;
    }

    /* Error */
    public static boolean writeRawBytes(File destination, byte[] bytes) {
        // Byte code:
        //   0: new 78	java/io/BufferedOutputStream
        //   3: dup
        //   4: new 47	java/io/FileOutputStream
        //   7: dup
        //   8: aload_0
        //   9: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   12: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   15: astore_2
        //   16: aload_2
        //   17: aload_1
        //   18: invokevirtual 80	java/io/BufferedOutputStream:write	([B)V
        //   21: aload_2
        //   22: invokevirtual 81	java/io/BufferedOutputStream:flush	()V
        //   25: iconst_1
        //   26: istore_3
        //   27: aload_2
        //   28: invokevirtual 82	java/io/BufferedOutputStream:close	()V
        //   31: iload_3
        //   32: ireturn
        //   33: astore 4
        //   35: aload_2
        //   36: invokevirtual 82	java/io/BufferedOutputStream:close	()V
        //   39: aload 4
        //   41: athrow
        //   42: astore_2
        //   43: ldc 23
        //   45: new 24	java/lang/StringBuilder
        //   48: dup
        //   49: invokespecial 25	java/lang/StringBuilder:<init>	()V
        //   52: ldc 83
        //   54: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   57: aload_0
        //   58: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   61: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   64: aload_2
        //   65: invokestatic 84	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   68: pop
        //   69: new 85	java/lang/RuntimeException
        //   72: dup
        //   73: ldc 86
        //   75: iconst_1
        //   76: anewarray 74	java/lang/Object
        //   79: dup
        //   80: iconst_0
        //   81: aload_0
        //   82: aastore
        //   83: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   86: invokespecial 87	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
        //   89: athrow
        // Line number table:
        //   Java source line #288	-> byte code offset #0
        //   Java source line #290	-> byte code offset #16
        //   Java source line #291	-> byte code offset #21
        //   Java source line #292	-> byte code offset #25
        //   Java source line #294	-> byte code offset #27
        //   Java source line #292	-> byte code offset #31
        //   Java source line #294	-> byte code offset #33
        //   Java source line #296	-> byte code offset #42
        //   Java source line #297	-> byte code offset #43
        //   Java source line #301	-> byte code offset #69
        //   Java source line #302	-> byte code offset #83
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	destination	File
        //   0	90	1	bytes	byte[]
        //   15	21	2	output	java.io.BufferedOutputStream
        //   42	23	2	ioe	IOException
        //   33	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	27	33	finally
        //   33	35	33	finally
        //   0	31	42	java/io/IOException
        //   33	42	42	java/io/IOException
    }

    public static boolean extractZip(File destination, byte[] zipBytes) {
        Log.wtf("InstantRun", "");
        return false;
    }


    public static void startUpdate() {
        getWriteFolder(true);
    }

    public static void finishUpdate(boolean wroteResources) {
        if (wroteResources) {
            swapFolders();
        }
    }

    public static void writeAaptResources(String relativePath, byte[] bytes) {
        File resourceFile = getResourceFile(getWriteFolder(false));
        File file = resourceFile;


        File folder = file.getParentFile();
        if (!folder.isDirectory()) {
            boolean created = folder.mkdirs();
            if (!created) {
                if (Log.isLoggable("InstantRun", 2)) {
                    Log.v("InstantRun", "Cannot create local resource file directory " + folder);
                }
                return;
            }
        }

        if (relativePath.equals("resources.ap_")) {


            writeRawBytes(file, bytes);
        } else {
            writeRawBytes(file, bytes);
        }
    }

    public static String writeTempDexFile(byte[] bytes) {
        File file = getTempDexFile();
        if (file != null) {
            writeRawBytes(file, bytes);
            return file.getPath();
        }
        Log.e("InstantRun", "No file to write temp dex content to");

        return null;
    }


    public static void purgeTempDexFiles(File dataFolder) {
        havePurgedTempDexFolder = true;

        File dexFolder = getTempDexFileFolder(dataFolder);
        if (!dexFolder.isDirectory()) {
            return;
        }
        File[] files = dexFolder.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.getPath().endsWith(".dex")) {
                boolean deleted = file.delete();
                if (!deleted) {
                    Log.e("InstantRun", "Could not delete temp dex file " + file);
                }
            }
        }
    }


    public static long getFileSize(String path) {
        return -1L;
    }


    public static byte[] getCheckSum(String path) {
        return null;
    }


    public static byte[] getCheckSum(File file) {
        return null;
    }
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/server/FileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */