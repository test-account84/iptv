package com.google.android.gms.internal.firebase-auth-api;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafs {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;

    public zzafs() {
    }

    public final Uri zza() {
        if (TextUtils.isEmpty(this.zzc)) {
            return null;
        }
        return Uri.parse(this.zzc);
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zzd;
    }

    public final String zzg() {
        return this.zze;
    }

    public zzafs(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = null;
        this.zzf = str6;
        this.zzg = str7;
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
