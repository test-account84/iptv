package com.google.android.gms.internal.firebase-auth-api;

import G5.f0;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafc {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzafv zzf;
    private String zzg;
    private String zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private f0 zzl;
    private List zzm;
    private zzap zzn;

    public zzafc() {
        this.zzf = new zzafv();
        this.zzn = zzap.zzh();
    }

    public final long zza() {
        return this.zzi;
    }

    public final long zzb() {
        return this.zzj;
    }

    public final Uri zzc() {
        if (TextUtils.isEmpty(this.zze)) {
            return null;
        }
        return Uri.parse(this.zze);
    }

    public final zzafc zzd(String str) {
        this.zze = str;
        return this;
    }

    public final f0 zze() {
        return this.zzl;
    }

    public final zzafv zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzh;
    }

    public final List zzk() {
        return this.zzm;
    }

    public final List zzl() {
        return this.zzf.zza();
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzk;
    }

    public zzafc(String str, String str2, boolean z, String str3, String str4, zzafv zzafvVar, String str5, String str6, long j, long j2, boolean z2, f0 f0Var, List list, zzap zzapVar) {
        zzafv zzafvVar2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzafvVar == null) {
            zzafvVar2 = new zzafv();
        } else {
            List zza = zzafvVar.zza();
            zzafv zzafvVar3 = new zzafv();
            if (zza != null) {
                zzafvVar3.zza().addAll(zza);
            }
            zzafvVar2 = zzafvVar3;
        }
        this.zzf = zzafvVar2;
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = false;
        this.zzl = null;
        this.zzm = list == null ? new ArrayList() : list;
        this.zzn = zzapVar;
    }

    public final zzafc zza(f0 f0Var) {
        this.zzl = f0Var;
        return this;
    }

    public final zzafc zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzafc zzc(String str) {
        r.g(str);
        this.zzg = str;
        return this;
    }

    public final zzap zzd() {
        return this.zzn;
    }

    public final zzafc zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzafc zza(List list) {
        r.m(list);
        zzafv zzafvVar = new zzafv();
        this.zzf = zzafvVar;
        zzafvVar.zza().addAll(list);
        return this;
    }

    public final zzafc zza(boolean z) {
        this.zzk = z;
        return this;
    }
}
