package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class vm implements we {
    protected final bf a;
    protected final int b;
    protected final int[] c;
    private final s[] d;
    private final long[] e;
    private int f;

    public vm(bf bfVar, int[] iArr) {
        int length = iArr.length;
        int i = 0;
        af.w(length > 0);
        af.s(bfVar);
        this.a = bfVar;
        this.b = length;
        this.d = new s[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = bfVar.b(iArr[i2]);
        }
        Arrays.sort(this.d, vp.b);
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i >= i3) {
                this.e = new long[i3];
                return;
            } else {
                this.c[i] = bfVar.a(this.d[i]);
                i++;
            }
        }
    }

    public int e(long j, List list) {
        return list.size();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            vm vmVar = (vm) obj;
            if (this.a == vmVar.a && Arrays.equals(this.c, vmVar.c)) {
                return true;
            }
        }
        return false;
    }

    public void f() {
    }

    public void g() {
    }

    public void h(float f) {
    }

    public final int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        int identityHashCode = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.c);
        this.f = identityHashCode;
        return identityHashCode;
    }

    public final int j(int i) {
        return this.c[i];
    }

    public final int k() {
        return this.c[a()];
    }

    public final int l(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final int m(s sVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.d[i] == sVar) {
                return i;
            }
        }
        return -1;
    }

    public final int n() {
        return this.c.length;
    }

    public final s o(int i) {
        return this.d[i];
    }

    public final s p() {
        return this.d[a()];
    }

    public final bf q() {
        return this.a;
    }

    public final boolean r(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean s = s(i, elapsedRealtime);
        int i2 = 0;
        while (true) {
            if (i2 < this.b) {
                if (s) {
                    break;
                }
                s = (i2 == i || s(i2, elapsedRealtime)) ? false : true;
                i2++;
            } else if (!s) {
                return false;
            }
        }
        long[] jArr = this.e;
        jArr[i] = Math.max(jArr[i], cq.an(elapsedRealtime, j));
        return true;
    }

    public final boolean s(int i, long j) {
        return this.e[i] > j;
    }

    public final /* synthetic */ void t() {
    }
}
