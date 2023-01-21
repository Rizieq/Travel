package com.project.travel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.model.ResponseHotel
import com.project.travel.ui.hotel.detailHotel.DetailHotelActivity
import kotlinx.android.synthetic.main.item_hotel.view.*


class HotelAdapter(val data:List<ResponseHotel>?) : RecyclerView.Adapter<HotelAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel, parent, false)
        return HotelAdapter.ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data?.get(position))
    }


    override fun getItemCount(): Int = data?.size ?: 0


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun onBind(get : ResponseHotel?){
            itemView.item_hotel_name.text = get?.nameHotel
            itemView.item_hotel_location.text = get?.address
            Glide.with(itemView.context)
                .load(get?.photo)
                .into(itemView.item_img_hotel)


            itemView.setOnClickListener {

                val intent = Intent(itemView.context, DetailHotelActivity::class.java)
                intent.putExtra("imageDetail",get?.photo)
                intent.putExtra("nameDetail",get?.nameHotel)
                intent.putExtra("addressDetail",get?.address)
                intent.putExtra("descriptionDetail",get?.description)
                intent.putExtra("latDetail",get?.lat)
                intent.putExtra("longDetail",get?.long)
                intent.putExtra("reviewDetail",get?.review)
                intent.putExtra("priceDetail",get?.price)
                itemView.context.startActivity(intent)
            }
        }
    }


}