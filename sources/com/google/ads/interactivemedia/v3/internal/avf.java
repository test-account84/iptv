package com.google.ads.interactivemedia.v3.internal;

import j$.util.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class avf extends AbstractMap implements Serializable, aun {
    transient Object[] a;
    transient Object[] b;
    transient int c;
    transient int d;
    private transient int[] e;
    private transient int[] f;
    private transient int[] g;
    private transient int[] h;
    private transient int i;
    private transient int j;
    private transient int[] k;
    private transient int[] l;
    private transient Set m;
    private transient Set n;
    private transient Set o;
    private transient aun p;

    private avf() {
        i(2);
    }

    private static int[] A(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    private final void B(int i, Object obj) {
        atp.e(i != -1);
        int d = d(obj, axo.F(obj));
        int i2 = this.j;
        if (d != -1) {
            Objects.toString(obj);
            throw new IllegalArgumentException("Key already present in map: ".concat(String.valueOf(obj)));
        }
        if (i2 == i) {
            i2 = this.k[i];
        } else if (i2 == this.c) {
            i2 = d;
        }
        if (i == -2) {
            d = this.l[-2];
        } else if (this.c != -2) {
            d = -2;
        }
        y(this.k[i], this.l[i]);
        s(i, axo.F(this.a[i]));
        this.a[i] = obj;
        v(i, axo.F(obj));
        y(i2, i);
        y(i, d);
    }

    private final void C(int i, Object obj) {
        atp.e(i != -1);
        int F = axo.F(obj);
        if (f(obj, F) != -1) {
            Objects.toString(obj);
            throw new IllegalArgumentException("Value already present in map: ".concat(String.valueOf(obj)));
        }
        t(i, axo.F(this.b[i]));
        this.b[i] = obj;
        w(i, F);
    }

    public static /* synthetic */ int a(avf avfVar) {
        return avfVar.i;
    }

    public static /* synthetic */ int[] l(avf avfVar) {
        return avfVar.l;
    }

    public static /* synthetic */ void m(avf avfVar, int i, Object obj) {
        avfVar.C(i, obj);
    }

    public static /* synthetic */ void n(avf avfVar, aun aunVar) {
        avfVar.p = aunVar;
    }

    public static /* synthetic */ void o(avf avfVar, int i, Object obj) {
        avfVar.B(i, obj);
    }

    public static avf p() {
        return new avf();
    }

    private final int r(int i) {
        return i & (this.e.length - 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        i(16);
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private final void s(int i, int i2) {
        atp.e(i != -1);
        int r = r(i2);
        int[] iArr = this.e;
        int i3 = iArr[r];
        if (i3 == i) {
            int[] iArr2 = this.g;
            iArr[r] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.g[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                Object obj = this.a[i];
                Objects.toString(obj);
                throw new AssertionError("Expected to find entry with key ".concat(String.valueOf(obj)));
            }
            if (i3 == i) {
                int[] iArr3 = this.g;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.g[i3];
        }
    }

    private final void t(int i, int i2) {
        atp.e(i != -1);
        int r = r(i2);
        int[] iArr = this.f;
        int i3 = iArr[r];
        if (i3 == i) {
            int[] iArr2 = this.h;
            iArr[r] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.h[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                Object obj = this.b[i];
                Objects.toString(obj);
                throw new AssertionError("Expected to find entry with value ".concat(String.valueOf(obj)));
            }
            if (i3 == i) {
                int[] iArr3 = this.h;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.h[i3];
        }
    }

    private final void u(int i) {
        int length = this.g.length;
        if (length < i) {
            int e = avh.e(length, i);
            this.a = Arrays.copyOf(this.a, e);
            this.b = Arrays.copyOf(this.b, e);
            this.g = A(this.g, e);
            this.h = A(this.h, e);
            this.k = A(this.k, e);
            this.l = A(this.l, e);
        }
        if (this.e.length < i) {
            int G = axo.G(i);
            this.e = z(G);
            this.f = z(G);
            for (int i2 = 0; i2 < this.c; i2++) {
                int r = r(axo.F(this.a[i2]));
                int[] iArr = this.g;
                int[] iArr2 = this.e;
                iArr[i2] = iArr2[r];
                iArr2[r] = i2;
                int r2 = r(axo.F(this.b[i2]));
                int[] iArr3 = this.h;
                int[] iArr4 = this.f;
                iArr3[i2] = iArr4[r2];
                iArr4[r2] = i2;
            }
        }
    }

    private final void v(int i, int i2) {
        atp.e(i != -1);
        int r = r(i2);
        int[] iArr = this.g;
        int[] iArr2 = this.e;
        iArr[i] = iArr2[r];
        iArr2[r] = i;
    }

    private final void w(int i, int i2) {
        atp.e(i != -1);
        int r = r(i2);
        int[] iArr = this.h;
        int[] iArr2 = this.f;
        iArr[i] = iArr2[r];
        iArr2[r] = i;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.c);
        for (Map.Entry entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    private final void x(int i, int i2, int i3) {
        int i4;
        int i5;
        atp.e(i != -1);
        s(i, i2);
        t(i, i3);
        y(this.k[i], this.l[i]);
        int i6 = this.c - 1;
        if (i6 != i) {
            int i7 = this.k[i6];
            int i8 = this.l[i6];
            y(i7, i);
            y(i, i8);
            Object[] objArr = this.a;
            Object obj = objArr[i6];
            Object[] objArr2 = this.b;
            Object obj2 = objArr2[i6];
            objArr[i] = obj;
            objArr2[i] = obj2;
            int r = r(axo.F(obj));
            int[] iArr = this.e;
            int i9 = iArr[r];
            if (i9 == i6) {
                iArr[r] = i;
            } else {
                int i10 = this.g[i9];
                while (true) {
                    i4 = i9;
                    i9 = i10;
                    if (i9 == i6) {
                        break;
                    } else {
                        i10 = this.g[i9];
                    }
                }
                this.g[i4] = i;
            }
            int[] iArr2 = this.g;
            iArr2[i] = iArr2[i6];
            iArr2[i6] = -1;
            int r2 = r(axo.F(obj2));
            int[] iArr3 = this.f;
            int i11 = iArr3[r2];
            if (i11 == i6) {
                iArr3[r2] = i;
            } else {
                int i12 = this.h[i11];
                while (true) {
                    i5 = i11;
                    i11 = i12;
                    if (i11 == i6) {
                        break;
                    } else {
                        i12 = this.h[i11];
                    }
                }
                this.h[i5] = i;
            }
            int[] iArr4 = this.h;
            iArr4[i] = iArr4[i6];
            iArr4[i6] = -1;
        }
        Object[] objArr3 = this.a;
        int i13 = this.c - 1;
        objArr3[i13] = null;
        this.b[i13] = null;
        this.c = i13;
        this.d++;
    }

    private final void y(int i, int i2) {
        if (i == -2) {
            this.i = i2;
        } else {
            this.l[i] = i2;
        }
        if (i2 == -2) {
            this.j = i;
        } else {
            this.k[i2] = i;
        }
    }

    private static int[] z(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final int b(Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[r(i)];
        while (i2 != -1) {
            if (com.google.ads.interactivemedia.v3.impl.data.k.c(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    public final int c(Object obj) {
        return d(obj, axo.F(obj));
    }

    public final void clear() {
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, (Object) null);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1);
        Arrays.fill(this.g, 0, this.c, -1);
        Arrays.fill(this.h, 0, this.c, -1);
        Arrays.fill(this.k, 0, this.c, -1);
        Arrays.fill(this.l, 0, this.c, -1);
        this.c = 0;
        this.i = -2;
        this.j = -2;
        this.d++;
    }

    public final boolean containsKey(Object obj) {
        return c(obj) != -1;
    }

    public final boolean containsValue(Object obj) {
        return e(obj) != -1;
    }

    public final int d(Object obj, int i) {
        return b(obj, i, this.e, this.g, this.a);
    }

    public final int e(Object obj) {
        return f(obj, axo.F(obj));
    }

    public final Set entrySet() {
        Set set = this.o;
        if (set != null) {
            return set;
        }
        auy auyVar = new auy(this);
        this.o = auyVar;
        return auyVar;
    }

    public final int f(Object obj, int i) {
        return b(obj, i, this.f, this.h, this.b);
    }

    public final aun g() {
        aun aunVar = this.p;
        if (aunVar != null) {
            return aunVar;
        }
        auz auzVar = new auz(this);
        this.p = auzVar;
        return auzVar;
    }

    public final Object get(Object obj) {
        int c = c(obj);
        if (c == -1) {
            return null;
        }
        return this.b[c];
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Set values() {
        Set set = this.n;
        if (set != null) {
            return set;
        }
        avc avcVar = new avc(this);
        this.n = avcVar;
        return avcVar;
    }

    public final void i(int i) {
        axo.K(i, "expectedSize");
        int G = axo.G(i);
        this.c = 0;
        this.a = new Object[i];
        this.b = new Object[i];
        this.e = z(G);
        this.f = z(G);
        this.g = z(i);
        this.h = z(i);
        this.i = -2;
        this.j = -2;
        this.k = z(i);
        this.l = z(i);
    }

    public final void j(int i, int i2) {
        x(i, i2, axo.F(this.b[i]));
    }

    public final void k(int i, int i2) {
        x(i, axo.F(this.a[i]), i2);
    }

    public final Set keySet() {
        Set set = this.m;
        if (set != null) {
            return set;
        }
        avb avbVar = new avb(this);
        this.m = avbVar;
        return avbVar;
    }

    public final Object put(Object obj, Object obj2) {
        int F = axo.F(obj);
        int d = d(obj, F);
        if (d != -1) {
            Object obj3 = this.b[d];
            if (com.google.ads.interactivemedia.v3.impl.data.k.c(obj3, obj2)) {
                return obj2;
            }
            C(d, obj2);
            return obj3;
        }
        int F2 = axo.F(obj2);
        atp.g(f(obj2, F2) == -1, "Value already present: %s", obj2);
        u(this.c + 1);
        Object[] objArr = this.a;
        int i = this.c;
        objArr[i] = obj;
        this.b[i] = obj2;
        v(i, F);
        w(this.c, F2);
        y(this.j, this.c);
        y(this.c, -2);
        this.c++;
        this.d++;
        return null;
    }

    public final Object q(Object obj, Object obj2) {
        int F = axo.F(obj);
        int f = f(obj, F);
        if (f != -1) {
            Object obj3 = this.a[f];
            if (com.google.ads.interactivemedia.v3.impl.data.k.c(obj3, obj2)) {
                return obj2;
            }
            B(f, obj2);
            return obj3;
        }
        int i = this.j;
        int F2 = axo.F(obj2);
        atp.g(d(obj2, F2) == -1, "Key already present: %s", obj2);
        u(this.c + 1);
        Object[] objArr = this.a;
        int i2 = this.c;
        objArr[i2] = obj2;
        this.b[i2] = obj;
        v(i2, F2);
        w(this.c, F);
        int i3 = i == -2 ? this.i : this.l[i];
        y(i, this.c);
        y(this.c, i3);
        this.c++;
        this.d++;
        return null;
    }

    public final Object remove(Object obj) {
        int F = axo.F(obj);
        int d = d(obj, F);
        if (d == -1) {
            return null;
        }
        Object obj2 = this.b[d];
        j(d, F);
        return obj2;
    }

    public final int size() {
        return this.c;
    }
}
