package com.paypal.gdelapena.alaccy;

import android.location.Location;

/**
 * Created by gdelapena on 11/23/14.
 */
public class LogHelper {

    public static String FormatLocationInfo(String provider, Double lat, Double lng, float accy){
        String logMessage = String.format("%s | lat/long=%f/%f | accy=%f", provider, lat, lng, accy);

        return logMessage;
    }

    public static String FormatLocationInfo(Location location) {
        String provider = location.getProvider();
        Double lat = location.getLatitude();
        Double lng = location.getLongitude();
        float accy = location.getAccuracy();

        return FormatLocationInfo(provider,lat,lng,accy);
    }
}
