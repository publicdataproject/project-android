package com.song2.publicdata_project.Fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.LinearLayout
import com.song2.publicdata_project.R
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView

import com.google.android.gms.maps.OnMapReadyCallback
import com.song2.publicdata_project.Data.ShopListData
import com.song2.publicdata_project.adapter.ShopListRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_shop.*

class ShopFragment : Fragment(),OnMapReadyCallback{

    lateinit var mapView: MapView

    lateinit var shopListRecyclerViewAdapter : ShopListRecyclerViewAdapter

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        attachShopListRecyclerView()
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

        googleMap.addCircle(
            CircleOptions()
                .radius(1000.0)
                .strokeWidth(0f)
                .center(LatLng(35.141233, 126.925594))
                .fillColor(Color.parseColor("#7Fc4c9e8"))
        )

    }

    fun attachShopListRecyclerView(){
        var dataList : ArrayList<ShopListData> = ArrayList()
        dataList.add(ShopListData(0,"","군포 농협","군포"))
        dataList.add(ShopListData(1,"","안양 농협","안양"))
        dataList.add(ShopListData(2,"","망원 농협","망원"))

        shopListRecyclerViewAdapter= ShopListRecyclerViewAdapter(context!!, dataList)
        rv_shop_frag_shop_list.adapter = shopListRecyclerViewAdapter
        rv_shop_frag_shop_list.layoutManager = LinearLayoutManager(context!!, LinearLayout.HORIZONTAL, false)
    }


}
