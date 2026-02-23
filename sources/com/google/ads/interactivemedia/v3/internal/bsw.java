package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bsw extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    public bsw() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final bqw a() {
        return new bqw(getMessage());
    }
}
