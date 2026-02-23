package com.google.ads.interactivemedia.v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class avi extends AbstractCollection implements Serializable {
    private static final Object[] aW = new Object[0];

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public int a(Object[] objArr, int i) {
        axq it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int b() {
        throw new UnsupportedOperationException();
    }

    public int c() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    public avo d() {
        throw null;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public abstract axq iterator();

    public abstract boolean f();

    public Object[] g() {
        return null;
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(aW);
    }

    public Object writeReplace() {
        return new avm(toArray());
    }

    public final Object[] toArray(Object[] objArr) {
        atp.k(objArr);
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] g = g();
            if (g != null) {
                return Arrays.copyOfRange(g, c(), b(), objArr.getClass());
            }
            objArr = axo.j(objArr, size);
        } else if (length > size) {
            objArr[size] = null;
        }
        a(objArr, 0);
        return objArr;
    }
}
