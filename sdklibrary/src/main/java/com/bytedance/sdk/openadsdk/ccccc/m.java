/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.provider.BaseColumns;
/*     */ 
/*     */
/*     */ public final class m
/*     */ {
/*     */   public static final class a
/*     */     implements BaseColumns
/*     */   {
/*  51 */     public static final Uri a = Uri.parse("content://com.ss.android.newmedia.downloads/all_downloads");
/*     */     

/*     */     public static boolean isSuccess(int paramInt)
/*     */     {
/* 394 */       return (paramInt >= 200) && (paramInt < 300);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public static boolean b(int paramInt)
/*     */     {
/* 401 */       return (paramInt >= 400) && (paramInt < 600);
/*     */     }
/*     */     
/*     */ 

/*     */ 
/*     */     public static boolean isDone(int paramInt)
/*     */     {
/* 434 */       return ((paramInt >= 200) && (paramInt < 300)) || ((paramInt >= 400) && (paramInt < 600));
/*     */     }
/*     */     
/*     */ 

/*     */ 
/*     */ 
/*     */ 
/*     */     public static String getMsg(int paramInt)
/*     */     {
/* 605 */       switch (paramInt) {
/* 606 */       case 190:  return "PENDING";
/* 607 */       case 192:  return "RUNNING";
/* 608 */       case 193:  return "PAUSED_BY_APP";
/* 609 */       case 194:  return "WAITING_TO_RETRY";
/* 610 */       case 195:  return "WAITING_FOR_NETWORK";
/* 611 */       case 196:  return "QUEUED_FOR_WIFI";
/* 612 */       case 198:  return "INSUFFICIENT_SPACE_ERROR";
/* 613 */       case 199:  return "DEVICE_NOT_FOUND_ERROR";
/* 614 */       case 200:  return "SUCCESS";
/* 615 */       case 400:  return "BAD_REQUEST";
/* 616 */       case 406:  return "NOT_ACCEPTABLE";
/* 617 */       case 411:  return "LENGTH_REQUIRED";
/* 618 */       case 412:  return "PRECONDITION_FAILED";
/* 619 */       case 488:  return "FILE_ALREADY_EXISTS_ERROR";
/* 620 */       case 489:  return "CANNOT_RESUME";
/* 621 */       case 490:  return "CANCELED";
/* 622 */       case 491:  return "UNKNOWN_ERROR";
/* 623 */       case 492:  return "FILE_ERROR";
/* 624 */       case 493:  return "UNHANDLED_REDIRECT";
/* 625 */       case 494:  return "UNHANDLED_HTTP_CODE";
/* 626 */       case 495:  return "HTTP_DATA_ERROR";
/* 627 */       case 496:  return "HTTP_EXCEPTION";
/* 628 */       case 497:  return "TOO_MANY_REDIRECTS";
/* 629 */       case 498:  return "BLOCKED"; }
/* 630 */       return Integer.toString(paramInt);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ccccc\LogUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */