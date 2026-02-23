package H3;

import B3.J;
import B3.X;
import B3.Y;
import B3.Z;
import B3.g0;
import B3.i0;
import B3.x;
import H3.f;
import O2.A0;
import O2.H1;
import O2.l1;
import O2.z0;
import V2.w;
import V2.y;
import Z3.A;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import b4.C;
import b4.F;
import b4.G;
import d3.v;
import d3.w;
import d4.B;
import d4.M;
import d4.k0;
import j$.util.Objects;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q3.a;
import s5.D;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements G.b, G.f, Z, d3.k, X.d {
    public static final Set Z = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    public w A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public z0 G;
    public z0 H;
    public boolean I;
    public i0 J;
    public Set K;
    public int[] L;
    public int M;
    public boolean N;
    public boolean[] O;
    public boolean[] P;
    public long Q;
    public long R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long W;
    public V2.m X;
    public j Y;
    public final String a;
    public final int c;
    public final b d;
    public final f e;
    public final b4.b f;
    public final z0 g;
    public final y h;
    public final w.a i;
    public final F j;
    public final J.a l;
    public final int m;
    public final ArrayList o;
    public final List p;
    public final Runnable q;
    public final Runnable r;
    public final Handler s;
    public final ArrayList t;
    public final Map u;
    public D3.f v;
    public d[] w;
    public Set y;
    public SparseIntArray z;
    public final G k = new G("Loader:HlsSampleStreamWrapper");
    public final f.b n = new f.b();
    public int[] x = new int[0];

    public interface b extends Z.a {
        void n(Uri uri);

        void onPrepared();
    }

    public static class c implements d3.w {
        public static final z0 g = new z0.b().g0("application/id3").G();
        public static final z0 h = new z0.b().g0("application/x-emsg").G();
        public final s3.b a = new s3.b();
        public final d3.w b;
        public final z0 c;
        public z0 d;
        public byte[] e;
        public int f;

        public c(d3.w wVar, int i) {
            z0 z0Var;
            this.b = wVar;
            if (i == 1) {
                z0Var = g;
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i);
                }
                z0Var = h;
            }
            this.c = z0Var;
            this.e = new byte[0];
            this.f = 0;
        }

        public /* synthetic */ int a(b4.k kVar, int i, boolean z) {
            return v.a(this, kVar, i, z);
        }

        public /* synthetic */ void b(M m, int i) {
            v.b(this, m, i);
        }

        public void c(M m, int i, int i2) {
            h(this.f + i);
            m.l(this.e, this.f, i);
            this.f += i;
        }

        public void d(z0 z0Var) {
            this.d = z0Var;
            this.b.d(this.c);
        }

        public int e(b4.k kVar, int i, boolean z, int i2) {
            h(this.f + i);
            int read = kVar.read(this.e, this.f, i);
            if (read != -1) {
                this.f += read;
                return read;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }

        public void f(long j, int i, int i2, int i3, w.a aVar) {
            d4.a.e(this.d);
            M i4 = i(i2, i3);
            if (!k0.c(this.d.m, this.c.m)) {
                if (!"application/x-emsg".equals(this.d.m)) {
                    B.j("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.d.m);
                    return;
                }
                s3.a c = this.a.c(i4);
                if (!g(c)) {
                    B.j("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.c.m, c.getWrappedMetadataFormat()}));
                    return;
                }
                i4 = new M((byte[]) d4.a.e(c.getWrappedMetadataBytes()));
            }
            int a = i4.a();
            this.b.b(i4, a);
            this.b.f(j, i, a, i3, aVar);
        }

        public final boolean g(s3.a aVar) {
            z0 wrappedMetadataFormat = aVar.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && k0.c(this.c.m, wrappedMetadataFormat.m);
        }

        public final void h(int i) {
            byte[] bArr = this.e;
            if (bArr.length < i) {
                this.e = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        public final M i(int i, int i2) {
            int i3 = this.f - i2;
            M m = new M(Arrays.copyOfRange(this.e, i3 - i, i3));
            byte[] bArr = this.e;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.f = i2;
            return m;
        }
    }

    public static final class d extends X {
        public final Map H;
        public V2.m I;

        public d(b4.b bVar, y yVar, w.a aVar, Map map) {
            super(bVar, yVar, aVar);
            this.H = map;
        }

        public void f(long j, int i, int i2, int i3, w.a aVar) {
            super.f(j, i, i2, i3, aVar);
        }

        public final q3.a h0(q3.a aVar) {
            if (aVar == null) {
                return null;
            }
            int f = aVar.f();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= f) {
                    i2 = -1;
                    break;
                }
                a.b e = aVar.e(i2);
                if ((e instanceof v3.l) && "com.apple.streaming.transportStreamTimestamp".equals(((v3.l) e).c)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return aVar;
            }
            if (f == 1) {
                return null;
            }
            a.b[] bVarArr = new a.b[f - 1];
            while (i < f) {
                if (i != i2) {
                    bVarArr[i < i2 ? i : i - 1] = aVar.e(i);
                }
                i++;
            }
            return new q3.a(bVarArr);
        }

        public void i0(V2.m mVar) {
            this.I = mVar;
            I();
        }

        public void j0(j jVar) {
            f0(jVar.l);
        }

        public z0 w(z0 z0Var) {
            V2.m mVar;
            V2.m mVar2 = this.I;
            if (mVar2 == null) {
                mVar2 = z0Var.p;
            }
            if (mVar2 != null && (mVar = (V2.m) this.H.get(mVar2.d)) != null) {
                mVar2 = mVar;
            }
            q3.a h0 = h0(z0Var.k);
            if (mVar2 != z0Var.p || h0 != z0Var.k) {
                z0Var = z0Var.b().O(mVar2).Z(h0).G();
            }
            return super.w(z0Var);
        }

        public /* synthetic */ d(b4.b bVar, y yVar, w.a aVar, Map map, a aVar2) {
            this(bVar, yVar, aVar, map);
        }
    }

    public q(String str, int i, b bVar, f fVar, Map map, b4.b bVar2, long j, z0 z0Var, y yVar, w.a aVar, F f, J.a aVar2, int i2) {
        this.a = str;
        this.c = i;
        this.d = bVar;
        this.e = fVar;
        this.u = map;
        this.f = bVar2;
        this.g = z0Var;
        this.h = yVar;
        this.i = aVar;
        this.j = f;
        this.l = aVar2;
        this.m = i2;
        Set set = Z;
        this.y = new HashSet(set.size());
        this.z = new SparseIntArray(set.size());
        this.w = new d[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        this.p = Collections.unmodifiableList(arrayList);
        this.t = new ArrayList();
        this.q = new o(this);
        this.r = new p(this);
        this.s = k0.x();
        this.Q = j;
        this.R = j;
    }

    public static d3.h C(int i, int i2) {
        B.j("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new d3.h();
    }

    public static z0 F(z0 z0Var, z0 z0Var2, boolean z) {
        String d2;
        String str;
        if (z0Var == null) {
            return z0Var2;
        }
        int k = d4.F.k(z0Var2.m);
        if (k0.M(z0Var.j, k) == 1) {
            d2 = k0.N(z0Var.j, k);
            str = d4.F.g(d2);
        } else {
            d2 = d4.F.d(z0Var.j, z0Var2.m);
            str = z0Var2.m;
        }
        z0.b K = z0Var2.b().U(z0Var.a).W(z0Var.c).X(z0Var.d).i0(z0Var.e).e0(z0Var.f).I(z ? z0Var.g : -1).b0(z ? z0Var.h : -1).K(d2);
        if (k == 2) {
            K.n0(z0Var.r).S(z0Var.s).R(z0Var.t);
        }
        if (str != null) {
            K.g0(str);
        }
        int i = z0Var.z;
        if (i != -1 && k == 1) {
            K.J(i);
        }
        q3.a aVar = z0Var.k;
        if (aVar != null) {
            q3.a aVar2 = z0Var2.k;
            if (aVar2 != null) {
                aVar = aVar2.c(aVar);
            }
            K.Z(aVar);
        }
        return K.G();
    }

    private void G(int i) {
        d4.a.g(!this.k.j());
        while (true) {
            if (i >= this.o.size()) {
                i = -1;
                break;
            } else if (A(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = K().i;
        j H = H(i);
        if (this.o.isEmpty()) {
            this.R = this.Q;
        } else {
            ((j) D.d(this.o)).o();
        }
        this.U = false;
        this.l.C(this.B, H.h, j);
    }

    public static boolean J(z0 z0Var, z0 z0Var2) {
        String str = z0Var.m;
        String str2 = z0Var2.m;
        int k = d4.F.k(str);
        if (k != 3) {
            return k == d4.F.k(str2);
        }
        if (k0.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || z0Var.E == z0Var2.E;
        }
        return false;
    }

    public static int N(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    private static boolean P(D3.f fVar) {
        return fVar instanceof j;
    }

    private boolean Q() {
        return this.R != -9223372036854775807L;
    }

    private void U() {
        if (!this.I && this.L == null && this.D) {
            for (d dVar : this.w) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.J != null) {
                T();
                return;
            }
            z();
            n0();
            this.d.onPrepared();
        }
    }

    public static /* synthetic */ void a(q qVar) {
        qVar.e0();
    }

    private void i0() {
        for (d dVar : this.w) {
            dVar.W(this.S);
        }
        this.S = false;
    }

    private boolean j0(long j) {
        int length = this.w.length;
        for (int i = 0; i < length; i++) {
            if (!this.w[i].Z(j, false) && (this.P[i] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void w(q qVar) {
        qVar.U();
    }

    public final boolean A(int i) {
        for (int i2 = i; i2 < this.o.size(); i2++) {
            if (((j) this.o.get(i2)).o) {
                return false;
            }
        }
        j jVar = (j) this.o.get(i);
        for (int i3 = 0; i3 < this.w.length; i3++) {
            if (this.w[i3].C() > jVar.m(i3)) {
                return false;
            }
        }
        return true;
    }

    public void B() {
        if (this.E) {
            return;
        }
        f(this.Q);
    }

    public final X D(int i, int i2) {
        int length = this.w.length;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        d dVar = new d(this.f, this.h, this.i, this.u, null);
        dVar.b0(this.Q);
        if (z) {
            dVar.i0(this.X);
        }
        dVar.a0(this.W);
        j jVar = this.Y;
        if (jVar != null) {
            dVar.j0(jVar);
        }
        dVar.d0(this);
        int i3 = length + 1;
        int[] copyOf = Arrays.copyOf(this.x, i3);
        this.x = copyOf;
        copyOf[length] = i;
        this.w = (d[]) k0.S0(this.w, dVar);
        boolean[] copyOf2 = Arrays.copyOf(this.P, i3);
        this.P = copyOf2;
        copyOf2[length] = z;
        this.N |= z;
        this.y.add(Integer.valueOf(i2));
        this.z.append(i2, length);
        if (N(i2) > N(this.B)) {
            this.C = length;
            this.B = i2;
        }
        this.O = Arrays.copyOf(this.O, i3);
        return dVar;
    }

    public final i0 E(g0[] g0VarArr) {
        for (int i = 0; i < g0VarArr.length; i++) {
            g0 g0Var = g0VarArr[i];
            z0[] z0VarArr = new z0[g0Var.a];
            for (int i2 = 0; i2 < g0Var.a; i2++) {
                z0 c2 = g0Var.c(i2);
                z0VarArr[i2] = c2.c(this.h.a(c2));
            }
            g0VarArr[i] = new g0(g0Var.c, z0VarArr);
        }
        return new i0(g0VarArr);
    }

    public final j H(int i) {
        j jVar = (j) this.o.get(i);
        ArrayList arrayList = this.o;
        k0.a1(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.w.length; i2++) {
            this.w[i2].u(jVar.m(i2));
        }
        return jVar;
    }

    public final boolean I(j jVar) {
        int i = jVar.l;
        int length = this.w.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.O[i2] && this.w[i2].Q() == i) {
                return false;
            }
        }
        return true;
    }

    public final j K() {
        return (j) this.o.get(r0.size() - 1);
    }

    public final d3.w L(int i, int i2) {
        d4.a.a(Z.contains(Integer.valueOf(i2)));
        int i3 = this.z.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.y.add(Integer.valueOf(i2))) {
            this.x[i3] = i;
        }
        return this.x[i3] == i ? this.w[i3] : C(i, i2);
    }

    public int M() {
        return this.M;
    }

    public final void O(j jVar) {
        this.Y = jVar;
        this.G = jVar.e;
        this.R = -9223372036854775807L;
        this.o.add(jVar);
        y.a p = s5.y.p();
        for (d dVar : this.w) {
            p.h(Integer.valueOf(dVar.G()));
        }
        jVar.n(this, p.k());
        for (d dVar2 : this.w) {
            dVar2.j0(jVar);
            if (jVar.o) {
                dVar2.g0();
            }
        }
    }

    public boolean R(int i) {
        return !Q() && this.w[i].K(this.U);
    }

    public boolean S() {
        return this.B == 2;
    }

    public final void T() {
        int i = this.J.a;
        int[] iArr = new int[i];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                d[] dVarArr = this.w;
                if (i3 >= dVarArr.length) {
                    break;
                }
                if (J((z0) d4.a.i(dVarArr[i3].F()), this.J.b(i2).c(0))) {
                    this.L[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            ((m) it.next()).b();
        }
    }

    public void V() {
        this.k.a();
        this.e.n();
    }

    public void X(int i) {
        V();
        this.w[i].N();
    }

    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void t(D3.f fVar, long j, long j2, boolean z) {
        this.v = null;
        B3.u uVar = new B3.u(fVar.a, fVar.c, fVar.f(), fVar.e(), j, j2, fVar.b());
        this.j.d(fVar.a);
        this.l.q(uVar, fVar.d, this.c, fVar.e, fVar.f, fVar.g, fVar.h, fVar.i);
        if (z) {
            return;
        }
        if (Q() || this.F == 0) {
            i0();
        }
        if (this.F > 0) {
            this.d.j(this);
        }
    }

    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void W(D3.f fVar, long j, long j2) {
        this.v = null;
        this.e.p(fVar);
        B3.u uVar = new B3.u(fVar.a, fVar.c, fVar.f(), fVar.e(), j, j2, fVar.b());
        this.j.d(fVar.a);
        this.l.t(uVar, fVar.d, this.c, fVar.e, fVar.f, fVar.g, fVar.h, fVar.i);
        if (this.E) {
            this.d.j(this);
        } else {
            f(this.Q);
        }
    }

    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public G.c j(D3.f fVar, long j, long j2, IOException iOException, int i) {
        G.c h;
        int i2;
        boolean P = P(fVar);
        if (P && !((j) fVar).q() && (iOException instanceof C.e) && ((i2 = ((C.e) iOException).e) == 410 || i2 == 404)) {
            return G.d;
        }
        long b2 = fVar.b();
        B3.u uVar = new B3.u(fVar.a, fVar.c, fVar.f(), fVar.e(), j, j2, b2);
        F.c cVar = new F.c(uVar, new x(fVar.d, this.c, fVar.e, fVar.f, fVar.g, k0.x1(fVar.h), k0.x1(fVar.i)), iOException, i);
        F.b a2 = this.j.a(A.c(this.e.k()), cVar);
        boolean m = (a2 == null || a2.a != 2) ? false : this.e.m(fVar, a2.b);
        if (m) {
            if (P && b2 == 0) {
                ArrayList arrayList = this.o;
                d4.a.g(((j) arrayList.remove(arrayList.size() - 1)) == fVar);
                if (this.o.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((j) D.d(this.o)).o();
                }
            }
            h = G.f;
        } else {
            long c2 = this.j.c(cVar);
            h = c2 != -9223372036854775807L ? G.h(false, c2) : G.g;
        }
        G.c cVar2 = h;
        boolean z = !cVar2.c();
        this.l.v(uVar, fVar.d, this.c, fVar.e, fVar.f, fVar.g, fVar.h, fVar.i, iOException, z);
        if (z) {
            this.v = null;
            this.j.d(fVar.a);
        }
        if (m) {
            if (this.E) {
                this.d.j(this);
            } else {
                f(this.Q);
            }
        }
        return cVar2;
    }

    public boolean b() {
        return this.k.j();
    }

    public void b0() {
        this.y.clear();
    }

    public long c() {
        if (Q()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return K().i;
    }

    public boolean c0(Uri uri, F.c cVar, boolean z) {
        F.b a2;
        if (!this.e.o(uri)) {
            return true;
        }
        long j = (z || (a2 = this.j.a(A.c(this.e.k()), cVar)) == null || a2.a != 2) ? -9223372036854775807L : a2.b;
        return this.e.q(uri, j) && j != -9223372036854775807L;
    }

    public long d(long j, H1 h1) {
        return this.e.b(j, h1);
    }

    public void d0() {
        if (this.o.isEmpty()) {
            return;
        }
        j jVar = (j) D.d(this.o);
        int c2 = this.e.c(jVar);
        if (c2 == 1) {
            jVar.v();
        } else if (c2 == 2 && !this.U && this.k.j()) {
            this.k.f();
        }
    }

    public d3.w e(int i, int i2) {
        d3.w wVar;
        if (!Z.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                d3.w[] wVarArr = this.w;
                if (i3 >= wVarArr.length) {
                    wVar = null;
                    break;
                }
                if (this.x[i3] == i) {
                    wVar = wVarArr[i3];
                    break;
                }
                i3++;
            }
        } else {
            wVar = L(i, i2);
        }
        if (wVar == null) {
            if (this.V) {
                return C(i, i2);
            }
            wVar = D(i, i2);
        }
        if (i2 != 5) {
            return wVar;
        }
        if (this.A == null) {
            this.A = new c(wVar, this.m);
        }
        return this.A;
    }

    public final void e0() {
        this.D = true;
        U();
    }

    public boolean f(long j) {
        List list;
        long max;
        if (this.U || this.k.j() || this.k.i()) {
            return false;
        }
        if (Q()) {
            list = Collections.emptyList();
            max = this.R;
            for (d dVar : this.w) {
                dVar.b0(this.R);
            }
        } else {
            list = this.p;
            j K = K();
            max = K.h() ? K.i : Math.max(this.Q, K.h);
        }
        List list2 = list;
        long j2 = max;
        this.n.a();
        this.e.e(j, j2, list2, this.E || !list2.isEmpty(), this.n);
        f.b bVar = this.n;
        boolean z = bVar.b;
        D3.f fVar = bVar.a;
        Uri uri = bVar.c;
        if (z) {
            this.R = -9223372036854775807L;
            this.U = true;
            return true;
        }
        if (fVar == null) {
            if (uri != null) {
                this.d.n(uri);
            }
            return false;
        }
        if (P(fVar)) {
            O((j) fVar);
        }
        this.v = fVar;
        this.l.z(new B3.u(fVar.a, fVar.c, this.k.n(fVar, this, this.j.b(fVar.d))), fVar.d, this.c, fVar.e, fVar.f, fVar.g, fVar.h, fVar.i);
        return true;
    }

    public void f0(g0[] g0VarArr, int i, int... iArr) {
        this.J = E(g0VarArr);
        this.K = new HashSet();
        for (int i2 : iArr) {
            this.K.add(this.J.b(i2));
        }
        this.M = i;
        Handler handler = this.s;
        b bVar = this.d;
        Objects.requireNonNull(bVar);
        handler.post(new n(bVar));
        n0();
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Attempt to invoke virtual method 'void jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)' on a null object reference
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(Unknown Source:89)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(Unknown Source:106)
        */
    public long g() {
        /*
            r7 = this;
            boolean r0 = r7.U
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.Q()
            if (r0 == 0) goto L10
            long r0 = r7.R
            return r0
        L10:
            long r0 = r7.Q
            H3.j r2 = r7.K()
            boolean r3 = r2.h()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList r2 = r7.o
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList r2 = r7.o
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            H3.j r2 = (H3.j) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.i
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.D
            if (r2 == 0) goto L55
            H3.q$d[] r2 = r7.w
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.z()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.q.g():long");
    }

    public int g0(int i, A0 a0, U2.g gVar, int i2) {
        if (Q()) {
            return -3;
        }
        int i3 = 0;
        if (!this.o.isEmpty()) {
            int i4 = 0;
            while (i4 < this.o.size() - 1 && I((j) this.o.get(i4))) {
                i4++;
            }
            k0.a1(this.o, 0, i4);
            j jVar = (j) this.o.get(0);
            z0 z0Var = jVar.e;
            if (!z0Var.equals(this.H)) {
                this.l.h(this.c, z0Var, jVar.f, jVar.g, jVar.h);
            }
            this.H = z0Var;
        }
        if (!this.o.isEmpty() && !((j) this.o.get(0)).q()) {
            return -3;
        }
        int S = this.w[i].S(a0, gVar, i2, this.U);
        if (S == -5) {
            z0 z0Var2 = (z0) d4.a.e(a0.b);
            if (i == this.C) {
                int d2 = w5.f.d(this.w[i].Q());
                while (i3 < this.o.size() && ((j) this.o.get(i3)).l != d2) {
                    i3++;
                }
                z0Var2 = z0Var2.l(i3 < this.o.size() ? ((j) this.o.get(i3)).e : (z0) d4.a.e(this.G));
            }
            a0.b = z0Var2;
        }
        return S;
    }

    public void h(long j) {
        if (this.k.i() || Q()) {
            return;
        }
        if (this.k.j()) {
            d4.a.e(this.v);
            if (this.e.v(j, this.v, this.p)) {
                this.k.f();
                return;
            }
            return;
        }
        int size = this.p.size();
        while (size > 0 && this.e.c((j) this.p.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.p.size()) {
            G(size);
        }
        int h = this.e.h(j, this.p);
        if (h < this.o.size()) {
            G(h);
        }
    }

    public void h0() {
        if (this.E) {
            for (d dVar : this.w) {
                dVar.R();
            }
        }
        this.k.m(this);
        this.s.removeCallbacksAndMessages((Object) null);
        this.I = true;
        this.t.clear();
    }

    public boolean k0(long j, boolean z) {
        this.Q = j;
        if (Q()) {
            this.R = j;
            return true;
        }
        if (this.D && !z && j0(j)) {
            return false;
        }
        this.R = j;
        this.U = false;
        this.o.clear();
        if (this.k.j()) {
            if (this.D) {
                for (d dVar : this.w) {
                    dVar.r();
                }
            }
            this.k.f();
        } else {
            this.k.g();
            i0();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean l0(Z3.s[] r20, boolean[] r21, B3.Y[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.q.l0(Z3.s[], boolean[], B3.Y[], boolean[], long, boolean):boolean");
    }

    public void m0(V2.m mVar) {
        if (k0.c(this.X, mVar)) {
            return;
        }
        this.X = mVar;
        int i = 0;
        while (true) {
            d[] dVarArr = this.w;
            if (i >= dVarArr.length) {
                return;
            }
            if (this.P[i]) {
                dVarArr[i].i0(mVar);
            }
            i++;
        }
    }

    public final void n0() {
        this.E = true;
    }

    public void o() {
        for (d dVar : this.w) {
            dVar.T();
        }
    }

    public void o0(boolean z) {
        this.e.t(z);
    }

    public void p() {
        V();
        if (this.U && !this.E) {
            throw l1.a("Loading finished before preparation is complete.", null);
        }
    }

    public void p0(long j) {
        if (this.W != j) {
            this.W = j;
            for (d dVar : this.w) {
                dVar.a0(j);
            }
        }
    }

    public void q() {
        this.V = true;
        this.s.post(this.r);
    }

    public int q0(int i, long j) {
        if (Q()) {
            return 0;
        }
        d dVar = this.w[i];
        int E = dVar.E(j, this.U);
        j jVar = (j) D.e(this.o, null);
        if (jVar != null && !jVar.q()) {
            E = Math.min(E, jVar.m(i) - dVar.C());
        }
        dVar.e0(E);
        return E;
    }

    public void r(z0 z0Var) {
        this.s.post(this.q);
    }

    public void r0(int i) {
        x();
        d4.a.e(this.L);
        int i2 = this.L[i];
        d4.a.g(this.O[i2]);
        this.O[i2] = false;
    }

    public final void s0(Y[] yArr) {
        this.t.clear();
        for (Y y : yArr) {
            if (y != null) {
                this.t.add((m) y);
            }
        }
    }

    public i0 u() {
        x();
        return this.J;
    }

    public void v(long j, boolean z) {
        if (!this.D || Q()) {
            return;
        }
        int length = this.w.length;
        for (int i = 0; i < length; i++) {
            this.w[i].q(j, z, this.O[i]);
        }
    }

    public final void x() {
        d4.a.g(this.E);
        d4.a.e(this.J);
        d4.a.e(this.K);
    }

    public int y(int i) {
        x();
        d4.a.e(this.L);
        int i2 = this.L[i];
        if (i2 == -1) {
            return this.K.contains(this.J.b(i)) ? -3 : -2;
        }
        boolean[] zArr = this.O;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public final void z() {
        z0 z0Var;
        int length = this.w.length;
        int i = 0;
        int i2 = -2;
        int i3 = -1;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = ((z0) d4.a.i(this.w[i].F())).m;
            int i4 = d4.F.s(str) ? 2 : d4.F.o(str) ? 1 : d4.F.r(str) ? 3 : -2;
            if (N(i4) > N(i2)) {
                i3 = i;
                i2 = i4;
            } else if (i4 == i2 && i3 != -1) {
                i3 = -1;
            }
            i++;
        }
        g0 j = this.e.j();
        int i5 = j.a;
        this.M = -1;
        this.L = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.L[i6] = i6;
        }
        g0[] g0VarArr = new g0[length];
        int i7 = 0;
        while (i7 < length) {
            z0 z0Var2 = (z0) d4.a.i(this.w[i7].F());
            if (i7 == i3) {
                z0[] z0VarArr = new z0[i5];
                for (int i8 = 0; i8 < i5; i8++) {
                    z0 c2 = j.c(i8);
                    if (i2 == 1 && (z0Var = this.g) != null) {
                        c2 = c2.l(z0Var);
                    }
                    z0VarArr[i8] = i5 == 1 ? z0Var2.l(c2) : F(c2, z0Var2, true);
                }
                g0VarArr[i7] = new g0(this.a, z0VarArr);
                this.M = i7;
            } else {
                z0 z0Var3 = (i2 == 2 && d4.F.o(z0Var2.m)) ? this.g : null;
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(":muxed:");
                sb.append(i7 < i3 ? i7 : i7 - 1);
                g0VarArr[i7] = new g0(sb.toString(), F(z0Var3, z0Var2, false));
            }
            i7++;
        }
        this.J = E(g0VarArr);
        d4.a.g(this.K == null);
        this.K = Collections.emptySet();
    }

    public void n(com.google.android.exoplayer2.extractor.g gVar) {
    }
}
