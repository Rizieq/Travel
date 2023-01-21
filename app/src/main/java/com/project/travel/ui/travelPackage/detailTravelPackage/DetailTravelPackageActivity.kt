package com.project.travel.ui.travelPackage.detailTravelPackage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.ui.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_detail_tourist_attraction.*
import kotlinx.android.synthetic.main.activity_detail_travel_trip.*

class DetailTravelPackageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_travel_trip)

        btn_purchase.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }

        val intentImageDetail = intent.getStringExtra("imageDetail")
        val intentName = intent.getStringExtra("nameDetail")
        val intentDesc = intent.getStringExtra("descDetail")
        val intentDay = intent.getStringExtra("dayDetail")
        val intentPrice = intent.getStringExtra("priceDetail")


        Glide.with(this)
            .load(intentImageDetail)
            .into(imgPackageTravel)
        namePackageTravel.text = intentName
        descriptionTravelPackage.text = intentDesc
        dayPackageTravel.text = intentDay
        priceHotelDetail.text = intentPrice


    }
}