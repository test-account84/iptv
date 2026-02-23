package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class anu implements ThreadFactory {
    private final ThreadFactory a = Executors.defaultThreadFactory();
    private final AtomicInteger b = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.a.newThread(runnable);
        newThread.setName("gads-" + this.b.getAndIncrement());
        return newThread;
    }
}
