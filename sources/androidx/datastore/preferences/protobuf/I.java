package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.r0;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i implements d0 {
    public final h a;
    public int b;
    public int c;
    public int d = 0;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r0.b.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r0.b.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r0.b.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r0.b.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r0.b.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public i(h hVar) {
        h hVar2 = (h) y.b(hVar, "input");
        this.a = hVar2;
        hVar2.d = this;
    }

    public static i P(h hVar) {
        i iVar = hVar.d;
        return iVar != null ? iVar : new i(hVar);
    }

    private Object Q(r0.b bVar, Class cls, o oVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(e());
            case 2:
                return p();
            case 3:
                return Double.valueOf(i());
            case 4:
                return Integer.valueOf(l());
            case 5:
                return Integer.valueOf(x());
            case 6:
                return Long.valueOf(b());
            case 7:
                return Float.valueOf(J());
            case 8:
                return Integer.valueOf(q());
            case 9:
                return Long.valueOf(N());
            case 10:
                return T(cls, oVar);
            case 11:
                return Integer.valueOf(K());
            case 12:
                return Long.valueOf(f());
            case 13:
                return Integer.valueOf(m());
            case 14:
                return Long.valueOf(C());
            case 15:
                return O();
            case 16:
                return Integer.valueOf(h());
            case 17:
                return Long.valueOf(v());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private Object R(e0 e0Var, o oVar) {
        int i = this.c;
        this.c = r0.c(r0.a(this.b), 4);
        try {
            Object f = e0Var.f();
            e0Var.b(f, this, oVar);
            e0Var.c(f);
            if (this.b == this.c) {
                return f;
            }
            throw z.g();
        } finally {
            this.c = i;
        }
    }

    private Object S(e0 e0Var, o oVar) {
        int C = this.a.C();
        h hVar = this.a;
        if (hVar.a >= hVar.b) {
            throw z.h();
        }
        int l = hVar.l(C);
        Object f = e0Var.f();
        this.a.a++;
        e0Var.b(f, this, oVar);
        e0Var.c(f);
        this.a.a(0);
        r5.a--;
        this.a.k(l);
        return f;
    }

    private void V(int i) {
        if (this.a.d() != i) {
            throw z.k();
        }
    }

    private void W(int i) {
        if (r0.b(this.b) != i) {
            throw z.d();
        }
    }

    private void X(int i) {
        if ((i & 3) != 0) {
            throw z.g();
        }
    }

    private void Y(int i) {
        if ((i & 7) != 0) {
            throw z.g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        r7.a.k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A(java.util.Map r8, androidx.datastore.preferences.protobuf.H.a r9, androidx.datastore.preferences.protobuf.o r10) {
        /*
            r7 = this;
            r0 = 2
            r7.W(r0)
            androidx.datastore.preferences.protobuf.h r1 = r7.a
            int r1 = r1.C()
            androidx.datastore.preferences.protobuf.h r2 = r7.a
            int r1 = r2.l(r1)
            java.lang.Object r2 = r9.b
            java.lang.Object r3 = r9.d
        L14:
            int r4 = r7.E()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.h r5 = r7.a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.I()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.z r4 = new androidx.datastore.preferences.protobuf.z     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.r0$b r4 = r9.c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            java.lang.Object r5 = r9.d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            java.lang.Object r3 = r7.Q(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.r0$b r4 = r9.a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            r5 = 0
            java.lang.Object r2 = r7.Q(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.z.a -> L51
            goto L14
        L51:
            boolean r4 = r7.I()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.z r8 = new androidx.datastore.preferences.protobuf.z     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.h r8 = r7.a
            r8.k(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.h r9 = r7.a
            r9.k(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.A(java.util.Map, androidx.datastore.preferences.protobuf.H$a, androidx.datastore.preferences.protobuf.o):void");
    }

    public void B(List list) {
        int B;
        if (list instanceof x) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b != 2) {
                if (b != 5) {
                    throw z.d();
                }
                this.a.q();
                throw null;
            }
            X(this.a.C());
            this.a.d();
            this.a.q();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 2) {
            int C = this.a.C();
            X(C);
            int d = this.a.d() + C;
            do {
                list.add(Integer.valueOf(this.a.q()));
            } while (this.a.d() < d);
            return;
        }
        if (b2 != 5) {
            throw z.d();
        }
        do {
            list.add(Integer.valueOf(this.a.q()));
            if (this.a.e()) {
                return;
            } else {
                B = this.a.B();
            }
        } while (B == this.b);
        this.d = B;
    }

    public long C() {
        W(0);
        return this.a.y();
    }

    public String D() {
        W(2);
        return this.a.z();
    }

    public int E() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.B();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return r0.a(i2);
    }

    public void F(List list) {
        U(list, false);
    }

    public void G(List list) {
        int B;
        if (list instanceof u) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b != 2) {
                if (b != 5) {
                    throw z.d();
                }
                this.a.s();
                throw null;
            }
            X(this.a.C());
            this.a.d();
            this.a.s();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 2) {
            int C = this.a.C();
            X(C);
            int d = this.a.d() + C;
            do {
                list.add(Float.valueOf(this.a.s()));
            } while (this.a.d() < d);
            return;
        }
        if (b2 != 5) {
            throw z.d();
        }
        do {
            list.add(Float.valueOf(this.a.s()));
            if (this.a.e()) {
                return;
            } else {
                B = this.a.B();
            }
        } while (B == this.b);
        this.d = B;
    }

    public void H(List list, e0 e0Var, o oVar) {
        int B;
        if (r0.b(this.b) != 3) {
            throw z.d();
        }
        int i = this.b;
        do {
            list.add(R(e0Var, oVar));
            if (this.a.e() || this.d != 0) {
                return;
            } else {
                B = this.a.B();
            }
        } while (B == i);
        this.d = B;
    }

    public boolean I() {
        int i;
        if (this.a.e() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.E(i);
    }

    public float J() {
        W(5);
        return this.a.s();
    }

    public int K() {
        W(5);
        return this.a.v();
    }

    public void L(List list) {
        int B;
        if (r0.b(this.b) != 2) {
            throw z.d();
        }
        do {
            list.add(p());
            if (this.a.e()) {
                return;
            } else {
                B = this.a.B();
            }
        } while (B == this.b);
        this.d = B;
    }

    public void M(List list) {
        int B;
        if (list instanceof l) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 1) {
                this.a.o();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            Y(this.a.C());
            this.a.d();
            this.a.o();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 1) {
            do {
                list.add(Double.valueOf(this.a.o()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int C = this.a.C();
        Y(C);
        int d = this.a.d() + C;
        do {
            list.add(Double.valueOf(this.a.o()));
        } while (this.a.d() < d);
    }

    public long N() {
        W(0);
        return this.a.u();
    }

    public String O() {
        W(2);
        return this.a.A();
    }

    public Object T(Class cls, o oVar) {
        W(2);
        return S(a0.a().c(cls), oVar);
    }

    public void U(List list, boolean z) {
        int B;
        int B2;
        if (r0.b(this.b) != 2) {
            throw z.d();
        }
        if (!(list instanceof D) || z) {
            do {
                list.add(z ? O() : D());
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        D d = (D) list;
        do {
            d.x(p());
            if (this.a.e()) {
                return;
            } else {
                B2 = this.a.B();
            }
        } while (B2 == this.b);
        this.d = B2;
    }

    public Object a(e0 e0Var, o oVar) {
        W(2);
        return S(e0Var, oVar);
    }

    public long b() {
        W(1);
        return this.a.r();
    }

    public void c(List list) {
        int B;
        if (list instanceof x) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b != 2) {
                if (b != 5) {
                    throw z.d();
                }
                this.a.v();
                throw null;
            }
            X(this.a.C());
            this.a.d();
            this.a.v();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 2) {
            int C = this.a.C();
            X(C);
            int d = this.a.d() + C;
            do {
                list.add(Integer.valueOf(this.a.v()));
            } while (this.a.d() < d);
            return;
        }
        if (b2 != 5) {
            throw z.d();
        }
        do {
            list.add(Integer.valueOf(this.a.v()));
            if (this.a.e()) {
                return;
            } else {
                B = this.a.B();
            }
        } while (B == this.b);
        this.d = B;
    }

    public void d(List list) {
        int B;
        if (list instanceof F) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.y();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.y();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Long.valueOf(this.a.y()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Long.valueOf(this.a.y()));
        } while (this.a.d() < d);
        V(d);
    }

    public boolean e() {
        W(0);
        return this.a.m();
    }

    public long f() {
        W(1);
        return this.a.w();
    }

    public void g(List list) {
        int B;
        if (list instanceof F) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.D();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.D();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Long.valueOf(this.a.D()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Long.valueOf(this.a.D()));
        } while (this.a.d() < d);
        V(d);
    }

    public int getTag() {
        return this.b;
    }

    public int h() {
        W(0);
        return this.a.C();
    }

    public double i() {
        W(1);
        return this.a.o();
    }

    public void j(List list) {
        int B;
        if (list instanceof F) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.u();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.u();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Long.valueOf(this.a.u()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Long.valueOf(this.a.u()));
        } while (this.a.d() < d);
        V(d);
    }

    public void k(List list) {
        int B;
        if (list instanceof x) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.p();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.p();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.p()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.p()));
        } while (this.a.d() < d);
        V(d);
    }

    public int l() {
        W(0);
        return this.a.p();
    }

    public int m() {
        W(0);
        return this.a.x();
    }

    public void n(List list) {
        int B;
        if (list instanceof e) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.m();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.m();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Boolean.valueOf(this.a.m()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Boolean.valueOf(this.a.m()));
        } while (this.a.d() < d);
        V(d);
    }

    public void o(List list) {
        U(list, true);
    }

    public g p() {
        W(2);
        return this.a.n();
    }

    public int q() {
        W(0);
        return this.a.t();
    }

    public void r(List list, e0 e0Var, o oVar) {
        int B;
        if (r0.b(this.b) != 2) {
            throw z.d();
        }
        int i = this.b;
        do {
            list.add(S(e0Var, oVar));
            if (this.a.e() || this.d != 0) {
                return;
            } else {
                B = this.a.B();
            }
        } while (B == i);
        this.d = B;
    }

    public void s(List list) {
        int B;
        if (list instanceof F) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 1) {
                this.a.r();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            Y(this.a.C());
            this.a.d();
            this.a.r();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 1) {
            do {
                list.add(Long.valueOf(this.a.r()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int C = this.a.C();
        Y(C);
        int d = this.a.d() + C;
        do {
            list.add(Long.valueOf(this.a.r()));
        } while (this.a.d() < d);
    }

    public Object t(e0 e0Var, o oVar) {
        W(3);
        return R(e0Var, oVar);
    }

    public void u(List list) {
        int B;
        if (list instanceof x) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.x();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.x();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.x()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.x()));
        } while (this.a.d() < d);
        V(d);
    }

    public long v() {
        W(0);
        return this.a.D();
    }

    public void w(List list) {
        int B;
        if (list instanceof x) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.C();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.C();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.C()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.C()));
        } while (this.a.d() < d);
        V(d);
    }

    public int x() {
        W(5);
        return this.a.q();
    }

    public void y(List list) {
        int B;
        if (list instanceof F) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 1) {
                this.a.w();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            Y(this.a.C());
            this.a.d();
            this.a.w();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 1) {
            do {
                list.add(Long.valueOf(this.a.w()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int C = this.a.C();
        Y(C);
        int d = this.a.d() + C;
        do {
            list.add(Long.valueOf(this.a.w()));
        } while (this.a.d() < d);
    }

    public void z(List list) {
        int B;
        if (list instanceof x) {
            d.D.a(list);
            int b = r0.b(this.b);
            if (b == 0) {
                this.a.t();
                throw null;
            }
            if (b != 2) {
                throw z.d();
            }
            this.a.C();
            this.a.d();
            this.a.t();
            throw null;
        }
        int b2 = r0.b(this.b);
        if (b2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.t()));
                if (this.a.e()) {
                    return;
                } else {
                    B = this.a.B();
                }
            } while (B == this.b);
            this.d = B;
            return;
        }
        if (b2 != 2) {
            throw z.d();
        }
        int d = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.t()));
        } while (this.a.d() < d);
        V(d);
    }
}
