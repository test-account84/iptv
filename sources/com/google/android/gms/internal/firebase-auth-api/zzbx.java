package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzuy;
import com.google.android.gms.internal.firebase-auth-api.zzvg;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbx {
    private final zzvg zza;
    private final List zzb;
    private final zzrn zzc = zzrn.zza;

    private zzbx(zzvg zzvgVar, List list) {
        this.zza = zzvgVar;
        this.zzb = list;
    }

    public final String toString() {
        return zzcx.zza(this.zza).toString();
    }

    public final zzbx zza() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        zzvg.zza zzc = zzvg.zzc();
        for (zzvg.zzb zzbVar : this.zza.zze()) {
            zzuy zzb = zzbVar.zzb();
            if (zzb.zzb() != zzuy.zza.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("The keyset contains a non-private key");
            }
            zzuy zza = zzct.zza(zzb.zzf(), zzb.zze());
            zzct.zza(zza);
            zzc.zza((zzvg.zzb) ((zzajc) ((zzvg.zzb.zza) zzbVar.zzn()).zza(zza).zzf()));
        }
        zzc.zza(this.zza.zzb());
        return zza((zzvg) ((zzajc) zzc.zzf()));
    }

    public final zzvg zzb() {
        return this.zza;
    }

    public final zzvj zzc() {
        return zzcx.zza(this.zza);
    }

    public static final zzbx zza(zzca zzcaVar, zzbg zzbgVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzua zza = zzcaVar.zza();
        if (zza == null || zza.zzc().zzb() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return zza(zza(zza, zzbgVar, bArr));
    }

    private static List zzb(zzvg zzvgVar) {
        zzbv zzbvVar;
        ArrayList arrayList = new ArrayList(zzvgVar.zza());
        for (zzvg.zzb zzbVar : zzvgVar.zze()) {
            int zza = zzbVar.zza();
            try {
                zzbt zza2 = zznu.zza().zza(zza(zzbVar), zzcs.zza());
                int i = zzbw.zza[zzbVar.zzc().ordinal()];
                if (i == 1) {
                    zzbvVar = zzbv.zza;
                } else if (i == 2) {
                    zzbvVar = zzbv.zzb;
                } else {
                    if (i != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    zzbvVar = zzbv.zzc;
                }
                arrayList.add(new zzbz(zza2, zzbvVar, zza, zza == zzvgVar.zzb(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzc(zzvg zzvgVar) throws GeneralSecurityException {
        if (zzvgVar == null || zzvgVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static final zzbx zza(zzvg zzvgVar) throws GeneralSecurityException {
        zzc(zzvgVar);
        return new zzbx(zzvgVar, zzb(zzvgVar));
    }

    private static zzos zza(zzvg.zzb zzbVar) {
        try {
            return zzos.zza(zzbVar.zzb().zzf(), zzbVar.zzb().zze(), zzbVar.zzb().zzb(), zzbVar.zzf(), zzbVar.zzf() == zzvs.RAW ? null : Integer.valueOf(zzbVar.zza()));
        } catch (GeneralSecurityException e) {
            throw new zzpd("Creating a protokey serialization failed", e);
        }
    }

    private static zzua zza(zzvg zzvgVar, zzbg zzbgVar, byte[] bArr) throws GeneralSecurityException {
        byte[] zzb = zzbgVar.zzb(zzvgVar.zzj(), bArr);
        try {
            if (zzvg.zza(zzbgVar.zza(zzb, bArr), zzaio.zza()).equals(zzvgVar)) {
                return (zzua) ((zzajc) zzua.zza().zza(zzahp.zza(zzb)).zza(zzcx.zza(zzvgVar)).zzf());
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzaji unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzvg zza(zzua zzuaVar, zzbg zzbgVar, byte[] bArr) throws GeneralSecurityException {
        try {
            zzvg zza = zzvg.zza(zzbgVar.zza(zzuaVar.zzc().zzg(), bArr), zzaio.zza());
            zzc(zza);
            return zza;
        } catch (zzaji unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static Object zza(zzmp zzmpVar, zzbt zzbtVar, Class cls) throws GeneralSecurityException {
        try {
            return zzmpVar.zza(zzbtVar, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private static Object zza(zzmp zzmpVar, zzvg.zzb zzbVar, Class cls) throws GeneralSecurityException {
        try {
            return zzmpVar.zza(zzbVar.zzb(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        }
    }

    public final Object zza(Class cls) throws GeneralSecurityException {
        zzow zza = zzow.zza();
        if (!(zza instanceof zzmp)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        Class zza2 = zza.zza(cls);
        if (zza2 == null) {
            throw new GeneralSecurityException("No wrapper found for " + cls.getName());
        }
        zzcx.zzb(this.zza);
        zzcj zzcjVar = new zzcj(zza2, null);
        zzcjVar.zza(this.zzc);
        for (int i = 0; i < this.zza.zza(); i++) {
            zzvg.zzb zza3 = this.zza.zza(i);
            if (zza3.zzc().equals(zzuz.ENABLED)) {
                Object zza4 = zza(zza, zza3, zza2);
                Object zza5 = this.zzb.get(i) != null ? zza(zza, ((zzbz) this.zzb.get(i)).zza(), zza2) : null;
                if (zza5 == null && zza4 == null) {
                    throw new GeneralSecurityException("Unable to get primitive " + String.valueOf(zza2) + " for key of type " + zza3.zzb().zzf());
                }
                if (zza3.zza() == this.zza.zzb()) {
                    zzcjVar.zzb(zza5, zza4, zza3);
                } else {
                    zzcjVar.zza(zza5, zza4, zza3);
                }
            }
        }
        return zza.zza(zzcjVar.zza(), cls);
    }

    public final void zza(zzcd zzcdVar) throws GeneralSecurityException, IOException {
        for (zzvg.zzb zzbVar : this.zza.zze()) {
            if (zzbVar.zzb().zzb() == zzuy.zza.UNKNOWN_KEYMATERIAL || zzbVar.zzb().zzb() == zzuy.zza.SYMMETRIC || zzbVar.zzb().zzb() == zzuy.zza.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", new Object[]{zzbVar.zzb().zzb().name(), zzbVar.zzb().zzf()}));
            }
        }
        zzcdVar.zza(this.zza);
    }

    public final void zza(zzcd zzcdVar, zzbg zzbgVar) throws GeneralSecurityException, IOException {
        zzcdVar.zza(zza(this.zza, zzbgVar, new byte[0]));
    }
}
