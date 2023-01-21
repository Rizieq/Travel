package com.project.travel.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.travel.R
import com.project.travel.adapter.PaymentAdapter
import com.project.travel.adapter.PesananAdapter
import com.project.travel.model.ResponsePaymentItem
import com.project.travel.ui.pesanan.PesananPresenter
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_pesanan.*

class PaymentActivity : AppCompatActivity(),PaymentContract {
    private lateinit var presenter: PaymentPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)



        getPayment()
    }


    override fun onResume() {
        super.onResume()
        getPayment()
    }

    override fun onPause() {
        super.onPause()
    }

    private fun getPayment() {
        presenter = PaymentPresenter(this)
        presenter.getPayment()
    }

    override fun onSuccessGetPayment(data: List<ResponsePaymentItem>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_payment.setLayoutManager(LinearLayoutManager(this))
        rv_payment.setHasFixedSize(true)
        rv_payment.setAdapter(PaymentAdapter(data))
    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}