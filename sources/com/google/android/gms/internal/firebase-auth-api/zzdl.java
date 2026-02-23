package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdl extends zzdb {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzc zze;
    private final zzb zzf;

    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private Integer zzc;
        private Integer zzd;
        private zzb zze;
        private zzc zzf;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = zzc.zzc;
        }

        public final zza zza(int i) throws GeneralSecurityException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
            }
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zza zzc(int i) throws GeneralSecurityException {
            if (i < 12 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.zzc = Integer.valueOf(i);
            return this;
        }

        public final zza zzd(int i) throws GeneralSecurityException {
            if (i < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.zzd = Integer.valueOf(i);
            return this;
        }

        public /* synthetic */ zza(zzdm zzdmVar) {
            this();
        }

        public final zza zza(zzb zzbVar) {
            this.zze = zzbVar;
            return this;
        }

        public final zza zza(zzc zzcVar) {
            this.zzf = zzcVar;
            return this;
        }

        public final zzdl zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("AES key size is not set");
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("HMAC key size is not set");
            }
            if (this.zzc == null) {
                throw new GeneralSecurityException("iv size is not set");
            }
            Integer num = this.zzd;
            if (num == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.zze == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.zzf == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            int intValue = num.intValue();
            zzb zzbVar = this.zze;
            if (zzbVar == zzb.zza) {
                if (intValue > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{num}));
                }
            } else if (zzbVar == zzb.zzb) {
                if (intValue > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{num}));
                }
            } else if (zzbVar == zzb.zzc) {
                if (intValue > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{num}));
                }
            } else if (zzbVar == zzb.zzd) {
                if (intValue > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{num}));
                }
            } else {
                if (zzbVar != zzb.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                }
                if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{num}));
                }
            }
            return new zzdl(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze, null);
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
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("NO_PREFIX");
        private final String zzd;

        private zzc(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzdl(int i, int i2, int i3, int i4, zzc zzcVar, zzb zzbVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzcVar;
        this.zzf = zzbVar;
    }

    public static zza zzf() {
        return new zza(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdl)) {
            return false;
        }
        zzdl zzdlVar = (zzdl) obj;
        return zzdlVar.zza == this.zza && zzdlVar.zzb == this.zzb && zzdlVar.zzc == this.zzc && zzdlVar.zzd == this.zzd && zzdlVar.zze == this.zze && zzdlVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzdl.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        return "AesCtrHmacAead Parameters (variant: " + String.valueOf(this.zze) + ", hashType: " + String.valueOf(this.zzf) + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    public final boolean zza() {
        return this.zze != zzc.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzb zzg() {
        return this.zzf;
    }

    public final zzc zzh() {
        return this.zze;
    }

    public /* synthetic */ zzdl(int i, int i2, int i3, int i4, zzc zzcVar, zzb zzbVar, zzdn zzdnVar) {
        this(i, i2, i3, i4, zzcVar, zzbVar);
    }
}
