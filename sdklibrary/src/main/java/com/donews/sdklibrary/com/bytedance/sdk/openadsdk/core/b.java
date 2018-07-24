/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.support.annotation.Nullable;
/*     */ import com.bytedance.sdk.openadsdk.core.d.a;
/*     */ import com.bytedance.sdk.openadsdk.core.d.d;
/*     */ import com.bytedance.sdk.openadsdk.core.d.f;
/*     */ import com.bytedance.sdk.openadsdk.core.d.g;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.core.d.k;
/*     */ import java.util.List;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*     */   @Nullable
/*     */   public static a a(JSONObject paramJSONObject)
/*     */   {
/*  20 */     if (paramJSONObject == null) {
/*  21 */       return null;
/*     */     }
/*     */     try {
/*  24 */       a locala = new a();
/*  25 */       locala.a(paramJSONObject.optString("request_id"));
/*  26 */       locala.a(paramJSONObject.optInt("ret"));
/*  27 */       locala.b(paramJSONObject.optString("message"));
/*  28 */       if (locala.a() != 0) {
/*  29 */         return null;
/*     */       }
/*  31 */       JSONArray localJSONArray = paramJSONObject.optJSONArray("creatives");
/*  32 */       if (localJSONArray != null) {
/*  33 */         for (int i = 0; i < localJSONArray.length(); i++) {
/*  34 */           h localh = b(localJSONArray.optJSONObject(i));
/*  35 */           if (localh != null) {
/*  36 */             locala.a(localh);
/*     */           }
/*     */         }
/*     */       }
/*  40 */       return locala;
/*     */     } catch (Throwable localThrowable) {
/*  42 */       localThrowable.printStackTrace();
/*     */     }
/*  44 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static h b(JSONObject paramJSONObject)
/*     */   {
/*  50 */     if (paramJSONObject == null) {
/*  51 */       return null;
/*     */     }
/*  53 */     h localh = new h();
/*  54 */     localh.a(paramJSONObject.optInt("interaction_type"));
/*  55 */     localh.b(paramJSONObject.optString("target_url"));
/*  56 */     localh.f(paramJSONObject.optString("ad_id"));
/*  57 */     localh.a(paramJSONObject.optString("source"));
/*  58 */     JSONObject localJSONObject1 = paramJSONObject.optJSONObject("icon");
/*  59 */     localh.a(paramJSONObject.optBoolean("screenshot", false));
/*  60 */     if (localJSONObject1 != null) {
/*  61 */       localObject = new g();
/*  62 */       ((g)localObject).a(localJSONObject1.optString("url"));
/*  63 */       ((g)localObject).b(localJSONObject1.optInt("height"));
/*  64 */       ((g)localObject).a(localJSONObject1.optInt("width"));
/*  65 */       localh.a((g)localObject);
/*     */     }
/*  67 */     Object localObject = paramJSONObject.optJSONArray("image");
/*  68 */     if (localObject != null) {
/*  69 */       for (int i = 0; i < ((JSONArray)localObject).length(); i++) {
/*  70 */         g localg = new g();
/*  71 */         JSONObject localJSONObject2 = ((JSONArray)localObject).optJSONObject(i);
/*  72 */         localg.a(localJSONObject2.optString("url"));
/*  73 */         localg.b(localJSONObject2.optInt("height"));
/*  74 */         localg.a(localJSONObject2.optInt("width"));
/*  75 */         localh.b(localg);
/*     */       }
/*     */     }
/*  78 */     JSONArray localJSONArray1 = paramJSONObject.optJSONArray("show_url");
/*  79 */     if (localJSONArray1 != null) {
/*  80 */       for (int j = 0; j < localJSONArray1.length(); j++) {
/*  81 */         localh.h().add(localJSONArray1.optString(j));
/*     */       }
/*     */     }
/*  84 */     JSONArray localJSONArray2 = paramJSONObject.optJSONArray("click_url");
/*  85 */     if (localJSONArray2 != null) {
/*  86 */       for (int k = 0; k < localJSONArray2.length(); k++) {
/*  87 */         localh.i().add(localJSONArray2.optString(k));
/*     */       }
/*     */     }
/*  90 */     localh.c(paramJSONObject.optString("phone_num"));
/*  91 */     localh.d(paramJSONObject.optString("title"));
/*  92 */     localh.e(paramJSONObject.optString("description"));
/*  93 */     localh.g(paramJSONObject.optString("ext"));
/*  94 */     localh.b(paramJSONObject.optInt("image_mode"));
/*  95 */     JSONObject localJSONObject3 = paramJSONObject.optJSONObject("app");
/*  96 */     JSONObject localJSONObject4 = paramJSONObject.optJSONObject("deep_link");
/*  97 */     localh.a(c(localJSONObject3));
/*  98 */     localh.a(d(localJSONObject4));
/*  99 */     JSONArray localJSONArray3 = paramJSONObject.optJSONArray("filter_words");
/*     */     
/* 101 */     if (localJSONArray3 != null) {
/* 102 */       for (int m = 0; m < localJSONArray3.length(); m++) {
/* 103 */         JSONObject localJSONObject6 = localJSONArray3.optJSONObject(m);
/* 104 */         f localf = new f();
/* 105 */         localf.a(localJSONObject6.optString("id"));
/* 106 */         localf.b(localJSONObject6.optString("name"));
/* 107 */         localf.a(localJSONObject6.optBoolean("is_selected"));
/* 108 */         if (localf.d()) {
/* 109 */           localh.a(localf);
/*     */         }
/*     */       }
/*     */     }
/* 113 */     localh.c(paramJSONObject.optInt("count_down"));
/* 114 */     localh.a(paramJSONObject.optLong("expiration_time"));
/* 115 */     JSONObject localJSONObject5 = paramJSONObject.optJSONObject("video");
/* 116 */     if (localJSONObject5 != null) {
/* 117 */       localh.a(e(localJSONObject5));
/*     */     }
/*     */     
/* 120 */     return localh;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static com.bytedance.sdk.openadsdk.core.d.b c(JSONObject paramJSONObject) {
/* 125 */     if (paramJSONObject == null) {
/* 126 */       return null;
/*     */     }
/* 128 */     com.bytedance.sdk.openadsdk.core.d.b localb = new com.bytedance.sdk.openadsdk.core.d.b();
/* 129 */     localb.b(paramJSONObject.optString("app_name"));
/* 130 */     localb.c(paramJSONObject.optString("package_name"));
/* 131 */     localb.a(paramJSONObject.optString("download_url"));
/* 132 */     localb.a(paramJSONObject.optInt("score", 4));
/* 133 */     localb.b(paramJSONObject.optInt("comment_num", 6870));
/* 134 */     return localb;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static d d(JSONObject paramJSONObject) {
/* 139 */     if (paramJSONObject == null) {
/* 140 */       return null;
/*     */     }
/* 142 */     d locald = new d();
/* 143 */     locald.a(paramJSONObject.optString("deeplink_url"));
/* 144 */     locald.b(paramJSONObject.optString("fallback_url"));
/* 145 */     locald.a(paramJSONObject.optInt("fallback_type"));
/* 146 */     return locald;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static k e(JSONObject paramJSONObject) {
/* 151 */     if (paramJSONObject == null) {
/* 152 */       return null;
/*     */     }
/* 154 */     k localk = new k();
/* 155 */     localk.a(paramJSONObject.optInt("cover_height"));
/* 156 */     localk.b(paramJSONObject.optInt("cover_width"));
/* 157 */     localk.a(paramJSONObject.optString("resolution"));
/* 158 */     localk.a(paramJSONObject.optLong("size"));
/* 159 */     localk.a(paramJSONObject.optDouble("video_duration"));
/* 160 */     localk.b(paramJSONObject.optString("cover_url"));
/* 161 */     localk.c(paramJSONObject.optString("video_url"));
/* 162 */     localk.d(paramJSONObject.optString("endcard"));
/* 163 */     return localk;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */