package com.project.travel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.model.ResponseTouristAttraction
import com.project.travel.ui.touristAttraction.detailTouristAttraction.DetailTouristAttractionActivity
import kotlinx.android.synthetic.main.item_hotel.view.*
import kotlinx.android.synthetic.main.item_hotel.view.item_hotel_location
import kotlinx.android.synthetic.main.item_tourist_attraction.view.*

class TouristAttractionAdapter(val data:List<ResponseTouristAttraction>?) : RecyclerView.Adapter<TouristAttractionAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tourist_attraction, parent, false)
        return TouristAttractionAdapter.ViewHolder(view)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data?.get(position))
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int = data?.size ?: 0


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(get : ResponseTouristAttraction?){
            itemView.item_tourist_attraction_name.text = get?.nameTouristAttraction
            itemView.item_tourist_attraction_location.text = get?.address
            Glide.with(itemView.context)
                .load(get?.photo)
                .into(itemView.item_img_tourist_attraction)


            itemView.setOnClickListener {

                val intent = Intent(itemView.context, DetailTouristAttractionActivity::class.java)
                intent.putExtra("imageDetail",get?.photo)
                intent.putExtra("nameDetail",get?.nameTouristAttraction)
                intent.putExtra("addressDetail",get?.address)
                intent.putExtra("descriptionDetail",get?.description)
                intent.putExtra("latDetail",get?.lat)
                intent.putExtra("longDetail",get?.long)
                itemView.context.startActivity(intent)
            }
        }
    }
}