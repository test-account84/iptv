package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzuv implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzuw zzb;

    public zzuv(zzuw zzuwVar) {
        this.zzb = zzuwVar;
        this.zza = zzuw.zza(zzuwVar).iterator();
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
