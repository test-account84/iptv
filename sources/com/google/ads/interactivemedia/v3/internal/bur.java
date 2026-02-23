package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bur {
    private static final ThreadLocal a = new ThreadLocal();
    private final List c;
    private boolean b = true;
    private String[] d = null;

    public bur() {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(String.class);
    }

    public static Set a() {
        return (Set) a.get();
    }

    public static bux b(Object obj, Object obj2) {
        return bux.c(new buv(obj), new buv(obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.Object r5, java.lang.Object r6, java.lang.String... r7) {
        /*
            if (r5 != r6) goto L5
            r5 = 1
            goto L6c
        L5:
            com.google.ads.interactivemedia.v3.internal.bur r0 = new com.google.ads.interactivemedia.v3.internal.bur
            r0.<init>()
            r0.d = r7
            boolean r7 = r0.b
            if (r7 != 0) goto L11
            goto L6a
        L11:
            if (r5 == r6) goto L6a
            java.lang.Class r7 = r5.getClass()
            java.lang.Class r1 = r6.getClass()
            boolean r2 = r7.isInstance(r6)
            r3 = 0
            if (r2 == 0) goto L29
            boolean r2 = r1.isInstance(r5)
            if (r2 != 0) goto L35
            goto L37
        L29:
            boolean r2 = r1.isInstance(r5)
            if (r2 == 0) goto L68
            boolean r2 = r7.isInstance(r6)
            if (r2 != 0) goto L37
        L35:
            r2 = r7
            goto L38
        L37:
            r2 = r1
        L38:
            boolean r4 = r2.isArray()     // Catch: java.lang.IllegalArgumentException -> L68
            if (r4 == 0) goto L42
            r0.f(r5, r6)     // Catch: java.lang.IllegalArgumentException -> L68
            goto L6a
        L42:
            java.util.List r4 = r0.c     // Catch: java.lang.IllegalArgumentException -> L68
            boolean r7 = r4.contains(r7)     // Catch: java.lang.IllegalArgumentException -> L68
            if (r7 != 0) goto L61
            java.util.List r7 = r0.c     // Catch: java.lang.IllegalArgumentException -> L68
            boolean r7 = r7.contains(r1)     // Catch: java.lang.IllegalArgumentException -> L68
            if (r7 == 0) goto L53
            goto L61
        L53:
            r0.h(r5, r6, r2)     // Catch: java.lang.IllegalArgumentException -> L68
            java.lang.Class r7 = r2.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L68
            if (r7 == 0) goto L6a
            java.lang.Class r2 = r2.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L68
            goto L53
        L61:
            boolean r5 = r5.equals(r6)     // Catch: java.lang.IllegalArgumentException -> L68
            r0.b = r5     // Catch: java.lang.IllegalArgumentException -> L68
            goto L6a
        L68:
            r0.b = r3
        L6a:
            boolean r5 = r0.b
        L6c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bur.c(java.lang.Object, java.lang.Object, java.lang.String[]):boolean");
    }

    private final void h(Object obj, Object obj2, Class cls) {
        Set a2 = a();
        bux b = b(obj, obj2);
        buw buwVar = (buw) b;
        bux c = bux.c(buwVar.b, buwVar.a);
        if (a2 == null || !(a2.contains(b) || a2.contains(c))) {
            try {
                HashSet a3 = a();
                if (a3 == null) {
                    a3 = new HashSet();
                    a.set(a3);
                }
                a3.add(b(obj, obj2));
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (int i = 0; i < declaredFields.length && this.b; i++) {
                    Field field = declaredFields[i];
                    if (!bto.D(this.d, field.getName()) && !field.getName().contains("$") && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(bus.class)) {
                        try {
                            f(field.get(obj), field.get(obj2));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
                i(obj, obj2);
            } catch (Throwable th) {
                i(obj, obj2);
                throw th;
            }
        }
    }

    private static void i(Object obj, Object obj2) {
        Set a2 = a();
        if (a2 != null) {
            a2.remove(b(obj, obj2));
            if (a2.isEmpty()) {
                a.remove();
            }
        }
    }

    public final void d(int i, int i2) {
        if (this.b) {
            this.b = i == i2;
        }
    }

    public final void e(long j, long j2) {
        if (this.b) {
            this.b = j == j2;
        }
    }

    public final void f(Object obj, Object obj2) {
        if (this.b && obj != obj2) {
            if (obj == null || obj2 == null) {
                g();
                return;
            }
            if (!obj.getClass().isArray()) {
                this.b = obj.equals(obj2);
                return;
            }
            if (obj.getClass() != obj2.getClass()) {
                g();
                return;
            }
            int i = 0;
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                if (this.b && jArr != jArr2) {
                    if (jArr.length != jArr2.length) {
                        g();
                        return;
                    }
                    while (i < jArr.length && this.b) {
                        e(jArr[i], jArr2[i]);
                        i++;
                    }
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int[] iArr2 = (int[]) obj2;
                if (!this.b || iArr == iArr2) {
                    return;
                }
                if (iArr.length != iArr2.length) {
                    g();
                    return;
                }
                while (i < iArr.length && this.b) {
                    d(iArr[i], iArr2[i]);
                    i++;
                }
                return;
            }
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                short[] sArr2 = (short[]) obj2;
                if (!this.b || sArr == sArr2) {
                    return;
                }
                if (sArr.length != sArr2.length) {
                    g();
                    return;
                }
                for (int i2 = 0; i2 < sArr.length && this.b; i2++) {
                    this.b = sArr[i2] == sArr2[i2];
                }
                return;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                char[] cArr2 = (char[]) obj2;
                if (!this.b || cArr == cArr2) {
                    return;
                }
                if (cArr.length != cArr2.length) {
                    g();
                    return;
                }
                for (int i3 = 0; i3 < cArr.length && this.b; i3++) {
                    this.b = cArr[i3] == cArr2[i3];
                }
                return;
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (!this.b || bArr == bArr2) {
                    return;
                }
                if (bArr.length != bArr2.length) {
                    g();
                    return;
                }
                for (int i4 = 0; i4 < bArr.length && this.b; i4++) {
                    this.b = bArr[i4] == bArr2[i4];
                }
                return;
            }
            if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                if (!this.b || dArr == dArr2) {
                    return;
                }
                if (dArr.length != dArr2.length) {
                    g();
                    return;
                }
                while (i < dArr.length && this.b) {
                    e(Double.doubleToLongBits(dArr[i]), Double.doubleToLongBits(dArr2[i]));
                    i++;
                }
                return;
            }
            if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                if (!this.b || fArr == fArr2) {
                    return;
                }
                if (fArr.length != fArr2.length) {
                    g();
                    return;
                }
                while (i < fArr.length && this.b) {
                    d(Float.floatToIntBits(fArr[i]), Float.floatToIntBits(fArr2[i]));
                    i++;
                }
                return;
            }
            if (!(obj instanceof boolean[])) {
                Object[] objArr = (Object[]) obj;
                Object[] objArr2 = (Object[]) obj2;
                if (!this.b || objArr == objArr2) {
                    return;
                }
                if (objArr.length != objArr2.length) {
                    g();
                    return;
                }
                while (i < objArr.length && this.b) {
                    f(objArr[i], objArr2[i]);
                    i++;
                }
                return;
            }
            boolean[] zArr = (boolean[]) obj;
            boolean[] zArr2 = (boolean[]) obj2;
            if (!this.b || zArr == zArr2) {
                return;
            }
            if (zArr.length != zArr2.length) {
                g();
                return;
            }
            for (int i5 = 0; i5 < zArr.length && this.b; i5++) {
                this.b = zArr[i5] == zArr2[i5];
            }
        }
    }

    public final void g() {
        this.b = false;
    }
}
