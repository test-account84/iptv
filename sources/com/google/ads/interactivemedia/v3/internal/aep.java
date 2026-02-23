package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aep implements zh {
    private final int a;
    private final int b;
    private final List c;
    private final cj d;
    private final SparseIntArray e;
    private final aes f;
    private final SparseArray g;
    private final SparseBooleanArray h;
    private final SparseBooleanArray i;
    private final aem j;
    private ael k;
    private zk l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private aeu q;
    private int r;
    private int s;

    static {
        adj adjVar = adj.a;
    }

    public aep() {
        this(1, 112800);
    }

    public static /* bridge */ /* synthetic */ int f(aep aepVar) {
        return aepVar.a;
    }

    public static /* bridge */ /* synthetic */ int g(aep aepVar) {
        return aepVar.m;
    }

    public static /* bridge */ /* synthetic */ SparseArray h(aep aepVar) {
        return aepVar.g;
    }

    public static /* bridge */ /* synthetic */ SparseBooleanArray i(aep aepVar) {
        return aepVar.h;
    }

    public static /* bridge */ /* synthetic */ SparseBooleanArray j(aep aepVar) {
        return aepVar.i;
    }

    public static /* bridge */ /* synthetic */ zk k(aep aepVar) {
        return aepVar.l;
    }

    public static /* bridge */ /* synthetic */ aes l(aep aepVar) {
        return aepVar.f;
    }

    public static /* bridge */ /* synthetic */ aeu m(aep aepVar) {
        return aepVar.q;
    }

    public static /* bridge */ /* synthetic */ List n(aep aepVar) {
        return aepVar.c;
    }

    public static /* bridge */ /* synthetic */ void o(aep aepVar, aeu aeuVar) {
        aepVar.q = aeuVar;
    }

    public static /* bridge */ /* synthetic */ void p(aep aepVar, int i) {
        aepVar.s = i;
    }

    public static /* bridge */ /* synthetic */ void q(aep aepVar, int i) {
        aepVar.m = i;
    }

    public static /* bridge */ /* synthetic */ boolean r(aep aepVar) {
        return aepVar.n;
    }

    public static /* bridge */ /* synthetic */ void s(aep aepVar) {
        aepVar.n = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean C(com.google.ads.interactivemedia.v3.internal.zi r7) throws java.io.IOException {
        /*
            r6 = this;
            com.google.ads.interactivemedia.v3.internal.cj r0 = r6.d
            byte[] r0 = r0.H()
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.f(r0, r2, r1)
            r1 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r1 = r1 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.i(r1)
            r7 = 1
            return r7
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aep.C(com.google.ads.interactivemedia.v3.internal.zi):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0198  */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.google.ads.interactivemedia.v3.internal.zi r18, com.google.ads.interactivemedia.v3.internal.zy r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aep.a(com.google.ads.interactivemedia.v3.internal.zi, com.google.ads.interactivemedia.v3.internal.zy):int");
    }

    public final void b(zk zkVar) {
        this.l = zkVar;
    }

    public final void c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(long r10, long r12) {
        /*
            r9 = this;
            int r10 = r9.a
            r11 = 2
            r0 = 0
            if (r10 == r11) goto L8
            r10 = 1
            goto L9
        L8:
            r10 = 0
        L9:
            com.google.ads.interactivemedia.v3.internal.af.w(r10)
            java.util.List r10 = r9.c
            int r10 = r10.size()
            r11 = 0
        L13:
            r1 = 0
            if (r11 >= r10) goto L42
            java.util.List r3 = r9.c
            java.lang.Object r3 = r3.get(r11)
            com.google.ads.interactivemedia.v3.internal.co r3 = (com.google.ads.interactivemedia.v3.internal.co) r3
            long r4 = r3.e()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L3c
            long r4 = r3.c()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L3f
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 == 0) goto L3f
            int r1 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r1 == 0) goto L3f
        L3c:
            r3.h(r12)
        L3f:
            int r11 = r11 + 1
            goto L13
        L42:
            int r10 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r10 == 0) goto L4d
            com.google.ads.interactivemedia.v3.internal.ael r10 = r9.k
            if (r10 == 0) goto L4d
            r10.c(r12)
        L4d:
            com.google.ads.interactivemedia.v3.internal.cj r10 = r9.d
            r10.B(r0)
            android.util.SparseIntArray r10 = r9.e
            r10.clear()
            r10 = 0
        L58:
            android.util.SparseArray r11 = r9.g
            int r11 = r11.size()
            if (r10 >= r11) goto L6e
            android.util.SparseArray r11 = r9.g
            java.lang.Object r11 = r11.valueAt(r10)
            com.google.ads.interactivemedia.v3.internal.aeu r11 = (com.google.ads.interactivemedia.v3.internal.aeu) r11
            r11.c()
            int r10 = r10 + 1
            goto L58
        L6e:
            r9.r = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aep.d(long, long):void");
    }

    public aep(int i, int i2) {
        this(1, new co(0L), new ado(null), 112800);
    }

    public aep(int i, co coVar, aes aesVar, int i2) {
        this.f = aesVar;
        this.b = 112800;
        this.a = i;
        this.c = Collections.singletonList(coVar);
        this.d = new cj(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.h = sparseBooleanArray;
        this.i = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.g = sparseArray;
        this.e = new SparseIntArray();
        this.j = new aem(112800);
        this.l = zk.b;
        this.s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray a = aesVar.a();
        int size = a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.g.put(a.keyAt(i3), (aeu) a.valueAt(i3));
        }
        this.g.put(0, new aej(new aen(this)));
        this.q = null;
    }
}
