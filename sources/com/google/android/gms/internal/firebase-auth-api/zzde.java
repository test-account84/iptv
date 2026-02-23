package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzdl;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzde extends zzcz {
    private final zzdl zza;
    private final zzxu zzb;
    private final zzxu zzc;
    private final zzxt zzd;
    private final Integer zze;

    public static class zza {
        private zzdl zza;
        private zzxu zzb;
        private zzxu zzc;
        private Integer zzd;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
        }

        public final zza zza(zzdl zzdlVar) {
            this.zza = zzdlVar;
            return this;
        }

        public final zza zzb(zzxu zzxuVar) {
            this.zzc = zzxuVar;
            return this;
        }

        public /* synthetic */ zza(zzdg zzdgVar) {
            this();
        }

        public final zza zza(zzxu zzxuVar) {
            this.zzb = zzxuVar;
            return this;
        }

        public final zza zza(Integer num) {
            this.zzd = num;
            return this;
        }

        public final zzde zza() throws GeneralSecurityException {
            zzxt zza;
            zzdl zzdlVar = this.zza;
            if (zzdlVar == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (this.zzb == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            }
            if (zzdlVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            }
            if (this.zza.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            }
            if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzd != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzh() == zzdl.zzc.zzc) {
                zza = zzxt.zza(new byte[0]);
            } else if (this.zza.zzh() == zzdl.zzc.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
            } else {
                if (this.zza.zzh() != zzdl.zzc.zza) {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + String.valueOf(this.zza.zzh()));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
            }
            return new zzde(this.zza, this.zzb, this.zzc, zza, this.zzd, null);
        }
    }

    private zzde(zzdl zzdlVar, zzxu zzxuVar, zzxu zzxuVar2, zzxt zzxtVar, Integer num) {
        this.zza = zzdlVar;
        this.zzb = zzxuVar;
        this.zzc = zzxuVar2;
        this.zzd = zzxtVar;
        this.zze = num;
    }

    public /* synthetic */ zzde(zzdl zzdlVar, zzxu zzxuVar, zzxu zzxuVar2, zzxt zzxtVar, Integer num, zzdf zzdfVar) {
        this(zzdlVar, zzxuVar, zzxuVar2, zzxtVar, num);
    }
}
