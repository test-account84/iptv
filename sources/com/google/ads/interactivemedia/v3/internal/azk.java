package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azk extends ayz implements RunnableFuture {
    private volatile azc b;

    public azk(Callable callable) {
        super((char[]) null);
        this.b = new azj(this, callable);
    }

    public static azk p(Callable callable) {
        return new azk(callable);
    }

    public static azk q(Runnable runnable, Object obj) {
        return new azk(Executors.callable(runnable, obj));
    }

    public final String e() {
        azc azcVar = this.b;
        if (azcVar == null) {
            return super.e();
        }
        return "task=[" + azcVar + "]";
    }

    public final void h() {
        azc azcVar;
        if (k() && (azcVar = this.b) != null) {
            azcVar.h();
        }
        this.b = null;
    }

    public final void run() {
        azc azcVar = this.b;
        if (azcVar != null) {
            azcVar.run();
        }
        this.b = null;
    }
}
