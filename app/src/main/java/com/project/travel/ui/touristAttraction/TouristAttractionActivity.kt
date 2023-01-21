package com.project.travel.ui.touristAttraction

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.R
import com.project.travel.adapter.TouristAttractionAdapter
import com.project.travel.model.ResponseTouristAttraction
import kotlinx.android.synthetic.main.activity_tourist_attraction.*

class TouristAttractionActivity : AppCompatActivity(), TouristAttractionContract{
    private lateinit var presenter: TouristAttractionPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourist_attraction)
        getListTouristAttraction()
    }

    override fun onResume() {
        super.onResume()
        getListTouristAttraction()
    }

    override fun onPause() {
        super.onPause()
    }

    private fun getListTouristAttraction() {
        presenter = TouristAttractionPresenter(this)
        presenter.getListTouristAttraction()
    }

    override fun onSuccessGetTouristAttraction(data: List<ResponseTouristAttraction>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_tourist_attraction.setLayoutManager(LinearLayoutManager(this))
        rv_tourist_attraction.setHasFixedSize(true)
        rv_tourist_attraction.setAdapter(TouristAttractionAdapter(data))
    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}