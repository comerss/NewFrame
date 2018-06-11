package com.liangyibang.baselibrary.http;

import com.liangyibang.baselibrary.utils.ToastUtils;

/**
 * Created by Comers on 2017/10/25.
 */

public abstract class ICallBack<T> extends BaseCallBack<T> {
    @Override
    public void onError(String msg) {
        ToastUtils.showToast(msg);
    }
}
