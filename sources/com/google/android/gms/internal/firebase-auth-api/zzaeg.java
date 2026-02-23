package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaeg extends zzafz {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzaey zzd;
    private final String zze;

    private zzaeg(String str, String str2, String str3, zzaey zzaeyVar, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaeyVar;
        this.zze = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzafz) {
            zzafz zzafzVar = (zzafz) obj;
            if (this.zza.equals(zzafzVar.zzd()) && ((str = this.zzb) != null ? str.equals(zzafzVar.zze()) : zzafzVar.zze() == null) && this.zzc.equals(zzafzVar.zzf()) && this.zzd.equals(zzafzVar.zzb()) && this.zze.equals(zzafzVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        String str = this.zzb;
        return ((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        return "RevokeTokenRequest{providerId=" + this.zza + ", tenantId=" + this.zzb + ", token=" + this.zzc + ", tokenType=" + String.valueOf(this.zzd) + ", idToken=" + this.zze + "}";
    }

    public final zzaey zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }

    public /* synthetic */ zzaeg(String str, String str2, String str3, zzaey zzaeyVar, String str4, zzaei zzaeiVar) {
        this(str, str2, str3, zzaeyVar, str4);
    }
}
