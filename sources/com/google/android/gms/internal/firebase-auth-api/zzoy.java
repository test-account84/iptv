package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzoy {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    private zzoy(zzox zzoxVar) {
        this.zza = new HashMap(zzox.zzb(zzoxVar));
        this.zzb = new HashMap(zzox.zza(zzoxVar));
        this.zzc = new HashMap(zzox.zzd(zzoxVar));
        this.zzd = new HashMap(zzox.zzc(zzoxVar));
    }

    public static /* bridge */ /* synthetic */ Map zzb(zzoy zzoyVar) {
        return zzoyVar.zza;
    }

    public static /* bridge */ /* synthetic */ Map zzc(zzoy zzoyVar) {
        return zzoyVar.zzd;
    }

    public static /* bridge */ /* synthetic */ Map zzd(zzoy zzoyVar) {
        return zzoyVar.zzc;
    }

    public final zzbt zza(zzov zzovVar, zzcs zzcsVar) throws GeneralSecurityException {
        zzpa zzpaVar = new zzpa(zzovVar.getClass(), zzovVar.zzb(), null);
        if (this.zzb.containsKey(zzpaVar)) {
            return ((zzmu) this.zzb.get(zzpaVar)).zza(zzovVar, zzcsVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + String.valueOf(zzpaVar) + " available");
    }

    public /* synthetic */ zzoy(zzox zzoxVar, zzpe zzpeVar) {
        this(zzoxVar);
    }

    public final zzch zza(zzov zzovVar) throws GeneralSecurityException {
        zzpa zzpaVar = new zzpa(zzovVar.getClass(), zzovVar.zzb(), null);
        if (this.zzd.containsKey(zzpaVar)) {
            return ((zznv) this.zzd.get(zzpaVar)).zza(zzovVar);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + String.valueOf(zzpaVar) + " available");
    }

    public final boolean zzb(zzov zzovVar) {
        return this.zzb.containsKey(new zzpa(zzovVar.getClass(), zzovVar.zzb(), null));
    }

    public final boolean zzc(zzov zzovVar) {
        return this.zzd.containsKey(new zzpa(zzovVar.getClass(), zzovVar.zzb(), null));
    }

    public final zzov zza(zzch zzchVar, Class cls) throws GeneralSecurityException {
        zzpc zzpcVar = new zzpc(zzchVar.getClass(), cls, null);
        if (this.zzc.containsKey(zzpcVar)) {
            return ((zznz) this.zzc.get(zzpcVar)).zza(zzchVar);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + String.valueOf(zzpcVar) + " available");
    }

    public static /* bridge */ /* synthetic */ Map zza(zzoy zzoyVar) {
        return zzoyVar.zzb;
    }
}
