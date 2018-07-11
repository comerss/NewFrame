/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.support.annotation.NonNull;
/*     */ import com.bytedance.sdk.openadsdk.AdSlot;
/*     */ import com.bytedance.sdk.openadsdk.TTAdNative;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import com.bytedance.sdk.openadsdk.core.nibuguan.a;
/*     */ import com.bytedance.sdk.openadsdk.core.nibuguan.h;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ class u
/*     */   implements TTAdNative
/*     */ {
/*     */   private o a;
/*     */   private Context b;6
/*     */   
/*     */   u(Context paramContext)
/*     */   {
/*  27 */     this.a = n.c();
/*  28 */     this.b = paramContext;
/*     */   }
/*     */   
/*     */   public void loadFeedAd(AdSlot paramAdSlot, @NonNull final TTAdNative.FeedAdListener paramFeedAdListener)
/*     */   {
/*  33 */     a(paramAdSlot);
/*  34 */     this.a.a(paramAdSlot, 5, new o.a()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString) {
/*  37 */         paramFeedAdListener.onError(paramAnonymousInt, paramAnonymousString);
/*     */       }
/*     */       
/*     */       public void a(a paramAnonymousa)
/*     */       {
/*  42 */         if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/*  43 */           List localList = paramAnonymousa.b();
/*  44 */           ArrayList localArrayList = new ArrayList(localList.size());
/*  45 */           for (h localh : localList) {
/*  46 */             if (localh.v()) {
/*  47 */               localArrayList.add(new w(u.a(u.this), localh));
/*     */             }
/*     */           }
/*  50 */           if (!localArrayList.isEmpty()) {
/*  51 */             paramFeedAdListener.onFeedAdLoad(localArrayList);
/*     */           } else {
/*  53 */             paramFeedAdListener.onError(-4, g.a(-4));
/*     */           }
/*     */         } else {
/*  56 */           paramFeedAdListener.onError(-3, g.a(-3));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void loadBannerAd(AdSlot paramAdSlot, @NonNull TTAdNative.BannerAdListener paramBannerAdListener)
/*     */   {
/*  64 */     a(paramAdSlot);
/*  65 */     com.bytedance.sdk.openadsdk.core.b.b.a(this.b).a(paramAdSlot, paramBannerAdListener);
/*     */   }
/*     */   
/*     */   public void loadInteractionAd(AdSlot paramAdSlot, @NonNull final TTAdNative.InteractionAdListener paramInteractionAdListener)
/*     */   {
/*  70 */     a(paramAdSlot);
/*     */     
/*  72 */     this.a.a(paramAdSlot, 2, new o.a()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString) {
/*  75 */         paramInteractionAdListener.onError(paramAnonymousInt, paramAnonymousString);
/*     */       }
/*     */       
/*     */       public void a(a paramAnonymousa)
/*     */       {
/*  80 */         if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/*  81 */           h localh = (h)paramAnonymousa.b().get(0);
/*  82 */           if (localh.v()) {
/*  83 */             final x localx = new x(u.a(u.this), localh);
/*  84 */             localx.a(new j()
/*     */             {
/*     */               public void a() {
/*  87 */                 u.2.this.a.onInteractionAdLoad(localx);
/*     */               }
/*     */               
/*     */               public void b()
/*     */               {
/*  92 */                 u.2.this.a.onError(-6, g.a(-6));
/*     */               }
/*     */             });
/*     */           } else {
/*  96 */             paramInteractionAdListener.onError(-4, g.a(-4));
/*     */           }
/*     */         } else {
/*  99 */           paramInteractionAdListener.onError(-3, g.a(-3));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void loadSplashAd(AdSlot paramAdSlot, @NonNull TTAdNative.SplashAdListener paramSplashAdListener, int paramInt)
/*     */   {
/* 107 */     a(paramAdSlot);
/*     */     
/* 109 */     com.bytedance.sdk.openadsdk.core.f.b.a(this.b).a(paramAdSlot, paramSplashAdListener, paramInt);
/*     */   }
/*     */   
/*     */   public void loadSplashAd(AdSlot paramAdSlot, @NonNull TTAdNative.SplashAdListener paramSplashAdListener)
/*     */   {
/* 114 */     a(paramAdSlot);
/*     */     
/* 116 */     com.bytedance.sdk.openadsdk.core.f.b.a(this.b).a(paramAdSlot, paramSplashAdListener, 0);
/*     */   }
/*     */   
/*     */   public void loadRewardVideoAd(final AdSlot paramAdSlot, @NonNull final TTAdNative.RewardVideoAdListener paramRewardVideoAdListener)
/*     */   {
/* 121 */     a(paramAdSlot);
/* 122 */     this.a.a(paramAdSlot, 7, new o.a()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString) {
/* 125 */         paramRewardVideoAdListener.onError(paramAnonymousInt, paramAnonymousString);
/*     */       }
/*     */       
/*     */       public void a(a paramAnonymousa)
/*     */       {
/* 130 */         if ((paramAnonymousa.b() != null) && (!paramAnonymousa.b().isEmpty())) {
/* 131 */           h localh = (h)paramAnonymousa.b().get(0);
/* 132 */           if (localh.v()) {
/* 133 */             y localy = new y(u.a(u.this), localh, paramAdSlot, paramRewardVideoAdListener);
/* 134 */             localy.a();
/* 135 */             paramRewardVideoAdListener.onRewardVideoAdLoad(localy);
/*     */           } else {
/* 137 */             paramRewardVideoAdListener.onError(-4, g.a(-4));
/*     */           }
/*     */         } else {
/* 140 */           paramRewardVideoAdListener.onError(-3, g.a(-3));
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void a(AdSlot paramAdSlot) {
/* 147 */     com.bytedance.sdk.openadsdk.ggg.o.a(paramAdSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
/* 148 */     com.bytedance.sdk.openadsdk.ggg.o.a(paramAdSlot.getImgAcceptedHeight() > 0, "必须设置图片素材尺寸");
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\u.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */