package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzjj implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzjk zzb;

    public zzjj(zzjk zzjkVar) {
        this.zzb = zzjkVar;
        this.zza = zzjk.zza(zzjkVar).iterator();
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
