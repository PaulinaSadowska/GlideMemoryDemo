package com.paulinasadowska.glidememorydemo.targets

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.paulinasadowska.glidememorydemo.R
import com.paulinasadowska.glidememorydemo.logging.DrawableSizeLoggerListener
import com.paulinasadowska.glidememorydemo.logging.logMessage
import kotlinx.android.synthetic.main.activity_targets.*

@SuppressLint("SetTextI18n")
class TargetActivity : AppCompatActivity() {

    companion object {
        private const val IMAGE_URL = "https://picsum.photos/2000/1000?image=32"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_targets)

        loadRegular()
        loadDrawableImageTarget()
        loadCustomTarget()
        loadCustomTargetWithSize()
        loadSimpleTarget()
    }

    private fun loadRegular() { //2.22Mb
        Glide.with(this)
                .load(IMAGE_URL)
                .listener(DrawableSizeLoggerListener {
                    image1Size.text = "Regular\n $it"
                })
                .into(image1)
    }

    private fun loadDrawableImageTarget() { //2.22Mb or 24.55Mb without fitCenter or with only dontTransform
        Glide.with(this)
                .load(IMAGE_URL)
                //.fitCenter() // with 2.22Mb, without 24.55Mb
                //.downsample(DownsampleStrategy.FIT_CENTER) // with 2.22Mb, without 24.55Mb (without fitCenter)
                .into(object : DrawableImageViewTarget(image2) {
                    override fun setResource(resource: Drawable?) {
                        image2Size.text = "DrawableImageViewTarget\n${resource.logMessage()}"
                        super.setResource(resource)
                    }
                })
    }

    private fun loadCustomTarget() { // 7.63Mb (2000x1000)
        Glide.with(this)
                .load(IMAGE_URL)
                .into(object : CustomTarget<Drawable>() {

                    override fun onLoadCleared(placeholder: Drawable?) {
                        // do nothing
                    }

                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        image3Size.text = "CustomTarget\n${resource.logMessage()}"
                        image3.setImageDrawable(resource)
                    }
                })
    }


    private fun loadCustomTargetWithSize() { // 2.22Mb (1080x540)
        image4.viewTreeObserver.addOnGlobalLayoutListener {
            Glide.with(this)
                    .load(IMAGE_URL)
                    .into(object : CustomTarget<Drawable>(image4.width, 1) {
                        override fun onLoadCleared(placeholder: Drawable?) {
                            // do nothing
                        }

                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            image4Size.text = "CustomTarget with size\n${resource.logMessage()}"
                            image4.setImageDrawable(resource)
                        }
                    })
        }
    }

    private fun loadSimpleTarget() { // 7.63Mb (2000x1000)
        Glide.with(this)
                .load(IMAGE_URL)
                .into(object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                        image5Size.text = "SimpleTarget\n${resource.logMessage()}"
                        image5.setImageDrawable(resource)
                    }
                })
    }
}