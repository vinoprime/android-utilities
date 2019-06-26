package com.okit.androidutilities;

import android.content.Context;
import android.location.LocationManager;

import com.vinoprime.errorloggerlib.ErrorLogger;

public class LocationUtility {

    private static final String TAG = "LocationUtility";

    public static final int HARDWARE_ENABLED_GPS = 0;
    public static final int NETWORK_ENABLED_GPS = 1;

    public static boolean[] isCanAccesLocation(Context context) {

        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            ErrorLogger.displayOnLogcat(TAG, e);
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            ErrorLogger.displayOnLogcat(TAG, e);
        }

//        if (gps_enabled || network_enabled) return true;
        boolean[] status = new boolean[2];
        status[HARDWARE_ENABLED_GPS] = gps_enabled;
        status[NETWORK_ENABLED_GPS] = network_enabled;

        return status;
    }

}
