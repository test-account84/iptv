package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aqv {
    private static final AtomicReference a = new AtomicReference();
    private static final AtomicReference b = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    public static aqt a() {
        return (aqt) a.get();
    }

    public static aqu b() {
        return (aqu) b.get();
    }

    public static void c(aqt aqtVar) {
        a.set(aqtVar);
    }
}
