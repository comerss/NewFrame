package com.comers.sdk.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.comers.sdk.R;
import com.comers.sdk.base.DownLoadHelper;
import com.comers.sdk.bean.EventTrack;
import com.comers.sdk.interfaces.AdvertiseSplash;
import com.comers.sdk.interfaces.DownLoadListener;
import com.comers.sdk.utils.HttpUtils;
import com.comers.sdk.utils.ImageLoader;

import java.util.List;

/**
 * Created by 79653 on 2018/6/20.
 * 描述：开屏广告的View
 */
public class SplashLayout extends FrameLayout {
    private Context mContext;
    private ImageView ImgContent;
    private TextView txTime;
    private NativeData eventUrl;
    private long visibleTime;
    private long goneTime;
    private AdvertiseSplash.AdvertiseInterationListener mListener;

    public SplashLayout(Context context) {
        super(context, null);
    }

    public SplashLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SplashLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initListener();
    }

    private void initListener() {
        ImgContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                doEvent(eventUrl);
                //TODO 点击时间的上报
                if (mListener != null){
                    mListener.onAdvertiseClicked(ImgContent, 1);
                }
            }
        });
        txTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 需要上报事件
                if (mListener != null)
                    mListener.onAdvertiseSkip();
            }
        });
    }

    private void doEvent(NativeData event) {
        if (event == null || event.getEventTracks() == null)
            return;
//        SHOW = 1,  //曝光监测CLICK = 2;  //点击监测
        List<EventTrack> eventTracks = event.getEventTracks();
        if (eventTracks != null && eventTracks.size() > 0) {
            for (int i = 0; i < eventTracks.size(); i++) {
                if (eventTracks.get(i).getEvent_type().equals("2")) {//
                    String notifyurl = eventTracks.get(i).getNotify_url();
                    HttpUtils.startHttpGet(notifyurl, null);
                    break;
                }
            }
        }
        String opUrl = event.getInteractionObject().getUrl();
        String opType = event.getInteraction_type();
        if (!TextUtils.isEmpty(opType)) {
            switch (opType) {
                case "1"://不交互
                    break;
                case "2"://浏览
                    Intent intent=new Intent(mContext,WebViewActivity.class);
                    intent.putExtra("data",event);
                    intent.putExtra("url",opUrl);
                    mContext.startActivity(intent);
                    break;
                case "3"://下载
                    DownLoadHelper.instance().download(mContext, opUrl);
//                    DownLoadService.setDownloadListener(mLoadListener);
                    break;
                case "4"://电话
                    break;
                case "5"://短信
                    break;
                case "6"://邮件
                    break;
                case "7"://视频播放
                    break;
                case "8"://音频播放
                    break;
                case "9"://gif图
                    break;
            }
        }
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.layout_splash, null);
        addView(view);
        ImgContent = view.findViewById(R.id.imgContent);
        txTime = view.findViewById(R.id.txTime);
    }

    public void setData(String info, NativeData eventUrl) {
        this.eventUrl = eventUrl;
        if (info != null) {
            Bitmap bitmap = ImageLoader.loadImage(info);
            if (bitmap != null){
                ImgContent.setImageBitmap(bitmap);
            }
        }
    }

    //交给用户处理全屏广告还是半屏广高
    public DownLoadListener mLoadListener;

    public void setLayoutParam(LayoutParams param) {
        ImgContent.setLayoutParams(param);
    }

    public void setOnInteractionListener(AdvertiseSplash.AdvertiseInterationListener listener) {
        mListener = listener;
    }
}
