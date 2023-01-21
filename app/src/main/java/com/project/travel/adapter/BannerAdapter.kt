package com.project.travel.adapter

import android.content.Intent
import android.content.res.TypedArray
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.islamkhsh.CardSliderAdapter
import com.project.travel.R
import com.project.travel.model.ResponseBanner
import com.project.travel.model.ResponseEvent
import com.project.travel.ui.mainHome.detailHome.DetailMainActivity
import kotlinx.android.synthetic.main.item_banner.view.*
import kotlinx.android.synthetic.main.item_event.view.*

class BannerAdapter(val banners: List<ResponseBanner>?) : CardSliderAdapter<BannerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(com.project.travel.R.layout.item_banner,parent,false))

    }

    override fun getItemCount(): Int = banners!!.size

    override fun bindVH(holder: ViewHolder, position: Int) {

        holder.itemView.run {
            Glide.with(context)
                .load(banners?.get(position)?.Link)
                .into(item_img_banner)
            item_banner_name.text = banners?.get(position)!!.Name
            Log.d("LOG_DATA", banners?.get(position)!!.Name.toString())

        }
        holder.itemView.setOnClickListener {  }
    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view)
}

