package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfv extends zzdb {
    private final zza zza;

    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        private zza(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzfv(zza zzaVar) {
        this.zza = zzaVar;
    }

    public static zzfv zza(zza zzaVar) {
        return new zzfv(zzaVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzfv) && ((zzfv) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfv.class, this.zza});
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + String.valueOf(this.zza) + ")";
    }

    public final zza zzb() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}
