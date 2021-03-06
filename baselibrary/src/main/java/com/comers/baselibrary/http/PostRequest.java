package com.comers.baselibrary.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.comers.baselibrary.utils.ConstantsPool;
import com.comers.baselibrary.utils.SharedHelper;
import com.comers.baselibrary.utils.UIUtils;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Comers on 2017/10/24.
 */

public class PostRequest extends BaseRequest<PostRequest> {
    String content;

    public PostRequest(@NonNull String url) {
        super(url);
    }

    public PostRequest(@NonNull String url, @NonNull String content) {
        super(url);
        this.content = content;
    }

    public PostRequest add(String key, Object value) {
        if (TextUtils.isEmpty(key)) {
            return this;
        }
        if (value == null) {
            mObjectMaps.put(key, "");
        } else {
            mObjectMaps.put(key, value);
        }
        return this;
    }

    public <T> void execute(BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入URL
            return;
        }
        String json;
        if (!mObjectMaps.isEmpty()) {
            json = JsonParseHelper.obj2Json(mObjectMaps);
        } else {
            json = content;
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        final Request request = new Request.Builder()
                .url(mURI)
                .post(body)
                .build();
        perform(request, callBack);
    }

    public <T> void executeSync(BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入URL
            return;
        }
        String json = JsonParseHelper.obj2Json(mObjectMaps);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        final Request request = new Request.Builder()
                .url(mURI)
                .post(body)
                .build();
        performSync(request, callBack);
    }
}
