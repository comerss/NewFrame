package com.comers.baselibrary.widget.fontview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.comers.baselibrary.R;

import java.lang.reflect.Field;

/**
 * Created by Comers on 2017/11/16.
 * 描述：可以定义字体的Textview
 */

public class FontTextView extends AppCompatTextView {
    private int textFont = 1;//normal

    public FontTextView(Context context) {
        this(context, null);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);
            textFont = array.getInt(R.styleable.FontTextView_textFont, 1);
            array.recycle();
        }
        setIncludeFontPadding(false);//去除字体的自带padding值
        initTextFont(context);
    }

    private void initTextFont(Context context) {
        //  Typeface face = Typeface.createFromAsset(getAssets(), "fonts/HanYi.ttf");
        if (textFont == 0) {//细体
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Light.ttf");
            setTypeface(typeface);
        } else if (textFont == 1) {//normal
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Regular.ttf");
            setTypeface(typeface);
        } else if (textFont == 2) {//粗体
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Medium.ttf");
            setTypeface(typeface);
        } else if (textFont == 3) {//数字
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Number.ttf");
            setTypeface(typeface);
        }
        Drawable[] drawables = getCompoundDrawables();
        int desInt = 0;
        if (drawables[2] != null) {
            try {
                //获取  right 箭头的资源id
                Field field = R.drawable.class.getField("right");
                desInt = field.getInt(drawables[2]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //全局的右箭头大小控制，如果是右箭头则重新设置大小，解决不能设置右箭头大小的问题
        if (drawables[2] != null && (desInt == R.drawable.right || desInt ==R.drawable.jiantouhong||desInt ==R.drawable.jiantouhuang)) {
            drawables[2].setBounds(drawables[2].getBounds().left - 6, drawables[2].getBounds().top - 5, drawables[2].getBounds().right + 3, drawables[2].getBounds().bottom + 5);
        } else {
            if (drawables[2] != null)
                drawables[2].setBounds(drawables[2].getBounds());
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableLeft = drawables[2];
            if (drawableLeft != null) {
                float textWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = 0;
                drawableWidth = drawableLeft.getIntrinsicWidth();
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                canvas.translate((getWidth() - bodyWidth) / 2, 0);
            }
        }
        super.onDraw(canvas);
    }
}
