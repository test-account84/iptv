package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzi implements Iterator {
    private int zza = zzh.zzb;
    private Object zzb;

    public final boolean hasNext() {
        int i = this.zza;
        int i2 = zzh.zzd;
        if (i == i2) {
            throw new IllegalStateException();
        }
        int i3 = i - 1;
        if (i3 == 0) {
            return true;
        }
        if (i3 != 2) {
            this.zza = i2;
            this.zzb = zza();
            if (this.zza != zzh.zzc) {
                this.zza = zzh.zza;
                return true;
            }
        }
        return false;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.zza = zzh.zzb;
        Object obj = this.zzb;
        this.zzb = null;
        return obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public abstract Object zza();

    public final Object zzb() {
        this.zza = zzh.zzc;
        return null;
    }
}
