package com.comers.baselibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by human on 2017/6/2.
 */

public class ImageUtils {
    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //保存文件到指定路径
    public static boolean saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "良医帮";
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            boolean isSuccess = bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos);
            fos.flush();
            fos.close();

            //把文件插入到系统图库
            //MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);

            //保存图片后发送广播通知更新数据库
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            if (isSuccess) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static File saveBitmapFile(Bitmap bitmap) {
        File file = new File("/mnt/sdcard/" + System.currentTimeMillis()
                + ".jpg");// 将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static File saveBitmapFile(Bitmap bitmap, String path) {
        File file = new File(path);// 将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void saveImage(String bitmap, String path) {
        Bitmap bitmap1 = getSmallBitmap(bitmap);
        saveBitmapFile(bitmap1, path);
    }

    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//等于true 的时候只是获取bitmap的大小，不加载到内存当中
        BitmapFactory.decodeFile(filePath, options);
        // Calculate inSampleSize  缩小为原来的1/9
        options.inSampleSize =3;
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, options);
    }

    public static Bitmap decodeScaleImage(String path, int width, int height) {
        BitmapFactory.Options options = getBitmapOptions(path);
        int var4 = calculateInSampleSize(options, width, height);
        options.inSampleSize = var4;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        int degree = readPictureDegree(path);
        Bitmap result = null;
        if (bitmap != null && degree != 0) {
            result = rotaingImageView(degree, bitmap);
            bitmap.recycle();
            bitmap = null;
            return result;
        } else {
            return bitmap;
        }
    }

    public static Bitmap decodeScaleImage(Context context, int id, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), id, options);
        int var6 = calculateInSampleSize(options, width, height);
        options.inSampleSize = var6;
        options.inJustDecodeBounds = false;
        Bitmap var4 = BitmapFactory.decodeResource(context.getResources(), id, options);
        return var4;
    }

    public static int calculateInSampleSize(BitmapFactory.Options option, int width, int height) {
        int outHeight = option.outHeight;
        int outWidth = option.outWidth;
        int var5 = 1;
        if (outHeight > height || outWidth > width) {
            int var6 = Math.round((float) outHeight / (float) height);
            int var7 = Math.round((float) outWidth / (float) width);
            var5 = var6 > var7 ? var6 : var7;
        }

        return var5;
    }

    public static String getScaledImage(Context context, String path, int var2) {
        File file = new File(path);
        if (file.exists()) {
            long length = file.length();
            if (length > 102400L) {
                Bitmap bitmap = decodeScaleImage(path, 640, 960);

                try {
                    File result = new File(context.getExternalCacheDir(), "eaemobTemp" + var2 + ".jpg");
                    FileOutputStream outputStream = new FileOutputStream(result);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 60, outputStream);
                    outputStream.close();
                    return result.getAbsolutePath();
                } catch (Exception var9) {
                    var9.printStackTrace();
                }
            }
        }

        return path;
    }

    public static int readPictureDegree(String path) {
        short degree = 0;

        try {
            ExifInterface var2 = new ExifInterface(path);
            int var3 = var2.getAttributeInt("Orientation", 1);
            switch (var3) {
                case 3:
                    degree = 180;
                case 4:
                case 5:
                case 7:
                default:
                    break;
                case 6:
                    degree = 90;
                    break;
                case 8:
                    degree = 270;
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return degree;
    }

    public static Bitmap rotaingImageView(int degree, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) degree);
        Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return result;
    }

    public static BitmapFactory.Options getBitmapOptions(String pathName) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, options);
        return options;
    }

    public static String getPath(Context context, Uri selectedImage) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            cursor = null;

            if (picturePath == null || picturePath.equals("null")) {
                return "";
            }
            return picturePath;
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(context, "找不到图片", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return "";

            }
            return file.getAbsolutePath();
        }
    }

    //往SD卡写入文件的方法
    public void savaFileToSD(String filePath, byte[] bytes) throws Exception {
        //如果手机已插入sd卡,且app具有读写sd卡的权限
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File dir1 = new File(filePath);
            if (!dir1.exists()){
                dir1.mkdirs();
            }
            //这里就不要用openFileOutput了,那个是往手机内存中写数据的
            FileOutputStream output = new FileOutputStream(filePath);
            output.write(bytes);
            //将bytes写入到输出流中
            output.close();
            //关闭输出流
//            Toast.makeText(context, "图片已成功保存到"+filePath, Toast.LENGTH_SHORT).show();
        }
    }


}
