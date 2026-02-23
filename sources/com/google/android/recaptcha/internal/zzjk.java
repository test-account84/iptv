package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzjk extends AbstractList implements RandomAccess, zzhg {
    private final zzhg zza;

    public zzjk(zzhg zzhgVar) {
        this.zza = zzhgVar;
    }

    public static /* bridge */ /* synthetic */ zzhg zza(zzjk zzjkVar) {
        return zzjkVar.zza;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzhf) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzjj(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzji(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzhg zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzez zzezVar) {
        throw new UnsupportedOperationException();
    }
}
