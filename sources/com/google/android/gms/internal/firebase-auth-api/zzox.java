package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzox {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzox() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public static /* bridge */ /* synthetic */ Map zzb(zzox zzoxVar) {
        return zzoxVar.zza;
    }

    public static /* bridge */ /* synthetic */ Map zzc(zzox zzoxVar) {
        return zzoxVar.zzd;
    }

    public static /* bridge */ /* synthetic */ Map zzd(zzox zzoxVar) {
        return zzoxVar.zzc;
    }

    public final zzox zza(zzmu zzmuVar) throws GeneralSecurityException {
        zzpa zzpaVar = new zzpa(zzmuVar.zzb(), zzmuVar.zza(), null);
        if (this.zzb.containsKey(zzpaVar)) {
            zzmu zzmuVar2 = (zzmu) this.zzb.get(zzpaVar);
            if (!zzmuVar2.equals(zzmuVar) || !zzmuVar.equals(zzmuVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + String.valueOf(zzpaVar));
            }
        } else {
            this.zzb.put(zzpaVar, zzmuVar);
        }
        return this;
    }

    public zzox(zzoy zzoyVar) {
        this.zza = new HashMap(zzoy.zzb(zzoyVar));
        this.zzb = new HashMap(zzoy.zza(zzoyVar));
        this.zzc = new HashMap(zzoy.zzd(zzoyVar));
        this.zzd = new HashMap(zzoy.zzc(zzoyVar));
    }

    public final zzox zza(zzmx zzmxVar) throws GeneralSecurityException {
        zzpc zzpcVar = new zzpc(zzmxVar.zza(), zzmxVar.zzb(), null);
        if (this.zza.containsKey(zzpcVar)) {
            zzmx zzmxVar2 = (zzmx) this.zza.get(zzpcVar);
            if (!zzmxVar2.equals(zzmxVar) || !zzmxVar.equals(zzmxVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzpcVar));
            }
        } else {
            this.zza.put(zzpcVar, zzmxVar);
        }
        return this;
    }

    public final zzox zza(zznv zznvVar) throws GeneralSecurityException {
        zzpa zzpaVar = new zzpa(zznvVar.zzb(), zznvVar.zza(), null);
        if (this.zzd.containsKey(zzpaVar)) {
            zznv zznvVar2 = (zznv) this.zzd.get(zzpaVar);
            if (!zznvVar2.equals(zznvVar) || !zznvVar.equals(zznvVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + String.valueOf(zzpaVar));
            }
        } else {
            this.zzd.put(zzpaVar, zznvVar);
        }
        return this;
    }

    public final zzox zza(zznz zznzVar) throws GeneralSecurityException {
        zzpc zzpcVar = new zzpc(zznzVar.zza(), zznzVar.zzb(), null);
        if (this.zzc.containsKey(zzpcVar)) {
            zznz zznzVar2 = (zznz) this.zzc.get(zzpcVar);
            if (!zznzVar2.equals(zznzVar) || !zznzVar.equals(zznzVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzpcVar));
            }
        } else {
            this.zzc.put(zzpcVar, zznzVar);
        }
        return this;
    }

    public final zzoy zza() {
        return new zzoy(this, null);
    }

    public static /* bridge */ /* synthetic */ Map zza(zzox zzoxVar) {
        return zzoxVar.zzb;
    }
}
