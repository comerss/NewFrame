package com.donews.frame.camera

import android.Manifest
import android.content.Intent
import com.bumptech.glide.Glide
import com.donews.frame.R
import com.liangyibang.baselibrary.base.BaseActivity
import com.liangyibang.baselibrary.utils.CameraUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.File

/**
 * Created by 79653 on 2018/6/11.
 * 描述：
 */
class CameraActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_camera
    }

    override fun initView() {
    }

    var cameraFile: File? = null
    override fun initListener() {
        btnCamera.setOnClickListener {
            RxPermissions(this@CameraActivity)
                    .requestEach(Manifest.permission.CAMERA)
                    .subscribeBy {
                        if (it.granted)
                            cameraFile = CameraUtils.openCamera(this, 999)
                    }
        }
    }

    override fun initData() {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 999) {
            cameraFile?.let {
                if (it.exists())
                    Glide.with(this)
                            .load(cameraFile!!.absolutePath)
                            .into(Img)
            }
        }

    }
}