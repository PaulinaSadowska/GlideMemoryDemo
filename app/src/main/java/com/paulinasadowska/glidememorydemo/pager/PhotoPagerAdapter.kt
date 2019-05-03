package com.paulinasadowska.glidememorydemo.pager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide


class PhotoPagerAdapter(private val context: Context) : PagerAdapter() {

    private val images = listOf(
            "https://picsum.photos/2000/3000?image=0",
            "https://picsum.photos/2100/3000?image=1",
            "https://picsum.photos/2200/3000?image=2",
            "https://picsum.photos/2300/3000?image=3",
            "https://picsum.photos/2400/3000?image=4",
            "https://picsum.photos/2500/3000?image=5",
            "https://picsum.photos/2600/3000?image=6",
            "https://picsum.photos/2700/3000?image=7",
            "https://picsum.photos/2800/3000?image=8",
            "https://picsum.photos/2900/3000?image=9",
            "https://picsum.photos/2000/3100?image=10",
            "https://picsum.photos/2000/3200?image=11",
            "https://picsum.photos/2000/33000?image=12",
            "https://picsum.photos/2000/3400?image=13"
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        container.addView(imageView)

        Glide.with(context)
                .load(images[position])
                .into(imageView)

        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, o: Any) {
        container.removeView(o as View)
    }
    override fun isViewFromObject(view: View, p1: Any) = view == p1

    override fun getCount() = images.size

}
