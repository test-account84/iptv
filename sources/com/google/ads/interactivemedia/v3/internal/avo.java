package com.google.ads.interactivemedia.v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class avo extends avi implements List, RandomAccess {
    private static final axr a = new axr(awz.a, 0);

    public static avk j() {
        return new avk();
    }

    public static avo k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    public static avo l(Object[] objArr, int i) {
        return i == 0 ? awz.a : new awz(objArr, i);
    }

    public static avo m(Collection collection) {
        if (!(collection instanceof avi)) {
            return u(collection.toArray());
        }
        avo d = ((avi) collection).d();
        return d.f() ? k(d.toArray()) : d;
    }

    public static avo n(Object[] objArr) {
        return objArr.length == 0 ? awz.a : u((Object[]) objArr.clone());
    }

    public static avo o() {
        return awz.a;
    }

    public static avo p(Object obj) {
        return u(obj);
    }

    public static avo q(Object obj, Object obj2) {
        return u(obj, obj2);
    }

    public static avo r(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return u(obj, obj2, obj3, obj4, obj5);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private static avo u(Object... objArr) {
        axo.l(objArr, objArr.length);
        return k(objArr);
    }

    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Deprecated
    public final avo d() {
        return this;
    }

    public final axq e() {
        return listIterator();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (com.google.ads.interactivemedia.v3.impl.data.k.c(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !com.google.ads.interactivemedia.v3.impl.data.k.c(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public avo h() {
        return size() <= 1 ? this : new avl(this);
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public avo subList(int i, int i2) {
        atp.h(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? awz.a : new avn(this, i, i3);
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final axr listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final axr listIterator(int i) {
        atp.m(i, size());
        return isEmpty() ? a : new axr(this, i);
    }

    public Object writeReplace() {
        return new avm(toArray());
    }
}
