/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;

import com.bytedance.sdk.openadsdk.a.UIUtils;
import com.bytedance.sdk.openadsdk.eeeee.b;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.l;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class v
/*     */   implements b, MineHandler.OnResult
/*     */ {
/*     */   private WeakReference<WebView> a;
/*     */   private MineHandler b;
/*  45 */   private static Map<String, Boolean> c = new ConcurrentHashMap();
/*     */   
/*     */   private WeakReference<Context> d;
/*     */   
/*     */   private com.bytedance.sdk.openadsdk.eeeee.c e;
/*     */   
/*     */   private String f;
/*     */   
/*     */   private String g;
/*     */   private int h;
/*  55 */   private boolean i = true;
/*     */   
/*     */   static {
/*  58 */     c.put("log_event", Boolean.TRUE);
/*  59 */     c.put("private", Boolean.TRUE);
/*  60 */     c.put("dispatch_message", Boolean.TRUE);
/*     */   }
/*     */   
/*     */   public v(Context paramContext) {
/*  64 */     this.d = new WeakReference(paramContext);
/*  65 */     this.b = new MineHandler(Looper.getMainLooper(), this);
/*     */   }
/*     */   
/*     */   public WebView a() {
/*  69 */     return this.a != null ? (WebView)this.a.get() : null;
/*     */   }
/*     */   
/*     */   public v a(WebView paramWebView) {
/*  73 */     this.a = new WeakReference(paramWebView);
/*  74 */     return this;
/*     */   }
/*     */   
/*     */   public v a(String paramString) {
/*  78 */     this.f = paramString;
/*  79 */     return this;
/*     */   }
/*     */   
/*     */   public v b(String paramString) {
/*  83 */     this.g = paramString;
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public v a(int paramInt) {
/*  88 */     this.h = paramInt;
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   private List<String> e()
/*     */   {
/*  94 */     return Arrays.asList(new String[] { "appInfo", "adInfo" });
/*     */   }
/*     */   
/*     */ 
/*     */   private void a(JSONObject paramJSONObject, int paramInt)
/*     */     throws Exception
/*     */   {
/* 101 */     JSONArray localJSONArray = new JSONArray();
/* 102 */     List<String> localList = e();
/* 103 */     for (String str : localList) {
/* 104 */       localJSONArray.put(str);
/*     */     }
/* 106 */     paramJSONObject.put("appName", UIUtils.a());
/* 107 */     paramJSONObject.put("innerAppName", UIUtils.e());
/* 108 */     paramJSONObject.put("aid", UIUtils.b());
/* 109 */     paramJSONObject.put("sdkEdition", UIUtils.c());
/* 110 */     paramJSONObject.put("appVersion", UIUtils.d());
/* 111 */     paramJSONObject.put("netType", UIUtils.f());
/* 112 */     paramJSONObject.put("supportList", localJSONArray);
/* 113 */     paramJSONObject.put("deviceId", UIUtils.a(n.a()));
/*     */   }
/*     */   
/*     */   private void a(JSONObject paramJSONObject) throws Exception {
/* 117 */     if (!StringUtils.isEmpty(this.f)) {
/* 118 */       paramJSONObject.put("cid", this.f);
/*     */     }
/*     */     
/* 121 */     if (!StringUtils.isEmpty(this.g)) {
/* 122 */       paramJSONObject.put("log_extra", this.g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(a parama) throws Exception {
/* 127 */     if (!"call".equals(parama.a)) {
/* 128 */       return;
/*     */     }
/*     */     
/* 131 */     JSONObject localJSONObject = new JSONObject();
/*     */     
/*     */ 
/* 134 */     if ("appInfo".equals(parama.c)) {
/* 135 */       if (!StringUtils.isEmpty(parama.b)) {
/* 136 */         a(localJSONObject, parama.e);
/* 137 */         c(parama.b, localJSONObject);
/*     */       }
/* 139 */       return;
/*     */     }
/*     */     
/* 142 */     if ("adInfo".equals(parama.c)) {
/* 143 */       if (!StringUtils.isEmpty(parama.b)) {
/* 144 */         a(localJSONObject);
/* 145 */         c(parama.b, localJSONObject);
/*     */       }
/* 147 */       return;
/*     */     }
/*     */     
/*     */ 
/* 151 */     boolean bool = a(parama, localJSONObject);
/* 152 */     if (StringUtils.isEmpty(parama.b)) {
/* 153 */       return;
/*     */     }
/* 155 */     if (bool) {
/* 156 */       c(parama.b, localJSONObject);
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
/* 167 */   public void a(boolean paramBoolean) { this.i = paramBoolean; }
/*     */   
/*     */   private boolean a(a parama, JSONObject paramJSONObject) throws Exception {
/*     */     Context localContext;
/* 171 */     if ("subscribe_app_ad".equals(parama.c)) {
/* 172 */       f();
/*     */       
/* 174 */       if ((this.d != null) && ((localContext = (Context)this.d.get()) != null)) {
/* 175 */         this.e.a(localContext, parama.d, this.g, this.h, this.i);
/*     */       }
/* 177 */       return false; }
/* 178 */     if ("download_app_ad".equals(parama.c)) {
/* 179 */       if (this.e == null) {
/* 180 */         return false;
/*     */       }
/*     */       
/* 183 */       if ((this.d != null) && ((localContext = (Context)this.d.get()) != null)) {
/* 184 */         this.e.a(localContext, parama.d);
/*     */       }
/* 186 */     } else if ("cancel_download_app_ad".equals(parama.c)) {
/* 187 */       if (this.e == null) {
/* 188 */         return false;
/*     */       }
/* 190 */       this.e.b(parama.d);
/* 191 */     } else if ("unsubscribe_app_ad".equals(parama.c)) {
/* 192 */       if (this.e == null) {
/* 193 */         return false;
/*     */       }
/* 195 */       this.e.a(parama.d);
/*     */     }
/* 197 */     return false;
/*     */   }
/*     */   
/*     */   private void c(String paramString, JSONObject paramJSONObject) {
/*     */     try {
/* 202 */       JSONObject localJSONObject = new JSONObject();
/* 203 */       localJSONObject.put("__msg_type", "callback");
/* 204 */       localJSONObject.put("__callback_id", paramString);
/* 205 */       if (paramJSONObject != null) {
/* 206 */         localJSONObject.put("__params", paramJSONObject);
/*     */       }
/* 208 */       b(localJSONObject);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   private void b(JSONObject paramJSONObject) {
/* 214 */     if (paramJSONObject == null) {
/* 215 */       return;
/*     */     }
/* 217 */     WebView localWebView = a();
/* 218 */     if (localWebView != null) {
/* 219 */       String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + paramJSONObject.toString() + ")";
/* 220 */       l.a(localWebView, str);
/* 221 */       if (LogUtils.a()) {
/* 222 */         LogUtils.a("TTAndroidObject", "js_msg " + str);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(String paramString, JSONObject paramJSONObject) {
/*     */     try {
/* 229 */       if (StringUtils.isEmpty(paramString)) {
/* 230 */         return;
/*     */       }
/* 232 */       JSONObject localJSONObject = new JSONObject();
/* 233 */       localJSONObject.put("__msg_type", "event");
/* 234 */       localJSONObject.put("__event_id", paramString);
/* 235 */       if (paramJSONObject != null) {
/* 236 */         localJSONObject.put("__params", paramJSONObject);
/*     */       }
/* 238 */       b(localJSONObject);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   private void c(String paramString) {
/*     */     try {
/* 245 */       String str = new String(Base64.decode(paramString, 2));
/* 246 */       LogUtils.b("TTAndroidObject", str);
/*     */       
/* 248 */       JSONArray localJSONArray = new JSONArray(str);
/* 249 */       int j = localJSONArray.length();
/* 250 */       for (int k = 0; k < j; k++) {
/* 251 */         JSONObject localJSONObject = localJSONArray.getJSONObject(k);
/* 252 */         a locala = new a();
/* 253 */         locala.a = localJSONObject.getString("__msg_type");
/* 254 */         locala.b = localJSONObject.optString("__callback_id", null);
/* 255 */         locala.c = localJSONObject.optString("func");
/* 256 */         locala.d = localJSONObject.optJSONObject("params");
/* 257 */         locala.e = localJSONObject.optInt("JSSDK");
/* 258 */         if ((!StringUtils.isEmpty(locala.a)) && (!StringUtils.isEmpty(locala.c)))
/*     */         {
/*     */ 
/* 261 */           Message localMessage = this.b.obtainMessage(11);
/* 262 */           localMessage.obj = locala;
/* 263 */           this.b.sendMessage(localMessage);
/*     */         }
/*     */       }
/* 266 */     } catch (Exception localException) { if (LogUtils.a()) {
/* 267 */         LogUtils.d("TTAndroidObject", "failed to parse jsbridge msg queue " + paramString);
/*     */       } else {
/* 269 */         LogUtils.d("TTAndroidObject", "failed to parse jsbridge msg queue");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean a(Uri paramUri) {
/* 275 */     if (paramUri == null) {
/* 276 */       return false;
/*     */     }
/*     */     try {
/* 279 */       if (!"bytedance".equals(paramUri.getScheme())) {
/* 280 */         return false;
/*     */       }
/* 282 */       String str = paramUri.getHost();
/* 283 */       if (c.containsKey(str)) {
/* 284 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/* 288 */     return false;
/*     */   }
/*     */   
/*     */   public void b(@NonNull Uri paramUri) {
/*     */     try {
/* 293 */       String str1 = paramUri.getHost();
/* 294 */       if ("log_event".equals(str1)) {
/* 295 */         String str2 = paramUri.getQueryParameter("category");
/* 296 */         String str3 = paramUri.getQueryParameter("tag");
/* 297 */         String str4 = paramUri.getQueryParameter("label");
/* 298 */         long l1 = 0L;
/*     */         try {
/* 300 */           l1 = Long.parseLong(paramUri.getQueryParameter("value"));
/*     */         }
/*     */         catch (Exception localException2) {}
/* 303 */         long l2 = 0L;
/*     */         try {
/* 305 */           l2 = Long.parseLong(paramUri.getQueryParameter("ext_value"));
/*     */         }
/*     */         catch (Exception localException3) {}
/* 308 */         JSONObject localJSONObject = null;
/* 309 */         String str5 = paramUri.getQueryParameter("extra");
/* 310 */         if (!StringUtils.isEmpty(str5)) {
/*     */           try {
/* 312 */             localJSONObject = new JSONObject(str5);
/*     */           }
/*     */           catch (Exception localException4) {}
/*     */         }
/* 316 */         com.bytedance.sdk.openadsdk.dddd.c.a(str2, str3, str4, l1, l2, localJSONObject);
/* 317 */       } else if (("private".equals(str1)) || ("dispatch_message".equals(str1))) {
/* 318 */         d(paramUri.toString());
/*     */       } else {
/* 320 */         Log.w("TTAndroidObject", "handlrUir: not match schema host");
/*     */       }
/*     */     } catch (Exception localException1) {
/* 323 */       Log.w("TTAndroidObject", "handleUri exception: " + localException1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void d(String paramString) {
/* 328 */     if (paramString == null) {
/* 329 */       return;
/*     */     }
/* 331 */     if (!paramString.startsWith("bytedance://")) {
/* 332 */       return;
/*     */     }
/* 334 */     String str1 = "bytedance://dispatch_message/";
/* 335 */     String str2 = "bytedance://private/setresult/";
/*     */     try {
/* 337 */       if (paramString.equals(str1)) {
/* 338 */         WebView localWebView = a();
/*     */         
/* 340 */         if (localWebView != null) {
/* 341 */           l.a(localWebView, "javascript:ToutiaoJSBridge._fetchQueue()");
/*     */         }
/* 343 */       } else if (paramString.startsWith(str2)) {
/* 344 */         int j = str2.length();
/* 345 */         int k = paramString.indexOf('&', j);
/* 346 */         if (k <= 0) {
/* 347 */           return;
/*     */         }
/* 349 */         String str3 = paramString.substring(j, k);
/* 350 */         String str4 = paramString.substring(k + 1);
/* 351 */         if ((str3.equals("SCENE_FETCHQUEUE")) && (str4.length() > 0)) {
/* 352 */           c(str4);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void b() {
/* 360 */     if (this.e != null) {
/* 361 */       this.e.b();
/*     */     }
/*     */   }
/*     */   
/*     */   public void c() {
/* 366 */     if (this.e != null) {
/* 367 */       this.e.c();
/*     */     }
/*     */   }
/*     */   
/*     */   public void d() {
/* 372 */     if (this.e != null) {
/* 373 */       this.e.d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 379 */     if (paramMessage == null) {
/* 380 */       return;
/*     */     }
/* 382 */     switch (paramMessage.what) {
/*     */     case 11: 
/* 384 */       if ((paramMessage.obj instanceof a)) {
/*     */         try {
/* 386 */           a((a)paramMessage.obj);
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */   
/*     */   private void f()
/*     */   {
/* 396 */     if (this.e == null) {
/* 397 */       this.e = com.bytedance.sdk.openadsdk.eeeee.a.a(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void b(String paramString, JSONObject paramJSONObject)
/*     */   {
/* 403 */     a(paramString, paramJSONObject);
/*     */   }
/*     */   
/*     */   public static class a
/*     */   {
/*     */     public String a;
/*     */     public String b;
/*     */     public String c;
/*     */     public JSONObject d;
/*     */     public int e;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\v.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */