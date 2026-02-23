package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsb extends bop implements RandomAccess {
    private static final bsb a;
    private Object[] b;
    private int c;

    static {
        bsb bsbVar = new bsb(new Object[0], 0);
        a = bsbVar;
        bsbVar.b();
    }

    public bsb() {
        this(new Object[10], 0);
    }

    public static bsb e() {
        return a;
    }

    private final String f(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    private final void g(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(f(i));
        }
    }

    public final void add(int i, Object obj) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(f(i));
        }
        Object[] objArr = this.b;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.b, i, objArr2, i + 1, this.c - i);
            this.b = objArr2;
        }
        this.b[i] = obj;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public final /* bridge */ /* synthetic */ bqt d(int i) {
        if (i >= this.c) {
            return new bsb(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final Object get(int i) {
        g(i);
        return this.b[i];
    }

    public final Object remove(int i) {
        a();
        g(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i < this.c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    public final Object set(int i, Object obj) {
        a();
        g(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    public final int size() {
        return this.c;
    }

    private bsb(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    public final boolean add(Object obj) {
        a();
        int i = this.c;
        Object[] objArr = this.b;
        if (i == objArr.length) {
            this.b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
