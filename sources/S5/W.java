package s5;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class w extends AbstractCollection implements Serializable {
    public static final Object[] a = new Object[0];

    public static abstract class a extends b {
        public Object[] a;
        public int b;
        public boolean c;

        public a(int i) {
            l.b(i, "initialCapacity");
            this.a = new Object[i];
            this.b = 0;
        }

        public b b(Iterable iterable) {
            if (iterable instanceof Collection) {
                w wVar = (Collection) iterable;
                g(this.b + wVar.size());
                if (wVar instanceof w) {
                    this.b = wVar.e(this.a, this.b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a d(Object obj) {
            r5.m.k(obj);
            g(this.b + 1);
            Object[] objArr = this.a;
            int i = this.b;
            this.b = i + 1;
            objArr[i] = obj;
            return this;
        }

        public b e(Object... objArr) {
            f(objArr, objArr.length);
            return this;
        }

        public final void f(Object[] objArr, int i) {
            P.c(objArr, i);
            g(this.b + i);
            System.arraycopy(objArr, 0, this.a, this.b, i);
            this.b += i;
        }

        public final void g(int i) {
            Object[] objArr = this.a;
            if (objArr.length < i) {
                this.a = Arrays.copyOf(objArr, b.c(objArr.length, i));
            } else if (!this.c) {
                return;
            } else {
                this.a = (Object[]) objArr.clone();
            }
            this.c = false;
        }
    }

    public static abstract class b {
        public static int c(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = i + (i >> 1) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        public abstract b a(Object obj);

        public b b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    public y d() {
        return isEmpty() ? y.z() : y.n(toArray());
    }

    public int e(Object[] objArr, int i) {
        c0 l = l();
        while (l.hasNext()) {
            objArr[i] = l.next();
            i++;
        }
        return i;
    }

    public Object[] f() {
        return null;
    }

    public int g() {
        throw new UnsupportedOperationException();
    }

    public int i() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean j();

    public abstract c0 l();

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(a);
    }

    public final Object[] toArray(Object[] objArr) {
        r5.m.k(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] f = f();
            if (f != null) {
                return S.a(f, i(), g(), objArr);
            }
            objArr = P.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        e(objArr, 0);
        return objArr;
    }
}
