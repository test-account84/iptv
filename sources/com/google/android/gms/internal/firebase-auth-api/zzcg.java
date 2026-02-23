package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcg {
    private final ConcurrentMap zza;
    private final List zzb;
    private zzcl zzc;
    private final Class zzd;
    private final zzrn zze;
    private final boolean zzf;

    private zzcg(ConcurrentMap concurrentMap, List list, zzcl zzclVar, zzrn zzrnVar, Class cls) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzclVar;
        this.zzd = cls;
        this.zze = zzrnVar;
        this.zzf = false;
    }

    public final zzcl zza() {
        return this.zzc;
    }

    public final zzrn zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze() {
        return zza(zzbn.zza);
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }

    public /* synthetic */ zzcg(ConcurrentMap concurrentMap, List list, zzcl zzclVar, zzrn zzrnVar, Class cls, zzcm zzcmVar) {
        this(concurrentMap, list, zzclVar, zzrnVar, cls);
    }

    public final List zza(byte[] bArr) {
        List list = (List) this.zza.get(new zzck(bArr, null));
        return list != null ? list : Collections.emptyList();
    }
}
