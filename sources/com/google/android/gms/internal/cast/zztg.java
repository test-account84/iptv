package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztg implements zztn {
    private final zztn[] zza;

    public zztg(zztn... zztnVarArr) {
        this.zza = zztnVarArr;
    }

    public final zztm zzb(Class cls) {
        zztn[] zztnVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zztn zztnVar = zztnVarArr[i];
            if (zztnVar.zzc(cls)) {
                return zztnVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zztn[] zztnVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zztnVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
