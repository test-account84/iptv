package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzir;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzik extends zzjc {
    private final zzir zza;
    private final zzxu zzb;
    private final zzxt zzc;
    private final Integer zzd;

    public static class zza {
        private zzir zza;
        private zzxu zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzir zzirVar) {
            this.zza = zzirVar;
            return this;
        }

        public /* synthetic */ zza(zzim zzimVar) {
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

        public final zzik zza() throws GeneralSecurityException {
            zzxt zza;
            zzir zzirVar = this.zza;
            if (zzirVar == null || this.zzb == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            }
            if (zzirVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzd() == zzir.zzb.zzc) {
                zza = zzxt.zza(new byte[0]);
            } else if (this.zza.zzd() == zzir.zzb.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else {
                if (this.zza.zzd() != zzir.zzb.zza) {
                    throw new IllegalStateException("Unknown AesSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            }
            return new zzik(this.zza, this.zzb, zza, this.zzc, null);
        }
    }

    private zzik(zzir zzirVar, zzxu zzxuVar, zzxt zzxtVar, Integer num) {
        this.zza = zzirVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
        this.zzd = num;
    }

    public /* synthetic */ zzik(zzir zzirVar, zzxu zzxuVar, zzxt zzxtVar, Integer num, zzio zzioVar) {
        this(zzirVar, zzxuVar, zzxtVar, num);
    }
}
