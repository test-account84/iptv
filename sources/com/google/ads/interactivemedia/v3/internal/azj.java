package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azj extends azc {
    final /* synthetic */ azk a;
    private final Callable b;

    public azj(azk azkVar, Callable callable) {
        this.a = azkVar;
        atp.k(callable);
        this.b = callable;
    }

    public final Object a() throws Exception {
        return this.b.call();
    }

    public final String b() {
        return this.b.toString();
    }

    public final void d(Throwable th) {
        this.a.o(th);
    }

    public final void e(Object obj) {
        this.a.j(obj);
    }

    public final boolean g() {
        return this.a.isDone();
    }
}
