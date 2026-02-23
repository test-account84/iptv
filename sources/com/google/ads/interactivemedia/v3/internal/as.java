package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class as extends IOException {
    public final boolean a;
    public final int b;

    public as(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.a = z;
        this.b = i;
    }

    public static as a(String str, Throwable th) {
        return new as(str, th, true, 1);
    }

    public static as b(String str, Throwable th) {
        return new as(str, th, true, 0);
    }

    public static as c(String str, Throwable th) {
        return new as(str, th, true, 4);
    }

    public static as d(String str) {
        return new as(str, null, false, 1);
    }
}
