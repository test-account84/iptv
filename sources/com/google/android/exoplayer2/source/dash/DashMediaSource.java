package com.google.android.exoplayer2.source.dash;

import B3.C;
import B3.J;
import B3.i;
import B3.j;
import B3.u;
import B3.x;
import B3.z;
import O2.H0;
import O2.Q1;
import O2.l1;
import O2.w0;
import V2.B;
import V2.l;
import V2.y;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import b4.A;
import b4.F;
import b4.G;
import b4.H;
import b4.I;
import b4.S;
import b4.o;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.d;
import d4.T;
import d4.k0;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z3.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class DashMediaSource extends B3.a {
    public final H A;
    public o B;
    public G C;
    public S D;
    public IOException E;
    public Handler F;
    public H0.g G;
    public Uri H;
    public Uri I;
    public F3.c J;
    public boolean K;
    public long L;
    public long M;
    public long N;
    public int O;
    public long P;
    public int Q;
    public final H0 i;
    public final boolean j;
    public final o.a k;
    public final a.a l;
    public final i m;
    public final y n;
    public final F o;
    public final E3.b p;
    public final long q;
    public final long r;
    public final J.a s;
    public final I.a t;
    public final e u;
    public final Object v;
    public final SparseArray w;
    public final Runnable x;
    public final Runnable y;
    public final d.b z;

    public static final class Factory implements C.a {
        public final a.a a;
        public final o.a b;
        public B c;
        public i d;
        public F e;
        public long f;
        public long g;
        public I.a h;

        public Factory(o.a aVar) {
            this(new c.a(aVar), aVar);
        }

        public int[] c() {
            return new int[]{0};
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public DashMediaSource b(H0 h0) {
            d4.a.e(h0.c);
            I.a aVar = this.h;
            if (aVar == null) {
                aVar = new F3.d();
            }
            List list = h0.c.f;
            return new DashMediaSource(h0, null, this.b, !list.isEmpty() ? new D(aVar, list) : aVar, this.a, this.d, null, this.c.a(h0), this.e, this.f, this.g, null);
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory d(B b) {
            this.c = (B) d4.a.f(b, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory a(F f) {
            this.e = (F) d4.a.f(f, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(a.a aVar, o.a aVar2) {
            this.a = (a.a) d4.a.e(aVar);
            this.b = aVar2;
            this.c = new l();
            this.e = new A();
            this.f = 30000L;
            this.g = 5000000L;
            this.d = new j();
        }
    }

    public class a implements T.b {
        public a() {
        }

        public void a(IOException iOException) {
            DashMediaSource.r0(DashMediaSource.this, iOException);
        }

        public void b() {
            DashMediaSource.q0(DashMediaSource.this, T.h());
        }
    }

    public static final class b extends Q1 {
        public final long g;
        public final long h;
        public final long i;
        public final int j;
        public final long k;
        public final long l;
        public final long m;
        public final F3.c n;
        public final H0 o;
        public final H0.g p;

        public b(long j, long j2, long j3, int i, long j4, long j5, long j6, F3.c cVar, H0 h0, H0.g gVar) {
            d4.a.g(cVar.d == (gVar != null));
            this.g = j;
            this.h = j2;
            this.i = j3;
            this.j = i;
            this.k = j4;
            this.l = j5;
            this.m = j6;
            this.n = cVar;
            this.o = h0;
            this.p = gVar;
        }

        public static boolean y(F3.c cVar) {
            return cVar.d && cVar.e != -9223372036854775807L && cVar.b == -9223372036854775807L;
        }

        public int f(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.j) >= 0 && intValue < n()) {
                return intValue;
            }
            return -1;
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            d4.a.c(i, 0, n());
            return bVar.y(z ? this.n.d(i).a : null, z ? Integer.valueOf(this.j + i) : null, 0, this.n.g(i), k0.P0(this.n.d(i).b - this.n.d(0).b) - this.k);
        }

        public int n() {
            return this.n.e();
        }

        public Object r(int i) {
            d4.a.c(i, 0, n());
            return Integer.valueOf(this.j + i);
        }

        public Q1.d t(int i, Q1.d dVar, long j) {
            d4.a.c(i, 0, 1);
            long x = x(j);
            Object obj = Q1.d.s;
            H0 h0 = this.o;
            F3.c cVar = this.n;
            return dVar.j(obj, h0, cVar, this.g, this.h, this.i, true, y(cVar), this.p, x, this.l, 0, n() - 1, this.k);
        }

        public int u() {
            return 1;
        }

        public final long x(long j) {
            E3.f b;
            long j2 = this.m;
            if (!y(this.n)) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.l) {
                    return -9223372036854775807L;
                }
            }
            long j3 = this.k + j2;
            long g = this.n.g(0);
            int i = 0;
            while (i < this.n.e() - 1 && j3 >= g) {
                j3 -= g;
                i++;
                g = this.n.g(i);
            }
            F3.g d = this.n.d(i);
            int a = d.a(2);
            return (a == -1 || (b = ((F3.j) ((F3.a) d.c.get(a)).c.get(0)).b()) == null || b.i(g) == 0) ? j2 : (j2 + b.c(b.h(j3, g))) - j3;
        }
    }

    public final class c implements d.b {
        public c() {
        }

        public void a(long j) {
            DashMediaSource.this.C0(j);
        }

        public void b() {
            DashMediaSource.this.D0();
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public static final class d implements I.a {
        public static final Pattern a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, r5.d.c)).readLine();
            try {
                Matcher matcher = a.matcher(readLine);
                if (!matcher.matches()) {
                    throw l1.c("Couldn't parse timestamp: " + readLine, null);
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j * (((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0L : Long.parseLong(group2))) * 60000);
                }
                return Long.valueOf(time);
            } catch (ParseException e) {
                throw l1.c(null, e);
            }
        }
    }

    public final class e implements G.b {
        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void t(I i, long j, long j2, boolean z) {
            DashMediaSource.this.E0(i, j, j2);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void W(I i, long j, long j2) {
            DashMediaSource.this.F0(i, j, j2);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public G.c j(I i, long j, long j2, IOException iOException, int i2) {
            return DashMediaSource.this.G0(i, j, j2, iOException, i2);
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public final class f implements H {
        public f() {
        }

        public void a() {
            DashMediaSource.s0(DashMediaSource.this).a();
            b();
        }

        public final void b() {
            if (DashMediaSource.t0(DashMediaSource.this) != null) {
                throw DashMediaSource.t0(DashMediaSource.this);
            }
        }
    }

    public final class g implements G.b {
        public g() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void t(I i, long j, long j2, boolean z) {
            DashMediaSource.this.E0(i, j, j2);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void W(I i, long j, long j2) {
            DashMediaSource.this.H0(i, j, j2);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public G.c j(I i, long j, long j2, IOException iOException, int i2) {
            return DashMediaSource.this.I0(i, j, j2, iOException);
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    public static final class h implements I.a {
        public h() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) {
            return Long.valueOf(k0.W0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        w0.a("goog.exo.dash");
    }

    public DashMediaSource(H0 h0, F3.c cVar, o.a aVar, I.a aVar2, a.a aVar3, i iVar, b4.h hVar, y yVar, F f2, long j, long j2) {
        this.i = h0;
        this.G = h0.e;
        this.H = ((H0.h) d4.a.e(h0.c)).a;
        this.I = h0.c.a;
        this.J = cVar;
        this.k = aVar;
        this.t = aVar2;
        this.l = aVar3;
        this.n = yVar;
        this.o = f2;
        this.q = j;
        this.r = j2;
        this.m = iVar;
        this.p = new E3.b();
        boolean z = cVar != null;
        this.j = z;
        this.s = f0(null);
        this.v = new Object();
        this.w = new SparseArray();
        this.z = new c(this, null);
        this.P = -9223372036854775807L;
        this.N = -9223372036854775807L;
        if (!z) {
            this.u = new e(this, null);
            this.A = new f();
            this.x = new E3.d(this);
            this.y = new E3.e(this);
            return;
        }
        d4.a.g(true ^ cVar.d);
        this.u = null;
        this.x = null;
        this.y = null;
        this.A = new H.a();
    }

    private /* synthetic */ void A0() {
        L0(false);
    }

    private void R0() {
        Uri uri;
        this.F.removeCallbacks(this.x);
        if (this.C.i()) {
            return;
        }
        if (this.C.j()) {
            this.K = true;
            return;
        }
        synchronized (this.v) {
            uri = this.H;
        }
        this.K = false;
        Q0(new I(this.B, uri, 4, this.t), this.u, this.o.b(4));
    }

    public static /* synthetic */ void o0(DashMediaSource dashMediaSource) {
        dashMediaSource.A0();
    }

    public static /* synthetic */ void p0(DashMediaSource dashMediaSource) {
        dashMediaSource.R0();
    }

    public static /* synthetic */ void q0(DashMediaSource dashMediaSource, long j) {
        dashMediaSource.K0(j);
    }

    public static /* synthetic */ void r0(DashMediaSource dashMediaSource, IOException iOException) {
        dashMediaSource.J0(iOException);
    }

    public static /* synthetic */ G s0(DashMediaSource dashMediaSource) {
        return dashMediaSource.C;
    }

    public static /* synthetic */ IOException t0(DashMediaSource dashMediaSource) {
        return dashMediaSource.E;
    }

    public static long u0(F3.g gVar, long j, long j2) {
        long P0 = k0.P0(gVar.b);
        boolean y0 = y0(gVar);
        long j3 = Long.MAX_VALUE;
        for (int i = 0; i < gVar.c.size(); i++) {
            F3.a aVar = (F3.a) gVar.c.get(i);
            List list = aVar.c;
            int i2 = aVar.b;
            boolean z = (i2 == 1 || i2 == 2) ? false : true;
            if ((!y0 || !z) && !list.isEmpty()) {
                E3.f b2 = ((F3.j) list.get(0)).b();
                if (b2 == null) {
                    return P0 + j;
                }
                long l = b2.l(j, j2);
                if (l == 0) {
                    return P0;
                }
                long e2 = (b2.e(j, j2) + l) - 1;
                j3 = Math.min(j3, b2.d(e2, j) + b2.c(e2) + P0);
            }
        }
        return j3;
    }

    public static long v0(F3.g gVar, long j, long j2) {
        long P0 = k0.P0(gVar.b);
        boolean y0 = y0(gVar);
        long j3 = P0;
        for (int i = 0; i < gVar.c.size(); i++) {
            F3.a aVar = (F3.a) gVar.c.get(i);
            List list = aVar.c;
            int i2 = aVar.b;
            boolean z = (i2 == 1 || i2 == 2) ? false : true;
            if ((!y0 || !z) && !list.isEmpty()) {
                E3.f b2 = ((F3.j) list.get(0)).b();
                if (b2 == null) {
                    return P0;
                }
                if (b2.l(j, j2) == 0) {
                    return P0;
                }
                j3 = Math.max(j3, b2.c(b2.e(j, j2)) + P0);
            }
        }
        return j3;
    }

    public static long w0(F3.c cVar, long j) {
        E3.f b2;
        int e2 = cVar.e() - 1;
        F3.g d2 = cVar.d(e2);
        long P0 = k0.P0(d2.b);
        long g2 = cVar.g(e2);
        long P02 = k0.P0(j);
        long P03 = k0.P0(cVar.a);
        long P04 = k0.P0(5000L);
        for (int i = 0; i < d2.c.size(); i++) {
            List list = ((F3.a) d2.c.get(i)).c;
            if (!list.isEmpty() && (b2 = ((F3.j) list.get(0)).b()) != null) {
                long f2 = ((P03 + P0) + b2.f(g2, P02)) - P02;
                if (f2 < P04 - 100000 || (f2 > P04 && f2 < P04 + 100000)) {
                    P04 = f2;
                }
            }
        }
        return v5.e.a(P04, 1000L, RoundingMode.CEILING);
    }

    public static boolean y0(F3.g gVar) {
        for (int i = 0; i < gVar.c.size(); i++) {
            int i2 = ((F3.a) gVar.c.get(i)).b;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean z0(F3.g gVar) {
        for (int i = 0; i < gVar.c.size(); i++) {
            E3.f b2 = ((F3.j) ((F3.a) gVar.c.get(i)).c.get(0)).b();
            if (b2 == null || b2.j()) {
                return true;
            }
        }
        return false;
    }

    public final void B0() {
        T.j(this.C, new a());
    }

    public void C0(long j) {
        long j2 = this.P;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.P = j;
        }
    }

    public void D0() {
        this.F.removeCallbacks(this.y);
        R0();
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        int intValue = ((Integer) bVar.a).intValue() - this.Q;
        J.a f0 = f0(bVar);
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(intValue + this.Q, this.J, this.p, intValue, this.l, this.D, null, this.n, b0(bVar), this.o, f0, this.N, this.A, bVar2, this.m, this.z, i0());
        this.w.put(bVar3.a, bVar3);
        return bVar3;
    }

    public void E0(I i, long j, long j2) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        this.o.d(i.a);
        this.s.p(uVar, i.d);
    }

    public void F0(I i, long j, long j2) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        this.o.d(i.a);
        this.s.s(uVar, i.d);
        F3.c cVar = (F3.c) i.e();
        F3.c cVar2 = this.J;
        int e2 = cVar2 == null ? 0 : cVar2.e();
        long j3 = cVar.d(0).b;
        int i2 = 0;
        while (i2 < e2 && this.J.d(i2).b < j3) {
            i2++;
        }
        if (cVar.d) {
            if (e2 - i2 > cVar.e()) {
                d4.B.j("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j4 = this.P;
                if (j4 == -9223372036854775807L || cVar.h * 1000 > j4) {
                    this.O = 0;
                } else {
                    d4.B.j("DashMediaSource", "Loaded stale dynamic manifest: " + cVar.h + ", " + this.P);
                }
            }
            int i3 = this.O;
            this.O = i3 + 1;
            if (i3 < this.o.b(i.d)) {
                P0(x0());
                return;
            } else {
                this.E = new E3.c();
                return;
            }
        }
        this.J = cVar;
        this.K = cVar.d & this.K;
        this.L = j - j2;
        this.M = j;
        synchronized (this.v) {
            try {
                if (i.c.a == this.H) {
                    Uri uri = this.J.k;
                    if (uri == null) {
                        uri = i.f();
                    }
                    this.H = uri;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (e2 == 0) {
            F3.c cVar3 = this.J;
            if (cVar3.d) {
                F3.o oVar = cVar3.i;
                if (oVar != null) {
                    M0(oVar);
                    return;
                } else {
                    B0();
                    return;
                }
            }
        } else {
            this.Q += i2;
        }
        L0(true);
    }

    public G.c G0(I i, long j, long j2, IOException iOException, int i2) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        long c2 = this.o.c(new F.c(uVar, new x(i.d), iOException, i2));
        G.c h2 = c2 == -9223372036854775807L ? G.g : G.h(false, c2);
        boolean z = !h2.c();
        this.s.w(uVar, i.d, iOException, z);
        if (z) {
            this.o.d(i.a);
        }
        return h2;
    }

    public void H0(I i, long j, long j2) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        this.o.d(i.a);
        this.s.s(uVar, i.d);
        K0(((Long) i.e()).longValue() - j);
    }

    public G.c I0(I i, long j, long j2, IOException iOException) {
        this.s.w(new u(i.a, i.c, i.f(), i.d(), j, j2, i.b()), i.d, iOException, true);
        this.o.d(i.a);
        J0(iOException);
        return G.f;
    }

    public final void J0(IOException iOException) {
        d4.B.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        L0(true);
    }

    public final void K0(long j) {
        this.N = j;
        L0(true);
    }

    public final void L0(boolean z) {
        F3.g gVar;
        long j;
        long j2;
        for (int i = 0; i < this.w.size(); i++) {
            int keyAt = this.w.keyAt(i);
            if (keyAt >= this.Q) {
                ((com.google.android.exoplayer2.source.dash.b) this.w.valueAt(i)).M(this.J, keyAt - this.Q);
            }
        }
        F3.g d2 = this.J.d(0);
        int e2 = this.J.e() - 1;
        F3.g d3 = this.J.d(e2);
        long g2 = this.J.g(e2);
        long P0 = k0.P0(k0.g0(this.N));
        long v0 = v0(d2, this.J.g(0), P0);
        long u0 = u0(d3, g2, P0);
        boolean z2 = this.J.d && !z0(d3);
        if (z2) {
            long j3 = this.J.f;
            if (j3 != -9223372036854775807L) {
                v0 = Math.max(v0, u0 - k0.P0(j3));
            }
        }
        long j4 = u0 - v0;
        F3.c cVar = this.J;
        if (cVar.d) {
            d4.a.g(cVar.a != -9223372036854775807L);
            long P02 = (P0 - k0.P0(this.J.a)) - v0;
            S0(P02, j4);
            long x1 = this.J.a + k0.x1(v0);
            long P03 = P02 - k0.P0(this.G.a);
            long min = Math.min(this.r, j4 / 2);
            j = x1;
            j2 = P03 < min ? min : P03;
            gVar = d2;
        } else {
            gVar = d2;
            j = -9223372036854775807L;
            j2 = 0;
        }
        long P04 = v0 - k0.P0(gVar.b);
        F3.c cVar2 = this.J;
        m0(new b(cVar2.a, j, this.N, this.Q, P04, j4, j2, cVar2, this.i, cVar2.d ? this.G : null));
        if (this.j) {
            return;
        }
        this.F.removeCallbacks(this.y);
        if (z2) {
            this.F.postDelayed(this.y, w0(this.J, k0.g0(this.N)));
        }
        if (this.K) {
            R0();
            return;
        }
        if (z) {
            F3.c cVar3 = this.J;
            if (cVar3.d) {
                long j5 = cVar3.e;
                if (j5 != -9223372036854775807L) {
                    if (j5 == 0) {
                        j5 = 5000;
                    }
                    P0(Math.max(0L, (this.L + j5) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public final void M0(F3.o oVar) {
        I.a dVar;
        String str = oVar.a;
        if (k0.c(str, "urn:mpeg:dash:utc:direct:2014") || k0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            N0(oVar);
            return;
        }
        if (k0.c(str, "urn:mpeg:dash:utc:http-iso:2014") || k0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            dVar = new d();
        } else {
            if (!k0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !k0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                if (k0.c(str, "urn:mpeg:dash:utc:ntp:2014") || k0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
                    B0();
                    return;
                } else {
                    J0(new IOException("Unsupported UTC timing scheme"));
                    return;
                }
            }
            dVar = new h(null);
        }
        O0(oVar, dVar);
    }

    public final void N0(F3.o oVar) {
        try {
            K0(k0.W0(oVar.b) - this.M);
        } catch (l1 e2) {
            J0(e2);
        }
    }

    public final void O0(F3.o oVar, I.a aVar) {
        Q0(new I(this.B, Uri.parse(oVar.b), 5, aVar), new g(this, null), 1);
    }

    public void P() {
        this.A.a();
    }

    public final void P0(long j) {
        this.F.postDelayed(this.x, j);
    }

    public final void Q0(I i, G.b bVar, int i2) {
        this.s.y(new u(i.a, i.c, this.C.n(i, bVar, i2)), i.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[PHI: r1
      0x0052: PHI (r1v37 long) = (r1v12 long), (r1v15 long) binds: [B:13:0x0050, B:61:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0015 A[PHI: r1
      0x0015: PHI (r1v41 long) = (r1v2 long), (r1v5 long) binds: [B:2:0x0013, B:65:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S0(long r18, long r20) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.S0(long, long):void");
    }

    public void Y(z zVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) zVar;
        bVar.I();
        this.w.remove(bVar.a);
    }

    public H0 e() {
        return this.i;
    }

    public void l0(S s) {
        this.D = s;
        this.n.b(Looper.myLooper(), i0());
        this.n.prepare();
        if (this.j) {
            L0(false);
            return;
        }
        this.B = this.k.a();
        this.C = new G("DashMediaSource");
        this.F = k0.x();
        R0();
    }

    public void n0() {
        this.K = false;
        this.B = null;
        G g2 = this.C;
        if (g2 != null) {
            g2.l();
            this.C = null;
        }
        this.L = 0L;
        this.M = 0L;
        this.J = this.j ? this.J : null;
        this.H = this.I;
        this.E = null;
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.F = null;
        }
        this.N = -9223372036854775807L;
        this.O = 0;
        this.P = -9223372036854775807L;
        this.w.clear();
        this.p.i();
        this.n.release();
    }

    public final long x0() {
        return Math.min((this.O - 1) * 1000, 5000);
    }

    public /* synthetic */ DashMediaSource(H0 h0, F3.c cVar, o.a aVar, I.a aVar2, a.a aVar3, i iVar, b4.h hVar, y yVar, F f2, long j, long j2, a aVar4) {
        this(h0, cVar, aVar, aVar2, aVar3, iVar, hVar, yVar, f2, j, j2);
    }
}
