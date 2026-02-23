package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class aug extends AbstractCollection {
    final Object a;
    Collection b;
    final aug c;
    final Collection d;
    final /* synthetic */ auj e;

    public aug(auj aujVar, Object obj, Collection collection, aug augVar) {
        this.e = aujVar;
        this.a = obj;
        this.b = collection;
        this.c = augVar;
        this.d = augVar == null ? null : augVar.b;
    }

    public final void a() {
        aug augVar = this.c;
        if (augVar != null) {
            augVar.a();
        } else {
            auj.h(this.e).put(this.a, this.b);
        }
    }

    public final boolean add(Object obj) {
        b();
        boolean isEmpty = this.b.isEmpty();
        boolean add = this.b.add(obj);
        if (!add) {
            return add;
        }
        auj.q(this.e);
        if (!isEmpty) {
            return add;
        }
        a();
        return true;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.b.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        auj.s(this.e, this.b.size() - size);
        if (size != 0) {
            return addAll;
        }
        a();
        return true;
    }

    public final void b() {
        Collection collection;
        aug augVar = this.c;
        if (augVar != null) {
            augVar.b();
            if (this.c.b != this.d) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.b.isEmpty() || (collection = (Collection) auj.h(this.e).get(this.a)) == null) {
                return;
            }
            this.b = collection;
        }
    }

    public final void c() {
        aug augVar = this.c;
        if (augVar != null) {
            augVar.c();
        } else if (this.b.isEmpty()) {
            auj.h(this.e).remove(this.a);
        }
    }

    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.b.clear();
        auj.t(this.e, size);
        c();
    }

    public final boolean contains(Object obj) {
        b();
        return this.b.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        b();
        return this.b.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        b();
        return this.b.equals(obj);
    }

    public final int hashCode() {
        b();
        return this.b.hashCode();
    }

    public final Iterator iterator() {
        b();
        return new auf(this);
    }

    public final boolean remove(Object obj) {
        b();
        boolean remove = this.b.remove(obj);
        if (remove) {
            auj.r(this.e);
            c();
        }
        return remove;
    }

    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.b.removeAll(collection);
        if (removeAll) {
            auj.s(this.e, this.b.size() - size);
            c();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection collection) {
        atp.k(collection);
        int size = size();
        boolean retainAll = this.b.retainAll(collection);
        if (retainAll) {
            auj.s(this.e, this.b.size() - size);
            c();
        }
        return retainAll;
    }

    public final int size() {
        b();
        return this.b.size();
    }

    public final String toString() {
        b();
        return this.b.toString();
    }
}
