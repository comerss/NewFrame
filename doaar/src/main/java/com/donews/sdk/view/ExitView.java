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
 * Created by YJ on 2016/11/24.
 */
public class ExitView extends FrameLayout{
    private int i=5;
    private Thread thread=null;
    private ExitView exitView=null;
    private TextView tv_finish;
    private Activity con;
    private WebView exitWv=null;
    private String key,secret;
    private ViewGroup viewGroup;
    public ExitView(Activity context,String authKey,String authSecret,ViewGroup groupView) {
        super(context);
        this.con=context;
        exitView=this;
        this.key=authKey;
        this.secret=authSecret;
        this.viewGroup=groupView;
        if(NetUtils.netstate(context)!=0) {
            initExitView(context);
        }
    }
    private void initExitView(Context c){
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        params.gravity= Gravity.CENTER;
        FrameLayout fl=new FrameLayout(c);
        fl.setLayoutParams(params);
        LinearLayout.LayoutParams imgParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        exitWv=new WebView(c);
        exitWv.getSettings().setJavaScriptEnabled(true);
        exitWv.setHorizontalScrollBarEnabled(false);
        exitWv.setVerticalScrollBarEnabled(false);
        exitWv.setOverScrollMode(OVER_SCROLL_NEVER);
        fl.addView(exitWv, imgParams);
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
                        handler.obtainMessage(Contants.GETEXITAD_FINISH).sendToTarget();
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
                    exitView.setVisibility(View.GONE);
                    viewGroup.removeView(exitView);
                }
            }
        });
        addView(fl);
    }
    public void loadAd(){
        if(exitWv!=null) {
            URLUtils.getExitAd(con, key, secret, handler);
        }
    }
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what){
                case Contants.GETEXITAD_FINISH:
                    SpannableStringBuilder style=new SpannableStringBuilder("   跳过 "+i+"   ");
                    style.setSpan(new ForegroundColorSpan(Color.BLACK), 3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    style.setSpan(new ForegroundColorSpan(Color.GRAY), 6, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    tv_finish.setText(style);
                    exitView.bringToFront();
                    invalidate();
                    if(i==0){
                        exitView.setVisibility(View.GONE);
                        viewGroup.removeView(exitView);
                    }
                    break;
                case Contants.GETEXITAD_SUCCESS:
                    if(viewGroup!=null && exitWv != null) {
                        exitWv.loadData(msg.obj.toString().replaceAll("\n",""), "text/html", "UTF-8");
                        viewGroup.addView(exitView);
                        exitView.bringToFront();
                        invalidate();
                    }
                    break;
            }
        }

    };
}