package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfj implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzfk zzb;

    public zzfj(zzfk zzfkVar) {
        this.zzb = zzfkVar;
        this.zza = zzfk.zza(zzfkVar).iterator();
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
