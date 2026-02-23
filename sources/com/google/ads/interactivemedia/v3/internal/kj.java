package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class kj implements jz {
    protected final int b = 250000;
    protected final int c = 750000;
    protected final int d = 4;
    protected final int e = 250000;
    protected final int f = 50000000;
    public final int g = 2;

    public kj(ki kiVar) {
    }

    public static int a(int i, int i2, int i3) {
        return axy.a(((i * i2) * i3) / 1000000);
    }

    public static int b(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }
}
