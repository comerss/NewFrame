package com.donews.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.donews.sdk.utils.Contants;
import com.donews.sdk.utils.PhoneInfoUtils;
import com.donews.sdk.utils.URLUtils;


/**
 * Created by YJ on 2016/4/21.
 */
public class BannerView extends FrameLayout {
    private BannerView banner=null;
    private WebView webView=null;
    private Activity context;
    private String key,secret;
    private ViewGroup viewGroup;
    public BannerView(Activity activity,String authKey,String authSecret,ViewGroup group){
        super(activity);
        context=activity;
        banner=this;
        key=authKey;
        secret=authSecret;
        viewGroup=group;
        initView(activity);
    }
    private void initView(Context c){
        int screenWidth= PhoneInfoUtils.getScreenWidth(context);
        int bannerHeight=100;
        if(screenWidth<800){
            bannerHeight=100;
        }else{
            bannerHeight=166;
        }
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,bannerHeight);
        params.gravity= Gravity.CENTER;
        FrameLayout fl=new FrameLayout(c);
        fl.setLayoutParams(params);
        LinearLayout.LayoutParams imgParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT);
        webView=new WebView(c);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setOverScrollMode(OVER_SCROLL_NEVER);
        fl.addView(webView, imgParams);
        LinearLayout.LayoutParams tvParams=new LinearLayout.LayoutParams(PhoneInfoUtils.getScreenWidth(c)-5, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvParams.gravity=Gravity.RIGHT;
        LinearLayout layout = new LinearLayout(c);
        layout.setGravity(Gravity.RIGHT);
        TextView tv_close=new TextView(c);
        CircleView bg= new CircleView();
        tv_close.setBackgroundDrawable(bg);
        tv_close.setGravity(Gravity.CENTER);
        tv_close.setTextSize(13.0f);
        tv_close.setText("  ×  ");
        tv_close.setTextColor(Color.WHITE);
        layout.addView(tv_close);
        fl.addView(layout, tvParams);
        tv_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                banner.setVisibility(View.GONE);
                viewGroup.removeView(banner);
            }
        });
        addView(fl);
    }
    public void loadAD(){
        if(refreshTime==0||!isStartRefresh()){
            handler.obtainMessage(Contants.BANNER_REFRESHAD).sendToTarget();
        }else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isStartRefresh()) {
                        try {
                            handler.obtainMessage(Contants.BANNER_REFRESHAD).sendToTarget();
                            Thread.sleep(refreshTime * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            ).start();
        }
    }
    private int refreshTime;
    private boolean startRefresh;

    public boolean isStartRefresh() {
        return startRefresh;
    }

    public void setStartRefresh(boolean startRefresh) {
        this.startRefresh = startRefresh;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what){
                case Contants.GETAD_SUCCESS:
                    if(viewGroup!=null && webView!=null) {
                        webView.loadData((String) msg.obj, "text/html", "UTF-8");
                        viewGroup.removeView(banner);
                        viewGroup.addView(banner);
                    }
                    break;
                case Contants.BANNER_REFRESHAD:
//                    Log.e("refresh","LLL"+PhoneInfoUtils.isViewCovered(context,viewGroup));
                    if(webView!=null) {
                        URLUtils.getAD(context, key, secret, handler);
                    }
                break;
            }
        }

    };
}

