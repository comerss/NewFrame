/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.Bitmap.CompressFormat;
/*     */ import android.os.Build;
/*     */ import android.os.Build.VERSION;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.support.annotation.WorkerThread;
/*     */ import android.telephony.TelephonyManager;
/*     */ import android.text.TextUtils;
/*     */ import android.util.DisplayMetrics;
/*     */ import com.androidquery.AQuery;
/*     */ import com.androidquery.callback.AjaxCallback;
/*     */ import com.androidquery.callback.AjaxStatus;
/*     */ import com.bytedance.sdk.openadsdk.AdSlot;
/*     */ import com.bytedance.sdk.openadsdk.core.d.f;
/*     */ import com.bytedance.sdk.openadsdk.core.d.j;
/*     */ import com.bytedance.sdk.openadsdk.core.f.b.a;
/*     */ import com.bytedance.sdk.openadsdk.g.d;
/*     */ import com.bytedance.sdk.openadsdk.g.e;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.q;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
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
/*     */ public class p
/*     */   implements o<com.bytedance.sdk.openadsdk.d.a>
/*     */ {
/*     */   private final Context a;
/*     */   private final boolean b;
/*  98 */   private ExecutorService c = Executors.newFixedThreadPool(1);
/*     */   private String d;
/*     */   
/*     */   p(Context paramContext) {
/* 102 */     this.a = paramContext;
/* 103 */     this.b = k();
/* 104 */     this.d = c();
/*     */   }
/*     */   
/*     */   private JSONObject a(AdSlot paramAdSlot, int paramInt) {
/* 108 */     JSONObject localJSONObject1 = new JSONObject();
/*     */     try {
/* 110 */       JSONObject localJSONObject2 = new JSONObject();
/* 111 */       localJSONObject2.put("request_id", d());
/* 112 */       localJSONObject2.put("ad_sdk_version", "1.9.0");
/* 113 */       localJSONObject2.put("source_type", "app");
/*     */       
/* 115 */       localJSONObject2.put("app", e());
/* 116 */       JSONObject localJSONObject3 = d.d(this.a);
/* 117 */       if (localJSONObject3 != null) {
/* 118 */         localJSONObject3.put("orientation", paramAdSlot.getOrientation());
/*     */       }
/* 120 */       localJSONObject2.put("device", localJSONObject3);
/* 121 */       localJSONObject2.put("user", g());
/* 122 */       localJSONObject2.put("ua", r.a);
/* 123 */       localJSONObject2.put("ip", i());
/* 124 */       JSONArray localJSONArray = new JSONArray();
/* 125 */       localJSONArray.put(b(paramAdSlot, paramInt));
/* 126 */       localJSONObject2.put("adslots", localJSONArray);
/* 127 */       String str = a.a(localJSONObject2.toString(), "b0458c2b262949b8");
/* 128 */       if (b(str)) {
/* 129 */         localJSONObject1.put("message", str);
/* 130 */         localJSONObject1.put("cipher", 1);
/*     */       } else {
/* 132 */         localJSONObject1.put("message", localJSONObject2.toString());
/* 133 */         localJSONObject1.put("cipher", 0);
/*     */       }
/* 135 */       localJSONObject1.put("ad_sdk_version", "1.9.0");
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 138 */     return localJSONObject1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean a(String paramString)
/*     */   {
/* 147 */     if (com.bytedance.sdk.openadsdk.core.c.a.a().b()) {
/* 148 */       return true;
/*     */     }
/*     */     
/* 151 */     if (com.bytedance.sdk.openadsdk.core.c.a.a().a(paramString)) {
/* 152 */       String str = com.bytedance.sdk.openadsdk.core.c.a.a().c();
/* 153 */       com.bytedance.sdk.openadsdk.d.c.a(this.a, str, System.currentTimeMillis());
/* 154 */       return true;
/*     */     }
/* 156 */     return false;
/*     */   }
/*     */   
/*     */   public void a(AdSlot paramAdSlot, int paramInt, final o.a parama)
/*     */   {
/* 161 */     if (parama == null)
/*     */     {
/* 163 */       return;
/*     */     }
/*     */     
/* 166 */     if (a(paramAdSlot.getCodeId())) {
/* 167 */       parama.a(-8, g.a(-8));
/* 168 */       return;
/*     */     }
/*     */     
/* 171 */     final JSONObject localJSONObject = a(paramAdSlot, paramInt);
/* 172 */     if (localJSONObject == null) {
/* 173 */       parama.a(-9, g.a(-9));
/* 174 */       return;
/*     */     }
/*     */     
/* 177 */     AQuery localAQuery = new AQuery(this.a);
/* 178 */     AjaxCallback local1 = new AjaxCallback()
/*     */     {
/*     */       public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
/* 181 */         if (paramAnonymousAjaxStatus.getCode() == 200) {
/* 182 */           if (TextUtils.isEmpty(paramAnonymousString2)) {
/* 183 */             p.a(p.this, parama);
/* 184 */             p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/* 185 */             return;
/*     */           }
/*     */           try {
/* 188 */             p.a locala = p.a.a(new JSONObject(paramAnonymousString2));
/* 189 */             if ((!TextUtils.isEmpty(locala.e)) && (!locala.e.equals(i.a(p.a(p.this)))))
/*     */             {
/* 191 */               i.a(p.a(p.this), locala.e);
/*     */             }
/* 193 */             if (locala.b != 20000) {
/* 194 */               parama.a(locala.b, g.a(locala.b));
/* 195 */               p.a(p.this, paramAnonymousAjaxStatus.getCode(), locala.b, localJSONObject.toString(), paramAnonymousString2);
/* 196 */               return;
/*     */             }
/* 198 */             if (locala.d == null) {
/* 199 */               p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/* 200 */               p.a(p.this, parama);
/* 201 */               return;
/*     */             }
/* 203 */             locala.d.c(paramAnonymousString2);
/* 204 */             parama.a(locala.d);
/*     */           } catch (JSONException localJSONException) {
/* 206 */             p.a(p.this, parama);
/* 207 */             p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/*     */           }
/*     */         }
/* 210 */         if (paramAnonymousAjaxStatus.getCode() > 0)
/*     */         {
/* 212 */           parama.a(paramAnonymousAjaxStatus.getCode(), paramAnonymousAjaxStatus.getMessage());
/* 213 */           p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/*     */         }
/*     */         else {
/* 216 */           parama.a(-2, g.a(-2));
/* 217 */           p.a(p.this, paramAnonymousAjaxStatus.getCode(), -2, localJSONObject.toString(), paramAnonymousString2);
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 222 */     };
/* 223 */     local1.timeout(b(paramInt));
/* 224 */     AjaxCallback.setAgent(r.a);
/* 225 */     localAQuery.post("https://i.snssdk.com/api/ad/union/sdk/get_ads/", localJSONObject, String.class, local1);
/*     */   }
/*     */   
/*     */   private int b(int paramInt) {
/* 229 */     return (paramInt == 3) || (paramInt == 4) ? 2000 : 10000;
/*     */   }
/*     */   
/*     */   private boolean b(String paramString) {
/* 233 */     return !q.a(paramString);
/*     */   }
/*     */   
/*     */   @WorkerThread
/*     */   public com.bytedance.sdk.openadsdk.d.g a(List<com.bytedance.sdk.openadsdk.d.a> paramList)
/*     */   {
/* 239 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 241 */       localJSONObject.put("header", j());
/* 242 */       JSONArray localJSONArray = new JSONArray();
/* 243 */       for (localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { com.bytedance.sdk.openadsdk.d.a locala = (com.bytedance.sdk.openadsdk.d.a)((Iterator)localObject).next();
/* 244 */         localJSONArray.put(locala.b);
/*     */       }
/* 246 */       localJSONObject.put("event", localJSONArray);
/* 247 */       localJSONObject.put("_gen_time", System.currentTimeMillis());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/*     */     
/* 251 */     AjaxCallback localAjaxCallback = new AjaxCallback();
/* 252 */     localAjaxCallback.url("https://extlog.snssdk.com/service/2/app_log/");
/* 253 */     localAjaxCallback.type(String.class);
/* 254 */     localAjaxCallback.timeout(10000);
/* 255 */     AjaxCallback.setAgent(r.a);
/* 256 */     localAjaxCallback.method(1);
/* 257 */     Object localObject = a.a(localJSONObject.toString(), "a0497c2b26294048");
/* 258 */     m.b("adevent", "adevent is :" + localJSONObject.toString());
/*     */     try {
/* 260 */       if (!b((String)localObject)) {
/* 261 */         localAjaxCallback.param("%entity", new StringEntity(localJSONObject.toString(), "UTF-8"));
/*     */       } else {
/* 263 */         localAjaxCallback.param("%entity", new StringEntity((String)localObject, "UTF-8"));
/*     */       }
/*     */     }
/*     */     catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
/*     */     
/* 268 */     Map localMap = c((String)localObject);
/* 269 */     localAjaxCallback.headers(localMap);
/* 270 */     AQuery localAQuery = new AQuery(this.a);
/* 271 */     localAQuery.sync(localAjaxCallback);
/* 272 */     AjaxStatus localAjaxStatus = localAjaxCallback.getStatus();
/* 273 */     boolean bool1 = d((String)localAjaxCallback.getResult());
/*     */     
/* 275 */     boolean bool2 = false;
/* 276 */     String str; if ((localAjaxStatus.getCode() == 200) && (!bool1)) {
/* 277 */       str = "server say not success";
/* 278 */       bool2 = true;
/*     */     } else {
/* 280 */       str = localAjaxStatus.getMessage();
/*     */     }
/* 282 */     return new com.bytedance.sdk.openadsdk.d.g((localAjaxStatus.getCode() == 200) && (bool1), localAjaxStatus
/* 283 */       .getCode(), str, bool2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.h paramh)
/*     */   {
/* 290 */     JSONObject localJSONObject = b(paramh);
/* 291 */     if (localJSONObject == null) {
/* 292 */       return;
/*     */     }
/* 294 */     AjaxCallback localAjaxCallback = new AjaxCallback();
/* 295 */     localAjaxCallback.timeout(10000);
/* 296 */     AQuery localAQuery = new AQuery(this.a);
/* 297 */     localAQuery.post("https://i.snssdk.com/api/ad/union/dislike_event/", localJSONObject, String.class, localAjaxCallback);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.core.d.h paramh) {
/* 302 */     JSONObject localJSONObject1 = new JSONObject();
/* 303 */     com.bytedance.sdk.openadsdk.g.a locala = com.bytedance.sdk.openadsdk.g.b.a(this.a);
/*     */     try {
/* 305 */       JSONObject localJSONObject2 = new JSONObject();
/* 306 */       localJSONObject2.put("action", "dislike");
/* 307 */       localJSONObject2.put("timestamp", System.currentTimeMillis());
/* 308 */       localJSONObject2.put("ad_sdk_version", "1.9.0");
/* 309 */       if (locala != null) {
/* 310 */         localJSONObject2.put("latitude", locala.a);
/* 311 */         localJSONObject2.put("longitude", locala.b);
/*     */       }
/* 313 */       localJSONObject2.put("extra", paramh.o());
/* 314 */       localJSONObject2.put("filter_words", c(paramh));
/*     */       
/* 316 */       JSONArray localJSONArray = new JSONArray();
/* 317 */       localJSONArray.put(localJSONObject2);
/* 318 */       localJSONObject1.put("actions", localJSONArray);
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 321 */     return localJSONObject1;
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, int paramInt2, String paramString1, String paramString2) {
/* 325 */     JSONObject localJSONObject1 = new JSONObject();
/* 326 */     JSONArray localJSONArray = new JSONArray();
/* 327 */     JSONObject localJSONObject2 = new JSONObject();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 332 */       localJSONObject1.putOpt("http_code", Integer.valueOf(paramInt1)).putOpt("client_code", Integer.valueOf(paramInt2)).putOpt("request_data", paramString1).putOpt("response_data", paramString2);
/* 333 */       localJSONArray.put(localJSONObject1);
/* 334 */       localJSONObject2.put("logs", localJSONArray);
/* 335 */       AjaxCallback localAjaxCallback = new AjaxCallback();
/* 336 */       localAjaxCallback.timeout(10000);
/* 337 */       AQuery localAQuery = new AQuery(this.a);
/* 338 */       localAQuery.post("https://is.snssdk.com/api/ad/union/sdk/upload/log/", localJSONObject2, String.class, localAjaxCallback);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   private JSONArray c(com.bytedance.sdk.openadsdk.core.d.h paramh) {
/* 344 */     if (paramh == null) {
/* 345 */       return null;
/*     */     }
/* 347 */     List localList = paramh.q();
/* 348 */     JSONArray localJSONArray = new JSONArray();
/* 349 */     if ((localList != null) && (!localList.isEmpty()))
/*     */     {
/* 351 */       for (int i = 0; i < localList.size(); i++) {
/* 352 */         f localf = (f)localList.get(i);
/* 353 */         if (localf.c()) {
/* 354 */           localJSONArray.put(localf.a());
/*     */         }
/*     */       }
/*     */     }
/* 358 */     return localJSONArray;
/*     */   }
/*     */   
/*     */ 
/*     */   @NonNull
/*     */   private Map<String, String> c(String paramString)
/*     */   {
/* 365 */     HashMap localHashMap = new HashMap();
/* 366 */     localHashMap.put("Content-Type", "application/json; charset=utf-8");
/* 367 */     if (b(paramString)) {
/* 368 */       localHashMap.put("Content-Encoding", "union_sdk_encode");
/*     */     }
/* 370 */     return localHashMap;
/*     */   }
/*     */   
/*     */   private boolean d(String paramString) {
/* 374 */     if (!TextUtils.isEmpty(paramString)) {
/*     */       try {
/* 376 */         JSONObject localJSONObject = new JSONObject(paramString);
/* 377 */         return localJSONObject.optString("message").equalsIgnoreCase("success");
/*     */       }
/*     */       catch (JSONException localJSONException) {}
/*     */     }
/* 381 */     return false;
/*     */   }
/*     */   
/*     */   private void a(o.a parama)
/*     */   {
/* 386 */     parama.a(-1, g.a(-1));
/*     */   }
/*     */   
/*     */   private void a(o.b paramb) {
/* 390 */     paramb.a(-1, g.a(-1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String d()
/*     */   {
/* 399 */     return UUID.randomUUID().toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private JSONObject e()
/*     */   {
/* 408 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 410 */       localJSONObject.put("appid", h.a().b());
/* 411 */       localJSONObject.put("name", h.a().c());
/* 412 */       a(localJSONObject);
/* 413 */       b(localJSONObject);
/* 414 */       localJSONObject.put("is_paid_app", h.a().d());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 417 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   private String f() {
/* 421 */     return d.b();
/*     */   }
/*     */   
/*     */   private JSONObject g() {
/* 425 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 427 */       localJSONObject.put("gender", h.a().f());
/* 428 */       if (h.a().e() > 0) {
/* 429 */         localJSONObject.put("age", h.a().e());
/*     */       }
/* 431 */       a(localJSONObject, "phone_nub", h());
/* 432 */       a(localJSONObject, "keywords", h.a().g());
/* 433 */       JSONArray localJSONArray = com.bytedance.sdk.openadsdk.g.i.a(this.a, this.c);
/* 434 */       if (localJSONArray != null) {
/* 435 */         localJSONObject.put("app_list", localJSONArray);
/*     */       }
/* 437 */       a(localJSONObject, "data", h.a().h());
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 440 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   private void a(JSONObject paramJSONObject, String paramString1, String paramString2) throws JSONException
/*     */   {
/* 445 */     if (!TextUtils.isEmpty(paramString2)) {
/* 446 */       paramJSONObject.put(paramString1, paramString2);
/*     */     }
/*     */   }
/*     */   
/*     */   private String h()
/*     */   {
/*     */     try {
/* 453 */       TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
/* 454 */       return localTelephonyManager.getLine1Number();
/*     */     } catch (Throwable localThrowable) {}
/* 456 */     return null;
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
/*     */   private void a(JSONObject paramJSONObject)
/*     */   {
/*     */     try
/*     */     {
/* 499 */       String str = this.a.getPackageName();
/* 500 */       paramJSONObject.put("package_name", str);
/* 501 */       paramJSONObject.put("version", this.a.getPackageManager().getPackageInfo(str, 0).versionCode + "");
/*     */     } catch (JSONException|NameNotFoundException localJSONException) {
/* 503 */       localJSONException.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void b(JSONObject paramJSONObject)
/*     */   {
/* 513 */     com.bytedance.sdk.openadsdk.g.a locala = com.bytedance.sdk.openadsdk.g.b.a(this.a);
/* 514 */     if (locala != null) {
/*     */       try {
/* 516 */         JSONObject localJSONObject = new JSONObject();
/* 517 */         localJSONObject.put("latitude", locala.a);
/* 518 */         localJSONObject.put("longitude", locala.b);
/* 519 */         paramJSONObject.put("geo", localJSONObject);
/*     */       }
/*     */       catch (JSONException localJSONException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private String i() {
/* 526 */     return d.a(true);
/*     */   }
/*     */   
/*     */   private JSONObject b(AdSlot paramAdSlot, int paramInt) {
/* 530 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 532 */       localJSONObject.put("id", paramAdSlot.getCodeId());
/* 533 */       localJSONObject.put("adtype", paramInt);
/* 534 */       localJSONObject.put("pos", AdSlot.getPosition(paramInt));
/* 535 */       a(localJSONObject, "accepted_size", paramAdSlot.getImgAcceptedWidth(), paramAdSlot.getImgAcceptedHeight());
/* 536 */       localJSONObject.put("is_support_dpl", paramAdSlot.isSupportDeepLink());
/* 537 */       int i = paramAdSlot.getAdCount();
/* 538 */       if (i < 1) {
/* 539 */         i = 1;
/*     */       }
/* 541 */       if (i > 3) {
/* 542 */         i = 3;
/*     */       }
/* 544 */       localJSONObject.put("ad_count", i);
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 547 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   private void a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2) {
/* 551 */     if ((paramInt1 > 0) && (paramInt2 > 0)) {
/* 552 */       JSONObject localJSONObject = new JSONObject();
/* 553 */       JSONArray localJSONArray = new JSONArray();
/*     */       try {
/* 555 */         localJSONObject.put("width", paramInt1);
/* 556 */         localJSONObject.put("height", paramInt2);
/* 557 */         localJSONArray.put(localJSONObject);
/* 558 */         paramJSONObject.put(paramString, localJSONArray);
/*     */       }
/*     */       catch (JSONException localJSONException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private JSONObject j() {
/* 565 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 567 */       localJSONObject.put("ua", r.a);
/* 568 */       localJSONObject.put("udid", i.d(this.a));
/* 569 */       localJSONObject.put("openudid", i.c(this.a));
/* 570 */       localJSONObject.put("ad_sdk_version", 1);
/* 571 */       localJSONObject.put("sim_op", a(this.a));
/* 572 */       localJSONObject.put("root", this.b ? 1 : 0);
/* 573 */       localJSONObject.put("timezone", b());
/* 574 */       localJSONObject.put("access", com.bytedance.sdk.openadsdk.g.c.b(this.a));
/* 575 */       localJSONObject.put("os", "Android");
/* 576 */       localJSONObject.put("os_version", VERSION.RELEASE);
/* 577 */       localJSONObject.put("os_api", VERSION.SDK_INT);
/* 578 */       localJSONObject.put("device_type", this.d);
/* 579 */       localJSONObject.put("device_model", Build.MODEL);
/* 580 */       localJSONObject.put("device_brand", Build.BRAND);
/* 581 */       localJSONObject.put("device_manufacturer", Build.MANUFACTURER);
/* 582 */       localJSONObject.put("language", Locale.getDefault().getLanguage());
/* 583 */       DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
/* 584 */       localJSONObject.put("resolution", localDisplayMetrics.heightPixels + "x" + localDisplayMetrics.widthPixels);
/* 585 */       localJSONObject.put("display_density", a(localDisplayMetrics.densityDpi));
/* 586 */       localJSONObject.put("density_dpi", localDisplayMetrics.densityDpi);
/* 587 */       localJSONObject.put("mc", f());
/* 588 */       localJSONObject.put("device_id", i.a(this.a));
/* 589 */       localJSONObject.put("aid", 1181);
/* 590 */       localJSONObject.put("rom", a());
/* 591 */       localJSONObject.put("cpu_abi", Build.CPU_ABI);
/* 592 */       localJSONObject.put("build_serial", Build.SERIAL);
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 595 */     return localJSONObject;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean k()
/*     */   {
/* 604 */     boolean bool = false;
/*     */     try {
/* 606 */       if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())) {
/* 607 */         bool = false;
/*     */       } else {
/* 609 */         bool = true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 614 */     return bool;
/*     */   }
/*     */   
/*     */   static String a(Context paramContext)
/*     */   {
/*     */     try {
/* 620 */       TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
/* 621 */       return localTelephonyManager.getSimOperator();
/*     */     } catch (Throwable localThrowable) {}
/* 623 */     return "";
/*     */   }
/*     */   
/*     */   static String a()
/*     */   {
/* 628 */     StringBuilder localStringBuilder = new StringBuilder();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 633 */       if (com.bytedance.sdk.openadsdk.g.r.c()) {
/* 634 */         localStringBuilder.append("MIUI-");
/* 635 */       } else if (com.bytedance.sdk.openadsdk.g.r.d()) {
/* 636 */         localStringBuilder.append("FLYME-");
/*     */       } else {
/* 638 */         String str = com.bytedance.sdk.openadsdk.g.r.b();
/* 639 */         if (com.bytedance.sdk.openadsdk.g.r.a(str)) {
/* 640 */           localStringBuilder.append("EMUI-");
/*     */         }
/* 642 */         if (!TextUtils.isEmpty(str)) {
/* 643 */           localStringBuilder.append(str).append("-");
/*     */         }
/*     */       }
/* 646 */       localStringBuilder.append(VERSION.INCREMENTAL);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/* 649 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   static String a(int paramInt) {
/*     */     String str;
/* 654 */     switch (paramInt) {
/*     */     case 120: 
/* 656 */       str = "ldpi";
/* 657 */       break;
/*     */     case 240: 
/* 659 */       str = "hdpi";
/* 660 */       break;
/*     */     case 160: 
/* 662 */       str = "mdpi";
/* 663 */       break;
/*     */     case 320: 
/* 665 */       str = "xhdpi";
/* 666 */       break;
/*     */     case 480: 
/* 668 */       str = "xxhdpi";
/* 669 */       break;
/*     */     case 640: 
/* 671 */       str = "xxxhdpi";
/* 672 */       break;
/*     */     default: 
/* 674 */       str = "mdpi";
/*     */     }
/*     */     
/* 677 */     return str;
/*     */   }
/*     */   
/*     */   static int b() {
/* 681 */     TimeZone localTimeZone = TimeZone.getDefault();
/* 682 */     int i = localTimeZone.getRawOffset() / 3600000;
/* 683 */     if (i < -12)
/* 684 */       i = -12;
/* 685 */     if (i > 12)
/* 686 */       i = 12;
/* 687 */     return i;
/*     */   }
/*     */   
/*     */   public String c() {
/* 691 */     if (d.b(this.a))
/* 692 */       return "tv";
/* 693 */     if (d.a(this.a)) {
/* 694 */       return "android_pad";
/*     */     }
/* 696 */     return "android";
/*     */   }
/*     */   
/*     */ 
/*     */   public static class a
/*     */   {
/*     */     final int a;
/*     */     final int b;
/*     */     final String c;
/*     */     @Nullable
/*     */     public final com.bytedance.sdk.openadsdk.core.d.a d;
/*     */     final String e;
/*     */     
/*     */     private a(String paramString1, int paramInt1, int paramInt2, String paramString2, @Nullable com.bytedance.sdk.openadsdk.core.d.a parama)
/*     */     {
/* 711 */       this.a = paramInt1;
/* 712 */       this.b = paramInt2;
/* 713 */       this.c = paramString2;
/* 714 */       this.d = parama;
/* 715 */       this.e = paramString1;
/*     */     }
/*     */     
/*     */     public static a a(JSONObject paramJSONObject) {
/* 719 */       String str1 = paramJSONObject.optString("did");
/* 720 */       int i = paramJSONObject.optInt("processing_time_ms");
/* 721 */       int j = paramJSONObject.optInt("status_code");
/* 722 */       String str2 = paramJSONObject.optString("request_id");
/* 723 */       com.bytedance.sdk.openadsdk.core.d.a locala = b.a(paramJSONObject);
/* 724 */       if (locala != null)
/*     */       {
/* 726 */         locala.a(paramJSONObject.optLong("request_after"));
/*     */       }
/* 728 */       return new a(str1, i, j, str2, locala);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(JSONObject paramJSONObject, final o.b paramb)
/*     */   {
/* 734 */     if ((paramJSONObject == null) || (paramb == null)) {
/* 735 */       return;
/*     */     }
/* 737 */     final JSONObject localJSONObject = c(paramJSONObject);
/* 738 */     AQuery localAQuery = new AQuery(this.a);
/* 739 */     AjaxCallback local2 = new AjaxCallback()
/*     */     {
/*     */       public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
/* 742 */         if (paramAnonymousAjaxStatus.getCode() == 200) {
/* 743 */           if (TextUtils.isEmpty(paramAnonymousString2)) {
/* 744 */             p.a(p.this, paramb);
/* 745 */             p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/* 746 */             return;
/*     */           }
/*     */           try {
/* 749 */             p.c localc = p.c.a(new JSONObject(paramAnonymousString2));
/*     */             
/* 751 */             if (localc.a != 20000) {
/* 752 */               paramb.a(localc.a, g.a(localc.a));
/* 753 */               p.a(p.this, paramAnonymousAjaxStatus.getCode(), localc.a, localJSONObject.toString(), paramAnonymousString2);
/* 754 */               return;
/*     */             }
/* 756 */             if (localc.c == null) {
/* 757 */               p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/* 758 */               p.a(p.this, paramb);
/* 759 */               return;
/*     */             }
/* 761 */             paramb.a(localc);
/*     */           } catch (JSONException localJSONException) {
/* 763 */             p.a(p.this, paramb);
/* 764 */             p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/*     */           }
/*     */         }
/* 767 */         if (paramAnonymousAjaxStatus.getCode() > 0)
/*     */         {
/* 769 */           paramb.a(paramAnonymousAjaxStatus.getCode(), paramAnonymousAjaxStatus.getMessage());
/* 770 */           p.a(p.this, paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
/*     */         }
/*     */         else {
/* 773 */           paramb.a(-2, g.a(-2));
/* 774 */           p.a(p.this, paramAnonymousAjaxStatus.getCode(), -2, localJSONObject.toString(), paramAnonymousString2);
/*     */         }
/*     */         
/*     */       }
/* 778 */     };
/* 779 */     local2.timeout(10000);
/* 780 */     localAQuery.post("https://is.snssdk.com/api/ad/union/sdk/reward_video/reward/", localJSONObject, String.class, local2);
/*     */   }
/*     */   
/*     */   private JSONObject c(JSONObject paramJSONObject) {
/* 784 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 786 */       String str = a.a(paramJSONObject.toString(), "b0458c2b262949b8");
/* 787 */       if (b(str)) {
/* 788 */         localJSONObject.put("cipher", 1);
/* 789 */         localJSONObject.put("message", str);
/*     */       } else {
/* 791 */         localJSONObject.put("cipher", 0);
/* 792 */         localJSONObject.put("message", paramJSONObject.toString());
/*     */       }
/*     */     }
/*     */     catch (JSONException localJSONException) {}
/* 796 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   public static class c {
/*     */     public final int a;
/*     */     public final boolean b;
/*     */     public final j c;
/*     */     
/*     */     private c(int paramInt, boolean paramBoolean, j paramj) {
/* 805 */       this.a = paramInt;
/* 806 */       this.b = paramBoolean;
/* 807 */       this.c = paramj;
/*     */     }
/*     */     
/*     */     public static c a(JSONObject paramJSONObject) {
/* 811 */       if (paramJSONObject == null) {
/* 812 */         return null;
/*     */       }
/* 814 */       int i = paramJSONObject.optInt("code");
/* 815 */       boolean bool = paramJSONObject.optBoolean("verify");
/* 816 */       JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
/* 817 */       j localj = new j();
/*     */       try {
/* 819 */         if (localJSONObject != null) {
/* 820 */           localj.a(localJSONObject.optInt("reason"));
/* 821 */           localj.b(localJSONObject.optInt("corp_type"));
/* 822 */           localj.c(localJSONObject.optInt("reward_amount"));
/* 823 */           localj.a(localJSONObject.optString("reward_name"));
/*     */         }
/*     */       } catch (Throwable localThrowable) {
/* 826 */         localThrowable.printStackTrace();
/*     */       }
/* 828 */       return new c(i, bool, localj);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap)
/*     */   {
/* 834 */     HashMap localHashMap = new HashMap();
/* 835 */     localHashMap.put("rit", Integer.valueOf(paramInt));
/* 836 */     localHashMap.put("req_id", paramString1);
/* 837 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 838 */     paramBitmap.compress(CompressFormat.JPEG, 50, localByteArrayOutputStream);
/* 839 */     localHashMap.put("image", localByteArrayOutputStream.toByteArray());
/*     */     try {
/* 841 */       localByteArrayOutputStream.close();
/*     */     } catch (IOException localIOException) {
/* 843 */       localIOException.printStackTrace();
/*     */     }
/* 845 */     localHashMap.put("ad_id", paramString2);
/* 846 */     localHashMap.put("sign", e.b(paramString1 + ":" + paramInt));
/* 847 */     AjaxCallback local3 = new AjaxCallback()
/*     */     {
/*     */       public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
/* 850 */         super.callback(paramAnonymousString1, paramAnonymousString2, paramAnonymousAjaxStatus);
/*     */       }
/*     */       
/* 853 */     };
/* 854 */     local3.url("https://i.snssdk.com/union/service/sdk/upload/");
/* 855 */     local3.type(String.class);
/* 856 */     local3.timeout(10000);
/* 857 */     local3.method(1);
/* 858 */     local3.params(localHashMap);
/* 859 */     AQuery localAQuery = new AQuery(this.a);
/* 860 */     localAQuery.ajax(local3);
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
/*     */   private JSONObject a(String paramString1, String paramString2)
/*     */   {
/* 886 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 888 */       String str1 = a.a(paramString1, "b0458c2b262949b8");
/* 889 */       int i = (int)(System.currentTimeMillis() / 1000L);
/* 890 */       StringBuffer localStringBuffer = new StringBuffer("id=");
/* 891 */       localStringBuffer.append(str1 + "&timestamp=");
/* 892 */       localStringBuffer.append(i + "&ext=");
/* 893 */       localStringBuffer.append(paramString2);
/* 894 */       String str2 = e.a(localStringBuffer.toString()).toUpperCase();
/* 895 */       localJSONObject.put("id", str1);
/* 896 */       localJSONObject.put("timestamp", i);
/* 897 */       localJSONObject.put("sign", str2);
/* 898 */       localJSONObject.put("ext", paramString2);
/*     */     }
/*     */     catch (Exception localException) {}
/* 901 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   public void a(String paramString1, String paramString2, final b.a parama)
/*     */   {
/* 906 */     if ((paramString1 == null) || (paramString2 == null) || (parama == null)) {
/* 907 */       return;
/*     */     }
/* 909 */     JSONObject localJSONObject = a(paramString1, paramString2);
/* 910 */     AQuery localAQuery = new AQuery(this.a);
/* 911 */     AjaxCallback local4 = new AjaxCallback()
/*     */     {
/*     */       public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
/* 914 */         if (paramAnonymousAjaxStatus.getCode() == 200) {
/* 915 */           if (TextUtils.isEmpty(paramAnonymousString2)) {
/* 916 */             parama.a(true);
/* 917 */             return;
/*     */           }
/*     */           try {
/* 920 */             p.b localb = p.b.a(new JSONObject(paramAnonymousString2));
/* 921 */             if ((localb.a == 0) && (!localb.b)) {
/* 922 */               parama.a(false);
/* 923 */               return;
/*     */             }
/*     */           }
/*     */           catch (JSONException localJSONException) {}
/*     */         }
/*     */         
/* 929 */         parama.a(true);
/*     */       }
/* 931 */     };
/* 932 */     local4.timeout(800);
/* 933 */     localAQuery.post("https://is.snssdk.com/api/ad/union/sdk/material/check/", localJSONObject, String.class, local4);
/*     */   }
/*     */   
/*     */   public static class b {
/*     */     public final int a;
/*     */     public final boolean b;
/*     */     
/*     */     private b(int paramInt, boolean paramBoolean) {
/* 941 */       this.a = paramInt;
/* 942 */       this.b = paramBoolean;
/*     */     }
/*     */     
/*     */     public static b a(JSONObject paramJSONObject) {
/* 946 */       if (paramJSONObject == null) {
/* 947 */         return null;
/*     */       }
/* 949 */       int i = paramJSONObject.optInt("error_code");
/* 950 */       boolean bool = paramJSONObject.optBoolean("result");
/* 951 */       return new b(i, bool);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\p.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */