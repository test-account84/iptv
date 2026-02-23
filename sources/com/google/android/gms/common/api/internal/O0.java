package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o0 implements c.c, I0 {
    public final a.f a;
    public final b b;
    public com.google.android.gms.common.internal.k c = null;
    public Set d = null;
    public boolean e = false;
    public final /* synthetic */ g f;

    public o0(g gVar, a.f fVar, b bVar) {
        this.f = gVar;
        this.a = fVar;
        this.b = bVar;
    }

    public static /* bridge */ /* synthetic */ a.f e(o0 o0Var) {
        return o0Var.a;
    }

    public static /* bridge */ /* synthetic */ b f(o0 o0Var) {
        return o0Var.b;
    }

    public static /* bridge */ /* synthetic */ void g(o0 o0Var, boolean z) {
        o0Var.e = true;
    }

    public static /* bridge */ /* synthetic */ void h(o0 o0Var) {
        o0Var.i();
    }

    public final void a(w4.b bVar) {
        k0 k0Var = (k0) g.z(this.f).get(this.b);
        if (k0Var != null) {
            k0Var.G(bVar);
        }
    }

    public final void b(com.google.android.gms.common.internal.k kVar, Set set) {
        if (kVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            a(new w4.b(4));
        } else {
            this.c = kVar;
            this.d = set;
            i();
        }
    }

    public final void c(w4.b bVar) {
        g.n(this.f).post(new n0(this, bVar));
    }

    public final void d(int i) {
        k0 k0Var = (k0) g.z(this.f).get(this.b);
        if (k0Var != null) {
            if (k0.K(k0Var)) {
                k0Var.G(new w4.b(17));
            } else {
                k0Var.onConnectionSuspended(i);
            }
        }
    }

    public final void i() {
        com.google.android.gms.common.internal.k kVar;
        if (!this.e || (kVar = this.c) == null) {
            return;
        }
        this.a.getRemoteService(kVar, this.d);
    }
}
