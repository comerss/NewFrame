package com.comers.baselibrary.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.comers.baselibrary.R;


/**
 * Created by human on 2017/5/27.
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context, int themeResId) {
        super(context, R.style.MyDialog);
    }

    public LoadingDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proessdialog);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void show() {
        if (null != this)
            super.show();
    }
}
