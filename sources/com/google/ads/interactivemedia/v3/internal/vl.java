package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vl extends vm {
    private final wq d;
    private final long e;
    private final long f;
    private final long g;
    private final avo h;
    private final bn i;
    private float j;
    private int k;
    private int l;
    private long m;
    private ve n;

    public vl(bf bfVar, int[] iArr, wq wqVar, List list, bn bnVar) {
        super(bfVar, iArr);
        this.d = wqVar;
        this.e = 10000000L;
        this.f = 25000000L;
        this.g = 25000000L;
        this.h = avo.m(list);
        this.i = bnVar;
        this.j = 1.0f;
        this.l = 0;
        this.m = -9223372036854775807L;
    }

    public static /* bridge */ /* synthetic */ avo i(zo[] zoVarArr) {
        int length;
        int i;
        int[] iArr;
        avk avkVar;
        ArrayList arrayList = new ArrayList();
        char c = 0;
        int i2 = 0;
        while (true) {
            length = zoVarArr.length;
            i = 1;
            if (i2 >= length) {
                break;
            }
            zo zoVar = zoVarArr[i2];
            if (zoVar == null || ((int[]) zoVar.a).length <= 1) {
                avkVar = null;
            } else {
                avkVar = avo.j();
                avkVar.g(new vj(0L, 0L));
            }
            arrayList.add(avkVar);
            i2++;
        }
        long[][] jArr = new long[length][];
        for (int i3 = 0; i3 < zoVarArr.length; i3++) {
            zo zoVar2 = zoVarArr[i3];
            if (zoVar2 == null) {
                jArr[i3] = new long[0];
            } else {
                jArr[i3] = new long[((int[]) zoVar2.a).length];
                int i4 = 0;
                while (true) {
                    if (i4 >= ((int[]) zoVar2.a).length) {
                        break;
                    }
                    jArr[i3][i4] = ((bf) zoVar2.b).b(r11[i4]).h;
                    i4++;
                }
                Arrays.sort(jArr[i3]);
            }
        }
        int[] iArr2 = new int[length];
        long[] jArr2 = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            long[] jArr3 = jArr[i5];
            jArr2[i5] = jArr3.length == 0 ? 0L : jArr3[0];
        }
        u(arrayList, jArr2);
        awj b = awu.a().b().b();
        int i6 = 0;
        while (i6 < length) {
            int length2 = jArr[i6].length;
            if (length2 <= i) {
                iArr = iArr2;
            } else {
                double[] dArr = new double[length2];
                int i7 = 0;
                while (true) {
                    long[] jArr4 = jArr[i6];
                    double d = 0.0d;
                    iArr = iArr2;
                    if (i7 >= jArr4.length) {
                        break;
                    }
                    long j = jArr4[i7];
                    if (j != -1) {
                        d = Math.log(j);
                    }
                    dArr[i7] = d;
                    i7++;
                    iArr2 = iArr;
                }
                int i8 = length2 - 1;
                double d2 = dArr[i8] - dArr[c];
                int i9 = 0;
                while (i9 < i8) {
                    int i10 = i9 + 1;
                    b.u(Double.valueOf(d2 == 0.0d ? 1.0d : (((dArr[i9] + dArr[i10]) * 0.5d) - dArr[c]) / d2), Integer.valueOf(i6));
                    i9 = i10;
                    c = 0;
                }
            }
            i6++;
            iArr2 = iArr;
            c = 0;
            i = 1;
        }
        int[] iArr3 = iArr2;
        avo m = avo.m(b.v());
        for (int i11 = 0; i11 < m.size(); i11++) {
            int intValue = ((Integer) m.get(i11)).intValue();
            int i12 = iArr3[intValue] + 1;
            iArr3[intValue] = i12;
            jArr2[intValue] = jArr[intValue][i12];
            u(arrayList, jArr2);
        }
        for (int i13 = 0; i13 < zoVarArr.length; i13++) {
            if (arrayList.get(i13) != null) {
                long j2 = jArr2[i13];
                jArr2[i13] = j2 + j2;
            }
        }
        u(arrayList, jArr2);
        avk j3 = avo.j();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            avk avkVar2 = (avk) arrayList.get(i14);
            j3.g(avkVar2 == null ? avo.o() : avkVar2.f());
        }
        return j3.f();
    }

    private static void u(List list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            avk avkVar = (avk) list.get(i);
            if (avkVar != null) {
                avkVar.g(new vj(j, jArr[i]));
            }
        }
    }

    private final int v(long j) {
        long e = (long) (((long) (this.d.e() * 0.7f)) / this.j);
        if (!this.h.isEmpty()) {
            int i = 1;
            while (i < this.h.size() - 1 && ((vj) this.h.get(i)).a < e) {
                i++;
            }
            vj vjVar = (vj) this.h.get(i - 1);
            vj vjVar2 = (vj) this.h.get(i);
            long j2 = vjVar.a;
            long j3 = vjVar2.a;
            e = ((long) (((e - j2) / (j3 - j2)) * (vjVar2.b - r8))) + vjVar.b;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            if (j == Long.MIN_VALUE || !s(i3, j)) {
                if (o(i3).h <= e) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    private static final long w(List list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        ve veVar = (ve) axo.z(list);
        long j = veVar.l;
        if (j != -9223372036854775807L) {
            long j2 = veVar.m;
            if (j2 != -9223372036854775807L) {
                return j2 - j;
            }
        }
        return -9223372036854775807L;
    }

    public final int a() {
        return this.k;
    }

    public final int b() {
        return this.l;
    }

    public final void c() {
    }

    public final void d(long j, long j2, List list, vg[] vgVarArr) {
        long w;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.k;
        int length = vgVarArr.length;
        int i2 = 0;
        if (i >= length || !vgVarArr[i].e()) {
            while (true) {
                if (i2 >= length) {
                    w = w(list);
                    break;
                }
                vg vgVar = vgVarArr[i2];
                if (vgVar.e()) {
                    w = vgVar.a() - vgVar.b();
                    break;
                }
                i2++;
            }
        } else {
            vg vgVar2 = vgVarArr[this.k];
            w = vgVar2.a() - vgVar2.b();
        }
        int i3 = this.l;
        if (i3 == 0) {
            this.l = 1;
            this.k = v(elapsedRealtime);
            return;
        }
        int i4 = this.k;
        int m = list.isEmpty() ? -1 : m(((ve) axo.z(list)).i);
        if (m != -1) {
            i3 = ((ve) axo.z(list)).j;
            i4 = m;
        }
        int v = v(elapsedRealtime);
        if (!s(i4, elapsedRealtime)) {
            s o = o(i4);
            s o2 = o(v);
            long j3 = 10000000;
            if (j2 != -9223372036854775807L) {
                j3 = Math.min((long) ((w != -9223372036854775807L ? j2 - w : j2) * 0.75f), 10000000L);
            }
            int i5 = o2.h;
            int i6 = o.h;
            if ((i5 > i6 && j < j3) || (i5 < i6 && j >= 25000000)) {
                v = i4;
            }
        }
        if (v != i4) {
            i3 = 3;
        }
        this.l = i3;
        this.k = v;
    }

    public final int e(long j, List list) {
        int i;
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.m;
        if (j2 != -9223372036854775807L && elapsedRealtime - j2 < 1000 && (list.isEmpty() || ((ve) axo.z(list)).equals(this.n))) {
            return list.size();
        }
        this.m = elapsedRealtime;
        this.n = list.isEmpty() ? null : (ve) axo.z(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (cq.s(((ve) list.get(size - 1)).l - j, this.j) < 25000000) {
            return size;
        }
        w(list);
        s o = o(v(elapsedRealtime));
        for (int i3 = 0; i3 < size; i3++) {
            ve veVar = (ve) list.get(i3);
            s sVar = veVar.i;
            if (cq.s(veVar.l - j, this.j) >= 25000000 && sVar.h < o.h && (i = sVar.r) != -1 && i <= 719 && (i2 = sVar.q) != -1 && i2 <= 1279 && i < o.r) {
                return i3;
            }
        }
        return size;
    }

    public final void f() {
        this.n = null;
    }

    public final void g() {
        this.m = -9223372036854775807L;
        this.n = null;
    }

    public final void h(float f) {
        this.j = f;
    }
}
