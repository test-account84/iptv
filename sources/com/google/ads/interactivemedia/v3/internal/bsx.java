package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bsx {
    private static final bsx a = new bsx(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    private bsx() {
        this(0, new int[8], new Object[8], true);
    }

    public static bsx c() {
        return a;
    }

    public static bsx d(bsx bsxVar, bsx bsxVar2) {
        int i = bsxVar.b + bsxVar2.b;
        int[] copyOf = Arrays.copyOf(bsxVar.c, i);
        System.arraycopy(bsxVar2.c, 0, copyOf, bsxVar.b, bsxVar2.b);
        Object[] copyOf2 = Arrays.copyOf(bsxVar.d, i);
        System.arraycopy(bsxVar2.d, 0, copyOf2, bsxVar.b, bsxVar2.b);
        return new bsx(i, copyOf, copyOf2, true);
    }

    public static bsx e() {
        return new bsx(0, new int[8], new Object[8], true);
    }

    private final void m(int i) {
        int[] iArr = this.c;
        if (i > iArr.length) {
            int i2 = this.b;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.c = Arrays.copyOf(iArr, i);
            this.d = Arrays.copyOf(this.d, i);
        }
    }

    private static void n(int i, Object obj, btn btnVar) throws IOException {
        int a2 = btm.a(i);
        int b = btm.b(i);
        if (b == 0) {
            btnVar.t(a2, ((Long) obj).longValue());
            return;
        }
        if (b == 1) {
            btnVar.m(a2, ((Long) obj).longValue());
            return;
        }
        if (b == 2) {
            btnVar.d(a2, (bpb) obj);
            return;
        }
        if (b != 3) {
            if (b != 5) {
                throw new RuntimeException(bqw.a());
            }
            btnVar.k(a2, ((Integer) obj).intValue());
        } else {
            btnVar.G(a2);
            ((bsx) obj).k(btnVar);
            btnVar.h(a2);
        }
    }

    public final int a() {
        int T;
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int i4 = this.c[i3];
            int a2 = btm.a(i4);
            int b = btm.b(i4);
            if (b == 0) {
                T = bpk.T(a2, ((Long) this.d[i3]).longValue());
            } else if (b == 1) {
                ((Long) this.d[i3]).longValue();
                T = bpk.aF(a2);
            } else if (b == 2) {
                T = bpk.x(a2, (bpb) this.d[i3]);
            } else if (b == 3) {
                int Q = bpk.Q(a2);
                T = Q + Q + ((bsx) this.d[i3]).a();
            } else {
                if (b != 5) {
                    throw new IllegalStateException(bqw.a());
                }
                ((Integer) this.d[i3]).intValue();
                T = bpk.aE(a2);
            }
            i2 += T;
        }
        this.e = i2;
        return i2;
    }

    public final int b() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int i4 = this.c[i3];
            bpb bpbVar = (bpb) this.d[i3];
            int Q = bpk.Q(1);
            i2 += Q + Q + bpk.R(2, btm.a(i4)) + bpk.x(3, bpbVar);
        }
        this.e = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bsx)) {
            return false;
        }
        bsx bsxVar = (bsx) obj;
        int i = this.b;
        if (i == bsxVar.b) {
            int[] iArr = this.c;
            int[] iArr2 = bsxVar.c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.d;
                    Object[] objArr2 = bsxVar.d;
                    int i3 = this.b;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final void f() {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g() {
        this.f = false;
    }

    public final void h(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            bru.b(sb, i, String.valueOf(btm.a(this.c[i2])), this.d[i2]);
        }
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.d;
        int i7 = this.b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void i(int i, Object obj) {
        f();
        m(this.b + 1);
        int[] iArr = this.c;
        int i2 = this.b;
        iArr[i2] = i;
        this.d[i2] = obj;
        this.b = i2 + 1;
    }

    public final void j(btn btnVar) throws IOException {
        for (int i = 0; i < this.b; i++) {
            btnVar.x(btm.a(this.c[i]), this.d[i]);
        }
    }

    public final void k(btn btnVar) throws IOException {
        if (this.b != 0) {
            for (int i = 0; i < this.b; i++) {
                n(this.c[i], this.d[i], btnVar);
            }
        }
    }

    public final void l(bsx bsxVar) {
        if (bsxVar.equals(a)) {
            return;
        }
        f();
        int i = this.b + bsxVar.b;
        m(i);
        System.arraycopy(bsxVar.c, 0, this.c, this.b, bsxVar.b);
        System.arraycopy(bsxVar.d, 0, this.d, this.b, bsxVar.b);
        this.b = i;
    }

    private bsx(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }
}
