package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ayp extends auv implements Future, azd {
    public ayp() {
    }

    public /* bridge */ /* synthetic */ Object a() {
        throw null;
    }

    public abstract azd b();

    public /* bridge */ /* synthetic */ Future c() {
        throw null;
    }

    public boolean cancel(boolean z) {
        return c().cancel(z);
    }

    public final void g(Runnable runnable, Executor executor) {
        b().g(runnable, executor);
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return c().get();
    }

    public final boolean isCancelled() {
        return c().isCancelled();
    }

    public final boolean isDone() {
        return c().isDone();
    }

    public ayp(byte[] bArr) {
        this();
    }

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return c().get(j, timeUnit);
    }
}
