package com.paulinasadowska.glidememorydemo.recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.paulinasadowska.glidememorydemo.R
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentFrame, RecyclerViewFragment())
                    .commit()
        }

        nextButton.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentFrame, EmptyFragment())
                    .commit()
        }
    }
}