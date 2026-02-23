package com.google.android.gms.internal.measurement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzlu extends zzlw {
    private zzlu() {
        super(null);
    }

    public final void zza(Object obj, long j) {
        ((zzli) zznu.zzf(obj, j)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j) {
        zzli zzliVar = (zzli) zznu.zzf(obj, j);
        zzli zzliVar2 = (zzli) zznu.zzf(obj2, j);
        int size = zzliVar.size();
        int size2 = zzliVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzliVar.zzc()) {
                zzliVar = zzliVar.zzd(size2 + size);
            }
            zzliVar.addAll(zzliVar2);
        }
        if (size > 0) {
            zzliVar2 = zzliVar;
        }
        zznu.zzs(obj, j, zzliVar2);
    }

    public /* synthetic */ zzlu(zzlt zzltVar) {
        super(null);
    }
}
