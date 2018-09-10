package com.donews.sdk.view;

import android.app.Activity;
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
 * Created by YJ on 2016/11/25.
 * App切换广告
 */
public class SwitchView extends FrameLayout{
    private int i=3;
    private Thread thread=null;
    private SwitchView switchView=null;
    private TextView tv_finish;
    private Activity context;
    private WebView switchWv=null;
    private String key,secret;
    private ViewGroup viewGroup;
    public SwitchView(Activity context,String authKey,String authSecret,ViewGroup groupView){
        super(context);
        this.key=authKey;
        this.secret=authSecret;
        this.context=context;
        switchView=this;
        this.viewGroup=groupView;
        if(NetUtils.netstate(context)!=0){
            initSwitchView(context);
        }
    }
    private void initSwitchView(Activity c){
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        params.gravity= Gravity.CENTER;
        FrameLayout fl=new FrameLayout(c);
        fl.setLayoutParams(params);
        LinearLayout.LayoutParams imgParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        switchWv=new WebView(c);
        switchWv.getSettings().setJavaScriptEnabled(true);
        switchWv.setHorizontalScrollBarEnabled(false);
        switchWv.setVerticalScrollBarEnabled(false);
        switchWv.setOverScrollMode(OVER_SCROLL_NEVER);
        fl.addView(switchWv, imgParams);
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
                        handler.obtainMessage(Contants.GETSWITCHAD_FINISH).sendToTarget();
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
                    switchView.setVisibility(View.GONE);
                    viewGroup.removeView(switchView);
                }
            }
        });
        addView(fl);
    }
    public void loadAd(){
        if(switchWv!=null) {
            URLUtils.getSwitchAd(context, key, secret, handler);
        }
    }
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what){
                case Contants.GETSWITCHAD_FINISH:
                    SpannableStringBuilder style=new SpannableStringBuilder("   跳过 "+i+"   ");
                    style.setSpan(new ForegroundColorSpan(Color.BLACK), 3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    style.setSpan(new ForegroundColorSpan(Color.GRAY), 6, 7, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                    tv_finish.setText(style);
                    switchView.bringToFront();
                    invalidate();
                    if(i==0 && switchView!=null){
                        switchView.setVisibility(View.GONE);
                        viewGroup.removeView(switchView);
                    }
                    break;
                case Contants.GETSWITCHAD_SUCCESS:
                    if(viewGroup!=null && switchWv != null) {
                        String result=msg.obj.toString().replaceAll("\n","");
                        switchWv.loadData(result.replaceAll("\n",""), "text/html", "UTF-8");
                        viewGroup.addView(switchView);
                        switchView.bringToFront();
                        invalidate();
                    }
                    break;
            }
        }

    };
}
