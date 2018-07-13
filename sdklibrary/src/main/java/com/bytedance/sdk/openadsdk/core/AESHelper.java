package com.bytedance.sdk.openadsdk.core;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by 79653 on 2018/7/12.
 * 描述：
 */
public class AESHelper {
    public static String encrypt(String var0, String var1) {
        try {
            SecretKeySpec var2 = new SecretKeySpec(var1.getBytes(), "AES");
            Cipher var3 = Cipher.getInstance("AES/ECB/PKCS5Padding");
            var3.init(1, var2);
            byte[] var4 = var3.doFinal(var0.getBytes("utf-8"));
            String var5 = Base64.encodeToString(var4, 0);
            return var5;
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }
}
