package com.comers.shenwu.camera;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.comers.baselibrary.base.LogUtils;

import java.io.IOException;

/**
 * Created by 79653 on 2018/12/3.
 * 描述：
 */
public class VideoManager extends View implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    public String sourse;
    TextureView mTextureView;
    MediaPlayer mPlayer;
    Context mContext;
    boolean autoPlay = true;
    int progress = 0;//播放的当前时间
    VideoStatus mStatus;
    Runnable mProgressTask = new Runnable() {
        @Override
        public void run() {
            int progress = mPlayer.getCurrentPosition();
            LogUtils.i("progress", "-------------->" + progress);
            mHandler.postDelayed(this, 1000);
            progress = mPlayer.getCurrentPosition();
            if (mActionListener != null) {
                mActionListener.onProgress(progress);
            }
        }
    };
    Runnable checkTask = new Runnable() {
        @Override
        public void run() {
            Rect rect = new Rect();
            int height = lyContainer.getMeasuredHeight();
            lyContainer.getGlobalVisibleRect(rect);
            double radio = (rect.bottom - rect.top) * 1.0 / height;
            if (radio >= 0.5) {
                start();
            } else {
                stop();
            }
            mHandler.postDelayed(this, 200);
        }
    };

    private void stop() {
        try {
            mPlayer.pause();
            progress = mPlayer.getCurrentPosition();
            if (mActionListener != null) {
                mActionListener.onPause();
            }
        } catch (Exception e) {

        }
    }

    private void start() {
        try {
            if (!mPlayer.isPlaying() || isStop) {
                mPlayer.start();
                isStop = false;
                if (progress != 0) {
                    mPlayer.seekTo(progress);
                }
            }
        } catch (Exception e) {

        }
    }

    Handler mHandler = new Handler();
    private LinearLayout lyContainer;


    public VideoManager(Context context, String path) {
        super(context);
        this.sourse = path;
        mContext = context;
        mTextureView = new TextureView(context);
        mPlayer = new MediaPlayer();
        mPlayer.reset();
        mPlayer.setLooping(false);
        try {
            mPlayer.setDataSource(path);
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        mTextureView.setSurfaceTextureListener(this);
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnCompletionListener(this);
        lyContainer = new LinearLayout(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.height = (int) getNeedHeight();
        lyContainer.addView(mTextureView, params);
        lyContainer.addView(this);
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        mPlayer.setSurface(new Surface(surface));
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        release();
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (autoPlay && getVisibility() == View.VISIBLE) {
            try {
                mHandler.postDelayed(mProgressTask, 200);
                mPlayer.start();
                mStatus = VideoStatus.START;
                if (mActionListener != null) {
                    mActionListener.onStart();
                }
                mHandler.postDelayed(checkTask, 100);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        release();
        if (mHandler != null) {
            mHandler.removeCallbacks(mProgressTask);
            mProgressTask = null;
        }
    }

    boolean isStop = false;

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        //当window可见不可见的判断
        try {
            if (visibility == View.VISIBLE) {
                //判断状态
                if (isStop && progress != 0) {
                    start();
                    if (mActionListener != null) {
                        mActionListener.onResume();
                    }
                }
            } else {
                //暂停
                mPlayer.pause();
                if (mActionListener != null) {
                    mActionListener.onPause();
                }
                progress = mPlayer.getCurrentPosition();
                isStop = true;
            }
        } catch (Exception e) {

        }
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            mPlayer.prepareAsync();
        } catch (Exception e) {

        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    //资源释放
    private void release() {
        try {
            mPlayer.stop();
            mPlayer.release();
            if (mActionListener != null) {
                mActionListener.onRelease();
            }
        } catch (Exception cx) {
        }
    }

    public ViewGroup getVideoView() {
        return lyContainer;
    }

    private float getNeedHeight() {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float height = displayMetrics.widthPixels;
        if (height != 0) {
            return height * 9 / 16;
        }
        return dip2px(mContext, 180);
    }

    public static float dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }

    public interface VideoActionListener {
        void onStart();

        void onProgress(int progress);

        void onPause();

        void onResume();

        void onRelease();
    }

    public VideoActionListener mActionListener;

    public void setOnVideoActionListener(VideoActionListener listener) {
        mActionListener = listener;
    }
}
