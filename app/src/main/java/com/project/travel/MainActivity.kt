package com.project.travel

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.adapter.EventAdapter
import com.project.travel.model.ResponseEvent
import com.project.travel.ui.MainActivityContract
import com.project.travel.ui.MainActiviyPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract{
    private lateinit var presenter: MainActiviyPresenter
    private var listEvent : EventAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        getListProduk()
    }

    override fun onResume() {
        super.onResume()
        getListProduk()
    }

    override fun onPause() {
        super.onPause()
    }
    fun getListProduk(){

        presenter = MainActiviyPresenter(this)
        presenter.getListProduk()


    }


    override fun onSuccessGetEvent(data: List<ResponseEvent>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_main_event.setLayoutManager(LinearLayoutManager(this))
        rv_main_event.setHasFixedSize(true)
        rv_main_event.setAdapter(EventAdapter(data))

    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this@MainActivity,"Failed",Toast.LENGTH_LONG).show()
    }
}