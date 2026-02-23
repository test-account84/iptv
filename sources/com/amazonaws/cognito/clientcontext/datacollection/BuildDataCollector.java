package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BuildDataCollector extends DataCollector {
    public Map collect(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("DeviceBrand", Build.BRAND);
        hashMap.put("DeviceFingerprint", Build.FINGERPRINT);
        hashMap.put("DeviceHardware", Build.HARDWARE);
        hashMap.put("DeviceName", Build.MODEL);
        hashMap.put("Product", Build.PRODUCT);
        hashMap.put("BuildType", Build.TYPE);
        hashMap.put("DeviceOsReleaseVersion", Build.VERSION.RELEASE);
        hashMap.put("DeviceSdkVersion", Build.VERSION.SDK);
        return hashMap;
    }
}
