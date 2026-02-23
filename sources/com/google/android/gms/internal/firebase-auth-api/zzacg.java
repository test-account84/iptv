package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import G5.A;
import G5.F;
import G5.P;
import android.content.Context;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzacg {
    private static final A4.a zza = new A4.a("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzyj zzb;
    private final zzadu zzc;

    public zzacg(f fVar, ScheduledExecutorService scheduledExecutorService) {
        r.m(fVar);
        Context l = fVar.l();
        r.m(l);
        this.zzb = new zzyj(new zzacu(fVar, zzacr.zza()));
        this.zzc = new zzadu(l, scheduledExecutorService);
    }

    public final void zza(A a, String str, String str2, String str3, zzace zzaceVar) {
        r.m(a);
        r.h(str, "cachedTokenState should not be empty.");
        r.m(zzaceVar);
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    public final void zzb(String str, zzace zzaceVar) {
        r.g(str);
        r.m(zzaceVar);
        this.zzb.zzb(str, new zzacd(zzaceVar, zza));
    }

    public final void zzc(String str, zzace zzaceVar) {
        r.g(str);
        r.m(zzaceVar);
        this.zzb.zzc(str, new zzacd(zzaceVar, zza));
    }

    public final void zzd(String str, zzace zzaceVar) {
        r.m(zzaceVar);
        this.zzb.zze(str, new zzacd(zzaceVar, zza));
    }

    public final void zze(String str, zzace zzaceVar) {
        r.g(str);
        r.m(zzaceVar);
        this.zzb.zzf(str, new zzacd(zzaceVar, zza));
    }

    public final void zzf(String str, String str2, zzace zzaceVar) {
        r.g(str);
        r.g(str2);
        r.m(zzaceVar);
        this.zzb.zzf(str, str2, new zzacd(zzaceVar, zza));
    }

    public final void zza(zzafz zzafzVar, zzace zzaceVar) {
        r.m(zzafzVar);
        this.zzb.zza(zzafzVar, new zzacd(zzaceVar, zza));
    }

    public final void zzb(String str, String str2, zzace zzaceVar) {
        r.g(str);
        r.g(str2);
        r.m(zzaceVar);
        this.zzb.zzb(str, str2, new zzacd(zzaceVar, zza));
    }

    public final void zzc(String str, String str2, zzace zzaceVar) {
        r.g(str);
        r.g(str2);
        r.m(zzaceVar);
        this.zzb.zzc(str, str2, new zzacd(zzaceVar, zza));
    }

    public final void zzd(String str, String str2, zzace zzaceVar) {
        r.g(str);
        r.m(zzaceVar);
        this.zzb.zzd(str, str2, new zzacd(zzaceVar, zza));
    }

    public final void zze(String str, String str2, zzace zzaceVar) {
        r.g(str);
        this.zzb.zze(str, str2, new zzacd(zzaceVar, zza));
    }

    public final void zza(zzagm zzagmVar, zzace zzaceVar) {
        this.zzb.zza(zzagmVar, new zzacd((zzace) r.m(zzaceVar), zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzace zzaceVar) {
        r.g(str);
        r.g(str2);
        r.m(zzaceVar);
        r.m(zzaceVar);
        this.zzb.zzb(str, str2, str3, str4, new zzacd(zzaceVar, zza));
    }

    public final void zza(zzagt zzagtVar, zzace zzaceVar) {
        r.m(zzagtVar);
        r.m(zzaceVar);
        this.zzb.zza(zzagtVar, new zzacd(zzaceVar, zza));
    }

    public final void zza(zzagu zzaguVar, zzace zzaceVar) {
        r.m(zzaguVar);
        r.m(zzaceVar);
        this.zzb.zza(zzaguVar, new zzacd(zzaceVar, zza));
    }

    public final void zza(zzxv zzxvVar, zzace zzaceVar) {
        r.m(zzxvVar);
        r.g(zzxvVar.zza());
        r.g(zzxvVar.zzb());
        r.m(zzaceVar);
        this.zzb.zza(zzxvVar.zza(), zzxvVar.zzb(), zzxvVar.zzc(), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzxx zzxxVar, zzace zzaceVar) {
        r.m(zzxxVar);
        this.zzb.zza(zzafl.zza(zzxxVar.zzb(), zzxxVar.zza()), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzxy zzxyVar, zzace zzaceVar) {
        r.m(zzxyVar);
        this.zzb.zza(zzafg.zzb(), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzxz zzxzVar, zzace zzaceVar) {
        r.m(zzxzVar);
        r.g(zzxzVar.zzb());
        r.m(zzaceVar);
        this.zzb.zza(zzxzVar.zzb(), zzxzVar.zza(), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzya zzyaVar, zzace zzaceVar) {
        r.m(zzaceVar);
        r.m(zzyaVar);
        F f = (F) r.m(zzyaVar.zza());
        this.zzb.zza(r.g(zzyaVar.zzb()), zzado.zza(f), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzyb zzybVar, zzace zzaceVar) {
        r.m(zzaceVar);
        r.m(zzybVar);
        zzaga zzagaVar = (zzaga) r.m(zzybVar.zza());
        String zzd = zzagaVar.zzd();
        zzacd zzacdVar = new zzacd(zzaceVar, zza);
        if (this.zzc.zzd(zzd)) {
            if (!zzagaVar.zze()) {
                this.zzc.zzb(zzacdVar, zzd);
                return;
            }
            this.zzc.zzc(zzd);
        }
        long zzb = zzagaVar.zzb();
        boolean zzf = zzagaVar.zzf();
        if (zza(zzb, zzf)) {
            zzagaVar.zza(new zzaee(this.zzc.zzb()));
        }
        this.zzc.zza(zzd, zzacdVar, zzb, zzf);
        this.zzb.zza(zzagaVar, this.zzc.zza(zzacdVar, zzd));
    }

    public final void zza(zzyc zzycVar, zzace zzaceVar) {
        r.m(zzycVar);
        r.g(zzycVar.zzc());
        r.m(zzaceVar);
        this.zzb.zza(zzycVar.zzc(), zzycVar.zza(), zzycVar.zzd(), zzycVar.zzb(), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzyd zzydVar, zzace zzaceVar) {
        r.m(zzydVar);
        r.m(zzydVar.zza());
        r.m(zzaceVar);
        this.zzb.zza(zzydVar.zza(), zzydVar.zzb(), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzye zzyeVar, zzace zzaceVar) {
        r.m(zzyeVar);
        r.m(zzaceVar);
        this.zzb.zzd(zzyeVar.zza(), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzyf zzyfVar, zzace zzaceVar) {
        r.m(zzyfVar);
        r.m(zzaceVar);
        String M = zzyfVar.zzb().M();
        zzacd zzacdVar = new zzacd(zzaceVar, zza);
        if (this.zzc.zzd(M)) {
            if (zzyfVar.zzg()) {
                this.zzc.zzc(M);
            } else {
                this.zzc.zzb(zzacdVar, M);
                return;
            }
        }
        long zza2 = zzyfVar.zza();
        boolean zzh = zzyfVar.zzh();
        zzagi zza3 = zzagi.zza(zzyfVar.zzd(), zzyfVar.zzb().K(), zzyfVar.zzb().M(), zzyfVar.zzc(), zzyfVar.zzf(), zzyfVar.zze());
        if (zza(zza2, zzh)) {
            zza3.zza(new zzaee(this.zzc.zzb()));
        }
        this.zzc.zza(M, zzacdVar, zza2, zzh);
        this.zzb.zza(zza3, this.zzc.zza(zzacdVar, M));
    }

    public final void zza(zzyg zzygVar, zzace zzaceVar) {
        r.m(zzaceVar);
        r.m(zzygVar);
        this.zzb.zza(zzado.zza((F) r.m(zzygVar.zza())), new zzacd(zzaceVar, zza));
    }

    public final void zza(zzyi zzyiVar, zzace zzaceVar) {
        r.m(zzyiVar);
        this.zzb.zza(zzafe.zza(zzyiVar.zza(), zzyiVar.zzb(), zzyiVar.zzc()), new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, A a, String str2, zzace zzaceVar) {
        r.g(str);
        r.m(a);
        r.m(zzaceVar);
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    public final void zza(String str, P p, zzace zzaceVar) {
        r.g(str);
        r.m(p);
        r.m(zzaceVar);
        this.zzb.zza(str, p, new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, zzace zzaceVar) {
        r.g(str);
        r.m(zzaceVar);
        this.zzb.zza(str, new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, zzagt zzagtVar, zzace zzaceVar) {
        r.g(str);
        r.m(zzagtVar);
        r.m(zzaceVar);
        this.zzb.zza(str, zzagtVar, new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, String str2, zzace zzaceVar) {
        r.g(str);
        r.m(zzaceVar);
        this.zzb.zza(str, str2, new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, boolean z3, zzace zzaceVar) {
        r.h(str, "idToken should not be empty.");
        r.m(zzaceVar);
        zzacd zzacdVar = new zzacd(zzaceVar, zza);
        if (this.zzc.zzd(str2)) {
            zzadu zzaduVar = this.zzc;
            if (!z) {
                zzaduVar.zzb(zzacdVar, str2);
                return;
            }
            zzaduVar.zzc(str2);
        }
        zzagk zza2 = zzagk.zza(str, str2, str3, str4, str5, null);
        if (zza(j, z3)) {
            zza2.zza(new zzaee(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzacdVar, j, z3);
        this.zzb.zza(zza2, this.zzc.zza(zzacdVar, str2));
    }

    public final void zza(String str, String str2, String str3, zzace zzaceVar) {
        r.h(str, "cachedTokenState should not be empty.");
        r.h(str2, "uid should not be empty.");
        r.m(zzaceVar);
        this.zzb.zzb(str, str2, str3, new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzace zzaceVar) {
        r.g(str);
        r.g(str2);
        r.m(zzaceVar);
        this.zzb.zza(str, str2, str3, str4, new zzacd(zzaceVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzace zzaceVar) {
        r.g(str);
        r.g(str2);
        r.g(str3);
        r.m(zzaceVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzacd(zzaceVar, zza));
    }

    private static boolean zza(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.g("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
