package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class is implements hw, it {
    private boolean A;
    private final Context a;
    private final iu b;
    private final PlaybackSession c;
    private String i;
    private PlaybackMetrics.Builder j;
    private int k;
    private at n;
    private ir o;
    private ir p;
    private ir q;
    private s r;
    private s s;
    private s t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private final bd e = new bd();
    private final bc f = new bc();
    private final HashMap h = new HashMap();
    private final HashMap g = new HashMap();
    private final long d = SystemClock.elapsedRealtime();
    private int l = 0;
    private int m = 0;

    private is(Context context, PlaybackSession playbackSession) {
        this.a = context.getApplicationContext();
        this.c = playbackSession;
        ip ipVar = new ip();
        this.b = ipVar;
        ipVar.g(this);
    }

    public static is k(Context context) {
        MediaMetricsManager a = M0.a(context.getSystemService("media_metrics"));
        if (a == null) {
            return null;
        }
        return new is(context, N0.a(a));
    }

    @SuppressLint({"SwitchIntDef"})
    private static int n(int i) {
        switch (cq.i(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void o() {
        PlaybackMetrics.Builder builder = this.j;
        if (builder != null && this.A) {
            i0.a(builder, this.z);
            j0.a(this.j, this.x);
            k0.a(this.j, this.y);
            Long l = (Long) this.g.get(this.i);
            m0.a(this.j, l == null ? 0L : l.longValue());
            Long l2 = (Long) this.h.get(this.i);
            n0.a(this.j, l2 == null ? 0L : l2.longValue());
            o0.a(this.j, (l2 == null || l2.longValue() <= 0) ? 0 : 1);
            q0.a(this.c, p0.a(this.j));
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    private final void p(long j, s sVar, int i) {
        if (cq.V(this.s, sVar)) {
            return;
        }
        int i2 = (this.s == null && i == 0) ? 1 : i;
        this.s = sVar;
        t(0, j, sVar, i2);
    }

    private final void q(long j, s sVar, int i) {
        if (cq.V(this.t, sVar)) {
            return;
        }
        int i2 = (this.t == null && i == 0) ? 1 : i;
        this.t = sVar;
        t(2, j, sVar, i2);
    }

    private final void r(be beVar, te teVar) {
        int a;
        int i;
        PlaybackMetrics.Builder builder = this.j;
        if (teVar == null || (a = beVar.a(teVar.a)) == -1) {
            return;
        }
        beVar.m(a, this.f);
        beVar.o(this.f.c, this.e);
        ad adVar = this.e.c.b;
        if (adVar == null) {
            i = 0;
        } else {
            int m = cq.m(adVar.a);
            i = m != 0 ? m != 1 ? m != 2 ? 1 : 4 : 5 : 3;
        }
        J0.a(builder, i);
        bd bdVar = this.e;
        if (bdVar.n != -9223372036854775807L && !bdVar.l && !bdVar.i && !bdVar.c()) {
            K0.a(builder, this.e.b());
        }
        L0.a(builder, true != this.e.c() ? 1 : 2);
        this.A = true;
    }

    private final void s(long j, s sVar, int i) {
        if (cq.V(this.r, sVar)) {
            return;
        }
        int i2 = (this.r == null && i == 0) ? 1 : i;
        this.r = sVar;
        t(1, j, sVar, i2);
    }

    private final void t(int i, long j, s sVar, int i2) {
        int i3;
        TrackChangeEvent.Builder a = r0.a(U0.a(i), j - this.d);
        if (sVar != null) {
            z0.a(a, 1);
            if (i2 != 1) {
                i3 = 3;
                if (i2 != 2) {
                    i3 = i2 != 3 ? 1 : 4;
                }
            } else {
                i3 = 2;
            }
            A0.a(a, i3);
            String str = sVar.k;
            if (str != null) {
                B0.a(a, str);
            }
            String str2 = sVar.l;
            if (str2 != null) {
                C0.a(a, str2);
            }
            String str3 = sVar.i;
            if (str3 != null) {
                D0.a(a, str3);
            }
            int i4 = sVar.h;
            if (i4 != -1) {
                E0.a(a, i4);
            }
            int i5 = sVar.q;
            if (i5 != -1) {
                F0.a(a, i5);
            }
            int i6 = sVar.r;
            if (i6 != -1) {
                G0.a(a, i6);
            }
            int i7 = sVar.y;
            if (i7 != -1) {
                I0.a(a, i7);
            }
            int i8 = sVar.z;
            if (i8 != -1) {
                s0.a(a, i8);
            }
            String str4 = sVar.c;
            if (str4 != null) {
                String[] ak = cq.ak(str4, "-");
                Pair create = Pair.create(ak[0], ak.length >= 2 ? ak[1] : null);
                t0.a(a, (String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    u0.a(a, (String) obj);
                }
            }
            float f = sVar.s;
            if (f != -1.0f) {
                v0.a(a, f);
            }
        } else {
            z0.a(a, 0);
        }
        this.A = true;
        y0.a(this.c, x0.a(a));
    }

    private final boolean u(ir irVar) {
        return irVar != null && irVar.c.equals(this.b.d());
    }

    public final void a(hv hvVar, tb tbVar) {
        if (hvVar.d == null) {
            return;
        }
        s sVar = tbVar.c;
        af.s(sVar);
        int i = tbVar.d;
        iu iuVar = this.b;
        be beVar = hvVar.b;
        te teVar = hvVar.d;
        af.s(teVar);
        ir irVar = new ir(sVar, i, iuVar.e(beVar, teVar));
        int i2 = tbVar.b;
        if (i2 != 0) {
            if (i2 == 1) {
                this.p = irVar;
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.q = irVar;
                return;
            }
        }
        this.o = irVar;
    }

    public final void b(hv hvVar, at atVar) {
        this.n = atVar;
    }

    public final void c(hv hvVar, int i, long j) {
        te teVar = hvVar.d;
        if (teVar != null) {
            iu iuVar = this.b;
            be beVar = hvVar.b;
            af.s(teVar);
            String e = iuVar.e(beVar, teVar);
            Long l = (Long) this.h.get(e);
            Long l2 = (Long) this.g.get(e);
            this.h.put(e, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.g.put(e, Long.valueOf((l2 != null ? l2.longValue() : 0L) + i));
        }
    }

    public final void d(tb tbVar) {
        this.v = tbVar.a;
    }

    public final /* synthetic */ void e(int i) {
    }

    public final void f(int i) {
        if (i == 1) {
            this.u = true;
            i = 1;
        }
        this.k = i;
    }

    public final void g(ep epVar) {
        this.x += epVar.g;
        this.y += epVar.e;
    }

    public final void h(bl blVar) {
        ir irVar = this.o;
        if (irVar != null) {
            s sVar = irVar.a;
            if (sVar.r == -1) {
                r b = sVar.b();
                b.aj(blVar.b);
                b.Q(blVar.c);
                this.o = new ir(b.v(), irVar.b, irVar.c);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x034a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(com.google.ads.interactivemedia.v3.internal.az r18, com.google.ads.interactivemedia.v3.internal.aeq r19) {
        /*
            Method dump skipped, instructions count: 1176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.is.i(com.google.ads.interactivemedia.v3.internal.az, com.google.ads.interactivemedia.v3.internal.aeq):void");
    }

    public final LogSessionId j() {
        return h0.a(this.c);
    }

    public final void l(hv hvVar, String str) {
        te teVar = hvVar.d;
        if (teVar == null || !teVar.b()) {
            o();
            this.i = str;
            this.j = P0.a(O0.a(V0.a(), "AndroidXMedia3"), "1.0.0-beta02");
            r(hvVar.b, hvVar.d);
        }
    }

    public final void m(hv hvVar, String str) {
        te teVar = hvVar.d;
        if ((teVar == null || !teVar.b()) && str.equals(this.i)) {
            o();
        }
        this.g.remove(str);
        this.h.remove(str);
    }
}
