package com.paulinasadowska.glidememorydemo.image

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideLoader(private val activity: AppCompatActivity) : LifecycleObserver {

    private val views: MutableSet<ImageView> = mutableSetOf()

    init {
        activity.lifecycle.addObserver(this)
    }

    fun load(url: String, view: ImageView) {
        Glide.with(activity)
                .load(url)
                .skipMemoryCache(true)
                .into(view)
        views.add(view)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        views.forEach {
            Glide.with(activity).clear(it)
        }
        views.clear()
    }
}