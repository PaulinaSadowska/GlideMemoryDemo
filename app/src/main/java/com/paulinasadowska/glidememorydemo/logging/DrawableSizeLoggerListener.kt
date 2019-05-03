package com.paulinasadowska.glidememorydemo.logging

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.paulinasadowska.glidememorydemo.logging.logMessage

class DrawableSizeLoggerListener(private val logReadyListener: (log: String) -> Unit) : RequestListener<Drawable> {

    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
        return false
    }

    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
        logReadyListener(resource.logMessage())
        return false
    }
}

