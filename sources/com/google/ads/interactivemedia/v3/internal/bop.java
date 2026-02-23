package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class bop extends AbstractList implements bqt {
    private boolean a = true;

    public final void a() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public void add(int i, Object obj) {
        a();
        super.add(i, obj);
    }

    public boolean addAll(int i, Collection collection) {
        a();
        return super.addAll(i, collection);
    }

    public final void b() {
        this.a = false;
    }

    public final boolean c() {
        return this.a;
    }

    public void clear() {
        a();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public Object remove(int i) {
        a();
        return super.remove(i);
    }

    public final boolean removeAll(Collection collection) {
        a();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        a();
        return super.retainAll(collection);
    }

    public Object set(int i, Object obj) {
        a();
        return super.set(i, obj);
    }

    public boolean add(Object obj) {
        a();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        a();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        a();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
