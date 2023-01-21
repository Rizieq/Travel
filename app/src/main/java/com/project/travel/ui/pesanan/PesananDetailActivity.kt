package com.project.travel.ui.pesanan

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.project.travel.R
import kotlinx.android.synthetic.main.activity_pesanan_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PesananDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan_detail)

        val intentName = intent.getStringExtra("nameDetail")
        val intentNo = intent.getStringExtra("noDetail")
        val intentDate = intent.getStringExtra("dateDetail")
        val intentPrice = intent.getStringExtra("priceDetail")
        val intentMember = intent.getStringExtra("menberDetail")

        txt_date_pesanan_transaksi.text = intentDate
        txt_package_name_transaksi.text = intentName
        txt_no_transaksi.text = intentDate
        txt_member_transaksi.text = intentMember


        actionGenerateQrcode(intentName,intentNo,intentDate,intentPrice,intentMember)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun actionGenerateQrcode(
        name: String?,
        no: String?,
        date: String?,
        price: String?,
        member: String?
    ) {
        val encodedText = "$name,$no,$date,$price,$member"
        GlobalScope.launch(Dispatchers.IO) {
            val bitmapMatrix = MultiFormatWriter().run {
                encode(
                    encodedText, BarcodeFormat.QR_CODE,
                    QRCODE_SIZE,
                    QRCODE_SIZE
                )
            }
            val qrCode = BarcodeEncoder().createBitmap(bitmapMatrix)
            launch(Dispatchers.Main) {
                displayQrCode(qrCode)
            }
        }
    }

    private fun displayQrCode(qrCode: Bitmap) {
        dispayQrCode.setImageBitmap(qrCode)
    }

    companion object {
        private const val QRCODE_SIZE = 200
        const val TYPE = "type"
    }
}