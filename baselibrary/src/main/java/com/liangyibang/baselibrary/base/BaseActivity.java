package com.liangyibang.baselibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.liangyibang.baselibrary.R;
import com.liangyibang.baselibrary.baseAdapter.BaseQuickAdapter;
import com.liangyibang.baselibrary.baseAdapter.BaseViewHolder;
import com.liangyibang.baselibrary.http.Constant;
import com.liangyibang.baselibrary.utils.ToastUtils;
import com.liangyibang.baselibrary.widget.statusbar.StatusBarCompat;

import java.lang.reflect.Method;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initWondow();
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
        ToastUtils.showToast(content);
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
    public static void closeKeybord(EditText mEditText, Context mContext) {
        if (mEditText == null || mContext == null)
            return;
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
        Class<EditText> cls = EditText.class;
        try {
            Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
            setShowSoftInputOnFocus.setAccessible(false);
            setShowSoftInputOnFocus.invoke(mEditText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打卡软键盘
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity == null)
            return;
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (activity.getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (activity.getCurrentFocus() != null)
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            Class<EditText> cls = EditText.class;
            try {
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(false);
                setShowSoftInputOnFocus.invoke(activity.getCurrentFocus(), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //调理方案URL
    public static String getRecipel() {
        if (Constant.IS_DEBUG)
            return "https://wechat2.liangyibang.com/html/app/consult.html?";
        return "https://wechat.liangyibang.com/html/app/consult.html?";
    }

    public <T> void setResult(BaseQuickAdapter<T, BaseViewHolder> adapter, List<T> it, int pageNum) {
        adapter.loadMoreComplete();
        if (it == null)
            return;
        if (pageNum == 1) {
            adapter.setNewData(it);
            adapter.setEmptyView(R.layout.empty_view);
        } else {
            adapter.addData(it);
            adapter.setEnableLoadMore(!it.isEmpty());
        }
    }
}
