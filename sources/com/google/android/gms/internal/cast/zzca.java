package com.google.android.gms.internal.cast;

import android.view.View;
import o4.e;
import r4.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzca extends a {
    private final View zza;

    public zzca(View view) {
        this.zza = view;
        view.setEnabled(false);
    }

    public final void onSessionConnected(e eVar) {
        super.onSessionConnected(eVar);
        this.zza.setEnabled(true);
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
