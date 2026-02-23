package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class aup extends AbstractCollection {
    final Collection a;
    final atm b;

    public aup(Collection collection, atm atmVar) {
        this.a = collection;
        this.b = atmVar;
    }

    public final boolean add(Object obj) {
        atp.e(this.b.a(obj));
        return this.a.add(obj);
    }

    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            atp.e(this.b.a(it.next()));
        }
        return this.a.addAll(collection);
    }

    public final void clear() {
        axo.D(this.a, this.b);
    }

    public final boolean contains(Object obj) {
        if (axo.H(this.a, obj)) {
            return this.b.a(obj);
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        Collection collection = this.a;
        atm atmVar = this.b;
        Iterator it = collection.iterator();
        atp.l(atmVar, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (atmVar.a(it.next())) {
                return i == -1;
            }
            i++;
        }
        return true;
    }

    public final Iterator iterator() {
        Iterator it = this.a.iterator();
        atm atmVar = this.b;
        atp.k(it);
        atp.k(atmVar);
        return new ats(it, atmVar);
    }

    public final boolean remove(Object obj) {
        return contains(obj) && this.a.remove(obj);
    }

    public final boolean removeAll(Collection collection) {
        Iterator it = this.a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.b.a(next) && collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public final boolean retainAll(Collection collection) {
        Iterator it = this.a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.b.a(next) && !collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public final int size() {
        Iterator it = this.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.b.a(it.next())) {
                i++;
            }
        }
        return i;
    }

    public final Object[] toArray() {
        return axo.t(iterator()).toArray();
    }

    public final Object[] toArray(Object[] objArr) {
        return axo.t(iterator()).toArray(objArr);
    }
}
