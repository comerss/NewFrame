package com.comers.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by code5 on 2017/3/28.
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }
}
