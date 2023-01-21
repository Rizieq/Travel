package com.project.travel.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.model.ResponseEvent
import com.project.travel.ui.mainHome.detailHome.DetailMainActivity
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
            itemView.item_date_event1.text = get?.eventDate
            Glide.with(itemView.context)
                .load(get?.Photo)
                .into(itemView.item_img_event1)

            Log.d("LOG_DATA_Event", get?.NameEvent.toString())


            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMainActivity::class.java)
                intent.putExtra("imageDetail",get?.Photo)
                intent.putExtra("nameDetail",get?.NameEvent)
                intent.putExtra("addressDetail",get?.Address)
                intent.putExtra("descriptionDetail",get?.Description)
                intent.putExtra("latDetail",get?.Lat)
                intent.putExtra("longDetail",get?.Long)
                intent.putExtra("dateDetail",get?.eventDate)
                itemView.context.startActivity(intent)
            }
        }
    }


}