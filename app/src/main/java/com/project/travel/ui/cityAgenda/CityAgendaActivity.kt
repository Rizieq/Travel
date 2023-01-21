package com.project.travel.ui.cityAgenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.R
import com.project.travel.adapter.EventAdapter
import com.project.travel.model.ResponseEvent
import com.project.travel.ui.mainHome.MainActiviyPresenter
import kotlinx.android.synthetic.main.activity_city_agenda.*
import kotlinx.android.synthetic.main.activity_main.*

class CityAgendaActivity : AppCompatActivity(),CityAgendaContract  {
    private lateinit var presenter: CityAgendaPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_agenda)

        getCityAgenda()
    }

    override fun onResume() {
        super.onResume()
        getCityAgenda()
    }



    private fun getCityAgenda() {
        presenter = CityAgendaPresenter(this)
        presenter.getListCityAgenda()
    }

    override fun onSuccessGetCityAgenda(data: List<ResponseEvent>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvCityAgenda.setLayoutManager(LinearLayoutManager(this))
        rvCityAgenda.setHasFixedSize(true)
        rvCityAgenda.setAdapter(EventAdapter(data))

    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
    }
}