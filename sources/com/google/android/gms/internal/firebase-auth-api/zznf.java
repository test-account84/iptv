package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznf extends zzch {
    private final zzor zza;

    public zznf(zzor zzorVar) {
        this.zza = zzorVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznf)) {
            return false;
        }
        zzor zzorVar = ((zznf) obj).zza;
        return this.zza.zza().zzd().equals(zzorVar.zza().zzd()) && this.zza.zza().zzf().equals(zzorVar.zza().zzf()) && this.zza.zza().zze().equals(zzorVar.zza().zze());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza.zza(), this.zza.zzb()});
    }

    public final String toString() {
        String zzf = this.zza.zza().zzf();
        int i = zzni.zza[this.zza.zza().zzd().ordinal()];
        return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{zzf, i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK"});
    }

    public final boolean zza() {
        return this.zza.zza().zzd() != zzvs.RAW;
    }

    public final zzor zzb() {
        return this.zza;
    }
}
