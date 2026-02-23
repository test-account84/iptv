package s5;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class m {

    public static class a extends AbstractCollection {
        public final Collection a;
        public final r5.n c;

        public a(Collection collection, r5.n nVar) {
            this.a = collection;
            this.c = nVar;
        }

        public boolean add(Object obj) {
            r5.m.d(this.c.apply(obj));
            return this.a.add(obj);
        }

        public boolean addAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                r5.m.d(this.c.apply(it.next()));
            }
            return this.a.addAll(collection);
        }

        public void clear() {
            D.g(this.a, this.c);
        }

        public boolean contains(Object obj) {
            if (m.c(this.a, obj)) {
                return this.c.apply(obj);
            }
            return false;
        }

        public boolean containsAll(Collection collection) {
            return m.a(this, collection);
        }

        public boolean isEmpty() {
            return !D.a(this.a, this.c);
        }

        public Iterator iterator() {
            return E.i(this.a.iterator(), this.c);
        }

        public boolean remove(Object obj) {
            return contains(obj) && this.a.remove(obj);
        }

        public boolean removeAll(Collection collection) {
            Iterator it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.c.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public boolean retainAll(Collection collection) {
            Iterator it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.c.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public int size() {
            Iterator it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.c.apply(it.next())) {
                    i++;
                }
            }
            return i;
        }

        public Object[] toArray() {
            return G.j(iterator()).toArray();
        }

        public Object[] toArray(Object[] objArr) {
            return G.j(iterator()).toArray(objArr);
        }
    }

    public static boolean a(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder b(int i) {
        l.b(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    public static boolean c(Collection collection, Object obj) {
        r5.m.k(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
