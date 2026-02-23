package com.google.android.exoplayer2.source.smoothstreaming;

import B3.C;
import B3.J;
import B3.b0;
import B3.i;
import B3.j;
import B3.u;
import B3.x;
import B3.z;
import N3.a;
import O2.H0;
import O2.w0;
import V2.B;
import V2.l;
import V2.y;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import b4.A;
import b4.F;
import b4.G;
import b4.H;
import b4.I;
import b4.S;
import b4.h;
import b4.o;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import d4.k0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import z3.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class SsMediaSource extends B3.a implements G.b {
    public N3.a A;
    public Handler B;
    public final boolean i;
    public final Uri j;
    public final H0.h k;
    public final H0 l;
    public final o.a m;
    public final b.a n;
    public final i o;
    public final y p;
    public final F q;
    public final long r;
    public final J.a s;
    public final I.a t;
    public final ArrayList u;
    public o v;
    public G w;
    public H x;
    public S y;
    public long z;

    public static final class Factory implements C.a {
        public final b.a a;
        public final o.a b;
        public i c;
        public B d;
        public F e;
        public long f;
        public I.a g;

        public Factory(o.a aVar) {
            this(new a.a(aVar), aVar);
        }

        public int[] c() {
            return new int[]{1};
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public SsMediaSource b(H0 h0) {
            d4.a.e(h0.c);
            I.a aVar = this.g;
            if (aVar == null) {
                aVar = new N3.b();
            }
            List list = h0.c.f;
            return new SsMediaSource(h0, null, this.b, !list.isEmpty() ? new D(aVar, list) : aVar, this.a, this.c, null, this.d.a(h0), this.e, this.f, null);
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory d(B b) {
            this.d = (B) d4.a.f(b, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory a(F f) {
            this.e = (F) d4.a.f(f, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(b.a aVar, o.a aVar2) {
            this.a = (b.a) d4.a.e(aVar);
            this.b = aVar2;
            this.d = new l();
            this.e = new A();
            this.f = 30000L;
            this.c = new j();
        }
    }

    static {
        w0.a("goog.exo.smoothstreaming");
    }

    public SsMediaSource(H0 h0, N3.a aVar, o.a aVar2, I.a aVar3, b.a aVar4, i iVar, h hVar, y yVar, F f, long j) {
        d4.a.g(aVar == null || !aVar.d);
        this.l = h0;
        H0.h hVar2 = (H0.h) d4.a.e(h0.c);
        this.k = hVar2;
        this.A = aVar;
        this.j = hVar2.a.equals(Uri.EMPTY) ? null : k0.C(hVar2.a);
        this.m = aVar2;
        this.t = aVar3;
        this.n = aVar4;
        this.o = iVar;
        this.p = yVar;
        this.q = f;
        this.r = j;
        this.s = f0(null);
        this.i = aVar != null;
        this.u = new ArrayList();
    }

    public static /* synthetic */ void o0(SsMediaSource ssMediaSource) {
        ssMediaSource.u0();
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        J.a f0 = f0(bVar);
        c cVar = new c(this.A, this.n, this.y, this.o, null, this.p, b0(bVar), this.q, f0, this.x, bVar2);
        this.u.add(cVar);
        return cVar;
    }

    public void P() {
        this.x.a();
    }

    public void Y(z zVar) {
        ((c) zVar).t();
        this.u.remove(zVar);
    }

    public H0 e() {
        return this.l;
    }

    public void l0(S s) {
        this.y = s;
        this.p.b(Looper.myLooper(), i0());
        this.p.prepare();
        if (this.i) {
            this.x = new H.a();
            s0();
            return;
        }
        this.v = this.m.a();
        G g = new G("SsMediaSource");
        this.w = g;
        this.x = g;
        this.B = k0.x();
        u0();
    }

    public void n0() {
        this.A = this.i ? this.A : null;
        this.v = null;
        this.z = 0L;
        G g = this.w;
        if (g != null) {
            g.l();
            this.w = null;
        }
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.B = null;
        }
        this.p.release();
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void t(I i, long j, long j2, boolean z) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        this.q.d(i.a);
        this.s.p(uVar, i.d);
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void W(I i, long j, long j2) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        this.q.d(i.a);
        this.s.s(uVar, i.d);
        this.A = (N3.a) i.e();
        this.z = j - j2;
        s0();
        t0();
    }

    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public G.c j(I i, long j, long j2, IOException iOException, int i2) {
        u uVar = new u(i.a, i.c, i.f(), i.d(), j, j2, i.b());
        long c = this.q.c(new F.c(uVar, new x(i.d), iOException, i2));
        G.c h = c == -9223372036854775807L ? G.g : G.h(false, c);
        boolean z = !h.c();
        this.s.w(uVar, i.d, iOException, z);
        if (z) {
            this.q.d(i.a);
        }
        return h;
    }

    public final void s0() {
        b0 b0Var;
        for (int i = 0; i < this.u.size(); i++) {
            ((c) this.u.get(i)).w(this.A);
        }
        long j = Long.MIN_VALUE;
        long j2 = Long.MAX_VALUE;
        for (a.b bVar : this.A.f) {
            if (bVar.k > 0) {
                j2 = Math.min(j2, bVar.e(0));
                j = Math.max(j, bVar.e(bVar.k - 1) + bVar.c(bVar.k - 1));
            }
        }
        if (j2 == Long.MAX_VALUE) {
            long j3 = this.A.d ? -9223372036854775807L : 0L;
            N3.a aVar = this.A;
            boolean z = aVar.d;
            b0Var = new b0(j3, 0L, 0L, 0L, true, z, z, aVar, this.l);
        } else {
            N3.a aVar2 = this.A;
            if (aVar2.d) {
                long j4 = aVar2.h;
                if (j4 != -9223372036854775807L && j4 > 0) {
                    j2 = Math.max(j2, j - j4);
                }
                long j5 = j2;
                long j6 = j - j5;
                long P0 = j6 - k0.P0(this.r);
                if (P0 < 5000000) {
                    P0 = Math.min(5000000L, j6 / 2);
                }
                b0Var = new b0(-9223372036854775807L, j6, j5, P0, true, true, true, this.A, this.l);
            } else {
                long j7 = aVar2.g;
                long j8 = j7 != -9223372036854775807L ? j7 : j - j2;
                b0Var = new b0(j2 + j8, j8, j2, 0L, true, false, false, this.A, this.l);
            }
        }
        m0(b0Var);
    }

    public final void t0() {
        if (this.A.d) {
            this.B.postDelayed(new M3.a(this), Math.max(0L, (this.z + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final void u0() {
        if (this.w.i()) {
            return;
        }
        I i = new I(this.v, this.j, 4, this.t);
        this.s.y(new u(i.a, i.c, this.w.n(i, this, this.q.b(i.d))), i.d);
    }

    public /* synthetic */ SsMediaSource(H0 h0, N3.a aVar, o.a aVar2, I.a aVar3, b.a aVar4, i iVar, h hVar, y yVar, F f, long j, a aVar5) {
        this(h0, aVar, aVar2, aVar3, aVar4, iVar, hVar, yVar, f, j);
    }
}
