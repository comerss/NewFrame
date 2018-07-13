/*    */ package com.bytedance.sdk.openadsdk.core.nibuguan;
/*    */ 
/*    */ 
/*    */
public class j {
    private h a;
    private byte[] b;
    private NativeData c;

    public j(h var1, byte[] var2) {
        this.a = var1;
        this.b = var2;
    }

    public j(NativeData var1, h var2, byte[] var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public h a() {
        return this.a;
    }

    public byte[] b() {
        return this.b;
    }

    public NativeData c() {
        return this.c;
    }
}
