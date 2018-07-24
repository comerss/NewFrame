/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.f;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.AsyncTask;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.text.TextUtils;
/*     */ import com.androidquery.AQuery;
/*     */ import com.androidquery.callback.AjaxCallback;
/*     */ import com.androidquery.callback.AjaxStatus;
/*     */ import com.bytedance.sdk.openadsdk.g.k;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.n;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
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
/*     */ public class b
/*     */   implements a
/*     */ {
/*     */   private Context a;
/*     */   private d b;
/*  35 */   private ExecutorService c = Executors.newFixedThreadPool(1);
/*     */   
/*     */   public b(Context paramContext, d paramd)
/*     */   {
/*  39 */     this.a = paramContext;
/*  40 */     this.b = paramd;
/*     */   }
/*     */   
/*     */   public void a(String paramString, List<String> paramList, boolean paramBoolean)
/*     */   {
/*  45 */     if (k.b(paramList)) {
/*  46 */       for (String str : paramList) {
/*  47 */         c localc = new c(UUID.randomUUID().toString(), str, paramBoolean, 5);
/*  48 */         a locala = new a(localc, paramString, null);
/*  49 */         locala.executeOnExecutor(this.c, new Void[0]);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(final String paramString)
/*     */   {
/*  56 */     this.c.submit(new Runnable()
/*     */     {
/*     */       public void run() {
/*  59 */         final List localList = b.a(b.this).a();
/*  60 */         Handler localHandler = new Handler(Looper.getMainLooper());
/*  61 */         localHandler.post(new Runnable()
/*     */         {
/*     */           public void run() {
/*  64 */             b.a(b.this, localList, b.1.this.a);
/*     */           }
/*     */         });
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void a(List<c> paramList, String paramString) {
/*  72 */     if (k.b(paramList)) {
/*  73 */       for (c localc : paramList) {
/*  74 */         a locala = new a(localc, paramString, null);
/*  75 */         locala.executeOnExecutor(this.c, new Void[0]);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class a
/*     */     extends AsyncTask<Void, Void, Void>
/*     */   {
/*     */     private c b;
/*     */     private final String c;
/*     */     
/*     */     private a(c paramc, String paramString)
/*     */     {
/*  88 */       this.b = paramc;
/*  89 */       this.c = paramString;
/*     */     }
/*     */     
/*     */     private String c(String paramString)
/*     */     {
/*  94 */       String str = paramString;
/*  95 */       if (!TextUtils.isEmpty(str)) {
/*  96 */         if ((str.contains("{TS}")) || (str.contains("__TS__"))) {
/*  97 */           long l = System.currentTimeMillis();
/*  98 */           str = str.replace("{TS}", String.valueOf(l));
/*  99 */           str = str.replace("__TS__", String.valueOf(l));
/*     */         }
/* 101 */         if (((str.contains("{UID}")) || (str.contains("__UID__"))) && (!TextUtils.isEmpty(this.c))) {
/* 102 */           str = str.replace("{UID}", this.c);
/* 103 */           str = str.replace("__UID__", this.c);
/*     */         }
/*     */       }
/* 106 */       return str;
/*     */     }
/*     */     
/*     */     boolean a(String paramString) {
/* 110 */       return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
/*     */     }
/*     */     
/*     */     String b(String paramString) {
/* 114 */       String str = paramString;
/* 115 */       if (!TextUtils.isEmpty(str)) {
/*     */         try {
/* 117 */           Random localRandom = new Random();
/* 118 */           str = str.replace("[ss_random]", String.valueOf(localRandom.nextLong()));
/* 119 */           str = str.replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
/*     */         } catch (Exception localException) {
/* 121 */           localException.printStackTrace();
/*     */         }
/*     */       }
/* 124 */       return str;
/*     */     }
/*     */     
/*     */     protected Void a(Void... paramVarArgs)
/*     */     {
/* 129 */       if (!a(this.b.b())) {
/* 130 */         return null;
/*     */       }
/* 132 */       if (this.b.d() == 0) {
/* 133 */         b.a(b.this).c(this.b);
/* 134 */         return null;
/*     */       }
/* 136 */       while ((this.b.d() > 0) && (!isCancelled())) {
/* 137 */         if (this.b.d() == 5) {
/* 138 */           b.a(b.this).a(this.b);
/*     */         }
/* 140 */         if (!n.a(b.b(b.this))) {
/*     */           break;
/*     */         }
/*     */         
/* 144 */         String str = c(this.b.b());
/* 145 */         if (this.b.c()) {
/* 146 */           str = b(str);
/*     */         }
/* 148 */         AjaxCallback localAjaxCallback = new AjaxCallback();
/* 149 */         localAjaxCallback.url(str);
/* 150 */         localAjaxCallback.type(String.class);
/* 151 */         localAjaxCallback.timeout(10000);
/* 152 */         localAjaxCallback.method(0);
/*     */         
/* 154 */         AQuery localAQuery = new AQuery(b.b(b.this));
/* 155 */         localAQuery.sync(localAjaxCallback);
/* 156 */         AjaxStatus localAjaxStatus = localAjaxCallback.getStatus();
/* 157 */         if (localAjaxStatus.getCode() == 200)
/*     */         {
/* 159 */           b.a(b.this).c(this.b);
/* 160 */           if (!m.a) break;
/* 161 */           m.c("trackurl", "track success : " + this.b.b()); break;
/*     */         }
/*     */         
/*     */ 
/* 165 */         if (m.a) {
/* 166 */           m.c("trackurl", "track fail : " + this.b.b());
/*     */         }
/*     */         
/* 169 */         this.b.a(this.b.d() - 1);
/* 170 */         if (this.b.d() == 0) {
/* 171 */           b.a(b.this).c(this.b);
/* 172 */           if (!m.a) break;
/* 173 */           m.c("trackurl", "track fail and delete : " + this.b.b()); break;
/*     */         }
/*     */         
/*     */ 
/* 177 */         b.a(b.this).b(this.b);
/*     */       }
/*     */       
/*     */ 
/* 181 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\f\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */