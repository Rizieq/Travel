package com.project.travel.ui.travelPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.R
import com.project.travel.adapter.TouristAttractionAdapter
import com.project.travel.adapter.TravelPackageAdapter
import com.project.travel.model.ResponseTravelPackage
import com.project.travel.ui.touristAttraction.TouristAttractionPresenter
import com.project.travel.ui.travelPackage.detailTravelPackage.DetailTravelPackageActivity
import kotlinx.android.synthetic.main.activity_tourist_attraction.*
import kotlinx.android.synthetic.main.activity_travel_package.*
import kotlinx.android.synthetic.main.item_travel_package.*

class TravelPackageActivity : AppCompatActivity(),TravelPackageContract {
    private lateinit var presenter: TravelPackagePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_package)

        getTravelPackage()
    }

    override fun onResume() {
        super.onResume()
        getTravelPackage()
    }

    override fun onPause() {
        super.onPause()
    }

    private fun getTravelPackage() {
        presenter = TravelPackagePresenter(this)
        presenter.getTravelpackage()
    }


    override fun onSuccessGetTravelPackage(data: List<ResponseTravelPackage>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_travel_package.setLayoutManager(LinearLayoutManager(this))
        rv_travel_package.setHasFixedSize(true)
        rv_travel_package.setAdapter(TravelPackageAdapter(data))

    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}