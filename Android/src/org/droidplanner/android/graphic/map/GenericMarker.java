package org.droidplanner.android.graphic.map;

// import com.google.android.gms.maps.model.LatLng;
// import com.google.android.gms.maps.model.MarkerOptions;

import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

public class GenericMarker {

	public static MarkerOptions build(LatLng coord) {
		return new MarkerOptions().position(coord).draggable(true).anchor(0.5f, 0.5f);
	}

}
