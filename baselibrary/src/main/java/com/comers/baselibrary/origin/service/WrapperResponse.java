package com.comers.baselibrary.origin.service;


import android.os.Handler;
import android.os.Looper;

import com.comers.baselibrary.origin.service.convert.Convert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author nate
 */

public class WrapperResponse extends ICallBack<String> {

    private ICallBack mICallBack;

    private List<Convert> mConvert;
    Handler mHandler=new Handler(Looper.getMainLooper());
    public WrapperResponse(ICallBack ICallBack, List<Convert> converts) {
        this.mICallBack = ICallBack;
        this.mConvert = converts;
    }
    @Override
    public void success(final DoRequest request, final String data) {
        if(mConvert==null||mConvert.size()==0){
            if(mICallBack !=null){
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mICallBack.success(request, data);
                    }
                });
            }
        }else{
            for (Convert convert : mConvert) {
                if (convert.isCanParse(request.getContentType())) {
                    try {
                        final Object object = convert.parse(data, getType());
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mICallBack.success(request, object);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }

            }
        }
    }


    public Type getType() {
        Type type = mICallBack.getClass().getGenericSuperclass();
        Type[] paramType = ((ParameterizedType) type).getActualTypeArguments();
        return paramType[0];
    }

    @Override
    public void fail(int errorCode, String errorMsg) {
        if(mICallBack !=null){
            mICallBack.fail(errorCode, errorMsg);
        }
    }
}
