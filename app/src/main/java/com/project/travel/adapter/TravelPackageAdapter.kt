package com.project.travel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.model.ResponseTravelPackage
import com.project.travel.ui.travelPackage.detailTravelPackage.DetailTravelPackageActivity
import kotlinx.android.synthetic.main.item_travel_package.view.*


class TravelPackageAdapter(val data:List<ResponseTravelPackage>?) : RecyclerView.Adapter<TravelPackageAdapter.ViewHolder>() {

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_travel_package, parent, false)
        return TravelPackageAdapter.ViewHolder(view)
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


    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(get : ResponseTravelPackage?){
            itemView.item_travel_package_name.text = get?.namePackage
            itemView.item_travel_package_day.text = get?.dayPackage
            itemView.item_travel_package_price.text = get?.pricePackage
            itemView.item_value_star.text = get?.starPackage
            itemView.item_value_like.text = get?.likePackage

            Glide.with(itemView.context)
                .load(get?.imagePackage)
                .into(itemView.item_travel_package)




            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailTravelPackageActivity::class.java)
                intent.putExtra("imageDetail",get?.imagePackage)
                intent.putExtra("nameDetail",get?.namePackage)
                intent.putExtra("descDetail",get?.descPackage)
                intent.putExtra("dayDetail",get?.dayPackage)
                intent.putExtra("priceDetail",get?.pricePackage)
                intent.putExtra("starDetail",get?.starPackage)
                intent.putExtra("likeDetail",get?.likePackage)
                itemView.context.startActivity(intent)
            }
        }
    }
}