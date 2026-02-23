package com.google.android.gms.internal.cast;

import android.content.Context;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzax {
    public L zza;
    private final Context zzb;

    public zzax(Context context) {
        this.zzb = context;
    }

    public final L zza() {
        if (this.zza == null) {
            this.zza = L.j(this.zzb);
        }
        return this.zza;
    }

    public final void zzb(L.a aVar) {
        L zza = zza();
        if (zza != null) {
            zza.s(aVar);
        }
    }
}
