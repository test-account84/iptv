package com.google.android.gms.common.api.internal;

import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ w4.b a;
    public final /* synthetic */ o0 c;

    public n0(o0 o0Var, w4.b bVar) {
        this.c = o0Var;
        this.a = bVar;
    }

    public final void run() {
        o0 o0Var = this.c;
        k0 k0Var = (k0) g.z(o0Var.f).get(o0.f(o0Var));
        if (k0Var == null) {
            return;
        }
        if (!this.a.L()) {
            k0Var.F(this.a, null);
            return;
        }
        o0.g(this.c, true);
        if (o0.e(this.c).requiresSignIn()) {
            o0.h(this.c);
            return;
        }
        try {
            o0 o0Var2 = this.c;
            o0.e(o0Var2).getRemoteService(null, o0.e(o0Var2).getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            o0.e(this.c).disconnect("Failed to get service from broker.");
            k0Var.F(new w4.b(10), null);
        }
    }
}
