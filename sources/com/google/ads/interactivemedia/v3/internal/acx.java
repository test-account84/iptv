package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class acx implements zh, aab {
    public static final /* synthetic */ int a = 0;
    private final cj b;
    private final cj c;
    private final cj d;
    private final cj e;
    private final ArrayDeque f;
    private final List g;
    private int h;
    private int i;
    private long j;
    private int k;
    private cj l;
    private int m;
    private int n;
    private int o;
    private int p;
    private zk q;
    private acw[] r;
    private long[][] s;
    private int t;
    private long u;
    private int v;

    static {
        acu acuVar = acu.a;
    }

    public acx() {
        this(null);
    }

    private static int f(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int i(ade adeVar, long j) {
        int a2 = adeVar.a(j);
        return a2 == -1 ? adeVar.b(j) : a2;
    }

    private static long j(ade adeVar, long j, long j2) {
        int i = i(adeVar, j);
        return i == -1 ? j2 : Math.min(adeVar.c[i], j2);
    }

    private final void k() {
        this.h = 0;
        this.k = 0;
    }

    private final void l(long j) throws as {
        ao aoVar;
        ao aoVar2;
        long j2;
        List list;
        int i;
        zp zpVar;
        int i2;
        int i3;
        while (!this.f.isEmpty() && ((acc) this.f.peek()).a == j) {
            acc accVar = (acc) this.f.pop();
            if (accVar.d == 1836019574) {
                ArrayList arrayList = new ArrayList();
                boolean z = this.v == 1;
                zp zpVar2 = new zp();
                acd b = accVar.b(1969517665);
                if (b != null) {
                    Pair a2 = acm.a(b);
                    ao aoVar3 = (ao) a2.first;
                    ao aoVar4 = (ao) a2.second;
                    if (aoVar3 != null) {
                        zpVar2.b(aoVar3);
                    }
                    aoVar = aoVar4;
                    aoVar2 = aoVar3;
                } else {
                    aoVar = null;
                    aoVar2 = null;
                }
                acc a3 = accVar.a(1835365473);
                long j3 = -9223372036854775807L;
                ao b2 = a3 != null ? acm.b(a3) : null;
                List d = acm.d(accVar, zpVar2, -9223372036854775807L, null, z, acv.a);
                int size = d.size();
                long j4 = -9223372036854775807L;
                int i4 = 0;
                int i5 = -1;
                while (true) {
                    j2 = 0;
                    if (i4 >= size) {
                        break;
                    }
                    ade adeVar = (ade) d.get(i4);
                    if (adeVar.b == 0) {
                        list = d;
                        i = size;
                        zpVar = zpVar2;
                    } else {
                        adb adbVar = adeVar.a;
                        list = d;
                        i = size;
                        long j5 = adbVar.e;
                        if (j5 == j3) {
                            j5 = adeVar.h;
                        }
                        long max = Math.max(j4, j5);
                        acw acwVar = new acw(adbVar, adeVar, this.q.i(i4, adbVar.b));
                        int i6 = "audio/true-hd".equals(adbVar.f.l) ? adeVar.e * 16 : adeVar.e + 30;
                        r b3 = adbVar.f.b();
                        b3.W(i6);
                        if (adbVar.b == 2 && j5 > 0 && (i3 = adeVar.b) > 1) {
                            b3.P(i3 / (j5 / 1000000.0f));
                        }
                        int i7 = adbVar.b;
                        int i8 = act.b;
                        if (i7 == 1 && zpVar2.a()) {
                            b3.N(zpVar2.a);
                            b3.O(zpVar2.b);
                        }
                        int i9 = adbVar.b;
                        ao[] aoVarArr = {aoVar, this.g.isEmpty() ? null : new ao(this.g)};
                        zpVar = zpVar2;
                        ao aoVar5 = new ao(new an[0]);
                        if (i9 == 1) {
                            if (aoVar2 != null) {
                                aoVar5 = aoVar2;
                            }
                        } else if (i9 == 2 && b2 != null) {
                            for (int i10 = 0; i10 < b2.a(); i10++) {
                                an b4 = b2.b(i10);
                                if (b4 instanceof abg) {
                                    abg abgVar = (abg) b4;
                                    if ("com.android.capture.fps".equals(abgVar.a)) {
                                        i2 = 1;
                                        aoVar5 = new ao(abgVar);
                                        break;
                                    }
                                }
                            }
                        }
                        i2 = 1;
                        for (int i11 = 0; i11 < 2; i11 += i2) {
                            aoVar5 = aoVar5.d(aoVarArr[i11]);
                        }
                        if (aoVar5.a() > 0) {
                            b3.X(aoVar5);
                        }
                        acwVar.c.b(b3.v());
                        if (adbVar.b == 2 && i5 == -1) {
                            i5 = arrayList.size();
                        }
                        arrayList.add(acwVar);
                        j4 = max;
                    }
                    i4++;
                    d = list;
                    size = i;
                    zpVar2 = zpVar;
                    j3 = -9223372036854775807L;
                }
                this.t = i5;
                this.u = j4;
                acw[] acwVarArr = (acw[]) arrayList.toArray(new acw[0]);
                this.r = acwVarArr;
                int length = acwVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i12 = 0; i12 < acwVarArr.length; i12++) {
                    jArr[i12] = new long[acwVarArr[i12].b.b];
                    jArr2[i12] = acwVarArr[i12].b.f[0];
                }
                int i13 = 0;
                while (i13 < acwVarArr.length) {
                    long j6 = Long.MAX_VALUE;
                    int i14 = -1;
                    for (int i15 = 0; i15 < acwVarArr.length; i15++) {
                        if (!zArr[i15]) {
                            long j7 = jArr2[i15];
                            if (j7 <= j6) {
                                i14 = i15;
                                j6 = j7;
                            }
                        }
                    }
                    int i16 = iArr[i14];
                    long[] jArr3 = jArr[i14];
                    jArr3[i16] = j2;
                    ade adeVar2 = acwVarArr[i14].b;
                    j2 += adeVar2.d[i16];
                    int i17 = i16 + 1;
                    iArr[i14] = i17;
                    if (i17 < jArr3.length) {
                        jArr2[i14] = adeVar2.f[i17];
                    } else {
                        zArr[i14] = true;
                        i13++;
                    }
                }
                this.s = jArr;
                this.q.n();
                this.q.x(this);
                this.f.clear();
                this.h = 2;
            } else if (!this.f.isEmpty()) {
                ((acc) this.f.peek()).c(accVar);
            }
        }
        if (this.h != 2) {
            k();
        }
    }

    public final boolean C(zi ziVar) throws IOException {
        return ada.b(ziVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x02cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.google.ads.interactivemedia.v3.internal.zi r33, com.google.ads.interactivemedia.v3.internal.zy r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 989
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.acx.a(com.google.ads.interactivemedia.v3.internal.zi, com.google.ads.interactivemedia.v3.internal.zy):int");
    }

    public final void b(zk zkVar) {
        this.q = zkVar;
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        this.f.clear();
        this.k = 0;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        if (j == 0) {
            k();
            return;
        }
        for (acw acwVar : this.r) {
            ade adeVar = acwVar.b;
            int a2 = adeVar.a(j2);
            if (a2 == -1) {
                a2 = adeVar.b(j2);
            }
            acwVar.e = a2;
            aaf aafVar = acwVar.d;
            if (aafVar != null) {
                aafVar.b();
            }
        }
    }

    public final long e() {
        return this.u;
    }

    public final zz g(long j) {
        long j2;
        long j3;
        int b;
        acw[] acwVarArr = this.r;
        if (acwVarArr.length == 0) {
            aac aacVar = aac.a;
            return new zz(aacVar, aacVar);
        }
        int i = this.t;
        long j4 = -1;
        if (i != -1) {
            ade adeVar = acwVarArr[i].b;
            int i2 = i(adeVar, j);
            if (i2 == -1) {
                aac aacVar2 = aac.a;
                return new zz(aacVar2, aacVar2);
            }
            long j5 = adeVar.f[i2];
            j2 = adeVar.c[i2];
            if (j5 >= j || i2 >= adeVar.b - 1 || (b = adeVar.b(j)) == -1 || b == i2) {
                j3 = -9223372036854775807L;
            } else {
                j3 = adeVar.f[b];
                j4 = adeVar.c[b];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            acw[] acwVarArr2 = this.r;
            if (i3 >= acwVarArr2.length) {
                break;
            }
            if (i3 != this.t) {
                ade adeVar2 = acwVarArr2[i3].b;
                long j6 = j(adeVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = j(adeVar2, j3, j4);
                }
                j2 = j6;
            }
            i3++;
        }
        aac aacVar3 = new aac(j, j2);
        return j3 == -9223372036854775807L ? new zz(aacVar3, aacVar3) : new zz(aacVar3, new aac(j3, j4));
    }

    public final boolean h() {
        return true;
    }

    public acx(byte[] bArr) {
        this.h = 0;
        new ArrayList();
        this.g = new ArrayList();
        this.e = new cj(16);
        this.f = new ArrayDeque();
        this.b = new cj(zw.a);
        this.c = new cj(4);
        this.d = new cj();
        this.m = -1;
        this.q = zk.b;
        this.r = new acw[0];
    }
}
