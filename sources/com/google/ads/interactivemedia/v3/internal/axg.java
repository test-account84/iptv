package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axg extends awf {
    static final axg c = new axg(avo.o(), awx.a);
    final transient avo d;

    public axg(avo avoVar, Comparator comparator) {
        super(comparator);
        this.d = avoVar;
    }

    public final axg A(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        return i < i2 ? new axg(this.d.subList(i, i2), ((awf) this).a) : awf.w(((awf) this).a);
    }

    public final int a(Object[] objArr, int i) {
        return this.d.a(objArr, i);
    }

    public final int b() {
        return this.d.b();
    }

    public final int c() {
        return this.d.c();
    }

    public final Object ceiling(Object obj) {
        int z = z(obj, true);
        if (z == size()) {
            return null;
        }
        return this.d.get(z);
    }

    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.d, obj, ((awf) this).a) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        if (collection instanceof aww) {
            collection = ((aww) collection).a();
        }
        if (!axo.a(((awf) this).a, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        axq it = iterator();
        Iterator it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int j = j(next2, next);
                if (j >= 0) {
                    if (j != 0) {
                        break;
                    }
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                }
            } catch (NullPointerException | ClassCastException unused) {
            }
        }
        return false;
    }

    public final avo d() {
        return this.d;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final axq iterator() {
        return this.d.listIterator();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!axo.a(((awf) this).a, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            axq it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 == null || j(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    public final boolean f() {
        return this.d.f();
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.d.get(0);
    }

    public final Object floor(Object obj) {
        int y = y(obj, true) - 1;
        if (y == -1) {
            return null;
        }
        return this.d.get(y);
    }

    public final Object[] g() {
        return this.d.g();
    }

    public final Object higher(Object obj) {
        int z = z(obj, false);
        if (z == size()) {
            return null;
        }
        return this.d.get(z);
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.d.get(size() - 1);
    }

    public final Object lower(Object obj) {
        int y = y(obj, false) - 1;
        if (y == -1) {
            return null;
        }
        return this.d.get(y);
    }

    public final awf o() {
        Comparator reverseOrder = Collections.reverseOrder(((awf) this).a);
        return isEmpty() ? awf.w(reverseOrder) : new axg(this.d.h(), reverseOrder);
    }

    public final awf r(Object obj, boolean z) {
        return A(0, y(obj, z));
    }

    public final int size() {
        return this.d.size();
    }

    public final awf t(Object obj, boolean z, Object obj2, boolean z2) {
        return v(obj, z).r(obj2, z2);
    }

    public final awf v(Object obj, boolean z) {
        return A(z(obj, z), size());
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public final axq descendingIterator() {
        return this.d.h().listIterator();
    }

    public final int y(Object obj, boolean z) {
        avo avoVar = this.d;
        atp.k(obj);
        int binarySearch = Collections.binarySearch(avoVar, obj, ((awf) this).a);
        return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : ~binarySearch;
    }

    public final int z(Object obj, boolean z) {
        avo avoVar = this.d;
        atp.k(obj);
        int binarySearch = Collections.binarySearch(avoVar, obj, ((awf) this).a);
        return binarySearch >= 0 ? z ? binarySearch : binarySearch + 1 : ~binarySearch;
    }
}
