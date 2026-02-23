package com.google.android.gms.common.api.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ j0 a;

    public i0(j0 j0Var) {
        this.a = j0Var;
    }

    public final void run() {
        k0 k0Var = this.a.a;
        k0.r(k0Var).disconnect(k0.r(k0Var).getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
