package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzakc implements zzakk {
    private zzakk[] zza;

    public zzakc(zzakk... zzakkVarArr) {
        this.zza = zzakkVarArr;
    }

    public final zzakl zza(Class cls) {
        for (zzakk zzakkVar : this.zza) {
            if (zzakkVar.zzb(cls)) {
                return zzakkVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    public final boolean zzb(Class cls) {
        for (zzakk zzakkVar : this.zza) {
            if (zzakkVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
