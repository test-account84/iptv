package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzel extends zzcz {
    private final zzes zza;
    private final zzxu zzb;
    private final zzxt zzc;
    private final Integer zzd;

    public static class zza {
        private zzes zza;
        private zzxu zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzes zzesVar) {
            this.zza = zzesVar;
            return this;
        }

        public /* synthetic */ zza(zzen zzenVar) {
            this();
        }

        public final zza zza(zzxu zzxuVar) {
            this.zzb = zzxuVar;
            return this;
        }

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        public final zzel zza() throws GeneralSecurityException {
            zzxt zza;
            zzes zzesVar = this.zza;
            if (zzesVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzesVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzf() == zzes.zzb.zzc) {
                zza = zzxt.zza(new byte[0]);
            } else if (this.zza.zzf() == zzes.zzb.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else {
                if (this.zza.zzf() != zzes.zzb.zza) {
                    throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + String.valueOf(this.zza.zzf()));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            }
            return new zzel(this.zza, this.zzb, zza, this.zzc, null);
        }
    }

    private zzel(zzes zzesVar, zzxu zzxuVar, zzxt zzxtVar, Integer num) {
        this.zza = zzesVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
        this.zzd = num;
    }

    public /* synthetic */ zzel(zzes zzesVar, zzxu zzxuVar, zzxt zzxtVar, Integer num, zzep zzepVar) {
        this(zzesVar, zzxuVar, zzxtVar, num);
    }
}
