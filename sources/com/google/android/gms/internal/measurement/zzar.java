package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzar implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzar(zzat zzatVar) {
        this.zza = zzatVar;
    }

    public final boolean hasNext() {
        return this.zzb < zzat.zzb(this.zza).length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        if (i >= zzat.zzb(this.zza).length()) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return new zzat(String.valueOf(i));
    }
}
