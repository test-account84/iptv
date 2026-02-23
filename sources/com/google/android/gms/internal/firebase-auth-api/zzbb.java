package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbb extends zzau {
    private final transient zzat zza;
    private final transient zzap zzb;

    public zzbb(zzat zzatVar, zzap zzapVar) {
        this.zza = zzatVar;
        this.zzb = zzapVar;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final zzap zzc() {
        return this.zzb;
    }

    public final zzbc zzd() {
        return (zzbc) zzc().iterator();
    }

    public final boolean zze() {
        return true;
    }
}
