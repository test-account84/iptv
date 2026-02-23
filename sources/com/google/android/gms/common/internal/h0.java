package com.google.android.gms.common.internal;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h0 extends S {
    public final /* synthetic */ c g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(c cVar, int i, Bundle bundle) {
        super(cVar, i, null);
        this.g = cVar;
    }

    public final void f(w4.b bVar) {
        if (this.g.enableLocalFallback() && c.zzo(this.g)) {
            c.zzk(this.g, 16);
        } else {
            this.g.zzc.c(bVar);
            this.g.onConnectionFailed(bVar);
        }
    }

    public final boolean g() {
        this.g.zzc.c(w4.b.j);
        return true;
    }
}
