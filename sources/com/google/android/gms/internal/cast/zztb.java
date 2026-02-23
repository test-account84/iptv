package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztb extends zztd {
    private zztb() {
        super(null);
    }

    public final void zza(Object obj, long j) {
        ((zzsp) zzvb.zzf(obj, j)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j) {
        zzsp zzspVar = (zzsp) zzvb.zzf(obj, j);
        zzsp zzspVar2 = (zzsp) zzvb.zzf(obj2, j);
        int size = zzspVar.size();
        int size2 = zzspVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzspVar.zzc()) {
                zzspVar = zzspVar.zzg(size2 + size);
            }
            zzspVar.addAll(zzspVar2);
        }
        if (size > 0) {
            zzspVar2 = zzspVar;
        }
        zzvb.zzs(obj, j, zzspVar2);
    }

    public /* synthetic */ zztb(zzta zztaVar) {
        super(null);
    }
}
