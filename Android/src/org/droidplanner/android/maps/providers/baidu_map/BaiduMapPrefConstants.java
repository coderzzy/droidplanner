package org.droidplanner.android.maps.providers.baidu_map;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zzy on 7/20/17.
 */
public class BaiduMapPrefConstants {

    @StringDef({BAIDU_TILE_PROVIDER, MAPBOX_TILE_PROVIDER, ARC_GIS_TILE_PROVIDER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TileProvider{}

    public static final String BAIDU_TILE_PROVIDER = "baidu";
    public static final String MAPBOX_TILE_PROVIDER = "mapbox";
    public static final String ARC_GIS_TILE_PROVIDER = "arcgis";

    //Prevent instantiation
    private BaiduMapPrefConstants(){}
}