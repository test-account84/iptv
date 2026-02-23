package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzvb;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcy {
    public static final zzvb zzb;
    private static final zzvb zzf;
    private static final zzvb zzg;
    private static final zzvb zzh;
    public static final zzvb zza = zza(16);
    private static final zzvb zzc = zza(32);
    private static final zzvb zzd = zza(16, 16);
    private static final zzvb zze = zza(32, 16);

    static {
        zzub zzubVar = zzub.SHA256;
        zzb = zza(16, 16, 32, 16, zzubVar);
        zzf = zza(32, 16, 32, 32, zzubVar);
        zzvb.zza zza2 = zzvb.zza().zza(new zzfu().zze());
        zzvs zzvsVar = zzvs.TINK;
        zzg = (zzvb) ((zzajc) zza2.zza(zzvsVar).zzf());
        zzh = (zzvb) ((zzajc) zzvb.zza().zza(new zzhj().zze()).zza(zzvsVar).zzf());
    }

    private static zzvb zza(int i) {
        return (zzvb) ((zzajc) zzvb.zza().zza(((zzsv) ((zzajc) zzsv.zzc().zza(i).zzf())).zzi()).zza(new zzeo().zze()).zza(zzvs.TINK).zzf());
    }

    private static zzvb zza(int i, int i2) {
        return (zzvb) ((zzajc) zzvb.zza().zza(((zzsq) ((zzajc) zzsq.zzb().zza(i).zza((zzsr) ((zzajc) zzsr.zzb().zza(16).zzf())).zzf())).zzi()).zza(new zzdz().zze()).zza(zzvs.TINK).zzf());
    }

    private static zzvb zza(int i, int i2, int i3, int i4, zzub zzubVar) {
        zzsj zzsjVar = (zzsj) ((zzajc) zzsj.zzb().zza((zzsm) ((zzajc) zzsm.zzb().zza(16).zzf())).zza(i).zzf());
        return (zzvb) ((zzajc) zzvb.zza().zza(((zzsf) ((zzajc) zzsf.zza().zza(zzsjVar).zza((zzug) ((zzajc) zzug.zzc().zza((zzuh) ((zzajc) zzuh.zzc().zza(zzubVar).zza(i4).zzf())).zza(32).zzf())).zzf())).zzi()).zza(new zzdi().zze()).zza(zzvs.TINK).zzf());
    }
}
