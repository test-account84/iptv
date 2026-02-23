package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h1 implements t0 {
    public final /* synthetic */ w a;

    public /* synthetic */ h1(w wVar, g1 g1Var) {
        this.a = wVar;
    }

    public final void a(Bundle bundle) {
        w.p(this.a).lock();
        try {
            w.u(this.a, bundle);
            w.q(this.a, w4.b.j);
            w.v(this.a);
        } finally {
            w.p(this.a).unlock();
        }
    }

    public final void b(w4.b bVar) {
        w.p(this.a).lock();
        try {
            w.q(this.a, bVar);
            w.v(this.a);
        } finally {
            w.p(this.a).unlock();
        }
    }

    public final void c(int i, boolean z) {
        w.p(this.a).lock();
        try {
            w wVar = this.a;
            if (w.w(wVar) || w.l(wVar) == null || !w.l(wVar).L()) {
                w.s(this.a, false);
                w.t(this.a, i, z);
            } else {
                w.s(this.a, true);
                w.o(this.a).onConnectionSuspended(i);
            }
            w.p(this.a).unlock();
        } catch (Throwable th) {
            w.p(this.a).unlock();
            throw th;
        }
    }
}
