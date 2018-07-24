/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.b;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.Dialog;
/*     */ import android.content.Context;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.ViewGroup;
/*     */ import android.view.Window;
/*     */ import android.view.WindowManager.LayoutParams;
/*     */ import android.widget.AdapterView;
/*     */ import android.widget.AdapterView.OnItemClickListener;
/*     */ import android.widget.BaseAdapter;
/*     */ import android.widget.LinearLayout.LayoutParams;
/*     */ import android.widget.ListView;
/*     */ import android.widget.TextView;
/*     */ import com.bytedance.sdk.openadsdk.R.drawable;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.R.style;
/*     */ import com.bytedance.sdk.openadsdk.TTAdDislike;
/*     */ import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
/*     */ import com.bytedance.sdk.openadsdk.core.d.f;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.d.c;
/*     */ import com.bytedance.sdk.openadsdk.g.k;
/*     */ import com.bytedance.sdk.openadsdk.g.o;
/*     */ import com.bytedance.sdk.openadsdk.g.s;
/*     */ import java.util.List;
/*     */ 
/*     */ public class b implements TTAdDislike
/*     */ {
/*     */   private Context a;
/*     */   private h b;
/*     */   private Dialog c;
/*     */   private a d;
/*     */   private TTAdDislike.DislikeInteractionCallback e;
/*     */   
/*     */   public b(Context paramContext, h paramh)
/*     */   {
/*  43 */     o.a(paramContext, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
/*  44 */     this.a = paramContext;
/*  45 */     this.b = paramh;
/*  46 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/*  50 */     this.c = new Dialog(this.a, R.style.dislikeDialog);
/*  51 */     LayoutInflater localLayoutInflater = this.c.getLayoutInflater();
/*  52 */     View localView = localLayoutInflater.inflate(R.layout.tt_dislike_dialog_layout, null);
/*  53 */     localView.findViewById(R.id.dislike_unlike_tv).setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/*  56 */         b.a(b.this).dismiss();
/*  57 */         c.c(b.b(b.this));
/*  58 */         if (b.c(b.this) != null) {
/*  59 */           b.c(b.this).onSelected(0, b.d(b.this).getString(R.string.tt_unlike));
/*     */         }
/*     */       }
/*  62 */     });
/*  63 */     localView.findViewById(R.id.dislike_cancle_tv).setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/*  66 */         b.a(b.this).dismiss();
/*  67 */         if (b.c(b.this) != null) {
/*  68 */           b.c(b.this).onCancel();
/*     */         }
/*     */         
/*     */       }
/*  72 */     });
/*  73 */     ListView localListView = (ListView)localView.findViewById(R.id.filer_words_lv);
/*  74 */     localListView.setOnItemClickListener(new OnItemClickListener()
/*     */     {
/*     */       public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
/*  77 */         b.a(b.this).dismiss();
/*     */         
/*     */ 
/*  80 */         ((f)b.b(b.this).q().get(paramAnonymousInt)).a(true);
/*  81 */         c.c(b.b(b.this));
/*  82 */         if (b.c(b.this) != null)
/*     */         {
/*  84 */           b.c(b.this).onSelected(paramAnonymousInt + 1, ((f)b.b(b.this).q().get(paramAnonymousInt)).b());
/*     */         }
/*     */       }
/*  87 */     });
/*  88 */     this.d = new a(this.c.getLayoutInflater(), this.b.q());
/*  89 */     localListView.setAdapter(this.d);
/*     */     
/*     */ 
/*  92 */     int i = s.a(this.a) - 120;
/*  93 */     this.c.setContentView(localView, new LinearLayout.LayoutParams(i, -2));
/*  94 */     Window localWindow = this.c.getWindow();
/*  95 */     localWindow.setGravity(80);
/*  96 */     WindowManager.LayoutParams localLayoutParams = this.c.getWindow().getAttributes();
/*  97 */     localLayoutParams.y = 50;
/*  98 */     localWindow.setAttributes(localLayoutParams);
/*     */   }
/*     */   
/*     */   public void showDislikeDialog()
/*     */   {
/* 103 */     int i = ((this.a instanceof Activity)) && (!((Activity)this.a).isFinishing()) ? 1 : 0;
/* 104 */     if (i != 0) {
/* 105 */       this.c.show();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(h paramh) {
/* 110 */     if ((this.d == null) || (paramh == null)) {
/* 111 */       return;
/*     */     }
/*     */     
/* 114 */     this.b = paramh;
/* 115 */     this.d.a();
/* 116 */     List localList = this.b.q();
/* 117 */     if (!k.a(localList)) {
/* 118 */       for (int i = 0; i < localList.size(); i++) {
/* 119 */         this.d.a((f)localList.get(i));
/*     */       }
/*     */     }
/* 122 */     this.d.notifyDataSetChanged();
/*     */   }
/*     */   
/*     */   public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback)
/*     */   {
/* 127 */     this.e = paramDislikeInteractionCallback;
/*     */   }
/*     */   
/*     */   private static class a extends BaseAdapter
/*     */   {
/*     */     private List<f> a;
/*     */     private LayoutInflater b;
/*     */     
/*     */     a(LayoutInflater paramLayoutInflater, List<f> paramList) {
/* 136 */       this.a = paramList;
/* 137 */       this.b = paramLayoutInflater;
/*     */     }
/*     */     
/*     */     public int getCount()
/*     */     {
/* 142 */       return this.a.size();
/*     */     }
/*     */     
/*     */     public Object getItem(int paramInt)
/*     */     {
/* 147 */       return this.a.get(paramInt);
/*     */     }
/*     */     
/*     */     public long getItemId(int paramInt)
/*     */     {
/* 152 */       return paramInt;
/*     */     }
/*     */     
/*     */     public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
/*     */     {
/*     */       a locala;
/* 158 */       if (paramView == null) {
/* 159 */         locala = new a(null);
/* 160 */         paramView = this.b.inflate(R.layout.tt_dialog_listview_item, paramViewGroup, false);
/* 161 */         locala.a = ((TextView)paramView.findViewById(R.id.item_tv));
/* 162 */         paramView.setTag(locala);
/*     */       } else {
/* 164 */         locala = (a)paramView.getTag();
/*     */       }
/* 166 */       locala.a.setText(((f)this.a.get(paramInt)).b());
/* 167 */       if (paramInt != this.a.size() - 1) {
/* 168 */         locala.a.setBackgroundResource(R.drawable.tt_dislike_middle_seletor);
/*     */       } else {
/* 170 */         locala.a.setBackgroundResource(R.drawable.tt_dislike_bottom_seletor);
/*     */       }
/* 172 */       return paramView;
/*     */     }
/*     */     
/*     */     public void a(f paramf) {
/* 176 */       this.a.add(paramf);
/*     */     }
/*     */     
/*     */     public void a() {
/* 180 */       this.a.clear();
/*     */     }
/*     */     
/*     */     private static class a
/*     */     {
/*     */       TextView a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\b\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */