package com.donews.frame.sdk

import android.content.Context
import com.baidu.mobad.feeds.NativeResponse
import com.bumptech.glide.Glide
import com.comers.baselibrary.baseAdapter.BaseQuickAdapter
import com.comers.baselibrary.baseAdapter.BaseViewHolder
import com.donews.frame.R

/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class FeedAdapter(context: Context,list:List<NativeResponse>) : BaseQuickAdapter<NativeResponse, BaseViewHolder>(context, R.layout.adapter_feed,list) {

    override fun convert(helper: BaseViewHolder, item: NativeResponse?) {
        Glide.with(mContext)
                .load(item?.iconUrl)
                .into(helper.getView(R.id.native_icon_image))
        Glide.with(mContext)
                .load(item?.imageUrl)
                .into(helper.getView(R.id.native_main_image))
        helper.setText(R.id.native_text, item?.desc)
        helper.setText(R.id.native_title, item?.title)
        helper.setText(R.id.native_brand_name, item?.brandName)
        Glide.with(mContext)
                .load(item?.adLogoUrl)
                .into(helper.getView(R.id.native_adlogo))
        Glide.with(mContext)
                .load(item?.baiduLogoUrl)
                .into(helper.getView(R.id.native_baidulogo))
        val text = if (item!!.isDownloadApp) "下载" else "查看"
        helper.setText(R.id.native_cta,text)
        item.recordImpression(helper.itemView)
    }
}