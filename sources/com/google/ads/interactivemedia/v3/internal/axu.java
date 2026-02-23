package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class axu {
    static {
        Math.log(2.0d);
    }

    public static boolean a(double d) {
        if (Math.copySign(1.0d - d, 1.0d) <= 0.1d || d == 1.0d) {
            return true;
        }
        return Double.isNaN(1.0d) && Double.isNaN(d);
    }
}
