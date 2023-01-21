package com.project.travel.ui.hotel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.R
import com.project.travel.adapter.EventAdapter
import com.project.travel.adapter.HotelAdapter
import com.project.travel.model.ResponseHotel
import com.project.travel.ui.mainHome.MainActiviyPresenter
import kotlinx.android.synthetic.main.activity_hotel.*
import kotlinx.android.synthetic.main.activity_main.*


class HotelActivity : AppCompatActivity(), HotelContract {
    private lateinit var presenter: HotelPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        getListHotel()
    }

    override fun onResume() {
        super.onResume()
        getListHotel()
    }

    override fun onPause() {
        super.onPause()

    }


    private fun getListHotel() {
        presenter = HotelPresenter(this)
        presenter.getListHotel()
    }

    override fun onSuccessGetHotel(data: List<ResponseHotel>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_hotel.setLayoutManager(LinearLayoutManager(this))
        rv_hotel.setHasFixedSize(true)
        rv_hotel.setAdapter(HotelAdapter(data))

    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}