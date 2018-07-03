package com.comers.market.kotlin

import android.content.Context
import android.text.TextUtils
import android.widget.Toast

/**
 * Created by Comers on 2017/11/3.
 * 拓展函数，其本质是用静态导入的方式使用函数！
 */
inline fun Context.showToast(showText: String, length: Int = Toast.LENGTH_SHORT) {
    var mToast: Toast? = null
    if (mToast == null) {
        mToast = Toast.makeText(this, showText, Toast.LENGTH_SHORT)
    } else {
        mToast!!.setText(showText)
    }
    if (!TextUtils.isEmpty(showText)) {
        mToast!!.show()
    } else {
        mToast!!.cancel()
    }
}
