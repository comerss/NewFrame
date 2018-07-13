/*      */ package com.bytedance.sdk.openadsdk.ccccc;
/*      */ 
/*      */

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
/*      */ public class AppAdViewHolder
/*      */ {
/*  335 */   public static final String[] STRINGS = { "_id", "_data AS local_filename", "mediaprovider_uri", "destination", "title", "description", "icon_url", "uri", "status", "hint", "mimetype AS media_type", "total_bytes AS total_size", "lastmod AS last_modified_timestamp", "current_bytes AS bytes_so_far", "allow_write", "etag", "'placeholder' AS local_uri", "'placeholder' AS reason" };
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Context b;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private ContentResolver c;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private i mI;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private String e;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class fccc
/*      */   {
/*      */     private Uri b;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private Uri c;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  383 */     private List<Pair<String, String>> d = new ArrayList();
/*      */     private CharSequence e;
/*      */     private CharSequence f;
/*      */     private CharSequence g;
/*      */     private String h;
/*  388 */     private int i = -1;
/*  389 */     private boolean j = true;
/*  390 */     private boolean k = true;
/*  391 */     private boolean l = false;
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
/*  434 */     private int m = 0;
/*      */     
/*      */ 
/*      */ 
/*      */     public fccc(Uri paramUri)
/*      */     {
/*  440 */       if (paramUri == null) {
/*  441 */         throw new NullPointerException();
/*      */       }
/*  443 */       String str = paramUri.getScheme();
/*  444 */       if ((str == null) || ((!str.equals("http")) && (!str.equals("https")))) {
/*  445 */         throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + paramUri);
/*      */       }
/*  447 */       this.b = paramUri;
/*      */     }
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
/*      */     public fccc a(Context paramContext, String paramString1, String paramString2)
/*      */     {
/*  492 */       File localFile = paramContext.getExternalFilesDir(paramString1);
/*  493 */       if (localFile == null)
/*  494 */         throw new IllegalStateException("Failed to get external storage files directory");
/*  495 */       if (localFile.exists()) {
/*  496 */         if (!localFile.isDirectory()) {
/*  497 */           throw new IllegalStateException(localFile.getAbsolutePath() + " already exists and is not SslHepler directory");
/*      */         }
/*      */         
/*      */       }
/*  501 */       else if (!localFile.mkdirs())
/*      */       {
/*  503 */         throw new IllegalStateException("Unable to create directory: " + localFile.getAbsolutePath());
/*      */       }
/*      */       
/*  506 */       a(localFile, paramString2);
/*  507 */       return this;
/*      */     }
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
/*      */     private void a(File paramFile, String paramString)
/*      */     {
/*  545 */       if (paramString == null) {
/*  546 */         throw new NullPointerException("subPath cannot be null");
/*      */       }
/*  548 */       this.c = Uri.withAppendedPath(Uri.fromFile(paramFile), paramString);
/*      */     }
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
/*      */     public fccc a(CharSequence paramCharSequence)
/*      */     {
/*  591 */       this.e = paramCharSequence;
/*  592 */       return this;
/*      */     }
/*      */     
/*      */     public fccc b(CharSequence paramCharSequence) {
/*  596 */       this.g = paramCharSequence;
/*  597 */       return this;
/*      */     }
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
/*      */     public fccc a(String paramString)
/*      */     {
/*  619 */       this.h = paramString;
/*  620 */       return this;
/*      */     }
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
/*      */     public fccc a(int paramInt)
/*      */     {
/*  641 */       this.m = paramInt;
/*  642 */       return this;
/*      */     }
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
/*      */     public fccc a(boolean paramBoolean)
/*      */     {
/*  667 */       this.j = paramBoolean;
/*  668 */       return this;
/*      */     }
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
/*      */     ContentValues b(String paramString)
/*      */     {
/*  687 */       ContentValues localContentValues = new ContentValues();
///*  688 */       if ((!aaaaaa) && (this.bee == null)) throw new AssertionError();
/*  689 */       localContentValues.put("uri", this.b.toString());
/*  690 */       localContentValues.put("notificationpackage", paramString);
/*      */       
/*  692 */       if (this.c != null) {
/*  693 */         localContentValues.put("destination", Integer.valueOf(1));
/*  694 */         localContentValues.put("hint", this.c.toString());
/*      */       } else {
/*  696 */         localContentValues.put("destination", Integer.valueOf(0));
/*      */       }
/*      */       
/*  699 */       localContentValues.put("scanned", Integer.valueOf(this.l ? 0 : 2));
/*      */       
/*      */ 
/*  702 */       if (!this.d.isEmpty()) {
/*  703 */         a(localContentValues);
/*      */       }
/*      */       
/*  706 */       a(localContentValues, "title", this.e);
/*  707 */       a(localContentValues, "description", this.f);
/*  708 */       a(localContentValues, "icon_url", this.g);
/*  709 */       a(localContentValues, "mimetype", this.h);
/*      */       
/*  711 */       localContentValues.put("visibility", Integer.valueOf(this.m));
/*  712 */       localContentValues.put("allowed_network_types", Integer.valueOf(this.i));
/*  713 */       localContentValues.put("allow_roaming", Boolean.valueOf(this.j));
/*  714 */       localContentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(this.k));
/*      */       
/*  716 */       return localContentValues;
/*      */     }
/*      */     
/*      */     private void a(ContentValues paramContentValues) {
/*  720 */       int n = 0;
/*  721 */       for (Pair localPair : this.d) {
/*  722 */         String str = (String)localPair.first + ": " + (String)localPair.second;
/*  723 */         paramContentValues.put("http_header_" + n, str);
/*  724 */         n++;
/*      */       }
/*      */     }
/*      */     
/*      */     private void a(ContentValues paramContentValues, String paramString, Object paramObject) {
/*  729 */       if (paramObject != null) {
/*  730 */         paramContentValues.put(paramString, paramObject.toString());
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
/*      */   public static class fbbb
/*      */   {
/*  753 */     private long[] a = null;
/*  754 */     private String[] b = null;
/*  755 */     private Integer c = null;
/*  756 */     private String d = "lastmod";
/*  757 */     private int e = 2;
/*  758 */     private boolean f = false;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public fbbb a(long... paramVarArgs)
/*      */     {
/*  766 */       this.a = paramVarArgs;
/*  767 */       return this;
/*      */     }
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
/*      */     public fbbb a(String... paramVarArgs)
/*      */     {
/*  787 */       this.b = paramVarArgs;
/*  788 */       return this;
/*      */     }
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
/*      */     Cursor a(i parami, String[] paramArrayOfString, Uri paramUri)
/*      */     {
/*  838 */       Uri localUri = paramUri;
/*  839 */       ArrayList localArrayList1 = new ArrayList();
/*  840 */       ArrayList localArrayList2 = new ArrayList();
/*  841 */       String[] arrayOfString = null;
/*      */       
/*  843 */       if (this.a != null) {
/*  844 */         localArrayList1.add(e(this.a));
/*  845 */         localArrayList2.addAll(Arrays.asList(f(this.a)));
/*      */       }
/*      */       
/*  848 */       if (this.b != null) {
/*  849 */         localArrayList1.add(a(this.b));
/*  850 */         localArrayList2.addAll(Arrays.asList(b(this.b)));
/*      */       }
/*      */       
/*  853 */       if (this.c != null) {
/*  854 */       List  localObject = new ArrayList();
/*  855 */         if ((this.c.intValue() & 0x1) != 0) {
/*  856 */           ((List)localObject).add(a("=", 190));
/*      */         }
/*  858 */         if ((this.c.intValue() & 0x2) != 0) {
/*  859 */           ((List)localObject).add(a("=", 192));
/*      */         }
/*  861 */         if ((this.c.intValue() & 0x4) != 0) {
/*  862 */           ((List)localObject).add(a("=", 193));
/*  863 */           ((List)localObject).add(a("=", 194));
/*  864 */           ((List)localObject).add(a("=", 195));
/*  865 */           ((List)localObject).add(a("=", 196));
/*      */         }
/*  867 */         if ((this.c.intValue() & 0x8) != 0) {
/*  868 */           ((List)localObject).add(a("=", 200));
/*      */         }
/*  870 */         if ((this.c.intValue() & 0x10) != 0) {
/*  871 */           ((List)localObject).add("(" + a(">=", 400) + " AND " + 
/*  872 */             a("<", 600) + ")");
/*      */         }
/*  874 */         localArrayList1.add(getString(" OR ", (Iterable)localObject));
/*      */       }
/*      */       
/*  877 */       if (this.f) {
/*  878 */         localArrayList1.add("is_visible_in_downloads_ui != '0'");
/*      */       }
/*      */       
/*      */ 
/*  882 */       localArrayList1.add("deleted != '1'");
/*      */       
/*  884 */       Object localObject = getString(" AND ", localArrayList1);
/*      */       try {
/*  886 */         arrayOfString = (String[])localArrayList2.toArray(new String[localArrayList2.size()]);
/*      */       } catch (ArrayStoreException localArrayStoreException) {
/*  888 */         localArrayStoreException.printStackTrace();
/*      */       }
/*  890 */       String str1 = this.e == 1 ? "ASC" : "DESC";
/*  891 */       String str2 = this.d + " " + str1;
/*      */       try {
/*  893 */         return parami.a(localUri, paramArrayOfString, (String)localObject, arrayOfString, str2);
/*      */       }
/*      */       catch (Exception localException) {}
/*  896 */       return null;
/*      */     }
/*      */     
/*      */     private String getString(String paramString, Iterable<String> paramIterable)
/*      */     {
/*  901 */       StringBuilder localStringBuilder = new StringBuilder();
/*  902 */       int i = 1;
/*  903 */       for (String str : paramIterable) {
/*  904 */         if (i == 0) {
/*  905 */           localStringBuilder.append(paramString);
/*      */         }
/*  907 */         localStringBuilder.append(str);
/*  908 */         i = 0;
/*      */       }
/*  910 */       return localStringBuilder.toString();
/*      */     }
/*      */     
/*      */     private String a(String paramString, int paramInt) {
/*  914 */       return "status" + paramString + "'" + paramInt + "'";
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  922 */   private Uri f = com.bytedance.sdk.openadsdk.ccccc.m.a.a;
/*      */   private static AppAdViewHolder g;
/*      */   
/*      */   public static synchronized AppAdViewHolder aaaaaa(Context paramContext) {
/*  926 */     if (g == null) {
/*  927 */       g = new AppAdViewHolder(paramContext, paramContext.getPackageName());
/*      */     }
/*  929 */     return g;
/*      */   }
/*      */   
/*      */   private AppAdViewHolder(Context paramContext, String paramString) {
/*  933 */     this.b = paramContext.getApplicationContext();
/*  934 */     this.c = paramContext.getApplicationContext().getContentResolver();
/*  935 */     this.mI = i.a(this.b.getApplicationContext());
/*  936 */     this.e = paramString;
/*  937 */            aaaaaa((com.bytedance.sdk.openadsdk.ccccc.asasa.b)(new com.bytedance.sdk.openadsdk.ccccc.asasa.sdf(this.b)));
    /*      */   }
/*      */   
/*      */   public y aaaaaa(String paramString) {
/*  941 */     if (TextUtils.isEmpty(paramString)) {
/*  942 */       return null;
/*      */     }
/*  944 */     Cursor localCursor = null;
/*      */     try {
/*  946 */       fbbb localb = new fbbb();
/*  947 */       localb.a(new String[] { paramString });
/*  948 */       localCursor = aaaaaa(localb);
/*  949 */       if ((localCursor != null) && (localCursor.getCount() >= 1)) {
/*  950 */         localCursor.moveToFirst();
/*  951 */         y localy1 = new y();
/*  952 */         localy1.a = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
/*  953 */         localy1.b = localCursor.getInt(localCursor.getColumnIndexOrThrow("status"));
/*  954 */         localy1.c = localCursor.getLong(localCursor.getColumnIndexOrThrow("total_size"));
/*  955 */         localy1.d = localCursor.getLong(localCursor.getColumnIndexOrThrow("bytes_so_far"));
/*  956 */         localy1.e = localCursor.getString(localCursor.getColumnIndexOrThrow("local_filename"));
/*  957 */         return localy1;
/*      */       }
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
/*  970 */       return null;
/*      */     }
/*      */     catch (Exception localException2)
/*      */     {
/*  960 */       localException2.printStackTrace();
/*      */     } finally {
/*      */       try {
/*  963 */         if (localCursor != null) {
/*  964 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException5) {}
/*      */     }
return null;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean aaaaaa(y paramy)
/*      */   {
/*  974 */     if (paramy == null) {
/*  975 */       return false;
/*      */     }
/*  977 */     if ((paramy.b == 8) && 
/*  978 */       (!aaaaaa(paramy.e, paramy.a))) {
/*  979 */       d(new long[] { paramy.a });
/*  980 */       return true;
/*      */     }
/*  982 */     return false;
/*      */   }
/*      */   
/*      */   boolean aaaaaa(String paramString, long paramLong) {
/*  986 */     if (TextUtils.isEmpty(paramString)) {
/*  987 */       return false;
/*      */     }
/*  989 */     File localFile = new File(paramString);
/*  990 */     if (localFile.exists()) {
/*  991 */       return true;
/*      */     }
/*  993 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public long aaaaaa(fccc paramc)
/*      */   {
/*      */     try
/*      */     {
/* 1006 */       long l1 = b(paramc);
/* 1007 */       long l2 = 0; if (l1 == -1L) {
/* 1008 */         ContentValues localContentValues = paramc.b(this.e);
/* 1009 */         Uri localUri = this.mI.a(com.bytedance.sdk.openadsdk.ccccc.m.a.a, localContentValues);
/* 1010 */         l2 = Long.parseLong(localUri.getLastPathSegment()); }
/* 1011 */       return l2;
/*      */     }
/*      */     catch (Exception localException) {}
/*      */     
/*      */ 
/* 1016 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */   private long b(final fccc paramc)
/*      */   {
/* 1022 */     Cursor localCursor = null;
/*      */     
/*      */     try
/*      */     {
/* 1026 */       fbbb localb = new fbbb();
/* 1027 */       localb.a(new String[] { paramc.b.toString() });
/* 1028 */       localCursor = aaaaaa(localb);
/* 1029 */       if ((localCursor != null) && (localCursor.getCount() >= 1)) {
/* 1030 */         localCursor.moveToFirst();
/* 1031 */         final long l1 = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
/* 1032 */         final String str = localCursor.getString(localCursor.getColumnIndexOrThrow("etag"));
/* 1033 */         if (!TextUtils.isEmpty(str)) {
/* 1034 */           if (!ToolUtils.a(this.b)) {
/* 1035 */             aaaaaa(l1);
/* 1036 */             return l1;
/*      */           }
/* 1038 */             new Thread(){
                    @Override
                    public void run() {
                        HttpURLConnection localHttpURLConnection = null;
                        try
                        {
                            URL localURL = new URL(paramc.b.toString());
                            localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
                            localHttpURLConnection.setInstanceFollowRedirects(false);
                            localHttpURLConnection.setConnectTimeout(20000);
                            localHttpURLConnection.setReadTimeout(20000);
                            localHttpURLConnection.addRequestProperty("User-Agent", SsDownloadManager.b);
                            localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                            localHttpURLConnection.addRequestProperty("If-None-Match", str);
                            int i = localHttpURLConnection.getResponseCode();
                            if (i == 304) {
                                aaaaaa(l1);
                            } else {
                                aaaaaa(paramc.m, new long[] { l1 });
                            }
                        } catch (Exception localException) {
                            localException.printStackTrace();
                        }

                }
                }.start();
///* 1065 */           local1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
/*      */         } else {
/* 1067 */           aaaaaa(l1);
/*      */         }
/* 1069 */         return l1;
/*      */       }
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
/* 1082 */       return -1L;
/*      */     }
/*      */     catch (Exception localException2)
/*      */     {
/* 1072 */       localException2.printStackTrace();
/*      */     } finally {
/*      */       try {
/* 1075 */         if (localCursor != null) {
/* 1076 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException6) {}
/*      */     }
    /* 1082 */       return -1L;
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
/*      */   private void aaaaaa(long paramLong)
/*      */   {
/* 1094 */     Uri localUri = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, paramLong);
/* 1095 */     Cursor localCursor = this.mI.a(localUri, null, null, null, null);
/*      */     try { int i;
/* 1097 */       int j; String str; if (localCursor.moveToFirst()) {
/* 1098 */         i = localCursor.getInt(localCursor.getColumnIndexOrThrow("status"));
/* 1099 */         j = localCursor.getInt(localCursor.getColumnIndexOrThrow("visibility"));
/* 1100 */         str = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
/*      */       } else {
/* 1102 */         Log.w("DownloadManager", "Missing details for download " + paramLong);
/* 1103 */         return;
/*      */       }
/* 1105 */       if ((com.bytedance.sdk.openadsdk.ccccc.m.a.a(i)) &&
/* 1106 */         (aaaaaa(str, paramLong))) {
/* 1107 */         ContentValues localContentValues = new ContentValues();
/* 1108 */         localContentValues.put("visibility", 
/* 1109 */           Integer.valueOf(1));
/* 1110 */         localContentValues.put("status", Integer.valueOf(201));
/* 1111 */         this.mI.a(localUri, localContentValues, null, null);
/* 1112 */         int[] arrayOfInt = new int[2];
/* 1113 */         arrayOfInt[0] = 268435456;
/* 1114 */         arrayOfInt[1] = 536870912;
/* 1115 */         s.a(this.b, paramLong, arrayOfInt, "");
/*      */       }
/* 1117 */       else if (aaaaaa(i) == 4) {
/* 1118 */         c(new long[] { paramLong });
/*      */       } else {
/* 1120 */         aaaaaa(j, new long[] { paramLong });
/*      */       }
/*      */       return;
/*      */     } catch (Exception localException3) {
/* 1124 */       localException3.printStackTrace();
/*      */     } finally {
/*      */       try {
/* 1127 */         if (localCursor != null) {
/* 1128 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException5) {}
/*      */     }
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
/*      */   public int aaaaaa(long... var1)
/*      */   {
/*      */      try {
        if (var1 != null && var1.length != 0) {
            ContentValues var2 = new ContentValues();
            var2.put("deleted", 1);
            return var1.length == 1 ? this.mI.a(ContentUris.withAppendedId(this.f, var1[0]), var2, (String)null, (String[])null) : this.mI.a(this.f, var2, e(var1), f(var1));
        } else {
            throw new IllegalArgumentException("input param 'ids' can'MineHandler be null");
        }
    } catch (Exception var3) {
        return -1;
    }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void b(long... paramVarArgs)
/*      */   {
/* 1175 */     Cursor localCursor = aaaaaa(new fbbb().a(paramVarArgs));
/*      */     try {
/* 1177 */       for (localCursor.moveToFirst(); !localCursor.isAfterLast(); localCursor
/* 1178 */             .moveToNext())
/*      */       {
/* 1180 */         int i = localCursor.getInt(localCursor.getColumnIndex("status"));
/* 1181 */         if ((i != 2) && (i != 1))
/*      */         {
/*      */ 
/* 1184 */           throw new IllegalArgumentException("Can only pause SslHepler running download: " + localCursor.getLong(localCursor
/* 1185 */             .getColumnIndex("_id")));
/*      */         }
/*      */       }
/*      */       
/* 1189 */       ContentValues localContentValues = new ContentValues();
/* 1190 */       localContentValues.put("control", Integer.valueOf(1));
/* 1191 */       localContentValues.put("no_integrity", Integer.valueOf(1));
/* 1192 */       this.mI.a(this.f, localContentValues, e(paramVarArgs),
/* 1193 */         f(paramVarArgs)); return;
/*      */     }
/*      */     catch (Exception localException2) {}finally
/*      */     {
/*      */       try {
/* 1198 */         if (localCursor != null) {
/* 1199 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException4) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void c(long... paramVarArgs)
/*      */   {
/* 1215 */     Cursor localCursor = aaaaaa(new fbbb().a(paramVarArgs));
/*      */     try {
/* 1217 */       for (localCursor.moveToFirst(); !localCursor.isAfterLast(); localCursor
/* 1218 */             .moveToNext())
/*      */       {
/* 1220 */         int i = localCursor.getInt(localCursor.getColumnIndex("status"));
/* 1221 */         if (i != 4)
/*      */         {
/*      */ 
/* 1224 */           throw new IllegalArgumentException("Cann only resume SslHepler paused download: " + localCursor.getLong(localCursor
/* 1225 */             .getColumnIndex("_id")));
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */       try
/*      */       {
/* 1232 */         if (localCursor != null) {
/* 1233 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException1) {}
/*      */       
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (Exception localException2)
/*      */     {
/* 1229 */       localException2.printStackTrace();
/*      */     } finally {
/*      */       try {
/* 1232 */         if (localCursor != null) {
/* 1233 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException4) {}
/*      */     }
/*      */     
/*      */     ContentValues localContentValues=new ContentValues();
/*      */
/* 1241 */     localContentValues.put("status", Integer.valueOf(190));
/* 1242 */     localContentValues.put("control", Integer.valueOf(0));
/* 1243 */     this.mI.a(this.f, localContentValues, e(paramVarArgs),
/* 1244 */       f(paramVarArgs));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int d(long... paramVarArgs)
/*      */   {
/* 1256 */     return aaaaaa(paramVarArgs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Cursor aaaaaa(fbbb paramb)
/*      */   {
/* 1267 */     Cursor localCursor = paramb.a(this.mI, STRINGS, this.f);
/* 1268 */     if (localCursor == null) {
/* 1269 */       return null;
/*      */     }
/* 1271 */     return new adf(localCursor, this.f, this.b);
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
/*      */   public void aaaaaa(int paramInt, long... paramVarArgs)
/*      */   {
/* 1371 */     Cursor localCursor = aaaaaa(new fbbb().a(paramVarArgs));
/*      */     try {
/* 1373 */       for (localCursor.moveToFirst(); !localCursor.isAfterLast(); localCursor.moveToNext()) {
/* 1374 */         int i = localCursor.getInt(localCursor.getColumnIndex("status"));
/* 1375 */         if ((i != 8) && (i != 16))
/*      */         {
/* 1377 */           throw new IllegalArgumentException("Cannot restart incomplete download: " + localCursor.getLong(localCursor.getColumnIndex("_id")));
/*      */         }
/*      */       }
/* 1380 */       ContentValues localContentValues = new ContentValues();
/* 1381 */       localContentValues.put("current_bytes", Integer.valueOf(0));
/* 1382 */       localContentValues.put("total_bytes", Integer.valueOf(-1));
/* 1383 */       localContentValues.putNull("_data");
/* 1384 */       localContentValues.put("status", Integer.valueOf(190));
/* 1385 */       localContentValues.put("numfailed", Integer.valueOf(0));
/* 1386 */       localContentValues.put("visibility", 
/* 1387 */         Integer.valueOf(paramInt));
/* 1388 */       localContentValues.put("control", Integer.valueOf(0));
/* 1389 */       this.mI.a(this.f, localContentValues, e(paramVarArgs), f(paramVarArgs)); return;
/*      */     }
/*      */     catch (Exception localException2) {}finally
/*      */     {
/*      */       try {
/* 1394 */         if (localCursor != null) {
/* 1395 */           localCursor.close();
/*      */         }
/*      */       }
/*      */       catch (Exception localException4) {}
/*      */     }
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
/*      */   public static Long b(Context paramContext)
/*      */   {
/* 1412 */     return Long.valueOf(2147483648L);
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
/*      */   public static Long c(Context paramContext)
/*      */   {
/* 1425 */     return Long.valueOf(1073741824L);
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
/*      */   static String e(long[] paramArrayOfLong)
/*      */   {
/* 1441 */     StringBuilder localStringBuilder = new StringBuilder();
/* 1442 */     localStringBuilder.append("(");
/* 1443 */     for (int i = 0; i < paramArrayOfLong.length; i++) {
/* 1444 */       if (i > 0) {
/* 1445 */         localStringBuilder.append("OR ");
/*      */       }
/* 1447 */       localStringBuilder.append("_id");
/* 1448 */       localStringBuilder.append(" = ? ");
/*      */     }
/* 1450 */     localStringBuilder.append(")");
/* 1451 */     return localStringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static String aaaaaa(String[] paramArrayOfString)
/*      */   {
/* 1458 */     StringBuilder localStringBuilder = new StringBuilder();
/* 1459 */     localStringBuilder.append("(");
/* 1460 */     for (int i = 0; i < paramArrayOfString.length; i++) {
/* 1461 */       if (i > 0) {
/* 1462 */         localStringBuilder.append("OR ");
/*      */       }
/* 1464 */       localStringBuilder.append("uri");
/* 1465 */       localStringBuilder.append(" = ? ");
/*      */     }
/* 1467 */     localStringBuilder.append(")");
/* 1468 */     return localStringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static String[] b(String[] paramArrayOfString)
/*      */   {
/* 1475 */     String[] arrayOfString = new String[paramArrayOfString.length];
/* 1476 */     for (int i = 0; i < paramArrayOfString.length; i++) {
/* 1477 */       arrayOfString[i] = paramArrayOfString[i];
/*      */     }
/* 1479 */     return arrayOfString;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static String[] f(long[] paramArrayOfLong)
/*      */   {
/* 1486 */     String[] arrayOfString = new String[paramArrayOfLong.length];
/* 1487 */     for (int i = 0; i < paramArrayOfLong.length; i++) {
/* 1488 */       arrayOfString[i] = Long.toString(paramArrayOfLong[i]);
/*      */     }
/* 1490 */     return arrayOfString;
/*      */   }
/*      */   
/*      */ 
/*      */   private static class adf
/*      */     extends CursorWrapper
/*      */   {
/*      */     private Uri a;
/*      */     
/*      */     private Context b;
/*      */     
/*      */     public adf(Cursor paramCursor, Uri paramUri, Context paramContext)
/*      */     {
/* 1503 */       super(paramCursor);
/* 1504 */       this.a = paramUri;
/* 1505 */       this.b = paramContext.getApplicationContext();
/*      */     }
/*      */     
/*      */     public int getInt(int paramInt)
/*      */     {
/* 1510 */       return (int)getLong(paramInt);
/*      */     }
/*      */     
/*      */     public long getLong(int paramInt)
/*      */     {
/* 1515 */       if (getColumnName(paramInt).equals("reason"))
/* 1516 */         return a(super.getInt(getColumnIndex("status")));
/* 1517 */       if (getColumnName(paramInt).equals("status")) {
/* 1518 */         return a(super.getInt(getColumnIndex("status")));
/*      */       }
/* 1520 */       return super.getLong(paramInt);
/*      */     }
/*      */     
/*      */ 
/*      */     public String getString(int paramInt)
/*      */     {
/* 1526 */       return getColumnName(paramInt).equals("local_uri") ? a() : 
/* 1527 */         super.getString(paramInt);
/*      */     }
/*      */     
/*      */     private String a() {
/* 1531 */       long l1 = getLong(getColumnIndex("destination"));
/* 1532 */       if ((l1 == 1L) || (l1 == 0L))
/*      */       {
/* 1534 */         String str = getString(getColumnIndex("local_filename"));
/* 1535 */         if (str == null) {
/* 1536 */           return null;
/*      */         }
/*      */         
/*      */ 
/* 1540 */         if (Build.VERSION.SDK_INT >= 24) {
/* 1541 */           return FileProvider.getUriForFile(this.b, this.b.getApplicationContext().getPackageName() + ".fileprovider", new File(str)).toString();
/*      */         }
/* 1543 */         return Uri.fromFile(new File(str)).toString();
/*      */       }
/*      */       
/* 1546 */       long l2 = getLong(getColumnIndex("_id"));
/* 1547 */       return ContentUris.withAppendedId(this.a, l2).toString();
/*      */     }
/*      */     
/*      */     private long a(int paramInt) {
/* 1551 */       switch (aaaaaa(paramInt)) {
/*      */       case 16: 
/* 1553 */         return c(paramInt);
/*      */       
/*      */       case 4: 
/* 1556 */         return b(paramInt);
/*      */       }
/*      */       
/* 1559 */       return 0L;
/*      */     }
/*      */     
/*      */     private long b(int paramInt)
/*      */     {
/* 1564 */       switch (paramInt) {
/*      */       case 194: 
/* 1566 */         return 1L;
/*      */       
/*      */       case 195: 
/* 1569 */         return 2L;
/*      */       
/*      */       case 196: 
/* 1572 */         return 3L;
/*      */       }
/*      */       
/* 1575 */       return 4L;
/*      */     }
/*      */     
/*      */     private long c(int paramInt)
/*      */     {
/* 1580 */       if (((400 <= paramInt) && (paramInt < 488)) || ((500 <= paramInt) && (paramInt < 600)))
/*      */       {
/*      */ 
/* 1583 */         return paramInt;
/*      */       }
/*      */       
/* 1586 */       switch (paramInt) {
/*      */       case 492: 
/* 1588 */         return 1001L;
/*      */       
/*      */       case 493: 
/*      */       case 494: 
/* 1592 */         return 1002L;
/*      */       
/*      */       case 495: 
/* 1595 */         return 1004L;
/*      */       
/*      */       case 497: 
/* 1598 */         return 1005L;
/*      */       
/*      */       case 198: 
/* 1601 */         return 1006L;
/*      */       
/*      */       case 199: 
/* 1604 */         return 1007L;
/*      */       
/*      */       case 489: 
/* 1607 */         return 1008L;
/*      */       
/*      */       case 488: 
/* 1610 */         return 1009L;
/*      */       }
/*      */       
/* 1613 */       return 1000L;
/*      */     }
/*      */   }
/*      */   
/*      */   public static int aaaaaa(int paramInt)
/*      */   {
/* 1619 */     switch (paramInt) {
/*      */     case 190: 
/* 1621 */       return 1;
/*      */     
/*      */     case 192: 
/* 1624 */       return 2;
/*      */     
/*      */     case 193: 
/*      */     case 194: 
/*      */     case 195: 
/*      */     case 196: 
/* 1630 */       return 4;
/*      */     
/*      */     case 200: 
/*      */     case 201: 
/* 1634 */       return 8;
/*      */     }
/*      */     
/* 1637 */     return 16;
/*      */   }
/*      */   
/*      */   public static int aaaaaa(Context paramContext, int paramInt, long paramLong)
/*      */   {
/* 1642 */     return aaaaaa(paramContext, paramInt, paramLong, null);
/*      */   }
/*      */   
/*      */   public static int aaaaaa(Context paramContext, int paramInt, long paramLong, String paramString) {
/* 1646 */     if ((paramContext == null) || (paramLong < 0L)) {
/* 1647 */       return -1;
/*      */     }
/* 1649 */     int i = -1;
/*      */     try {
/* 1651 */       if (LogUtils.a()) {
/* 1652 */         LogUtils.b("AppAdViewHolder", "mId = " + paramLong + " mStatus = " + paramInt);
/*      */       }
/* 1654 */       switch (paramInt) {
/*      */       case 16: 
/* 1656 */         if (paramLong >= 0L) {
/* 1657 */           int j = 1;
/* 1658 */           if (!h.a().j()) {
/* 1659 */             j = 2;
/*      */           }
/* 1661 */           aaaaaa(paramContext).aaaaaa(j, new long[] { paramLong });
/* 1662 */           i = 1; }
/* 1663 */         break;
/*      */       
/*      */       case 4: 
/* 1666 */         if (paramLong >= 0L) {
/* 1667 */           aaaaaa(paramContext).c(new long[] { paramLong });
/* 1668 */           i = 2;
/*      */         }
/*      */         break;
/*      */       case 1: 
/*      */       case 2: 
/* 1673 */         if (paramLong >= 0L) {
/* 1674 */           aaaaaa(paramContext).b(new long[] { paramLong });
/* 1675 */           i = 4;
/*      */         }
/*      */         break;
/*      */       case 8: 
/* 1679 */         if (paramLong >= 0L) {
/* 1680 */           int[] arrayOfInt = new int[2];
/* 1681 */           arrayOfInt[0] = 268435456;
/* 1682 */           arrayOfInt[1] = 536870912;
/* 1683 */           s.a(paramContext, paramLong, arrayOfInt, paramString);
/* 1684 */           i = 8;
/*      */         }
/*      */         
/*      */         break;
/*      */       }
/*      */       
/*      */     }
/*      */     catch (Exception localException) {}
/*      */     
/* 1693 */     return i;
/*      */   }
/*      */   
/*      */   static void aaaaaa(com.bytedance.sdk.openadsdk.ccccc.asasa.b paramb) {
/* 1697 */     n.a(paramb);
/*      */   }
/*      */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\HandleInitEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */