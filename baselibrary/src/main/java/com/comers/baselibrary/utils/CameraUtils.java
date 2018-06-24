package com.comers.baselibrary.utils;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;

/**
 * Created by human on 2017/7/21.
 * 打开相机或者打开相册
 * 后期需要把权限集成进；来
 */

public class CameraUtils {
    public static void openAlbum(Activity activity, int requestcode) {
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");

        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        activity.startActivityForResult(intent, requestcode);
    }
    public static File openCamera(Activity activity, int requestCode) {
        if (!isSdcardExist()) {
            ToastUtils.showToast("SD卡不存在，无法打开相机！");
            return null;
        }

        File mCameraFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Camera/", System.currentTimeMillis() + ".jpg");
        //noinspection ResultOfMethodCallIgnored
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(activity, "com.donews.frame.fileprovider", mCameraFile);
        } else {
            uri = Uri.fromFile(mCameraFile);
        }
        mCameraFile.getParentFile().mkdirs();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, uri);
        activity.startActivityForResult(intent, requestCode);
        return mCameraFile;
    }

    public static boolean isSdcardExist() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static String getPath(Uri selectedImage, Activity activity) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = activity.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            cursor = null;

            if (picturePath == null || picturePath.equals("null")) {
                Toast toast = Toast.makeText(activity, "找不到图片", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return "";
            }
            return picturePath;
        } else {
            File file = new File(selectedImage.getPath());
            if (!file.exists()) {
                Toast toast = Toast.makeText(activity, "找不到图片", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                return "";

            }
            return file.getAbsolutePath();
        }

    }

}
