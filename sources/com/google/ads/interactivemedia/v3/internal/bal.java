package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bal {
    private final ConcurrentMap a;
    private final baj b;
    private final Class c;
    private final bfx d;

    public /* synthetic */ bal(ConcurrentMap concurrentMap, baj bajVar, bfx bfxVar, Class cls) {
        this.a = concurrentMap;
        this.b = bajVar;
        this.c = cls;
        this.d = bfxVar;
    }

    public final baj a() {
        return this.b;
    }

    public final bfx b() {
        return this.d;
    }

    public final Class c() {
        return this.c;
    }

    public final Collection d() {
        return this.a.values();
    }

    public final boolean e() {
        return !this.d.a().isEmpty();
    }
}
