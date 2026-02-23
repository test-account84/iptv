package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bei {
    private static final bei a = new bei();
    private static final beh b = new beh(null);
    private final AtomicReference c = new AtomicReference();

    public static bei a() {
        return a;
    }

    public final bfz b() {
        bfz bfzVar = (bfz) this.c.get();
        return bfzVar == null ? b : bfzVar;
    }
}
