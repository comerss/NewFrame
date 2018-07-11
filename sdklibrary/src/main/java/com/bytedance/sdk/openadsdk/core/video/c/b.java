/*     */ package com.bytedance.sdk.openadsdk.core.video.c;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.media.MediaDataSource;
/*     */ import android.media.MediaPlayer;
/*     */ import android.media.MediaPlayer.OnBufferingUpdateListener;
/*     */ import android.media.MediaPlayer.OnCompletionListener;
/*     */ import android.media.MediaPlayer.OnErrorListener;
/*     */ import android.media.MediaPlayer.OnInfoListener;
/*     */ import android.media.MediaPlayer.OnPreparedListener;
/*     */ import android.media.MediaPlayer.OnSeekCompleteListener;
/*     */ import android.media.MediaPlayer.OnVideoSizeChangedListener;
/*     */ import android.net.Uri;
/*     */ import android.text.TextUtils;
/*     */ import android.view.Surface;
/*     */ import android.view.SurfaceHolder;
/*     */ import java.io.IOException;
/*     */ import java.lang.ref.WeakReference;
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
/*     */ public class b
/*     */   extends a
/*     */ {
/*     */   private final MediaPlayer a;
/*     */   private final a b;
/*     */   private MediaDataSource c;
/*  40 */   private final Object d = new Object();
/*     */   private boolean e;
/*     */   
/*     */   public b() {
/*  44 */     synchronized (this.d) {
/*  45 */       this.a = new MediaPlayer();
/*     */     }
/*  47 */     this.a.setAudioStreamType(3);
/*  48 */     this.b = new a(this);
/*  49 */     n();
/*     */   }
/*     */   
/*     */   public MediaPlayer e() {
/*  53 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(SurfaceHolder paramSurfaceHolder)
/*     */   {
/*  58 */     synchronized (this.d) {
/*  59 */       if (!this.e) {
/*  60 */         this.a.setDisplay(paramSurfaceHolder);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @TargetApi(14)
/*     */   public void a(Surface paramSurface)
/*     */   {
/*  68 */     this.a.setSurface(paramSurface);
/*     */   }
/*     */   
/*     */ 
/*     */   public void a(String paramString)
/*     */     throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
/*     */   {
/*  75 */     Uri localUri = Uri.parse(paramString);
/*  76 */     String str = localUri.getScheme();
/*  77 */     if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("file"))) {
/*  78 */       this.a.setDataSource(localUri.getPath());
/*     */     } else {
/*  80 */       this.a.setDataSource(paramString);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void m()
/*     */   {
/*  90 */     if (this.c != null) {
/*     */       try {
/*  92 */         this.c.close();
/*     */       } catch (IOException localIOException) {
/*  94 */         localIOException.printStackTrace();
/*     */       }
/*  96 */       this.c = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void f() throws IllegalStateException
/*     */   {
/* 102 */     this.a.start();
/*     */   }
/*     */   
/*     */   public void g() throws IllegalStateException
/*     */   {
/* 107 */     this.a.stop();
/*     */   }
/*     */   
/*     */   public void h() throws IllegalStateException
/*     */   {
/* 112 */     this.a.pause();
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean)
/*     */   {
/* 117 */     this.a.setScreenOnWhilePlaying(paramBoolean);
/*     */   }
/*     */   
/*     */   public void a(long paramLong) throws IllegalStateException
/*     */   {
/* 122 */     this.a.seekTo((int)paramLong);
/*     */   }
/*     */   
/*     */   public long i()
/*     */   {
/*     */     try {
/* 128 */       return this.a.getCurrentPosition();
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/* 131 */     return 0L;
/*     */   }
/*     */   
/*     */   public long j()
/*     */   {
/*     */     try
/*     */     {
/* 138 */       return this.a.getDuration();
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/* 141 */     return 0L;
/*     */   }
/*     */   
/*     */ 
/*     */   public void k()
/*     */   {
/* 147 */     this.e = true;
/* 148 */     this.a.release();
/* 149 */     m();
/* 150 */     a();
/* 151 */     n();
/*     */   }
/*     */   
/*     */   public void l()
/*     */   {
/*     */     try {
/* 157 */       this.a.reset();
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/*     */     
/* 161 */     m();
/* 162 */     a();
/* 163 */     n();
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean)
/*     */   {
/* 168 */     this.a.setLooping(paramBoolean);
/*     */   }
/*     */   
/*     */   public void a(float paramFloat1, float paramFloat2)
/*     */   {
/* 173 */     this.a.setVolume(paramFloat1, paramFloat2);
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
/*     */   public void a(Context paramContext, int paramInt)
/*     */   {
/* 188 */     this.a.setWakeMode(paramContext, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void n()
/*     */   {
/* 199 */     this.a.setOnPreparedListener(this.b);
/* 200 */     this.a
/* 201 */       .setOnBufferingUpdateListener(this.b);
/* 202 */     this.a.setOnCompletionListener(this.b);
/* 203 */     this.a
/* 204 */       .setOnSeekCompleteListener(this.b);
/* 205 */     this.a
/* 206 */       .setOnVideoSizeChangedListener(this.b);
/* 207 */     this.a.setOnErrorListener(this.b);
/* 208 */     this.a.setOnInfoListener(this.b);
/*     */   }
/*     */   
/*     */ 
/*     */   private class a
/*     */     implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
/*     */   {
/*     */     public final WeakReference<b> a;
/*     */     
/*     */ 
/*     */     public a(b paramb)
/*     */     {
/* 220 */       this.a = new WeakReference(paramb);
/*     */     }
/*     */     
/*     */     public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
/*     */     {
/* 225 */       b localb = (b)this.a.get();
/* 226 */       return (localb != null) && (b.this.b(paramInt1, paramInt2));
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
/*     */     {
/* 232 */       b localb = (b)this.a.get();
/* 233 */       return (localb != null) && (b.this.a(paramInt1, paramInt2));
/*     */     }
/*     */     
/*     */ 
/*     */     public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
/*     */     {
/* 239 */       b localb = (b)this.a.get();
/* 240 */       if (localb == null) {
/* 241 */         return;
/*     */       }
/* 243 */       b.this.a(paramInt1, paramInt2, 1, 1);
/*     */     }
/*     */     
/*     */     public void onSeekComplete(MediaPlayer paramMediaPlayer)
/*     */     {
/* 248 */       b localb = (b)this.a.get();
/* 249 */       if (localb == null) {
/* 250 */         return;
/*     */       }
/* 252 */       b.this.d();
/*     */     }
/*     */     
/*     */     public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
/*     */     {
/* 257 */       b localb = (b)this.a.get();
/* 258 */       if (localb == null) {
/* 259 */         return;
/*     */       }
/* 261 */       b.this.a(paramInt);
/*     */     }
/*     */     
/*     */     public void onCompletion(MediaPlayer paramMediaPlayer)
/*     */     {
/* 266 */       b localb = (b)this.a.get();
/* 267 */       if (localb == null) {
/* 268 */         return;
/*     */       }
/* 270 */       b.this.c();
/*     */     }
/*     */     
/*     */     public void onPrepared(MediaPlayer paramMediaPlayer)
/*     */     {
/* 275 */       b localb = (b)this.a.get();
/* 276 */       if (localb == null) {
/* 277 */         return;
/*     */       }
/* 279 */       b.this.b();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\cdsss\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */