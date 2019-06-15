package com.song2.publicdata_project.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.song2.publicdata_project.R
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView

import com.google.android.gms.maps.OnMapReadyCallback

class ShopFragment : Fragment(),OnMapReadyCallback{

    lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layout = inflater.inflate(R.layout.fragment_shop, container, false)
        mapView = layout.findViewById(R.id.mv_shop_fragment)
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync(this)

        return layout
    }

    override fun onResume() {
        mapView.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(googleMap: GoogleMap) {

        MapsInitializer.initialize(this.getActivity())

        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(35.141233, 126.925594), 14f)

        googleMap.animateCamera(cameraUpdate)

        googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(35.141233, 126.925594))
                .title("루프리코리아")
        )

    }
}
