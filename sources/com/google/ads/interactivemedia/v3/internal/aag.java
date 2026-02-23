package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aag {
    public final Object a;

    private aag(String str) {
        this.a = str;
    }

    public static aag a(cj cjVar) {
        String str;
        cjVar.G(2);
        int i = cjVar.i();
        int i2 = i >> 1;
        int i3 = (cjVar.i() >> 3) | ((i & 1) << 5);
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            str = "dvhe";
        } else if (i2 == 8) {
            str = "hev1";
        } else {
            if (i2 != 9) {
                return null;
            }
            str = "avc3";
        }
        return new aag(str + ".0" + i2 + (i3 < 10 ? ".0" : ".") + i3);
    }
}
