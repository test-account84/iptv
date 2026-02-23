package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ayk extends ayl {
    final /* synthetic */ aym a;
    private final Callable c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ayk(aym aymVar, Callable callable, Executor executor) {
        super(aymVar, executor);
        this.a = aymVar;
        atp.k(callable);
        this.c = callable;
    }

    public final Object a() throws Exception {
        return this.c.call();
    }

    public final String b() {
        return this.c.toString();
    }

    public final void c(Object obj) {
        this.a.j(obj);
    }
}
