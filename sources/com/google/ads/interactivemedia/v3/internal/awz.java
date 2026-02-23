package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awz extends avo {
    static final avo a = new awz(new Object[0], 0);
    final transient Object[] b;
    private final transient int c;

    public awz(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.c);
        return i + this.c;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return 0;
    }

    public final boolean f() {
        return false;
    }

    public final Object[] g() {
        return this.b;
    }

    public final Object get(int i) {
        atp.j(i, this.c);
        Object obj = this.b[i];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.c;
    }
}
