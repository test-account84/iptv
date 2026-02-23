package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaeh extends zzafu {
    private final String zza;
    private final String zzb;

    public zzaeh(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzafu) {
            zzafu zzafuVar = (zzafu) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzafuVar.zzb()) : zzafuVar.zzb() == null) {
                String str2 = this.zzb;
                String zza = zzafuVar.zza();
                if (str2 != null ? str2.equals(zza) : zza == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.zzb;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "RecaptchaEnforcementState{provider=" + this.zza + ", enforcementState=" + this.zzb + "}";
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
