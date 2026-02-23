package com.google.android.gms.internal.firebase-auth-api;

import j$.util.List;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzap extends zzak implements List, RandomAccess, j$.util.List {
    private static final zzbf zza = new zzar(zzax.zza, 0);

    private static zzap zzb(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException("at index " + i);
            }
        }
        return zzb(objArr, objArr.length);
    }

    public static zzao zzg() {
        return new zzao();
    }

    public static zzap zzh() {
        return zzax.zza;
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

    public boolean equals(Object obj) {
        if (obj == zzy.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzw.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!zzw.zza(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
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

    public /* synthetic */ Iterator iterator() {
        return iterator();
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

    public /* synthetic */ ListIterator listIterator() {
        return (zzbf) listIterator(0);
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.-CC.$default$replaceAll(this, unaryOperator);
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void sort(Comparator comparator) {
        List.-CC.$default$sort(this, comparator);
    }

    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final zzap zzc() {
        return this;
    }

    public final zzbc zzd() {
        return (zzbf) listIterator();
    }

    public static zzap zzb(Object[] objArr, int i) {
        return i == 0 ? zzax.zza : new zzax(objArr, i);
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzy.zzb(i, size());
        return isEmpty() ? zza : new zzar(this, i);
    }

    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzap subList(int i, int i2) {
        zzy.zza(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? zzax.zza : new zzaq(this, i, i3);
    }

    public static zzap zza(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return zzb(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    public static zzap zza(Collection collection) {
        if (!(collection instanceof zzak)) {
            return zzb(collection.toArray());
        }
        zzap zzc = ((zzak) collection).zzc();
        if (!zzc.zze()) {
            return zzc;
        }
        Object[] array = zzc.toArray();
        return zzb(array, array.length);
    }

    public static zzap zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }
}
