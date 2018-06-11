package com.liangyibang.baselibrary.widget.update;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.liangyibang.baselibrary.R;
import com.liangyibang.baselibrary.utils.ToastUtils;

/**
 * Created by Comers on 2017/12/20.
 * 描述：
 */

public class UpdateDialog extends Dialog {
    TextView txContent, txCanel, txSure;

    public UpdateDialog(@NonNull Context context, UpdateType type) {
        super(context);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        setContentView(R.layout.dialog_update);
        txContent = findViewById(R.id.txContent);
        txCanel = findViewById(R.id.txCancel);
        txSure = findViewById(R.id.txSure);
        if (type == UpdateType.FORCE_UPDATE) {
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        } else {
            setCanceledOnTouchOutside(true);
            setCancelable(true);
        }
        initData();
    }

    private void initData() {
        txCanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                ToastUtils.showToastCenter("可在设置里面进行检测更新！");
            }
        });
        txSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSureListener != null)
                    mOnSureListener.onSure();
                dismiss();
            }
        });
    }

    public enum UpdateType {
        FORCE_UPDATE, OPTIONAL_UPDATE
    }

    public interface onSureListener {
        void onSure();
    }

    onSureListener mOnSureListener;

    public void setOnSureListener(onSureListener onSureListener) {
        mOnSureListener = onSureListener;
    }
}

