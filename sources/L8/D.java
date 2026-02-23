package l8;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class d implements Collection, x8.a {
    public final Object[] a;
    public final boolean c;

    public d(Object[] values, boolean z) {
        kotlin.jvm.internal.l.e(values, "values");
        this.a = values;
        this.c = z;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return h.m(this.a, obj);
    }

    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.l.e(elements, "elements");
        Collection collection = (Iterable) elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int d() {
        return this.a.length;
    }

    public boolean isEmpty() {
        return this.a.length == 0;
    }

    public Iterator iterator() {
        return kotlin.jvm.internal.b.a(this.a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return d();
    }

    public final Object[] toArray() {
        return j.a(this.a, this.c);
    }

    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.l.e(array, "array");
        return kotlin.jvm.internal.f.b(this, array);
    }
}
