package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApplicationDataCollector extends DataCollector {
    private static final int ALL_FLAGS_OFF = 0;
    private static final String TAG = "ApplicationDataCollector";

    private String getAppName(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
    }

    private String getAppTargetSdk(Context context) {
        return String.valueOf(context.getApplicationInfo().targetSdkVersion);
    }

    private String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(TAG, "Unable to get app version. Provided package name could not be found.");
            return "";
        }
    }

    public Map collect(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("ApplicationName", getAppName(context));
        hashMap.put("ApplicationTargetSdk", getAppTargetSdk(context));
        hashMap.put("ApplicationVersion", getAppVersion(context));
        return hashMap;
    }
}
