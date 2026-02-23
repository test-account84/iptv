package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcl {
    private final Object zza;
    private final Object zzb;
    private final byte[] zzc;
    private final zzuz zzd;
    private final zzvs zze;
    private final int zzf;
    private final String zzg;
    private final zzbt zzh;

    public zzcl(Object obj, Object obj2, byte[] bArr, zzuz zzuzVar, zzvs zzvsVar, int i, String str, zzbt zzbtVar) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzd = zzuzVar;
        this.zze = zzvsVar;
        this.zzf = i;
        this.zzg = str;
        this.zzh = zzbtVar;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzbt zzb() {
        return this.zzh;
    }

    public final zzuz zzc() {
        return this.zzd;
    }

    public final zzvs zzd() {
        return this.zze;
    }

    public final Object zze() {
        return this.zza;
    }

    public final Object zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final byte[] zzh() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
