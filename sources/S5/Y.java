package s5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import s5.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class y extends w implements List, RandomAccess {
    public static final d0 c = new b(T.f, 0);

    public static final class a extends w.a {
        public a() {
            this(4);
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            super.d(obj);
            return this;
        }

        public a i(Object... objArr) {
            super.e(objArr);
            return this;
        }

        public a j(Iterable iterable) {
            super.b(iterable);
            return this;
        }

        public y k() {
            this.c = true;
            return y.o(this.a, this.b);
        }

        public a(int i) {
            super(i);
        }
    }

    public static class b extends s5.a {
        public final y d;

        public b(y yVar, int i) {
            super(yVar.size(), i);
            this.d = yVar;
        }

        public Object a(int i) {
            return this.d.get(i);
        }
    }

    public class c extends y {
        public final transient int d;
        public final transient int e;

        public c(int i, int i2) {
            this.d = i;
            this.e = i2;
        }

        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public y subList(int i, int i2) {
            r5.m.o(i, i2, this.e);
            y yVar = y.this;
            int i3 = this.d;
            return yVar.subList(i + i3, i2 + i3);
        }

        public Object[] f() {
            return y.this.f();
        }

        public int g() {
            return y.this.i() + this.d + this.e;
        }

        public Object get(int i) {
            r5.m.i(i, this.e);
            return y.this.get(i + this.d);
        }

        public int i() {
            return y.this.i() + this.d;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        public boolean j() {
            return true;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        public int size() {
            return this.e;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }

    public static y A(Object obj) {
        return q(obj);
    }

    public static y B(Object obj, Object obj2) {
        return q(obj, obj2);
    }

    public static y D(Object obj, Object obj2, Object obj3) {
        return q(obj, obj2, obj3);
    }

    public static y E(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return q(obj, obj2, obj3, obj4, obj5);
    }

    public static y F(Comparator comparator, Iterable iterable) {
        r5.m.k(comparator);
        Object[] j = D.j(iterable);
        P.b(j);
        Arrays.sort(j, comparator);
        return n(j);
    }

    public static y n(Object[] objArr) {
        return o(objArr, objArr.length);
    }

    public static y o(Object[] objArr, int i) {
        return i == 0 ? z() : new T(objArr, i);
    }

    public static a p() {
        return new a();
    }

    public static y q(Object... objArr) {
        return n(P.b(objArr));
    }

    public static y r(Collection collection) {
        if (!(collection instanceof w)) {
            return q(collection.toArray());
        }
        y d = ((w) collection).d();
        return d.j() ? n(d.toArray()) : d;
    }

    public static y s(Object[] objArr) {
        return objArr.length == 0 ? z() : q((Object[]) objArr.clone());
    }

    public static y z() {
        return T.f;
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public y subList(int i, int i2) {
        r5.m.o(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? z() : I(i, i2);
    }

    public y I(int i, int i2) {
        return new c(i, i2 - i);
    }

    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int e(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(Object obj) {
        return G.c(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return G.d(this, obj);
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c0 iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return G.f(this, obj);
    }

    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public d0 listIterator() {
        return listIterator(0);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public d0 listIterator(int i) {
        r5.m.m(i, size());
        return isEmpty() ? c : new b(this, i);
    }

    public final y d() {
        return this;
    }
}
