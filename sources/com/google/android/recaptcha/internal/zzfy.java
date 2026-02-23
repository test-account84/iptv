package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfy {
    private final Object zza;
    private final int zzb;

    public zzfy(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfyVar = (zzfy) obj;
        return this.zza == zzfyVar.zza && this.zzb == zzfyVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
