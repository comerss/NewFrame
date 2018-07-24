/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.f;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.graphics.drawable.Drawable;
/*    */ import android.support.annotation.NonNull;
/*    */ import android.support.annotation.Nullable;
/*    */ import android.text.SpannableStringBuilder;
/*    */ import android.view.View;
/*    */ import android.view.View.OnClickListener;
/*    */ import android.view.View.OnTouchListener;
/*    */ import android.widget.FrameLayout;
/*    */ import android.widget.FrameLayout.LayoutParams;
/*    */ import android.widget.TextView;
/*    */ import com.bytedance.sdk.openadsdk.R.id;
/*    */ import com.bytedance.sdk.openadsdk.R.layout;
/*    */ import com.bytedance.sdk.openadsdk.g.o;
/*    */ import pl.droidsonroids.gif.GifImageView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */   extends FrameLayout
/*    */ {
/*    */   private Context a;
/*    */   private GifImageView b;
/*    */   private TextView c;
/*    */   
/*    */   public c(@NonNull Context paramContext)
/*    */   {
/* 33 */     super(paramContext);
/* 34 */     this.a = paramContext;
/* 35 */     a();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void a()
/*    */   {
/* 51 */     setLayoutParams(new LayoutParams(-1, -1));
/* 52 */     View localView = inflate(this.a, R.layout.tt_splash_view, this);
/* 53 */     this.b = ((GifImageView)localView.findViewById(R.id.splash_ad_gif));
/* 54 */     this.c = ((TextView)localView.findViewById(R.id.splash_skip_tv));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void setSkipText(SpannableStringBuilder paramSpannableStringBuilder)
/*    */   {
/* 63 */     this.c.setText(paramSpannableStringBuilder);
/*    */   }
/*    */   
/*    */   void setSkipIconVisibility(int paramInt) {
/* 67 */     if ((paramInt == 8) || (paramInt == 4) || (paramInt == 0)) {
/* 68 */       this.c.setVisibility(paramInt);
/*    */     }
/*    */   }
/*    */   
/*    */   void setDrawable(Drawable paramDrawable) {
/* 73 */     this.b.setImageDrawable(paramDrawable);
/*    */   }
/*    */   
/*    */   View getDislikeView() {
/* 77 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void setOnClickListener(@Nullable OnClickListener paramOnClickListener) {
/* 81 */     o.a("不允许在Splash广告中注册OnClickListener");
/*    */   }
/*    */   
/*    */   public final void setOnTouchListener(OnTouchListener paramOnTouchListener)
/*    */   {
/* 86 */     o.a("不允许在Splash广告中注册OnTouchListener");
/*    */   }
/*    */   
/*    */   final void setOnTouchListenerInternal(OnTouchListener paramOnTouchListener) {
/* 90 */     super.setOnTouchListener(paramOnTouchListener);
/*    */   }
/*    */   
/*    */   final void setOnClickListenerInternal(@Nullable OnClickListener paramOnClickListener)
/*    */   {
/* 95 */     super.setOnClickListener(paramOnClickListener);
/*    */   }
/*    */   
/*    */   final void setSkipListener(OnClickListener paramOnClickListener) {
/* 99 */     this.c.setOnClickListener(paramOnClickListener);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\f\c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */