package com.comers.sdk.inveno;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.comers.sdk.base.DownLoadHelper;
import com.comers.sdk.bean.EventTrack;
import com.comers.sdk.interfaces.AdvertiseFeed;
import com.comers.sdk.utils.HttpUtils;
import com.comers.sdk.view.NativeData;
import com.comers.sdk.view.WebViewActivity;

import java.util.List;

/**
 * Created by 79653 on 2018/6/28.
 * 描述：
 */
public final class InvenoEvent {
    boolean isSHow = false;
    private Context mContext;
    public InvenoEvent(Context context){
        mContext=context;
    }
    public void onShow(View view, NativeData nativeData) {
        view.setVisibility(View.VISIBLE);
        isSHow = true;
        if (nativeData != null) {
            List<EventTrack> list = nativeData.getEventTracks();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (TextUtils.equals(list.get(i).event_type, "1")) {//曝光
                        HttpUtils.startHttpGet(list.get(i).notify_url, null);
                    }
                }
            }
        }
    }

    public void onViewClick(final View view, final NativeData nativeData, final AdvertiseFeed.AdvertiseInteractionListener var3, final AdvertiseFeed advertiseFeed) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var3.onViewClicked(view);
                if (nativeData != null) {
                    List<EventTrack> list = nativeData.getEventTracks();
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            if (!isSHow) {
                                if (TextUtils.equals(list.get(i).event_type, "1")) {//曝光
                                    HttpUtils.startHttpGet(list.get(i).notify_url, null);
                                }
                            }
                            if (TextUtils.equals(list.get(i).event_type, "2")) {//点击事件
                                HttpUtils.startHttpGet(list.get(i).notify_url, null);
                            }
                        }
                    }
                    onClickEvent(nativeData);
                }
            }
        });
    }

    private void onClickEvent(NativeData nativeData) {
        if(nativeData!=null){
            //1：不交互 2：浏览 3：下载 4：打电话  5：短信 6：邮件  7：视频播放 8：音频播放 9：GIF
            if(TextUtils.equals(nativeData.getInteraction_type(),"1")){
                //浏览
                if(mContext==null)
                    return;
                Intent intent=new Intent(mContext,WebViewActivity.class);
                intent.putExtra("url", nativeData.getInteractionObject().url);
                mContext.startActivity(intent);

            }else if(TextUtils.equals(nativeData.getInteraction_type(),"2")){
                //下载
                download(nativeData.getInteractionObject().url);
            }

        }
    }

    private void download(String url) {
//        DownLoadManager.INSTANCE.download(mContext,url);
        DownLoadHelper.instance().download(mContext,url);
    }
}
