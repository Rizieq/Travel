package com.project.travel.ui.detailMainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.travel.R
import kotlinx.android.synthetic.main.activity_detail_main.*
import kotlinx.android.synthetic.main.item_event.view.*

class DetailMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_main)

        val intentImageDetail = intent.getStringExtra("imageDetail")
        val intentNameEvent = intent.getStringExtra("nameEventDetail")
        val intentAddress = intent.getStringExtra("addressDetail")
        val intentDescription = intent.getStringExtra("descriptionDetail")
        val intentLat = intent.getStringExtra("latDetail")
        val intentLong = intent.getStringExtra("longDetail")

        Glide.with(this)
            .load(intentImageDetail)
            .into(imgDetail)
        nameEventDetail.text = intentNameEvent
        addressDetail.text = intentAddress
        descriptionDetail.text = intentDescription



    }
}