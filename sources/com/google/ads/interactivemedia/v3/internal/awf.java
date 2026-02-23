package com.google.ads.interactivemedia.v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class awf extends awg implements NavigableSet, axn {
    final transient Comparator a;
    transient awf b;

    public awf(Comparator comparator) {
        this.a = comparator;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static axg w(Comparator comparator) {
        return awx.a.equals(comparator) ? axg.c : new axg(avo.o(), comparator);
    }

    public Object ceiling(Object obj) {
        return axo.B(tailSet(obj, true));
    }

    public final Comparator comparator() {
        return this.a;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public abstract axq iterator();

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        return axo.y(headSet(obj, true).descendingIterator());
    }

    public Object higher(Object obj) {
        return axo.B(tailSet(obj, false));
    }

    public final int j(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        return axo.y(headSet(obj, false).descendingIterator());
    }

    public abstract awf o();

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final awf descendingSet() {
        awf awfVar = this.b;
        if (awfVar != null) {
            return awfVar;
        }
        awf o = o();
        this.b = o;
        o.b = this;
        return o;
    }

    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final awf headSet(Object obj, boolean z) {
        atp.k(obj);
        return r(obj, z);
    }

    public abstract awf r(Object obj, boolean z);

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final awf subSet(Object obj, boolean z, Object obj2, boolean z2) {
        atp.k(obj);
        atp.k(obj2);
        atp.e(this.a.compare(obj, obj2) <= 0);
        return t(obj, z, obj2, z2);
    }

    public abstract awf t(Object obj, boolean z, Object obj2, boolean z2);

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final awf tailSet(Object obj, boolean z) {
        atp.k(obj);
        return v(obj, z);
    }

    public abstract awf v(Object obj, boolean z);

    public Object writeReplace() {
        return new awe(this.a, toArray());
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public abstract axq descendingIterator();

    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }
}
