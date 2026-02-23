package c4;

import android.net.Uri;
import b4.B;
import b4.K;
import b4.Q;
import b4.S;
import b4.m;
import b4.o;
import c4.a;
import c4.b;
import d4.O;
import d4.k0;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements b4.o {
    public final c4.a a;
    public final b4.o b;
    public final b4.o c;
    public final b4.o d;
    public final i e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public Uri i;
    public b4.s j;
    public b4.s k;
    public b4.o l;
    public long m;
    public long n;
    public long o;
    public j p;
    public boolean q;
    public boolean r;
    public long s;
    public long t;

    public interface b {
    }

    public static final class c implements o.a {
        public c4.a a;
        public m.a c;
        public boolean e;
        public o.a f;
        public int g;
        public int h;
        public o.a b = new B.b();
        public i d = i.a;

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a() {
            o.a aVar = this.f;
            return e(aVar != null ? aVar.a() : null, this.h, this.g);
        }

        public c c() {
            o.a aVar = this.f;
            return e(aVar != null ? aVar.a() : null, this.h | 1, -1000);
        }

        public c d() {
            return e(null, this.h | 1, -1000);
        }

        public final c e(b4.o oVar, int i, int i2) {
            b4.m mVar;
            c4.a aVar = (c4.a) d4.a.e(this.a);
            if (this.e || oVar == null) {
                mVar = null;
            } else {
                m.a aVar2 = this.c;
                mVar = aVar2 != null ? aVar2.a() : new b.b().b(aVar).a();
            }
            return new c(aVar, oVar, this.b.a(), mVar, this.d, i, null, i2, null, null);
        }

        public c4.a f() {
            return this.a;
        }

        public i g() {
            return this.d;
        }

        public O h() {
            return null;
        }

        public c i(c4.a aVar) {
            this.a = aVar;
            return this;
        }

        public c j(m.a aVar) {
            this.c = aVar;
            this.e = aVar == null;
            return this;
        }

        public c k(int i) {
            this.h = i;
            return this;
        }

        public c l(o.a aVar) {
            this.f = aVar;
            return this;
        }
    }

    public c(c4.a aVar, b4.o oVar, b4.o oVar2, b4.m mVar, i iVar, int i, O o, int i2, b bVar) {
        this.a = aVar;
        this.b = oVar2;
        this.e = iVar == null ? i.a : iVar;
        this.f = (i & 1) != 0;
        this.g = (i & 2) != 0;
        this.h = (i & 4) != 0;
        Q q = null;
        if (oVar != null) {
            this.d = oVar;
            if (mVar != null) {
                q = new Q(oVar, mVar);
            }
        } else {
            this.d = K.a;
        }
        this.c = q;
    }

    public static Uri v(c4.a aVar, String str, Uri uri) {
        Uri b2 = n.b(aVar.b(str));
        return b2 != null ? b2 : uri;
    }

    public final boolean A() {
        return this.l == this.c;
    }

    public final void D(b4.s sVar, boolean z) {
        j h;
        long j;
        b4.s a2;
        b4.o oVar;
        String str = (String) k0.j(sVar.i);
        if (this.r) {
            h = null;
        } else if (this.f) {
            try {
                h = this.a.h(str, this.n, this.o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            h = this.a.d(str, this.n, this.o);
        }
        if (h == null) {
            oVar = this.d;
            a2 = sVar.a().h(this.n).g(this.o).a();
        } else if (h.e) {
            Uri fromFile = Uri.fromFile((File) k0.j(h.f));
            long j2 = h.c;
            long j3 = this.n - j2;
            long j4 = h.d - j3;
            long j5 = this.o;
            if (j5 != -1) {
                j4 = Math.min(j4, j5);
            }
            a2 = sVar.a().i(fromFile).k(j2).h(j3).g(j4).a();
            oVar = this.b;
        } else {
            if (h.h()) {
                j = this.o;
            } else {
                j = h.d;
                long j6 = this.o;
                if (j6 != -1) {
                    j = Math.min(j, j6);
                }
            }
            a2 = sVar.a().h(this.n).g(j).a();
            oVar = this.c;
            if (oVar == null) {
                oVar = this.d;
                this.a.g(h);
                h = null;
            }
        }
        this.t = (this.r || oVar != this.d) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            d4.a.g(x());
            if (oVar == this.d) {
                return;
            }
            try {
                j();
            } finally {
            }
        }
        if (h != null && h.b()) {
            this.p = h;
        }
        this.l = oVar;
        this.k = a2;
        this.m = 0L;
        long a3 = oVar.a(a2);
        p pVar = new p();
        if (a2.h == -1 && a3 != -1) {
            this.o = a3;
            p.g(pVar, this.n + a3);
        }
        if (z()) {
            Uri uri = oVar.getUri();
            this.i = uri;
            p.h(pVar, sVar.a.equals(uri) ^ true ? this.i : null);
        }
        if (A()) {
            this.a.f(str, pVar);
        }
    }

    public final void E(String str) {
        this.o = 0L;
        if (A()) {
            p pVar = new p();
            p.g(pVar, this.n);
            this.a.f(str, pVar);
        }
    }

    public final int F(b4.s sVar) {
        if (this.g && this.q) {
            return 0;
        }
        return (this.h && sVar.h == -1) ? 1 : -1;
    }

    public long a(b4.s sVar) {
        try {
            String a2 = this.e.a(sVar);
            b4.s a3 = sVar.a().f(a2).a();
            this.j = a3;
            this.i = v(this.a, a2, a3.a);
            this.n = sVar.g;
            int F = F(sVar);
            boolean z = F != -1;
            this.r = z;
            if (z) {
                C(F);
            }
            if (this.r) {
                this.o = -1L;
            } else {
                long a4 = n.a(this.a.b(a2));
                this.o = a4;
                if (a4 != -1) {
                    long j = a4 - sVar.g;
                    this.o = j;
                    if (j < 0) {
                        throw new b4.p(2008);
                    }
                }
            }
            long j2 = sVar.h;
            if (j2 != -1) {
                long j3 = this.o;
                if (j3 != -1) {
                    j2 = Math.min(j3, j2);
                }
                this.o = j2;
            }
            long j4 = this.o;
            if (j4 > 0 || j4 == -1) {
                D(a3, false);
            }
            long j5 = sVar.h;
            return j5 != -1 ? j5 : this.o;
        } catch (Throwable th) {
            w(th);
            throw th;
        }
    }

    public void close() {
        this.j = null;
        this.i = null;
        this.n = 0L;
        B();
        try {
            j();
        } catch (Throwable th) {
            w(th);
            throw th;
        }
    }

    public Map e() {
        return z() ? this.d.e() : Collections.emptyMap();
    }

    public void g(S s) {
        d4.a.e(s);
        this.b.g(s);
        this.d.g(s);
    }

    public Uri getUri() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        b4.o oVar = this.l;
        if (oVar == null) {
            return;
        }
        try {
            oVar.close();
        } finally {
            this.k = null;
            this.l = null;
            j jVar = this.p;
            if (jVar != null) {
                this.a.g(jVar);
                this.p = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:10:0x001e, B:12:0x0026, B:13:0x002d, B:15:0x003d, B:17:0x0043, B:18:0x0049, B:20:0x005a, B:22:0x005e, B:24:0x0064, B:26:0x006a, B:28:0x0070, B:29:0x007c, B:34:0x0088), top: B:9:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 0
            if (r15 != 0) goto L4
            return r0
        L4:
            long r1 = r12.o
            r3 = -1
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto Le
            return r3
        Le:
            b4.s r1 = r12.j
            java.lang.Object r1 = d4.a.e(r1)
            b4.s r1 = (b4.s) r1
            b4.s r2 = r12.k
            java.lang.Object r2 = d4.a.e(r2)
            b4.s r2 = (b4.s) r2
            long r6 = r12.n     // Catch: java.lang.Throwable -> L2b
            long r8 = r12.t     // Catch: java.lang.Throwable -> L2b
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L2d
            r6 = 1
            r12.D(r1, r6)     // Catch: java.lang.Throwable -> L2b
            goto L2d
        L2b:
            r13 = move-exception
            goto L93
        L2d:
            b4.o r6 = r12.l     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r6 = d4.a.e(r6)     // Catch: java.lang.Throwable -> L2b
            b4.o r6 = (b4.o) r6     // Catch: java.lang.Throwable -> L2b
            int r6 = r6.read(r13, r14, r15)     // Catch: java.lang.Throwable -> L2b
            r7 = -1
            if (r6 == r3) goto L5e
            boolean r13 = r12.y()     // Catch: java.lang.Throwable -> L2b
            if (r13 == 0) goto L49
            long r13 = r12.s     // Catch: java.lang.Throwable -> L2b
            long r0 = (long) r6     // Catch: java.lang.Throwable -> L2b
            long r13 = r13 + r0
            r12.s = r13     // Catch: java.lang.Throwable -> L2b
        L49:
            long r13 = r12.n     // Catch: java.lang.Throwable -> L2b
            long r0 = (long) r6     // Catch: java.lang.Throwable -> L2b
            long r13 = r13 + r0
            r12.n = r13     // Catch: java.lang.Throwable -> L2b
            long r13 = r12.m     // Catch: java.lang.Throwable -> L2b
            long r13 = r13 + r0
            r12.m = r13     // Catch: java.lang.Throwable -> L2b
            long r13 = r12.o     // Catch: java.lang.Throwable -> L2b
            int r15 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r15 == 0) goto L87
            long r13 = r13 - r0
            r12.o = r13     // Catch: java.lang.Throwable -> L2b
            goto L87
        L5e:
            boolean r3 = r12.z()     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L7c
            long r2 = r2.h     // Catch: java.lang.Throwable -> L2b
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 == 0) goto L70
            long r9 = r12.m     // Catch: java.lang.Throwable -> L2b
            int r11 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r11 >= 0) goto L7c
        L70:
            java.lang.String r13 = r1.i     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r13 = d4.k0.j(r13)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L2b
            r12.E(r13)     // Catch: java.lang.Throwable -> L2b
            goto L87
        L7c:
            long r2 = r12.o     // Catch: java.lang.Throwable -> L2b
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L88
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 != 0) goto L87
            goto L88
        L87:
            return r6
        L88:
            r12.j()     // Catch: java.lang.Throwable -> L2b
            r12.D(r1, r0)     // Catch: java.lang.Throwable -> L2b
            int r13 = r12.read(r13, r14, r15)     // Catch: java.lang.Throwable -> L2b
            return r13
        L93:
            r12.w(r13)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.c.read(byte[], int, int):int");
    }

    public c4.a t() {
        return this.a;
    }

    public i u() {
        return this.e;
    }

    public final void w(Throwable th) {
        if (y() || (th instanceof a.a)) {
            this.q = true;
        }
    }

    public final boolean x() {
        return this.l == this.d;
    }

    public final boolean y() {
        return this.l == this.b;
    }

    public final boolean z() {
        return !y();
    }

    public /* synthetic */ c(c4.a aVar, b4.o oVar, b4.o oVar2, b4.m mVar, i iVar, int i, O o, int i2, b bVar, a aVar2) {
        this(aVar, oVar, oVar2, mVar, iVar, i, o, i2, bVar);
    }

    public final void B() {
    }

    public final void C(int i) {
    }
}
