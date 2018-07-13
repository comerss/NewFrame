/*     */ package com.bytedance.sdk.openadsdk.eeeee;
/*     */ 
/*     */ import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.ccccc.x;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.r;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
/*     */ public class a
/*     */   implements c
/*     */ {
/*  25 */   public static final String a = a.class.getSimpleName();
/*     */   
/*     */   private static volatile c b;
/*     */   
/*     */   private com.bytedance.sdk.openadsdk.eeeee.b c;
/*  30 */   private final Map<String, x> d = new HashMap();
/*     */   
/*     */   private a(com.bytedance.sdk.openadsdk.eeeee.b paramb) {
/*  33 */     this.c = paramb;
/*     */   }
/*     */   
/*     */   public static c a(com.bytedance.sdk.openadsdk.eeeee.b paramb) {
/*  37 */     if (b == null) {
/*  38 */       synchronized (c.class) {
/*  39 */         if (b == null) {
/*  40 */           b = new a(paramb);
/*     */         }
/*     */       }
/*     */     }
/*  44 */     return b;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static c a() {
/*  49 */     return b;
/*     */   }
/*     */   
/*     */   public void b()
/*     */   {
/*  54 */     for (x localx : this.d.values()) {
/*  55 */       if (localx != null) {
/*  56 */         localx.e();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void c()
/*     */   {
/*  63 */     for (x localx : this.d.values()) {
/*  64 */       if (localx != null) {
/*  65 */         localx.f();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void d()
/*     */   {
/*  72 */     c();
/*  73 */     this.d.clear();
/*  74 */     b = null;
/*     */   }
/*     */   
/*     */   public void a(Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt, boolean paramBoolean)
/*     */   {
/*  79 */     if ((paramContext == null) || (paramJSONObject == null)) {
/*  80 */       return;
/*     */     }
/*  82 */     JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
/*  83 */     if (localJSONObject != null) {
/*  84 */       h localh = new h();
/*  85 */       localh.a(localJSONObject);
/*  86 */       localh.g(paramString);
/*  87 */       a(paramContext, localh, localJSONObject, paramInt, paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(Context paramContext, h paramh, JSONObject paramJSONObject, int paramInt, boolean paramBoolean) {
/*  92 */     if ((paramContext == null) || (paramh == null) || (paramh.m() == null) || (paramJSONObject == null) || (this.c == null))
/*     */     {
/*  94 */       return;
/*     */     }
/*  96 */     x localx = (x)this.d.get(paramh.m().a());
/*  97 */     if (localx != null) {
/*  98 */       return;
/*     */     }
/* 100 */     String str = r.a(paramInt);
/* 101 */     if (StringUtils.isEmpty(str)) {
/* 102 */       return;
/*     */     }
/* 104 */     localx = a(paramContext, paramh, paramJSONObject, str, paramBoolean);
/* 105 */     this.d.put(paramh.m().a(), localx);
/*     */   }
/*     */   
/*     */   public void a(Context paramContext, JSONObject paramJSONObject)
/*     */   {
/* 110 */     if ((paramContext == null) || (paramJSONObject == null)) {
/* 111 */       return;
/*     */     }
/* 113 */     JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
/* 114 */     if (localJSONObject != null) {
/* 115 */       h localh = new h();
/* 116 */       localh.a(localJSONObject);
/* 117 */       a(paramContext, localh);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(Context paramContext, h paramh) {
/* 122 */     if ((paramContext == null) || (paramh == null) || (paramh.m() == null)) {
/* 123 */       return;
/*     */     }
/* 125 */     x localx = (x)this.d.get(paramh.m().a());
/*     */     
/* 127 */     if (localx != null) {
/* 128 */       localx.c();
/*     */     }
/* 130 */     if ((paramContext instanceof TTRewardVideoActivity)) {
/* 131 */       ((TTRewardVideoActivity)paramContext).a();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(JSONObject paramJSONObject)
/*     */   {
/* 137 */     if (paramJSONObject == null) {
/* 138 */       return;
/*     */     }
/* 140 */     JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
/* 141 */     if (localJSONObject != null) {
/* 142 */       h localh = new h();
/* 143 */       localh.a(localJSONObject);
/* 144 */       a(localh, localJSONObject);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(h paramh, JSONObject paramJSONObject) {
/* 149 */     if ((this.c == null) || (paramh == null) || (paramh.m() == null)) {
/* 150 */       return;
/*     */     }
/* 152 */     String str = paramh.m().a();
/* 153 */     if (this.d.containsKey(str)) {
/* 154 */       this.d.remove(str);
/*     */       try {
/* 156 */         JSONObject localJSONObject = new JSONObject();
/* 157 */         localJSONObject.put("message", "success");
/* 158 */         localJSONObject.put("status", "unsubscribed");
/* 159 */         localJSONObject.put("appad", paramJSONObject);
/* 160 */         this.c.b("app_ad_event", localJSONObject);
/*     */       } catch (JSONException localJSONException) {
/* 162 */         localJSONException.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void b(JSONObject paramJSONObject)
/*     */   {
/* 169 */     if ((paramJSONObject == null) || (this.c == null)) {
/* 170 */       return;
/*     */     }
/* 172 */     JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
/* 173 */     if (localJSONObject != null) {
/* 174 */       h localh = new h();
/* 175 */       localh.a(localJSONObject);
/* 176 */       x localx = (x)this.d.get(localh.m().a());
/* 177 */       if (localx != null) {
/* 178 */         localx.g();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(String paramString)
/*     */   {
/* 185 */     if ((StringUtils.isEmpty(paramString)) || (this.d == null)) {
/* 186 */       return;
/*     */     }
/* 188 */     x localx = (x)this.d.get(paramString);
/* 189 */     if (localx != null) {
/* 190 */       localx.d();
/*     */     }
/*     */   }
/*     */   
/*     */   private x a(@NonNull final Context paramContext, @NonNull final h paramh, @NonNull final JSONObject paramJSONObject, @NonNull final String paramString, boolean paramBoolean) {
/* 195 */     x localx = new x(paramContext, paramh, paramString);
/* 196 */     localx.a(new TTAppDownloadListener()
/*     */     {
/*     */       public void onIdle() {
/* 199 */         a(new String[] { "status", "idle" });
/*     */       }
/*     */       
/*     */       public void onDownloadActive(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString1, String paramAnonymousString2)
/*     */       {
/* 204 */         a(new String[] { "status", "download_active", "total_bytes", 
/*     */         
/* 206 */           String.valueOf(paramAnonymousLong1), "current_bytes", 
/* 207 */           String.valueOf(paramAnonymousLong2) });
/*     */       }
/*     */       
/*     */       public void onDownloadPaused(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString1, String paramAnonymousString2)
/*     */       {
/* 212 */         a(new String[] { "status", "download_paused", "total_bytes", 
/*     */         
/* 214 */           String.valueOf(paramAnonymousLong1), "current_bytes", 
/* 215 */           String.valueOf(paramAnonymousLong2) });
/*     */       }
/*     */       
/*     */       public void onDownloadFailed(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString1, String paramAnonymousString2)
/*     */       {
/* 220 */         a(new String[] { "status", "download_failed", "total_bytes", 
/*     */         
/* 222 */           String.valueOf(paramAnonymousLong1), "current_bytes", 
/* 223 */           String.valueOf(paramAnonymousLong2) });
/*     */       }
/*     */       
/*     */       public void onDownloadFinished(long paramAnonymousLong, String paramAnonymousString1, String paramAnonymousString2)
/*     */       {
/* 228 */         a(new String[] { "status", "download_finished", "total_bytes", 
/*     */         
/* 230 */           String.valueOf(paramAnonymousLong), "current_bytes", 
/* 231 */           String.valueOf(paramAnonymousLong) });
/*     */       }
/*     */       
/*     */       public void onInstalled(String paramAnonymousString1, String paramAnonymousString2)
/*     */       {
/* 236 */         a(new String[] { "status", "installed" });
/*     */       }
/*     */       
/*     */       private void a(String... paramAnonymousVarArgs) {
/* 240 */         if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length % 2 != 0)) {
/* 241 */           return;
/*     */         }
/*     */         try {
/* 244 */           JSONObject localJSONObject = new JSONObject();
/* 245 */           localJSONObject.put("message", "success");
/* 246 */           localJSONObject.put("appad", paramJSONObject);
/* 247 */           for (int i = 0; i < paramAnonymousVarArgs.length; i += 2) {
/* 248 */             localJSONObject.put(paramAnonymousVarArgs[i], paramAnonymousVarArgs[(i + 1)]);
/*     */           }
/* 250 */          c.b("app_ad_event", localJSONObject);
/*     */         } catch (JSONException localJSONException) {
/* 252 */           LogUtils.b(com.bytedance.sdk.openadsdk.eeeee.a.a, "JSONException");
/*     */         }
/*     */         
/*     */       }
/* 256 */     });
/* 257 */     localx.a(new d()
/*     */     {
/*     */       public void a() {
/* 260 */         a(new String[] { "status", "cancel_download" });
/*     */       }
/*     */       
/*     */       private void a(String... paramAnonymousVarArgs) {
/* 264 */         if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length % 2 != 0)) {
/* 265 */           return;
/*     */         }
/*     */         try {
/* 268 */           JSONObject localJSONObject = new JSONObject();
/* 269 */           localJSONObject.put("message", "success");
/* 270 */           localJSONObject.put("appad", paramJSONObject);
/* 271 */           for (int i = 0; i < paramAnonymousVarArgs.length; i += 2) {
/* 272 */             localJSONObject.put(paramAnonymousVarArgs[i], paramAnonymousVarArgs[(i + 1)]);
/*     */           }
/* 274 */          c.b("app_ad_event", localJSONObject);
        /*     */         } catch (JSONException localJSONException) {
        /* 252 */           LogUtils.b(com.bytedance.sdk.openadsdk.eeeee.a.a, "JSONException");
        /*     */
/*     */         }
/*     */       }
/*     */     });
/*     */     
/* 281 */     if (!paramBoolean) {
/* 282 */       return localx;
/*     */     }
/* 284 */     localx.a(new x.b()
/*     */     {
/*     */       public void a() {
/* 287 */         com.bytedance.sdk.openadsdk.dddd.c.a(paramContext, paramh, paramString, "click_start_detail");
/* 288 */         LogUtils.b(com.bytedance.sdk.openadsdk.eeeee.a.a, " js onClickDownloadStart");
/*     */       }
/*     */       
/*     */       public void b()
/*     */       {
/* 293 */         com.bytedance.sdk.openadsdk.dddd.c.b(paramContext, paramh, paramString, "click_pause");
/* 294 */         LogUtils.b(com.bytedance.sdk.openadsdk.eeeee.a.a, " js onClickDownloadPause");
/*     */       }
/*     */       
/*     */       public void c()
/*     */       {
/* 299 */         com.bytedance.sdk.openadsdk.dddd.c.c(paramContext, paramh, paramString, "click_continue");
/* 300 */         LogUtils.b(com.bytedance.sdk.openadsdk.eeeee.a.a, " js onClickDownloadContinue");
/*     */       }
/*     */       
/*     */       public void d()
/*     */       {
/* 305 */         com.bytedance.sdk.openadsdk.dddd.c.h(paramContext, paramh, paramString, "click_open");
/* 306 */         LogUtils.b(com.bytedance.sdk.openadsdk.eeeee.a.a, "onClickOpenAdApp");
/*     */       }
/* 308 */     });
/* 309 */     return localx;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\eee\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */