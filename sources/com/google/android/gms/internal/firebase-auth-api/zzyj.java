package com.google.android.gms.internal.firebase-auth-api;

import G5.P;
import G5.d;
import G5.f0;
import G5.h;
import H5.m;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzyj {
    private final zzadi zza;

    public zzyj(zzadi zzadiVar) {
        this.zza = (zzadi) r.m(zzadiVar);
    }

    public static /* bridge */ /* synthetic */ zzadi zza(zzyj zzyjVar) {
        return zzyjVar.zza;
    }

    private final void zzb(zzafe zzafeVar, zzacd zzacdVar) {
        r.m(zzafeVar);
        r.m(zzacdVar);
        this.zza.zza(zzafeVar, new zzzx(this, zzacdVar));
    }

    public final void zzc(String str, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        zza(str, new zzzu(this, zzacdVar));
    }

    public final void zzd(String str, zzacd zzacdVar) {
        r.m(zzacdVar);
        this.zza.zza(str, new zzzy(this, zzacdVar));
    }

    public final void zze(String str, zzacd zzacdVar) {
        r.m(zzacdVar);
        this.zza.zza(new zzage(str), new zzaaa(this, zzacdVar));
    }

    public final void zzf(String str, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        zza(str, new zzzf(this, zzacdVar));
    }

    public final void zza(h hVar, String str, zzacd zzacdVar) {
        r.m(hVar);
        r.m(zzacdVar);
        if (hVar.zzg()) {
            zza(hVar.L(), new zzyn(this, hVar, str, zzacdVar));
        } else {
            zza(new zzaep(hVar, null, str), zzacdVar);
        }
    }

    public final void zzb(String str, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        this.zza.zza(new zzafb(str), new zzym(this, zzacdVar));
    }

    public final void zzc(String str, String str2, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        zza(str, new zzaae(this, str2, zzacdVar));
    }

    public final void zzd(String str, String str2, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        this.zza.zza(new zzafx(str, null, str2), new zzyw(this, zzacdVar));
    }

    public final void zze(String str, String str2, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        this.zza.zza(new zzaek(str, str2), new zzyu(this, zzacdVar));
    }

    public final void zzf(String str, String str2, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        zza(str2, new zzzi(this, str, zzacdVar));
    }

    private final void zza(zzaep zzaepVar, zzacd zzacdVar) {
        r.m(zzaepVar);
        r.m(zzacdVar);
        this.zza.zza(zzaepVar, new zzyq(this, zzacdVar));
    }

    public final void zzb(String str, String str2, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        zza(str, new zzaab(this, str2, zzacdVar));
    }

    public final void zza(zzaer zzaerVar, String str, zzacd zzacdVar) {
        r.m(zzaerVar);
        r.m(zzacdVar);
        zza(str, new zzzo(this, zzaerVar, zzacdVar));
    }

    public final void zzb(String str, String str2, String str3, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        zza(str, new zzzk(this, str2, str3, zzacdVar));
    }

    public final void zza(zzaet zzaetVar, zzacd zzacdVar) {
        r.m(zzaetVar);
        r.m(zzacdVar);
        this.zza.zza(zzaetVar, new zzzq(this, zzacdVar));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        this.zza.zza(new zzagw(str, str2, str3, str4), new zzyo(this, zzacdVar));
    }

    public final void zza(zzafe zzafeVar, zzacd zzacdVar) {
        zzb(zzafeVar, zzacdVar);
    }

    public final void zza(zzafg zzafgVar, zzacd zzacdVar) {
        r.m(zzafgVar);
        r.m(zzacdVar);
        this.zza.zza(zzafgVar, new zzzr(this, zzacdVar));
    }

    public final void zza(zzafl zzaflVar, zzacd zzacdVar) {
        r.m(zzaflVar);
        r.m(zzacdVar);
        this.zza.zza(zzaflVar, new zzzs(this, zzacdVar));
    }

    private final void zza(zzafn zzafnVar, String str, String str2, Boolean bool, f0 f0Var, zzacd zzacdVar, zzadl zzadlVar) {
        r.m(zzafnVar);
        r.m(zzadlVar);
        r.m(zzacdVar);
        this.zza.zza(new zzafa(zzafnVar.zzc()), new zzyr(this, zzadlVar, str2, str, bool, f0Var, zzacdVar, zzafnVar));
    }

    public final void zza(zzafz zzafzVar, zzacd zzacdVar) {
        this.zza.zza(zzafzVar, new zzzz(this, zzacdVar));
    }

    public final void zza(zzaga zzagaVar, zzacd zzacdVar) {
        r.g(zzagaVar.zzd());
        r.m(zzacdVar);
        this.zza.zza(zzagaVar, new zzyx(this, zzacdVar));
    }

    public final void zza(zzagg zzaggVar, zzacd zzacdVar) {
        r.m(zzaggVar);
        r.m(zzacdVar);
        this.zza.zza(zzaggVar, new zzzl(this, zzaggVar, zzacdVar));
    }

    public final void zza(zzagi zzagiVar, zzacd zzacdVar) {
        r.m(zzagiVar);
        r.m(zzacdVar);
        this.zza.zza(zzagiVar, new zzzp(this, zzacdVar));
    }

    public final void zza(zzagt zzagtVar, zzacd zzacdVar) {
        r.m(zzagtVar);
        r.m(zzacdVar);
        zzagtVar.zzb(true);
        this.zza.zza(zzagtVar, new zzzm(this, zzacdVar));
    }

    public final void zza(zzagu zzaguVar, zzacd zzacdVar) {
        r.m(zzaguVar);
        r.m(zzacdVar);
        this.zza.zza(zzaguVar, new zzyv(this, zzacdVar));
    }

    public final void zza(zzagy zzagyVar, zzacd zzacdVar) {
        r.m(zzagyVar);
        r.m(zzacdVar);
        this.zza.zza(zzagyVar, new zzza(this, zzacdVar));
    }

    public static /* synthetic */ void zza(zzyj zzyjVar, zzacd zzacdVar, zzafn zzafnVar, zzafc zzafcVar, zzagc zzagcVar, zzadl zzadlVar) {
        r.m(zzacdVar);
        r.m(zzafnVar);
        r.m(zzafcVar);
        r.m(zzagcVar);
        r.m(zzadlVar);
        zzyjVar.zza.zza(zzagcVar, new zzys(zzyjVar, zzagcVar, zzafcVar, zzacdVar, zzafnVar, zzadlVar));
    }

    public static /* synthetic */ void zza(zzyj zzyjVar, zzacd zzacdVar, zzafn zzafnVar, zzagc zzagcVar, zzadl zzadlVar) {
        r.m(zzacdVar);
        r.m(zzafnVar);
        r.m(zzagcVar);
        r.m(zzadlVar);
        zzyjVar.zza.zza(new zzafa(zzafnVar.zzc()), new zzyp(zzyjVar, zzadlVar, zzacdVar, zzafnVar, zzagcVar));
    }

    public static /* synthetic */ void zza(zzyj zzyjVar, zzacd zzacdVar, zzage zzageVar, zzadl zzadlVar) {
        r.m(zzacdVar);
        r.m(zzageVar);
        r.m(zzadlVar);
        zzyjVar.zza.zza(zzageVar, new zzzc(zzyjVar, zzacdVar, zzadlVar));
    }

    public static /* bridge */ /* synthetic */ void zza(zzyj zzyjVar, zzaep zzaepVar, zzacd zzacdVar) {
        zzyjVar.zza(zzaepVar, zzacdVar);
    }

    public static /* bridge */ /* synthetic */ void zza(zzyj zzyjVar, zzafn zzafnVar, String str, String str2, Boolean bool, f0 f0Var, zzacd zzacdVar, zzadl zzadlVar) {
        zzyjVar.zza(zzafnVar, null, str2, bool, null, zzacdVar, zzadlVar);
    }

    public static /* synthetic */ void zza(zzyj zzyjVar, zzagv zzagvVar, zzacd zzacdVar, zzadl zzadlVar) {
        if (!zzagvVar.zzo()) {
            zzyjVar.zza(new zzafn(zzagvVar.zzi(), zzagvVar.zze(), Long.valueOf(zzagvVar.zza()), "Bearer"), zzagvVar.zzh(), zzagvVar.zzg(), Boolean.valueOf(zzagvVar.zzn()), zzagvVar.zzb(), zzacdVar, zzadlVar);
            return;
        }
        zzacdVar.zza(new zzyh(zzagvVar.zzm() ? new Status(17012) : m.a(zzagvVar.zzd()), zzagvVar.zzb(), zzagvVar.zzc(), zzagvVar.zzj()));
    }

    public final void zza(String str, d dVar, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        zzafe zzafeVar = new zzafe(4);
        zzafeVar.zzd(str);
        if (dVar != null) {
            zzafeVar.zza(dVar);
        }
        zzb(zzafeVar, zzacdVar);
    }

    public final void zza(String str, d dVar, String str2, String str3, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        zzafe zzafeVar = new zzafe(dVar.N());
        zzafeVar.zzb(str);
        zzafeVar.zza(dVar);
        zzafeVar.zzc(str2);
        zzafeVar.zza(str3);
        this.zza.zza(zzafeVar, new zzyt(this, zzacdVar));
    }

    public final void zza(String str, P p, zzacd zzacdVar) {
        r.g(str);
        r.m(p);
        r.m(zzacdVar);
        zza(str, new zzaac(this, p, zzacdVar));
    }

    public final void zza(String str, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        zza(str, new zzzw(this, zzacdVar));
    }

    private final void zza(String str, zzadk zzadkVar) {
        r.m(zzadkVar);
        r.g(str);
        zzafn zzb = zzafn.zzb(str);
        if (zzb.zzg()) {
            zzadkVar.zza(zzb);
        } else {
            this.zza.zza(new zzafb(zzb.zzd()), new zzaag(this, zzadkVar));
        }
    }

    public final void zza(String str, zzagt zzagtVar, zzacd zzacdVar) {
        r.g(str);
        r.m(zzagtVar);
        r.m(zzacdVar);
        zza(str, new zzzd(this, zzagtVar, zzacdVar));
    }

    public final void zza(String str, zzagy zzagyVar, zzacd zzacdVar) {
        r.g(str);
        r.m(zzagyVar);
        r.m(zzacdVar);
        zza(str, new zzzb(this, zzagyVar, zzacdVar));
    }

    public final void zza(String str, String str2, zzacd zzacdVar) {
        r.g(str);
        r.m(zzacdVar);
        zzagc zzagcVar = new zzagc();
        zzagcVar.zze(str);
        zzagcVar.zzh(str2);
        this.zza.zza(zzagcVar, new zzaad(this, zzacdVar));
    }

    public final void zza(String str, String str2, String str3, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        this.zza.zza(new zzafx(str, str2, str3), new zzyy(this, zzacdVar));
    }

    public final void zza(String str, String str2, String str3, String str4, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.m(zzacdVar);
        this.zza.zza(new zzage(str, str2, null, str3, str4, null), new zzyl(this, zzacdVar));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzacd zzacdVar) {
        r.g(str);
        r.g(str2);
        r.g(str3);
        r.m(zzacdVar);
        zza(str3, new zzyz(this, str, str2, str4, str5, zzacdVar));
    }
}
