package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzajx extends zzajs {
    private zzajx() {
        super(null);
    }

    private static zzajj zzc(Object obj, long j) {
        return (zzajj) zzamk.zze(obj, j);
    }

    public final List zza(Object obj, long j) {
        zzajj zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzajj zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzamk.zza(obj, j, zza);
        return zza;
    }

    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    public /* synthetic */ zzajx(zzajw zzajwVar) {
        this();
    }

    public final void zza(Object obj, Object obj2, long j) {
        zzajj zzc = zzc(obj, j);
        zzajj zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzamk.zza(obj, j, zzc2);
    }
}
