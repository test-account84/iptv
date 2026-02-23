package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class wd extends wj {
    public static final /* synthetic */ int a = 0;
    private static final awy b = awy.b(vp.e);
    private static final awy c = awy.b(vp.f);
    private final Object d;
    private final boolean e;
    private vu f;
    private vy g;
    private f h;
    private final vk i;

    @Deprecated
    public wd() {
        vu vuVar = vu.B;
        throw null;
    }

    public static /* bridge */ /* synthetic */ int a(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    public static int b(s sVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(sVar.c)) {
            return 4;
        }
        String e = e(str);
        String e2 = e(sVar.c);
        if (e2 == null || e == null) {
            return (z && e2 == null) ? 1 : 0;
        }
        if (e2.startsWith(e) || e.startsWith(e2)) {
            return 3;
        }
        return cq.al(e2, "-")[0].equals(cq.al(e, "-")[0]) ? 2 : 0;
    }

    public static /* bridge */ /* synthetic */ awy c() {
        return b;
    }

    public static /* bridge */ /* synthetic */ awy d() {
        return c;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static /* bridge */ /* synthetic */ void f(wd wdVar) {
        wdVar.q();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ boolean i(com.google.ads.interactivemedia.v3.internal.wd r8, com.google.ads.interactivemedia.v3.internal.s r9) {
        /*
            java.lang.Object r0 = r8.d
            monitor-enter(r0)
            com.google.ads.interactivemedia.v3.internal.vu r1 = r8.f     // Catch: java.lang.Throwable -> L90
            boolean r1 = r1.L     // Catch: java.lang.Throwable -> L90
            r2 = 1
            if (r1 == 0) goto L92
            boolean r1 = r8.e     // Catch: java.lang.Throwable -> L90
            if (r1 != 0) goto L92
            int r1 = r9.y     // Catch: java.lang.Throwable -> L90
            r3 = 2
            if (r1 <= r3) goto L92
            java.lang.String r1 = r9.l     // Catch: java.lang.Throwable -> L90
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L1b
            goto L65
        L1b:
            int r6 = r1.hashCode()     // Catch: java.lang.Throwable -> L90
            r7 = 3
            switch(r6) {
                case -2123537834: goto L42;
                case 187078296: goto L38;
                case 187078297: goto L2e;
                case 1504578661: goto L24;
                default: goto L23;
            }
        L23:
            goto L4c
        L24:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 1
            goto L4d
        L2e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 3
            goto L4d
        L38:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 0
            goto L4d
        L42:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 2
            goto L4d
        L4c:
            r1 = -1
        L4d:
            if (r1 == 0) goto L56
            if (r1 == r2) goto L56
            if (r1 == r3) goto L56
            if (r1 == r7) goto L56
            goto L65
        L56:
            int r1 = com.google.ads.interactivemedia.v3.internal.cq.a     // Catch: java.lang.Throwable -> L90
            if (r1 < r4) goto L92
            com.google.ads.interactivemedia.v3.internal.vy r1 = r8.g     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L92
            boolean r1 = r1.g()     // Catch: java.lang.Throwable -> L90
            if (r1 != 0) goto L65
            goto L92
        L65:
            int r1 = com.google.ads.interactivemedia.v3.internal.cq.a     // Catch: java.lang.Throwable -> L90
            if (r1 < r4) goto L8e
            com.google.ads.interactivemedia.v3.internal.vy r1 = r8.g     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8e
            boolean r1 = r1.g()     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8e
            com.google.ads.interactivemedia.v3.internal.vy r1 = r8.g     // Catch: java.lang.Throwable -> L90
            boolean r1 = r1.e()     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8e
            com.google.ads.interactivemedia.v3.internal.vy r1 = r8.g     // Catch: java.lang.Throwable -> L90
            boolean r1 = r1.f()     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8e
            com.google.ads.interactivemedia.v3.internal.vy r1 = r8.g     // Catch: java.lang.Throwable -> L90
            com.google.ads.interactivemedia.v3.internal.f r8 = r8.h     // Catch: java.lang.Throwable -> L90
            boolean r8 = r1.d(r8, r9)     // Catch: java.lang.Throwable -> L90
            if (r8 == 0) goto L8e
            goto L92
        L8e:
            r2 = 0
            goto L92
        L90:
            r8 = move-exception
            goto L94
        L92:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L90
            return r2
        L94:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L90
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.wd.i(com.google.ads.interactivemedia.v3.internal.wd, com.google.ads.interactivemedia.v3.internal.s):boolean");
    }

    public static boolean j(int i, boolean z) {
        int f = fz.f(i);
        if (f != 4) {
            return z && f == 3;
        }
        return true;
    }

    private final void q() {
        boolean z;
        vy vyVar;
        synchronized (this.d) {
            try {
                z = false;
                if (this.f.L && !this.e && cq.a >= 32 && (vyVar = this.g) != null && vyVar.g()) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            o();
        }
    }

    private static void r(um umVar, bi biVar) {
        for (int i = 0; i < umVar.b; i++) {
            if (((bg) biVar.z.get(umVar.b(i))) != null) {
                throw null;
            }
        }
    }

    private static final Pair s(int i, wg wgVar, int[][][] iArr, wa waVar, Comparator comparator) {
        int i2;
        avo avoVar;
        wg wgVar2 = wgVar;
        ArrayList arrayList = new ArrayList();
        int a2 = wgVar.a();
        int i3 = 0;
        while (i3 < a2) {
            if (i == wgVar2.b(i3)) {
                um d = wgVar2.d(i3);
                for (int i4 = 0; i4 < d.b; i4++) {
                    bf b2 = d.b(i4);
                    List a3 = waVar.a(i3, b2, iArr[i3][i4]);
                    boolean[] zArr = new boolean[b2.a];
                    int i5 = 0;
                    while (i5 < b2.a) {
                        wb wbVar = (wb) a3.get(i5);
                        int b3 = wbVar.b();
                        if (zArr[i5] || b3 == 0) {
                            i2 = a2;
                        } else {
                            if (b3 == 1) {
                                avoVar = avo.p(wbVar);
                                i2 = a2;
                            } else {
                                avo arrayList2 = new ArrayList();
                                arrayList2.add(wbVar);
                                int i6 = i5 + 1;
                                while (i6 < b2.a) {
                                    wb wbVar2 = (wb) a3.get(i6);
                                    int i7 = a2;
                                    if (wbVar2.b() == 2 && wbVar.c(wbVar2)) {
                                        arrayList2.add(wbVar2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    a2 = i7;
                                }
                                i2 = a2;
                                avoVar = arrayList2;
                            }
                            arrayList.add(avoVar);
                        }
                        i5++;
                        a2 = i2;
                    }
                }
            }
            i3++;
            wgVar2 = wgVar;
            a2 = a2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((wb) list.get(i8)).c;
        }
        wb wbVar3 = (wb) list.get(0);
        return Pair.create(new zo(wbVar3.b, iArr2), Integer.valueOf(wbVar3.a));
    }

    public final void g() {
        vy vyVar;
        synchronized (this.d) {
            try {
                if (cq.a >= 32 && (vyVar = this.g) != null) {
                    vyVar.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.g();
    }

    public final void h(f fVar) {
        boolean z;
        synchronized (this.d) {
            z = !this.h.equals(fVar);
            this.h = fVar;
        }
        if (z) {
            q();
        }
    }

    public final void k() {
    }

    public final Pair l(wg wgVar, int[][][] iArr, int[] iArr2) throws ev {
        vu vuVar;
        boolean z;
        String str;
        int[] iArr3;
        int length;
        bf bfVar;
        vy vyVar;
        int[][][] iArr4 = iArr;
        synchronized (this.d) {
            try {
                vuVar = this.f;
                if (vuVar.L && cq.a >= 32 && (vyVar = this.g) != null) {
                    Looper myLooper = Looper.myLooper();
                    af.t(myLooper);
                    vyVar.b(this, myLooper);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int a2 = wgVar.a();
        int a3 = wgVar.a();
        zo[] zoVarArr = new zo[a3];
        int i = 1;
        int i2 = 2;
        Pair s = s(2, wgVar, iArr4, new vq(vuVar, iArr2, 1), vp.c);
        if (s != null) {
            zoVarArr[((Integer) s.second).intValue()] = (zo) s.first;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= wgVar.a()) {
                z = false;
                break;
            }
            if (wgVar.b(i3) == 2 && wgVar.d(i3).b > 0) {
                z = true;
                break;
            }
            i3++;
        }
        Pair s2 = s(1, wgVar, iArr4, new vo(this, vuVar, z), vp.a);
        if (s2 != null) {
            zoVarArr[((Integer) s2.second).intValue()] = (zo) s2.first;
        }
        if (s2 == null) {
            str = null;
        } else {
            Object obj = s2.first;
            str = ((bf) ((zo) obj).b).b(((int[]) ((zo) obj).a)[0]).c;
        }
        int i4 = 3;
        Pair s3 = s(3, wgVar, iArr4, new vq(vuVar, str, 0), vp.d);
        if (s3 != null) {
            zoVarArr[((Integer) s3.second).intValue()] = (zo) s3.first;
        }
        int i5 = 0;
        while (i5 < a3) {
            int b2 = wgVar.b(i5);
            if (b2 != i2 && b2 != i && b2 != i4) {
                um d = wgVar.d(i5);
                int[][] iArr5 = iArr4[i5];
                bf bfVar2 = null;
                int i6 = 0;
                int i7 = 0;
                vs vsVar = null;
                while (i6 < d.b) {
                    bf b3 = d.b(i6);
                    int[] iArr6 = iArr5[i6];
                    vs vsVar2 = vsVar;
                    for (int i8 = 0; i8 < b3.a; i8++) {
                        if (j(iArr6[i8], vuVar.M)) {
                            bfVar = bfVar2;
                            vs vsVar3 = new vs(b3.b(i8), iArr6[i8]);
                            if (vsVar2 == null || vsVar3.compareTo(vsVar2) > 0) {
                                i7 = i8;
                                vsVar2 = vsVar3;
                                bfVar2 = b3;
                            }
                        } else {
                            bfVar = bfVar2;
                        }
                        bfVar2 = bfVar;
                    }
                    i6++;
                    vsVar = vsVar2;
                }
                zoVarArr[i5] = bfVar2 == null ? null : new zo(bfVar2, i7);
            }
            i5++;
            iArr4 = iArr;
            i = 1;
            i2 = 2;
            i4 = 3;
        }
        int a4 = wgVar.a();
        HashMap hashMap = new HashMap();
        for (int i9 = 0; i9 < a4; i9++) {
            r(wgVar.d(i9), vuVar);
        }
        r(wgVar.e(), vuVar);
        for (int i10 = 0; i10 < a4; i10++) {
            if (((bg) hashMap.get(Integer.valueOf(wgVar.b(i10)))) != null) {
                throw null;
            }
        }
        int a5 = wgVar.a();
        for (int i11 = 0; i11 < a5; i11++) {
            um d2 = wgVar.d(i11);
            if (vuVar.d(i11, d2)) {
                if (vuVar.b(i11, d2) != null) {
                    throw null;
                }
                zoVarArr[i11] = null;
            }
        }
        for (int i12 = 0; i12 < a2; i12++) {
            int b4 = wgVar.b(i12);
            if (vuVar.c(i12) || vuVar.A.contains(Integer.valueOf(b4))) {
                zoVarArr[i12] = null;
            }
        }
        vk vkVar = this.i;
        wq m = m();
        avo i13 = vl.i(zoVarArr);
        we[] weVarArr = new we[a3];
        for (int i14 = 0; i14 < a3; i14++) {
            zo zoVar = zoVarArr[i14];
            if (zoVar != null && (length = (iArr3 = (int[]) zoVar.a).length) != 0) {
                weVarArr[i14] = length == 1 ? new wf((bf) zoVar.b, iArr3[0]) : vkVar.a((bf) zoVar.b, iArr3, m, (avo) i13.get(i14));
            }
        }
        hj[] hjVarArr = new hj[a2];
        for (int i15 = 0; i15 < a2; i15++) {
            hjVarArr[i15] = (vuVar.c(i15) || vuVar.A.contains(Integer.valueOf(wgVar.b(i15))) || (wgVar.b(i15) != -2 && weVarArr[i15] == null)) ? null : hj.a;
        }
        return Pair.create(hjVarArr, weVarArr);
    }

    public wd(Context context) {
        this(vu.a(context), new vk(), context);
    }

    private wd(bi biVar, vk vkVar, Context context) {
        super(null);
        this.d = new Object();
        if (context != null) {
            context.getApplicationContext();
        }
        this.i = vkVar;
        this.f = (vu) biVar;
        this.h = f.a;
        boolean z = false;
        if (context != null && cq.ab(context)) {
            z = true;
        }
        this.e = z;
        if (!z && context != null && cq.a >= 32) {
            this.g = vy.a(context);
        }
        if (this.f.L && context == null) {
            cd.e("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
