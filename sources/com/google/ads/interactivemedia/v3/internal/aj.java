package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aj {
    private static final HashSet a = new HashSet();
    private static String b = "media3.common";

    public static synchronized String a() {
        String str;
        synchronized (aj.class) {
            str = b;
        }
        return str;
    }

    public static synchronized void b(String str) {
        synchronized (aj.class) {
            if (a.add(str)) {
                b = b + ", " + str;
            }
        }
    }
}
