/*     */ package com.bytedance.sdk.openadsdk.dddd;
/*     */ 
/*     */ import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bytedance.sdk.openadsdk.b.NativeHelper;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.d;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AdEvent
/*     */ {
/*  34 */   private static Map<com.bytedance.sdk.openadsdk.core.nibuguan.h, h> a = new WeakHashMap();
/*     */   
/*     */   public static void a(com.bytedance.sdk.openadsdk.core.nibuguan.h paramh) {
/*  37 */     if (a.containsKey(paramh)) {
/*  38 */       return;
/*     */     }
/*  40 */     a.put(paramh, new h());
/*     */   }
/*     */   
/*     */   public static boolean b(com.bytedance.sdk.openadsdk.core.nibuguan.h paramh) {
/*  44 */     h localh = (h)a.get(paramh);
/*  45 */     return (localh != null) && (localh.b());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */
public static void show(Context var0, com.bytedance.sdk.openadsdk.core.nibuguan.h var1, String var2) {
    var0 = n.a();
    com.bytedance.sdk.openadsdk.dddd.h var3 = a.get(var1);
    boolean var4 = false;
    if (var3 != null && !var4 || var3 != null && !var3.b()) {
        var3.a(true);
        var3.a(SystemClock.elapsedRealtime());
        JSONObject var5 = new JSONObject();

        try {
            JSONObject var6 = new JSONObject();
            var6.put("device", d.d(var0).toString());
            var6.put("is_cache", var1.u() ? 1 : 0);
            var5.put("ad_extra_data", var6.toString());
            var5.putOpt("log_extra", var1.o());
        } catch (JSONException var9) {
            ;
        }

        a var10 = com.bytedance.sdk.openadsdk.dddd.a.a(var0, var2, "show", var1.l(), var5);
        n.b().a(var10);
        String var7 = i.a(n.a());
        if (!TextUtils.isEmpty(var7)) {
            List var8 = var1.h();
            n.d().a(var7, var8, true);
        }

        if (LogUtils.isDebug) {
            LogUtils.c("AdEvent", "show " + var1.l());
        }
    }

}/*     */
/*     */   public static void a(com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2, long paramLong) {
/*  84 */     JSONObject localJSONObject1 = new JSONObject();
/*     */     try {
/*  86 */       JSONObject localJSONObject2 = new JSONObject();
/*  87 */       localJSONObject2.put("device", d.d(n.a()).toString());
/*  88 */       if (paramString2.equals("download_creative_duration")) {
/*  89 */         localJSONObject2.put("download_creative_duration", paramLong);
/*  90 */       } else if (paramString2.equals("load_ad_duration")) {
/*  91 */         localJSONObject2.put("load_ad_duration", paramLong);
/*     */       }
/*  93 */       localJSONObject1.put("ad_extra_data", localJSONObject2.toString());
/*  94 */       localJSONObject1.putOpt("log_extra", paramh.o());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/*  97 */     a locala = com.bytedance.sdk.openadsdk.dddd.a.a(n.a(), paramString1, paramString2, paramh.l(), localJSONObject1);
/*  98 */     n.b().a(locala);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(Context paramContext, String paramString1, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, com.bytedance.sdk.openadsdk.core.nibuguan.c paramc, String paramString2, boolean paramBoolean)
/*     */   {
/* 107 */     paramContext = n.a();
/* 108 */     h localh = (h)a.get(paramh);
/* 109 */     if ((localh != null) && (localh.b())) {
/* 110 */       JSONObject localJSONObject1 = new JSONObject();
/*     */       try {
/* 112 */         if (paramc != null) {
/* 113 */           JSONObject localJSONObject2 = paramc.a();
/* 114 */           localJSONObject2.put("device", d.d(paramContext).toString());
/* 115 */           localJSONObject2.put("is_valid", paramBoolean);
/* 116 */           localJSONObject1.put("ad_extra_data", localJSONObject2.toString());
/*     */         }
/* 118 */         localJSONObject1.putOpt("log_extra", paramh.o());
/* 119 */         long l = localh.a();
/* 120 */         localJSONObject1.putOpt("showtime", Long.valueOf(l > 0L ? SystemClock.elapsedRealtime() - l : -1L));
/*     */       }
/*     */       catch (JSONException localJSONException) {}
/* 123 */       a locala = com.bytedance.sdk.openadsdk.dddd.a.a(paramContext, paramString2, paramString1, paramh.l(), localJSONObject1);
/* 124 */       n.b().a(locala);
/*     */       
/* 126 */       String str = i.a(n.a());
/* 127 */       if ((!TextUtils.isEmpty(str)) && ("click".equals(paramString1))) {
/* 128 */         List localList = paramh.i();
/* 129 */         n.d().a(str, localList, true);
/*     */       }
/* 131 */       if (LogUtils.isDebug) {
/* 132 */         LogUtils.c("AdEvent", paramString1 + " " + paramh.l());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void a(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2) {
/* 138 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public static void b(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2) {
/* 142 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void c(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2)
/*     */   {
/* 149 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void d(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2)
/*     */   {
/* 158 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void e(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2)
/*     */   {
/* 165 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void c(@NonNull com.bytedance.sdk.openadsdk.core.nibuguan.h paramh)
/*     */   {
/* 172 */     NativeHelper.a().a(paramh);
/* 173 */     if (LogUtils.isDebug) {
/* 174 */       LogUtils.c("AdEvent", "tt_dislike_icon " + paramh.l());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void f(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2)
/*     */   {
/* 187 */     a locala =com.bytedance.sdk.openadsdk.dddd.a.a(paramContext, paramString1, paramString2, paramh.l(), paramh.o());
/* 188 */     n.b().a(locala);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2, long paramLong, int paramInt)
/*     */   {
/* 202 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 204 */       localJSONObject.put("duration", paramLong);
/* 205 */       localJSONObject.put("percent", paramInt);
/*     */     } catch (JSONException localJSONException) {
/* 207 */       localJSONException.printStackTrace();
/*     */     }
/* 209 */     a(paramContext, paramh, paramString1, paramString2, localJSONObject);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void g(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2)
/*     */   {
/* 220 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void h(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2)
/*     */   {
/* 231 */     i(paramContext, paramh, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   private static void i(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2) {
/* 235 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 237 */       localJSONObject.putOpt("log_extra", paramh.o());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 240 */     a locala = com.bytedance.sdk.openadsdk.dddd.a.a(paramContext, paramString1, paramString2, paramh.l(), localJSONObject);
/* 241 */     n.b().a(locala);
/* 242 */     if (LogUtils.isDebug) {
/* 243 */       LogUtils.c("AdEvent", "tag: " + paramString1 + "label: " + paramString2 + " " + paramh.l());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void a(Context paramContext, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh, String paramString1, String paramString2, JSONObject paramJSONObject)
/*     */   {
/*     */     try
/*     */     {
/* 257 */       if (paramJSONObject != null) {
/* 258 */         paramJSONObject.putOpt("log_extra", paramh.o());
/*     */       }
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 262 */     a locala = com.bytedance.sdk.openadsdk.dddd.a.a(paramContext, paramString1, paramString2, paramh.l(), paramJSONObject);
/* 263 */     n.b().a(locala);
/* 264 */     if (LogUtils.isDebug) {
/* 265 */       LogUtils.c("AdEvent", "tag: " + paramString1 + "label: " + paramString2 + " " + paramh.l());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void a(Context paramContext, String paramString, long paramLong) {
/* 270 */     com.bytedance.sdk.openadsdk.core.cccc.b.a(paramContext, paramString, paramLong);
/*     */   }
/*     */   
/*     */   public static void a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject)
/*     */   {
/* 275 */     if (paramJSONObject != null) {
/* 276 */     JSONObject  localObject = new JSONObject();
/*     */       try {
/* 278 */         ((JSONObject)localObject).put("device", d.d(n.a()).toString());
/* 279 */         paramJSONObject.put("ad_extra_data", ((JSONObject)localObject).toString());
/*     */       }
/*     */       catch (JSONException localJSONException) {}
/*     */     }
/* 283 */     com.bytedance.sdk.openadsdk.dddd.a localObject = com.bytedance.sdk.openadsdk.dddd.a.a(paramString1, paramString2, paramString3, paramLong1, paramLong2, paramJSONObject);
/* 284 */     n.b().a(localObject);
/* 285 */     if (LogUtils.isDebug) {
/* 286 */       LogUtils.c("AdEvent", "sendJsAdEvent");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\LocationUtils\cdsss.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */