package com.paulinasadowska.glidememorydemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.paulinasadowska.glidememorydemo.image.ImageActivity
import com.paulinasadowska.glidememorydemo.pager.ViewPagerActivity
import com.paulinasadowska.glidememorydemo.recycler.RecyclerViewActivity
import com.paulinasadowska.glidememorydemo.size.BitmapSizeActivity
import com.paulinasadowska.glidememorydemo.size.GrayOverlayActivity
import com.paulinasadowska.glidememorydemo.size.SmallBitmapSizeActivity
import com.paulinasadowska.glidememorydemo.targets.TargetActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBitmapSize.onClickStart(BitmapSizeActivity::class)
        buttonSmallBitmapSize.onClickStart(SmallBitmapSizeActivity::class)
        buttonOverlaySize.onClickStart(GrayOverlayActivity::class)
        buttonTargets.onClickStart(TargetActivity::class)
        buttonActivityStack.onClickStart(ImageActivity::class)
        buttonRecyclerView.onClickStart(RecyclerViewActivity::class)
        buttonViewPager.onClickStart(ViewPagerActivity::class)
    }

    private fun TextView.onClickStart(clazz: KClass<*>) {
        setOnClickListener {
            startActivity(clazz)
        }
    }

    private fun startActivity(clazz: KClass<*>) {
        startActivity(Intent(this, clazz.java))
    }
}
