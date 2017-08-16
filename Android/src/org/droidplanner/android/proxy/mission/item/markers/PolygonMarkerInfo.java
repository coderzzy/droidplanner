package org.droidplanner.android.proxy.mission.item.markers;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.mission.item.complex.Survey;

import org.droidplanner.android.R;
import org.droidplanner.android.maps.MarkerInfo;
import org.droidplanner.android.proxy.mission.item.MissionItemProxy;

/**
 */
public class PolygonMarkerInfo extends MarkerInfo {

	private LatLong mPoint;
	private final MissionItemProxy markerOrigin;
    private final Survey survey;
    private final int polygonIndex;

	public PolygonMarkerInfo(LatLong point, MissionItemProxy origin, Survey mSurvey, int index) {
		this.markerOrigin = origin;
		mPoint = point;
		survey = mSurvey;
		polygonIndex = index;
	}

	public Survey getSurvey(){
		return survey;
	}

	public int getIndex(){
		return polygonIndex;
	}

	
	@Override
	public float getAnchorU() {
		return 0.5f;
	}

	@Override
	public float getAnchorV() {
		return 0.5f;
	}

	@Override
	public Bitmap getIcon(Resources res) {
		// return null;
		Drawable drawable = res.getDrawable(R.drawable.ic_mission_survey_wp);
		int width = drawable.getIntrinsicWidth();// 取drawable的长宽
		int height = drawable.getIntrinsicHeight();
		Bitmap.Config config = Bitmap.Config.ALPHA_8;/*drawable.getOpacity() != PixelFormat.OPAQUE ?Bitmap.Config.ARGB_8888:Bitmap.Config.RGB_565;*/// 取drawable的颜色格式
		Bitmap bitmap = Bitmap.createBitmap(width, height, config);// 建立对应bitmap
		Canvas canvas = new Canvas(bitmap);// 建立对应bitmap的画布
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);// 把drawable内容画到画布中
		return bitmap;
	}

	@Override
	public com.o3dr.services.android.lib.coordinate.LatLong getPosition() {
		return mPoint;
	}

	@Override
	public void setPosition(LatLong coord) {
		mPoint = coord;
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public boolean isFlat() {
		return true;
	}

	public MissionItemProxy getMarkerOrigin() {
		return markerOrigin;
	}
}
