package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e0 extends U {
    public c a;
    public final int c;

    public e0(c cVar, int i) {
        this.a = cVar;
        this.c = i;
    }

    public final void R0(int i, IBinder iBinder, k0 k0Var) {
        c cVar = this.a;
        r.n(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        r.m(k0Var);
        c.zzj(cVar, k0Var);
        z(i, iBinder, k0Var.f);
    }

    public final void o0(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void z(int i, IBinder iBinder, Bundle bundle) {
        r.n(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.onPostInitHandler(i, iBinder, bundle, this.c);
        this.a = null;
    }
}
