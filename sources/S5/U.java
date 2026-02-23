package s5;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import s5.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u extends AbstractMap implements j, Serializable {
    public transient Object[] a;
    public transient Object[] c;
    public transient int d;
    public transient int e;
    public transient int[] f;
    public transient int[] g;
    public transient int[] h;
    public transient int[] i;
    public transient int j;
    public transient int k;
    public transient int[] l;
    public transient int[] m;
    public transient Set n;
    public transient Set o;
    public transient Set p;
    public transient j q;

    public final class a extends s5.e {
        public final Object a;
        public int c;

        public a(int i) {
            this.a = O.a(u.this.a[i]);
            this.c = i;
        }

        public void a() {
            int i = this.c;
            if (i != -1) {
                u uVar = u.this;
                if (i <= uVar.d && r5.j.a(uVar.a[i], this.a)) {
                    return;
                }
            }
            this.c = u.this.p(this.a);
        }

        public Object getKey() {
            return this.a;
        }

        public Object getValue() {
            a();
            int i = this.c;
            return i == -1 ? O.b() : O.a(u.this.c[i]);
        }

        public Object setValue(Object obj) {
            a();
            int i = this.c;
            if (i == -1) {
                u.this.put(this.a, obj);
                return O.b();
            }
            Object a = O.a(u.this.c[i]);
            if (r5.j.a(a, obj)) {
                return obj;
            }
            u.d(u.this, this.c, obj, false);
            return a;
        }
    }

    public static final class b extends s5.e {
        public final u a;
        public final Object c;
        public int d;

        public b(u uVar, int i) {
            this.a = uVar;
            this.c = O.a(uVar.c[i]);
            this.d = i;
        }

        private void a() {
            int i = this.d;
            if (i != -1) {
                u uVar = this.a;
                if (i <= uVar.d && r5.j.a(this.c, uVar.c[i])) {
                    return;
                }
            }
            this.d = this.a.r(this.c);
        }

        public Object getKey() {
            return this.c;
        }

        public Object getValue() {
            a();
            int i = this.d;
            return i == -1 ? O.b() : O.a(this.a.a[i]);
        }

        public Object setValue(Object obj) {
            a();
            int i = this.d;
            if (i == -1) {
                this.a.z(this.c, obj, false);
                return O.b();
            }
            Object a = O.a(this.a.a[i]);
            if (r5.j.a(a, obj)) {
                return obj;
            }
            u.e(this.a, this.d, obj, false);
            return a;
        }
    }

    public final class c extends h {
        public c() {
            super(u.this);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i) {
            return u.this.new a(i);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int p = u.this.p(key);
            return p != -1 && r5.j.a(value, u.this.c[p]);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int c = v.c(key);
            int q = u.this.q(key, c);
            if (q == -1 || !r5.j.a(value, u.this.c[q])) {
                return false;
            }
            u.this.C(q, c);
            return true;
        }
    }

    public static class d extends AbstractMap implements j, Serializable {
        public final u a;
        public transient Set c;

        public d(u uVar) {
            this.a = uVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set values() {
            return this.a.keySet();
        }

        public Object b(Object obj, Object obj2) {
            return this.a.z(obj, obj2, true);
        }

        public void clear() {
            this.a.clear();
        }

        public boolean containsKey(Object obj) {
            return this.a.containsValue(obj);
        }

        public boolean containsValue(Object obj) {
            return this.a.containsKey(obj);
        }

        public Set entrySet() {
            Set set = this.c;
            if (set != null) {
                return set;
            }
            e eVar = new e(this.a);
            this.c = eVar;
            return eVar;
        }

        public Object get(Object obj) {
            return this.a.t(obj);
        }

        public Set keySet() {
            return this.a.values();
        }

        public j l() {
            return this.a;
        }

        public Object put(Object obj, Object obj2) {
            return this.a.z(obj, obj2, false);
        }

        public Object remove(Object obj) {
            return this.a.E(obj);
        }

        public int size() {
            return this.a.d;
        }
    }

    public static class e extends h {
        public e(u uVar) {
            super(uVar);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i) {
            return new b(this.a, i);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int r = this.a.r(key);
            return r != -1 && r5.j.a(this.a.a[r], value);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int c = v.c(key);
            int s = this.a.s(key, c);
            if (s == -1 || !r5.j.a(this.a.a[s], value)) {
                return false;
            }
            this.a.D(s, c);
            return true;
        }
    }

    public final class f extends h {
        public f() {
            super(u.this);
        }

        public Object a(int i) {
            return O.a(u.this.a[i]);
        }

        public boolean contains(Object obj) {
            return u.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            int c = v.c(obj);
            int q = u.this.q(obj, c);
            if (q == -1) {
                return false;
            }
            u.this.C(q, c);
            return true;
        }
    }

    public final class g extends h {
        public g() {
            super(u.this);
        }

        public Object a(int i) {
            return O.a(u.this.c[i]);
        }

        public boolean contains(Object obj) {
            return u.this.containsValue(obj);
        }

        public boolean remove(Object obj) {
            int c = v.c(obj);
            int s = u.this.s(obj, c);
            if (s == -1) {
                return false;
            }
            u.this.D(s, c);
            return true;
        }
    }

    public static abstract class h extends AbstractSet {
        public final u a;

        public class a implements Iterator {
            public int a;
            public int c = -1;
            public int d;
            public int e;

            public a() {
                this.a = u.a(h.this.a);
                u uVar = h.this.a;
                this.d = uVar.e;
                this.e = uVar.d;
            }

            public final void b() {
                if (h.this.a.e != this.d) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                b();
                return this.a != -2 && this.e > 0;
            }

            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object a = h.this.a(this.a);
                this.c = this.a;
                this.a = u.c(h.this.a)[this.a];
                this.e--;
                return a;
            }

            public void remove() {
                b();
                l.c(this.c != -1);
                h.this.a.A(this.c);
                int i = this.a;
                u uVar = h.this.a;
                if (i == uVar.d) {
                    this.a = this.c;
                }
                this.c = -1;
                this.d = uVar.e;
            }
        }

        public h(u uVar) {
            this.a = uVar;
        }

        public abstract Object a(int i);

        public void clear() {
            this.a.clear();
        }

        public Iterator iterator() {
            return new a();
        }

        public int size() {
            return this.a.d;
        }
    }

    public u(int i) {
        u(i);
    }

    public static /* synthetic */ int a(u uVar) {
        return uVar.j;
    }

    public static /* synthetic */ int[] c(u uVar) {
        return uVar.m;
    }

    public static /* synthetic */ void d(u uVar, int i, Object obj, boolean z) {
        uVar.G(i, obj, z);
    }

    public static /* synthetic */ void e(u uVar, int i, Object obj, boolean z) {
        uVar.F(i, obj, z);
    }

    public static u g() {
        return h(16);
    }

    public static u h(int i) {
        return new u(i);
    }

    public static int[] i(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static int[] n(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    public void A(int i) {
        C(i, v.c(this.a[i]));
    }

    public final void B(int i, int i2, int i3) {
        r5.m.d(i != -1);
        j(i, i2);
        k(i, i3);
        H(this.l[i], this.m[i]);
        x(this.d - 1, i);
        Object[] objArr = this.a;
        int i4 = this.d;
        objArr[i4 - 1] = null;
        this.c[i4 - 1] = null;
        this.d = i4 - 1;
        this.e++;
    }

    public void C(int i, int i2) {
        B(i, i2, v.c(this.c[i]));
    }

    public void D(int i, int i2) {
        B(i, v.c(this.a[i]), i2);
    }

    public Object E(Object obj) {
        int c2 = v.c(obj);
        int s = s(obj, c2);
        if (s == -1) {
            return null;
        }
        Object obj2 = this.a[s];
        D(s, c2);
        return obj2;
    }

    public final void F(int i, Object obj, boolean z) {
        int i2;
        r5.m.d(i != -1);
        int c2 = v.c(obj);
        int q = q(obj, c2);
        int i3 = this.k;
        if (q == -1) {
            i2 = -2;
        } else {
            if (!z) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 28);
                sb.append("Key already present in map: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
            i3 = this.l[q];
            i2 = this.m[q];
            C(q, c2);
            if (i == this.d) {
                i = q;
            }
        }
        if (i3 == i) {
            i3 = this.l[i];
        } else if (i3 == this.d) {
            i3 = q;
        }
        if (i2 == i) {
            q = this.m[i];
        } else if (i2 != this.d) {
            q = i2;
        }
        H(this.l[i], this.m[i]);
        j(i, v.c(this.a[i]));
        this.a[i] = obj;
        v(i, v.c(obj));
        H(i3, i);
        H(i, q);
    }

    public final void G(int i, Object obj, boolean z) {
        r5.m.d(i != -1);
        int c2 = v.c(obj);
        int s = s(obj, c2);
        if (s != -1) {
            if (!z) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                sb.append("Value already present in map: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
            D(s, c2);
            if (i == this.d) {
                i = s;
            }
        }
        k(i, v.c(this.c[i]));
        this.c[i] = obj;
        w(i, c2);
    }

    public final void H(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            this.m[i] = i2;
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            this.l[i2] = i;
        }
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public Set values() {
        Set set = this.o;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.o = gVar;
        return gVar;
    }

    public Object b(Object obj, Object obj2) {
        return y(obj, obj2, true);
    }

    public void clear() {
        Arrays.fill(this.a, 0, this.d, (Object) null);
        Arrays.fill(this.c, 0, this.d, (Object) null);
        Arrays.fill(this.f, -1);
        Arrays.fill(this.g, -1);
        Arrays.fill(this.h, 0, this.d, -1);
        Arrays.fill(this.i, 0, this.d, -1);
        Arrays.fill(this.l, 0, this.d, -1);
        Arrays.fill(this.m, 0, this.d, -1);
        this.d = 0;
        this.j = -2;
        this.k = -2;
        this.e++;
    }

    public boolean containsKey(Object obj) {
        return p(obj) != -1;
    }

    public boolean containsValue(Object obj) {
        return r(obj) != -1;
    }

    public Set entrySet() {
        Set set = this.p;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.p = cVar;
        return cVar;
    }

    public final int f(int i) {
        return i & (this.f.length - 1);
    }

    public Object get(Object obj) {
        int p = p(obj);
        if (p == -1) {
            return null;
        }
        return this.c[p];
    }

    public final void j(int i, int i2) {
        r5.m.d(i != -1);
        int f2 = f(i2);
        int[] iArr = this.f;
        int i3 = iArr[f2];
        if (i3 == i) {
            int[] iArr2 = this.h;
            iArr[f2] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.h[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                String valueOf = String.valueOf(this.a[i]);
                StringBuilder sb = new StringBuilder(valueOf.length() + 32);
                sb.append("Expected to find entry with key ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
            }
            if (i3 == i) {
                int[] iArr3 = this.h;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.h[i3];
        }
    }

    public final void k(int i, int i2) {
        r5.m.d(i != -1);
        int f2 = f(i2);
        int[] iArr = this.g;
        int i3 = iArr[f2];
        if (i3 == i) {
            int[] iArr2 = this.i;
            iArr[f2] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.i[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                String valueOf = String.valueOf(this.c[i]);
                StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                sb.append("Expected to find entry with value ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
            }
            if (i3 == i) {
                int[] iArr3 = this.i;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.i[i3];
        }
    }

    public Set keySet() {
        Set set = this.n;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.n = fVar;
        return fVar;
    }

    public j l() {
        j jVar = this.q;
        if (jVar != null) {
            return jVar;
        }
        d dVar = new d(this);
        this.q = dVar;
        return dVar;
    }

    public final void m(int i) {
        int[] iArr = this.h;
        if (iArr.length < i) {
            int c2 = w.b.c(iArr.length, i);
            this.a = Arrays.copyOf(this.a, c2);
            this.c = Arrays.copyOf(this.c, c2);
            this.h = n(this.h, c2);
            this.i = n(this.i, c2);
            this.l = n(this.l, c2);
            this.m = n(this.m, c2);
        }
        if (this.f.length < i) {
            int a2 = v.a(i, 1.0d);
            this.f = i(a2);
            this.g = i(a2);
            for (int i2 = 0; i2 < this.d; i2++) {
                int f2 = f(v.c(this.a[i2]));
                int[] iArr2 = this.h;
                int[] iArr3 = this.f;
                iArr2[i2] = iArr3[f2];
                iArr3[f2] = i2;
                int f3 = f(v.c(this.c[i2]));
                int[] iArr4 = this.i;
                int[] iArr5 = this.g;
                iArr4[i2] = iArr5[f3];
                iArr5[f3] = i2;
            }
        }
    }

    public int o(Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[f(i)];
        while (i2 != -1) {
            if (r5.j.a(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    public int p(Object obj) {
        return q(obj, v.c(obj));
    }

    public Object put(Object obj, Object obj2) {
        return y(obj, obj2, false);
    }

    public int q(Object obj, int i) {
        return o(obj, i, this.f, this.h, this.a);
    }

    public int r(Object obj) {
        return s(obj, v.c(obj));
    }

    public Object remove(Object obj) {
        int c2 = v.c(obj);
        int q = q(obj, c2);
        if (q == -1) {
            return null;
        }
        Object obj2 = this.c[q];
        C(q, c2);
        return obj2;
    }

    public int s(Object obj, int i) {
        return o(obj, i, this.g, this.i, this.c);
    }

    public int size() {
        return this.d;
    }

    public Object t(Object obj) {
        int r = r(obj);
        if (r == -1) {
            return null;
        }
        return this.a[r];
    }

    public void u(int i) {
        l.b(i, "expectedSize");
        int a2 = v.a(i, 1.0d);
        this.d = 0;
        this.a = new Object[i];
        this.c = new Object[i];
        this.f = i(a2);
        this.g = i(a2);
        this.h = i(i);
        this.i = i(i);
        this.j = -2;
        this.k = -2;
        this.l = i(i);
        this.m = i(i);
    }

    public final void v(int i, int i2) {
        r5.m.d(i != -1);
        int f2 = f(i2);
        int[] iArr = this.h;
        int[] iArr2 = this.f;
        iArr[i] = iArr2[f2];
        iArr2[f2] = i;
    }

    public final void w(int i, int i2) {
        r5.m.d(i != -1);
        int f2 = f(i2);
        int[] iArr = this.i;
        int[] iArr2 = this.g;
        iArr[i] = iArr2[f2];
        iArr2[f2] = i;
    }

    public final void x(int i, int i2) {
        int i3;
        int i4;
        if (i == i2) {
            return;
        }
        int i5 = this.l[i];
        int i6 = this.m[i];
        H(i5, i2);
        H(i2, i6);
        Object[] objArr = this.a;
        Object obj = objArr[i];
        Object[] objArr2 = this.c;
        Object obj2 = objArr2[i];
        objArr[i2] = obj;
        objArr2[i2] = obj2;
        int f2 = f(v.c(obj));
        int[] iArr = this.f;
        int i7 = iArr[f2];
        if (i7 == i) {
            iArr[f2] = i2;
        } else {
            int i8 = this.h[i7];
            while (true) {
                i3 = i7;
                i7 = i8;
                if (i7 == i) {
                    break;
                } else {
                    i8 = this.h[i7];
                }
            }
            this.h[i3] = i2;
        }
        int[] iArr2 = this.h;
        iArr2[i2] = iArr2[i];
        iArr2[i] = -1;
        int f3 = f(v.c(obj2));
        int[] iArr3 = this.g;
        int i9 = iArr3[f3];
        if (i9 == i) {
            iArr3[f3] = i2;
        } else {
            int i10 = this.i[i9];
            while (true) {
                i4 = i9;
                i9 = i10;
                if (i9 == i) {
                    break;
                } else {
                    i10 = this.i[i9];
                }
            }
            this.i[i4] = i2;
        }
        int[] iArr4 = this.i;
        iArr4[i2] = iArr4[i];
        iArr4[i] = -1;
    }

    public Object y(Object obj, Object obj2, boolean z) {
        int c2 = v.c(obj);
        int q = q(obj, c2);
        if (q != -1) {
            Object obj3 = this.c[q];
            if (r5.j.a(obj3, obj2)) {
                return obj2;
            }
            G(q, obj2, z);
            return obj3;
        }
        int c3 = v.c(obj2);
        int s = s(obj2, c3);
        if (!z) {
            r5.m.h(s == -1, "Value already present: %s", obj2);
        } else if (s != -1) {
            D(s, c3);
        }
        m(this.d + 1);
        Object[] objArr = this.a;
        int i = this.d;
        objArr[i] = obj;
        this.c[i] = obj2;
        v(i, c2);
        w(this.d, c3);
        H(this.k, this.d);
        H(this.d, -2);
        this.d++;
        this.e++;
        return null;
    }

    public Object z(Object obj, Object obj2, boolean z) {
        int c2 = v.c(obj);
        int s = s(obj, c2);
        if (s != -1) {
            Object obj3 = this.a[s];
            if (r5.j.a(obj3, obj2)) {
                return obj2;
            }
            F(s, obj2, z);
            return obj3;
        }
        int i = this.k;
        int c3 = v.c(obj2);
        int q = q(obj2, c3);
        if (!z) {
            r5.m.h(q == -1, "Key already present: %s", obj2);
        } else if (q != -1) {
            i = this.l[q];
            C(q, c3);
        }
        m(this.d + 1);
        Object[] objArr = this.a;
        int i2 = this.d;
        objArr[i2] = obj2;
        this.c[i2] = obj;
        v(i2, c3);
        w(this.d, c2);
        int i3 = i == -2 ? this.j : this.m[i];
        H(i, this.d);
        H(this.d, i3);
        this.d++;
        this.e++;
        return null;
    }
}
