package com.project.travel.ui.mainHome.detailHome

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.project.travel.R
import com.project.travel.databinding.ActivityMapsDetailMainBinding
import java.io.IOException
import java.util.*


class MapsDetailMainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapsDetailMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsDetailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        val intent = intent
        val namaEvent = intent.getStringExtra("nameDetail")
        val eventMapLat = intent.getStringExtra("latDetail")!!.toDouble()
        val eventMapLong = intent.getStringExtra("longDetail")!!.toDouble()

        val latLng = LatLng(eventMapLat, eventMapLong)
        val makerOptions = MarkerOptions().position(latLng).title(namaEvent)
            .snippet(getTheAddress(eventMapLat, eventMapLong))
        googleMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20f))
        googleMap?.addMarker(makerOptions)

    }
    private fun getTheAddress(latitude: Double, longitude: Double): String? {
        var retVal = ""
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            retVal = addresses[0].getAddressLine(0)

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return retVal
    }
}