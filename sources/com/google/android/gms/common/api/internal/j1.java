package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j1 implements t0 {
    public final /* synthetic */ w a;

    public /* synthetic */ j1(w wVar, i1 i1Var) {
        this.a = wVar;
    }

    public final void a(Bundle bundle) {
        w.p(this.a).lock();
        try {
            w.r(this.a, w4.b.j);
            w.v(this.a);
        } finally {
            w.p(this.a).unlock();
        }
    }

    public final void b(w4.b bVar) {
        w.p(this.a).lock();
        try {
            w.r(this.a, bVar);
            w.v(this.a);
        } finally {
            w.p(this.a).unlock();
        }
    }

    public final void c(int i, boolean z) {
        w.p(this.a).lock();
        try {
            w wVar = this.a;
            if (w.w(wVar)) {
                w.s(wVar, false);
                w.t(this.a, i, z);
            } else {
                w.s(wVar, true);
                w.n(this.a).onConnectionSuspended(i);
            }
            w.p(this.a).unlock();
        } catch (Throwable th) {
            w.p(this.a).unlock();
            throw th;
        }
    }
}
