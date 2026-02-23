package com.google.android.gms.internal.measurement;

import M4.P2;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdw extends zzch {
    private final P2 zza;

    public zzdw(P2 p2) {
        this.zza = p2;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.a(str, str2, bundle, j);
    }
}
