package com.google.android.gms.internal.cast;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import y5.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzqd extends AbstractExecutorService implements zzqp {
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzqw.zzn(runnable, obj);
    }

    public final /* synthetic */ Future submit(Runnable runnable) {
        return (b) super.submit(runnable);
    }

    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzqw(callable);
    }

    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (b) super.submit(runnable, obj);
    }

    public final /* synthetic */ Future submit(Callable callable) {
        return (b) super.submit(callable);
    }
}
