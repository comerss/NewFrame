package com.comers.baselibrary.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.comers.baselibrary.base.LoadingDialog;
import com.comers.baselibrary.utils.ConstantsPool;
import com.comers.baselibrary.utils.SharedHelper;
import com.comers.baselibrary.utils.UIUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Comers on 2017/10/24.
 */

public class BaseRequest<R extends BaseRequest> {
    @NonNull
    String mURI = "";
    Map<String, Object> mObjectMaps = new HashMap<>();
    Gson mGson = new Gson();
    boolean mShowDialog = true;
    boolean mShowFirstTime = false;
    Object mObject = null;
    LoadingDialog mLoadingDialog;

    public BaseRequest(@NonNull String url) {
        mURI = HttpConfig.baseUrl + url;
        if (HttpHelper.mContext != null && mLoadingDialog == null)
            mLoadingDialog = new LoadingDialog(HttpHelper.mContext);
        mObjectMaps.clear();
        mObjectMaps.put("token", SharedHelper.get(ConstantsPool.TOKEN, ""));
        mObjectMaps.put("app", "android");
        mObjectMaps.put("version", UIUtils.getVersionCode());
    }

    public R baseUrl(@NonNull String baseUrl) {
        if (mURI.contains(HttpConfig.baseUrl))
            mURI = mURI.replace(HttpConfig.baseUrl, "");
        mURI += baseUrl;
        return (R) this;
    }

    public R params(Map<String, Object> params) {
        if (params == null || params.isEmpty())
            return (R) this;
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (param.getKey() != null) {
                if (param.getValue() != null) {
                    mObjectMaps.put(param.getKey(), param.getValue());
                } else {
                    mObjectMaps.put(param.getKey(), "");
                }
            }
        }
        return (R) this;
    }

    public R showLoading(boolean showDialog) {
        mShowDialog = showDialog;
        return (R) this;
    }

    public R showFirstTime() {
        mShowFirstTime = true;
        return (R) this;
    }

    public R path(String url) {
        mURI = url;
        return (R) this;
    }


    public R tag(Object tag) {
        mObject = tag;
        return (R) this;
    }

    public <T> void perform(final Request request, final BaseCallBack<T> callBack) {
        show();
        ClientConfig.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                Platform.execute(new Runnable() {
                    @Override
                    public void run() {
                        dismiss();
                        doError(callBack, e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!call.isCanceled()) {
                    final String json = response.body().string();
                    Platform.execute(new Runnable() {
                        @Override
                        public void run() {
                            doResult(json, callBack);
                        }
                    });
                }
            }

        });
    }

    public <T> void performSync(final Request request, final BaseCallBack<T> callBack) {
        show();
        Response response = null;
        try {
            response = ClientConfig.getClient().newCall(request).execute();
        } catch (Exception e) {
            dismiss();
            e.printStackTrace();
            doError(callBack, e);
        }
        String json = "";
        if (response != null && response.isSuccessful()) {
            try {
                json = response.body().string();
            } catch (Exception e) {
                callBack.onError(response.code(),e.getMessage());
                dismiss();
                e.printStackTrace();
            }
            doResult(json, callBack);
        } else {
            callBack.onError(1001, "请求失败，请稍后重试！");
        }
        dismiss();
    }

    private <T> void doResult(String json, BaseCallBack<T> callBack) {
        HttpResult<T> result = null;
        try {
            result = (HttpResult<T>) mGson.fromJson(json, callBack.getType());
        } catch (Exception e) {
            callBack.onError(1001, "数据解析异常！");
            e.printStackTrace();
        }
        if (result != null) {
            //错误提示的统一处理！个别需要根据错误类型进行一些其他的操作，所以这里给了返回
            if (result.code != 0) {
                callBack.onSuccess(result, json);
            } else {
                callBack.onSuccess(result, json);
            }
        } else {
            callBack.onError(1001, "请求失败，请稍后重试！");
        }
        dismiss();
    }

    private void show() {
        if (mLoadingDialog != null) {
            try {
                if (mShowDialog)
                    mLoadingDialog.show();
            } catch (Exception e) {

            }
        }
    }

    private void dismiss() {
        //防止loading框导致的window leak
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            try {
                mLoadingDialog.dismiss();
            } catch (Exception e1) {

            }
        }
    }

    //网络请求失败的情况处理
    private <T> void doError(BaseCallBack<T> callBack, Exception e) {
        dismiss();
        if (e instanceof SocketTimeoutException) {
            callBack.onError(1001, "网络连接超时,请检查网络！");
        } else if (e instanceof SocketException) {
            if (e instanceof ConnectException) {
                callBack.onError(1001, "网络未连接，请检查网络！");
            } else {
                callBack.onError(1001, "网络错误，请检查网络！");
            }
        } else {
            callBack.onError(1001, "服务器无响应，请稍后重试！");
        }
    }

    private static Toast mToast;

    public static void showToast(String content) {
        if (mToast == null) {
            mToast = Toast.makeText(UIUtils.getContext(), content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }
        if (!TextUtils.isEmpty(content)) {
            mToast.show();
        } else {
            mToast.cancel();
        }
    }
}
