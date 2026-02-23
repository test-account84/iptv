package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzamh implements Iterator {
    private Iterator zza;
    private final /* synthetic */ zzamf zzb;

    public zzamh(zzamf zzamfVar) {
        this.zzb = zzamfVar;
        this.zza = zzamf.zza(zzamfVar).iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
