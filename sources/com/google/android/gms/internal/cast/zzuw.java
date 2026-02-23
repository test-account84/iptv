package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuw extends AbstractList implements RandomAccess, zzsx {
    private final zzsx zza;

    public zzuw(zzsx zzsxVar) {
        this.zza = zzsxVar;
    }

    public static /* bridge */ /* synthetic */ zzsx zza(zzuw zzuwVar) {
        return zzuwVar.zza;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzsw) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzuv(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzuu(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzsx zzd() {
        return this;
    }

    public final Object zze(int i) {
        return this.zza.zze(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }
}
