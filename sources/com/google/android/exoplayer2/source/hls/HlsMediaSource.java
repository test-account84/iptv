package com.google.android.exoplayer2.source.hls;

import B3.C;
import B3.J;
import B3.b0;
import B3.i;
import B3.z;
import H3.g;
import H3.h;
import J3.c;
import J3.e;
import J3.f;
import J3.j;
import J3.k;
import O2.H0;
import O2.w0;
import V2.B;
import V2.l;
import V2.y;
import android.os.Looper;
import b4.A;
import b4.F;
import b4.S;
import b4.b;
import b4.o;
import d4.k0;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class HlsMediaSource extends B3.a implements k.e {
    public final h i;
    public final H0.h j;
    public final g k;
    public final i l;
    public final y m;
    public final F n;
    public final boolean o;
    public final int p;
    public final boolean q;
    public final k r;
    public final long s;
    public final H0 t;
    public final long u;
    public H0.g v;
    public S w;

    public static final class Factory implements C.a {
        public final g a;
        public h b;
        public j c;
        public k.a d;
        public i e;
        public B f;
        public F g;
        public boolean h;
        public int i;
        public boolean j;
        public long k;
        public long l;

        public Factory(g gVar) {
            this.a = (g) d4.a.e(gVar);
            this.f = new l();
            this.c = new J3.a();
            this.d = c.q;
            this.b = h.a;
            this.g = new A();
            this.e = new B3.j();
            this.i = 1;
            this.k = -9223372036854775807L;
            this.h = true;
        }

        public int[] c() {
            return new int[]{2};
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource b(H0 h0) {
            d4.a.e(h0.c);
            j jVar = this.c;
            List list = h0.c.f;
            j eVar = !list.isEmpty() ? new e(jVar, list) : jVar;
            g gVar = this.a;
            h hVar = this.b;
            i iVar = this.e;
            y a = this.f.a(h0);
            F f = this.g;
            return new HlsMediaSource(h0, gVar, hVar, iVar, null, a, f, this.d.a(this.a, f, eVar), this.k, this.h, this.i, this.j, this.l, null);
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory d(B b) {
            this.f = (B) d4.a.f(b, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory a(F f) {
            this.g = (F) d4.a.f(f, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(o.a aVar) {
            this(new H3.c(aVar));
        }
    }

    static {
        w0.a("goog.exo.hls");
    }

    public HlsMediaSource(H0 h0, g gVar, h hVar, i iVar, b4.h hVar2, y yVar, F f, k kVar, long j, boolean z, int i, boolean z2, long j2) {
        this.j = (H0.h) d4.a.e(h0.c);
        this.t = h0;
        this.v = h0.e;
        this.k = gVar;
        this.i = hVar;
        this.l = iVar;
        this.m = yVar;
        this.n = f;
        this.r = kVar;
        this.s = j;
        this.o = z;
        this.p = i;
        this.q = z2;
        this.u = j2;
    }

    public static f.b q0(List list, long j) {
        f.b bVar = null;
        for (int i = 0; i < list.size(); i++) {
            f.b bVar2 = (f.b) list.get(i);
            long j2 = bVar2.f;
            if (j2 > j || !bVar2.m) {
                if (j2 > j) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public static f.d r0(List list, long j) {
        return (f.d) list.get(k0.g(list, Long.valueOf(j), true, true));
    }

    public static long u0(f fVar, long j) {
        long j2;
        f.f fVar2 = fVar.v;
        long j3 = fVar.e;
        if (j3 != -9223372036854775807L) {
            j2 = fVar.u - j3;
        } else {
            long j4 = fVar2.d;
            if (j4 == -9223372036854775807L || fVar.n == -9223372036854775807L) {
                long j5 = fVar2.c;
                j2 = j5 != -9223372036854775807L ? j5 : fVar.m * 3;
            } else {
                j2 = j4;
            }
        }
        return j2 + j;
    }

    public z E(C.b bVar, b bVar2, long j) {
        J.a f0 = f0(bVar);
        return new H3.l(this.i, this.r, this.k, this.w, null, this.m, b0(bVar), this.n, f0, bVar2, this.l, this.o, this.p, this.q, i0(), this.u);
    }

    public void M(f fVar) {
        long x1 = fVar.p ? k0.x1(fVar.h) : -9223372036854775807L;
        int i = fVar.d;
        long j = (i == 2 || i == 1) ? x1 : -9223372036854775807L;
        H3.i iVar = new H3.i((J3.g) d4.a.e(this.r.e()), fVar);
        m0(this.r.i() ? o0(fVar, j, x1, iVar) : p0(fVar, j, x1, iVar));
    }

    public void P() {
        this.r.l();
    }

    public void Y(z zVar) {
        ((H3.l) zVar).C();
    }

    public H0 e() {
        return this.t;
    }

    public void l0(S s) {
        this.w = s;
        this.m.b((Looper) d4.a.e(Looper.myLooper()), i0());
        this.m.prepare();
        this.r.a(this.j.a, f0(null), this);
    }

    public void n0() {
        this.r.stop();
        this.m.release();
    }

    public final b0 o0(f fVar, long j, long j2, H3.i iVar) {
        long d = fVar.h - this.r.d();
        long j3 = fVar.o ? d + fVar.u : -9223372036854775807L;
        long s0 = s0(fVar);
        long j4 = this.v.a;
        v0(fVar, k0.s(j4 != -9223372036854775807L ? k0.P0(j4) : u0(fVar, s0), s0, fVar.u + s0));
        return new b0(j, j2, -9223372036854775807L, j3, fVar.u, d, t0(fVar, s0), true, !fVar.o, fVar.d == 2 && fVar.f, iVar, this.t, this.v);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final B3.b0 p0(J3.f r25, long r26, long r28, H3.i r30) {
        /*
            r24 = this;
            r0 = r25
            long r1 = r0.e
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L31
            java.util.List r1 = r0.r
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L16
            goto L31
        L16:
            boolean r1 = r0.g
            if (r1 != 0) goto L2e
            long r1 = r0.e
            long r3 = r0.u
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L23
            goto L2e
        L23:
            java.util.List r3 = r0.r
            J3.f$d r1 = r0(r3, r1)
            long r1 = r1.f
        L2b:
            r16 = r1
            goto L34
        L2e:
            long r1 = r0.e
            goto L2b
        L31:
            r1 = 0
            goto L2b
        L34:
            B3.b0 r1 = new B3.b0
            r3 = r1
            long r10 = r0.u
            r12 = r10
            r0 = r24
            O2.H0 r2 = r0.t
            r22 = r2
            r23 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14 = 0
            r18 = 1
            r19 = 0
            r20 = 1
            r4 = r26
            r6 = r28
            r21 = r30
            r3.<init>(r4, r6, r8, r10, r12, r14, r16, r18, r19, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.p0(J3.f, long, long, H3.i):B3.b0");
    }

    public final long s0(f fVar) {
        if (fVar.p) {
            return k0.P0(k0.g0(this.s)) - fVar.e();
        }
        return 0L;
    }

    public final long t0(f fVar, long j) {
        long j2 = fVar.e;
        if (j2 == -9223372036854775807L) {
            j2 = (fVar.u + j) - k0.P0(this.v.a);
        }
        if (fVar.g) {
            return j2;
        }
        f.b q0 = q0(fVar.s, j2);
        if (q0 != null) {
            return q0.f;
        }
        if (fVar.r.isEmpty()) {
            return 0L;
        }
        f.d r0 = r0(fVar.r, j2);
        f.b q02 = q0(r0.n, j2);
        return q02 != null ? q02.f : r0.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v0(J3.f r6, long r7) {
        /*
            r5 = this;
            O2.H0 r0 = r5.t
            O2.H0$g r0 = r0.e
            float r1 = r0.e
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L28
            float r0 = r0.f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            J3.f$f r6 = r6.v
            long r0 = r6.c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L28
            long r0 = r6.d
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L28
            r6 = 1
            goto L29
        L28:
            r6 = 0
        L29:
            O2.H0$g$a r0 = new O2.H0$g$a
            r0.<init>()
            long r7 = d4.k0.x1(r7)
            O2.H0$g$a r7 = r0.k(r7)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L3d
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L41
        L3d:
            O2.H0$g r0 = r5.v
            float r0 = r0.e
        L41:
            O2.H0$g$a r7 = r7.j(r0)
            if (r6 == 0) goto L48
            goto L4c
        L48:
            O2.H0$g r6 = r5.v
            float r8 = r6.f
        L4c:
            O2.H0$g$a r6 = r7.h(r8)
            O2.H0$g r6 = r6.f()
            r5.v = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.v0(J3.f, long):void");
    }

    public /* synthetic */ HlsMediaSource(H0 h0, g gVar, h hVar, i iVar, b4.h hVar2, y yVar, F f, k kVar, long j, boolean z, int i, boolean z2, long j2, a aVar) {
        this(h0, gVar, hVar, iVar, hVar2, yVar, f, kVar, j, z, i, z2, j2);
    }
}
