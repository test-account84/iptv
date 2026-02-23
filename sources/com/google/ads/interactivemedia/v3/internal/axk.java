package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axk extends axj implements SortedSet {
    public axk(SortedSet sortedSet, atm atmVar) {
        super(sortedSet, atmVar);
    }

    public final Comparator comparator() {
        return this.a.comparator();
    }

    public final Object first() {
        Iterator it = this.a.iterator();
        atm atmVar = this.b;
        atp.k(it);
        atp.k(atmVar);
        while (it.hasNext()) {
            Object next = it.next();
            if (atmVar.a(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public final SortedSet headSet(Object obj) {
        return new axk(this.a.headSet(obj), this.b);
    }

    public final Object last() {
        SortedSet sortedSet = this.a;
        while (true) {
            Object last = sortedSet.last();
            if (this.b.a(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new axk(this.a.subSet(obj, obj2), this.b);
    }

    public final SortedSet tailSet(Object obj) {
        return new axk(this.a.tailSet(obj), this.b);
    }
}
