package P2;

import B3.C;
import O2.H0;
import O2.Q1;
import O2.R0;
import O2.V1;
import O2.l1;
import O2.p1;
import O2.s1;
import O2.t1;
import O2.z0;
import P2.c;
import P2.u0;
import Q2.B;
import V2.h;
import V2.o;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import b4.B;
import b4.C;
import b4.T;
import com.google.ads.interactivemedia.v3.internal.A0;
import com.google.ads.interactivemedia.v3.internal.B0;
import com.google.ads.interactivemedia.v3.internal.C0;
import com.google.ads.interactivemedia.v3.internal.D0;
import com.google.ads.interactivemedia.v3.internal.E0;
import com.google.ads.interactivemedia.v3.internal.F0;
import com.google.ads.interactivemedia.v3.internal.G0;
import com.google.ads.interactivemedia.v3.internal.I0;
import com.google.ads.interactivemedia.v3.internal.J0;
import com.google.ads.interactivemedia.v3.internal.K0;
import com.google.ads.interactivemedia.v3.internal.L0;
import com.google.ads.interactivemedia.v3.internal.M0;
import com.google.ads.interactivemedia.v3.internal.N0;
import com.google.ads.interactivemedia.v3.internal.O0;
import com.google.ads.interactivemedia.v3.internal.P0;
import com.google.ads.interactivemedia.v3.internal.Q0;
import com.google.ads.interactivemedia.v3.internal.S0;
import com.google.ads.interactivemedia.v3.internal.T0;
import com.google.ads.interactivemedia.v3.internal.U0;
import com.google.ads.interactivemedia.v3.internal.V0;
import com.google.ads.interactivemedia.v3.internal.W0;
import com.google.ads.interactivemedia.v3.internal.X0;
import com.google.ads.interactivemedia.v3.internal.Y0;
import com.google.ads.interactivemedia.v3.internal.Z0;
import com.google.ads.interactivemedia.v3.internal.a1;
import com.google.ads.interactivemedia.v3.internal.w0;
import com.google.ads.interactivemedia.v3.internal.x0;
import com.google.ads.interactivemedia.v3.internal.y0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import p3.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t0 implements c, u0.a {
    public boolean A;
    public final Context a;
    public final u0 b;
    public final PlaybackSession c;
    public String i;
    public PlaybackMetrics.Builder j;
    public int k;
    public p1 n;
    public b o;
    public b p;
    public b q;
    public z0 r;
    public z0 s;
    public z0 t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public int z;
    public final Q1.d e = new Q1.d();
    public final Q1.b f = new Q1.b();
    public final HashMap h = new HashMap();
    public final HashMap g = new HashMap();
    public final long d = SystemClock.elapsedRealtime();
    public int l = 0;
    public int m = 0;

    public static final class a {
        public final int a;
        public final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static final class b {
        public final z0 a;
        public final int b;
        public final String c;

        public b(z0 z0Var, int i, String str) {
            this.a = z0Var;
            this.b = i;
            this.c = str;
        }
    }

    public t0(Context context, PlaybackSession playbackSession) {
        this.a = context.getApplicationContext();
        this.c = playbackSession;
        r0 r0Var = new r0();
        this.b = r0Var;
        r0Var.c(this);
    }

    public static int A0(V2.m mVar) {
        for (int i = 0; i < mVar.e; i++) {
            UUID uuid = mVar.f(i).c;
            if (uuid.equals(O2.o.d)) {
                return 3;
            }
            if (uuid.equals(O2.o.e)) {
                return 2;
            }
            if (uuid.equals(O2.o.c)) {
                return 6;
            }
        }
        return 1;
    }

    public static a B0(p1 p1Var, Context context, boolean z) {
        int i;
        boolean z2;
        if (p1Var.a == 1001) {
            return new a(20, 0);
        }
        if (p1Var instanceof O2.w) {
            O2.w wVar = (O2.w) p1Var;
            z2 = wVar.j == 1;
            i = wVar.n;
        } else {
            i = 0;
            z2 = false;
        }
        MediaCodec.CryptoException cryptoException = (Throwable) d4.a.e(p1Var.getCause());
        if (!(cryptoException instanceof IOException)) {
            if (z2 && (i == 0 || i == 1)) {
                return new a(35, 0);
            }
            if (z2 && i == 3) {
                return new a(15, 0);
            }
            if (z2 && i == 2) {
                return new a(23, 0);
            }
            if (cryptoException instanceof u.b) {
                return new a(13, d4.k0.a0(((u.b) cryptoException).e));
            }
            if (cryptoException instanceof p3.n) {
                return new a(14, d4.k0.a0(((p3.n) cryptoException).c));
            }
            if (cryptoException instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (cryptoException instanceof B.b) {
                return new a(17, ((B.b) cryptoException).a);
            }
            if (cryptoException instanceof B.e) {
                return new a(18, ((B.e) cryptoException).a);
            }
            if (d4.k0.a < 16 || !(cryptoException instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = cryptoException.getErrorCode();
            return new a(y0(errorCode), errorCode);
        }
        if (cryptoException instanceof C.e) {
            return new a(5, ((C.e) cryptoException).e);
        }
        if ((cryptoException instanceof C.d) || (cryptoException instanceof l1)) {
            return new a(z ? 10 : 11, 0);
        }
        boolean z3 = cryptoException instanceof C.c;
        if (z3 || (cryptoException instanceof T.a)) {
            if (d4.I.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = cryptoException.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : (z3 && ((C.c) cryptoException).d == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (p1Var.a == 1002) {
            return new a(21, 0);
        }
        if (!(cryptoException instanceof o.a)) {
            if (!(cryptoException instanceof B.c) || !(cryptoException.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            ErrnoException cause2 = ((Throwable) d4.a.e(cryptoException.getCause())).getCause();
            return (d4.k0.a >= 21 && (cause2 instanceof ErrnoException) && cause2.errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        MediaDrm.MediaDrmStateException mediaDrmStateException = (Throwable) d4.a.e(cryptoException.getCause());
        int i2 = d4.k0.a;
        if (i2 < 21 || !(mediaDrmStateException instanceof MediaDrm.MediaDrmStateException)) {
            return (i2 < 23 || !X0.a(mediaDrmStateException)) ? (i2 < 18 || !(mediaDrmStateException instanceof NotProvisionedException)) ? (i2 < 18 || !(mediaDrmStateException instanceof DeniedByServerException)) ? mediaDrmStateException instanceof V2.W ? new a(23, 0) : mediaDrmStateException instanceof h.e ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int a0 = d4.k0.a0(mediaDrmStateException.getDiagnosticInfo());
        return new a(y0(a0), a0);
    }

    public static Pair C0(String str) {
        String[] i1 = d4.k0.i1(str, "-");
        return Pair.create(i1[0], i1.length >= 2 ? i1[1] : null);
    }

    public static int E0(Context context) {
        switch (d4.I.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    public static int F0(H0 h0) {
        H0.h hVar = h0.c;
        if (hVar == null) {
            return 0;
        }
        int y0 = d4.k0.y0(hVar.a, hVar.c);
        if (y0 == 0) {
            return 3;
        }
        if (y0 != 1) {
            return y0 != 2 ? 1 : 4;
        }
        return 5;
    }

    public static int G0(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 1 : 4;
        }
        return 3;
    }

    public static t0 w0(Context context) {
        MediaMetricsManager a2 = M0.a(context.getSystemService("media_metrics"));
        if (a2 == null) {
            return null;
        }
        return new t0(context, N0.a(a2));
    }

    public static int y0(int i) {
        switch (d4.k0.Z(i)) {
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

    public static V2.m z0(s5.y yVar) {
        V2.m mVar;
        s5.c0 l = yVar.l();
        while (l.hasNext()) {
            V1.a aVar = (V1.a) l.next();
            for (int i = 0; i < aVar.a; i++) {
                if (aVar.j(i) && (mVar = aVar.c(i).p) != null) {
                    return mVar;
                }
            }
        }
        return null;
    }

    public /* synthetic */ void A(c.a aVar, boolean z) {
        P2.b.B(this, aVar, z);
    }

    public /* synthetic */ void B(c.a aVar, int i, long j, long j2) {
        P2.b.l(this, aVar, i, j, j2);
    }

    public /* synthetic */ void C(c.a aVar, H0 h0, int i) {
        P2.b.G(this, aVar, h0, i);
    }

    public /* synthetic */ void D(c.a aVar, Object obj, long j) {
        P2.b.R(this, aVar, obj, j);
    }

    public LogSessionId D0() {
        return com.google.ads.interactivemedia.v3.internal.h0.a(this.c);
    }

    public void E(c.a aVar, U2.e eVar) {
        this.x += eVar.g;
        this.y += eVar.e;
    }

    public void F(c.a aVar, p1 p1Var) {
        this.n = p1Var;
    }

    public /* synthetic */ void G(c.a aVar, B3.x xVar) {
        P2.b.a0(this, aVar, xVar);
    }

    public /* synthetic */ void H(c.a aVar, R0 r0) {
        P2.b.H(this, aVar, r0);
    }

    public final void H0(c.b bVar) {
        for (int i = 0; i < bVar.d(); i++) {
            int b2 = bVar.b(i);
            c.a c = bVar.c(b2);
            if (b2 == 0) {
                this.b.d(c);
            } else if (b2 == 11) {
                this.b.e(c, this.k);
            } else {
                this.b.f(c);
            }
        }
    }

    public /* synthetic */ void I(c.a aVar, Exception exc) {
        P2.b.b(this, aVar, exc);
    }

    public final void I0(long j) {
        int E0 = E0(this.a);
        if (E0 != this.m) {
            this.m = E0;
            com.google.ads.interactivemedia.v3.internal.b0.a(this.c, a1.a(Z0.a(Y0.a(com.google.ads.interactivemedia.v3.internal.R0.a(), E0), j - this.d)));
        }
    }

    public /* synthetic */ void J(c.a aVar, O2.u uVar) {
        P2.b.p(this, aVar, uVar);
    }

    public final void J0(long j) {
        p1 p1Var = this.n;
        if (p1Var == null) {
            return;
        }
        a B0 = B0(p1Var, this.a, this.v == 4);
        W0.a(this.c, S0.a(com.google.ads.interactivemedia.v3.internal.H0.a(w0.a(com.google.ads.interactivemedia.v3.internal.l0.a(com.google.ads.interactivemedia.v3.internal.g0.a(Q0.a(), j - this.d), B0.a), B0.b), p1Var)));
        this.A = true;
        this.n = null;
    }

    public /* synthetic */ void K(c.a aVar, int i) {
        P2.b.M(this, aVar, i);
    }

    public final void K0(t1 t1Var, c.b bVar, long j) {
        if (t1Var.getPlaybackState() != 2) {
            this.u = false;
        }
        if (t1Var.n() == null) {
            this.w = false;
        } else if (bVar.a(10)) {
            this.w = true;
        }
        int S0 = S0(t1Var);
        if (this.l != S0) {
            this.l = S0;
            this.A = true;
            com.google.ads.interactivemedia.v3.internal.f0.a(this.c, com.google.ads.interactivemedia.v3.internal.e0.a(com.google.ads.interactivemedia.v3.internal.d0.a(com.google.ads.interactivemedia.v3.internal.c0.a(T0.a(), this.l), j - this.d)));
        }
    }

    public /* synthetic */ void L(c.a aVar) {
        P2.b.x(this, aVar);
    }

    public final void L0(t1 t1Var, c.b bVar, long j) {
        if (bVar.a(2)) {
            V1 p = t1Var.p();
            boolean e = p.e(2);
            boolean e2 = p.e(1);
            boolean e3 = p.e(3);
            if (e || e2 || e3) {
                if (!e) {
                    Q0(j, null, 0);
                }
                if (!e2) {
                    M0(j, null, 0);
                }
                if (!e3) {
                    O0(j, null, 0);
                }
            }
        }
        if (v0(this.o)) {
            b bVar2 = this.o;
            z0 z0Var = bVar2.a;
            if (z0Var.s != -1) {
                Q0(j, z0Var, bVar2.b);
                this.o = null;
            }
        }
        if (v0(this.p)) {
            b bVar3 = this.p;
            M0(j, bVar3.a, bVar3.b);
            this.p = null;
        }
        if (v0(this.q)) {
            b bVar4 = this.q;
            O0(j, bVar4.a, bVar4.b);
            this.q = null;
        }
    }

    public /* synthetic */ void M(c.a aVar, Q2.e eVar) {
        P2.b.a(this, aVar, eVar);
    }

    public final void M0(long j, z0 z0Var, int i) {
        if (d4.k0.c(this.s, z0Var)) {
            return;
        }
        int i2 = (this.s == null && i == 0) ? 1 : i;
        this.s = z0Var;
        R0(0, j, z0Var, i2);
    }

    public /* synthetic */ void N(c.a aVar, String str) {
        P2.b.e0(this, aVar, str);
    }

    public final void N0(t1 t1Var, c.b bVar) {
        V2.m z0;
        if (bVar.a(0)) {
            c.a c = bVar.c(0);
            if (this.j != null) {
                P0(c.b, c.d);
            }
        }
        if (bVar.a(2) && this.j != null && (z0 = z0(t1Var.p().c())) != null) {
            com.google.ads.interactivemedia.v3.internal.a0.a(s0.a(d4.k0.j(this.j)), A0(z0));
        }
        if (bVar.a(1011)) {
            this.z++;
        }
    }

    public /* synthetic */ void O(c.a aVar, int i, int i2, int i3, float f) {
        P2.b.j0(this, aVar, i, i2, i3, f);
    }

    public final void O0(long j, z0 z0Var, int i) {
        if (d4.k0.c(this.t, z0Var)) {
            return;
        }
        int i2 = (this.t == null && i == 0) ? 1 : i;
        this.t = z0Var;
        R0(2, j, z0Var, i2);
    }

    public /* synthetic */ void P(c.a aVar, boolean z) {
        P2.b.F(this, aVar, z);
    }

    public final void P0(Q1 q1, C.b bVar) {
        int f;
        PlaybackMetrics.Builder builder = this.j;
        if (bVar == null || (f = q1.f(bVar.a)) == -1) {
            return;
        }
        q1.k(f, this.f);
        q1.s(this.f.d, this.e);
        J0.a(builder, F0(this.e.d));
        Q1.d dVar = this.e;
        if (dVar.o != -9223372036854775807L && !dVar.m && !dVar.j && !dVar.i()) {
            K0.a(builder, this.e.f());
        }
        L0.a(builder, this.e.i() ? 2 : 1);
        this.A = true;
    }

    public /* synthetic */ void Q(c.a aVar) {
        P2.b.O(this, aVar);
    }

    public final void Q0(long j, z0 z0Var, int i) {
        if (d4.k0.c(this.r, z0Var)) {
            return;
        }
        int i2 = (this.r == null && i == 0) ? 1 : i;
        this.r = z0Var;
        R0(1, j, z0Var, i2);
    }

    public /* synthetic */ void R(c.a aVar, z0 z0Var) {
        P2.b.h0(this, aVar, z0Var);
    }

    public final void R0(int i, long j, z0 z0Var, int i2) {
        TrackChangeEvent.Builder a2 = com.google.ads.interactivemedia.v3.internal.r0.a(U0.a(i), j - this.d);
        if (z0Var != null) {
            com.google.ads.interactivemedia.v3.internal.z0.a(a2, 1);
            A0.a(a2, G0(i2));
            String str = z0Var.l;
            if (str != null) {
                B0.a(a2, str);
            }
            String str2 = z0Var.m;
            if (str2 != null) {
                C0.a(a2, str2);
            }
            String str3 = z0Var.j;
            if (str3 != null) {
                D0.a(a2, str3);
            }
            int i3 = z0Var.i;
            if (i3 != -1) {
                E0.a(a2, i3);
            }
            int i4 = z0Var.r;
            if (i4 != -1) {
                F0.a(a2, i4);
            }
            int i5 = z0Var.s;
            if (i5 != -1) {
                G0.a(a2, i5);
            }
            int i6 = z0Var.z;
            if (i6 != -1) {
                I0.a(a2, i6);
            }
            int i7 = z0Var.A;
            if (i7 != -1) {
                com.google.ads.interactivemedia.v3.internal.s0.a(a2, i7);
            }
            String str4 = z0Var.d;
            if (str4 != null) {
                Pair C0 = C0(str4);
                com.google.ads.interactivemedia.v3.internal.t0.a(a2, (String) C0.first);
                Object obj = C0.second;
                if (obj != null) {
                    com.google.ads.interactivemedia.v3.internal.u0.a(a2, (String) obj);
                }
            }
            float f = z0Var.t;
            if (f != -1.0f) {
                com.google.ads.interactivemedia.v3.internal.v0.a(a2, f);
            }
        } else {
            com.google.ads.interactivemedia.v3.internal.z0.a(a2, 0);
        }
        this.A = true;
        y0.a(this.c, x0.a(a2));
    }

    public void S(c.a aVar, String str, boolean z) {
        C.b bVar = aVar.d;
        if ((bVar == null || !bVar.b()) && str.equals(this.i)) {
            x0();
        }
        this.g.remove(str);
        this.h.remove(str);
    }

    public final int S0(t1 t1Var) {
        int playbackState = t1Var.getPlaybackState();
        if (this.u) {
            return 5;
        }
        if (this.w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i = this.l;
            if (i == 0 || i == 2) {
                return 2;
            }
            if (t1Var.E()) {
                return t1Var.v() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (t1Var.E()) {
                return t1Var.v() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.l == 0) {
            return this.l;
        }
        return 12;
    }

    public /* synthetic */ void T(c.a aVar, U2.e eVar) {
        P2.b.f0(this, aVar, eVar);
    }

    public /* synthetic */ void U(c.a aVar, Exception exc) {
        P2.b.b0(this, aVar, exc);
    }

    public /* synthetic */ void V(c.a aVar, int i) {
        P2.b.L(this, aVar, i);
    }

    public /* synthetic */ void W(c.a aVar, Exception exc) {
        P2.b.w(this, aVar, exc);
    }

    public /* synthetic */ void X(c.a aVar, int i) {
        P2.b.v(this, aVar, i);
    }

    public void Y(c.a aVar, B3.x xVar) {
        if (aVar.d == null) {
            return;
        }
        b bVar = new b((z0) d4.a.e(xVar.c), xVar.d, this.b.a(aVar.b, (C.b) d4.a.e(aVar.d)));
        int i = xVar.b;
        if (i != 0) {
            if (i == 1) {
                this.p = bVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.q = bVar;
                return;
            }
        }
        this.o = bVar;
    }

    public /* synthetic */ void Z(c.a aVar, String str) {
        P2.b.e(this, aVar, str);
    }

    public /* synthetic */ void a(c.a aVar, z0 z0Var, U2.h hVar) {
        P2.b.i0(this, aVar, z0Var, hVar);
    }

    public void a0(c.a aVar, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
        this.v = xVar.a;
    }

    public void b(c.a aVar, String str) {
        C.b bVar = aVar.d;
        if (bVar == null || !bVar.b()) {
            x0();
            this.i = str;
            this.j = P0.a(O0.a(V0.a(), "ExoPlayerLib"), "2.19.0");
            P0(aVar.b, aVar.d);
        }
    }

    public /* synthetic */ void b0(c.a aVar, boolean z) {
        P2.b.U(this, aVar, z);
    }

    public /* synthetic */ void c(c.a aVar) {
        P2.b.t(this, aVar);
    }

    public /* synthetic */ void c0(c.a aVar, long j) {
        P2.b.j(this, aVar, j);
    }

    public /* synthetic */ void d(c.a aVar, B3.u uVar, B3.x xVar) {
        P2.b.E(this, aVar, uVar, xVar);
    }

    public /* synthetic */ void d0(c.a aVar, q3.a aVar2) {
        P2.b.I(this, aVar, aVar2);
    }

    public /* synthetic */ void e(c.a aVar, int i) {
        P2.b.Q(this, aVar, i);
    }

    public /* synthetic */ void e0(c.a aVar, int i) {
        P2.b.X(this, aVar, i);
    }

    public /* synthetic */ void f(c.a aVar) {
        P2.b.u(this, aVar);
    }

    public /* synthetic */ void f0(c.a aVar, boolean z, int i) {
        P2.b.P(this, aVar, z, i);
    }

    public /* synthetic */ void g(c.a aVar, boolean z) {
        P2.b.A(this, aVar, z);
    }

    public /* synthetic */ void g0(c.a aVar, String str, long j) {
        P2.b.c(this, aVar, str, j);
    }

    public /* synthetic */ void h(c.a aVar, Z3.z zVar) {
        P2.b.Y(this, aVar, zVar);
    }

    public /* synthetic */ void h0(c.a aVar, int i, long j) {
        P2.b.y(this, aVar, i, j);
    }

    public /* synthetic */ void i(c.a aVar) {
        P2.b.T(this, aVar);
    }

    public void i0(c.a aVar, int i, long j, long j2) {
        C.b bVar = aVar.d;
        if (bVar != null) {
            String a2 = this.b.a(aVar.b, (C.b) d4.a.e(bVar));
            Long l = (Long) this.h.get(a2);
            Long l2 = (Long) this.g.get(a2);
            this.h.put(a2, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.g.put(a2, Long.valueOf((l2 != null ? l2.longValue() : 0L) + i));
        }
    }

    public /* synthetic */ void j(c.a aVar, Exception exc) {
        P2.b.k(this, aVar, exc);
    }

    public /* synthetic */ void j0(c.a aVar, boolean z, int i) {
        P2.b.J(this, aVar, z, i);
    }

    public /* synthetic */ void k(c.a aVar, V1 v1) {
        P2.b.Z(this, aVar, v1);
    }

    public /* synthetic */ void k0(c.a aVar) {
        P2.b.r(this, aVar);
    }

    public /* synthetic */ void l(c.a aVar, z0 z0Var, U2.h hVar) {
        P2.b.i(this, aVar, z0Var, hVar);
    }

    public /* synthetic */ void l0(c.a aVar, boolean z) {
        P2.b.V(this, aVar, z);
    }

    public /* synthetic */ void m(c.a aVar) {
        P2.b.s(this, aVar);
    }

    public /* synthetic */ void m0(c.a aVar, int i, boolean z) {
        P2.b.q(this, aVar, i, z);
    }

    public /* synthetic */ void n(c.a aVar, long j, int i) {
        P2.b.g0(this, aVar, j, i);
    }

    public /* synthetic */ void n0(c.a aVar, z0 z0Var) {
        P2.b.h(this, aVar, z0Var);
    }

    public /* synthetic */ void o(c.a aVar, int i, int i2) {
        P2.b.W(this, aVar, i, i2);
    }

    public void o0(c.a aVar, e4.C c) {
        b bVar = this.o;
        if (bVar != null) {
            z0 z0Var = bVar.a;
            if (z0Var.s == -1) {
                this.o = new b(z0Var.b().n0(c.a).S(c.c).G(), bVar.b, bVar.c);
            }
        }
    }

    public void p(c.a aVar, t1.e eVar, t1.e eVar2, int i) {
        if (i == 1) {
            this.u = true;
        }
        this.k = i;
    }

    public /* synthetic */ void p0(c.a aVar, B3.u uVar, B3.x xVar) {
        P2.b.C(this, aVar, uVar, xVar);
    }

    public /* synthetic */ void q(c.a aVar, U2.e eVar) {
        P2.b.g(this, aVar, eVar);
    }

    public /* synthetic */ void q0(c.a aVar, List list) {
        P2.b.o(this, aVar, list);
    }

    public /* synthetic */ void r(c.a aVar, P3.f fVar) {
        P2.b.n(this, aVar, fVar);
    }

    public /* synthetic */ void r0(c.a aVar, p1 p1Var) {
        P2.b.N(this, aVar, p1Var);
    }

    public /* synthetic */ void s(c.a aVar, String str, long j, long j2) {
        P2.b.d(this, aVar, str, j, j2);
    }

    public /* synthetic */ void s0(c.a aVar, U2.e eVar) {
        P2.b.f(this, aVar, eVar);
    }

    public /* synthetic */ void t(c.a aVar, s1 s1Var) {
        P2.b.K(this, aVar, s1Var);
    }

    public /* synthetic */ void t0(c.a aVar, String str, long j, long j2) {
        P2.b.d0(this, aVar, str, j, j2);
    }

    public /* synthetic */ void u(c.a aVar, String str, long j) {
        P2.b.c0(this, aVar, str, j);
    }

    public void u0(t1 t1Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        H0(bVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        N0(t1Var, bVar);
        J0(elapsedRealtime);
        L0(t1Var, bVar, elapsedRealtime);
        I0(elapsedRealtime);
        K0(t1Var, bVar, elapsedRealtime);
        if (bVar.a(1028)) {
            this.b.g(bVar.c(1028));
        }
    }

    public final boolean v0(b bVar) {
        return bVar != null && bVar.c.equals(this.b.b());
    }

    public /* synthetic */ void w(c.a aVar, t1.b bVar) {
        P2.b.m(this, aVar, bVar);
    }

    public final void x0() {
        PlaybackMetrics.Builder builder = this.j;
        if (builder != null && this.A) {
            com.google.ads.interactivemedia.v3.internal.i0.a(builder, this.z);
            com.google.ads.interactivemedia.v3.internal.j0.a(this.j, this.x);
            com.google.ads.interactivemedia.v3.internal.k0.a(this.j, this.y);
            Long l = (Long) this.g.get(this.i);
            com.google.ads.interactivemedia.v3.internal.m0.a(this.j, l == null ? 0L : l.longValue());
            Long l2 = (Long) this.h.get(this.i);
            com.google.ads.interactivemedia.v3.internal.n0.a(this.j, l2 == null ? 0L : l2.longValue());
            com.google.ads.interactivemedia.v3.internal.o0.a(this.j, (l2 == null || l2.longValue() <= 0) ? 0 : 1);
            com.google.ads.interactivemedia.v3.internal.q0.a(this.c, com.google.ads.interactivemedia.v3.internal.p0.a(this.j));
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

    public /* synthetic */ void y(c.a aVar, B3.u uVar, B3.x xVar) {
        P2.b.D(this, aVar, uVar, xVar);
    }

    public /* synthetic */ void z(c.a aVar, int i) {
        P2.b.S(this, aVar, i);
    }

    public void x(c.a aVar, String str) {
    }

    public void v(c.a aVar, String str, String str2) {
    }
}
