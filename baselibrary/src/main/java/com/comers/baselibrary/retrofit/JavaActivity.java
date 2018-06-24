package com.comers.baselibrary.retrofit;

import com.comers.baselibrary.base.BaseActivity;
import com.comers.baselibrary.http.HttpResult;
import com.comers.market.base.Data;

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
public class JavaActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {
        RetrofitHelper.INSTANCE.create().getData()
                .compose(RxHelper.INSTANCE.<HttpResult<Data>>schedulersTransformer())
                .subscribe(new HttpSubscriber<HttpResult<Data>>(){

                    @Override
                    public void onSuccess(HttpResult<Data> dataHttpResult) {

                    }
                });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
