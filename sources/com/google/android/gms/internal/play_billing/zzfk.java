package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfk extends AbstractList implements RandomAccess, zzdk {
    private final zzdk zza;

    public zzfk(zzdk zzdkVar) {
        this.zza = zzdkVar;
    }

    public static /* bridge */ /* synthetic */ zzdk zza(zzfk zzfkVar) {
        return zzfkVar.zza;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzdj) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzfj(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzfi(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzdk zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }
}
