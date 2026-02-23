package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Random;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ui {
    private final Object a;
    private final Object b;
    private final Object c;

    public ui() {
        this(new Random());
    }

    public final int a() {
        int[] iArr = (int[]) this.b;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final int b() {
        int[] iArr = (int[]) this.b;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int c() {
        return ((int[]) this.b).length;
    }

    public final int d(int i) {
        int i2 = ((int[]) this.c)[i] + 1;
        int[] iArr = (int[]) this.b;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public final int e(int i) {
        int i2 = ((int[]) this.c)[i] - 1;
        if (i2 >= 0) {
            return ((int[]) this.b)[i2];
        }
        return -1;
    }

    public final ui f() {
        return new ui(new Random(((Random) this.a).nextLong()));
    }

    public final ui g(int i, int i2) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            iArr[i4] = ((Random) this.a).nextInt(((int[]) this.b).length + 1);
            int i5 = i4 + 1;
            int nextInt = ((Random) this.a).nextInt(i5);
            iArr2[i4] = iArr2[nextInt];
            iArr2[nextInt] = i4 + i;
            i4 = i5;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[((int[]) this.b).length + i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr4 = (int[]) this.b;
            if (i3 >= iArr4.length + i2) {
                return new ui(iArr3, new Random(((Random) this.a).nextLong()));
            }
            if (i6 >= i2 || i7 != iArr[i6]) {
                int i8 = i7 + 1;
                int i9 = iArr4[i7];
                iArr3[i3] = i9;
                if (i9 >= i) {
                    iArr3[i3] = i9 + i2;
                }
                i7 = i8;
            } else {
                iArr3[i3] = iArr2[i6];
                i6++;
            }
            i3++;
        }
    }

    public final ui h(int i, int i2) {
        int i3 = i2 - i;
        int[] iArr = new int[((int[]) this.b).length - i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr2 = (int[]) this.b;
            if (i4 >= iArr2.length) {
                return new ui(iArr, new Random(((Random) this.a).nextLong()));
            }
            int i6 = iArr2[i4];
            if (i6 < i || i6 >= i2) {
                int i7 = i4 - i5;
                if (i6 >= i) {
                    i6 -= i3;
                }
                iArr[i7] = i6;
            } else {
                i5++;
            }
            i4++;
        }
    }

    public final long i(long j) {
        return ((kr) this.c).i(j);
    }

    public final long j() {
        return ((kp) this.a).o();
    }

    public final jb[] k() {
        return (jb[]) this.b;
    }

    public final void l(au auVar) {
        ((kr) this.c).k(auVar.b);
        ((kr) this.c).j(auVar.c);
    }

    public final void m(boolean z) {
        ((kp) this.a).p(z);
    }

    private ui(Random random) {
        this(new int[0], random);
    }

    private ui(int[] iArr, Random random) {
        this.b = iArr;
        this.a = random;
        this.c = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            ((int[]) this.c)[iArr[i]] = i;
        }
    }

    public ui(jb... jbVarArr) {
        kp kpVar = new kp();
        kr krVar = new kr();
        jb[] jbVarArr2 = new jb[2];
        this.b = jbVarArr2;
        System.arraycopy(jbVarArr, 0, jbVarArr2, 0, 0);
        this.a = kpVar;
        this.c = krVar;
        jb[] jbVarArr3 = jbVarArr2;
        jbVarArr3[0] = kpVar;
        jbVarArr3[1] = krVar;
    }
}
