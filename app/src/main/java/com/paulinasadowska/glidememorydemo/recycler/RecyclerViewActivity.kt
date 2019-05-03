package com.paulinasadowska.glidememorydemo.recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recycler.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            adapter = PhotoRecyclerAdapter(Glide.with(this@RecyclerViewActivity))

        }
    }
}