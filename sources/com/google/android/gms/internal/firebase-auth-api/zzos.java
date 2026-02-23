package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzos implements zzov {
    private final String zza;
    private final zzxt zzb;
    private final zzahp zzc;
    private final zzuy.zza zzd;
    private final zzvs zze;
    private final Integer zzf;

    private zzos(String str, zzahp zzahpVar, zzuy.zza zzaVar, zzvs zzvsVar, Integer num) {
        this.zza = str;
        this.zzb = zzpf.zzb(str);
        this.zzc = zzahpVar;
        this.zzd = zzaVar;
        this.zze = zzvsVar;
        this.zzf = num;
    }

    public static zzos zza(String str, zzahp zzahpVar, zzuy.zza zzaVar, zzvs zzvsVar, Integer num) throws GeneralSecurityException {
        if (zzvsVar == zzvs.zzd) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzos(str, zzahpVar, zzaVar, zzvsVar, num);
    }

    public final zzxt zzb() {
        return this.zzb;
    }

    public final zzvs zzc() {
        return this.zze;
    }

    public final zzahp zzd() {
        return this.zzc;
    }

    public final Integer zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zza;
    }

    public final zzuy.zza zza() {
        return this.zzd;
    }
}
