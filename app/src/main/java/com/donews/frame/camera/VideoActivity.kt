package com.donews.frame.camera

import android.media.MediaPlayer
import android.media.MediaRecorder
import com.donews.frame.R
import com.liangyibang.baselibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_video.*

/**
 * Created by 79653 on 2018/6/11.
 * 描述：
 */
class VideoActivity : BaseActivity() {
    lateinit var mediaPlayer: MediaPlayer
    var isDisplay: Boolean = false
    var isStart: Boolean = false
    lateinit var recorder:MediaRecorder
    override fun getLayoutId(): Int {
        return R.layout.activity_video
    }

    override fun initView() {
    }

    override fun initListener() {
        btnStart.setOnClickListener {
            if (isDisplay)
                if (mediaPlayer != null){
                    mediaPlayer.stop()
                    mediaPlayer.reset()
                    mediaPlayer.release()
                }

            if(!isStart){

            }



        }
    }

    override fun initData() {
    }
}