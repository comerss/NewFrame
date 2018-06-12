package com.donews.frame.camera

import android.hardware.Camera
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
    lateinit var recorder: MediaRecorder
    lateinit var camera: Camera
    override fun getLayoutId(): Int {
        return R.layout.activity_video
    }

    override fun initView() {
    }

    override fun initListener() {
        btnStart.setOnClickListener {
            if (isDisplay)
                if (mediaPlayer != null) {
                    mediaPlayer.stop()
                    mediaPlayer.reset()
                    mediaPlayer.release()
                }
            if (!isStart) {
                if (recorder == null)
                    recorder = MediaRecorder()
                camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK)
                camera.setDisplayOrientation(90)
                camera.unlock()
                recorder.setCamera(camera)
                // 这两项需要放在setOutputFormat之前
                recorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER)
                recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA)

                // Set output file format
                recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)

                // 这两项需要放在setOutputFormat之后
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP)

                recorder.setVideoSize(640, 480)
                recorder.setVideoFrameRate(30)
                recorder.setVideoEncodingBitRate(3 * 1024 * 1024)
                recorder.setOrientationHint(90)
                //设置记录会话的最大持续时间（毫秒）
                recorder.setMaxDuration(30 * 1000)
//                recorder.setPreviewDisplay(mSurfaceHolder.getSurface())
            }


        }
    }

    override fun initData() {
    }
}