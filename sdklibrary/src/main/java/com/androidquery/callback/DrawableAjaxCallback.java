/*      */ package com.androidquery.callback;
/*      */ 
/*      */

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ExifInterface;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.androidquery.auth.AccountHandle;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.RatioDrawable;

import org.apache.http.HttpHost;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import pl.droidsonroids.gif.GifDrawable;

/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DrawableAjaxCallback
/*      */   extends AbstractAjaxCallback<Drawable, DrawableAjaxCallback>
/*      */ {
/*   69 */   private static int a = 20;
/*   70 */   private static int b = 20;
/*   71 */   private static int c = 2500;
/*   72 */   private static int d = 160000;
/*   73 */   private static int e = 1000000;
/*      */   
/*   75 */   private static boolean f = false;
/*      */   
/*      */   private static Map<String, Drawable> g;
/*      */   
/*      */   private static Map<String, Drawable> h;
/*      */   private static Map<String, Drawable> i;
/*   81 */   private static HashMap<String, WeakHashMap<ImageView, DrawableAjaxCallback>> j = new HashMap();
/*      */   
/*      */   private WeakReference<ImageView> k;
/*      */   private int l;
/*      */   private int m;
/*      */   private File n;
/*      */   private Drawable o;
/*      */   private int p;
/*      */   private Drawable q;
/*      */   private float r;
/*      */   private int s;
/*   92 */   private boolean t = true;
/*   93 */   private float u = Float.MAX_VALUE;
/*      */   
/*      */   private boolean v;
/*      */   
/*      */   private boolean w;
/*      */   
/*      */ 
/*      */   public DrawableAjaxCallback()
/*      */   {
/*  102 */     ((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)type(Drawable.class)).memCache(true)).fileCache(true)).url("");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback imageView(ImageView paramImageView)
/*      */   {
/*  114 */     this.k = new WeakReference(paramImageView);
/*  115 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback targetWidth(int paramInt)
/*      */   {
/*  125 */     this.l = paramInt;
/*  126 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback file(File paramFile)
/*      */   {
/*  137 */     this.n = paramFile;
/*  138 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback preset(Drawable paramDrawable)
/*      */   {
/*  149 */     this.q = paramDrawable;
/*  150 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback bitmap(Drawable paramDrawable)
/*      */   {
/*  160 */     this.o = paramDrawable;
/*  161 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback fallback(int paramInt)
/*      */   {
/*  171 */     this.m = paramInt;
/*  172 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback animation(int paramInt)
/*      */   {
/*  182 */     this.p = paramInt;
/*  183 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback ratio(float paramFloat)
/*      */   {
/*  193 */     this.r = paramFloat;
/*  194 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback rotate(boolean paramBoolean)
/*      */   {
/*  204 */     this.w = paramBoolean;
/*  205 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback anchor(float paramFloat)
/*      */   {
/*  224 */     this.u = paramFloat;
/*      */     
/*  226 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public DrawableAjaxCallback round(int paramInt)
/*      */   {
/*  240 */     this.s = paramInt;
/*  241 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   private static Bitmap a(String paramString, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions, boolean paramBoolean)
/*      */   {
/*  247 */     Bitmap localBitmap = null;
/*      */     
/*      */ 
/*  250 */     if (paramString != null)
/*      */     {
/*  252 */       localBitmap = a(paramString, paramOptions, paramBoolean);
/*      */     }
/*  254 */     else if (paramArrayOfByte != null)
/*      */     {
/*  256 */       localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
/*      */     }
/*      */     
/*      */ 
/*  260 */     if ((localBitmap == null) && (paramOptions != null) && (!paramOptions.inJustDecodeBounds)) {
/*  261 */       AQUtility.debug("decode image failed", paramString);
/*      */     }
/*      */     
/*  264 */     return localBitmap;
/*      */   }
/*      */   
/*      */   private static boolean a() {
/*  268 */     AQUtility.debug("level", Integer.valueOf(AQuery.SDK_INT));
/*  269 */     return AQuery.SDK_INT < 19;
/*      */   }
/*      */   
/*      */ 
/*      */   private static Bitmap a(String paramString, BitmapFactory.Options paramOptions, boolean paramBoolean)
/*      */   {
/*  275 */     Bitmap localBitmap = null;
/*      */     
/*  277 */     if (paramOptions == null) {
/*  278 */       paramOptions = new BitmapFactory.Options();
/*      */     }
/*      */     
/*  281 */     paramOptions.inInputShareable = a();
/*  282 */     paramOptions.inPurgeable = true;
/*      */     
/*  284 */     FileInputStream localFileInputStream = null;
/*      */     
/*      */     try
/*      */     {
/*  288 */       localFileInputStream = new FileInputStream(paramString);
/*  289 */       FileDescriptor localFileDescriptor = localFileInputStream.getFD();
/*  290 */       localBitmap = BitmapFactory.decodeFileDescriptor(localFileDescriptor, null, paramOptions);
/*      */       
/*  292 */       if ((localBitmap != null) && (paramBoolean)) {
/*  293 */         localBitmap = a(paramString, localBitmap);
/*      */       }
/*      */     }
/*      */     catch (IOException localIOException)
/*      */     {
/*  298 */       AQUtility.report(localIOException);
/*      */     } finally {
/*  300 */       AQUtility.close(localFileInputStream);
/*      */     }
/*      */     
/*  303 */     return localBitmap;
/*      */   }
/*      */   
/*      */ 
/*      */   private static Bitmap a(String paramString, Bitmap paramBitmap)
/*      */   {
/*  309 */     if (paramBitmap == null) { return null;
/*      */     }
/*  311 */     Bitmap localBitmap = paramBitmap;
/*      */     
/*  313 */     int i1 = 1;
/*      */     try
/*      */     {
/*  316 */       ExifInterface localExifInterface = new ExifInterface(paramString);
/*  317 */       i1 = localExifInterface.getAttributeInt("Orientation", 1);
/*      */     }
/*      */     catch (Exception localException) {
/*  320 */       AQUtility.debug(localException);
/*      */     }
/*      */     
/*  323 */     if (i1 > 0)
/*      */     {
/*  325 */       Matrix localMatrix = a(i1);
/*  326 */       localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
/*      */       
/*  328 */       AQUtility.debug("before", paramBitmap.getWidth() + ":" + paramBitmap.getHeight());
/*  329 */       AQUtility.debug("after", localBitmap.getWidth() + ":" + localBitmap.getHeight());
/*      */       
/*  331 */       if (paramBitmap != localBitmap) {
/*  332 */         paramBitmap.recycle();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  337 */     return localBitmap;
/*      */   }
/*      */   
/*      */   private static Matrix a(int paramInt)
/*      */   {
/*  342 */     Matrix localMatrix = new Matrix();
/*  343 */     switch (paramInt) {
/*      */     case 2: 
/*  345 */       localMatrix.setScale(-1.0F, 1.0F);
/*  346 */       break;
/*      */     case 3: 
/*  348 */       localMatrix.setRotate(180.0F);
/*  349 */       break;
/*      */     case 4: 
/*  351 */       localMatrix.setRotate(180.0F);
/*  352 */       localMatrix.postScale(-1.0F, 1.0F);
/*  353 */       break;
/*      */     case 5: 
/*  355 */       localMatrix.setRotate(90.0F);
/*  356 */       localMatrix.postScale(-1.0F, 1.0F);
/*  357 */       break;
/*      */     case 6: 
/*  359 */       localMatrix.setRotate(90.0F);
/*  360 */       break;
/*      */     case 7: 
/*  362 */       localMatrix.setRotate(-90.0F);
/*  363 */       localMatrix.postScale(-1.0F, 1.0F);
/*  364 */       break;
/*      */     case 8: 
/*  366 */       localMatrix.setRotate(-90.0F);
/*      */     }
/*      */     
/*      */     
/*      */ 
/*  371 */     return localMatrix;
/*      */   }
/*      */   
/*      */   public static Drawable getResizedImage(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2)
/*      */   {
/*  376 */     return getResizedImage(paramString, paramArrayOfByte, paramInt1, paramBoolean, paramInt2, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Drawable getResizedImage(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
/*      */   {
/*  391 */     if (paramString != null) {
/*      */       try {
/*  393 */         return new GifDrawable(paramString);
/*      */ 
/*      */       }
/*      */       catch (IOException localIOException1) {}
/*  397 */     } else if (paramArrayOfByte != null) {
/*      */       try {
/*  399 */         return new GifDrawable(paramArrayOfByte);
/*      */       }
/*      */       catch (IOException localIOException2) {}
/*      */     }
/*      */     
/*      */ 
/*  405 */     return a(paramString, paramArrayOfByte, paramInt1, paramBoolean1, paramInt2, paramBoolean2);
/*      */   }
/*      */   
/*      */   private static Drawable a(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
/*  409 */     if ((paramString == null) && (paramArrayOfByte == null)) { return null;
/*      */     }
/*  411 */     BitmapFactory.Options localOptions = null;
/*      */     
/*  413 */     if (paramInt1 > 0)
/*      */     {
/*  415 */    Options   localObject = new BitmapFactory.Options();
/*  416 */       ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
/*      */       
/*  418 */       a(paramString, paramArrayOfByte, (BitmapFactory.Options)localObject, paramBoolean2);
/*      */       
/*  420 */       int i1 = ((BitmapFactory.Options)localObject).outWidth;
/*  421 */       if (!paramBoolean1) i1 = Math.max(i1, ((BitmapFactory.Options)localObject).outHeight);
/*  422 */       int i2 = a(i1, paramInt1);
/*      */       
/*  424 */       localOptions = new BitmapFactory.Options();
/*  425 */       localOptions.inSampleSize = i2;
/*      */     }
/*      */     
/*      */ 
/*  429 */     Object localObject = null;
/*      */     try {
/*  431 */       localObject = a(paramString, paramArrayOfByte, localOptions, paramBoolean2);
/*      */     } catch (OutOfMemoryError localOutOfMemoryError) {
/*  433 */       clearCache();
/*  434 */       AQUtility.report(localOutOfMemoryError);
/*      */     }
/*      */     
/*  437 */     if (paramInt2 > 0) {
/*  438 */       localObject = a((Bitmap)localObject, paramInt2);
/*      */     }
/*      */     
/*  441 */     return localObject == null ? null : new BitmapDrawable((Bitmap)localObject);
/*      */   }
/*      */   
/*      */ 
/*      */   private static int a(int paramInt1, int paramInt2)
/*      */   {
/*  447 */     int i1 = 1;
/*      */     
/*  449 */     for (int i2 = 0; i2 < 10; i2++)
/*      */     {
/*  451 */       if (paramInt1 < paramInt2 * 2) {
/*      */         break;
/*      */       }
/*      */       
/*  455 */       paramInt1 /= 2;
/*  456 */       i1 *= 2;
/*      */     }
/*      */     
/*      */ 
/*  460 */     return i1;
/*      */   }
/*      */   
/*      */   private Drawable a(String paramString, byte[] paramArrayOfByte) {
/*  464 */     return getResizedImage(paramString, paramArrayOfByte, this.l, this.t, this.s, this.w);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected File accessFile(File paramFile, String paramString)
/*      */   {
/*  471 */     if ((this.n != null) && (this.n.exists())) {
/*  472 */       return this.n;
/*      */     }
/*      */     
/*  475 */     return super.accessFile(paramFile, paramString);
/*      */   }
/*      */   
/*      */ 
/*      */   protected Drawable a(String paramString, File paramFile, AjaxStatus paramAjaxStatus)
/*      */   {
/*  481 */     return a(paramFile.getAbsolutePath(), (byte[]) null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Drawable transform(String paramString, byte[] paramArrayOfByte, AjaxStatus paramAjaxStatus)
/*      */   {
/*  489 */     String str = null;
/*      */     
/*  491 */     File localFile = paramAjaxStatus.getFile();
/*  492 */     if (localFile != null) {
/*  493 */       str = localFile.getAbsolutePath();
/*      */     }
/*      */     
/*  496 */     Object localObject = a(str, paramArrayOfByte);
/*      */     
/*  498 */     if (localObject == null)
/*      */     {
/*  500 */       if (this.m > 0) {
/*  501 */         localObject = b();
/*  502 */       } else if ((this.m == -2) || (this.m == -1)) {
/*  503 */         localObject = new BitmapDrawable(y);
/*  504 */       } else if (this.m == -3) {
/*  505 */         localObject = this.q;
/*      */       }
/*      */       
/*  508 */       if (paramAjaxStatus.getCode() != 200) {
/*  509 */         this.v = true;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  514 */       if ((paramAjaxStatus.getSource() == 1) && (localFile != null)) {
/*  515 */         AQUtility.debug("invalid bm from net");
/*  516 */         localFile.delete();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  524 */     return (Drawable)localObject;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private Drawable b()
/*      */   {
/*  532 */     Object localObject = null;
/*      */     
/*  534 */     View localView = (View)this.k.get();
/*  535 */     if (localView != null)
/*      */     {
/*  537 */       String str = Integer.toString(this.m);
/*  538 */       localObject = a(str);
/*      */       
/*  540 */       if (localObject == null) {
/*  541 */         Bitmap localBitmap = BitmapFactory.decodeResource(localView.getResources(), this.m);
/*  542 */         if (localBitmap != null) {
/*  543 */           localObject = new BitmapDrawable(localBitmap);
/*  544 */           a(str, (Drawable)localObject);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  549 */     return (Drawable)localObject;
/*      */   }
/*      */   
/*      */ 
/*      */   public static Drawable getMemoryCached(Context paramContext, int paramInt)
/*      */   {
/*  555 */     String str = Integer.toString(paramInt);
/*  556 */     Object localObject = a(str, 0, 0);
/*      */     
/*  558 */     if (localObject == null) {
/*  559 */       Bitmap localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
/*  560 */       if (localBitmap != null) {
/*  561 */         localObject = new BitmapDrawable(localBitmap);
/*  562 */         a(str, 0, 0, (Drawable)localObject, false);
/*      */       }
/*      */     }
/*      */     
/*  566 */     return (Drawable)localObject;
/*      */   }
/*      */   
/*  569 */   private static Bitmap x = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
/*      */   
/*  571 */   public static Bitmap getEmptyBitmap() { return x; }
/*      */   
/*      */ 
/*  574 */   private static Bitmap y = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public final void callback(String paramString, Drawable paramDrawable, AjaxStatus paramAjaxStatus)
/*      */   {
/*  581 */     ImageView localImageView1 = (ImageView)this.k.get();
/*  582 */     WeakHashMap localWeakHashMap = (WeakHashMap)j.remove(paramString);
/*      */     
/*      */ 
/*  585 */     if ((localWeakHashMap == null) || (!localWeakHashMap.containsKey(localImageView1))) {
/*  586 */       a(this, paramString, localImageView1, paramDrawable, paramAjaxStatus);
/*      */     }
/*      */     
/*  589 */     if (localWeakHashMap != null)
/*      */     {
/*  591 */       Set<ImageView> localSet = localWeakHashMap.keySet();
/*      */       
/*  593 */       for (ImageView localImageView2 : localSet) {
/*  594 */         DrawableAjaxCallback localDrawableAjaxCallback = (DrawableAjaxCallback)localWeakHashMap.get(localImageView2);
/*  595 */         localDrawableAjaxCallback.status = paramAjaxStatus;
/*  596 */         a(localDrawableAjaxCallback, paramString, localImageView2, paramDrawable, paramAjaxStatus);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void a(String paramString, Drawable paramDrawable, AjaxStatus paramAjaxStatus)
/*      */   {
/*  605 */     j.remove(paramString);
/*      */   }
/*      */   
/*      */ 
/*      */   private void a(DrawableAjaxCallback paramDrawableAjaxCallback, String paramString, ImageView paramImageView, Drawable paramDrawable, AjaxStatus paramAjaxStatus)
/*      */   {
/*  611 */     if ((paramImageView == null) || (paramDrawableAjaxCallback == null)) { return;
/*      */     }
/*  613 */     if (paramString.equals(paramImageView.getTag(1090453505)))
/*      */     {
/*  615 */       if ((paramImageView instanceof ImageView)) {
/*  616 */         paramDrawableAjaxCallback.a(paramString, paramImageView, paramDrawable, paramAjaxStatus);
/*      */       } else {
/*  618 */         paramDrawableAjaxCallback.a(paramString, paramImageView, paramDrawable, false);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  623 */     paramDrawableAjaxCallback.showProgress(false);
/*      */   }
/*      */   
/*      */   protected void a(String paramString, ImageView paramImageView, Drawable paramDrawable, AjaxStatus paramAjaxStatus) {
/*  627 */     a(paramString, paramImageView, paramDrawable, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setIconCacheLimit(int paramInt)
/*      */   {
/*  637 */     a = paramInt;
/*  638 */     clearCache();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setCacheLimit(int paramInt)
/*      */   {
/*  647 */     b = paramInt;
/*  648 */     clearCache();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setDelayWrite(boolean paramBoolean)
/*      */   {
/*  659 */     f = paramBoolean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setPixelLimit(int paramInt)
/*      */   {
/*  670 */     d = paramInt;
/*  671 */     clearCache();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setSmallPixel(int paramInt)
/*      */   {
/*  682 */     c = paramInt;
/*  683 */     clearCache();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setMaxPixelLimit(int paramInt)
/*      */   {
/*  692 */     e = paramInt;
/*  693 */     clearCache();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void clearCache()
/*      */   {
/*  700 */     h = null;
/*  701 */     g = null;
/*  702 */     i = null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<String, Drawable> c()
/*      */   {
/*  710 */     if (h == null) {
/*  711 */       h = Collections.synchronizedMap(new ParamMap(b, d, e));
/*      */     }
/*  713 */     return h;
/*      */   }
/*      */   
/*      */   private static Map<String, Drawable> d()
/*      */   {
/*  718 */     if (g == null) {
/*  719 */       g = Collections.synchronizedMap(new ParamMap(a, c, 250000));
/*      */     }
/*  721 */     return g;
/*      */   }
/*      */   
/*      */   private static Map<String, Drawable> e() {
/*  725 */     if (i == null) {
/*  726 */       i = Collections.synchronizedMap(new ParamMap(100, d, 250000));
/*      */     }
/*  728 */     return i;
/*      */   }
/*      */   
/*      */   protected Drawable a(String paramString)
/*      */   {
/*  733 */     if (this.o != null) return this.o;
/*  734 */     if (!this.memCache) return null;
/*  735 */     return a(paramString, this.l, this.s);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isMemoryCached(String paramString)
/*      */   {
/*  745 */     return (c().containsKey(paramString)) || (d().containsKey(paramString)) || (e().containsKey(paramString));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Drawable getMemoryCached(String paramString, int paramInt)
/*      */   {
/*  756 */     return a(paramString, paramInt, 0);
/*      */   }
/*      */   
/*      */   private static Drawable a(String paramString, int paramInt1, int paramInt2)
/*      */   {
/*  761 */     paramString = b(paramString, paramInt1, paramInt2);
/*      */     
/*  763 */     Map localMap = c();
/*  764 */     Drawable localDrawable = (Drawable)localMap.get(paramString);
/*      */     
/*  766 */     if (localDrawable == null) {
/*  767 */       localMap = d();
/*  768 */       localDrawable = (Drawable)localMap.get(paramString);
/*      */     }
/*      */     
/*  771 */     if (localDrawable == null) {
/*  772 */       localMap = e();
/*  773 */       localDrawable = (Drawable)localMap.get(paramString);
/*      */       
/*  775 */       if (localDrawable != null)
/*      */       {
/*  777 */         if (getLastStatus() == 200) {
/*  778 */           i = null;
/*  779 */           localDrawable = null;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  785 */     return localDrawable;
/*      */   }
/*      */   
/*      */   private static String b(String paramString, int paramInt1, int paramInt2)
/*      */   {
/*  790 */     if (paramInt1 > 0) {
/*  791 */       paramString = paramString + "#" + paramInt1;
/*      */     }
/*      */     
/*  794 */     if (paramInt2 > 0) {
/*  795 */       paramString = paramString + "#" + paramInt2;
/*      */     }
/*      */     
/*  798 */     return paramString;
/*      */   }
/*      */   
/*      */   private static void a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
/*      */   {
/*  803 */     if (paramDrawable == null) { return;
/*      */     }
/*  805 */     int i1 = 0;
/*  806 */     if ((paramDrawable instanceof BitmapDrawable)) {
/*  807 */      Bitmap localObject = ((BitmapDrawable)paramDrawable).getBitmap();
/*  808 */       i1 = ((Bitmap)localObject).getWidth() * ((Bitmap)localObject).getHeight();
/*      */     }
/*      */     else {
/*  811 */       i1 = d;
/*      */     }
/*      */     
/*  814 */     Object localObject = null;
/*      */     
/*  816 */     if (paramBoolean) {
/*  817 */       localObject = e();
/*  818 */     } else if (i1 <= c) {
/*  819 */       localObject = d();
/*      */     } else {
/*  821 */       localObject = c();
/*      */     }
/*      */     
/*  824 */     if ((paramInt1 > 0) || (paramInt2 > 0))
/*      */     {
/*  826 */       String str = b(paramString, paramInt1, paramInt2);
/*  827 */       ((Map)localObject).put(str, paramDrawable);
/*      */       
/*      */ 
/*  830 */       if (!((Map)localObject).containsKey(paramString)) {
/*  831 */         ((Map)localObject).put(paramString, null);
/*      */       }
/*      */     }
/*      */     else {
/*  835 */       ((Map)localObject).put(paramString, paramDrawable);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void a(String paramString, Drawable paramDrawable)
/*      */   {
/*  845 */     a(paramString, this.l, this.s, paramDrawable, this.v);
/*      */   }
/*      */   
/*      */   private static Drawable a(View paramView, Drawable paramDrawable, int paramInt)
/*      */   {
/*  850 */     if ((paramDrawable instanceof BitmapDrawable)) {
/*  851 */       Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
/*      */       
/*  853 */       if ((localBitmap != null) && (localBitmap.getWidth() == 1) && (localBitmap.getHeight() == 1) && (localBitmap != x)) {
/*  854 */         localBitmap = null;
/*      */       }
/*      */       
/*  857 */       if (localBitmap != null) {
/*  858 */         paramView.setVisibility(View.VISIBLE);
/*  859 */       } else if (paramInt == -2) {
/*  860 */         paramView.setVisibility(View.GONE);
/*  861 */       } else if (paramInt == -1) {
/*  862 */         paramView.setVisibility(View.INVISIBLE);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  867 */     return paramDrawable;
/*      */   }
/*      */   
/*      */ 
/*      */   private void a(String paramString, ImageView paramImageView)
/*      */   {
/*  873 */     if ((!paramString.equals(paramImageView.getTag(1090453505))) || (this.q != null))
/*      */     {
/*  875 */       paramImageView.setTag(1090453505, paramString);
/*      */       
/*  877 */       if ((this.q != null) && (!cacheAvailable(paramImageView.getContext()))) {
/*  878 */         a(paramString, paramImageView, this.q, true);
/*      */       }
/*      */       else {
/*  881 */         a(paramString, paramImageView, null, true);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void a(String paramString, ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean)
/*      */   {
/*  892 */     if (paramDrawable == null) {
/*  893 */       paramImageView.setImageDrawable(null);
/*  894 */       return;
/*      */     }
/*      */     
/*  897 */     if (paramBoolean) {
/*  898 */       if ((paramDrawable instanceof BitmapDrawable))
/*  899 */         paramImageView.setImageDrawable(a(paramImageView, ((BitmapDrawable)paramDrawable).getBitmap(), this.r, this.u));
/*  900 */       return;
/*      */     }
/*      */     
/*  903 */     if (this.status != null) {
/*  904 */       a(paramImageView, paramDrawable, this.q, this.m, this.p, this.r, this.u, this.status.getSource());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static Drawable a(ImageView paramImageView, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
/*      */   {
/*  911 */     Object localObject = null;
/*      */     
/*  913 */     if (paramFloat1 > 0.0F) {
/*  914 */       localObject = new RatioDrawable(paramImageView.getResources(), paramBitmap, paramImageView, paramFloat1, paramFloat2);
/*      */     } else {
/*  916 */       localObject = new BitmapDrawable(paramImageView.getResources(), paramBitmap);
/*      */     }
/*      */     
/*  919 */     return (Drawable)localObject;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void a(ImageView paramImageView, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
/*      */   {
/*  925 */     paramDrawable1 = a(paramImageView, paramDrawable1, paramInt1);
/*  926 */     if (paramDrawable1 == null) {
/*  927 */       paramImageView.setImageBitmap(null); return;
/*      */     }
/*      */     
/*      */     Drawable localObject1;
/*  931 */     if ((paramDrawable1 instanceof BitmapDrawable)) {
/*  932 */       localObject1 = a(paramImageView, ((BitmapDrawable)paramDrawable1).getBitmap(), paramFloat1, paramFloat2);
/*      */     }
/*      */     else {
/*  935 */       localObject1 = paramDrawable1;
/*      */     }
/*  937 */     Object localObject2 = null;
/*      */     
/*  939 */     if (b(paramInt2, paramInt3)) {
/*  940 */       if (paramDrawable2 == null) {
/*  941 */         localObject2 = new AlphaAnimation(0.0F, 1.0F);
/*  942 */         ((Animation)localObject2).setInterpolator(new DecelerateInterpolator());
/*  943 */         ((Animation)localObject2).setDuration(300L);
/*      */       }
/*  945 */       else if ((paramDrawable2 instanceof BitmapDrawable)) {
/*  946 */         Drawable localDrawable = a(paramImageView, ((BitmapDrawable)paramDrawable2).getBitmap(), paramFloat1, paramFloat2);
/*  947 */         Drawable[] arrayOfDrawable = { localDrawable, localObject1 };
/*  948 */         TransitionDrawable localTransitionDrawable = new TransitionDrawable(arrayOfDrawable);
/*  949 */         localTransitionDrawable.setCrossFadeEnabled(true);
/*  950 */         localTransitionDrawable.startTransition(300);
/*  951 */         localObject1 = localTransitionDrawable;
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*  956 */     else if (paramInt2 > 0) {
/*  957 */       localObject2 = AnimationUtils.loadAnimation(paramImageView.getContext(), paramInt2);
/*      */     }
/*      */     
/*  960 */     paramImageView.setImageDrawable((Drawable)localObject1);
/*      */     
/*  962 */     if (localObject2 != null) {
/*  963 */       ((Animation)localObject2).setStartTime(AnimationUtils.currentAnimationTimeMillis());
/*  964 */       paramImageView.startAnimation((Animation)localObject2);
/*      */     } else {
/*  966 */       paramImageView.setAnimation(null);
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean b(int paramInt1, int paramInt2)
/*      */   {
/*  972 */     switch (paramInt1) {
/*      */     case -1: 
/*  974 */       return true;
/*      */     case -3: 
/*  976 */       if (paramInt2 == 3) return true;
/*      */     case -2: 
/*  978 */       if (paramInt2 == 1) return true;
/*      */       break; }
/*  980 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, Object paramObject, AccountHandle paramAccountHandle, ImageOptions paramImageOptions, HttpHost paramHttpHost, String paramString2)
/*      */   {
/*  995 */     async(paramActivity, paramContext, paramImageView, paramString1, paramImageOptions.memCache, paramImageOptions.fileCache, paramImageOptions.targetWidth, paramImageOptions.fallback, new BitmapDrawable(paramImageOptions.preset), paramImageOptions.animation, paramImageOptions.ratio, paramImageOptions.anchor, paramObject, paramAccountHandle, paramImageOptions.policy, paramImageOptions.round, paramHttpHost, paramString2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Drawable paramDrawable, int paramInt3, float paramFloat1, float paramFloat2, Object paramObject, AccountHandle paramAccountHandle, int paramInt4, int paramInt5, HttpHost paramHttpHost, String paramString2)
/*      */   {
/* 1010 */     Drawable localDrawable = null;
/*      */     
/* 1012 */     if (paramBoolean1) {
/* 1013 */       localDrawable = a(paramString1, paramInt1, paramInt5);
/*      */     }
/*      */     
/* 1016 */     if (localDrawable != null) {
/* 1017 */       paramImageView.setTag(1090453505, paramString1);
/* 1018 */       Common.showProgress(paramObject, paramString1, false);
/* 1019 */       a(paramImageView, localDrawable, paramDrawable, paramInt2, paramInt3, paramFloat1, paramFloat2, 4);
/*      */     } else {
/* 1021 */       DrawableAjaxCallback localDrawableAjaxCallback = new DrawableAjaxCallback();
/* 1022 */       ((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)localDrawableAjaxCallback.url(paramString1)).imageView(paramImageView).memCache(paramBoolean1)).fileCache(paramBoolean2)).targetWidth(paramInt1).fallback(paramInt2).preset(paramDrawable).animation(paramInt3).ratio(paramFloat1).anchor(paramFloat2).progress(paramObject)).auth(paramAccountHandle)).policy(paramInt4)).round(paramInt5).networkUrl(paramString2);
/* 1023 */       if (paramHttpHost != null) {
/* 1024 */         localDrawableAjaxCallback.proxy(paramHttpHost.getHostName(), paramHttpHost.getPort());
/*      */       }
/* 1026 */       if (paramActivity != null) {
/* 1027 */         localDrawableAjaxCallback.async(paramActivity);
/*      */       } else {
/* 1029 */         localDrawableAjaxCallback.async(paramContext);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, Object paramObject, AccountHandle paramAccountHandle, ImageOptions paramImageOptions, HttpHost paramHttpHost, String paramString2, DrawableAjaxCallback paramDrawableAjaxCallback)
/*      */   {
/* 1042 */     async(paramActivity, paramContext, paramImageView, paramString1, paramImageOptions.memCache, paramImageOptions.fileCache, paramImageOptions.targetWidth, paramImageOptions.fallback, new BitmapDrawable(paramImageOptions.preset), paramImageOptions.animation, paramImageOptions.ratio, paramImageOptions.anchor, paramObject, paramAccountHandle, paramImageOptions.policy, paramImageOptions.round, paramHttpHost, paramString2, paramDrawableAjaxCallback);
/*      */   }
/*      */   
/*      */   public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Drawable paramDrawable, int paramInt3, float paramFloat1, float paramFloat2, Object paramObject, AccountHandle paramAccountHandle, int paramInt4, int paramInt5, HttpHost paramHttpHost, String paramString2, DrawableAjaxCallback paramDrawableAjaxCallback)
/*      */   {
/* 1047 */     ((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)((DrawableAjaxCallback)paramDrawableAjaxCallback.url(paramString1)).imageView(paramImageView).memCache(paramBoolean1)).fileCache(paramBoolean2)).targetWidth(paramInt1).fallback(paramInt2).preset(paramDrawable).animation(paramInt3).ratio(paramFloat1).anchor(paramFloat2).progress(paramObject)).auth(paramAccountHandle)).policy(paramInt4)).round(paramInt5).networkUrl(paramString2);
/* 1048 */     if (paramHttpHost != null) {
/* 1049 */       paramDrawableAjaxCallback.proxy(paramHttpHost.getHostName(), paramHttpHost.getPort());
/*      */     }
/* 1051 */     if (paramActivity != null) {
/* 1052 */       paramDrawableAjaxCallback.async(paramActivity);
/*      */     } else {
/* 1054 */       paramDrawableAjaxCallback.async(paramContext);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void async(Context paramContext)
/*      */   {
/* 1063 */     String str = getUrl();
/*      */     
/* 1065 */     ImageView localImageView = (ImageView)this.k.get();
/*      */     
/* 1067 */     if (str == null) {
/* 1068 */       showProgress(false);
/* 1069 */       a(str, localImageView, null, false);
/* 1070 */       return;
/*      */     }
/*      */     
/* 1073 */     Drawable localDrawable = a(str);
/* 1074 */     if (localDrawable != null) {
/* 1075 */       localImageView.setTag(1090453505, str);
/* 1076 */       this.status = new AjaxStatus().source(4).done();
/* 1077 */       callback(str, localDrawable, this.status);
/* 1078 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1082 */     a(str, localImageView);
/*      */     
/* 1084 */     if (!j.containsKey(str)) {
/* 1085 */       b(str, localImageView);
/* 1086 */       super.async(localImageView.getContext());
/*      */     } else {
/* 1088 */       showProgress(true);
/* 1089 */       b(str, localImageView);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected boolean isStreamingContent()
/*      */   {
/* 1097 */     return !f;
/*      */   }
/*      */   
/*      */ 
/*      */   private void b(String paramString, ImageView paramImageView)
/*      */   {
/* 1103 */     WeakHashMap localWeakHashMap = (WeakHashMap)j.get(paramString);
/*      */     
/* 1105 */     if (localWeakHashMap == null)
/*      */     {
/* 1107 */       if (j.containsKey(paramString))
/*      */       {
/* 1109 */         localWeakHashMap = new WeakHashMap();
/* 1110 */         localWeakHashMap.put(paramImageView, this);
/* 1111 */         j.put(paramString, localWeakHashMap);
/*      */       }
/*      */       else {
/* 1114 */         j.put(paramString, null);
/*      */       }
/*      */       
/*      */     }
/*      */     else {
/* 1119 */       localWeakHashMap.put(paramImageView, this);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static Bitmap a(Bitmap paramBitmap, int paramInt)
/*      */   {
/* 1126 */     if (paramBitmap == null) {
/* 1127 */       return null;
/*      */     }
/* 1129 */     Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
/* 1130 */     Canvas localCanvas = new Canvas(localBitmap);
/*      */     
/* 1132 */     int i1 = -12434878;
/* 1133 */     Paint localPaint = new Paint();
/* 1134 */     Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
/* 1135 */     RectF localRectF = new RectF(localRect);
/* 1136 */     float f1 = paramInt;
/*      */     
/* 1138 */     localPaint.setAntiAlias(true);
/* 1139 */     localCanvas.drawARGB(0, 0, 0, 0);
/* 1140 */     localPaint.setColor(-12434878);
/* 1141 */     localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
/*      */     
/* 1143 */     localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
/* 1144 */     localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
/*      */     
/* 1146 */     return localBitmap;
/*      */   }
/*      */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\androidquery\callback\DrawableAjaxCallback.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */