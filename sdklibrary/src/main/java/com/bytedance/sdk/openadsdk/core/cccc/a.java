/*     */ package com.bytedance.sdk.openadsdk.core.cccc;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
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
public class a {
    private static volatile a a;
    private static volatile boolean b;
    private static volatile long c;
    private Queue<a.asssa> d = new LinkedList();
    private Handler e;
    private com.bytedance.sdk.openadsdk.core.eeee.c f = n.e();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized(a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }

        return a;
    }

    private synchronized boolean b(String var1) {
        long var2 = System.currentTimeMillis();
        int var4 = this.f.d();
        long var5 = this.f.c();
        if (this.d.size() >= var4) {
            long var7 = (d.peek()).a;
            long var9 = Math.abs(var2 - var7);
            if (var9 <= var5) {
                this.b(var5 - var9);
                return true;
            }

            this.d.poll();
            this.d.offer(new asssa(var2, var1));
        } else {
            this.d.offer(new asssa(var2, var1));
        }

        return false;
    }

    public synchronized boolean a(String var1) {
        if (this.b(var1)) {
            this.a(true);
            this.a(c);
        } else {
            this.a(false);
        }

        return b;
    }

    private synchronized void a(long var1) {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }

        this.e.postDelayed(new Runnable() {
            public void run() {
                a(false);
            }
        }, var1);
    }

    private synchronized void a(boolean var1) {
        b = var1;
    }

    public boolean b() {
        return b;
    }

    private synchronized void b(long var1) {
        c = var1;
    }

    public synchronized String c() {
        HashMap var1 = new HashMap();
        Iterator var2 = this.d.iterator();

        while(var2.hasNext()) {
            asssa  var3 = (asssa)var2.next();
            if (var1.containsKey(var3.b)) {
                var1.put(var3.b, (Integer)var1.get(var3.b) + 1);
            } else {
                var1.put(var3.b, 1);
            }
        }

        Set var8 = var1.keySet();
        Iterator var9 = var8.iterator();
        int var4 = -2147483648;
        String var5 = "";

        while(var9.hasNext()) {
            String var7 = (String)var9.next();
            int var6 = (Integer)var1.get(var7);
            if (var4 < var6) {
                var4 = var6;
                var5 = var7;
            }
        }

        return var5;
    }

    private static class asssa {
        private long a;
        private String b;

        private asssa(long var1, String var3) {
            this.a = var1;
            this.b = var3;
        }
    }
}