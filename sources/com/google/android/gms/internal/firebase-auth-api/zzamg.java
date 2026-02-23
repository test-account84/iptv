package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzamg extends zzame {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzamd) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzamd) obj).zzb();
    }

    public final /* synthetic */ Object zzc(Object obj) {
        zzamd zzamdVar = ((zzajc) obj).zzb;
        if (zzamdVar != zzamd.zzc()) {
            return zzamdVar;
        }
        zzamd zzd = zzamd.zzd();
        zza(obj, zzd);
        return zzd;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzajc) obj).zzb;
    }

    public final /* synthetic */ Object zze(Object obj) {
        zzamd zzamdVar = (zzamd) obj;
        zzamdVar.zze();
        return zzamdVar;
    }

    public final void zzf(Object obj) {
        ((zzajc) obj).zzb.zze();
    }

    public final /* synthetic */ Object zza() {
        return zzamd.zzd();
    }

    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzamd) obj).zza(i << 3, Long.valueOf(j));
    }

    public final /* synthetic */ void zzc(Object obj, Object obj2) {
        zza(obj, (zzamd) obj2);
    }

    public final /* synthetic */ Object zza(Object obj, Object obj2) {
        zzamd zzamdVar = (zzamd) obj;
        zzamd zzamdVar2 = (zzamd) obj2;
        return zzamd.zzc().equals(zzamdVar2) ? zzamdVar : zzamd.zzc().equals(zzamdVar) ? zzamd.zza(zzamdVar, zzamdVar2) : zzamdVar.zza(zzamdVar2);
    }

    public final /* synthetic */ void zzb(Object obj, zzana zzanaVar) throws IOException {
        ((zzamd) obj).zzb(zzanaVar);
    }

    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzamd) obj).zza((i << 3) | 5, Integer.valueOf(i2));
    }

    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzamd) obj2);
    }

    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzamd) obj).zza((i << 3) | 1, Long.valueOf(j));
    }

    public final /* synthetic */ void zza(Object obj, int i, zzahp zzahpVar) {
        ((zzamd) obj).zza((i << 3) | 2, zzahpVar);
    }

    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzamd) obj).zza((i << 3) | 3, (zzamd) obj2);
    }

    private static void zza(Object obj, zzamd zzamdVar) {
        ((zzajc) obj).zzb = zzamdVar;
    }

    public final /* synthetic */ void zza(Object obj, zzana zzanaVar) throws IOException {
        ((zzamd) obj).zza(zzanaVar);
    }

    public final boolean zza(zzalc zzalcVar) {
        return false;
    }
}
