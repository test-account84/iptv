package s;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {
    public b a;
    public c b;
    public e c;

    public final class a implements Iterator {
        public final int a;
        public int c;
        public int d;
        public boolean e = false;

        public a(int i) {
            this.a = i;
            this.c = h.this.d();
        }

        public boolean hasNext() {
            return this.d < this.c;
        }

        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object b = h.this.b(this.d, this.a);
            this.d++;
            this.e = true;
            return b;
        }

        public void remove() {
            if (!this.e) {
                throw new IllegalStateException();
            }
            int i = this.d - 1;
            this.d = i;
            this.c--;
            this.e = false;
            h.this.h(i);
        }
    }

    public final class b implements Set {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            int d = h.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                h.this.g(entry.getKey(), entry.getValue());
            }
            return d != h.this.d();
        }

        public void clear() {
            h.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e = h.this.e(entry.getKey());
            if (e < 0) {
                return false;
            }
            return s.e.c(h.this.b(e, 1), entry.getValue());
        }

        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return h.k(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int d = h.this.d() - 1; d >= 0; d--) {
                Object b = h.this.b(d, 0);
                Object b2 = h.this.b(d, 1);
                i += (b == null ? 0 : b.hashCode()) ^ (b2 == null ? 0 : b2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        public Iterator iterator() {
            return h.this.new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return h.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c implements Set {
        public c() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            h.this.a();
        }

        public boolean contains(Object obj) {
            return h.this.e(obj) >= 0;
        }

        public boolean containsAll(Collection collection) {
            return h.j(h.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return h.k(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int d = h.this.d() - 1; d >= 0; d--) {
                Object b = h.this.b(d, 0);
                i += b == null ? 0 : b.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        public Iterator iterator() {
            return h.this.new a(0);
        }

        public boolean remove(Object obj) {
            int e = h.this.e(obj);
            if (e < 0) {
                return false;
            }
            h.this.h(e);
            return true;
        }

        public boolean removeAll(Collection collection) {
            return h.o(h.this.c(), collection);
        }

        public boolean retainAll(Collection collection) {
            return h.p(h.this.c(), collection);
        }

        public int size() {
            return h.this.d();
        }

        public Object[] toArray() {
            return h.this.q(0);
        }

        public Object[] toArray(Object[] objArr) {
            return h.this.r(objArr, 0);
        }
    }

    public final class d implements Iterator, Map.Entry {
        public int a;
        public boolean d = false;
        public int c = -1;

        public d() {
            this.a = h.this.d() - 1;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c++;
            this.d = true;
            return this;
        }

        public boolean equals(Object obj) {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return s.e.c(entry.getKey(), h.this.b(this.c, 0)) && s.e.c(entry.getValue(), h.this.b(this.c, 1));
        }

        public Object getKey() {
            if (this.d) {
                return h.this.b(this.c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if (this.d) {
                return h.this.b(this.c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.c < this.a;
        }

        public int hashCode() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b = h.this.b(this.c, 0);
            Object b2 = h.this.b(this.c, 1);
            return (b == null ? 0 : b.hashCode()) ^ (b2 != null ? b2.hashCode() : 0);
        }

        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            h.this.h(this.c);
            this.c--;
            this.a--;
            this.d = false;
        }

        public Object setValue(Object obj) {
            if (this.d) {
                return h.this.i(this.c, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final class e implements Collection {
        public e() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            h.this.a();
        }

        public boolean contains(Object obj) {
            return h.this.f(obj) >= 0;
        }

        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        public Iterator iterator() {
            return h.this.new a(1);
        }

        public boolean remove(Object obj) {
            int f = h.this.f(obj);
            if (f < 0) {
                return false;
            }
            h.this.h(f);
            return true;
        }

        public boolean removeAll(Collection collection) {
            int d = h.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(h.this.b(i, 1))) {
                    h.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection collection) {
            int d = h.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(h.this.b(i, 1))) {
                    h.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return h.this.d();
        }

        public Object[] toArray() {
            return h.this.q(1);
        }

        public Object[] toArray(Object[] objArr) {
            return h.this.r(objArr, 1);
        }
    }

    public static boolean j(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (NullPointerException | ClassCastException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(Object obj, Object obj2);

    public abstract void h(int i);

    public abstract Object i(int i, Object obj);

    public Set l() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public Set m() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public Collection n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }

    public Object[] q(int i) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i) {
        int d2 = d();
        if (objArr.length < d2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d2);
        }
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        if (objArr.length > d2) {
            objArr[d2] = null;
        }
        return objArr;
    }
}
