/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup;
/*     */ import com.bytedance.sdk.openadsdk.DownloadStatusController;
/*     */ import com.bytedance.sdk.openadsdk.TTAdDislike;
/*     */ import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.TTFeedAd;
/*     */
/*     */ import com.bytedance.sdk.openadsdk.TTImage;
/*     */ import com.bytedance.sdk.openadsdk.b.TTAdDislikeImpl;
/*     */
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
/*     */ import com.bytedance.sdk.openadsdk.core.nibuguan.g;
/*     */ import com.bytedance.sdk.openadsdk.core.nibuguan.h;
/*     */ import com.bytedance.sdk.openadsdk.core.video.a.f;
/*     */ import com.bytedance.sdk.openadsdk.ggg.o;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class w
/*     */   implements TTFeedAd
/*     */ {
/*     */   private final m b;
/*     */   private final h c;
/*     */   protected Context a;
/*     */   private TTAdDislike d;
/*     */   private DownloadStatusController e;
/*     */   private f f;
/*     */   
/*     */   w(@NonNull Context paramContext, @NonNull h paramh)
/*     */   {
/*  40 */     o.a(paramh, "materialMeta不能为null");
/*  41 */     this.c = paramh;
/*  42 */     this.a = paramContext;
/*  43 */     this.b = new m(this.a, this, paramh);
/*  44 */     if (getImageMode() == 5)
/*     */     {
/*  46 */       this.f = new f(paramContext, paramh);
/*     */     }
/*     */   }
/*     */   
/*     */   public void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, TTFeedAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/*  52 */     o.a(paramViewGroup, "container不能为null");
/*  53 */     o.a(paramView, "clickView不能为null");
/*     */     
/*  55 */     ArrayList localArrayList = new ArrayList(1);
/*  56 */     localArrayList.add(paramView);
/*  57 */     registerViewForInteraction(paramViewGroup, localArrayList, null, paramAdInteractionListener);
/*     */   }
/*     */   
/*     */   public void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, @NonNull List<View> paramList1, @Nullable List<View> paramList2, TTFeedAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/*  62 */     o.a(paramViewGroup, "container不能为null");
/*  63 */     o.a(paramList1, "clickView不能为null");
/*  64 */     o.a(paramList1.size() > 0, "clickViews数量必须大于等于1");
/*     */     
/*  66 */     this.b.a(paramViewGroup, paramList1, paramList2, paramAdInteractionListener);
/*     */   }
/*     */   
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/*  71 */     o.a(paramTTAppDownloadListener, "downloadListener不能为null");
/*  72 */     this.b.a(paramTTAppDownloadListener);
/*     */   }
/*     */   
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  78 */     return this.c.j();
/*     */   }
/*     */   
/*     */   public String getDescription()
/*     */   {
/*  83 */     return this.c.k();
/*     */   }
/*     */   
/*     */   public String getSource()
/*     */   {
/*  88 */     return this.c.b();
/*     */   }
/*     */   
/*     */   public TTImage getIcon()
/*     */   {
/*  93 */     return this.c.d() == null ? null : g.a(this.c.d());
/*     */   }
/*     */   
/*     */   public List<TTImage> getImageList()
/*     */   {
/*  98 */     ArrayList localArrayList = new ArrayList();
/*  99 */     if ((this.c.f() != null) && (!this.c.f().isEmpty())) {
/* 100 */       for (g localg : this.c.f()) {
/* 101 */         localArrayList.add(g.a(localg));
/*     */       }
/*     */     }
/* 104 */     return localArrayList;
/*     */   }
/*     */   
/*     */   public int getInteractionType()
/*     */   {
/* 109 */     if (this.c == null) {
/* 110 */       return -1;
/*     */     }
/* 112 */     return this.c.c();
/*     */   }
/*     */   
/*     */   public int getImageMode()
/*     */   {
/* 117 */     if (this.c == null) {
/* 118 */       return -1;
/*     */     }
/* 120 */     return this.c.p();
/*     */   }
/*     */   
/*     */   public TTAdDislike getDislikeDialog() {
/* 124 */     if (this.d == null) {
/* 125 */       a();
/*     */     }
/* 127 */     return this.d;
/*     */   }
/*     */   
/*     */   public View getAdView(boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/* 132 */     if (this.f != null) {
/* 133 */       this.f.setIsAutoPlay(paramBoolean1);
/* 134 */       this.f.setIsQuiet(paramBoolean2);
/*     */     }
/* 136 */     if ((getImageMode() != 5) || (this.f == null) || (!this.f.a(0L))) {
/* 137 */       return null;
/*     */     }
/* 139 */     return this.f;
/*     */   }
/*     */   
/*     */   public View getAdView()
/*     */   {
/* 144 */     if ((getImageMode() != 5) || (this.f == null) || (!this.f.a(0L))) {
/* 145 */       return null;
/*     */     }
/* 147 */     return this.f;
/*     */   }
/*     */   
/*     */   public DownloadStatusController getDownloadStatusController()
/*     */   {
/* 152 */     if ((this.e == null) && (this.b != null)) {
/* 153 */       final DownLoadListenerImpl localx = this.b.a();
/* 154 */       if (localx != null) {
/* 155 */         this.e = new DownloadStatusController()
/*     */         {
/*     */           public void changeDownloadStatus() {
/* 158 */             if (localx != null) {
/* 159 */               localx.b();
/*     */             }
/*     */           }
/*     */           
/*     */           public void cancelDownload()
/*     */           {
/* 165 */             if (localx != null) {
/* 166 */               localx.g();
/*     */             }
/*     */           }
/*     */         };
/*     */       }
/*     */     }
/* 172 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setActivityForDownloadApp(@NonNull Activity paramActivity)
/*     */   {
/* 177 */     if ((paramActivity != null) && ((paramActivity instanceof Activity))) {
/* 178 */       this.b.a(paramActivity);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a()
/*     */   {
/* 186 */     if ((this.a instanceof Activity)) {
/* 187 */       this.d = new TTAdDislikeImpl(this.a, this.c);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\w.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */