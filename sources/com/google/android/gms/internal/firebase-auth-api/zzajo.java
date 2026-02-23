package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzajo implements Iterator {
    private Iterator zza;

    public zzajo(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        return entry.getValue() instanceof zzajn ? new zzajm(entry, null) : entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
