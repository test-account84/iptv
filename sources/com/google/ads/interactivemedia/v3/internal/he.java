package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class he {
    private final hd a;
    private final hc b;
    private final bn c;
    private final be d;
    private int e;
    private Object f;
    private final Looper g;
    private final int h;
    private final long i = -9223372036854775807L;
    private final boolean j = true;
    private boolean k;
    private boolean l;
    private boolean m;

    public he(hc hcVar, hd hdVar, be beVar, int i, bn bnVar, Looper looper) {
        this.b = hcVar;
        this.a = hdVar;
        this.d = beVar;
        this.g = looper;
        this.c = bnVar;
        this.h = i;
    }

    public final int a() {
        return this.h;
    }

    public final int b() {
        return this.e;
    }

    public final long c() {
        return -9223372036854775807L;
    }

    public final Looper d() {
        return this.g;
    }

    public final be e() {
        return this.d;
    }

    public final hd f() {
        return this.a;
    }

    public final Object g() {
        return this.f;
    }

    public final synchronized void h(boolean z) {
        this.l = z | this.l;
        this.m = true;
        notifyAll();
    }

    public final boolean i() {
        return true;
    }

    public final synchronized void j(long j) throws InterruptedException, TimeoutException {
        try {
            af.w(this.k);
            af.w(this.g.getThread() != Thread.currentThread());
            long elapsedRealtime = SystemClock.elapsedRealtime() + j;
            while (!this.m) {
                if (j <= 0) {
                    throw new TimeoutException("Message delivery timed out.");
                }
                wait(j);
                j = elapsedRealtime - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k() {
    }

    public final void l() {
        af.w(!this.k);
        af.u(true);
        this.k = true;
        this.b.m(this);
    }

    public final void m(Object obj) {
        af.w(!this.k);
        this.f = obj;
    }

    public final void n(int i) {
        af.w(!this.k);
        this.e = i;
    }
}
