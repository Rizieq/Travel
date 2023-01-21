package com.project.travel

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.adapter.BannerAdapter
import com.project.travel.adapter.EventAdapter
import com.project.travel.model.ResponseBanner
import com.project.travel.model.ResponseEvent
import com.project.travel.ui.cityAgenda.CityAgendaActivity
import com.project.travel.ui.hotel.HotelActivity
import com.project.travel.ui.mainHome.MainActivityContract
import com.project.travel.ui.mainHome.MainActiviyPresenter
import com.project.travel.ui.pesanan.PesananActivity
import com.project.travel.ui.pesanan.PesananDetailActivity
import com.project.travel.ui.touristAttraction.TouristAttractionActivity
import com.project.travel.ui.travelPackage.TravelPackageActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract {
    private lateinit var presenter: MainActiviyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        imgAlertCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:115")
            startActivity(intent)
        }

        imgPesanan.setOnClickListener{
            startActivity(Intent(this,PesananActivity::class.java))
        }

        btn_city_agenda.setOnClickListener {
            startActivity(Intent(this,CityAgendaActivity::class.java))
        }
        btn_hotel.setOnClickListener {
            startActivity(Intent(this,HotelActivity::class.java))
        }

        btn_find_place.setOnClickListener {
            startActivity(Intent(this,TouristAttractionActivity::class.java))
        }

        btn_trip_package.setOnClickListener {
            startActivity(Intent(this,TravelPackageActivity::class.java))
        }

        getListEvent()
        getBanner()
    }

    private fun getBanner() {
        presenter = MainActiviyPresenter(this)
        presenter.getListBanner()
    }


    override fun onResume() {
        super.onResume()
        getListEvent()
    }

    override fun onPause() {
        super.onPause()
    }

    fun getListEvent(){
        presenter = MainActiviyPresenter(this)
        presenter.getListEvent()


    }


    override fun onSuccessGetEvent(data: List<ResponseEvent>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_main_event.setLayoutManager(linearLayoutManager)
        rv_main_event.setHasFixedSize(true)
        rv_main_event.setAdapter(EventAdapter(data))

    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this@MainActivity,"Failed",Toast.LENGTH_LONG).show()
    }

    override fun onSuccessGetBanner(data: List<ResponseBanner>?) {
        Log.d("LOG_DATA_HOME", data.toString())
        cardHomeSlider.adapter = BannerAdapter(data)
        cardHomeSlider.smallAlphaFactor = 1.0f
        cardHomeSlider.autoSlideTime = data!!.size
    }

    override fun onErrorGetListBanner(msg: String?) {
        Toast.makeText(this@MainActivity,"Failed",Toast.LENGTH_LONG).show()
    }
}