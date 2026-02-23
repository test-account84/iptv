package com.google.android.gms.internal.firebase-auth-api;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzamf extends AbstractList implements zzajt, RandomAccess {
    private final zzajt zza;

    public zzamf(zzajt zzajtVar) {
        this.zza = zzajtVar;
    }

    public static /* bridge */ /* synthetic */ zzajt zza(zzamf zzamfVar) {
        return zzamfVar.zza;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    public final Iterator iterator() {
        return new zzamh(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzami(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final zzajt zzd() {
        return this;
    }

    public final List zze() {
        return this.zza.zze();
    }

    public final void zza(zzahp zzahpVar) {
        throw new UnsupportedOperationException();
    }
}
