package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfr extends zzfl {
    private final transient zzfk zza;
    private final transient zzfh zzb;

    public zzfr(zzfk zzfkVar, zzfh zzfhVar) {
        this.zza = zzfkVar;
        this.zzb = zzfhVar;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzfh zzd() {
        return this.zzb;
    }

    public final zzfx zze() {
        return this.zzb.listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }
}
