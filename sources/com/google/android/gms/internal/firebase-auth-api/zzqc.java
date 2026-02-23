package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzql;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzqc extends zzqr {
    private final zzql zza;
    private final zzxu zzb;
    private final zzxt zzc;
    private final Integer zzd;

    public static class zza {
        private zzql zza;
        private zzxu zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzql zzqlVar) {
            this.zza = zzqlVar;
            return this;
        }

        public /* synthetic */ zza(zzqe zzqeVar) {
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

        public final zzqc zza() throws GeneralSecurityException {
            zzxt zza;
            zzql zzqlVar = this.zza;
            if (zzqlVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzqlVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzf() == zzql.zzb.zzd) {
                zza = zzxt.zza(new byte[0]);
            } else if (this.zza.zzf() == zzql.zzb.zzc || this.zza.zzf() == zzql.zzb.zzb) {
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else {
                if (this.zza.zzf() != zzql.zzb.zza) {
                    throw new IllegalStateException("Unknown HmacParameters.Variant: " + String.valueOf(this.zza.zzf()));
                }
                zza = zzxt.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            }
            return new zzqc(this.zza, this.zzb, zza, this.zzc, null);
        }
    }

    private zzqc(zzql zzqlVar, zzxu zzxuVar, zzxt zzxtVar, Integer num) {
        this.zza = zzqlVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
        this.zzd = num;
    }

    public static zza zzc() {
        return new zza(null);
    }

    public final /* synthetic */ zzqq zza() {
        return this.zza;
    }

    public final zzxt zzb() {
        return this.zzc;
    }

    public final zzxu zzd() {
        return this.zzb;
    }

    public /* synthetic */ zzqc(zzql zzqlVar, zzxu zzxuVar, zzxt zzxtVar, Integer num, zzqd zzqdVar) {
        this(zzqlVar, zzxuVar, zzxtVar, num);
    }
}
