package com.amplifyframework.devmenu;

import android.os.Build;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DeviceInfo {
    public boolean isEmulator() {
        return Build.DEVICE.toLowerCase(Locale.getDefault()).contains("generic") && Build.MODEL.toLowerCase(Locale.getDefault()).contains("sdk");
    }

    public String toString() {
        return String.format(Locale.US, "Device Manufacturer: %s\nDevice Model: %s\nAndroid System Version: %s\nSDK Version: %d\nDevice is an Emulator: %s", new Object[]{Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT), isEmulator() ? "Yes" : "No"});
    }
}
