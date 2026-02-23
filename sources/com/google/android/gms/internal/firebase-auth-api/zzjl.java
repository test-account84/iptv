package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzdl;
import com.google.android.gms.internal.firebase-auth-api.zzes;
import com.google.android.gms.internal.firebase-auth-api.zzir;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzjl extends zzks {
    private static final Set zza = (Set) zzpd.zza(zzjn.zza);
    private final zzc zzb;
    private final zzb zzc;
    private final zze zzd;
    private final zzd zze;
    private final zzch zzf;
    private final zzxt zzg;

    public static final class zza {
        private zzc zza;
        private zzb zzb;
        private zze zzc;
        private zzch zzd;
        private zzd zze;
        private zzxt zzf;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = zzd.zzc;
            this.zzf = null;
        }

        public final zza zza(zzch zzchVar) throws GeneralSecurityException {
            if (zzjl.zzi().contains(zzchVar)) {
                this.zzd = zzchVar;
                return this;
            }
            throw new GeneralSecurityException("Invalid DEM parameters " + String.valueOf(zzchVar) + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
        }

        public /* synthetic */ zza(zzjp zzjpVar) {
            this();
        }

        public final zza zza(zzb zzbVar) {
            this.zzb = zzbVar;
            return this;
        }

        public final zza zza(zzc zzcVar) {
            this.zza = zzcVar;
            return this;
        }

        public final zza zza(zzd zzdVar) {
            this.zze = zzdVar;
            return this;
        }

        public final zza zza(zze zzeVar) {
            this.zzc = zzeVar;
            return this;
        }

        public final zza zza(zzxt zzxtVar) {
            if (zzxtVar.zza() == 0) {
                this.zzf = null;
                return this;
            }
            this.zzf = zzxtVar;
            return this;
        }

        public final zzjl zza() throws GeneralSecurityException {
            zzc zzcVar = this.zza;
            if (zzcVar == null) {
                throw new GeneralSecurityException("Elliptic curve type is not set");
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("Hash type is not set");
            }
            if (this.zzd == null) {
                throw new GeneralSecurityException("DEM parameters are not set");
            }
            if (this.zze == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            zzc zzcVar2 = zzc.zzd;
            if (zzcVar != zzcVar2 && this.zzc == null) {
                throw new GeneralSecurityException("Point format is not set");
            }
            if (zzcVar != zzcVar2 || this.zzc == null) {
                return new zzjl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null);
            }
            throw new GeneralSecurityException("For Curve25519 point format must not be set");
        }
    }

    public static final class zzb {
        public static final zzb zza = new zzb("SHA1");
        public static final zzb zzb = new zzb("SHA224");
        public static final zzb zzc = new zzb("SHA256");
        public static final zzb zzd = new zzb("SHA384");
        public static final zzb zze = new zzb("SHA512");
        private final String zzf;

        private zzb(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    public static final class zzc {
        public static final zzc zza = new zzc("NIST_P256");
        public static final zzc zzb = new zzc("NIST_P384");
        public static final zzc zzc = new zzc("NIST_P521");
        public static final zzc zzd = new zzc("X25519");
        private final String zze;

        private zzc(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    public static final class zzd {
        public static final zzd zza = new zzd("TINK");
        public static final zzd zzb = new zzd("CRUNCHY");
        public static final zzd zzc = new zzd("NO_PREFIX");
        private final String zzd;

        private zzd(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    public static final class zze {
        public static final zze zza = new zze("COMPRESSED");
        public static final zze zzb = new zze("UNCOMPRESSED");
        public static final zze zzc = new zze("LEGACY_UNCOMPRESSED");
        private final String zzd;

        private zze(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzjl(zzc zzcVar, zzb zzbVar, zze zzeVar, zzch zzchVar, zzd zzdVar, zzxt zzxtVar) {
        this.zzb = zzcVar;
        this.zzc = zzbVar;
        this.zzd = zzeVar;
        this.zzf = zzchVar;
        this.zze = zzdVar;
        this.zzg = zzxtVar;
    }

    public static zza zzc() {
        return new zza(null);
    }

    public static /* bridge */ /* synthetic */ Set zzi() {
        return zza;
    }

    public static /* synthetic */ Set zzj() throws Exception {
        HashSet hashSet = new HashSet();
        zzes.zza zzc2 = zzes.zze().zza(12).zzb(16).zzc(16);
        zzes.zzb zzbVar = zzes.zzb.zzc;
        hashSet.add(zzc2.zza(zzbVar).zza());
        hashSet.add(zzes.zze().zza(12).zzb(32).zzc(16).zza(zzbVar).zza());
        zzdl.zza zzc3 = zzdl.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdl.zzb zzbVar2 = zzdl.zzb.zzc;
        zzdl.zza zza2 = zzc3.zza(zzbVar2);
        zzdl.zzc zzcVar = zzdl.zzc.zzc;
        hashSet.add(zza2.zza(zzcVar).zza());
        hashSet.add(zzdl.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzbVar2).zza(zzcVar).zza());
        hashSet.add(zzhm.zzc());
        hashSet.add(zzir.zzc().zza(64).zza(zzir.zzb.zzc).zza());
        return Collections.unmodifiableSet(hashSet);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjl)) {
            return false;
        }
        zzjl zzjlVar = (zzjl) obj;
        return zzjo.zza(zzjlVar.zzb, this.zzb) && zzjo.zza(zzjlVar.zzc, this.zzc) && zzjo.zza(zzjlVar.zzd, this.zzd) && zzjo.zza(zzjlVar.zzf, this.zzf) && zzjo.zza(zzjlVar.zze, this.zze) && zzjo.zza(zzjlVar.zzg, this.zzg);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzjl.class, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", new Object[]{this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    public final boolean zza() {
        return this.zze != zzd.zzc;
    }

    public final zzch zzb() {
        return this.zzf;
    }

    public final zzc zzd() {
        return this.zzb;
    }

    public final zzb zze() {
        return this.zzc;
    }

    public final zze zzf() {
        return this.zzd;
    }

    public final zzd zzg() {
        return this.zze;
    }

    public final zzxt zzh() {
        return this.zzg;
    }

    public /* synthetic */ zzjl(zzc zzcVar, zzb zzbVar, zze zzeVar, zzch zzchVar, zzd zzdVar, zzxt zzxtVar, zzjr zzjrVar) {
        this(zzcVar, zzbVar, zzeVar, zzchVar, zzdVar, zzxtVar);
    }
}
