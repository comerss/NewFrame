package com.donews.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.donews.sdk.utils.Contants;
import com.donews.sdk.utils.NetUtils;
import com.donews.sdk.utils.PhoneInfoUtils;
import com.donews.sdk.utils.URLUtils;


/**
 * Created by YJ on 2015/11/6.
 * 开屏广告
 */
public class SplashView extends FrameLayout{
    private int i=6;
    private Thread thread=null;
    private SplashView splashView=null;
    private TextView tv_finish;
    private Activity con;
    private WebView splash=null;
    private String key,secret;
    private ViewGroup viewGroup;
//    private String oldUrl="";

    public SplashView(Activity context,String authKey,String authSecret,ViewGroup groupView){
        super(context);
        this.con=context;
        splashView=this;
        this.key=authKey;
        this.secret=authSecret;
        this.viewGroup=groupView;
        if(NetUtils.netstate(context)!=0) {
            initView(context);
        }
    }
    public SplashView(Activity context,ViewGroup group){
        super(context);
        this.con=context;
        splashView=this;
        this.key= Contants.getDonewsKey(context);
        this.secret=Contants.getDonewsSecret(context);
        this.viewGroup=group;
        if(NetUtils.netstate(context)!=0) {
            initView(context);
        }
    }
    private void initView(Context c){
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        params.gravity= Gravity.CENTER;
        final FrameLayout fl=new FrameLayout(c);
        fl.setLayoutParams(params);
        LinearLayout.LayoutParams imgParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        splash=new WebView(c);
        splash.getSettings().setJavaScriptEnabled(true);
        splash.setHorizontalScrollBarEnabled(false);
        splash.setVerticalScrollBarEnabled(false);
        splash.setOverScrollMode(OVER_SCROLL_NEVER);
        splash.getSettings().setLoadsImagesAutomatically(true);
        fl.addView(splash, imgParams);
        LinearLayout.LayoutParams tvParams=new LinearLayout.LayoutParams(PhoneInfoUtils.getScreenWidth(c)-20,60);
        tvParams.gravity=Gravity.RIGHT|Gravity.BOTTOM;
        tvParams.topMargin=60;
        tvParams.bottomMargin=60;
        LinearLayout layout = new LinearLayout(c);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.RIGHT|Gravity.BOTTOM);
        tv_finish=new TextView(c);
        RoundRectDradable bg= new RoundRectDradable();
        tv_finish.setBackgroundDrawable(bg);
        tv_finish.setGravity(Gravity.CENTER);
        tv_finish.setTextSize(13.0f);
        layout.addView(tv_finish);
        fl.addView(layout, tvParams);
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (i>0) {
                    try {
                        handler.obtainMessage(Contants.SPLASH_FINISH).sendToTarget();
                        i--;
                        Thread.sleep( 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        );
        thread.start();
        tv_finish.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thread != null) {
                    thread.interrupt();
                    thread = null;
                    splashView.setVisibility(View.GONE);
                    viewGroup.removeView(splashView);
                }
            }
        });
        addView(fl);
    }
    public void loadAd(){
        if(splash!=null) {
//            URLUtils.getAD(con, key, secret, false, true, handler);
            URLUtils.getSplashAd(con,key,secret,handler);
        }
    }
    public void loadNiuerSplashAd(String userid){
        if(splash!=null){
//            URLUtils.getNiuerSplashAd(con,userid,key,secret,handler);
        }
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what){
                case Contants.SPLASH_FINISH:
                    SpannableStringBuilder style=new SpannableStringBuilder("   跳过 "+i+"   ");
                    style.setSpan(new ForegroundColorSpan(Color.BLACK), 3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    style.setSpan(new ForegroundColorSpan(Color.GRAY), 6, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    tv_finish.setText(style);
                    splashView.bringToFront();
                    invalidate();
                    if(i==0){
                        splashView.setVisibility(View.GONE);
                        viewGroup.removeView(splashView);
                    }
                    break;
                case Contants.GETSPLASHAD_SUCCESS:
                    if(viewGroup!=null && splash != null) {
                        String result=msg.obj.toString().replaceAll("\n","");
                        splash.loadData(result, "text/html", "UTF-8");
                        viewGroup.addView(splashView);
                        splashView.bringToFront();
                        invalidate();
                    }
                    break;
            }
        }

    };
}
