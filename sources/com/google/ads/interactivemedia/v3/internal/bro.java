package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bro {
    private static final bsr a;
    private static final bsr b;

    static {
        bsr bsrVar = null;
        try {
            bsrVar = (bsr) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        a = bsrVar;
        b = new bsr();
    }

    public static bsr a() {
        return a;
    }

    public static bsr b() {
        return b;
    }
}
