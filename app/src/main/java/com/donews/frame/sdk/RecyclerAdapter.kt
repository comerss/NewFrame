package com.donews.frame.sdk

import android.content.Context
import com.comers.baselibrary.baseAdapter.BaseQuickAdapter
import com.comers.baselibrary.baseAdapter.BaseViewHolder
import com.donews.frame.R

/**
 * Created by 79653 on 2018/7/31.
 * 描述：
 */
class RecyclerAdapter(context: Context) : BaseQuickAdapter<ListData, BaseViewHolder>(context, R.layout.adapter_feed) {
    override fun convert(helper: BaseViewHolder, item: ListData) {
        helper.setText(R.id.native_title,"----${helper.adapterPosition}---${item.position}---")
    }
}