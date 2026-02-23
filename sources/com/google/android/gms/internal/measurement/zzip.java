package com.google.android.gms.internal.measurement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzip implements zzim {
    private static final zzim zza = zzio.zza;
    private volatile zzim zzb;
    private Object zzc;

    public zzip(zzim zzimVar) {
        zzimVar.getClass();
        this.zzb = zzimVar;
    }

    public final String toString() {
        String str = this.zzb;
        if (str == zza) {
            str = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(str) + ")";
    }

    public final Object zza() {
        zzim zzimVar = this.zzb;
        zzim zzimVar2 = zza;
        if (zzimVar != zzimVar2) {
            synchronized (this) {
                try {
                    if (this.zzb != zzimVar2) {
                        Object zza2 = this.zzb.zza();
                        this.zzc = zza2;
                        this.zzb = zzimVar2;
                        return zza2;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
