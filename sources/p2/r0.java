package P2;

import B3.C;
import O2.Q1;
import P2.c;
import P2.u0;
import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r0 implements u0 {
    public static final r5.r h = new q0();
    public static final Random i = new Random();
    public final Q1.d a;
    public final Q1.b b;
    public final HashMap c;
    public final r5.r d;
    public u0.a e;
    public Q1 f;
    public String g;

    public final class a {
        public final String a;
        public int b;
        public long c;
        public C.b d;
        public boolean e;
        public boolean f;

        public a(String str, int i, C.b bVar) {
            this.a = str;
            this.b = i;
            this.c = bVar == null ? -1L : bVar.d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.d = bVar;
        }

        public static /* synthetic */ String a(a aVar) {
            return aVar.a;
        }

        public static /* synthetic */ long b(a aVar) {
            return aVar.c;
        }

        public static /* synthetic */ int c(a aVar) {
            return aVar.b;
        }

        public static /* synthetic */ boolean d(a aVar) {
            return aVar.e;
        }

        public static /* synthetic */ boolean e(a aVar, boolean z) {
            aVar.e = z;
            return z;
        }

        public static /* synthetic */ boolean f(a aVar) {
            return aVar.f;
        }

        public static /* synthetic */ boolean g(a aVar, boolean z) {
            aVar.f = z;
            return z;
        }

        public static /* synthetic */ C.b h(a aVar) {
            return aVar.d;
        }

        public boolean i(int i, C.b bVar) {
            if (bVar == null) {
                return i == this.b;
            }
            C.b bVar2 = this.d;
            return bVar2 == null ? !bVar.b() && bVar.d == this.c : bVar.d == bVar2.d && bVar.b == bVar2.b && bVar.c == bVar2.c;
        }

        public boolean j(c.a aVar) {
            C.b bVar = aVar.d;
            if (bVar == null) {
                return this.b != aVar.c;
            }
            long j = this.c;
            if (j == -1) {
                return false;
            }
            if (bVar.d > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int f = aVar.b.f(bVar.a);
            int f2 = aVar.b.f(this.d.a);
            C.b bVar2 = aVar.d;
            if (bVar2.d < this.d.d || f < f2) {
                return false;
            }
            if (f > f2) {
                return true;
            }
            boolean b = bVar2.b();
            C.b bVar3 = aVar.d;
            if (!b) {
                int i = bVar3.e;
                return i == -1 || i > this.d.b;
            }
            int i2 = bVar3.b;
            int i3 = bVar3.c;
            C.b bVar4 = this.d;
            int i4 = bVar4.b;
            if (i2 <= i4) {
                return i2 == i4 && i3 > bVar4.c;
            }
            return true;
        }

        public void k(int i, C.b bVar) {
            if (this.c == -1 && i == this.b && bVar != null) {
                this.c = bVar.d;
            }
        }

        public final int l(Q1 q1, Q1 q12, int i) {
            if (i >= q1.u()) {
                if (i < q12.u()) {
                    return i;
                }
                return -1;
            }
            q1.s(i, r0.i(r0.this));
            for (int i2 = r0.i(r0.this).p; i2 <= r0.i(r0.this).q; i2++) {
                int f = q12.f(q1.r(i2));
                if (f != -1) {
                    return q12.k(f, r0.j(r0.this)).d;
                }
            }
            return -1;
        }

        public boolean m(Q1 q1, Q1 q12) {
            int l = l(q1, q12, this.b);
            this.b = l;
            if (l == -1) {
                return false;
            }
            C.b bVar = this.d;
            return bVar == null || q12.f(bVar.a) != -1;
        }
    }

    public r0() {
        this(h);
    }

    public static /* synthetic */ String h() {
        return k();
    }

    public static /* synthetic */ Q1.d i(r0 r0Var) {
        return r0Var.a;
    }

    public static /* synthetic */ Q1.b j(r0 r0Var) {
        return r0Var.b;
    }

    public static String k() {
        byte[] bArr = new byte[12];
        i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    public synchronized String a(Q1 q1, C.b bVar) {
        return a.a(l(q1.m(bVar.a, this.b).d, bVar));
    }

    public synchronized String b() {
        return this.g;
    }

    public void c(u0.a aVar) {
        this.e = aVar;
    }

    public synchronized void d(c.a aVar) {
        try {
            d4.a.e(this.e);
            Q1 q1 = this.f;
            this.f = aVar.b;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (!aVar2.m(q1, this.f) || aVar2.j(aVar)) {
                    it.remove();
                    if (a.d(aVar2)) {
                        if (a.a(aVar2).equals(this.g)) {
                            this.g = null;
                        }
                        this.e.S(aVar, a.a(aVar2), false);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void e(c.a aVar, int i2) {
        try {
            d4.a.e(this.e);
            boolean z = i2 == 0;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.j(aVar)) {
                    it.remove();
                    if (a.d(aVar2)) {
                        boolean equals = a.a(aVar2).equals(this.g);
                        boolean z2 = z && equals && a.f(aVar2);
                        if (equals) {
                            this.g = null;
                        }
                        this.e.S(aVar, a.a(aVar2), z2);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r25.d.d < P2.r0.a.b(r2)) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void f(P2.c.a r25) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.r0.f(P2.c$a):void");
    }

    public synchronized void g(c.a aVar) {
        u0.a aVar2;
        this.g = null;
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            a aVar3 = (a) it.next();
            it.remove();
            if (a.d(aVar3) && (aVar2 = this.e) != null) {
                aVar2.S(aVar, a.a(aVar3), false);
            }
        }
    }

    public final a l(int i2, C.b bVar) {
        a aVar = null;
        long j = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            aVar2.k(i2, bVar);
            if (aVar2.i(i2, bVar)) {
                long b = a.b(aVar2);
                if (b == -1 || b < j) {
                    aVar = aVar2;
                    j = b;
                } else if (b == j && a.h((a) d4.k0.j(aVar)) != null && a.h(aVar2) != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = (String) this.d.get();
        a aVar3 = new a(str, i2, bVar);
        this.c.put(str, aVar3);
        return aVar3;
    }

    public final void m(c.a aVar) {
        if (aVar.b.v()) {
            this.g = null;
            return;
        }
        a aVar2 = (a) this.c.get(this.g);
        a l = l(aVar.c, aVar.d);
        this.g = a.a(l);
        f(aVar);
        C.b bVar = aVar.d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && a.b(aVar2) == aVar.d.d && a.h(aVar2) != null && a.h(aVar2).b == aVar.d.b && a.h(aVar2).c == aVar.d.c) {
            return;
        }
        C.b bVar2 = aVar.d;
        this.e.v(aVar, a.a(l(aVar.c, new C.b(bVar2.a, bVar2.d))), a.a(l));
    }

    public r0(r5.r rVar) {
        this.d = rVar;
        this.a = new Q1.d();
        this.b = new Q1.b();
        this.c = new HashMap();
        this.f = Q1.a;
    }
}
