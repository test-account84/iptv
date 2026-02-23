package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bpi implements bsd {
    private final bpg a;
    private int b;
    private int c;
    private int d = 0;

    private bpi(bpg bpgVar) {
        bqu.j(bpgVar, "input");
        this.a = bpgVar;
        bpgVar.d = this;
    }

    private final Object S(bsi bsiVar, bqb bqbVar) throws IOException {
        Object e = bsiVar.e();
        U(e, bsiVar, bqbVar);
        bsiVar.f(e);
        return e;
    }

    private final Object T(bsi bsiVar, bqb bqbVar) throws IOException {
        Object e = bsiVar.e();
        V(e, bsiVar, bqbVar);
        bsiVar.f(e);
        return e;
    }

    private final void U(Object obj, bsi bsiVar, bqb bqbVar) throws IOException {
        int i = this.c;
        this.c = btm.c(btm.a(this.b), 4);
        try {
            bsiVar.h(obj, this, bqbVar);
            if (this.b == this.c) {
            } else {
                throw bqw.g();
            }
        } finally {
            this.c = i;
        }
    }

    private final void V(Object obj, bsi bsiVar, bqb bqbVar) throws IOException {
        int n = this.a.n();
        bpg bpgVar = this.a;
        if (bpgVar.a >= bpgVar.b) {
            throw new bqw("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int e = bpgVar.e(n);
        this.a.a++;
        bsiVar.h(obj, this, bqbVar);
        this.a.z(0);
        r5.a--;
        this.a.A(e);
    }

    private final void W(int i) throws IOException {
        if (this.a.d() != i) {
            throw bqw.i();
        }
    }

    private final void X(int i) throws IOException {
        if (btm.b(this.b) != i) {
            throw bqw.a();
        }
    }

    private static final void Y(int i) throws IOException {
        if ((i & 3) != 0) {
            throw bqw.g();
        }
    }

    private static final void Z(int i) throws IOException {
        if ((i & 7) != 0) {
            throw bqw.g();
        }
    }

    public static bpi q(bpg bpgVar) {
        bpi bpiVar = bpgVar.d;
        return bpiVar != null ? bpiVar : new bpi(bpgVar);
    }

    public final void A(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqo)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Integer.valueOf(this.a.f()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Integer.valueOf(this.a.f()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bqo bqoVar = (bqo) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                bqoVar.g(this.a.f());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            bqoVar.g(this.a.f());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void B(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqo)) {
            int b = btm.b(this.b);
            if (b == 2) {
                int n = this.a.n();
                Y(n);
                int d = this.a.d() + n;
                do {
                    list.add(Integer.valueOf(this.a.g()));
                } while (this.a.d() < d);
                return;
            }
            if (b != 5) {
                throw bqw.a();
            }
            do {
                list.add(Integer.valueOf(this.a.g()));
                if (this.a.C()) {
                    return;
                } else {
                    m = this.a.m();
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        bqo bqoVar = (bqo) list;
        int b2 = btm.b(this.b);
        if (b2 == 2) {
            int n2 = this.a.n();
            Y(n2);
            int d2 = this.a.d() + n2;
            do {
                bqoVar.g(this.a.g());
            } while (this.a.d() < d2);
            return;
        }
        if (b2 != 5) {
            throw bqw.a();
        }
        do {
            bqoVar.g(this.a.g());
            if (this.a.C()) {
                return;
            } else {
                m2 = this.a.m();
            }
        } while (m2 == this.b);
        this.d = m2;
    }

    public final void C(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bri)) {
            int b = btm.b(this.b);
            if (b == 1) {
                do {
                    list.add(Long.valueOf(this.a.o()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int n = this.a.n();
            Z(n);
            int d = this.a.d() + n;
            do {
                list.add(Long.valueOf(this.a.o()));
            } while (this.a.d() < d);
            return;
        }
        bri briVar = (bri) list;
        int b2 = btm.b(this.b);
        if (b2 == 1) {
            do {
                briVar.f(this.a.o());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int n2 = this.a.n();
        Z(n2);
        int d2 = this.a.d() + n2;
        do {
            briVar.f(this.a.o());
        } while (this.a.d() < d2);
    }

    public final void D(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqh)) {
            int b = btm.b(this.b);
            if (b == 2) {
                int n = this.a.n();
                Y(n);
                int d = this.a.d() + n;
                do {
                    list.add(Float.valueOf(this.a.c()));
                } while (this.a.d() < d);
                return;
            }
            if (b != 5) {
                throw bqw.a();
            }
            do {
                list.add(Float.valueOf(this.a.c()));
                if (this.a.C()) {
                    return;
                } else {
                    m = this.a.m();
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        bqh bqhVar = (bqh) list;
        int b2 = btm.b(this.b);
        if (b2 == 2) {
            int n2 = this.a.n();
            Y(n2);
            int d2 = this.a.d() + n2;
            do {
                bqhVar.e(this.a.c());
            } while (this.a.d() < d2);
            return;
        }
        if (b2 != 5) {
            throw bqw.a();
        }
        do {
            bqhVar.e(this.a.c());
            if (this.a.C()) {
                return;
            } else {
                m2 = this.a.m();
            }
        } while (m2 == this.b);
        this.d = m2;
    }

    @Deprecated
    public final void E(List list, bsi bsiVar, bqb bqbVar) throws IOException {
        int m;
        int i = this.b;
        if (btm.b(i) != 3) {
            throw bqw.a();
        }
        do {
            list.add(S(bsiVar, bqbVar));
            if (this.a.C() || this.d != 0) {
                return;
            } else {
                m = this.a.m();
            }
        } while (m == i);
        this.d = m;
    }

    public final void F(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqo)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Integer.valueOf(this.a.h()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Integer.valueOf(this.a.h()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bqo bqoVar = (bqo) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                bqoVar.g(this.a.h());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            bqoVar.g(this.a.h());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void G(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bri)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Long.valueOf(this.a.p()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Long.valueOf(this.a.p()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bri briVar = (bri) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                briVar.f(this.a.p());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            briVar.f(this.a.p());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void H(List list, bsi bsiVar, bqb bqbVar) throws IOException {
        int m;
        int i = this.b;
        if (btm.b(i) != 2) {
            throw bqw.a();
        }
        do {
            list.add(T(bsiVar, bqbVar));
            if (this.a.C() || this.d != 0) {
                return;
            } else {
                m = this.a.m();
            }
        } while (m == i);
        this.d = m;
    }

    public final void I(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqo)) {
            int b = btm.b(this.b);
            if (b == 2) {
                int n = this.a.n();
                Y(n);
                int d = this.a.d() + n;
                do {
                    list.add(Integer.valueOf(this.a.k()));
                } while (this.a.d() < d);
                return;
            }
            if (b != 5) {
                throw bqw.a();
            }
            do {
                list.add(Integer.valueOf(this.a.k()));
                if (this.a.C()) {
                    return;
                } else {
                    m = this.a.m();
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        bqo bqoVar = (bqo) list;
        int b2 = btm.b(this.b);
        if (b2 == 2) {
            int n2 = this.a.n();
            Y(n2);
            int d2 = this.a.d() + n2;
            do {
                bqoVar.g(this.a.k());
            } while (this.a.d() < d2);
            return;
        }
        if (b2 != 5) {
            throw bqw.a();
        }
        do {
            bqoVar.g(this.a.k());
            if (this.a.C()) {
                return;
            } else {
                m2 = this.a.m();
            }
        } while (m2 == this.b);
        this.d = m2;
    }

    public final void J(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bri)) {
            int b = btm.b(this.b);
            if (b == 1) {
                do {
                    list.add(Long.valueOf(this.a.t()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int n = this.a.n();
            Z(n);
            int d = this.a.d() + n;
            do {
                list.add(Long.valueOf(this.a.t()));
            } while (this.a.d() < d);
            return;
        }
        bri briVar = (bri) list;
        int b2 = btm.b(this.b);
        if (b2 == 1) {
            do {
                briVar.f(this.a.t());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int n2 = this.a.n();
        Z(n2);
        int d2 = this.a.d() + n2;
        do {
            briVar.f(this.a.t());
        } while (this.a.d() < d2);
    }

    public final void K(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqo)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Integer.valueOf(this.a.l()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Integer.valueOf(this.a.l()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bqo bqoVar = (bqo) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                bqoVar.g(this.a.l());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            bqoVar.g(this.a.l());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void L(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bri)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Long.valueOf(this.a.u()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Long.valueOf(this.a.u()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bri briVar = (bri) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                briVar.f(this.a.u());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            briVar.f(this.a.u());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void M(List list, boolean z) throws IOException {
        int m;
        int m2;
        if (btm.b(this.b) != 2) {
            throw bqw.a();
        }
        if (!(list instanceof bre) || z) {
            do {
                list.add(z ? u() : t());
                if (this.a.C()) {
                    return;
                } else {
                    m = this.a.m();
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        bre breVar = (bre) list;
        do {
            breVar.i(p());
            if (this.a.C()) {
                return;
            } else {
                m2 = this.a.m();
            }
        } while (m2 == this.b);
        this.d = m2;
    }

    public final void N(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bqo)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Integer.valueOf(this.a.n()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Integer.valueOf(this.a.n()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bqo bqoVar = (bqo) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                bqoVar.g(this.a.n());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            bqoVar.g(this.a.n());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void O(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bri)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Long.valueOf(this.a.v()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Long.valueOf(this.a.v()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bri briVar = (bri) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                briVar.f(this.a.v());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            briVar.f(this.a.v());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final boolean P() throws IOException {
        X(0);
        return this.a.D();
    }

    public final boolean Q() throws IOException {
        int i;
        if (this.a.C() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.E(i);
    }

    public final void R(Map map, brm brmVar) throws IOException {
        X(2);
        int e = this.a.e(this.a.n());
        Object obj = brmVar.b;
        while (true) {
            try {
                int c = c();
                if (c == Integer.MAX_VALUE || this.a.C()) {
                    break;
                }
                if (c == 1) {
                    int i = bph.b;
                    throw null;
                }
                if (c == 2) {
                    throw null;
                }
                try {
                } catch (bqv unused) {
                    if (!Q()) {
                        throw new bqw("Unable to parse map entry.");
                    }
                }
                if (!Q()) {
                    throw new bqw("Unable to parse map entry.");
                }
            } catch (Throwable th) {
                this.a.A(e);
                throw th;
            }
        }
        map.put((Object) null, (Object) null);
        this.a.A(e);
    }

    public final double a() throws IOException {
        X(1);
        return this.a.b();
    }

    public final float b() throws IOException {
        X(5);
        return this.a.c();
    }

    public final int c() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            i = this.a.m();
            this.b = i;
        }
        if (i == 0 || i == this.c) {
            return Integer.MAX_VALUE;
        }
        return btm.a(i);
    }

    public final int d() {
        return this.b;
    }

    public final int e() throws IOException {
        X(0);
        return this.a.f();
    }

    public final int f() throws IOException {
        X(5);
        return this.a.g();
    }

    public final int g() throws IOException {
        X(0);
        return this.a.h();
    }

    public final int h() throws IOException {
        X(5);
        return this.a.k();
    }

    public final int i() throws IOException {
        X(0);
        return this.a.l();
    }

    public final int j() throws IOException {
        X(0);
        return this.a.n();
    }

    public final long k() throws IOException {
        X(1);
        return this.a.o();
    }

    public final long l() throws IOException {
        X(0);
        return this.a.p();
    }

    public final long m() throws IOException {
        X(1);
        return this.a.t();
    }

    public final long n() throws IOException {
        X(0);
        return this.a.u();
    }

    public final long o() throws IOException {
        X(0);
        return this.a.v();
    }

    public final bpb p() throws IOException {
        X(2);
        return this.a.w();
    }

    @Deprecated
    public final Object r(Class cls, bqb bqbVar) throws IOException {
        X(3);
        return S(bsa.a().b(cls), bqbVar);
    }

    public final Object s(Class cls, bqb bqbVar) throws IOException {
        X(2);
        return T(bsa.a().b(cls), bqbVar);
    }

    public final String t() throws IOException {
        X(2);
        return this.a.x();
    }

    public final String u() throws IOException {
        X(2);
        return this.a.y();
    }

    public final void v(Object obj, bsi bsiVar, bqb bqbVar) throws IOException {
        X(3);
        U(obj, bsiVar, bqbVar);
    }

    public final void w(Object obj, bsi bsiVar, bqb bqbVar) throws IOException {
        X(2);
        V(obj, bsiVar, bqbVar);
    }

    public final void x(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bos)) {
            int b = btm.b(this.b);
            if (b == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.D()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int d = this.a.d() + this.a.n();
            do {
                list.add(Boolean.valueOf(this.a.D()));
            } while (this.a.d() < d);
            W(d);
            return;
        }
        bos bosVar = (bos) list;
        int b2 = btm.b(this.b);
        if (b2 == 0) {
            do {
                bosVar.e(this.a.D());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int d2 = this.a.d() + this.a.n();
        do {
            bosVar.e(this.a.D());
        } while (this.a.d() < d2);
        W(d2);
    }

    public final void y(List list) throws IOException {
        int m;
        if (btm.b(this.b) != 2) {
            throw bqw.a();
        }
        do {
            list.add(p());
            if (this.a.C()) {
                return;
            } else {
                m = this.a.m();
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void z(List list) throws IOException {
        int m;
        int m2;
        if (!(list instanceof bpy)) {
            int b = btm.b(this.b);
            if (b == 1) {
                do {
                    list.add(Double.valueOf(this.a.b()));
                    if (this.a.C()) {
                        return;
                    } else {
                        m = this.a.m();
                    }
                } while (m == this.b);
                this.d = m;
                return;
            }
            if (b != 2) {
                throw bqw.a();
            }
            int n = this.a.n();
            Z(n);
            int d = this.a.d() + n;
            do {
                list.add(Double.valueOf(this.a.b()));
            } while (this.a.d() < d);
            return;
        }
        bpy bpyVar = (bpy) list;
        int b2 = btm.b(this.b);
        if (b2 == 1) {
            do {
                bpyVar.e(this.a.b());
                if (this.a.C()) {
                    return;
                } else {
                    m2 = this.a.m();
                }
            } while (m2 == this.b);
            this.d = m2;
            return;
        }
        if (b2 != 2) {
            throw bqw.a();
        }
        int n2 = this.a.n();
        Z(n2);
        int d2 = this.a.d() + n2;
        do {
            bpyVar.e(this.a.b());
        } while (this.a.d() < d2);
    }
}
