package com.paulinasadowska.glidememorydemo.image

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.frame_image.*
import kotlin.random.Random

class ImageActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_image)

        button.setOnClickListener {
            val i = Intent(this, ImageActivity3::class.java)
            startActivity(i)
            //  finish()
        }

        val a = Random.nextInt(20)

        GlideLoader(this)
                .load("https://picsum.photos/2000/3200?image=${a + 20}", image)
    }
}