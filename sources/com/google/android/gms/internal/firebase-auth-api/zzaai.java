package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import G5.F;
import G5.H;
import G5.I;
import G5.J;
import G5.L;
import G5.P;
import G5.g;
import G5.h;
import G5.u;
import H5.Q;
import H5.T;
import H5.d;
import H5.f0;
import H5.k;
import H5.p;
import H5.s;
import H5.w;
import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaai extends zzadh {
    public zzaai(f fVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzacg(fVar, scheduledExecutorService);
        this.zzb = executor;
    }

    public static H5.b zza(f fVar, zzafc zzafcVar) {
        r.m(fVar);
        r.m(zzafcVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f0(zzafcVar, "firebase"));
        List zzl = zzafcVar.zzl();
        if (zzl != null && !zzl.isEmpty()) {
            for (int i = 0; i < zzl.size(); i++) {
                arrayList.add(new f0((zzafs) zzl.get(i)));
            }
        }
        H5.b bVar = new H5.b(fVar, arrayList);
        bVar.W(new d(zzafcVar.zzb(), zzafcVar.zza()));
        bVar.X(zzafcVar.zzn());
        bVar.V(zzafcVar.zze());
        bVar.R(w.b(zzafcVar.zzk()));
        bVar.Y(zzafcVar.zzd());
        return bVar;
    }

    public final Task zzb(f fVar, u uVar, g gVar, String str, Q q) {
        return zza((zzaay) new zzaay(gVar, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzc(f fVar, u uVar, g gVar, String str, Q q) {
        return zza((zzaax) new zzaax(gVar, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzd(f fVar, u uVar, String str, Q q) {
        return zza((zzaby) new zzaby(str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza() {
        return zza(new zzaas());
    }

    public final Task zzb(f fVar, u uVar, h hVar, String str, Q q) {
        return zza((zzaaz) new zzaaz(hVar, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzc(f fVar, u uVar, String str, Q q) {
        return zza((zzabv) new zzabv(str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzd(f fVar, String str, String str2) {
        return zza((zzacc) new zzacc(str, str2).zza(fVar));
    }

    public final Task zza(f fVar, G5.d dVar, String str) {
        return zza((zzabi) new zzabi(str, dVar).zza(fVar));
    }

    public final Task zzb(f fVar, u uVar, F f, String str, Q q) {
        zzadt.zza();
        return zza((zzabd) new zzabd(f, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzc(f fVar, String str, String str2) {
        return zza((zzaao) new zzaao(str, str2).zza(fVar));
    }

    public final Task zza(f fVar, g gVar, String str, T t) {
        return zza((zzabm) new zzabm(gVar, str).zza(fVar).zza(t));
    }

    public final Task zzb(f fVar, u uVar, String str, Q q) {
        r.m(fVar);
        r.g(str);
        r.m(uVar);
        r.m(q);
        List T = uVar.T();
        if ((T != null && !T.contains(str)) || uVar.M()) {
            return Tasks.forException(zzacf.zza(new Status(17016, str)));
        }
        str.hashCode();
        return !str.equals("password") ? zza((zzabw) new zzabw(str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q)) : zza((zzabt) new zzabt().zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, h hVar, String str, T t) {
        return zza((zzabn) new zzabn(hVar, str).zza(fVar).zza(t));
    }

    public final Task zzb(f fVar, u uVar, String str, String str2, String str3, String str4, Q q) {
        return zza((zzabb) new zzabb(str, str2, str3, str4).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, u uVar, g gVar, String str, Q q) {
        r.m(fVar);
        r.m(gVar);
        r.m(uVar);
        r.m(q);
        List T = uVar.T();
        if (T != null && T.contains(gVar.H())) {
            return Tasks.forException(zzacf.zza(new Status(17015)));
        }
        if (gVar instanceof h) {
            h hVar = (h) gVar;
            return !hVar.M() ? zza((zzaau) new zzaau(hVar, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q)) : zza((zzaav) new zzaav(hVar).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
        }
        if (gVar instanceof F) {
            zzadt.zza();
            return zza((zzaaw) new zzaaw((F) gVar).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
        }
        r.m(fVar);
        r.m(gVar);
        r.m(uVar);
        r.m(q);
        return zza((zzaat) new zzaat(gVar).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzb(f fVar, String str, G5.d dVar, String str2, String str3) {
        dVar.O(6);
        return zza((zzabh) new zzabh(str, dVar, str2, str3, "sendSignInLinkToEmail").zza(fVar));
    }

    public final Task zza(f fVar, u uVar, h hVar, String str, Q q) {
        return zza((zzaba) new zzaba(hVar, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzb(f fVar, String str, String str2) {
        return zza((zzaak) new zzaak(str, str2).zza(fVar));
    }

    public final Task zza(f fVar, u uVar, F f, Q q) {
        zzadt.zza();
        return zza((zzabx) new zzabx(f).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zzb(f fVar, String str, String str2, String str3, String str4, T t) {
        return zza((zzabo) new zzabo(str, str2, str3, str4).zza(fVar).zza(t));
    }

    public final Task zza(f fVar, u uVar, F f, String str, Q q) {
        zzadt.zza();
        return zza((zzabe) new zzabe(f, str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, u uVar, I i, String str, T t) {
        zzadt.zza();
        zzaaq zzaaqVar = new zzaaq(i, str, null);
        zzaaqVar.zza(fVar).zza(t);
        if (uVar != null) {
            zzaaqVar.zza(uVar);
        }
        return zza(zzaaqVar);
    }

    public final Task zza(f fVar, u uVar, L l, String str, String str2, T t) {
        zzaaq zzaaqVar = new zzaaq(l, str, str2);
        zzaaqVar.zza(fVar).zza(t);
        if (uVar != null) {
            zzaaqVar.zza(uVar);
        }
        return zza(zzaaqVar);
    }

    public final Task zza(f fVar, u uVar, P p, Q q) {
        return zza((zzaca) new zzaca(p).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, u uVar, Q q) {
        return zza((zzabg) new zzabg().zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, u uVar, String str, Q q) {
        return zza((zzaap) new zzaap(str).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, u uVar, String str, String str2, Q q) {
        return zza((zzabu) new zzabu(uVar.zze(), str, str2).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, u uVar, String str, String str2, String str3, String str4, Q q) {
        return zza((zzabc) new zzabc(str, str2, str3, str4).zza(fVar).zza(uVar).zza((Object) q).zza((s) q));
    }

    public final Task zza(f fVar, F f, String str, T t) {
        zzadt.zza();
        return zza((zzabq) new zzabq(f, str).zza(fVar).zza(t));
    }

    public final Task zza(f fVar, I i, u uVar, String str, T t) {
        zzadt.zza();
        zzaan zzaanVar = new zzaan(i, uVar.zze(), str, null);
        zzaanVar.zza(fVar).zza(t);
        return zza(zzaanVar);
    }

    public final Task zza(f fVar, L l, u uVar, String str, String str2, T t) {
        zzaan zzaanVar = new zzaan(l, uVar.zze(), str, str2);
        zzaanVar.zza(fVar).zza(t);
        return zza(zzaanVar);
    }

    public final Task zza(f fVar, T t, String str) {
        return zza((zzabj) new zzabj(str).zza(fVar).zza(t));
    }

    public final Task zza(f fVar, String str, G5.d dVar, String str2, String str3) {
        dVar.O(1);
        return zza((zzabh) new zzabh(str, dVar, str2, str3, "sendPasswordResetEmail").zza(fVar));
    }

    public final Task zza(f fVar, String str, String str2) {
        return zza((zzaah) new zzaah(str, str2).zza(fVar));
    }

    public final Task zza(f fVar, String str, String str2, T t) {
        return zza((zzabl) new zzabl(str, str2).zza(fVar).zza(t));
    }

    public final Task zza(f fVar, String str, String str2, String str3) {
        return zza((zzaaj) new zzaaj(str, str2, str3).zza(fVar));
    }

    public final Task zza(f fVar, String str, String str2, String str3, String str4, T t) {
        return zza((zzaam) new zzaam(str, str2, str3, str4).zza(fVar).zza(t));
    }

    public final Task zza(u uVar, p pVar) {
        return zza((zzaal) new zzaal().zza(uVar).zza((Object) pVar).zza((s) pVar));
    }

    public final Task zza(k kVar, J j, String str, long j2, boolean z, boolean z2, String str2, String str3, boolean z3, H h, Executor executor, Activity activity) {
        zzabr zzabrVar = new zzabr(j, r.g(kVar.zzc()), str, j2, z, z2, str2, str3, z3);
        zzabrVar.zza(h, activity, executor, j.K());
        return zza(zzabrVar);
    }

    public final Task zza(k kVar, String str) {
        return zza(new zzabs(kVar, str));
    }

    public final Task zza(k kVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3, H h, Executor executor, Activity activity) {
        zzabp zzabpVar = new zzabp(kVar, str, str2, j, z, z2, str3, str4, z3);
        zzabpVar.zza(h, activity, executor, str);
        return zza(zzabpVar);
    }

    public final Task zza(String str) {
        return zza(new zzabk(str));
    }

    public final Task zza(String str, String str2) {
        return zza(new zzaar(str, str2));
    }

    public final Task zza(String str, String str2, G5.d dVar) {
        dVar.O(7);
        return zza(new zzabz(str, str2, dVar));
    }

    public final Task zza(String str, String str2, String str3, String str4) {
        return zza(new zzabf(str, str2, str3, str4));
    }

    public final void zza(f fVar, zzaga zzagaVar, H h, Activity activity, Executor executor) {
        zza((zzacb) new zzacb(zzagaVar).zza(fVar).zza(h, activity, executor, zzagaVar.zzd()));
    }
}
