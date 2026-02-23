package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ayh extends ayg {
    final AtomicIntegerFieldUpdater a;

    public ayh(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.a = atomicIntegerFieldUpdater;
    }

    public final int a(ayj ayjVar) {
        return this.a.decrementAndGet(ayjVar);
    }
}
