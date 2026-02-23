package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdt implements zzea {
    private final zzea[] zza;

    public zzdt(zzea... zzeaVarArr) {
        this.zza = zzeaVarArr;
    }

    public final zzdz zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzea zzeaVar = this.zza[i];
            if (zzeaVar.zzc(cls)) {
                return zzeaVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
