package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzql extends zzqq {
    private final int zza;
    private final int zzb;
    private final zzb zzc;
    private final zzc zzd;

    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private zzc zzc;
        private zzb zzd;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzb.zzd;
        }

        public final zza zza(int i) throws GeneralSecurityException {
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public /* synthetic */ zza(zzqn zzqnVar) {
            this();
        }

        public final zza zza(zzb zzbVar) {
            this.zzd = zzbVar;
            return this;
        }

        public final zza zza(zzc zzcVar) {
            this.zzc = zzcVar;
            return this;
        }

        public final zzql zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.zzc == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.zzd == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            if (num.intValue() < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.zza}));
            }
            Integer num2 = this.zzb;
            int intValue = num2.intValue();
            zzc zzcVar = this.zzc;
            if (intValue < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{num2}));
            }
            if (zzcVar == zzc.zza) {
                if (intValue > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{num2}));
                }
            } else if (zzcVar == zzc.zzb) {
                if (intValue > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{num2}));
                }
            } else if (zzcVar == zzc.zzc) {
                if (intValue > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{num2}));
                }
            } else if (zzcVar == zzc.zzd) {
                if (intValue > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{num2}));
                }
            } else {
                if (zzcVar != zzc.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                }
                if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{num2}));
                }
            }
            return new zzql(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
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

    public static final class zzc {
        public static final zzc zza = new zzc("SHA1");
        public static final zzc zzb = new zzc("SHA224");
        public static final zzc zzc = new zzc("SHA256");
        public static final zzc zzd = new zzc("SHA384");
        public static final zzc zze = new zzc("SHA512");
        private final String zzf;

        private zzc(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    private zzql(int i, int i2, zzb zzbVar, zzc zzcVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzbVar;
        this.zzd = zzcVar;
    }

    public static zza zzd() {
        return new zza(null);
    }

    private final int zzg() {
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
        if (!(obj instanceof zzql)) {
            return false;
        }
        zzql zzqlVar = (zzql) obj;
        return zzqlVar.zza == this.zza && zzqlVar.zzg() == zzg() && zzqlVar.zzc == this.zzc && zzqlVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzql.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return "HMAC Parameters (variant: " + String.valueOf(this.zzc) + ", hashType: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
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

    public final zzc zze() {
        return this.zzd;
    }

    public final zzb zzf() {
        return this.zzc;
    }

    public /* synthetic */ zzql(int i, int i2, zzb zzbVar, zzc zzcVar, zzqp zzqpVar) {
        this(i, i2, zzbVar, zzcVar);
    }
}
