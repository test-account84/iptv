package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdt implements Iterator {
    boolean zza = true;
    final /* synthetic */ Iterator zzb;

    public zzdt(zzdu zzduVar, Iterator it) {
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Object next = this.zzb.next();
        this.zza = false;
        return next;
    }

    public final void remove() {
        zzdi.zze(!this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
    }
}
