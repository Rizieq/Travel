package com.project.travel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.travel.R

import com.project.travel.model.ResponsePesananItem
import com.project.travel.ui.pesanan.PesananDetailActivity
import kotlinx.android.synthetic.main.item_pesanan.view.*

import kotlinx.android.synthetic.main.item_tourist_attraction.view.*

class PesananAdapter(val data:List<ResponsePesananItem>?) : RecyclerView.Adapter<PesananAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pesanan, parent, false)
        return PesananAdapter.ViewHolder(view)
    }


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

        fun onBind(get : ResponsePesananItem?){
            itemView.item_no_transaksi.text = get?.noTransaksi
            itemView.item_name_transaksi.text = get?.nameTransaksi
            itemView.item_date_transaksi.text = get?.date
            itemView.item_price_transaksi.text = get?.price

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, PesananDetailActivity::class.java)
                intent.putExtra("nameDetail",get?.nameTransaksi)
                intent.putExtra("noDetail",get?.noTransaksi)
                intent.putExtra("dateDetail",get?.date)
                intent.putExtra("priceDetail",get?.price)
                intent.putExtra("menberDetail",get?.meberTransaksi)
                itemView.context.startActivity(intent)
            }
        }
    }
}