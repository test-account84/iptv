package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class ayl extends azc {
    private final Executor a;
    final /* synthetic */ aym b;

    public ayl(aym aymVar, Executor executor) {
        this.b = aymVar;
        atp.k(executor);
        this.a = executor;
    }

    public abstract void c(Object obj);

    public final void d(Throwable th) {
        aym.w(this.b);
        if (th instanceof ExecutionException) {
            this.b.o(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.b.cancel(false);
        } else {
            this.b.o(th);
        }
    }

    public final void e(Object obj) {
        aym.w(this.b);
        c(obj);
    }

    public final void f() {
        try {
            this.a.execute(this);
        } catch (RejectedExecutionException e) {
            this.b.o(e);
        }
    }

    public final boolean g() {
        return this.b.isDone();
    }
}
