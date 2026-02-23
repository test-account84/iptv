package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmq {
    private static final Logger zza = Logger.getLogger(zzmq.class.getName());
    private final ConcurrentMap zzb;
    private final ConcurrentMap zzc;

    public interface zza {
        zzbs zza();

        zzbs zza(Class cls) throws GeneralSecurityException;

        Class zzb();

        Set zzc();
    }

    public zzmq() {
        this.zzb = new ConcurrentHashMap();
        this.zzc = new ConcurrentHashMap();
    }

    private final synchronized zza zzc(String str) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (zza) this.zzb.get(str);
    }

    public final zzbs zza(String str) throws GeneralSecurityException {
        return zzc(str).zza();
    }

    public final boolean zzb(String str) {
        return ((Boolean) this.zzc.get(str)).booleanValue();
    }

    public zzmq(zzmq zzmqVar) {
        this.zzb = new ConcurrentHashMap(zzmqVar.zzb);
        this.zzc = new ConcurrentHashMap(zzmqVar.zzc);
    }

    public final zzbs zza(String str, Class cls) throws GeneralSecurityException {
        zza zzc = zzc(str);
        if (zzc.zzc().contains(cls)) {
            return zzc.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzc.zzb());
        Set<Class> zzc2 = zzc.zzc();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : zzc2) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb.toString());
    }

    private static zza zza(zznb zznbVar) {
        return new zzmt(zznbVar);
    }

    private final synchronized void zza(zza zzaVar, boolean z, boolean z2) throws GeneralSecurityException {
        try {
            String zza2 = zzaVar.zza().zza();
            if (z2 && this.zzc.containsKey(zza2) && !((Boolean) this.zzc.get(zza2)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + zza2);
            }
            zza zzaVar2 = (zza) this.zzb.get(zza2);
            if (zzaVar2 != null && !zzaVar2.zzb().equals(zzaVar.zzb())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type " + zza2);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zza2, zzaVar2.zzb().getName(), zzaVar.zzb().getName()}));
            }
            if (z) {
                this.zzb.put(zza2, zzaVar);
            } else {
                this.zzb.putIfAbsent(zza2, zzaVar);
            }
            this.zzc.put(zza2, Boolean.valueOf(z2));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zza(zznb zznbVar, boolean z) throws GeneralSecurityException {
        if (!zznbVar.zzb().zza()) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zznbVar.getClass()) + " as it is not FIPS compatible.");
        }
        zza(zza(zznbVar), false, true);
    }

    public final synchronized void zza(zzop zzopVar, zznb zznbVar, boolean z) throws GeneralSecurityException {
        zzif.zza zzb = zzopVar.zzb();
        zzif.zza zzb2 = zznbVar.zzb();
        if (!zzb.zza()) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzopVar.getClass()) + " as it is not FIPS compatible.");
        }
        if (!zzb2.zza()) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zznbVar.getClass()) + " as it is not FIPS compatible.");
        }
        zza((zza) new zzms(zzopVar, zznbVar), true, true);
        zza(zza(zznbVar), false, false);
    }
}
