package com.paulinasadowska.glidememorydemo.size

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.activity_images.*

class BitmapSizeActivity : AppCompatActivity() {

    companion object {
        private const val IMAGE_URL = "https://picsum.photos/2000/1000?image=25"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        loadImageInto(matchImage, matchImageSize, "match x wrap") // 2.22Mb
        loadImageInto(wrapImage, wrapImageSize, "wrap x wrap")    // 6.14Mb
        loadImageInto(s200Image, s200ImageSize, "200x200")        // 0.53Mb
        loadOverride()                                                  // 0.53Mb
    }

    private fun loadImageInto(imageView: ImageView, textView: TextView, name: String) {
        Glide.with(this)
                .load(IMAGE_URL)
                .listener(DrawableSizeLoggerListener { it.logAndSetText(textView, name) })
                .into(imageView)
    }

    private fun loadOverride() {
        val density = resources.displayMetrics.density
        val size = (200 * density).toInt()
        Glide.with(this)
                .load(IMAGE_URL)
                .listener(DrawableSizeLoggerListener { it.logAndSetText(matchOverrideImageSize, "match override 200px*$density=200dp") })
                .override(size, size)
                .into(matchOverrideImage)
    }
}