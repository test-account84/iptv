package B3;

import B3.C;
import B3.T;
import B3.d0;
import C3.e;
import O2.H0;
import O2.z0;
import android.content.Context;
import b4.o;
import b4.w;
import com.google.android.exoplayer2.extractor.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements C.a {
    public final a a;
    public o.a b;
    public C.a c;
    public e.b d;
    public a4.b e;
    public b4.F f;
    public long g;
    public long h;
    public long i;
    public float j;
    public float k;
    public boolean l;

    public static final class a {
        public final d3.o a;
        public final Map b = new HashMap();
        public final Set c = new HashSet();
        public final Map d = new HashMap();
        public o.a e;
        public V2.B f;
        public b4.F g;

        public a(d3.o oVar) {
            this.a = oVar;
        }

        public static /* synthetic */ C.a a(Class cls, o.a aVar) {
            return j(cls, aVar);
        }

        public static /* synthetic */ C.a b(Class cls, o.a aVar) {
            return i(cls, aVar);
        }

        public static /* synthetic */ C.a c(Class cls, o.a aVar) {
            return k(cls, aVar);
        }

        public static /* synthetic */ C.a d(a aVar, o.a aVar2) {
            return aVar.m(aVar2);
        }

        public static /* synthetic */ C.a e(Class cls) {
            return l(cls);
        }

        public static /* synthetic */ C.a i(Class cls, o.a aVar) {
            return q.g(cls, aVar);
        }

        public static /* synthetic */ C.a j(Class cls, o.a aVar) {
            return q.g(cls, aVar);
        }

        public static /* synthetic */ C.a k(Class cls, o.a aVar) {
            return q.g(cls, aVar);
        }

        public static /* synthetic */ C.a l(Class cls) {
            return q.f(cls);
        }

        public final void f() {
            n(0);
            n(1);
            n(2);
            n(3);
            n(4);
        }

        public C.a g(int i) {
            C.a aVar = (C.a) this.d.get(Integer.valueOf(i));
            if (aVar != null) {
                return aVar;
            }
            r5.r n = n(i);
            if (n == null) {
                return null;
            }
            C.a aVar2 = (C.a) n.get();
            V2.B b = this.f;
            if (b != null) {
                aVar2.d(b);
            }
            b4.F f = this.g;
            if (f != null) {
                aVar2.a(f);
            }
            this.d.put(Integer.valueOf(i), aVar2);
            return aVar2;
        }

        public int[] h() {
            f();
            return w5.f.l(this.c);
        }

        public final /* synthetic */ C.a m(o.a aVar) {
            return new T.b(aVar, this.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final r5.r n(int r5) {
            /*
                r4 = this;
                java.util.Map r0 = r4.b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L19
                java.util.Map r0 = r4.b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                r5.r r5 = (r5.r) r5
                return r5
            L19:
                b4.o$a r0 = r4.e
                java.lang.Object r0 = d4.a.e(r0)
                b4.o$a r0 = (b4.o.a) r0
                java.lang.Class<B3.C$a> r1 = B3.C.a.class
                r2 = 0
                if (r5 == 0) goto L61
                r3 = 1
                if (r5 == r3) goto L55
                r3 = 2
                if (r5 == r3) goto L48
                r3 = 3
                if (r5 == r3) goto L3c
                r1 = 4
                if (r5 == r1) goto L33
                goto L6d
            L33:
                B3.p r1 = new B3.p     // Catch: java.lang.ClassNotFoundException -> L3a
                r1.<init>(r4, r0)     // Catch: java.lang.ClassNotFoundException -> L3a
            L38:
                r2 = r1
                goto L6d
            L3a:
                goto L6d
            L3c:
                java.lang.Class<com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory> r0 = com.google.android.exoplayer2.source.rtsp.RtspMediaSource.Factory.class
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                B3.o r1 = new B3.o     // Catch: java.lang.ClassNotFoundException -> L3a
                r1.<init>(r0)     // Catch: java.lang.ClassNotFoundException -> L3a
                goto L38
            L48:
                java.lang.Class<com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                B3.n r3 = new B3.n     // Catch: java.lang.ClassNotFoundException -> L3a
                r3.<init>(r1, r0)     // Catch: java.lang.ClassNotFoundException -> L3a
            L53:
                r2 = r3
                goto L6d
            L55:
                java.lang.Class<com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                B3.m r3 = new B3.m     // Catch: java.lang.ClassNotFoundException -> L3a
                r3.<init>(r1, r0)     // Catch: java.lang.ClassNotFoundException -> L3a
                goto L53
            L61:
                java.lang.Class<com.google.android.exoplayer2.source.dash.DashMediaSource$Factory> r3 = com.google.android.exoplayer2.source.dash.DashMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L3a
                B3.l r3 = new B3.l     // Catch: java.lang.ClassNotFoundException -> L3a
                r3.<init>(r1, r0)     // Catch: java.lang.ClassNotFoundException -> L3a
                goto L53
            L6d:
                java.util.Map r0 = r4.b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L81
                java.util.Set r0 = r4.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L81:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: B3.q.a.n(int):r5.r");
        }

        public void o(o.a aVar) {
            if (aVar != this.e) {
                this.e = aVar;
                this.b.clear();
                this.d.clear();
            }
        }

        public void p(V2.B b) {
            this.f = b;
            Iterator it = this.d.values().iterator();
            while (it.hasNext()) {
                ((C.a) it.next()).d(b);
            }
        }

        public void q(b4.F f) {
            this.g = f;
            Iterator it = this.d.values().iterator();
            while (it.hasNext()) {
                ((C.a) it.next()).a(f);
            }
        }
    }

    public q(Context context) {
        this(new w.a(context));
    }

    public static /* synthetic */ d3.i[] e(z0 z0Var) {
        return h(z0Var);
    }

    public static /* synthetic */ C.a f(Class cls) {
        return k(cls);
    }

    public static /* synthetic */ C.a g(Class cls, o.a aVar) {
        return l(cls, aVar);
    }

    public static /* synthetic */ d3.i[] h(z0 z0Var) {
        P3.l lVar = P3.l.a;
        return new d3.i[]{lVar.a(z0Var) ? new P3.m(lVar.b(z0Var), z0Var) : new b(z0Var)};
    }

    public static C i(H0 h0, C c) {
        H0.d dVar = h0.g;
        if (dVar.a == 0 && dVar.c == Long.MIN_VALUE && !dVar.e) {
            return c;
        }
        long P0 = d4.k0.P0(h0.g.a);
        long P02 = d4.k0.P0(h0.g.c);
        H0.d dVar2 = h0.g;
        return new e(c, P0, P02, !dVar2.f, dVar2.d, dVar2.e);
    }

    public static C.a k(Class cls) {
        try {
            return (C.a) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static C.a l(Class cls, o.a aVar) {
        try {
            return (C.a) cls.getConstructor(new Class[]{o.a.class}).newInstance(new Object[]{aVar});
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public C b(H0 h0) {
        d4.a.e(h0.c);
        String scheme = h0.c.a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((C.a) d4.a.e(this.c)).b(h0);
        }
        H0.h hVar = h0.c;
        int y0 = d4.k0.y0(hVar.a, hVar.c);
        C.a g = this.a.g(y0);
        d4.a.j(g, "No suitable media source factory found for content type: " + y0);
        H0.g.a b2 = h0.e.b();
        if (h0.e.a == -9223372036854775807L) {
            b2.k(this.g);
        }
        if (h0.e.e == -3.4028235E38f) {
            b2.j(this.j);
        }
        if (h0.e.f == -3.4028235E38f) {
            b2.h(this.k);
        }
        if (h0.e.c == -9223372036854775807L) {
            b2.i(this.h);
        }
        if (h0.e.d == -9223372036854775807L) {
            b2.g(this.i);
        }
        H0.g f = b2.f();
        if (!f.equals(h0.e)) {
            h0 = h0.b().f(f).a();
        }
        C b3 = g.b(h0);
        s5.y yVar = ((H0.h) d4.k0.j(h0.c)).h;
        if (!yVar.isEmpty()) {
            C[] cArr = new C[yVar.size() + 1];
            cArr[0] = b3;
            for (int i = 0; i < yVar.size(); i++) {
                if (this.l) {
                    T.b bVar = new T.b(this.b, new k(new z0.b().g0(((H0.k) yVar.get(i)).c).X(((H0.k) yVar.get(i)).d).i0(((H0.k) yVar.get(i)).e).e0(((H0.k) yVar.get(i)).f).W(((H0.k) yVar.get(i)).g).U(((H0.k) yVar.get(i)).h).G()));
                    b4.F f2 = this.f;
                    if (f2 != null) {
                        bVar.a(f2);
                    }
                    cArr[i + 1] = bVar.b(H0.e(((H0.k) yVar.get(i)).a.toString()));
                } else {
                    d0.b bVar2 = new d0.b(this.b);
                    b4.F f3 = this.f;
                    if (f3 != null) {
                        bVar2.b(f3);
                    }
                    cArr[i + 1] = bVar2.a((H0.k) yVar.get(i), -9223372036854775807L);
                }
            }
            b3 = new L(cArr);
        }
        return j(h0, i(h0, b3));
    }

    public int[] c() {
        return this.a.h();
    }

    public final C j(H0 h0, C c) {
        String str;
        d4.a.e(h0.c);
        H0.b bVar = h0.c.e;
        if (bVar == null) {
            return c;
        }
        e.b bVar2 = this.d;
        a4.b bVar3 = this.e;
        if (bVar2 == null || bVar3 == null) {
            str = "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.";
        } else {
            C3.e a2 = bVar2.a(bVar);
            if (a2 != null) {
                b4.s sVar = new b4.s(bVar.a);
                Object obj = bVar.c;
                return new C3.h(c, sVar, obj != null ? obj : s5.y.D(h0.a, h0.c.a, bVar.a), this, a2, bVar3);
            }
            str = "Playing media without ads, as no AdsLoader was provided.";
        }
        d4.B.j("DMediaSourceFactory", str);
        return c;
    }

    public q m(o.a aVar) {
        this.b = aVar;
        this.a.o(aVar);
        return this;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public q d(V2.B b2) {
        this.a.p((V2.B) d4.a.f(b2, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public q a(b4.F f) {
        this.f = (b4.F) d4.a.f(f, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.a.q(f);
        return this;
    }

    public q p(e.b bVar, a4.b bVar2) {
        this.d = (e.b) d4.a.e(bVar);
        this.e = (a4.b) d4.a.e(bVar2);
        return this;
    }

    public q q(C.a aVar) {
        this.c = aVar;
        return this;
    }

    public q(Context context, d3.o oVar) {
        this(new w.a(context), oVar);
    }

    public q(o.a aVar) {
        this(aVar, new d3.f());
    }

    public q(o.a aVar, d3.o oVar) {
        this.b = aVar;
        a aVar2 = new a(oVar);
        this.a = aVar2;
        aVar2.o(aVar);
        this.g = -9223372036854775807L;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.j = -3.4028235E38f;
        this.k = -3.4028235E38f;
    }

    public static final class b implements d3.i {
        public final z0 a;

        public b(z0 z0Var) {
            this.a = z0Var;
        }

        public void b(d3.k kVar) {
            d3.w e = kVar.e(0, 3);
            kVar.n(new g.b(-9223372036854775807L));
            kVar.q();
            e.d(this.a.b().g0("text/x-unknown").K(this.a.m).G());
        }

        public int d(d3.j jVar, d3.t tVar) {
            return jVar.b(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        public boolean h(d3.j jVar) {
            return true;
        }

        public void release() {
        }

        public void a(long j, long j2) {
        }
    }
}
