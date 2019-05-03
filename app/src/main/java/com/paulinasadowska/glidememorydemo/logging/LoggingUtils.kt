package com.paulinasadowska.glidememorydemo.logging

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.TextView

fun Drawable?.logMessage(): String {
    return when (this) {
        is BitmapDrawable -> logMessage()
        null -> "null"
        else -> this.javaClass.simpleName
    }
}

fun BitmapDrawable.logMessage(): String {
    return bitmap.logMessage()
}

fun Bitmap.logMessage(): String {
    val mbSize = String.format("%.2f", byteCount / 1048576.0)
    return "$byteCount bytes ($mbSize Mb), size: $width x $height"
}

fun String.logAndSetText(textView: TextView, name: String) {
    val log = "$name:\n$this"
    textView.text = log
    Log.d("GlideSize", log)
}