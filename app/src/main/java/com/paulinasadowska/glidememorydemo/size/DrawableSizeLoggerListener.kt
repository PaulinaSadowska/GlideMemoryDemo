package com.paulinasadowska.glidememorydemo.size

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.TextView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class DrawableSizeLoggerListener(private val logReadyListener: (log: String) -> Unit) : RequestListener<Drawable> {

    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
        return false
    }

    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
        if (resource is BitmapDrawable) {
            with(resource.bitmap) {
                val mbSize = String.format("%.2f", byteCount / 1048576.0)
                logReadyListener("$byteCount bytes ($mbSize Mb, size: $width x $height")
            }
        }
        return false
    }
}

fun String.logAndSetText(textView: TextView, name: String) {
    val log = "$name:\n$this"
    textView.text = log
    Log.d("GlideSize", log)
}