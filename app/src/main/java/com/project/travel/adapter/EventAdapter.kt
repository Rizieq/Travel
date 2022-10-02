package com.project.travel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.project.travel.R
import com.project.travel.model.ResponseEvent
import com.project.travel.networking.ApiClient
import com.project.travel.ui.detailMainActivity.DetailMainActivity
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(val data:List<ResponseEvent>?) : RecyclerView.Adapter<EventAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        holder.onBind(data?.get(position))


    }

    override fun getItemCount(): Int = data?.size ?: 0


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(get : ResponseEvent?){
            itemView.item_name_event1.text = get?.NameEvent
            itemView.item_location_event1.text = get?.Address
            Glide.with(itemView.context)
                .load(get?.Photo)
                .into(itemView.item_img_event1)


            itemView.setOnClickListener {
                val intent = Intent(itemView.context,DetailMainActivity::class.java)
                intent.putExtra("imageDetail",get?.Photo)
                intent.putExtra("nameEventDetail",get?.NameEvent)
                intent.putExtra("addressDetail",get?.Address)
                intent.putExtra("descriptionDetail",get?.Description)
                intent.putExtra("latDetail",get?.Lat)
                intent.putExtra("longDetail",get?.Long)
                itemView.context.startActivity(intent)
            }
        }
    }


}