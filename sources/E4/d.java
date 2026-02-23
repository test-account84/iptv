package e4;

import O2.A0;
import O2.z0;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import d4.Y;
import d4.a0;
import d4.k0;
import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d extends O2.k {
    public int A;
    public Object B;
    public Surface C;
    public l D;
    public m E;
    public V2.o F;
    public V2.o G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public long M;
    public long N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public C R;
    public long S;
    public int T;
    public int U;
    public int V;
    public long W;
    public long X;
    public U2.e Y;
    public final long q;
    public final int r;
    public final A.a s;
    public final Y t;
    public final U2.g u;
    public z0 v;
    public z0 w;
    public U2.d x;
    public U2.g y;
    public VideoDecoderOutputBuffer z;

    public d(long j, Handler handler, A a, int i) {
        super(2);
        this.q = j;
        this.r = i;
        this.N = -9223372036854775807L;
        U();
        this.t = new Y();
        this.u = U2.g.l();
        this.s = new A.a(handler, a);
        this.H = 0;
        this.A = -1;
    }

    private void T() {
        this.J = false;
    }

    private void U() {
        this.R = null;
    }

    private boolean W(long j, long j2) {
        if (this.z == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.x.b();
            this.z = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            U2.e eVar = this.Y;
            int i = eVar.f;
            int i2 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            eVar.f = i + i2;
            this.V -= i2;
        }
        if (!this.z.isEndOfStream()) {
            boolean q0 = q0(j, j2);
            if (q0) {
                o0(this.z.timeUs);
                this.z = null;
            }
            return q0;
        }
        if (this.H == 2) {
            r0();
            e0();
        } else {
            this.z.release();
            this.z = null;
            this.Q = true;
        }
        return false;
    }

    private boolean Y() {
        U2.d dVar = this.x;
        if (dVar == null || this.H == 2 || this.P) {
            return false;
        }
        if (this.y == null) {
            U2.g gVar = (U2.g) dVar.d();
            this.y = gVar;
            if (gVar == null) {
                return false;
            }
        }
        if (this.H == 1) {
            this.y.setFlags(4);
            this.x.c(this.y);
            this.y = null;
            this.H = 2;
            return false;
        }
        A0 B = B();
        int P = P(B, this.y, 0);
        if (P == -5) {
            k0(B);
            return true;
        }
        if (P != -4) {
            if (P == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (this.y.isEndOfStream()) {
            this.P = true;
            this.x.c(this.y);
            this.y = null;
            return false;
        }
        if (this.O) {
            this.t.a(this.y.f, this.v);
            this.O = false;
        }
        this.y.i();
        U2.g gVar2 = this.y;
        gVar2.a = this.v;
        p0(gVar2);
        this.x.c(this.y);
        this.V++;
        this.I = true;
        this.Y.c++;
        this.y = null;
        return true;
    }

    private static boolean b0(long j) {
        return j < -30000;
    }

    private static boolean c0(long j) {
        return j < -500000;
    }

    private void e0() {
        CryptoConfig cryptoConfig;
        if (this.x != null) {
            return;
        }
        u0(this.G);
        V2.o oVar = this.F;
        if (oVar != null) {
            cryptoConfig = oVar.d();
            if (cryptoConfig == null && this.F.getError() == null) {
                return;
            }
        } else {
            cryptoConfig = null;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.x = V(this.v, cryptoConfig);
            v0(this.A);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.s.k(this.x.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.Y.a++;
        } catch (OutOfMemoryError e) {
            throw y(e, this.v, 4001);
        } catch (U2.f e2) {
            d4.B.e("DecoderVideoRenderer", "Video codec error", e2);
            this.s.C(e2);
            throw y(e2, this.v, 4001);
        }
    }

    private void f0() {
        if (this.T > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.s.n(this.T, elapsedRealtime - this.S);
            this.T = 0;
            this.S = elapsedRealtime;
        }
    }

    private void g0() {
        this.L = true;
        if (this.J) {
            return;
        }
        this.J = true;
        this.s.A(this.B);
    }

    private void i0() {
        if (this.J) {
            this.s.A(this.B);
        }
    }

    private void j0() {
        C c = this.R;
        if (c != null) {
            this.s.D(c);
        }
    }

    private void u0(V2.o oVar) {
        V2.n.a(this.F, oVar);
        this.F = oVar;
    }

    private void w0() {
        this.N = this.q > 0 ? SystemClock.elapsedRealtime() + this.q : -9223372036854775807L;
    }

    private void y0(V2.o oVar) {
        V2.n.a(this.G, oVar);
        this.G = oVar;
    }

    public boolean A0(long j, long j2) {
        return b0(j);
    }

    public boolean B0(long j, long j2) {
        return b0(j) && j2 > 100000;
    }

    public void C0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.Y.f++;
        videoDecoderOutputBuffer.release();
    }

    public void D0(int i, int i2) {
        U2.e eVar = this.Y;
        eVar.h += i;
        int i3 = i + i2;
        eVar.g += i3;
        this.T += i3;
        int i4 = this.U + i3;
        this.U = i4;
        eVar.i = Math.max(i4, eVar.i);
        int i5 = this.r;
        if (i5 <= 0 || this.T < i5) {
            return;
        }
        f0();
    }

    public void G() {
        this.v = null;
        U();
        T();
        try {
            y0(null);
            r0();
        } finally {
            this.s.m(this.Y);
        }
    }

    public void H(boolean z, boolean z2) {
        U2.e eVar = new U2.e();
        this.Y = eVar;
        this.s.o(eVar);
        this.K = z2;
        this.L = false;
    }

    public void I(long j, boolean z) {
        this.P = false;
        this.Q = false;
        T();
        this.M = -9223372036854775807L;
        this.U = 0;
        if (this.x != null) {
            Z();
        }
        if (z) {
            w0();
        } else {
            this.N = -9223372036854775807L;
        }
        this.t.c();
    }

    public void M() {
        this.T = 0;
        this.S = SystemClock.elapsedRealtime();
        this.W = SystemClock.elapsedRealtime() * 1000;
    }

    public void N() {
        this.N = -9223372036854775807L;
        f0();
    }

    public void O(z0[] z0VarArr, long j, long j2) {
        this.X = j2;
        super.O(z0VarArr, j, j2);
    }

    public abstract U2.h S(String str, z0 z0Var, z0 z0Var2);

    public abstract U2.d V(z0 z0Var, CryptoConfig cryptoConfig);

    public void X(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        D0(0, 1);
        videoDecoderOutputBuffer.release();
    }

    public void Z() {
        this.V = 0;
        if (this.H != 0) {
            r0();
            e0();
            return;
        }
        this.y = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.z;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.z = null;
        }
        this.x.flush();
        this.I = false;
    }

    public final boolean a0() {
        return this.A != -1;
    }

    public boolean d() {
        return this.Q;
    }

    public boolean d0(long j) {
        int R = R(j);
        if (R == 0) {
            return false;
        }
        this.Y.j++;
        D0(R, this.V);
        Z();
        return true;
    }

    public boolean e() {
        if (this.v != null && ((F() || this.z != null) && (this.J || !a0()))) {
            this.N = -9223372036854775807L;
            return true;
        }
        if (this.N == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.N) {
            return true;
        }
        this.N = -9223372036854775807L;
        return false;
    }

    public final void h0(int i, int i2) {
        C c = this.R;
        if (c != null && c.a == i && c.c == i2) {
            return;
        }
        C c2 = new C(i, i2);
        this.R = c2;
        this.s.D(c2);
    }

    public void k0(A0 a0) {
        U2.h hVar;
        A.a aVar;
        z0 z0Var;
        this.O = true;
        z0 z0Var2 = (z0) d4.a.e(a0.b);
        y0(a0.a);
        z0 z0Var3 = this.v;
        this.v = z0Var2;
        U2.d dVar = this.x;
        if (dVar == null) {
            e0();
            aVar = this.s;
            z0Var = this.v;
            hVar = null;
        } else {
            hVar = this.G != this.F ? new U2.h(dVar.getName(), z0Var3, z0Var2, 0, 128) : S(dVar.getName(), z0Var3, z0Var2);
            if (hVar.d == 0) {
                if (this.I) {
                    this.H = 1;
                } else {
                    r0();
                    e0();
                }
            }
            aVar = this.s;
            z0Var = this.v;
        }
        aVar.p(z0Var, hVar);
    }

    public final void l0() {
        j0();
        T();
        if (getState() == 2) {
            w0();
        }
    }

    public final void m0() {
        U();
        T();
    }

    public void n(int i, Object obj) {
        if (i == 1) {
            x0(obj);
        } else if (i == 7) {
            this.E = (m) obj;
        } else {
            super.n(i, obj);
        }
    }

    public final void n0() {
        j0();
        i0();
    }

    public void o0(long j) {
        this.V--;
    }

    public final boolean q0(long j, long j2) {
        if (this.M == -9223372036854775807L) {
            this.M = j;
        }
        long j3 = this.z.timeUs - j;
        if (!a0()) {
            if (!b0(j3)) {
                return false;
            }
            C0(this.z);
            return true;
        }
        long j4 = this.z.timeUs - this.X;
        z0 z0Var = (z0) this.t.j(j4);
        if (z0Var != null) {
            this.w = z0Var;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.W;
        boolean z = getState() == 2;
        if (this.L ? this.J : !z && !this.K) {
            if (!z || !B0(j3, elapsedRealtime)) {
                if (!z || j == this.M || (z0(j3, j2) && d0(j))) {
                    return false;
                }
                if (A0(j3, j2)) {
                    X(this.z);
                    return true;
                }
                if (j3 < 30000) {
                    s0(this.z, j4, this.w);
                    return true;
                }
                return false;
            }
        }
        s0(this.z, j4, this.w);
        return true;
    }

    public void r0() {
        this.y = null;
        this.z = null;
        this.H = 0;
        this.I = false;
        this.V = 0;
        U2.d dVar = this.x;
        if (dVar != null) {
            this.Y.b++;
            dVar.release();
            this.s.l(this.x.getName());
            this.x = null;
        }
        u0(null);
    }

    public void s0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j, z0 z0Var) {
        m mVar = this.E;
        if (mVar != null) {
            mVar.a(j, System.nanoTime(), z0Var, null);
        }
        this.W = k0.P0(SystemClock.elapsedRealtime() * 1000);
        int i = videoDecoderOutputBuffer.mode;
        boolean z = i == 1 && this.C != null;
        boolean z2 = i == 0 && this.D != null;
        if (!z2 && !z) {
            X(videoDecoderOutputBuffer);
            return;
        }
        h0(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
        if (z2) {
            this.D.setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            t0(videoDecoderOutputBuffer, this.C);
        }
        this.U = 0;
        this.Y.e++;
        g0();
    }

    public abstract void t0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface);

    public void u(long j, long j2) {
        if (this.Q) {
            return;
        }
        if (this.v == null) {
            A0 B = B();
            this.u.clear();
            int P = P(B, this.u, 2);
            if (P != -5) {
                if (P == -4) {
                    d4.a.g(this.u.isEndOfStream());
                    this.P = true;
                    this.Q = true;
                    return;
                }
                return;
            }
            k0(B);
        }
        e0();
        if (this.x != null) {
            try {
                a0.a("drainAndFeed");
                while (W(j, j2)) {
                }
                while (Y()) {
                }
                a0.c();
                this.Y.c();
            } catch (U2.f e) {
                d4.B.e("DecoderVideoRenderer", "Video codec error", e);
                this.s.C(e);
                throw y(e, this.v, 4003);
            }
        }
    }

    public abstract void v0(int i);

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x0(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof android.view.Surface
            r1 = 0
            if (r0 == 0) goto L10
            r0 = r3
            android.view.Surface r0 = (android.view.Surface) r0
            r2.C = r0
            r2.D = r1
            r0 = 1
        Ld:
            r2.A = r0
            goto L23
        L10:
            boolean r0 = r3 instanceof e4.l
            r2.C = r1
            if (r0 == 0) goto L1d
            r0 = r3
            e4.l r0 = (e4.l) r0
            r2.D = r0
            r0 = 0
            goto Ld
        L1d:
            r2.D = r1
            r3 = -1
            r2.A = r3
            r3 = r1
        L23:
            java.lang.Object r0 = r2.B
            if (r0 == r3) goto L3c
            r2.B = r3
            if (r3 == 0) goto L38
            U2.d r3 = r2.x
            if (r3 == 0) goto L34
            int r3 = r2.A
            r2.v0(r3)
        L34:
            r2.l0()
            goto L41
        L38:
            r2.m0()
            goto L41
        L3c:
            if (r3 == 0) goto L41
            r2.n0()
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.d.x0(java.lang.Object):void");
    }

    public boolean z0(long j, long j2) {
        return c0(j);
    }

    public void p0(U2.g gVar) {
    }
}
