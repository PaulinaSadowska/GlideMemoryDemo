package com.paulinasadowska.glidememorydemo.size

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.activity_overlay.*

/**
 * Summary of this experiment:
 * creating Bitmap by hand (overall memory: 12.1MB, Bitmap 1.84MB)
 * using Glide: (overall 14.8Mb, Bitmap: 1.84MB (extra is probably for cache), BitmapDrawable (downsample etc. doesn't change anything)
 * using setImageResource (overall: 10.1MB, GradientDrawable created, 480bytes(??))
 * TODO - powtórz pomiary bez cache i bitmap pool
 */


class GrayOverlayActivity : AppCompatActivity() {

    companion object {
        private const val IMAGE_URL = "https://picsum.photos/2000/1000?image=27"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overlay)

        //createDownsample()
        createRegularBitmap()
    }

    private fun createDownsample() {
/*
        Glide.with(this)
                .load(IMAGE_URL)
                .into(downsampleImage)
*/

        val imageView = ImageView(this)

        // asBitmap (with or without downsample) //1,84Mb
        // without downsample + donttransform + NOT bitmap = BitmapDrawable //1,83MB
        // with downsample + donttransform + NOT bitmap  = Bitmap //1,83MB
        Glide.with(this)
                .load(R.drawable.overlay)
                .into(imageView)


        val params = ViewGroup.LayoutParams(800, 600)
        imageView.layoutParams = params
        //imageView.setImageResource(R.drawable.overlay) // GradientDrawable - 460vbytes??
        downsampleFrame.addView(imageView)
    }

    private fun createRegularBitmap() {
/*        Glide.with(this)
                .load(IMAGE_URL)
                .into(matchImage)*/

        val image = Bitmap.createBitmap(800, 600, Bitmap.Config.ARGB_8888) //1,83MB
        val canvas = Canvas(image)
        val HEX = -0x66000000
        canvas.drawColor(HEX)

        val imageView = ImageView(this)
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        imageView.layoutParams = params
        imageView.setImageBitmap(image)

        matchFrame.addView(imageView)
    }
}