package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzfj;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfc extends zzcz {
    private final zzfj zza;
    private final zzxu zzb;
    private final zzxt zzc;
    private final Integer zzd;

    public static class zza {
        private zzfj zza;
        private zzxu zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzfj zzfjVar) {
            this.zza = zzfjVar;
            return this;
        }

        public /* synthetic */ zza(zzfe zzfeVar) {
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

        public final zzfc zza() throws GeneralSecurityException {
            zzxt zza;
            zzfj zzfjVar = this.zza;
            if (zzfjVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzfjVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzd() == zzfj.zzb.zzc) {
                zza = zzxt.zza(new byte[0]);
            } else if (this.zza.zzd() == zzfj.zzb.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else {
                if (this.zza.zzd() != zzfj.zzb.zza) {
                    throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            }
            return new zzfc(this.zza, this.zzb, zza, this.zzc, null);
        }
    }

    private zzfc(zzfj zzfjVar, zzxu zzxuVar, zzxt zzxtVar, Integer num) {
        this.zza = zzfjVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
        this.zzd = num;
    }

    public /* synthetic */ zzfc(zzfj zzfjVar, zzxu zzxuVar, zzxt zzxtVar, Integer num, zzfd zzfdVar) {
        this(zzfjVar, zzxuVar, zzxtVar, num);
    }
}
