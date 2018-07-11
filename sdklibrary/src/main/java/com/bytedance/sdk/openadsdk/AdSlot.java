/*     */
package com.bytedance.sdk.openadsdk;

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
    /*     */
    public String getCodeId()
    /*     */ {
        /*  40 */
        return this.a;
        /*     */
    }

    /*     */
    /*     */
    public static int getPosition(int paramInt)
    /*     */ {
        /*  45 */
        switch (paramInt) {
            /*     */
            case 1:
                /*  47 */
                return 3;
            /*     */
            case 3:
                /*     */
            case 4:
                /*     */
            case 7:
                /*  51 */
                return 5;
            /*     */
            case 5:
                /*  53 */
                return 1;
            /*     */
            case 2:
                /*  55 */
                return 4;
            /*     */
        }
        /*  57 */
        return 1;
        /*     */
    }

    /*     */
    /*     */
    public int getImgAcceptedWidth()
    /*     */ {
        /*  62 */
        return this.b;
        /*     */
    }

    /*     */
    /*     */
    public int getImgAcceptedHeight() {
        /*  66 */
        return this.c;
        /*     */
    }

    /*     */
    /*     */
    public boolean isSupportDeepLink() {
        /*  70 */
        return this.e;
        /*     */
    }

    /*     */
    /*     */
    public int getAdCount() {
        /*  74 */
        return this.d;
        /*     */
    }

    /*     */
    /*     */
    public String getRewardName() {
        /*  78 */
        return this.f;
        /*     */
    }

    /*     */
    /*     */
    public int getRewardAmount() {
        /*  82 */
        return this.g;
        /*     */
    }

    /*     */
    /*     */
    public String getMediaExtra() {
        /*  86 */
        return this.h;
        /*     */
    }

    /*     */
    /*     */
    public String getUserID() {
        /*  90 */
        return this.i;
        /*     */
    }

    /*     */
    /*     */
    public int getOrientation() {
        /*  94 */
        return this.j;
        /*     */
    }

    /*     */
    /*     */   public static class Builder
            /*     */ {
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
        /*     */
        public Builder setCodeId(String paramString)
        /*     */ {
            /* 112 */
            this.a = paramString;
            /* 113 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setImageAcceptedSize(int paramInt1, int paramInt2) {
            /* 117 */
            this.b = paramInt1;
            /* 118 */
            this.c = paramInt2;
            /* 119 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setSupportDeepLink(boolean paramBoolean) {
            /* 123 */
            this.d = paramBoolean;
            /* 124 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        public Builder setAdCount(int paramInt)
        /*     */ {
            /* 133 */
            this.e = paramInt;
            /* 134 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setRewardName(String paramString) {
            /* 138 */
            this.f = paramString;
            /* 139 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setRewardAmount(int paramInt) {
            /* 143 */
            this.g = paramInt;
            /* 144 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setMediaExtra(String paramString) {
            /* 148 */
            this.h = paramString;
            /* 149 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setUserID(String paramString) {
            /* 153 */
            this.i = paramString;
            /* 154 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public Builder setOrientation(int paramInt) {
            /* 158 */
            this.j = paramInt;
            /* 159 */
            return this;
            /*     */
        }

        /*     */
        /*     */
        public AdSlot build() {
            AdSlot var1 = new AdSlot();
            var1.a = this.a;
            var1.d = this.e;
            var1.e = this.d;
            var1.b = this.b;
            var1.c = this.c;
            var1.f = this.f;
            var1.g = this.g;
            var1.h = this.h;
            var1.i = this.i;
            var1.j = this.j;
            return var1;
        }
        /*     */
    }
    /*     */
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\AdSlot.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */