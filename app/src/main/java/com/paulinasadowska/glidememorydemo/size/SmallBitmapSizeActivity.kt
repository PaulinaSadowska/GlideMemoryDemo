package com.paulinasadowska.glidememorydemo.size

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.activity_images_small.*

class SmallBitmapSizeActivity : AppCompatActivity() {

    companion object {
        private const val IMAGE_URL = "https://picsum.photos/200/100?image=26"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images_small)

        loadRegular()
        loadCenterInside()
        loadDownsample()
    }

    private fun loadRegular() { // 2.22Mb
        Glide.with(this)
                .load(IMAGE_URL)
                .listener(DrawableSizeLoggerListener { it.logAndSetText(matchImageSize, "match x wrap") })
                .into(matchImage)
    }

    private fun loadCenterInside() { // 0.08Mb
        Glide.with(this)
                .load(IMAGE_URL)
                .centerInside()
                .listener(DrawableSizeLoggerListener { it.logAndSetText(matchCenterImageSize, "match x wrap + center inside") })
                .into(matchCenterImage)
    }

    private fun loadDownsample() { // 0.08Mb
        Glide.with(this)
                .load(IMAGE_URL)
                .downsample(DownsampleStrategy.CENTER_INSIDE) //alone - 2.22Mb
                .dontTransform() // alone - 24.55Mb!!!
                .listener(DrawableSizeLoggerListener { it.logAndSetText(downsampleImageSize, "match x wrap + downsample center inside + dontTransform") })
                .into(downsampleImage)
    }
}