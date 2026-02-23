package f3;

import O2.l1;
import O2.z0;
import com.google.android.exoplayer2.extractor.g;
import d3.i;
import d3.j;
import d3.k;
import d3.t;
import d3.w;
import d4.B;
import d4.F;
import d4.M;
import java.util.ArrayList;
import s5.c0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements i {
    public int c;
    public f3.c e;
    public long h;
    public e i;
    public int m;
    public boolean n;
    public final M a = new M(12);
    public final c b = new c(null);
    public k d = new d3.g();
    public e[] g = new e[0];
    public long k = -1;
    public long l = -1;
    public int j = -1;
    public long f = -9223372036854775807L;

    public class b implements com.google.android.exoplayer2.extractor.g {
        public final long a;

        public b(long j) {
            this.a = j;
        }

        public g.a e(long j) {
            g.a i = b.c(b.this)[0].i(j);
            for (int i2 = 1; i2 < b.c(b.this).length; i2++) {
                g.a i3 = b.c(b.this)[i2].i(j);
                if (i3.a.b < i.a.b) {
                    i = i3;
                }
            }
            return i;
        }

        public boolean g() {
            return true;
        }

        public long i() {
            return this.a;
        }
    }

    public static class c {
        public int a;
        public int b;
        public int c;

        public c() {
        }

        public void a(M m) {
            this.a = m.u();
            this.b = m.u();
            this.c = 0;
        }

        public void b(M m) {
            a(m);
            if (this.a == 1414744396) {
                this.c = m.u();
                return;
            }
            throw l1.a("LIST expected, found: " + this.a, null);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static /* synthetic */ e[] c(b bVar) {
        return bVar.g;
    }

    public static void e(j jVar) {
        if ((jVar.getPosition() & 1) == 1) {
            jVar.q(1);
        }
    }

    public void a(long j, long j2) {
        this.h = -1L;
        this.i = null;
        for (e eVar : this.g) {
            eVar.o(j);
        }
        if (j != 0) {
            this.c = 6;
        } else if (this.g.length == 0) {
            this.c = 0;
        } else {
            this.c = 3;
        }
    }

    public void b(k kVar) {
        this.c = 0;
        this.d = kVar;
        this.h = -1L;
    }

    public int d(j jVar, t tVar) {
        if (m(jVar, tVar)) {
            return 1;
        }
        switch (this.c) {
            case 0:
                if (!h(jVar)) {
                    throw l1.a("AVI Header List not found", null);
                }
                jVar.q(12);
                this.c = 1;
                return 0;
            case 1:
                jVar.m(this.a.e(), 0, 12);
                this.a.U(0);
                this.b.b(this.a);
                c cVar = this.b;
                if (cVar.c == 1819436136) {
                    this.j = cVar.b;
                    this.c = 2;
                    return 0;
                }
                throw l1.a("hdrl expected, found: " + this.b.c, null);
            case 2:
                int i = this.j - 4;
                M m = new M(i);
                jVar.m(m.e(), 0, i);
                g(m);
                this.c = 3;
                return 0;
            case 3:
                if (this.k != -1) {
                    long position = jVar.getPosition();
                    long j = this.k;
                    if (position != j) {
                        this.h = j;
                        return 0;
                    }
                }
                jVar.s(this.a.e(), 0, 12);
                jVar.f();
                this.a.U(0);
                this.b.a(this.a);
                int u = this.a.u();
                int i2 = this.b.a;
                if (i2 == 1179011410) {
                    jVar.q(12);
                    return 0;
                }
                if (i2 != 1414744396 || u != 1769369453) {
                    this.h = jVar.getPosition() + this.b.b + 8;
                    return 0;
                }
                long position2 = jVar.getPosition();
                this.k = position2;
                this.l = position2 + this.b.b + 8;
                if (!this.n) {
                    if (((f3.c) d4.a.e(this.e)).a()) {
                        this.c = 4;
                        this.h = this.l;
                        return 0;
                    }
                    this.d.n(new g.b(this.f));
                    this.n = true;
                }
                this.h = jVar.getPosition() + 12;
                this.c = 6;
                return 0;
            case 4:
                jVar.m(this.a.e(), 0, 8);
                this.a.U(0);
                int u2 = this.a.u();
                int u3 = this.a.u();
                if (u2 == 829973609) {
                    this.c = 5;
                    this.m = u3;
                } else {
                    this.h = jVar.getPosition() + u3;
                }
                return 0;
            case 5:
                M m2 = new M(this.m);
                jVar.m(m2.e(), 0, this.m);
                i(m2);
                this.c = 6;
                this.h = this.k;
                return 0;
            case 6:
                return l(jVar);
            default:
                throw new AssertionError();
        }
    }

    public final e f(int i) {
        for (e eVar : this.g) {
            if (eVar.j(i)) {
                return eVar;
            }
        }
        return null;
    }

    public final void g(M m) {
        f c2 = f.c(1819436136, m);
        if (c2.getType() != 1819436136) {
            throw l1.a("Unexpected header list type " + c2.getType(), null);
        }
        f3.c cVar = (f3.c) c2.b(f3.c.class);
        if (cVar == null) {
            throw l1.a("AviHeader not found", null);
        }
        this.e = cVar;
        this.f = cVar.c * cVar.a;
        ArrayList arrayList = new ArrayList();
        c0 l = c2.a.l();
        int i = 0;
        while (l.hasNext()) {
            f3.a aVar = (f3.a) l.next();
            if (aVar.getType() == 1819440243) {
                int i2 = i + 1;
                e k = k((f) aVar, i);
                if (k != null) {
                    arrayList.add(k);
                }
                i = i2;
            }
        }
        this.g = (e[]) arrayList.toArray(new e[0]);
        this.d.q();
    }

    public boolean h(j jVar) {
        jVar.s(this.a.e(), 0, 12);
        this.a.U(0);
        if (this.a.u() != 1179011410) {
            return false;
        }
        this.a.V(4);
        return this.a.u() == 541677121;
    }

    public final void i(M m) {
        long j = j(m);
        while (m.a() >= 16) {
            int u = m.u();
            int u2 = m.u();
            long u3 = m.u() + j;
            m.u();
            e f = f(u);
            if (f != null) {
                if ((u2 & 16) == 16) {
                    f.b(u3);
                }
                f.k();
            }
        }
        for (e eVar : this.g) {
            eVar.c();
        }
        this.n = true;
        this.d.n(new b(this.f));
    }

    public final long j(M m) {
        if (m.a() < 16) {
            return 0L;
        }
        int f = m.f();
        m.V(8);
        long u = m.u();
        long j = this.k;
        long j2 = u <= j ? j + 8 : 0L;
        m.U(f);
        return j2;
    }

    public final e k(f fVar, int i) {
        String str;
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            str = "Missing Stream Header";
        } else {
            if (gVar != null) {
                long a2 = dVar.a();
                z0 z0Var = gVar.a;
                z0.b b2 = z0Var.b();
                b2.T(i);
                int i2 = dVar.f;
                if (i2 != 0) {
                    b2.Y(i2);
                }
                h hVar = (h) fVar.b(h.class);
                if (hVar != null) {
                    b2.W(hVar.a);
                }
                int k = F.k(z0Var.m);
                if (k != 1 && k != 2) {
                    return null;
                }
                w e = this.d.e(i, k);
                e.d(b2.G());
                e eVar = new e(i, k, a2, dVar.e, e);
                this.f = a2;
                return eVar;
            }
            str = "Missing Stream Format";
        }
        B.j("AviExtractor", str);
        return null;
    }

    public final int l(j jVar) {
        if (jVar.getPosition() >= this.l) {
            return -1;
        }
        e eVar = this.i;
        if (eVar == null) {
            e(jVar);
            jVar.s(this.a.e(), 0, 12);
            this.a.U(0);
            int u = this.a.u();
            if (u == 1414744396) {
                this.a.U(8);
                jVar.q(this.a.u() != 1769369453 ? 8 : 12);
                jVar.f();
                return 0;
            }
            int u2 = this.a.u();
            if (u == 1263424842) {
                this.h = jVar.getPosition() + u2 + 8;
                return 0;
            }
            jVar.q(8);
            jVar.f();
            e f = f(u);
            if (f == null) {
                this.h = jVar.getPosition() + u2;
                return 0;
            }
            f.n(u2);
            this.i = f;
        } else if (eVar.m(jVar)) {
            this.i = null;
        }
        return 0;
    }

    public final boolean m(j jVar, t tVar) {
        boolean z;
        if (this.h != -1) {
            long position = jVar.getPosition();
            long j = this.h;
            if (j < position || j > 262144 + position) {
                tVar.a = j;
                z = true;
            } else {
                jVar.q((int) (j - position));
                z = false;
            }
        } else {
            z = false;
        }
        this.h = -1L;
        return z;
    }

    public void release() {
    }
}
