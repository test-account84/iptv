package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzvg;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcb {
    private final zzvg.zza zza;

    private zzcb(zzvg.zza zzaVar) {
        this.zza = zzaVar;
    }

    private final synchronized int zza(zzvb zzvbVar, boolean z) throws GeneralSecurityException {
        zzvg.zzb zza;
        zza = zza(zzvbVar);
        this.zza.zza(zza);
        return zza.zza();
    }

    public static zzcb zzb() {
        return new zzcb(zzvg.zzc());
    }

    private final synchronized int zzc() {
        int zza;
        do {
            zza = zzpf.zza();
        } while (zzb(zza));
        return zza;
    }

    private final synchronized boolean zzb(int i) {
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            if (((zzvg.zzb) it.next()).zza() == i) {
                return true;
            }
        }
        return false;
    }

    public final synchronized zzbx zza() throws GeneralSecurityException {
        return zzbx.zza((zzvg) ((zzajc) this.zza.zzf()));
    }

    public final synchronized zzcb zza(int i) throws GeneralSecurityException {
        for (int i2 = 0; i2 < this.zza.zza(); i2++) {
            zzvg.zzb zzb = this.zza.zzb(i2);
            if (zzb.zza() == i) {
                if (!zzb.zzc().equals(zzuz.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                }
                this.zza.zza(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public final synchronized zzcb zza(zzbu zzbuVar) throws GeneralSecurityException {
        zza(zzbuVar.zza(), false);
        return this;
    }

    public static zzcb zza(zzbx zzbxVar) {
        return new zzcb((zzvg.zza) zzbxVar.zzb().zzn());
    }

    private final synchronized zzvg.zzb zza(zzuy zzuyVar, zzvs zzvsVar) throws GeneralSecurityException {
        int zzc;
        zzc = zzc();
        if (zzvsVar == zzvs.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzvg.zzb) ((zzajc) zzvg.zzb.zzd().zza(zzuyVar).zza(zzc).zza(zzuz.ENABLED).zza(zzvsVar).zzf());
    }

    private final synchronized zzvg.zzb zza(zzvb zzvbVar) throws GeneralSecurityException {
        return zza(zzct.zza(zzvbVar), zzvbVar.zzd());
    }
}
