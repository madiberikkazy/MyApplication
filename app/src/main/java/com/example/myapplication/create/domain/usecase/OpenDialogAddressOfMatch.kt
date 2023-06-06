package com.example.myapplication.create.domain.usecase

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng

class OpenDialogAddressOfMatch(private val textView: TextView) : DialogFragment(),
    OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val inflater = LayoutInflater.from(requireContext())
        val dialogView = inflater.inflate(R.layout.dialog_map, null)

        dialog.setContentView(dialogView)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)

        mapView = dialogView.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return dialog
    }


    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    private fun getAddressFromLatLng(latLng: LatLng): String {
        return "Address: ${latLng.latitude}, ${latLng.longitude}"
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(37.7749, -122.4194), 10f))
        googleMap.setOnMapClickListener { latLng ->
            val address = getAddressFromLatLng(latLng)
            textView.text = address
        }
    }
}
