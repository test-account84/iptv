package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axf extends avx {
    static final axf a;
    private static final Object[] d;
    final transient Object[] b;
    final transient Object[] c;
    private final transient int e;
    private final transient int f;
    private final transient int g;

    static {
        Object[] objArr = new Object[0];
        d = objArr;
        a = new axf(objArr, 0, objArr, 0, 0);
    }

    public axf(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.b = objArr;
        this.e = i;
        this.c = objArr2;
        this.f = i2;
        this.g = i3;
    }

    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.g);
        return i + this.g;
    }

    public final int b() {
        return this.g;
    }

    public final int c() {
        return 0;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.c;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int F = axo.F(obj);
        while (true) {
            int i = F & this.f;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            F = i + 1;
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final axq iterator() {
        return d().listIterator();
    }

    public final boolean f() {
        return false;
    }

    public final Object[] g() {
        return this.b;
    }

    public final boolean h() {
        return true;
    }

    public final int hashCode() {
        return this.e;
    }

    public final avo i() {
        return avo.l(this.b, this.g);
    }

    public final int size() {
        return this.g;
    }
}
