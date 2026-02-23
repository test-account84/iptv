package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brv implements bsi {
    private static final int[] a = new int[0];
    private static final Unsafe b = btf.j();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final brs g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final brh o;
    private final bto p;
    private final bsr q;
    private final bsr r;
    private final bsr s;

    private brv(int[] iArr, Object[] objArr, int i, int i2, brs brsVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, bsr bsrVar, brh brhVar, bto btoVar, bsr bsrVar2, bsr bsrVar3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = brsVar instanceof bqn;
        this.j = z;
        this.h = bsrVar2 != null && bsr.q(brsVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.q = bsrVar;
        this.o = brhVar;
        this.p = btoVar;
        this.s = bsrVar2;
        this.g = brsVar;
        this.r = bsrVar3;
    }

    private final int A(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int s = s(i4);
            if (i == s) {
                return i4;
            }
            if (i < s) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int B(int i) {
        return (i >>> 20) & 255;
    }

    private final int C(int i) {
        return this.c[i + 1];
    }

    private static long D(int i) {
        return i & 1048575;
    }

    private static long E(Object obj, long j) {
        return ((Long) btf.h(obj, j)).longValue();
    }

    private final bqr F(int i) {
        int i2 = i / 3;
        return (bqr) this.d[i2 + i2 + 1];
    }

    private final bsi G(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        bsi bsiVar = (bsi) this.d[i3];
        if (bsiVar != null) {
            return bsiVar;
        }
        bsi b2 = bsa.a().b((Class) this.d[i3 + 1]);
        this.d[i3] = b2;
        return b2;
    }

    private final Object H(int i) {
        int i2 = i / 3;
        return this.d[i2 + i2];
    }

    private final Object I(Object obj, int i) {
        bsi G = G(i);
        long D = D(C(i));
        if (!Y(obj, i)) {
            return G.e();
        }
        Object object = b.getObject(obj, D);
        if (ab(object)) {
            return object;
        }
        Object e = G.e();
        if (object != null) {
            G.g(e, object);
        }
        return e;
    }

    private final Object J(Object obj, int i, int i2) {
        bsi G = G(i2);
        if (!ac(obj, i, i2)) {
            return G.e();
        }
        Object object = b.getObject(obj, D(C(i2)));
        if (ab(object)) {
            return object;
        }
        Object e = G.e();
        if (object != null) {
            G.g(e, object);
        }
        return e;
    }

    private static Field K(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static List L(Object obj, long j) {
        return (List) btf.h(obj, j);
    }

    private static void M(Object obj) {
        if (!ab(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void N(Object obj, Object obj2, int i) {
        if (Y(obj2, i)) {
            long D = D(C(i));
            Unsafe unsafe = b;
            Object object = unsafe.getObject(obj2, D);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + s(i) + " is present but null: " + obj2.toString());
            }
            bsi G = G(i);
            if (!Y(obj, i)) {
                if (ab(object)) {
                    Object e = G.e();
                    G.g(e, object);
                    unsafe.putObject(obj, D, e);
                } else {
                    unsafe.putObject(obj, D, object);
                }
                Q(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, D);
            if (!ab(object2)) {
                Object e2 = G.e();
                G.g(e2, object2);
                unsafe.putObject(obj, D, e2);
                object2 = e2;
            }
            G.g(object2, object);
        }
    }

    private final void O(Object obj, Object obj2, int i) {
        int s = s(i);
        if (ac(obj2, s, i)) {
            long D = D(C(i));
            Unsafe unsafe = b;
            Object object = unsafe.getObject(obj2, D);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + s(i) + " is present but null: " + obj2.toString());
            }
            bsi G = G(i);
            if (!ac(obj, s, i)) {
                if (ab(object)) {
                    Object e = G.e();
                    G.g(e, object);
                    unsafe.putObject(obj, D, e);
                } else {
                    unsafe.putObject(obj, D, object);
                }
                R(obj, s, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, D);
            if (!ab(object2)) {
                Object e2 = G.e();
                G.g(e2, object2);
                unsafe.putObject(obj, D, e2);
                object2 = e2;
            }
            G.g(object2, object);
        }
    }

    private final void P(Object obj, int i, bsd bsdVar) throws IOException {
        long D;
        String p;
        if (X(i)) {
            D = D(i);
            p = bsdVar.u();
        } else if (this.i) {
            D = D(i);
            p = bsdVar.t();
        } else {
            D = D(i);
            p = bsdVar.p();
        }
        btf.w(obj, D, p);
    }

    private final void Q(Object obj, int i) {
        int z = z(i);
        long j = 1048575 & z;
        if (j == 1048575) {
            return;
        }
        btf.u(obj, j, (1 << (z >>> 20)) | btf.d(obj, j));
    }

    private final void R(Object obj, int i, int i2) {
        btf.u(obj, z(i2) & 1048575, i);
    }

    private final void S(Object obj, int i, Object obj2) {
        b.putObject(obj, D(C(i)), obj2);
        Q(obj, i);
    }

    private final void T(Object obj, int i, int i2, Object obj2) {
        b.putObject(obj, D(C(i2)), obj2);
        R(obj, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void U(java.lang.Object r18, com.google.ads.interactivemedia.v3.internal.btn r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.U(java.lang.Object, com.google.ads.interactivemedia.v3.internal.btn):void");
    }

    private final void V(btn btnVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            btnVar.v(i, bsr.c(H(i2)), bsr.b(obj));
        }
    }

    private final boolean W(Object obj, Object obj2, int i) {
        return Y(obj, i) == Y(obj2, i);
    }

    private static boolean X(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean Y(Object obj, int i) {
        int z = z(i);
        long j = 1048575 & z;
        if (j != 1048575) {
            return (btf.d(obj, j) & (1 << (z >>> 20))) != 0;
        }
        int C = C(i);
        long D = D(C);
        switch (B(C)) {
            case 0:
                return Double.doubleToRawLongBits(btf.b(obj, D)) != 0;
            case 1:
                return Float.floatToRawIntBits(btf.c(obj, D)) != 0;
            case 2:
                return btf.f(obj, D) != 0;
            case 3:
                return btf.f(obj, D) != 0;
            case 4:
                return btf.d(obj, D) != 0;
            case 5:
                return btf.f(obj, D) != 0;
            case 6:
                return btf.d(obj, D) != 0;
            case 7:
                return btf.A(obj, D);
            case 8:
                Object h = btf.h(obj, D);
                if (h instanceof String) {
                    return !((String) h).isEmpty();
                }
                if (h instanceof bpb) {
                    return !bpb.b.equals(h);
                }
                throw new IllegalArgumentException();
            case 9:
                return btf.h(obj, D) != null;
            case 10:
                return !bpb.b.equals(btf.h(obj, D));
            case 11:
                return btf.d(obj, D) != 0;
            case 12:
                return btf.d(obj, D) != 0;
            case 13:
                return btf.d(obj, D) != 0;
            case 14:
                return btf.f(obj, D) != 0;
            case 15:
                return btf.d(obj, D) != 0;
            case 16:
                return btf.f(obj, D) != 0;
            case 17:
                return btf.h(obj, D) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean Z(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? Y(obj, i) : (i3 & i4) != 0;
    }

    private static boolean aa(Object obj, int i, bsi bsiVar) {
        return bsiVar.l(btf.h(obj, D(i)));
    }

    private static boolean ab(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof bqn) {
            return ((bqn) obj).aO();
        }
        return true;
    }

    private final boolean ac(Object obj, int i, int i2) {
        return btf.d(obj, (long) (z(i2) & 1048575)) == i;
    }

    private static boolean ad(Object obj, long j) {
        return ((Boolean) btf.h(obj, j)).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0243, code lost:
    
        if (r0 != r31) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0245, code lost:
    
        r15 = r28;
        r14 = r29;
        r12 = r30;
        r13 = r32;
        r11 = r33;
        r1 = r18;
        r2 = r22;
        r6 = r25;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x025c, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0294, code lost:
    
        if (r0 != r15) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02b1, code lost:
    
        if (r0 != r15) goto L97;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0087. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ae(java.lang.Object r29, byte[] r30, int r31, int r32, com.google.ads.interactivemedia.v3.internal.boq r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.ae(java.lang.Object, byte[], int, int, com.google.ads.interactivemedia.v3.internal.boq):void");
    }

    private static final void af(int i, Object obj, btn btnVar) throws IOException {
        if (obj instanceof String) {
            btnVar.H(i, (String) obj);
        } else {
            btnVar.d(i, (bpb) obj);
        }
    }

    private final Object ag(Object obj, int i, Object obj2, bto btoVar, Object obj3) {
        bqr F;
        int s = s(i);
        Object h = btf.h(obj, D(C(i)));
        if (h == null || (F = F(i)) == null) {
            return obj2;
        }
        Map d = bsr.d(h);
        brm c = bsr.c(H(i));
        Iterator it = d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!F.a(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = btoVar.i(obj3);
                }
                int j = bsr.j(c, entry.getKey(), entry.getValue());
                bpb bpbVar = bpb.b;
                byte[] bArr = new byte[j];
                bpk X = bpk.X(bArr);
                try {
                    bsr.k(bpd.b(X), c, entry.getKey(), entry.getValue());
                    bto.q(obj2, s, bpd.a(X, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static final int ah(bto btoVar, Object obj) {
        return bto.t(btoVar.j(obj));
    }

    private static final void ai(bto btoVar, Object obj, btn btnVar) throws IOException {
        bto.A(btoVar.j(obj), btnVar);
    }

    public static bsx d(Object obj) {
        bqn bqnVar = (bqn) obj;
        bsx bsxVar = bqnVar.c;
        if (bsxVar != bsx.c()) {
            return bsxVar;
        }
        bsx e = bsx.e();
        bqnVar.c = e;
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0264  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.v3.internal.brv m(com.google.ads.interactivemedia.v3.internal.bsc r34, com.google.ads.interactivemedia.v3.internal.bsr r35, com.google.ads.interactivemedia.v3.internal.brh r36, com.google.ads.interactivemedia.v3.internal.bto r37, com.google.ads.interactivemedia.v3.internal.bsr r38, com.google.ads.interactivemedia.v3.internal.bsr r39) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.m(com.google.ads.interactivemedia.v3.internal.bsc, com.google.ads.interactivemedia.v3.internal.bsr, com.google.ads.interactivemedia.v3.internal.brh, com.google.ads.interactivemedia.v3.internal.bto, com.google.ads.interactivemedia.v3.internal.bsr, com.google.ads.interactivemedia.v3.internal.bsr):com.google.ads.interactivemedia.v3.internal.brv");
    }

    public static brv n(brp brpVar, bsr bsrVar, brh brhVar, bto btoVar, bsr bsrVar2, bsr bsrVar3) {
        if (brpVar instanceof bsc) {
            return m((bsc) brpVar, bsrVar, brhVar, btoVar, bsrVar2, bsrVar3);
        }
        throw null;
    }

    private static double o(Object obj, long j) {
        return ((Double) btf.h(obj, j)).doubleValue();
    }

    private static float p(Object obj, long j) {
        return ((Float) btf.h(obj, j)).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x017a A[PHI: r7
      0x017a: PHI (r7v104 int) = 
      (r7v67 int)
      (r7v70 int)
      (r7v73 int)
      (r7v76 int)
      (r7v79 int)
      (r7v82 int)
      (r7v85 int)
      (r7v88 int)
      (r7v91 int)
      (r7v94 int)
      (r7v97 int)
      (r7v100 int)
      (r7v103 int)
      (r7v107 int)
     binds: [B:141:0x0231, B:138:0x0223, B:135:0x0215, B:132:0x0207, B:129:0x01f9, B:126:0x01ec, B:123:0x01df, B:120:0x01d2, B:117:0x01c5, B:114:0x01b8, B:111:0x01ab, B:108:0x019e, B:105:0x0191, B:100:0x0178] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4 A[PHI: r7
      0x00b4: PHI (r7v138 java.lang.Object) = (r7v13 java.lang.Object), (r7v134 java.lang.Object), (r7v141 java.lang.Object) binds: [B:190:0x0325, B:58:0x00da, B:48:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dd A[PHI: r7
      0x00dd: PHI (r7v130 java.lang.Object) = (r7v13 java.lang.Object), (r7v134 java.lang.Object) binds: [B:190:0x0325, B:58:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int q(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 1104
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.q(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016b A[PHI: r3
      0x016b: PHI (r3v96 int) = 
      (r3v59 int)
      (r3v62 int)
      (r3v65 int)
      (r3v68 int)
      (r3v71 int)
      (r3v74 int)
      (r3v77 int)
      (r3v80 int)
      (r3v83 int)
      (r3v86 int)
      (r3v89 int)
      (r3v92 int)
      (r3v95 int)
      (r3v99 int)
     binds: [B:140:0x0222, B:137:0x0214, B:134:0x0206, B:131:0x01f8, B:128:0x01ea, B:125:0x01dd, B:122:0x01d0, B:119:0x01c3, B:116:0x01b6, B:113:0x01a9, B:110:0x019c, B:107:0x018f, B:104:0x0182, B:99:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7 A[PHI: r3
      0x00a7: PHI (r3v133 java.lang.Object) = (r3v17 java.lang.Object), (r3v129 java.lang.Object), (r3v136 java.lang.Object) binds: [B:189:0x0310, B:57:0x00cd, B:47:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d0 A[PHI: r3
      0x00d0: PHI (r3v125 java.lang.Object) = (r3v17 java.lang.Object), (r3v129 java.lang.Object) binds: [B:189:0x0310, B:57:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int r(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.r(java.lang.Object):int");
    }

    private final int s(int i) {
        return this.c[i];
    }

    private static int t(Object obj, long j) {
        return ((Integer) btf.h(obj, j)).intValue();
    }

    private final int u(Object obj, byte[] bArr, int i, int i2, int i3, long j, boq boqVar) throws IOException {
        Unsafe unsafe = b;
        Object H = H(i3);
        Object object = unsafe.getObject(obj, j);
        if (bsr.f(object)) {
            Object h = bsr.h();
            bsr.g(h, object);
            unsafe.putObject(obj, j, h);
            object = h;
        }
        brm c = bsr.c(H);
        Map d = bsr.d(object);
        int n = bpd.n(bArr, i, boqVar);
        int i4 = boqVar.a;
        if (i4 < 0 || i4 > i2 - n) {
            throw bqw.i();
        }
        int i5 = i4 + n;
        Object obj2 = c.b;
        while (n < i5) {
            int i6 = n + 1;
            int i7 = bArr[n];
            if (i7 < 0) {
                i6 = bpd.o(i7, bArr, i6, boqVar);
                i7 = boqVar.a;
            }
            int i8 = i7 >>> 3;
            if (i8 == 1) {
                throw null;
            }
            if (i8 == 2) {
                throw null;
            }
            n = bpd.t(i7, bArr, i6, i2, boqVar);
        }
        if (n != i5) {
            throw bqw.g();
        }
        d.put((Object) null, (Object) null);
        return i5;
    }

    private final int v(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, boq boqVar) throws IOException {
        Unsafe unsafe = b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(bpd.c(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(bpd.d(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int q = bpd.q(bArr, i, boqVar);
                    unsafe.putObject(obj, j, Long.valueOf(boqVar.b));
                    unsafe.putInt(obj, j2, i4);
                    return q;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int n = bpd.n(bArr, i, boqVar);
                    unsafe.putObject(obj, j, Integer.valueOf(boqVar.a));
                    unsafe.putInt(obj, j2, i4);
                    return n;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(bpd.u(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(bpd.f(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int q2 = bpd.q(bArr, i, boqVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(boqVar.b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return q2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int n2 = bpd.n(bArr, i, boqVar);
                    int i9 = boqVar.a;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !btj.j(bArr, n2, n2 + i9)) {
                            throw bqw.d();
                        }
                        unsafe.putObject(obj, j, new String(bArr, n2, i9, bqu.a));
                        n2 += i9;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return n2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object J = J(obj, i4, i8);
                    int s = bpd.s(J, G(i8), bArr, i, i2, boqVar);
                    T(obj, i4, i8, J);
                    return s;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int e = bpd.e(bArr, i, boqVar);
                    unsafe.putObject(obj, j, boqVar.c);
                    unsafe.putInt(obj, j2, i4);
                    return e;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int n3 = bpd.n(bArr, i, boqVar);
                    int i10 = boqVar.a;
                    bqr F = F(i8);
                    if (F == null || F.a(i10)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i10));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        d(obj).i(i3, Long.valueOf(i10));
                    }
                    return n3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int n4 = bpd.n(bArr, i, boqVar);
                    unsafe.putObject(obj, j, Integer.valueOf(bpg.F(boqVar.a)));
                    unsafe.putInt(obj, j2, i4);
                    return n4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int q3 = bpd.q(bArr, i, boqVar);
                    unsafe.putObject(obj, j, Long.valueOf(bpg.G(boqVar.b)));
                    unsafe.putInt(obj, j2, i4);
                    return q3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    Object J2 = J(obj, i4, i8);
                    int r = bpd.r(J2, G(i8), bArr, i, i2, (i3 & (-8)) | 4, boqVar);
                    T(obj, i4, i8, J2);
                    return r;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x0269, code lost:
    
        if (r29.b != 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x026b, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x026e, code lost:
    
        r12.e(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0271, code lost:
    
        if (r4 >= r19) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0273, code lost:
    
        r6 = com.google.ads.interactivemedia.v3.internal.bpd.n(r17, r4, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0279, code lost:
    
        if (r20 == r29.a) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x027c, code lost:
    
        r4 = com.google.ads.interactivemedia.v3.internal.bpd.q(r17, r6, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0284, code lost:
    
        if (r29.b == 0) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x026d, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0287, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x026e, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0136, code lost:
    
        if (r4 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0138, code lost:
    
        r12.add(com.google.ads.interactivemedia.v3.internal.bpb.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0146, code lost:
    
        if (r1 >= r19) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0148, code lost:
    
        r4 = com.google.ads.interactivemedia.v3.internal.bpd.n(r17, r1, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014e, code lost:
    
        if (r20 == r29.a) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0151, code lost:
    
        r1 = com.google.ads.interactivemedia.v3.internal.bpd.n(r17, r4, r29);
        r4 = r29.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0157, code lost:
    
        if (r4 < 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015b, code lost:
    
        if (r4 > (r17.length - r1)) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015d, code lost:
    
        if (r4 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013e, code lost:
    
        r12.add(com.google.ads.interactivemedia.v3.internal.bpb.u(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0164, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.bqw.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0169, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.bqw.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x016a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0146, code lost:
    
        r12.add(com.google.ads.interactivemedia.v3.internal.bpb.u(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01fe  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x020e -> B:107:0x01e5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x0284 -> B:144:0x026b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x015d -> B:62:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01c7 -> B:90:0x01a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int w(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.ads.interactivemedia.v3.internal.boq r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.w(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.ads.interactivemedia.v3.internal.boq):int");
    }

    private final int x(int i) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return A(i, 0);
    }

    private final int y(int i, int i2) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return A(i, i2);
    }

    private final int z(int i) {
        return this.c[i + 2];
    }

    public final int a(Object obj) {
        return this.j ? r(obj) : q(obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ec A[PHI: r3
      0x00ec: PHI (r3v8 java.lang.Object) = (r3v5 java.lang.Object), (r3v9 java.lang.Object) binds: [B:81:0x0108, B:74:0x00ea] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.b(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0585, code lost:
    
        if (r0 == r1) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0587, code lost:
    
        r30.putInt(r12, r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x058d, code lost:
    
        r10 = r9.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0592, code lost:
    
        if (r10 >= r9.n) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0594, code lost:
    
        r3 = ag(r33, r9.l[r10], r3, r9.p, r33);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x05a7, code lost:
    
        if (r3 == null) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x05a9, code lost:
    
        r9.p.l(r12, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x05ae, code lost:
    
        if (r7 != 0) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x05b0, code lost:
    
        if (r15 != r6) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x05b7, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.bqw.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x05bc, code lost:
    
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x05b8, code lost:
    
        if (r15 > r6) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x05ba, code lost:
    
        if (r8 != r7) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x05c1, code lost:
    
        throw com.google.ads.interactivemedia.v3.internal.bqw.g();
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0533  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.ads.interactivemedia.v3.internal.boq r38) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.c(java.lang.Object, byte[], int, int, int, com.google.ads.interactivemedia.v3.internal.boq):int");
    }

    public final Object e() {
        return bsr.a(this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = ab(r7)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r7 instanceof com.google.ads.interactivemedia.v3.internal.bqn
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r7
            com.google.ads.interactivemedia.v3.internal.bqn r0 = (com.google.ads.interactivemedia.v3.internal.bqn) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.aM(r2)
            r0.b = r1
            r0.aK()
        L1a:
            int[] r0 = r6.c
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L5e
            int r2 = r6.C(r1)
            long r3 = D(r2)
            int r2 = B(r2)
            r5 = 9
            if (r2 == r5) goto L48
            switch(r2) {
                case 17: goto L48;
                case 18: goto L42;
                case 19: goto L42;
                case 20: goto L42;
                case 21: goto L42;
                case 22: goto L42;
                case 23: goto L42;
                case 24: goto L42;
                case 25: goto L42;
                case 26: goto L42;
                case 27: goto L42;
                case 28: goto L42;
                case 29: goto L42;
                case 30: goto L42;
                case 31: goto L42;
                case 32: goto L42;
                case 33: goto L42;
                case 34: goto L42;
                case 35: goto L42;
                case 36: goto L42;
                case 37: goto L42;
                case 38: goto L42;
                case 39: goto L42;
                case 40: goto L42;
                case 41: goto L42;
                case 42: goto L42;
                case 43: goto L42;
                case 44: goto L42;
                case 45: goto L42;
                case 46: goto L42;
                case 47: goto L42;
                case 48: goto L42;
                case 49: goto L42;
                case 50: goto L33;
                default: goto L32;
            }
        L32:
            goto L5b
        L33:
            sun.misc.Unsafe r2 = com.google.ads.interactivemedia.v3.internal.brv.b
            java.lang.Object r5 = r2.getObject(r7, r3)
            if (r5 == 0) goto L5b
            com.google.ads.interactivemedia.v3.internal.bsr.i(r5)
            r2.putObject(r7, r3, r5)
            goto L5b
        L42:
            com.google.ads.interactivemedia.v3.internal.brh r2 = r6.o
            r2.c(r7, r3)
            goto L5b
        L48:
            boolean r2 = r6.Y(r7, r1)
            if (r2 == 0) goto L5b
            com.google.ads.interactivemedia.v3.internal.bsi r2 = r6.G(r1)
            sun.misc.Unsafe r5 = com.google.ads.interactivemedia.v3.internal.brv.b
            java.lang.Object r3 = r5.getObject(r7, r3)
            r2.f(r3)
        L5b:
            int r1 = r1 + 3
            goto L1d
        L5e:
            com.google.ads.interactivemedia.v3.internal.bto r0 = r6.p
            r0.k(r7)
            boolean r0 = r6.h
            if (r0 == 0) goto L6c
            com.google.ads.interactivemedia.v3.internal.bsr r0 = r6.s
            r0.l(r7)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.f(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.g(java.lang.Object, java.lang.Object):void");
    }

    public final void h(Object obj, bsd bsdVar, bqb bqbVar) throws IOException {
        brs brsVar;
        int e;
        List b2;
        List b3;
        List b4;
        List b5;
        List b6;
        List b7;
        List b8;
        List b9;
        List b10;
        List b11;
        bqr F;
        List b12;
        List b13;
        List b14;
        List b15;
        brs brsVar2;
        bqbVar.getClass();
        M(obj);
        bto btoVar = this.p;
        bqe bqeVar = null;
        Object obj2 = null;
        while (true) {
            try {
                int c = bsdVar.c();
                int x = x(c);
                if (x >= 0) {
                    int C = C(x);
                    try {
                        switch (B(C)) {
                            case 0:
                                btf.s(obj, D(C), bsdVar.a());
                                Q(obj, x);
                                break;
                            case 1:
                                btf.t(obj, D(C), bsdVar.b());
                                Q(obj, x);
                                break;
                            case 2:
                                btf.v(obj, D(C), bsdVar.l());
                                Q(obj, x);
                                break;
                            case 3:
                                btf.v(obj, D(C), bsdVar.o());
                                Q(obj, x);
                                break;
                            case 4:
                                btf.u(obj, D(C), bsdVar.g());
                                Q(obj, x);
                                break;
                            case 5:
                                btf.v(obj, D(C), bsdVar.k());
                                Q(obj, x);
                                break;
                            case 6:
                                btf.u(obj, D(C), bsdVar.f());
                                Q(obj, x);
                                break;
                            case 7:
                                btf.q(obj, D(C), bsdVar.P());
                                Q(obj, x);
                                break;
                            case 8:
                                P(obj, C, bsdVar);
                                Q(obj, x);
                                break;
                            case 9:
                                brsVar = (brs) I(obj, x);
                                bsdVar.w(brsVar, G(x), bqbVar);
                                S(obj, x, brsVar);
                                break;
                            case 10:
                                btf.w(obj, D(C), bsdVar.p());
                                Q(obj, x);
                                break;
                            case 11:
                                btf.u(obj, D(C), bsdVar.j());
                                Q(obj, x);
                                break;
                            case 12:
                                e = bsdVar.e();
                                bqr F2 = F(x);
                                if (F2 != null && !F2.a(e)) {
                                    obj2 = bsk.X(obj, c, e, obj2, btoVar);
                                    break;
                                } else {
                                    btf.u(obj, D(C), e);
                                    Q(obj, x);
                                    break;
                                }
                            case 13:
                                btf.u(obj, D(C), bsdVar.h());
                                Q(obj, x);
                                break;
                            case 14:
                                btf.v(obj, D(C), bsdVar.m());
                                Q(obj, x);
                                break;
                            case 15:
                                btf.u(obj, D(C), bsdVar.i());
                                Q(obj, x);
                                break;
                            case 16:
                                btf.v(obj, D(C), bsdVar.n());
                                Q(obj, x);
                                break;
                            case 17:
                                brsVar = (brs) I(obj, x);
                                bsdVar.v(brsVar, G(x), bqbVar);
                                S(obj, x, brsVar);
                                break;
                            case 18:
                                b2 = this.o.b(obj, D(C));
                                bsdVar.z(b2);
                                break;
                            case 19:
                                b3 = this.o.b(obj, D(C));
                                bsdVar.D(b3);
                                break;
                            case 20:
                                b4 = this.o.b(obj, D(C));
                                bsdVar.G(b4);
                                break;
                            case 21:
                                b5 = this.o.b(obj, D(C));
                                bsdVar.O(b5);
                                break;
                            case 22:
                                b6 = this.o.b(obj, D(C));
                                bsdVar.F(b6);
                                break;
                            case 23:
                                b7 = this.o.b(obj, D(C));
                                bsdVar.C(b7);
                                break;
                            case 24:
                                b8 = this.o.b(obj, D(C));
                                bsdVar.B(b8);
                                break;
                            case 25:
                                b9 = this.o.b(obj, D(C));
                                bsdVar.x(b9);
                                break;
                            case 26:
                                if (X(C)) {
                                    ((bpi) bsdVar).M(this.o.b(obj, D(C)), true);
                                    break;
                                } else {
                                    ((bpi) bsdVar).M(this.o.b(obj, D(C)), false);
                                    break;
                                }
                            case 27:
                                bsdVar.H(this.o.b(obj, D(C)), G(x), bqbVar);
                                break;
                            case 28:
                                bsdVar.y(this.o.b(obj, D(C)));
                                break;
                            case 29:
                                b10 = this.o.b(obj, D(C));
                                bsdVar.N(b10);
                                break;
                            case 30:
                                b11 = this.o.b(obj, D(C));
                                bsdVar.A(b11);
                                F = F(x);
                                obj2 = bsk.W(obj, c, b11, F, obj2, btoVar);
                                break;
                            case 31:
                                b12 = this.o.b(obj, D(C));
                                bsdVar.I(b12);
                                break;
                            case 32:
                                b13 = this.o.b(obj, D(C));
                                bsdVar.J(b13);
                                break;
                            case 33:
                                b14 = this.o.b(obj, D(C));
                                bsdVar.K(b14);
                                break;
                            case 34:
                                b15 = this.o.b(obj, D(C));
                                bsdVar.L(b15);
                                break;
                            case 35:
                                b2 = this.o.b(obj, D(C));
                                bsdVar.z(b2);
                                break;
                            case 36:
                                b3 = this.o.b(obj, D(C));
                                bsdVar.D(b3);
                                break;
                            case 37:
                                b4 = this.o.b(obj, D(C));
                                bsdVar.G(b4);
                                break;
                            case 38:
                                b5 = this.o.b(obj, D(C));
                                bsdVar.O(b5);
                                break;
                            case 39:
                                b6 = this.o.b(obj, D(C));
                                bsdVar.F(b6);
                                break;
                            case 40:
                                b7 = this.o.b(obj, D(C));
                                bsdVar.C(b7);
                                break;
                            case 41:
                                b8 = this.o.b(obj, D(C));
                                bsdVar.B(b8);
                                break;
                            case 42:
                                b9 = this.o.b(obj, D(C));
                                bsdVar.x(b9);
                                break;
                            case 43:
                                b10 = this.o.b(obj, D(C));
                                bsdVar.N(b10);
                                break;
                            case 44:
                                b11 = this.o.b(obj, D(C));
                                bsdVar.A(b11);
                                F = F(x);
                                obj2 = bsk.W(obj, c, b11, F, obj2, btoVar);
                                break;
                            case 45:
                                b12 = this.o.b(obj, D(C));
                                bsdVar.I(b12);
                                break;
                            case 46:
                                b13 = this.o.b(obj, D(C));
                                bsdVar.J(b13);
                                break;
                            case 47:
                                b14 = this.o.b(obj, D(C));
                                bsdVar.K(b14);
                                break;
                            case 48:
                                b15 = this.o.b(obj, D(C));
                                bsdVar.L(b15);
                                break;
                            case 49:
                                bsdVar.E(this.o.b(obj, D(C)), G(x), bqbVar);
                                break;
                            case 50:
                                Object H = H(x);
                                long D = D(C(x));
                                Object h = btf.h(obj, D);
                                if (h == null) {
                                    h = bsr.h();
                                    btf.w(obj, D, h);
                                } else if (bsr.f(h)) {
                                    Object h2 = bsr.h();
                                    bsr.g(h2, h);
                                    btf.w(obj, D, h2);
                                    h = h2;
                                }
                                bsdVar.R(bsr.d(h), bsr.c(H));
                                break;
                            case 51:
                                btf.w(obj, D(C), Double.valueOf(bsdVar.a()));
                                R(obj, c, x);
                                break;
                            case 52:
                                btf.w(obj, D(C), Float.valueOf(bsdVar.b()));
                                R(obj, c, x);
                                break;
                            case 53:
                                btf.w(obj, D(C), Long.valueOf(bsdVar.l()));
                                R(obj, c, x);
                                break;
                            case 54:
                                btf.w(obj, D(C), Long.valueOf(bsdVar.o()));
                                R(obj, c, x);
                                break;
                            case 55:
                                btf.w(obj, D(C), Integer.valueOf(bsdVar.g()));
                                R(obj, c, x);
                                break;
                            case 56:
                                btf.w(obj, D(C), Long.valueOf(bsdVar.k()));
                                R(obj, c, x);
                                break;
                            case 57:
                                btf.w(obj, D(C), Integer.valueOf(bsdVar.f()));
                                R(obj, c, x);
                                break;
                            case 58:
                                btf.w(obj, D(C), Boolean.valueOf(bsdVar.P()));
                                R(obj, c, x);
                                break;
                            case 59:
                                P(obj, C, bsdVar);
                                R(obj, c, x);
                                break;
                            case 60:
                                brsVar2 = (brs) J(obj, c, x);
                                bsdVar.w(brsVar2, G(x), bqbVar);
                                T(obj, c, x, brsVar2);
                                break;
                            case 61:
                                btf.w(obj, D(C), bsdVar.p());
                                R(obj, c, x);
                                break;
                            case 62:
                                btf.w(obj, D(C), Integer.valueOf(bsdVar.j()));
                                R(obj, c, x);
                                break;
                            case 63:
                                e = bsdVar.e();
                                bqr F3 = F(x);
                                if (F3 != null && !F3.a(e)) {
                                    obj2 = bsk.X(obj, c, e, obj2, btoVar);
                                    break;
                                }
                                btf.w(obj, D(C), Integer.valueOf(e));
                                R(obj, c, x);
                                break;
                            case 64:
                                btf.w(obj, D(C), Integer.valueOf(bsdVar.h()));
                                R(obj, c, x);
                                break;
                            case 65:
                                btf.w(obj, D(C), Long.valueOf(bsdVar.m()));
                                R(obj, c, x);
                                break;
                            case 66:
                                btf.w(obj, D(C), Integer.valueOf(bsdVar.i()));
                                R(obj, c, x);
                                break;
                            case 67:
                                btf.w(obj, D(C), Long.valueOf(bsdVar.n()));
                                R(obj, c, x);
                                break;
                            case 68:
                                brsVar2 = (brs) J(obj, c, x);
                                bsdVar.v(brsVar2, G(x), bqbVar);
                                T(obj, c, x, brsVar2);
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = btoVar.i(obj);
                                }
                                if (!btoVar.h(obj2, bsdVar)) {
                                    Object obj3 = obj2;
                                    for (int i = this.m; i < this.n; i++) {
                                        obj3 = ag(obj, this.l[i], obj3, btoVar, obj);
                                    }
                                    if (obj3 != null) {
                                        btoVar.l(obj, obj3);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    } catch (bqv unused) {
                        if (obj2 == null) {
                            obj2 = btoVar.i(obj);
                        }
                        if (!btoVar.h(obj2, bsdVar)) {
                            Object obj4 = obj2;
                            for (int i2 = this.m; i2 < this.n; i2++) {
                                obj4 = ag(obj, this.l[i2], obj4, btoVar, obj);
                            }
                            if (obj4 != null) {
                                btoVar.l(obj, obj4);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    if (c == Integer.MAX_VALUE) {
                        Object obj5 = obj2;
                        for (int i3 = this.m; i3 < this.n; i3++) {
                            obj5 = ag(obj, this.l[i3], obj5, btoVar, obj);
                        }
                        if (obj5 != null) {
                            btoVar.l(obj, obj5);
                            return;
                        }
                        return;
                    }
                    Object n = !this.h ? null : bsr.n(bqbVar, this.g, c);
                    if (n != null) {
                        bqe p = bqeVar == null ? bsr.p(obj) : bqeVar;
                        obj2 = bsr.u(obj, bsdVar, n, bqbVar, p, obj2, btoVar);
                        bqeVar = p;
                    } else {
                        if (obj2 == null) {
                            obj2 = btoVar.i(obj);
                        }
                        if (!btoVar.h(obj2, bsdVar)) {
                            Object obj6 = obj2;
                            for (int i4 = this.m; i4 < this.n; i4++) {
                                obj6 = ag(obj, this.l[i4], obj6, btoVar, obj);
                            }
                            if (obj6 != null) {
                                btoVar.l(obj, obj6);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Object obj7 = obj2;
                for (int i5 = this.m; i5 < this.n; i5++) {
                    obj7 = ag(obj, this.l[i5], obj7, btoVar, obj);
                }
                if (obj7 != null) {
                    btoVar.l(obj, obj7);
                }
                throw th;
            }
        }
    }

    public final void i(Object obj, byte[] bArr, int i, int i2, boq boqVar) throws IOException {
        if (this.j) {
            ae(obj, bArr, i, i2, boqVar);
        } else {
            c(obj, bArr, i, i2, 0, boqVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:282:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(java.lang.Object r13, com.google.ads.interactivemedia.v3.internal.btn r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.j(java.lang.Object, com.google.ads.interactivemedia.v3.internal.btn):void");
    }

    public final boolean k(Object obj, Object obj2) {
        int length = this.c.length;
        for (int i = 0; i < length; i += 3) {
            int C = C(i);
            long D = D(C);
            switch (B(C)) {
                case 0:
                    if (W(obj, obj2, i) && Double.doubleToLongBits(btf.b(obj, D)) == Double.doubleToLongBits(btf.b(obj2, D))) {
                        break;
                    }
                    return false;
                case 1:
                    if (W(obj, obj2, i) && Float.floatToIntBits(btf.c(obj, D)) == Float.floatToIntBits(btf.c(obj2, D))) {
                        break;
                    }
                    return false;
                case 2:
                    if (W(obj, obj2, i) && btf.f(obj, D) == btf.f(obj2, D)) {
                        break;
                    }
                    return false;
                case 3:
                    if (W(obj, obj2, i) && btf.f(obj, D) == btf.f(obj2, D)) {
                        break;
                    }
                    return false;
                case 4:
                    if (W(obj, obj2, i) && btf.d(obj, D) == btf.d(obj2, D)) {
                        break;
                    }
                    return false;
                case 5:
                    if (W(obj, obj2, i) && btf.f(obj, D) == btf.f(obj2, D)) {
                        break;
                    }
                    return false;
                case 6:
                    if (W(obj, obj2, i) && btf.d(obj, D) == btf.d(obj2, D)) {
                        break;
                    }
                    return false;
                case 7:
                    if (W(obj, obj2, i) && btf.A(obj, D) == btf.A(obj2, D)) {
                        break;
                    }
                    return false;
                case 8:
                    if (W(obj, obj2, i) && bsk.I(btf.h(obj, D), btf.h(obj2, D))) {
                        break;
                    }
                    return false;
                case 9:
                    if (W(obj, obj2, i) && bsk.I(btf.h(obj, D), btf.h(obj2, D))) {
                        break;
                    }
                    return false;
                case 10:
                    if (W(obj, obj2, i) && bsk.I(btf.h(obj, D), btf.h(obj2, D))) {
                        break;
                    }
                    return false;
                case 11:
                    if (W(obj, obj2, i) && btf.d(obj, D) == btf.d(obj2, D)) {
                        break;
                    }
                    return false;
                case 12:
                    if (W(obj, obj2, i) && btf.d(obj, D) == btf.d(obj2, D)) {
                        break;
                    }
                    return false;
                case 13:
                    if (W(obj, obj2, i) && btf.d(obj, D) == btf.d(obj2, D)) {
                        break;
                    }
                    return false;
                case 14:
                    if (W(obj, obj2, i) && btf.f(obj, D) == btf.f(obj2, D)) {
                        break;
                    }
                    return false;
                case 15:
                    if (W(obj, obj2, i) && btf.d(obj, D) == btf.d(obj2, D)) {
                        break;
                    }
                    return false;
                case 16:
                    if (W(obj, obj2, i) && btf.f(obj, D) == btf.f(obj2, D)) {
                        break;
                    }
                    return false;
                case 17:
                    if (W(obj, obj2, i) && bsk.I(btf.h(obj, D), btf.h(obj2, D))) {
                        break;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    if (!bsk.I(btf.h(obj, D), btf.h(obj2, D))) {
                        return false;
                    }
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long z = z(i) & 1048575;
                    if (btf.d(obj, z) == btf.d(obj2, z) && bsk.I(btf.h(obj, D), btf.h(obj2, D))) {
                        break;
                    }
                    return false;
            }
        }
        if (!this.p.j(obj).equals(this.p.j(obj2))) {
            return false;
        }
        if (this.h) {
            return bsr.o(obj).equals(bsr.o(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean l(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brv.l(java.lang.Object):boolean");
    }
}
