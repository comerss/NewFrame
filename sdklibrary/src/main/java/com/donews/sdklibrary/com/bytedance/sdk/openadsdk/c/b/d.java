/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c.b;
/*     */ 
/*     */ import android.Manifest.permission;
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.os.Build.VERSION;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.util.Log;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*  30 */   private static final String a = d.class.getSimpleName();
/*     */   
/*  32 */   private final Set<String> b = new HashSet(1);
/*  33 */   private final List<WeakReference<e>> c = new ArrayList(1);
/*  34 */   private final List<e> d = new ArrayList(1);
/*     */   
/*  36 */   private static d e = null;
/*     */   
/*  38 */   private static Map<String, Integer> f = new HashMap();
/*     */   
/*     */   static {
/*  41 */     f.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(R.string.tt_request_permission_descript_location));
/*  42 */     f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R.string.tt_request_permission_descript_location));
/*  43 */     f.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.tt_request_permission_descript_read_phone_state));
/*  44 */     f.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.tt_request_permission_descript_external_storage));
/*  45 */     if (Build.VERSION.SDK_INT >= 16) {
/*  46 */       f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.tt_request_permission_descript_external_storage));
/*     */     }
/*     */   }
/*     */   
/*     */   public static d a() {
/*  51 */     if (e == null) {
/*  52 */       e = new d();
/*     */     }
/*  54 */     return e;
/*     */   }
/*     */   
/*     */   private d() {
/*  58 */     b();
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
/*     */   private synchronized void b()
/*     */   {
/*  71 */     Field[] arrayOfField1 = Manifest.permission.class.getFields();
/*  72 */     for (Field localField : arrayOfField1) {
/*  73 */       String str = null;
/*     */       try {
/*  75 */         str = (String)localField.get("");
/*     */       } catch (IllegalAccessException localIllegalAccessException) {
/*  77 */         Log.e(a, "Could not access field", localIllegalAccessException);
/*     */       }
/*  79 */       this.b.add(str);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized void a(@NonNull String[] paramArrayOfString, @Nullable e parame)
/*     */   {
/*  95 */     if (parame == null) {
/*  96 */       return;
/*     */     }
/*  98 */     parame.a(paramArrayOfString);
/*  99 */     this.d.add(parame);
/* 100 */     this.c.add(new WeakReference(parame));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized void a(@Nullable e parame)
/*     */   {
/* 112 */     Iterator localIterator = this.c.iterator();
/* 113 */     Object localObject; while (localIterator.hasNext()) {
/* 114 */       localObject = (WeakReference)localIterator.next();
/* 115 */       if ((((WeakReference)localObject).get() == parame) || (((WeakReference)localObject).get() == null)) {
/* 116 */         localIterator.remove();
/*     */       }
/*     */     }
/* 119 */     localIterator = this.d.iterator();
/* 120 */     while (localIterator.hasNext()) {
/* 121 */       localObject = (e)localIterator.next();
/* 122 */       if (localObject == parame) {
/* 123 */         localIterator.remove();
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean a(@Nullable Context paramContext, @NonNull String paramString)
/*     */   {
/* 142 */     if (paramContext == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     if (com.bytedance.sdk.openadsdk.g.d.a()) {
/* 146 */       return (a.a(paramContext, paramString)) && ((b.a(paramContext, paramString) == 0) || 
/* 147 */         (!this.b.contains(paramString)));
/*     */     }
/* 149 */     return (b.a(paramContext, paramString) == 0) || 
/* 150 */       (!this.b.contains(paramString));
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
/*     */   public synchronized void a(@Nullable Activity paramActivity, @NonNull String[] paramArrayOfString, @Nullable e parame)
/*     */   {
/* 173 */     if (paramActivity == null) {
/* 174 */       return;
/*     */     }
/*     */     try {
/* 177 */       a(paramArrayOfString, parame);
/* 178 */       if (Build.VERSION.SDK_INT < 23) {
/* 179 */         b(paramActivity, paramArrayOfString, parame);
/*     */       } else {
/* 181 */         List localList = c(paramActivity, paramArrayOfString, parame);
/* 182 */         if (localList.isEmpty())
/*     */         {
/* 184 */           a(parame);
/*     */         } else {
/* 186 */           String[] arrayOfString = (String[])localList.toArray(new String[localList.size()]);
/* 187 */           b.a(paramActivity, arrayOfString, 1);
/*     */         }
/*     */       }
/*     */     } catch (Throwable localThrowable) {
/* 191 */       localThrowable.printStackTrace();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private void b(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @Nullable e parame)
/*     */   {
/* 207 */     for (String str : paramArrayOfString) {
/*     */       try {
/* 209 */         if (parame != null) {
/*     */           boolean bool;
/* 211 */           if (!this.b.contains(str)) {
/* 212 */             bool = parame.a(str, c.c);
/* 213 */           } else if (b.a(paramActivity, str) != 0)
/*     */           {
/* 215 */             bool = parame.a(str, c.b);
/*     */           } else {
/* 217 */             bool = parame.a(str, c.a);
/*     */           }
/* 219 */           if (bool) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable) {
/* 225 */         localThrowable.printStackTrace();
/*     */       }
/*     */     }
/* 228 */     a(parame);
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
/*     */   @NonNull
/*     */   private List<String> c(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @Nullable e parame)
/*     */   {
/* 246 */     ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
/* 247 */     for (String str : paramArrayOfString) {
/* 248 */       if (!this.b.contains(str)) {
/* 249 */         if (parame != null) {
/* 250 */           parame.a(str, c.c);
/*     */         }
/* 252 */       } else if (!a(paramActivity, str)) {
/* 253 */         localArrayList.add(str);
/*     */       }
/* 255 */       else if (parame != null) {
/* 256 */         parame.a(str, c.a);
/*     */       }
/*     */     }
/*     */     
/* 260 */     return localArrayList;
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
/*     */   public synchronized void a(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
/*     */   {
/*     */     try
/*     */     {
/* 284 */       ArrayList localArrayList = new ArrayList(3);
/* 285 */       int i = 0; for (int j = paramArrayOfString.length; i < j; i++) {
/* 286 */         String str = paramArrayOfString[i];
/* 287 */         if (((paramArrayOfInt[i] == -1) || ((com.bytedance.sdk.openadsdk.g.d.a()) && (!a.a(paramActivity, str)))) && 
/* 288 */           (paramArrayOfInt[i] != -1)) {
/* 289 */           paramArrayOfInt[i] = -1;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 294 */       a(paramArrayOfString, paramArrayOfInt, null);
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 297 */       localThrowable.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(@NonNull String[] paramArrayOfString1, @NonNull int[] paramArrayOfInt, String[] paramArrayOfString2) {
/*     */     try {
/* 303 */       int i = paramArrayOfString1.length;
/* 304 */       if (paramArrayOfInt.length < i) {
/* 305 */         i = paramArrayOfInt.length;
/*     */       }
/*     */       
/* 308 */       Iterator localIterator = this.c.iterator();
/* 309 */       while (localIterator.hasNext()) {
/* 310 */         localObject = (e)((WeakReference)localIterator.next()).get();
/* 311 */         for (int j = 0; j < i; j++) {
/* 312 */           if ((localObject == null) || (((e)localObject).a(paramArrayOfString1[j], paramArrayOfInt[j]))) {
/* 313 */             localIterator.remove();
/* 314 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 318 */       Object localObject = this.d.iterator();
/* 319 */       while (((Iterator)localObject).hasNext()) {
/* 320 */         ((Iterator)localObject).next();
/* 321 */         ((Iterator)localObject).remove();
/*     */       }
/*     */     } catch (Throwable localThrowable) {
/* 324 */       localThrowable.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\b\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */