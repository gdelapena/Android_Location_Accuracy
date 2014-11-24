package com.paypal.gdelapena.alaccy;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by gdelapena on 11/23/14.
 */
public class MyLocationListener implements android.location.LocationListener {

    final String _logTag = "ALAccy : ";
    Context mContext;

//    public MyLocationListener(Context context) {
//        this.mContext = context;
//    }

    @Override
    public void onLocationChanged(Location location) {
        String provider = location.getProvider();
        Double lat = location.getLatitude();
        Double lng = location.getLongitude();
        float accy = location.getAccuracy();

        String logMsg = LogHelper.FormatLocationInfo(provider,lat,lng,accy);
        Log.d(_logTag, "Monitor Location: " + logMsg);


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
