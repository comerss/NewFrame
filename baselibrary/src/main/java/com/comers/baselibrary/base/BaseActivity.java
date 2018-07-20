package com.comers.baselibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.comers.baselibrary.utils.ToastUtils;
import com.comers.baselibrary.utils.UIUtils;
import com.comers.baselibrary.widget.statusbar.StatusBarCompat;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBefore();
        setContentView(getLayoutId());
        mContext = this;
        initView();
        initData();
        initListener();
    }

    private void initWondow() {
        if (Build.VERSION.SDK_INT >= 21) {
            StatusBarCompat.setStatusBarColor(this, Color.parseColor("#6A6363"));
        }
    }


    protected void initBefore() {
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();


    /**
     * 短Toast 弹窗
     *
     * @param
     */
    public void showToast(final String content) {
        UIUtils.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(content);
            }
        });
    }

    /**
     * activity跳转
     *
     * @param activity
     * @param <E>
     */
    public <E> void toActivity(Class<E> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        //overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
    }

    /**
     * activity跳转
     *
     * @param activity
     * @param <E>
     */
    public <E> void toActivity(Class<E> activity, Bundle extras) {
        Intent intent = new Intent(this, activity);
        intent.putExtras(extras);
        startActivity(intent);
        //overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
    }

    /**
     * activity跳转(返回结果)
     * @param activity
     * @param <E>
     */
    public <E> void toActivityForResult(Class<E> activity, Bundle extras,
                                        int requestCode) {
        Intent intent = new Intent(this, activity);
        intent.putExtras(extras);
        startActivityForResult(intent, requestCode);
        //overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
    }

    /**
     * activity跳转(返回结果)
     *
     * @param activity
     * @param <E>
     */
    public <E> void toActivityForResult(Class<E> activity,
                                        int requestCode) {
        Intent intent = new Intent(this, activity);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setFinishView(View view) {
        if (view == null)
            return;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 关闭软键盘
     */
    public  void closeKeybord(EditText mEditText, Context mContext) {
        UIUtils.closeKeybord(mEditText,mContext);
    }

    /**
     * 打卡软键盘
     */
    public  void openKeybord(EditText mEditText, Context mContext) {
       UIUtils.openKeybord(mEditText,mContext);
    }

    public  void hideKeyboard(Activity activity) {
        UIUtils.closeKeybord(activity);
    }

    //调理方案URL

}
