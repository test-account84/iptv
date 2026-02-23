package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzas implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    public final boolean hasNext() {
        return this.zzb < zzat.zzb(this.zza).length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        zzat zzatVar = this.zza;
        if (i >= zzat.zzb(zzatVar).length()) {
            throw new NoSuchElementException();
        }
        String zzb = zzat.zzb(zzatVar);
        this.zzb = i + 1;
        return new zzat(String.valueOf(zzb.charAt(i)));
    }
}
