package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e1 implements GoogleApiClient.b, GoogleApiClient.c {
    public final com.google.android.gms.common.api.a a;
    public final boolean c;
    public f1 d;

    public e1(com.google.android.gms.common.api.a aVar, boolean z) {
        this.a = aVar;
        this.c = z;
    }

    public final void a(f1 f1Var) {
        this.d = f1Var;
    }

    public final f1 b() {
        com.google.android.gms.common.internal.r.n(this.d, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.d;
    }

    public final void onConnected(Bundle bundle) {
        b().onConnected(bundle);
    }

    public final void onConnectionFailed(w4.b bVar) {
        b().A(bVar, this.a, this.c);
    }

    public final void onConnectionSuspended(int i) {
        b().onConnectionSuspended(i);
    }
}
