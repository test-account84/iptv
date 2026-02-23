package com.google.android.gms.internal.cast;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzut extends zzur {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzus) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzus) obj).zzb();
    }

    public final /* synthetic */ Object zzc(Object obj) {
        return ((zzsh) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zzd(Object obj, Object obj2) {
        if (zzus.zzc().equals(obj2)) {
            return obj;
        }
        zzus zzusVar = (zzus) obj2;
        if (zzus.zzc().equals(obj)) {
            return zzus.zze((zzus) obj, zzusVar);
        }
        ((zzus) obj).zzd(zzusVar);
        return obj;
    }

    public final void zze(Object obj) {
        ((zzsh) obj).zzc.zzf();
    }

    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zzsh) obj).zzc = (zzus) obj2;
    }

    public final /* synthetic */ void zzg(Object obj, zzvi zzviVar) throws IOException {
    }
}
