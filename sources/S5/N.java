package s5;

import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class n extends AbstractMap implements Serializable {
    public static final Object k = new Object();
    public transient Object a;
    public transient int[] c;
    public transient Object[] d;
    public transient Object[] e;
    public transient int f;
    public transient int g;
    public transient Set h;
    public transient Set i;
    public transient Collection j;

    public class a extends e {
        public a() {
            super(n.this, null);
        }

        public Object c(int i) {
            return n.c(n.this, i);
        }
    }

    public class b extends e {
        public b() {
            super(n.this, null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry c(int i) {
            return n.this.new g(i);
        }
    }

    public class c extends e {
        public c() {
            super(n.this, null);
        }

        public Object c(int i) {
            return n.k(n.this, i);
        }
    }

    public class d extends AbstractSet {
        public d() {
        }

        public void clear() {
            n.this.clear();
        }

        public boolean contains(Object obj) {
            Map z = n.this.z();
            if (z != null) {
                return z.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int j = n.j(n.this, entry.getKey());
            return j != -1 && r5.j.a(n.k(n.this, j), entry.getValue());
        }

        public Iterator iterator() {
            return n.this.B();
        }

        public boolean remove(Object obj) {
            Map z = n.this.z();
            if (z != null) {
                return z.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (n.this.M()) {
                return false;
            }
            int m = n.m(n.this);
            int f = o.f(entry.getKey(), entry.getValue(), m, n.n(n.this), n.o(n.this), n.d(n.this), n.e(n.this));
            if (f == -1) {
                return false;
            }
            n.this.L(f, m);
            n.f(n.this);
            n.this.F();
            return true;
        }

        public int size() {
            return n.this.size();
        }
    }

    public abstract class e implements Iterator {
        public int a;
        public int c;
        public int d;

        public e() {
            this.a = n.a(n.this);
            this.c = n.this.C();
            this.d = -1;
        }

        public final void b() {
            if (n.a(n.this) != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object c(int i);

        public void d() {
            this.a += 32;
        }

        public boolean hasNext() {
            return this.c >= 0;
        }

        public Object next() {
            b();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.c;
            this.d = i;
            Object c = c(i);
            this.c = n.this.D(this.c);
            return c;
        }

        public void remove() {
            b();
            l.c(this.d >= 0);
            d();
            n nVar = n.this;
            nVar.remove(n.c(nVar, this.d));
            this.c = n.this.q(this.c, this.d);
            this.d = -1;
        }

        public /* synthetic */ e(n nVar, a aVar) {
            this();
        }
    }

    public class f extends AbstractSet {
        public f() {
        }

        public void clear() {
            n.this.clear();
        }

        public boolean contains(Object obj) {
            return n.this.containsKey(obj);
        }

        public Iterator iterator() {
            return n.this.K();
        }

        public boolean remove(Object obj) {
            Map z = n.this.z();
            return z != null ? z.keySet().remove(obj) : n.h(n.this, obj) != n.i();
        }

        public int size() {
            return n.this.size();
        }
    }

    public final class g extends s5.e {
        public final Object a;
        public int c;

        public g(int i) {
            this.a = n.c(n.this, i);
            this.c = i;
        }

        public final void a() {
            int i = this.c;
            if (i == -1 || i >= n.this.size() || !r5.j.a(this.a, n.c(n.this, this.c))) {
                this.c = n.j(n.this, this.a);
            }
        }

        public Object getKey() {
            return this.a;
        }

        public Object getValue() {
            Map z = n.this.z();
            if (z != null) {
                return O.a(z.get(this.a));
            }
            a();
            int i = this.c;
            return i == -1 ? O.b() : n.k(n.this, i);
        }

        public Object setValue(Object obj) {
            Map z = n.this.z();
            if (z != null) {
                return O.a(z.put(this.a, obj));
            }
            a();
            int i = this.c;
            if (i == -1) {
                n.this.put(this.a, obj);
                return O.b();
            }
            Object k = n.k(n.this, i);
            n.g(n.this, this.c, obj);
            return k;
        }
    }

    public class h extends AbstractCollection {
        public h() {
        }

        public void clear() {
            n.this.clear();
        }

        public Iterator iterator() {
            return n.this.a0();
        }

        public int size() {
            return n.this.size();
        }
    }

    public n() {
        H(3);
    }

    public static /* synthetic */ int a(n nVar) {
        return nVar.f;
    }

    public static /* synthetic */ Object c(n nVar, int i) {
        return nVar.J(i);
    }

    public static /* synthetic */ Object[] d(n nVar) {
        return nVar.P();
    }

    public static /* synthetic */ Object[] e(n nVar) {
        return nVar.R();
    }

    public static /* synthetic */ int f(n nVar) {
        int i = nVar.g;
        nVar.g = i - 1;
        return i;
    }

    public static /* synthetic */ void g(n nVar, int i, Object obj) {
        nVar.Y(i, obj);
    }

    public static /* synthetic */ Object h(n nVar, Object obj) {
        return nVar.N(obj);
    }

    public static /* synthetic */ Object i() {
        return k;
    }

    public static /* synthetic */ int j(n nVar, Object obj) {
        return nVar.G(obj);
    }

    public static /* synthetic */ Object k(n nVar, int i) {
        return nVar.Z(i);
    }

    public static /* synthetic */ int m(n nVar) {
        return nVar.E();
    }

    public static /* synthetic */ Object n(n nVar) {
        return nVar.Q();
    }

    public static /* synthetic */ int[] o(n nVar) {
        return nVar.O();
    }

    public static n t() {
        return new n();
    }

    public static n y(int i) {
        return new n(i);
    }

    public final int A(int i) {
        return O()[i];
    }

    public Iterator B() {
        Map z = z();
        return z != null ? z.entrySet().iterator() : new b();
    }

    public int C() {
        return isEmpty() ? -1 : 0;
    }

    public int D(int i) {
        int i2 = i + 1;
        if (i2 < this.g) {
            return i2;
        }
        return -1;
    }

    public final int E() {
        return (1 << (this.f & 31)) - 1;
    }

    public void F() {
        this.f += 32;
    }

    public final int G(Object obj) {
        if (M()) {
            return -1;
        }
        int c2 = v.c(obj);
        int E = E();
        int h2 = o.h(Q(), c2 & E);
        if (h2 == 0) {
            return -1;
        }
        int b2 = o.b(c2, E);
        do {
            int i = h2 - 1;
            int A = A(i);
            if (o.b(A, E) == b2 && r5.j.a(obj, J(i))) {
                return i;
            }
            h2 = o.c(A, E);
        } while (h2 != 0);
        return -1;
    }

    public void H(int i) {
        r5.m.e(i >= 0, "Expected size must be >= 0");
        this.f = w5.f.f(i, 1, 1073741823);
    }

    public void I(int i, Object obj, Object obj2, int i2, int i3) {
        V(i, o.d(i2, 0, i3));
        X(i, obj);
        Y(i, obj2);
    }

    public final Object J(int i) {
        return P()[i];
    }

    public Iterator K() {
        Map z = z();
        return z != null ? z.keySet().iterator() : new a();
    }

    public void L(int i, int i2) {
        Object Q = Q();
        int[] O = O();
        Object[] P = P();
        Object[] R = R();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            P[i] = null;
            R[i] = null;
            O[i] = 0;
            return;
        }
        Object obj = P[i3];
        P[i] = obj;
        R[i] = R[i3];
        P[i3] = null;
        R[i3] = null;
        O[i] = O[i3];
        O[i3] = 0;
        int c2 = v.c(obj) & i2;
        int h2 = o.h(Q, c2);
        if (h2 == size) {
            o.i(Q, c2, i + 1);
            return;
        }
        while (true) {
            int i4 = h2 - 1;
            int i5 = O[i4];
            int c3 = o.c(i5, i2);
            if (c3 == size) {
                O[i4] = o.d(i5, i + 1, i2);
                return;
            }
            h2 = c3;
        }
    }

    public boolean M() {
        return this.a == null;
    }

    public final Object N(Object obj) {
        if (M()) {
            return k;
        }
        int E = E();
        int f2 = o.f(obj, null, E, Q(), O(), P(), null);
        if (f2 == -1) {
            return k;
        }
        Object Z = Z(f2);
        L(f2, E);
        this.g--;
        F();
        return Z;
    }

    public final int[] O() {
        int[] iArr = this.c;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] P() {
        Object[] objArr = this.d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object Q() {
        Object obj = this.a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] R() {
        Object[] objArr = this.e;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void S(int i) {
        this.c = Arrays.copyOf(O(), i);
        this.d = Arrays.copyOf(P(), i);
        this.e = Arrays.copyOf(R(), i);
    }

    public final void T(int i) {
        int min;
        int length = O().length;
        if (i <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        S(min);
    }

    public final int U(int i, int i2, int i3, int i4) {
        Object a2 = o.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            o.i(a2, i3 & i5, i4 + 1);
        }
        Object Q = Q();
        int[] O = O();
        for (int i6 = 0; i6 <= i; i6++) {
            int h2 = o.h(Q, i6);
            while (h2 != 0) {
                int i7 = h2 - 1;
                int i8 = O[i7];
                int b2 = o.b(i8, i) | i6;
                int i9 = b2 & i5;
                int h3 = o.h(a2, i9);
                o.i(a2, i9, h2);
                O[i7] = o.d(b2, h3, i5);
                h2 = o.c(i8, i);
            }
        }
        this.a = a2;
        W(i5);
        return i5;
    }

    public final void V(int i, int i2) {
        O()[i] = i2;
    }

    public final void W(int i) {
        this.f = o.d(this.f, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public final void X(int i, Object obj) {
        P()[i] = obj;
    }

    public final void Y(int i, Object obj) {
        R()[i] = obj;
    }

    public final Object Z(int i) {
        return R()[i];
    }

    public Iterator a0() {
        Map z = z();
        return z != null ? z.values().iterator() : new c();
    }

    public void clear() {
        if (M()) {
            return;
        }
        F();
        Map z = z();
        if (z != null) {
            this.f = w5.f.f(size(), 3, 1073741823);
            z.clear();
            this.a = null;
        } else {
            Arrays.fill(P(), 0, this.g, (Object) null);
            Arrays.fill(R(), 0, this.g, (Object) null);
            o.g(Q());
            Arrays.fill(O(), 0, this.g, 0);
        }
        this.g = 0;
    }

    public boolean containsKey(Object obj) {
        Map z = z();
        return z != null ? z.containsKey(obj) : G(obj) != -1;
    }

    public boolean containsValue(Object obj) {
        Map z = z();
        if (z != null) {
            return z.containsValue(obj);
        }
        for (int i = 0; i < this.g; i++) {
            if (r5.j.a(obj, Z(i))) {
                return true;
            }
        }
        return false;
    }

    public Set entrySet() {
        Set set = this.i;
        if (set != null) {
            return set;
        }
        Set u = u();
        this.i = u;
        return u;
    }

    public Object get(Object obj) {
        Map z = z();
        if (z != null) {
            return z.get(obj);
        }
        int G = G(obj);
        if (G == -1) {
            return null;
        }
        p(G);
        return Z(G);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set keySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        Set w = w();
        this.h = w;
        return w;
    }

    public Object put(Object obj, Object obj2) {
        int i;
        if (M()) {
            r();
        }
        Map z = z();
        if (z != null) {
            return z.put(obj, obj2);
        }
        int[] O = O();
        Object[] P = P();
        Object[] R = R();
        int i2 = this.g;
        int i3 = i2 + 1;
        int c2 = v.c(obj);
        int E = E();
        int i4 = c2 & E;
        int h2 = o.h(Q(), i4);
        if (h2 == 0) {
            if (i3 <= E) {
                o.i(Q(), i4, i3);
                i = E;
            }
            i = U(E, o.e(E), c2, i2);
        } else {
            int b2 = o.b(c2, E);
            int i5 = 0;
            while (true) {
                int i6 = h2 - 1;
                int i7 = O[i6];
                if (o.b(i7, E) == b2 && r5.j.a(obj, P[i6])) {
                    Object obj3 = R[i6];
                    R[i6] = obj2;
                    p(i6);
                    return obj3;
                }
                int c3 = o.c(i7, E);
                i5++;
                if (c3 != 0) {
                    h2 = c3;
                } else {
                    if (i5 >= 9) {
                        return s().put(obj, obj2);
                    }
                    if (i3 <= E) {
                        O[i6] = o.d(i7, i3, E);
                    }
                }
            }
        }
        T(i3);
        I(i2, obj, obj2, c2, i);
        this.g = i3;
        F();
        return null;
    }

    public int q(int i, int i2) {
        return i - 1;
    }

    public int r() {
        r5.m.q(M(), "Arrays already allocated");
        int i = this.f;
        int j = o.j(i);
        this.a = o.a(j);
        W(j - 1);
        this.c = new int[i];
        this.d = new Object[i];
        this.e = new Object[i];
        return i;
    }

    public Object remove(Object obj) {
        Map z = z();
        if (z != null) {
            return z.remove(obj);
        }
        Object N = N(obj);
        if (N == k) {
            return null;
        }
        return N;
    }

    public Map s() {
        Map v = v(E() + 1);
        int C = C();
        while (C >= 0) {
            v.put(J(C), Z(C));
            C = D(C);
        }
        this.a = v;
        this.c = null;
        this.d = null;
        this.e = null;
        F();
        return v;
    }

    public int size() {
        Map z = z();
        return z != null ? z.size() : this.g;
    }

    public Set u() {
        return new d();
    }

    public Map v(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public Collection values() {
        Collection collection = this.j;
        if (collection != null) {
            return collection;
        }
        Collection x = x();
        this.j = x;
        return x;
    }

    public Set w() {
        return new f();
    }

    public Collection x() {
        return new h();
    }

    public Map z() {
        Object obj = this.a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public n(int i) {
        H(i);
    }

    public void p(int i) {
    }
}
