/*     */ package com.bytedance.sdk.openadsdk.core.video.c;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.media.MediaDataSource;
/*     */ import android.media.MediaPlayer;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
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
/*     */ public class MediaPlayerManager
/*     */   extends VideoManagerImpl
/*     */ {
/*     */   private final MediaPlayer mMediaPlayer;
/*     */   private final aaa b;
/*     */   private MediaDataSource mMediaDataSource;
/*  40 */   private final Object d = new Object();
/*     */   private boolean e;
/*     */   
/*     */   public MediaPlayerManager() {
/*  44 */     synchronized (this.d) {
/*  45 */       this.mMediaPlayer = new MediaPlayer();
/*     */     }
/*  47 */     this.mMediaPlayer.setAudioStreamType(3);
/*  48 */     this.b = new aaa(this);
/*  49 */     n();
/*     */   }
/*     */   
/*     */   public MediaPlayer getMediaPlayer() {
/*  53 */     return this.mMediaPlayer;
/*     */   }
/*     */   
/*     */   public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
/*     */   {
/*  58 */     synchronized (this.d) {
/*  59 */       if (!this.e) {
/*  60 */         this.mMediaPlayer.setDisplay(paramSurfaceHolder);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @TargetApi(14)
/*     */   public void setSurface(Surface paramSurface)
/*     */   {
/*  68 */     this.mMediaPlayer.setSurface(paramSurface);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setDataSource(String paramString)
/*     */     throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
/*     */   {
/*  75 */     Uri localUri = Uri.parse(paramString);
/*  76 */     String str = localUri.getScheme();
/*  77 */     if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("file"))) {
/*  78 */       this.mMediaPlayer.setDataSource(localUri.getPath());
/*     */     } else {
/*  80 */       this.mMediaPlayer.setDataSource(paramString);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void close()
/*     */   {
/*  90 */     if (this.mMediaDataSource != null) {
/*     */       try {
/*  92 */         this.mMediaDataSource.close();
/*     */       } catch (IOException localIOException) {
/*  94 */         localIOException.printStackTrace();
/*     */       }
/*  96 */       this.mMediaDataSource = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void start() throws IllegalStateException
/*     */   {
/* 102 */     this.mMediaPlayer.start();
/*     */   }
/*     */   
/*     */   public void stop() throws IllegalStateException
/*     */   {
/* 107 */     this.mMediaPlayer.stop();
/*     */   }
/*     */   
/*     */   public void pause() throws IllegalStateException
/*     */   {
/* 112 */     this.mMediaPlayer.pause();
/*     */   }
/*     */   
/*     */   public void setScreenOnWhilePlaying(boolean paramBoolean)
/*     */   {
/* 117 */     this.mMediaPlayer.setScreenOnWhilePlaying(paramBoolean);
/*     */   }
/*     */   
/*     */   public void a(long paramLong) throws IllegalStateException
/*     */   {
/* 122 */     this.mMediaPlayer.seekTo((int)paramLong);
/*     */   }
/*     */   
/*     */   public long i()
/*     */   {
/*     */     try {
/* 128 */       return this.mMediaPlayer.getCurrentPosition();
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/* 131 */     return 0L;
/*     */   }
/*     */   
/*     */   public long j()
/*     */   {
/*     */     try
/*     */     {
/* 138 */       return this.mMediaPlayer.getDuration();
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/* 141 */     return 0L;
/*     */   }
/*     */   
/*     */ 
/*     */   public void k()
/*     */   {
/* 147 */     this.e = true;
/* 148 */     this.mMediaPlayer.release();
/* 149 */     close();
/* 150 */     a();
/* 151 */     n();
/*     */   }
/*     */   
/*     */   public void l()
/*     */   {
/*     */     try {
/* 157 */       this.mMediaPlayer.reset();
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/*     */     
/* 161 */     close();
/* 162 */     a();
/* 163 */     n();
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean)
/*     */   {
/* 168 */     this.mMediaPlayer.setLooping(paramBoolean);
/*     */   }
/*     */   
/*     */   public void a(float paramFloat1, float paramFloat2)
/*     */   {
/* 173 */     this.mMediaPlayer.setVolume(paramFloat1, paramFloat2);
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
/* 188 */     this.mMediaPlayer.setWakeMode(paramContext, paramInt);
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
/* 199 */     this.mMediaPlayer.setOnPreparedListener(this.b);
/* 200 */     this.mMediaPlayer
/* 201 */       .setOnBufferingUpdateListener(this.b);
/* 202 */     this.mMediaPlayer.setOnCompletionListener(this.b);
/* 203 */     this.mMediaPlayer
/* 204 */       .setOnSeekCompleteListener(this.b);
/* 205 */     this.mMediaPlayer
/* 206 */       .setOnVideoSizeChangedListener(this.b);
/* 207 */     this.mMediaPlayer.setOnErrorListener(this.b);
/* 208 */     this.mMediaPlayer.setOnInfoListener(this.b);
/*     */   }
/*     */   
/*     */ 
/*     */   private class aaa
/*     */     implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener
/*     */   {
/*     */     public final WeakReference<b> a;
/*     */     
/*     */ 
/*     */     public aaa(MediaPlayerManager paramb)
/*     */     {
/* 220 */       this.a = new WeakReference(paramb);
/*     */     }
/*     */     
/*     */     public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
/*     */     {
/* 225 */       b localb = a.get();
/* 226 */       return (localb != null) && (b(paramInt1, paramInt2));
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
/*     */     {
/* 232 */       b localb = (b)this.a.get();
/* 233 */       return (localb != null) && (a(paramInt1, paramInt2));
/*     */     }
/*     */     
/*     */ 
/*     */     public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
/*     */     {
/* 239 */       b localb = (b)this.a.get();
/* 240 */       if (localb == null) {
/* 241 */         return;
/*     */       }
/* 243 */      a(paramInt1, paramInt2, 1, 1);
/*     */     }
/*     */     
/*     */     public void onSeekComplete(MediaPlayer paramMediaPlayer)
/*     */     {
/* 248 */       b localb = (b)this.a.get();
/* 249 */       if (localb == null) {
/* 250 */         return;
/*     */       }
/* 252 */      d();
/*     */     }
/*     */     
/*     */     public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
/*     */     {
/* 257 */       b localb = (b)this.a.get();
/* 258 */       if (localb == null) {
/* 259 */         return;
/*     */       }
/* 261 */      a(paramInt);
/*     */     }
/*     */     
/*     */     public void onCompletion(MediaPlayer paramMediaPlayer)
/*     */     {
/* 266 */       b localb = (b)this.a.get();
/* 267 */       if (localb == null) {
/* 268 */         return;
/*     */       }
/* 270 */       c();
/*     */     }
/*     */     
/*     */     public void onPrepared(MediaPlayer paramMediaPlayer)
/*     */     {
/* 275 */       b localb = (b)this.a.get();
/* 276 */       if (localb == null) {
/* 277 */         return;
/*     */       }
/* 279 */       b();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\cdsss\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */