package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpo extends zzqq {
    private final int zza;
    private final int zzb;
    private final zzb zzc;

    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private zzb zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = zzb.zzd;
        }

        public final zza zza(int i) throws GeneralSecurityException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i << 3)}));
            }
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i >= 10 && 16 >= i) {
                this.zzb = Integer.valueOf(i);
                return this;
            }
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
        }

        public /* synthetic */ zza(zzpq zzpqVar) {
            this();
        }

        public final zza zza(zzb zzbVar) {
            this.zzc = zzbVar;
            return this;
        }

        public final zzpo zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("key size not set");
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("tag size not set");
            }
            if (this.zzc != null) {
                return new zzpo(num.intValue(), this.zzb.intValue(), this.zzc, null);
            }
            throw new GeneralSecurityException("variant not set");
        }
    }

    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("LEGACY");
        public static final zzb zzd = new zzb("NO_PREFIX");
        private final String zze;

        private zzb(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    private zzpo(int i, int i2, zzb zzbVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzbVar;
    }

    public static zza zzd() {
        return new zza(null);
    }

    private final int zzf() {
        zzb zzbVar = this.zzc;
        if (zzbVar == zzb.zzd) {
            return this.zzb;
        }
        if (zzbVar == zzb.zza || zzbVar == zzb.zzb || zzbVar == zzb.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpo)) {
            return false;
        }
        zzpo zzpoVar = (zzpo) obj;
        return zzpoVar.zza == this.zza && zzpoVar.zzf() == zzf() && zzpoVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzpo.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.zzc) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzc != zzb.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzb zze() {
        return this.zzc;
    }

    public /* synthetic */ zzpo(int i, int i2, zzb zzbVar, zzpr zzprVar) {
        this(i, i2, zzbVar);
    }
}
