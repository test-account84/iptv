package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bqc {
    private static final bsr a = new bsr(null);
    private static final bsr b;

    static {
        bsr bsrVar = null;
        try {
            bsrVar = (bsr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        b = bsrVar;
    }

    public static bsr a() {
        bsr bsrVar = b;
        if (bsrVar != null) {
            return bsrVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static bsr b() {
        return a;
    }
}
