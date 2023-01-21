package com.project.travel.ui.cityAgenda.cityAgendaDetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.ui.mainHome.detailHome.MapsDetailMainActivity
import kotlinx.android.synthetic.main.activity_detail_main.*

class CityAgendaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_agenda_detail)
        val intentImageDetail = intent.getStringExtra("imageDetail")
        val intentNameEvent = intent.getStringExtra("nameEventDetail")
        val intentAddress = intent.getStringExtra("addressDetail")
        val intentDescription = intent.getStringExtra("descriptionDetail")
        val intentLat = intent.getStringExtra("latDetail")
        val intentLong = intent.getStringExtra("longDetail")
        val intentDate = intent.getStringExtra("dateDetail")

        Glide.with(this)
            .load(intentImageDetail)
            .into(imgDetail)
        nameEventDetail.text = intentNameEvent
        addressDetail.text = intentAddress
        descriptionDetail.text = intentDescription
        dateDetail.text = intentDate
        imgMapsDetail.setOnClickListener {
            val intent = Intent(this, MapsDetailMainActivity::class.java)

            intent.putExtra("nameEventDetail",intentNameEvent)
            intent.putExtra("latDetail",intentLat)
            intent.putExtra("longDetail",intentLong)
            startActivity(intent)
        }



    }
}