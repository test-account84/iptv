package com.google.ads.interactivemedia.v3.internal;

import j$.util.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class axo {
    public static Object[] A(Iterable iterable) {
        if (!(iterable instanceof Collection)) {
            iterable = t(iterable.iterator());
        }
        return iterable.toArray();
    }

    public static Object B(Iterable iterable) {
        return y(iterable.iterator());
    }

    public static Object C(Iterable iterable) {
        if (iterable.isEmpty()) {
            return null;
        }
        return L(iterable);
    }

    public static void D(Iterable iterable, atm atmVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            atp.k(atmVar);
            N((List) iterable, atmVar);
            return;
        }
        Iterator it = iterable.iterator();
        atp.k(atmVar);
        while (it.hasNext()) {
            if (atmVar.a(it.next())) {
                it.remove();
            }
        }
    }

    public static int E(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int F(Object obj) {
        return E(obj == null ? 0 : obj.hashCode());
    }

    public static int G(int i) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= highestOneBit) {
            return highestOneBit;
        }
        int i2 = highestOneBit + highestOneBit;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    public static boolean H(Collection collection, Object obj) {
        atp.k(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static void I(Object obj, Object obj2) {
        if (obj == null) {
            Objects.toString(obj2);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void J(boolean z) {
        atp.i(z, "no calls to next() since the last call to remove()");
    }

    public static void K(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    private static Object L(List list) {
        return list.get(list.size() - 1);
    }

    private static void M(List list, atm atmVar, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (atmVar.a(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            } else {
                list.remove(i2);
            }
        }
    }

    private static boolean N(List list, atm atmVar) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!atmVar.a(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        M(list, atmVar, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        M(list, atmVar, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    public static boolean a(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        atp.k(comparator);
        atp.k(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = awx.a;
            }
        } else {
            if (!(iterable instanceof axn)) {
                return false;
            }
            comparator2 = ((axn) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }

    public static int b(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    public static HashSet c() {
        return new HashSet();
    }

    public static HashSet d(int i) {
        return new HashSet(m(i));
    }

    public static Set e(Set set, atm atmVar) {
        if (!(set instanceof SortedSet)) {
            if (set instanceof axj) {
                axj axjVar = (axj) set;
                return new axj(axjVar.a, atp.d(axjVar.b, atmVar));
            }
            atp.k(set);
            atp.k(atmVar);
            return new axj(set, atmVar);
        }
        axj axjVar2 = (SortedSet) set;
        if (axjVar2 instanceof axj) {
            axj axjVar3 = axjVar2;
            return new axk(axjVar3.a, atp.d(axjVar3.b, atmVar));
        }
        atp.k(axjVar2);
        atp.k(atmVar);
        return new axk(axjVar2, atmVar);
    }

    public static Set f() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static boolean g(Set set, Object obj) {
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
            } catch (NullPointerException | ClassCastException unused) {
            }
        }
        return false;
    }

    public static boolean h(Set set, Collection collection) {
        atp.k(collection);
        if (collection instanceof aww) {
            collection = ((aww) collection).a();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return i(set, collection.iterator());
        }
        Iterator it = set.iterator();
        atp.k(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean i(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static Object[] j(Object[] objArr, int i) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
    }

    public static void k(Object obj, int i) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException("at index " + i);
    }

    public static void l(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            k(objArr[i2], i2);
        }
    }

    public static int m(int i) {
        if (i < 3) {
            K(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) Math.ceil(i / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static Object n(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static Object o(Map map, Object obj) {
        atp.k(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static HashMap p(int i) {
        return new HashMap(m(i));
    }

    public static Iterator q(Iterator it) {
        return new awl(it);
    }

    public static Map.Entry r(Object obj, Object obj2) {
        return new avj(obj, obj2);
    }

    public static boolean s(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static ArrayList t(Iterator it) {
        ArrayList arrayList = new ArrayList();
        atp.k(it);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @SafeVarargs
    public static ArrayList u(Object... objArr) {
        K(1, "arraySize");
        ArrayList arrayList = new ArrayList(axy.b(6L));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static Object v(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object w(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static void x(Iterator it) {
        atp.k(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static Object y(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object z(Iterable iterable) {
        if (!(iterable instanceof List)) {
            return v(iterable.iterator());
        }
        if (iterable.isEmpty()) {
            throw new NoSuchElementException();
        }
        return L(iterable);
    }
}
