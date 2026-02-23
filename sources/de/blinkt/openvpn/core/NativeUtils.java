package de.blinkt.openvpn.core;

import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class NativeUtils {
    public static final int[] a = {16, 64, 256, 1024, 8192, 16384};

    static {
        if (b()) {
            return;
        }
        System.loadLibrary("ovpnutil");
        System.loadLibrary("osslspeedtest");
    }

    public static String a() {
        return b() ? "ROBO" : getJNIAPI();
    }

    public static boolean b() {
        return "robolectric".equals(Build.FINGERPRINT);
    }

    private static native String getJNIAPI();
}
