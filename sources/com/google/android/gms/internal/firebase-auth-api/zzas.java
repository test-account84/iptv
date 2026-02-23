package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzas {
    zzav zza;
    private Object[] zzb;
    private int zzc;
    private boolean zzd;

    public zzas() {
        this(4);
    }

    public final zzas zza(Iterable iterable) {
        if (iterable instanceof Collection) {
            zza(this.zzc + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            zza(this.zzc + 1);
            zzai.zza(key, value);
            Object[] objArr = this.zzb;
            int i = this.zzc;
            objArr[i * 2] = key;
            objArr[(i * 2) + 1] = value;
            this.zzc = i + 1;
        }
        return this;
    }

    public zzas(int i) {
        this.zzb = new Object[i * 2];
        this.zzc = 0;
        this.zzd = false;
    }

    public final zzat zza() {
        zzav zzavVar = this.zza;
        if (zzavVar != null) {
            throw zzavVar.zza();
        }
        int i = this.zzc;
        Object[] objArr = this.zzb;
        this.zzd = true;
        zzaw zza = zzaw.zza(i, objArr, this);
        zzav zzavVar2 = this.zza;
        if (zzavVar2 == null) {
            return zza;
        }
        throw zzavVar2.zza();
    }

    private final void zza(int i) {
        int i2 = i << 1;
        Object[] objArr = this.zzb;
        if (i2 > objArr.length) {
            this.zzb = Arrays.copyOf(objArr, zzam.zza(objArr.length, i2));
            this.zzd = false;
        }
    }
}
