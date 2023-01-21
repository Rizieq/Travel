package com.project.travel.ui.pesanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.R
import com.project.travel.adapter.PesananAdapter
import com.project.travel.adapter.TouristAttractionAdapter
import com.project.travel.model.ResponsePesananItem
import com.project.travel.ui.touristAttraction.TouristAttractionPresenter
import kotlinx.android.synthetic.main.activity_pesanan.*
import kotlinx.android.synthetic.main.activity_tourist_attraction.*

class PesananActivity : AppCompatActivity(),PesananContract {
    private lateinit var presenter: PesananPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)

        getPesanan()
    }

    private fun getPesanan() {
        presenter = PesananPresenter(this)
        presenter.getPesanan()
    }

    override fun onResume() {
        super.onResume()
        getPesanan()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSuccessGetPesanan(data: List<ResponsePesananItem>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_pesanan.setLayoutManager(LinearLayoutManager(this))
        rv_pesanan.setHasFixedSize(true)
        rv_pesanan.setAdapter(PesananAdapter(data))
    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}