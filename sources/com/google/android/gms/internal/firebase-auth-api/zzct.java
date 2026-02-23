package com.google.android.gms.internal.firebase-auth-api;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzct {
    private static final Logger zza = Logger.getLogger(zzct.class.getName());
    private static final AtomicReference zzb = new AtomicReference(new zzmq());
    private static final ConcurrentMap zzc = new ConcurrentHashMap();
    private static final Set zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(zzbg.class);
        hashSet.add(zzbp.class);
        hashSet.add(zzcv.class);
        hashSet.add(zzbr.class);
        hashSet.add(zzbo.class);
        hashSet.add(zzce.class);
        hashSet.add(zzrx.class);
        hashSet.add(zzcr.class);
        hashSet.add(zzcq.class);
        zzd = Collections.unmodifiableSet(hashSet);
    }

    private zzct() {
    }

    @Deprecated
    private static zzbs zza(String str) throws GeneralSecurityException {
        return ((zzmq) zzb.get()).zza(str);
    }

    public static synchronized zzuy zza(zzvb zzvbVar) throws GeneralSecurityException {
        zzuy zza2;
        synchronized (zzct.class) {
            AtomicReference atomicReference = zzb;
            zzbs zza3 = ((zzmq) atomicReference.get()).zza(zzvbVar.zzf());
            if (!((zzmq) atomicReference.get()).zzb(zzvbVar.zzf())) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + zzvbVar.zzf());
            }
            zza2 = zza3.zza(zzvbVar.zze());
        }
        return zza2;
    }

    public static zzuy zza(String str, zzahp zzahpVar) throws GeneralSecurityException {
        zzbs zza2 = zza(str);
        if (zza2 instanceof zzco) {
            return ((zzco) zza2).zzc(zzahpVar);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    public static Class zza(Class cls) {
        try {
            return zznr.zza().zza(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zza(zzcg zzcgVar, Class cls) throws GeneralSecurityException {
        return zznr.zza().zza(zzcgVar, cls);
    }

    @Deprecated
    public static Object zza(zzuy zzuyVar) throws GeneralSecurityException {
        String zzf = zzuyVar.zzf();
        return zza(zzf).zzb(zzuyVar.zze());
    }

    public static Object zza(zzuy zzuyVar, Class cls) throws GeneralSecurityException {
        return zza(zzuyVar.zzf(), zzuyVar.zze(), cls);
    }

    public static Object zza(String str, zzahp zzahpVar, Class cls) throws GeneralSecurityException {
        return ((zzmq) zzb.get()).zza(str, cls).zzb(zzahpVar);
    }

    public static Object zza(String str, byte[] bArr, Class cls) throws GeneralSecurityException {
        return zza(str, zzahp.zza(bArr), cls);
    }

    public static synchronized void zza(zzcp zzcpVar) throws GeneralSecurityException {
        synchronized (zzct.class) {
            zznr.zza().zza(zzcpVar);
        }
    }

    public static synchronized void zza(zznb zznbVar, boolean z) throws GeneralSecurityException {
        synchronized (zzct.class) {
            AtomicReference atomicReference = zzb;
            zzmq zzmqVar = new zzmq((zzmq) atomicReference.get());
            zzmqVar.zza(zznbVar, true);
            atomicReference.set(zzmqVar);
        }
    }

    public static synchronized void zza(zzop zzopVar, zznb zznbVar, boolean z) throws GeneralSecurityException {
        synchronized (zzct.class) {
            AtomicReference atomicReference = zzb;
            zzmq zzmqVar = new zzmq((zzmq) atomicReference.get());
            zzmqVar.zza(zzopVar, zznbVar, true);
            atomicReference.set(zzmqVar);
        }
    }
}
