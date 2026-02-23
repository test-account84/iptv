package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ho implements gp {
    private final bn a;
    private boolean b;
    private long c;
    private long d;
    private au e = au.a;

    public ho(bn bnVar) {
        this.a = bnVar;
    }

    public final long a() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.d;
        au auVar = this.e;
        return j + (auVar.b == 1.0f ? cq.t(elapsedRealtime) : auVar.a(elapsedRealtime));
    }

    public final void b(long j) {
        this.c = j;
        if (this.b) {
            this.d = SystemClock.elapsedRealtime();
        }
    }

    public final au c() {
        return this.e;
    }

    public final void d() {
        if (this.b) {
            return;
        }
        this.d = SystemClock.elapsedRealtime();
        this.b = true;
    }

    public final void e() {
        if (this.b) {
            b(a());
            this.b = false;
        }
    }

    public final void g(au auVar) {
        if (this.b) {
            b(a());
        }
        this.e = auVar;
    }
}
