package com.comers.sdk.interfaces;

import android.view.View;
import android.view.ViewGroup;

import com.comers.sdk.bean.ImageInfo;

import java.util.List;

/**
 * Created by 79653 on 2018/6/20.
 * 描述：
 */
public interface AdvertiseFeed {

    String getTitle();

    String getDescription();

    String getSource();

    ImageInfo getIcon();

    List<ImageInfo> getImageList();

    //  * @return 2:在浏览器打开网页，3:在app中打开，4:下载应用，5:拨打电话 其它：未知类型
    int getInteractionType();
    /**getImageMode()
     * 得到Feed广告图片类型
     * @return 3 大图 2小图 4组图 5视频 其它：未知类型
     */
    int getImageMode();

    void registerViewForInteraction(ViewGroup convertView, View clickView, AdvertiseInteractionListener listener);
    //   * 注册可点击的View，click/show会在内部完成
    void registerViewForInteraction(ViewGroup convertView, List<View> clickView, AdvertiseInteractionListener listener);

    void  onShowAdvertise(View view);
    interface AdvertiseInteractionListener {
        void onViewClicked(View view);
        void onShow(View view);
    }
}
