package br.com.anibal.events.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.domain.Arguments
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class EventLocalFragment : BaseFragment(), OnMapReadyCallback {

    private val event = Arguments.event
    private var googleMap: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event_local, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap
        val location = LatLng(event.latitude.toDouble(), event.longitude.toDouble())
        val latLngZoom = CameraUpdateFactory.newLatLngZoom(location, 17f)
        this.googleMap?.moveCamera(latLngZoom)
        this.googleMap?.addMarker(MarkerOptions()
                .title(event.name)
                .snippet(event.startDate + " a " + event.finishDate)
                .position(location))
        this.googleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
    }


}
