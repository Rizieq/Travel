package com.project.travel.ui.touristAttraction.detailTouristAttraction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.travel.R
import com.project.travel.ui.mainHome.detailHome.MapsDetailMainActivity
import kotlinx.android.synthetic.main.activity_detail_main.*
import kotlinx.android.synthetic.main.activity_detail_tourist_attraction.*

class DetailTouristAttractionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tourist_attraction)

        val intentImageDetail = intent.getStringExtra("imageDetail")
        val intentName = intent.getStringExtra("nameDetail")
        val intentAddress = intent.getStringExtra("addressDetail")
        val intentDescription = intent.getStringExtra("descriptionDetail")
        val intentLat = intent.getStringExtra("latDetail")
        val intentLong = intent.getStringExtra("longDetail")


        Glide.with(this)
            .load(intentImageDetail)
            .into(imgTouristAttractionDetail)
        nameTouristAttractionDetail.text = intentName
        addressTouristAttractionDetail.text = intentAddress
        descriptionTouristAttractionDetail.text = intentDescription

        imgMapsTouristAttractionDetail.setOnClickListener {
            val intent = Intent(this, MapsDetailMainActivity::class.java)

            intent.putExtra("nameDetail",intentName)
            intent.putExtra("latDetail",intentLat)
            intent.putExtra("longDetail",intentLong)
            startActivity(intent)
        }



    }
}