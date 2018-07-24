/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk;
/*     */ 
/*     */ 
/*     */ public class AdSlot
/*     */ {
/*     */   public static final int TYPE_BANNER = 1;
/*     */   
/*     */   public static final int TYPE_INTERACTION_AD = 2;
/*     */   
/*     */   public static final int TYPE_SPLASH = 3;
/*     */   
/*     */   public static final int TYPE_CACHED_SPLASH = 4;
/*     */   
/*     */   public static final int TYPE_FEED = 5;
/*     */   
/*     */   public static final int TYPE_REWARD_VIDEO = 7;
/*     */   
/*     */   private String a;
/*     */   
/*     */   private int b;
/*     */   
/*     */   private int c;
/*     */   
/*     */   private int d;
/*     */   
/*     */   private boolean e;
/*     */   
/*     */   private String f;
/*     */   
/*     */   private int g;
/*     */   
/*     */   private String h;
/*     */   private String i;
/*  34 */   private int j = 2;
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCodeId()
/*     */   {
/*  40 */     return this.a;
/*     */   }
/*     */   
/*     */   public static int getPosition(int paramInt)
/*     */   {
/*  45 */     switch (paramInt) {
/*     */     case 1: 
/*  47 */       return 3;
/*     */     case 3: 
/*     */     case 4: 
/*     */     case 7: 
/*  51 */       return 5;
/*     */     case 5: 
/*  53 */       return 1;
/*     */     case 2: 
/*  55 */       return 4;
/*     */     }
/*  57 */     return 1;
/*     */   }
/*     */   
/*     */   public int getImgAcceptedWidth()
/*     */   {
/*  62 */     return this.b;
/*     */   }
/*     */   
/*     */   public int getImgAcceptedHeight() {
/*  66 */     return this.c;
/*     */   }
/*     */   
/*     */   public boolean isSupportDeepLink() {
/*  70 */     return this.e;
/*     */   }
/*     */   
/*     */   public int getAdCount() {
/*  74 */     return this.d;
/*     */   }
/*     */   
/*     */   public String getRewardName() {
/*  78 */     return this.f;
/*     */   }
/*     */   
/*     */   public int getRewardAmount() {
/*  82 */     return this.g;
/*     */   }
/*     */   
/*     */   public String getMediaExtra() {
/*  86 */     return this.h;
/*     */   }
/*     */   
/*     */   public String getUserID() {
/*  90 */     return this.i;
/*     */   }
/*     */   
/*     */   public int getOrientation() {
/*  94 */     return this.j;
/*     */   }
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private String a;
/*     */     private int b;
/*     */     private int c;
/*     */     private boolean d;
/* 103 */     private int e = 1;
/*     */     private String f;
/*     */     private int g;
/*     */     private String h;
/*     */     private String i;
/*     */     private int j;
/*     */     
/*     */     public Builder setCodeId(String paramString)
/*     */     {
/* 112 */       this.a = paramString;
/* 113 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setImageAcceptedSize(int paramInt1, int paramInt2) {
/* 117 */       this.b = paramInt1;
/* 118 */       this.c = paramInt2;
/* 119 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setSupportDeepLink(boolean paramBoolean) {
/* 123 */       this.d = paramBoolean;
/* 124 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Builder setAdCount(int paramInt)
/*     */     {
/* 133 */       this.e = paramInt;
/* 134 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setRewardName(String paramString) {
/* 138 */       this.f = paramString;
/* 139 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setRewardAmount(int paramInt) {
/* 143 */       this.g = paramInt;
/* 144 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setMediaExtra(String paramString) {
/* 148 */       this.h = paramString;
/* 149 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setUserID(String paramString) {
/* 153 */       this.i = paramString;
/* 154 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setOrientation(int paramInt) {
/* 158 */       this.j = paramInt;
/* 159 */       return this;
/*     */     }
/*     */     
/*     */     public AdSlot build() {
/* 163 */       AdSlot localAdSlot = new AdSlot(null);
/* 164 */       AdSlot.a(localAdSlot, this.a);
/* 165 */       AdSlot.a(localAdSlot, this.e);
/* 166 */       AdSlot.a(localAdSlot, this.d);
/* 167 */       AdSlot.b(localAdSlot, this.b);
/* 168 */       AdSlot.c(localAdSlot, this.c);
/* 169 */       AdSlot.b(localAdSlot, this.f);
/* 170 */       AdSlot.d(localAdSlot, this.g);
/* 171 */       AdSlot.c(localAdSlot, this.h);
/* 172 */       AdSlot.d(localAdSlot, this.i);
/* 173 */       AdSlot.e(localAdSlot, this.j);
/* 174 */       return localAdSlot;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\AdSlot.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */