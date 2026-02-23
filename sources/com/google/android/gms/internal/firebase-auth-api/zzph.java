package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzpo;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzph extends zzqr {
    private final zzpo zza;
    private final zzxu zzb;
    private final zzxt zzc;
    private final Integer zzd;

    public static class zza {
        private zzpo zza;
        private zzxu zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzpo zzpoVar) {
            this.zza = zzpoVar;
            return this;
        }

        public /* synthetic */ zza(zzpj zzpjVar) {
            this();
        }

        public final zza zza(zzxu zzxuVar) throws GeneralSecurityException {
            this.zzb = zzxuVar;
            return this;
        }

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        public final zzph zza() throws GeneralSecurityException {
            zzxt zza;
            zzpo zzpoVar = this.zza;
            if (zzpoVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzpoVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zze() == zzpo.zzb.zzd) {
                zza = zzxt.zza(new byte[0]);
            } else if (this.zza.zze() == zzpo.zzb.zzc || this.zza.zze() == zzpo.zzb.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else {
                if (this.zza.zze() != zzpo.zzb.zza) {
                    throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + String.valueOf(this.zza.zze()));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            }
            return new zzph(this.zza, this.zzb, zza, this.zzc, null);
        }
    }

    private zzph(zzpo zzpoVar, zzxu zzxuVar, zzxt zzxtVar, Integer num) {
        this.zza = zzpoVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
        this.zzd = num;
    }

    public final /* synthetic */ zzqq zza() {
        return this.zza;
    }

    public final zzxt zzb() {
        return this.zzc;
    }

    public final zzxu zzc() {
        return this.zzb;
    }

    public /* synthetic */ zzph(zzpo zzpoVar, zzxu zzxuVar, zzxt zzxtVar, Integer num, zzpi zzpiVar) {
        this(zzpoVar, zzxuVar, zzxtVar, num);
    }
}
