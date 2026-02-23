package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzno implements Iterator {
    final Iterator zza;
    final /* synthetic */ zznp zzb;

    public zzno(zznp zznpVar) {
        this.zzb = zznpVar;
        this.zza = zznp.zza(zznpVar).iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
