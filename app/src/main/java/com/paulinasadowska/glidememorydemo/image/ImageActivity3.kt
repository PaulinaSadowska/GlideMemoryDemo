package com.paulinasadowska.glidememorydemo.image

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.frame_image.*

class ImageActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_image)

        button.setOnClickListener {
            val i = Intent(this, ImageActivity4::class.java)
            startActivity(i)
            //finish()
        }

        GlideLoader(this)
                .load("https://picsum.photos/2000/3200?image=13", image)
    }

    override fun onStop() {
        super.onStop()
        Glide.with(this).clear(image)
    }
}