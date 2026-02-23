package M4;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y2 implements Callable {
    public final /* synthetic */ v a;
    public final /* synthetic */ String b;
    public final /* synthetic */ D2 c;

    public y2(D2 d2, v vVar, String str) {
        this.c = d2;
        this.a = vVar;
        this.b = str;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        X4 x4;
        I2 i2;
        zzga zzgaVar;
        String str;
        Bundle bundle;
        zzgc zzgcVar;
        String str2;
        r c;
        long j;
        D2.Z(this.c).e();
        y3 d0 = D2.Z(this.c).d0();
        v vVar = this.a;
        String str3 = this.b;
        d0.h();
        l2.t();
        com.google.android.gms.common.internal.r.m(vVar);
        com.google.android.gms.common.internal.r.g(str3);
        if (!d0.a.z().B(str3, m1.W)) {
            d0.a.d().q().b("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        }
        if (!"_iap".equals(vVar.f) && !"_iapx".equals(vVar.f)) {
            d0.a.d().q().c("Generating a payload for this event is not available. package_name, event_name", str3, vVar.f);
            return null;
        }
        zzga zza = zzgb.zza();
        d0.b.V().e0();
        try {
            I2 R = d0.b.V().R(str3);
            if (R == null) {
                d0.a.d().q().b("Log and bundle not available. package_name", str3);
            } else {
                if (R.O()) {
                    zzgc zzu = zzgd.zzu();
                    zzu.zzad(1);
                    zzu.zzZ("android");
                    if (!TextUtils.isEmpty(R.l0())) {
                        zzu.zzD(R.l0());
                    }
                    if (!TextUtils.isEmpty(R.n0())) {
                        zzu.zzF((String) com.google.android.gms.common.internal.r.m(R.n0()));
                    }
                    if (!TextUtils.isEmpty(R.o0())) {
                        zzu.zzG((String) com.google.android.gms.common.internal.r.m(R.o0()));
                    }
                    if (R.R() != -2147483648L) {
                        zzu.zzH((int) R.R());
                    }
                    zzu.zzV(R.c0());
                    zzu.zzP(R.a0());
                    String a = R.a();
                    String j0 = R.j0();
                    if (!TextUtils.isEmpty(a)) {
                        zzu.zzU(a);
                    } else if (!TextUtils.isEmpty(j0)) {
                        zzu.zzC(j0);
                    }
                    zzpz.zzc();
                    if (d0.a.z().B(null, m1.G0)) {
                        zzu.zzaj(R.h0());
                    }
                    K2 c0 = d0.b.c0(str3);
                    zzu.zzM(R.Z());
                    if (d0.a.o() && d0.a.z().C(zzu.zzaq()) && c0.j(J2.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                        zzu.zzO(null);
                    }
                    zzu.zzL(c0.i());
                    if (c0.j(J2.AD_STORAGE) && R.N()) {
                        Pair n = d0.b.e0().n(R.l0(), c0);
                        if (R.N() && !TextUtils.isEmpty((CharSequence) n.first)) {
                            try {
                                zzu.zzae(y3.e((String) n.first, Long.toString(vVar.i)));
                                Object obj = n.second;
                                if (obj != null) {
                                    zzu.zzX(((Boolean) obj).booleanValue());
                                }
                            } catch (SecurityException e) {
                                d0.a.d().q().b("Resettable device id encryption failed", e.getMessage());
                            }
                        }
                    }
                    d0.a.A().k();
                    zzu.zzN(Build.MODEL);
                    d0.a.A().k();
                    zzu.zzY(Build.VERSION.RELEASE);
                    zzu.zzak((int) d0.a.A().p());
                    zzu.zzao(d0.a.A().q());
                    try {
                        if (c0.j(J2.ANALYTICS_STORAGE) && R.m0() != null) {
                            zzu.zzE(y3.e((String) com.google.android.gms.common.internal.r.m(R.m0()), Long.toString(vVar.i)));
                        }
                        if (!TextUtils.isEmpty(R.p0())) {
                            zzu.zzT((String) com.google.android.gms.common.internal.r.m(R.p0()));
                        }
                        String l0 = R.l0();
                        List c02 = d0.b.V().c0(l0);
                        Iterator it = c02.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                x4 = null;
                                break;
                            }
                            x4 = (X4) it.next();
                            if ("_lte".equals(x4.c)) {
                                break;
                            }
                        }
                        if (x4 == null || x4.e == null) {
                            X4 x42 = new X4(l0, "auto", "_lte", d0.a.a().a(), 0L);
                            c02.add(x42);
                            d0.b.V().x(x42);
                        }
                        U4 g0 = d0.b.g0();
                        g0.a.d().v().a("Checking account type status for ad personalization signals");
                        if (g0.a.A().s()) {
                            String l02 = R.l0();
                            com.google.android.gms.common.internal.r.m(l02);
                            if (R.N() && g0.b.Z().B(l02)) {
                                g0.a.d().q().a("Turning off ad personalization due to account type");
                                Iterator it2 = c02.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    if ("_npa".equals(((X4) it2.next()).c)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                c02.add(new X4(l02, "auto", "_npa", g0.a.a().a(), 1L));
                            }
                        }
                        zzgm[] zzgmVarArr = new zzgm[c02.size()];
                        for (int i = 0; i < c02.size(); i++) {
                            zzgl zzd = zzgm.zzd();
                            zzd.zzf(((X4) c02.get(i)).c);
                            zzd.zzg(((X4) c02.get(i)).d);
                            d0.b.g0().M(zzd, ((X4) c02.get(i)).e);
                            zzgmVarArr[i] = (zzgm) zzd.zzaD();
                        }
                        zzu.zzj(Arrays.asList(zzgmVarArr));
                        A1 b = A1.b(vVar);
                        d0.a.N().z(b.d, d0.b.V().Q(str3));
                        d0.a.N().B(b, d0.a.z().n(str3));
                        Bundle bundle2 = b.d;
                        bundle2.putLong("_c", 1L);
                        d0.a.d().q().a("Marking in-app purchase as real-time");
                        bundle2.putLong("_r", 1L);
                        bundle2.putString("_o", vVar.h);
                        if (d0.a.N().U(zzu.zzaq())) {
                            d0.a.N().D(bundle2, "_dbg", 1L);
                            d0.a.N().D(bundle2, "_r", 1L);
                        }
                        r V = d0.b.V().V(str3, vVar.f);
                        if (V == null) {
                            zzgcVar = zzu;
                            i2 = R;
                            zzgaVar = zza;
                            str = str3;
                            bundle = bundle2;
                            str2 = null;
                            c = new r(str3, vVar.f, 0L, 0L, 0L, vVar.i, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            i2 = R;
                            zzgaVar = zza;
                            str = str3;
                            bundle = bundle2;
                            zzgcVar = zzu;
                            str2 = null;
                            long j2 = V.f;
                            c = V.c(vVar.i);
                            j = j2;
                        }
                        d0.b.V().q(c);
                        q qVar = new q(d0.a, vVar.h, str, vVar.f, vVar.i, j, bundle);
                        zzfs zze = zzft.zze();
                        zze.zzm(qVar.d);
                        zze.zzi(qVar.b);
                        zze.zzl(qVar.e);
                        s sVar = new s(qVar.f);
                        while (sVar.hasNext()) {
                            String next = sVar.next();
                            zzfw zze2 = zzfx.zze();
                            zze2.zzj(next);
                            Object M = qVar.f.M(next);
                            if (M != null) {
                                d0.b.g0().L(zze2, M);
                                zze.zze(zze2);
                            }
                        }
                        zzgc zzgcVar2 = zzgcVar;
                        zzgcVar2.zzk(zze);
                        zzge zza2 = zzgg.zza();
                        zzfu zza3 = zzfv.zza();
                        zza3.zza(c.c);
                        zza3.zzb(vVar.f);
                        zza2.zza(zza3);
                        zzgcVar2.zzaa(zza2);
                        zzgcVar2.zzf(d0.b.T().m(i2.l0(), Collections.emptyList(), zzgcVar2.zzau(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                        if (zze.zzq()) {
                            zzgcVar2.zzai(zze.zzc());
                            zzgcVar2.zzQ(zze.zzc());
                        }
                        long d02 = i2.d0();
                        if (d02 != 0) {
                            zzgcVar2.zzab(d02);
                        }
                        long f0 = i2.f0();
                        if (f0 != 0) {
                            zzgcVar2.zzac(f0);
                        } else if (d02 != 0) {
                            zzgcVar2.zzac(d02);
                        }
                        String d = i2.d();
                        zzqu.zzc();
                        String str4 = str;
                        if (d0.a.z().B(str4, m1.q0) && d != null) {
                            zzgcVar2.zzah(d);
                        }
                        i2.g();
                        zzgcVar2.zzI((int) i2.e0());
                        d0.a.z().q();
                        zzgcVar2.zzam(79000L);
                        zzgcVar2.zzal(d0.a.a().a());
                        zzgcVar2.zzag(true);
                        if (d0.a.z().B(str2, m1.u0)) {
                            d0.b.h(zzgcVar2.zzaq(), zzgcVar2);
                        }
                        zzga zzgaVar2 = zzgaVar;
                        zzgaVar2.zza(zzgcVar2);
                        I2 i22 = i2;
                        i22.E(zzgcVar2.zzd());
                        i22.C(zzgcVar2.zzc());
                        d0.b.V().p(i22);
                        d0.b.V().o();
                        d0.b.V().f0();
                        try {
                            return d0.b.g0().Q(((zzgb) zzgaVar2.zzaD()).zzbx());
                        } catch (IOException e2) {
                            d0.a.d().r().c("Data loss. Failed to bundle and serialize. appId", z1.z(str4), e2);
                            return str2;
                        }
                    } catch (SecurityException e3) {
                        d0.a.d().q().b("app instance id encryption failed", e3.getMessage());
                        byte[] bArr = new byte[0];
                        d0.b.V().f0();
                        return bArr;
                    }
                }
                d0.a.d().q().b("Log and bundle disabled. package_name", str3);
            }
            byte[] bArr2 = new byte[0];
            d0.b.V().f0();
            return bArr2;
        } catch (Throwable th) {
            d0.b.V().f0();
            throw th;
        }
    }
}
