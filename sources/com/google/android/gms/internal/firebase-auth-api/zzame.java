package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzame {
    public abstract int zza(Object obj);

    public abstract Object zza();

    public abstract Object zza(Object obj, Object obj2);

    public abstract void zza(Object obj, int i, int i2);

    public abstract void zza(Object obj, int i, long j);

    public abstract void zza(Object obj, int i, zzahp zzahpVar);

    public abstract void zza(Object obj, int i, Object obj2);

    public abstract void zza(Object obj, zzana zzanaVar) throws IOException;

    public abstract boolean zza(zzalc zzalcVar);

    public final boolean zza(Object obj, zzalc zzalcVar) throws IOException {
        int zzd = zzalcVar.zzd();
        int i = zzd >>> 3;
        int i2 = zzd & 7;
        if (i2 == 0) {
            zzb(obj, i, zzalcVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zza(obj, i, zzalcVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zza(obj, i, zzalcVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzaji.zza();
            }
            zza(obj, i, zzalcVar.zzf());
            return true;
        }
        Object zza = zza();
        int i3 = 4 | (i << 3);
        while (zzalcVar.zzc() != Integer.MAX_VALUE && zza(zza, zzalcVar)) {
        }
        if (i3 != zzalcVar.zzd()) {
            throw zzaji.zzb();
        }
        zza(obj, i, zze(zza));
        return true;
    }

    public abstract int zzb(Object obj);

    public abstract void zzb(Object obj, int i, long j);

    public abstract void zzb(Object obj, zzana zzanaVar) throws IOException;

    public abstract void zzb(Object obj, Object obj2);

    public abstract Object zzc(Object obj);

    public abstract void zzc(Object obj, Object obj2);

    public abstract Object zzd(Object obj);

    public abstract Object zze(Object obj);

    public abstract void zzf(Object obj);
}
