package com.paulinasadowska.glidememorydemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.paulinasadowska.glidememorydemo.image.ImageActivity
import com.paulinasadowska.glidememorydemo.pager.ViewPagerActivity
import com.paulinasadowska.glidememorydemo.recycler.RecyclerViewActivity
import com.paulinasadowska.glidememorydemo.size.BitmapSizeActivity
import com.paulinasadowska.glidememorydemo.size.SmallBitmapSizeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBitmapSize.setOnClickListener {
            startActivity(BitmapSizeActivity::class)
        }
        buttonSmallBitmapSize.setOnClickListener {
            startActivity(SmallBitmapSizeActivity::class)
        }
        buttonActivityStack.setOnClickListener {
            startActivity(ImageActivity::class)
        }
        buttonRecyclerView.setOnClickListener {
            startActivity(RecyclerViewActivity::class)
        }
        buttonViewPager.setOnClickListener {
            startActivity(ViewPagerActivity::class)
        }
    }

    private fun startActivity(clazz: KClass<*>) {
        startActivity(Intent(this, clazz.java))
    }
}
