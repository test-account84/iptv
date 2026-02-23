package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahw {
    private final BlockingQueue a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque c = new ArrayDeque();
    private ahv d = null;

    public ahw() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void c() {
        ahv ahvVar = (ahv) this.c.poll();
        this.d = ahvVar;
        if (ahvVar != null) {
            ahvVar.executeOnExecutor(this.b, new Object[0]);
        }
    }

    public final void a(ahv ahvVar) {
        ahvVar.b(this);
        this.c.add(ahvVar);
        if (this.d == null) {
            c();
        }
    }

    public final void b() {
        this.d = null;
        c();
    }
}
