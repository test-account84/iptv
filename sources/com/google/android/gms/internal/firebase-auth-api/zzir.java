package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzir extends zzjb {
    private final int zza;
    private final zzb zzb;

    public static final class zza {
        private Integer zza;
        private zzb zzb;

        private zza() {
            this.zza = null;
            this.zzb = zzb.zzc;
        }

        public final zza zza(int i) throws GeneralSecurityException {
            if (i != 32 && i != 48 && i != 64) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(i)}));
            }
            this.zza = Integer.valueOf(i);
            return this;
        }

        public /* synthetic */ zza(zzit zzitVar) {
            this();
        }

        public final zza zza(zzb zzbVar) {
            this.zzb = zzbVar;
            return this;
        }

        public final zzir zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.zzb != null) {
                return new zzir(num.intValue(), this.zzb, null);
            }
            throw new GeneralSecurityException("Variant is not set");
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

    private zzir(int i, zzb zzbVar) {
        this.zza = i;
        this.zzb = zzbVar;
    }

    public static zza zzc() {
        return new zza(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzir)) {
            return false;
        }
        zzir zzirVar = (zzir) obj;
        return zzirVar.zza == this.zza && zzirVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzir.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        return "AesSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzb != zzb.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzb zzd() {
        return this.zzb;
    }

    public /* synthetic */ zzir(int i, zzb zzbVar, zziu zziuVar) {
        this(i, zzbVar);
    }
}
