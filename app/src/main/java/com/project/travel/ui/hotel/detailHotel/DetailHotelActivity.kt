package com.project.travel.ui.hotel.detailHotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.ui.mainHome.detailHome.MapsDetailMainActivity
import kotlinx.android.synthetic.main.activity_detail_hotel.*

class DetailHotelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hotel)
        val intentImageDetail = intent.getStringExtra("imageDetail")
        val intentName = intent.getStringExtra("nameDetail")
        val intentAddress = intent.getStringExtra("addressDetail")
        val intentDescription = intent.getStringExtra("descriptionDetail")
        val intentLat = intent.getStringExtra("latDetail")
        val intentLong = intent.getStringExtra("longDetail")
        val intentReview = intent.getStringExtra("reviewDetail")
        val intentPrice = intent.getStringExtra("priceDetail")

        Glide.with(this)
            .load(intentImageDetail)
            .into(imgPackageTravel)
        namePackageTravel.text = intentName
        addressPackageTravel.text = intentAddress
        descriptionTravelPackage.text = intentDescription
        reviewHotelDetail.text = "Review : $intentReview"
        priceHotelDetail.text = "$intentPrice/"

        imgMapsHotelDetail.setOnClickListener {
            val intent = Intent(this, MapsDetailMainActivity::class.java)

            intent.putExtra("nameDetail",intentName)
            intent.putExtra("latDetail",intentLat)
            intent.putExtra("longDetail",intentLong)
            startActivity(intent)
        }
    }
}