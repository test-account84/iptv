package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdo extends zzdq {
    private zzdo() {
        throw null;
    }

    public final void zza(Object obj, long j) {
        ((zzcz) zzfp.zzf(obj, j)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j) {
        zzcz zzczVar = (zzcz) zzfp.zzf(obj, j);
        zzcz zzczVar2 = (zzcz) zzfp.zzf(obj2, j);
        int size = zzczVar.size();
        int size2 = zzczVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzczVar.zzc()) {
                zzczVar = zzczVar.zzd(size2 + size);
            }
            zzczVar.addAll(zzczVar2);
        }
        if (size > 0) {
            zzczVar2 = zzczVar;
        }
        zzfp.zzs(obj, j, zzczVar2);
    }

    public /* synthetic */ zzdo(zzdn zzdnVar) {
        super(null);
    }
}
