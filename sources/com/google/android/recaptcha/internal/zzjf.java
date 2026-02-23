package com.google.android.recaptcha.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzjf {
    public abstract int zza(Object obj);

    public abstract int zzb(Object obj);

    public abstract Object zzc(Object obj);

    public abstract Object zzd(Object obj);

    public abstract Object zze(Object obj, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract void zzh(Object obj, int i, int i2);

    public abstract void zzi(Object obj, int i, long j);

    public abstract void zzj(Object obj, int i, Object obj2);

    public abstract void zzk(Object obj, int i, zzez zzezVar);

    public abstract void zzl(Object obj, int i, long j);

    public abstract void zzm(Object obj);

    public abstract void zzn(Object obj, Object obj2);

    public abstract void zzo(Object obj, Object obj2);

    public abstract void zzp(Object obj, zzjx zzjxVar) throws IOException;

    public abstract void zzq(Object obj, zzjx zzjxVar) throws IOException;

    public final boolean zzr(Object obj, zzik zzikVar) throws IOException {
        int zzd = zzikVar.zzd();
        int i = zzd >>> 3;
        int i2 = zzd & 7;
        if (i2 == 0) {
            zzl(obj, i, zzikVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zzi(obj, i, zzikVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzk(obj, i, zzikVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzgy.zza();
            }
            zzh(obj, i, zzikVar.zzf());
            return true;
        }
        Object zzf = zzf();
        int i3 = i << 3;
        while (zzikVar.zzc() != Integer.MAX_VALUE && zzr(zzf, zzikVar)) {
        }
        if ((4 | i3) != zzikVar.zzd()) {
            throw zzgy.zzb();
        }
        zzg(zzf);
        zzj(obj, i, zzf);
        return true;
    }

    public abstract boolean zzs(zzik zzikVar);
}
