package com.paulinasadowska.glidememorydemo.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.paulinasadowska.glidememorydemo.R

class PhotoRecyclerAdapter(private val request: RequestManager) : RecyclerView.Adapter<PhotoRecyclerAdapter.MyViewHolder>() {

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
            "https://picsum.photos/2000/3300?image=12",
            "https://picsum.photos/2000/3400?image=13",
            "https://picsum.photos/2000/3400?image=14",
            "https://picsum.photos/2000/3400?image=15",
            "https://picsum.photos/2000/3400?image=16",
            "https://picsum.photos/2000/3400?image=17",
            "https://picsum.photos/2000/3400?image=18",
            "https://picsum.photos/2000/3400?image=19",
            "https://picsum.photos/2000/3400?image=20",
            "https://picsum.photos/2000/3000?image=40",
            "https://picsum.photos/2100/3000?image=21",
            "https://picsum.photos/2200/3000?image=22",
            "https://picsum.photos/2300/3000?image=32",
            "https://picsum.photos/2400/3000?image=24",
            "https://picsum.photos/2500/3000?image=25",
            "https://picsum.photos/2600/3000?image=26",
            "https://picsum.photos/2700/3000?image=27",
            "https://picsum.photos/2800/3000?image=28",
            "https://picsum.photos/2900/3000?image=29",
            "https://picsum.photos/2000/3100?image=30",
            "https://picsum.photos/2000/3200?image=31",
            "https://picsum.photos/2000/3300?image=32",
            "https://picsum.photos/2000/3400?image=33",
            "https://picsum.photos/2000/3400?image=34",
            "https://picsum.photos/2000/3400?image=35",
            "https://picsum.photos/2000/3400?image=16",
            "https://picsum.photos/2000/3400?image=37",
            "https://picsum.photos/2000/3400?image=38",
            "https://picsum.photos/2000/3400?image=39",
            "https://picsum.photos/2000/3400?image=41"
    )

    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_image, parent, false) as ImageView
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        request.load(images[position])
                //.skipMemoryCache(true)
                .into(holder.imageView)
    }

    override fun onViewRecycled(holder: MyViewHolder) {
        super.onViewRecycled(holder)
                // Glide.clear(holder.imageView)
    }

    override fun getItemCount() = images.size
}
