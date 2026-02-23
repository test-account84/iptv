package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q {
    public final s.i a = new s.i();
    public final s.f b = new s.f();

    public static class a {
        public static O.e d = new O.f(20);
        public int a;
        public RecyclerView.l.c b;
        public RecyclerView.l.c c;

        public static void a() {
            while (d.b() != null) {
            }
        }

        public static a b() {
            a aVar = (a) d.b();
            return aVar == null ? new a() : aVar;
        }

        public static void c(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }
    }

    public interface b {
        void a(RecyclerView.D d, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void b(RecyclerView.D d);

        void c(RecyclerView.D d, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.D d, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    public void a(RecyclerView.D d, RecyclerView.l.c cVar) {
        a aVar = (a) this.a.get(d);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(d, aVar);
        }
        aVar.a |= 2;
        aVar.b = cVar;
    }

    public void b(RecyclerView.D d) {
        a aVar = (a) this.a.get(d);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(d, aVar);
        }
        aVar.a |= 1;
    }

    public void c(long j, RecyclerView.D d) {
        this.b.k(j, d);
    }

    public void d(RecyclerView.D d, RecyclerView.l.c cVar) {
        a aVar = (a) this.a.get(d);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(d, aVar);
        }
        aVar.c = cVar;
        aVar.a |= 8;
    }

    public void e(RecyclerView.D d, RecyclerView.l.c cVar) {
        a aVar = (a) this.a.get(d);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(d, aVar);
        }
        aVar.b = cVar;
        aVar.a |= 4;
    }

    public void f() {
        this.a.clear();
        this.b.d();
    }

    public RecyclerView.D g(long j) {
        return (RecyclerView.D) this.b.g(j);
    }

    public boolean h(RecyclerView.D d) {
        a aVar = (a) this.a.get(d);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.D d) {
        a aVar = (a) this.a.get(d);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.D d) {
        p(d);
    }

    public final RecyclerView.l.c l(RecyclerView.D d, int i) {
        a aVar;
        RecyclerView.l.c cVar;
        int g = this.a.g(d);
        if (g >= 0 && (aVar = (a) this.a.o(g)) != null) {
            int i2 = aVar.a;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                aVar.a = i3;
                if (i == 4) {
                    cVar = aVar.b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVar.c;
                }
                if ((i3 & 12) == 0) {
                    this.a.m(g);
                    a.c(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    public RecyclerView.l.c m(RecyclerView.D d) {
        return l(d, 8);
    }

    public RecyclerView.l.c n(RecyclerView.D d) {
        return l(d, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void o(androidx.recyclerview.widget.q.b r7) {
        /*
            r6 = this;
            s.i r0 = r6.a
            int r0 = r0.size()
            int r0 = r0 + (-1)
        L8:
            if (r0 < 0) goto L63
            s.i r1 = r6.a
            java.lang.Object r1 = r1.j(r0)
            androidx.recyclerview.widget.RecyclerView$D r1 = (androidx.recyclerview.widget.RecyclerView.D) r1
            s.i r2 = r6.a
            java.lang.Object r2 = r2.m(r0)
            androidx.recyclerview.widget.q$a r2 = (androidx.recyclerview.widget.q.a) r2
            int r3 = r2.a
            r4 = r3 & 3
            r5 = 3
            if (r4 != r5) goto L25
        L21:
            r7.b(r1)
            goto L5d
        L25:
            r4 = r3 & 1
            if (r4 == 0) goto L34
            androidx.recyclerview.widget.RecyclerView$l$c r3 = r2.b
            if (r3 != 0) goto L2e
            goto L21
        L2e:
            androidx.recyclerview.widget.RecyclerView$l$c r4 = r2.c
        L30:
            r7.c(r1, r3, r4)
            goto L5d
        L34:
            r4 = r3 & 14
            r5 = 14
            if (r4 != r5) goto L42
        L3a:
            androidx.recyclerview.widget.RecyclerView$l$c r3 = r2.b
            androidx.recyclerview.widget.RecyclerView$l$c r4 = r2.c
            r7.a(r1, r3, r4)
            goto L5d
        L42:
            r4 = r3 & 12
            r5 = 12
            if (r4 != r5) goto L50
            androidx.recyclerview.widget.RecyclerView$l$c r3 = r2.b
            androidx.recyclerview.widget.RecyclerView$l$c r4 = r2.c
            r7.d(r1, r3, r4)
            goto L5d
        L50:
            r4 = r3 & 4
            if (r4 == 0) goto L58
            androidx.recyclerview.widget.RecyclerView$l$c r3 = r2.b
            r4 = 0
            goto L30
        L58:
            r3 = r3 & 8
            if (r3 == 0) goto L5d
            goto L3a
        L5d:
            androidx.recyclerview.widget.q.a.c(r2)
            int r0 = r0 + (-1)
            goto L8
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q.o(androidx.recyclerview.widget.q$b):void");
    }

    public void p(RecyclerView.D d) {
        a aVar = (a) this.a.get(d);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    public void q(RecyclerView.D d) {
        int n = this.b.n() - 1;
        while (true) {
            if (n < 0) {
                break;
            }
            if (d == this.b.o(n)) {
                this.b.m(n);
                break;
            }
            n--;
        }
        a aVar = (a) this.a.remove(d);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
