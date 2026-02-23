package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzed extends zzdb {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final zzb zzd;

    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private Integer zzc;
        private zzb zzd;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzb.zzc;
        }

        public final zza zza(int i) throws GeneralSecurityException {
            if (i != 12 && i != 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
            }
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zza zzc(int i) throws GeneralSecurityException {
            this.zzc = 16;
            return this;
        }

        public /* synthetic */ zza(zzee zzeeVar) {
            this();
        }

        public final zza zza(zzb zzbVar) {
            this.zzd = zzbVar;
            return this;
        }

        public final zzed zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("IV size is not set");
            }
            if (this.zzd == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            if (this.zzc != null) {
                return new zzed(num.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd, null);
            }
            throw new GeneralSecurityException("Tag size is not set");
        }
    }

    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("NO_PREFIX");
        private final String zzd;

        private zzb(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzed(int i, int i2, int i3, zzb zzbVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = zzbVar;
    }

    public static zza zze() {
        return new zza(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzed)) {
            return false;
        }
        zzed zzedVar = (zzed) obj;
        return zzedVar.zza == this.zza && zzedVar.zzb == this.zzb && zzedVar.zzc == this.zzc && zzedVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzed.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd});
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, " + this.zzc + "-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzb.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final zzb zzf() {
        return this.zzd;
    }

    public /* synthetic */ zzed(int i, int i2, int i3, zzb zzbVar, zzeg zzegVar) {
        this(i, i2, i3, zzbVar);
    }
}
