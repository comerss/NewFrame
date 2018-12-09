package com.comers.shenwu.camera;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.comers.baselibrary.base.LogUtils;

/**
 * Created by 79653 on 2018/11/21.
 * 描述：
 */
public class CheckStatusView extends AppCompatTextView {
    public CheckStatusView(Context context) {
        super(context);
    }

    public CheckStatusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckStatusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        if(visibility==VISIBLE){
            LogUtils.i("不可见","------------可见----------");
        }else{
            LogUtils.i("不可见","------------不可见----------");
        }
    }
}
