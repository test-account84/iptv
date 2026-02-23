package com.google.android.gms.internal.measurement;

import M4.O2;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdv extends zzch {
    private final O2 zza;

    public zzdv(O2 o2) {
        this.zza = o2;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.a(str, str2, bundle, j);
    }
}
