package com.paulinasadowska.glidememorydemo.pager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.activity_pager.*

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        pager.adapter = PhotoPagerAdapter(this)
    }

}
