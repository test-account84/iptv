package j$.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public class ConcurrentHashMap extends AbstractMap implements java.util.concurrent.ConcurrentMap, Serializable, ConcurrentMap {
    static final int g = Runtime.getRuntime().availableProcessors();
    private static final j$.sun.misc.a h;
    private static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final int n;
    private static final int o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    volatile transient l[] a;
    private volatile transient l[] b;
    private volatile transient long baseCount;
    private volatile transient c[] c;
    private volatile transient int cellsBusy;
    private transient i d;
    private transient s e;
    private transient e f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    static {
        ObjectStreamField objectStreamField = new ObjectStreamField("segments", n[].class);
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        j$.sun.misc.a h2 = j$.sun.misc.a.h();
        h = h2;
        i = h2.j(ConcurrentHashMap.class, "sizeCtl");
        j = h2.j(ConcurrentHashMap.class, "transferIndex");
        k = h2.j(ConcurrentHashMap.class, "baseCount");
        l = h2.j(ConcurrentHashMap.class, "cellsBusy");
        m = h2.j(c.class, "value");
        n = h2.a(l[].class);
        int b = h2.b(l[].class);
        if (((b - 1) & b) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        o = 31 - Integer.numberOfLeadingZeros(b);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i2) {
        this(i2, 0.75f, 1);
    }

    public ConcurrentHashMap(int i2, float f, int i3) {
        if (f <= 0.0f || i2 < 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        long j2 = (long) (((i2 < i3 ? i3 : i2) / f) + 1.0d);
        this.sizeCtl = j2 >= 1073741824 ? 1073741824 : l((int) j2);
    }

    public ConcurrentHashMap(Map map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x013f, code lost:
    
        if (r25.c != r7) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0141, code lost:
    
        r25.c = (j$.util.concurrent.c[]) java.util.Arrays.copyOf(r7, r8 << 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(long r26, int r28) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    static final boolean b(l[] lVarArr, int i2, l lVar) {
        return h.e(lVarArr, (i2 << o) + n, lVar);
    }

    static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Type type = obj.getClass();
        if (type == String.class) {
            return type;
        }
        ParameterizedType[] genericInterfaces = type.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (ParameterizedType parameterizedType : genericInterfaces) {
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                if (parameterizedType2.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType2.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == type) {
                    return type;
                }
            }
        }
        return null;
    }

    private final l[] e() {
        while (true) {
            l[] lVarArr = this.a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else if (h.c(this, i, i2, -1)) {
                try {
                    l[] lVarArr2 = this.a;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i3 = i2 > 0 ? i2 : 16;
                        l[] lVarArr3 = new l[i3];
                        this.a = lVarArr3;
                        i2 = i3 - (i3 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    this.sizeCtl = i2;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i2;
                    throw th;
                }
            }
        }
    }

    static final void h(l[] lVarArr, int i2, l lVar) {
        h.l(lVarArr, (i2 << o) + n, lVar);
    }

    static final int i(int i2) {
        return (i2 ^ (i2 >>> 16)) & Integer.MAX_VALUE;
    }

    static final l k(l[] lVarArr, int i2) {
        return (l) h.g(lVarArr, (i2 << o) + n);
    }

    private static final int l(int i2) {
        int numberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i2 - 1);
        if (numberOfLeadingZeros < 0) {
            return 1;
        }
        if (numberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return 1 + numberOfLeadingZeros;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r13v12, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r4v0, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r5v17, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r5v22, types: [j$.util.concurrent.l] */
    private final void m(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        int i2;
        int i3;
        g gVar;
        ConcurrentHashMap concurrentHashMap;
        int i4;
        r rVar;
        ConcurrentHashMap concurrentHashMap2 = this;
        l[] lVarArr4 = lVarArr;
        int length = lVarArr4.length;
        int i5 = g;
        int i6 = i5 > 1 ? (length >>> 3) / i5 : length;
        int i7 = i6 < 16 ? 16 : i6;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr5 = new l[length << 1];
                concurrentHashMap2.b = lVarArr5;
                concurrentHashMap2.transferIndex = length;
                lVarArr3 = lVarArr5;
            } catch (Throwable unused) {
                concurrentHashMap2.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar2 = new g(lVarArr3);
        int i8 = 0;
        int i9 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            if (z) {
                int i10 = i9 - 1;
                if (i10 >= i8 || z2) {
                    i8 = i8;
                    i9 = i10;
                } else {
                    int i11 = concurrentHashMap2.transferIndex;
                    if (i11 <= 0) {
                        i9 = -1;
                    } else {
                        j$.sun.misc.a aVar = h;
                        long j2 = j;
                        int i12 = i11 > i7 ? i11 - i7 : 0;
                        int i13 = i8;
                        if (aVar.c(this, j2, i11, i12)) {
                            i9 = i11 - 1;
                            i8 = i12;
                        } else {
                            i8 = i13;
                            i9 = i10;
                        }
                    }
                }
                z = false;
            } else {
                int i14 = i8;
                r rVar2 = null;
                if (i9 < 0 || i9 >= length || (i4 = i9 + length) >= length2) {
                    i2 = i7;
                    i3 = length2;
                    gVar = gVar2;
                    concurrentHashMap = this;
                    if (z2) {
                        concurrentHashMap.b = null;
                        concurrentHashMap.a = lVarArr3;
                        concurrentHashMap.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    j$.sun.misc.a aVar2 = h;
                    long j3 = i;
                    int i15 = concurrentHashMap.sizeCtl;
                    int i16 = i9;
                    if (!aVar2.c(this, j3, i15, i15 - 1)) {
                        i9 = i16;
                    } else {
                        if (i15 - 2 != ((Integer.numberOfLeadingZeros(length) | 32768) << 16)) {
                            return;
                        }
                        i9 = length;
                        z = true;
                        z2 = true;
                    }
                } else {
                    ?? k2 = k(lVarArr4, i9);
                    if (k2 == 0) {
                        z = b(lVarArr4, i9, gVar2);
                        concurrentHashMap = concurrentHashMap2;
                        i2 = i7;
                        i3 = length2;
                        gVar = gVar2;
                    } else {
                        int i17 = k2.a;
                        if (i17 == -1) {
                            concurrentHashMap = concurrentHashMap2;
                            i2 = i7;
                            i3 = length2;
                            gVar = gVar2;
                            z = true;
                        } else {
                            synchronized (k2) {
                                try {
                                    if (k(lVarArr4, i9) == k2) {
                                        if (i17 >= 0) {
                                            int i18 = i17 & length;
                                            r rVar3 = k2;
                                            for (r rVar4 = k2.d; rVar4 != null; rVar4 = rVar4.d) {
                                                int i19 = rVar4.a & length;
                                                if (i19 != i18) {
                                                    rVar3 = rVar4;
                                                    i18 = i19;
                                                }
                                            }
                                            if (i18 == 0) {
                                                rVar = null;
                                                rVar2 = rVar3;
                                            } else {
                                                rVar = rVar3;
                                            }
                                            l lVar = k2;
                                            while (lVar != rVar3) {
                                                int i20 = lVar.a;
                                                Object obj = lVar.b;
                                                int i21 = i7;
                                                Object obj2 = lVar.c;
                                                int i22 = length2;
                                                if ((i20 & length) == 0) {
                                                    rVar2 = new l(i20, obj, obj2, rVar2);
                                                } else {
                                                    rVar = new l(i20, obj, obj2, rVar);
                                                }
                                                lVar = lVar.d;
                                                i7 = i21;
                                                length2 = i22;
                                            }
                                            i2 = i7;
                                            i3 = length2;
                                            h(lVarArr3, i9, rVar2);
                                            h(lVarArr3, i4, rVar);
                                            h(lVarArr4, i9, gVar2);
                                            gVar = gVar2;
                                        } else {
                                            i2 = i7;
                                            i3 = length2;
                                            if (k2 instanceof q) {
                                                q qVar = (q) k2;
                                                r rVar5 = null;
                                                r rVar6 = null;
                                                l lVar2 = qVar.f;
                                                int i23 = 0;
                                                int i24 = 0;
                                                r rVar7 = null;
                                                while (lVar2 != null) {
                                                    q qVar2 = qVar;
                                                    int i25 = lVar2.a;
                                                    g gVar3 = gVar2;
                                                    r rVar8 = new r(i25, lVar2.b, lVar2.c, null, null);
                                                    if ((i25 & length) == 0) {
                                                        rVar8.h = rVar6;
                                                        if (rVar6 == null) {
                                                            rVar2 = rVar8;
                                                        } else {
                                                            rVar6.d = rVar8;
                                                        }
                                                        i23++;
                                                        rVar6 = rVar8;
                                                    } else {
                                                        rVar8.h = rVar5;
                                                        if (rVar5 == null) {
                                                            rVar7 = rVar8;
                                                        } else {
                                                            rVar5.d = rVar8;
                                                        }
                                                        i24++;
                                                        rVar5 = rVar8;
                                                    }
                                                    lVar2 = lVar2.d;
                                                    qVar = qVar2;
                                                    gVar2 = gVar3;
                                                }
                                                q qVar3 = qVar;
                                                g gVar4 = gVar2;
                                                l p = i23 <= 6 ? p(rVar2) : i24 != 0 ? new q(rVar2) : qVar3;
                                                l p2 = i24 <= 6 ? p(rVar7) : i23 != 0 ? new q(rVar7) : qVar3;
                                                h(lVarArr3, i9, p);
                                                h(lVarArr3, i4, p2);
                                                lVarArr4 = lVarArr;
                                                gVar = gVar4;
                                                h(lVarArr4, i9, gVar);
                                            }
                                        }
                                        z = true;
                                    } else {
                                        i2 = i7;
                                        i3 = length2;
                                    }
                                    gVar = gVar2;
                                } finally {
                                }
                            }
                            concurrentHashMap = this;
                        }
                    }
                }
                gVar2 = gVar;
                concurrentHashMap2 = concurrentHashMap;
                i8 = i14;
                i7 = i2;
                length2 = i3;
            }
        }
    }

    private final void n(l[] lVarArr, int i2) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l k2 = k(lVarArr, i2);
        if (k2 == null || k2.a < 0) {
            return;
        }
        synchronized (k2) {
            try {
                if (k(lVarArr, i2) == k2) {
                    r rVar = null;
                    l lVar = k2;
                    r rVar2 = null;
                    while (lVar != null) {
                        r rVar3 = new r(lVar.a, lVar.b, lVar.c, null, null);
                        rVar3.h = rVar2;
                        if (rVar2 == null) {
                            rVar = rVar3;
                        } else {
                            rVar2.d = rVar3;
                        }
                        lVar = lVar.d;
                        rVar2 = rVar3;
                    }
                    h(lVarArr, i2, new q(rVar));
                }
            } finally {
            }
        }
    }

    private final void o(int i2) {
        int length;
        int l2 = i2 >= 536870912 ? 1073741824 : l(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.sizeCtl;
            if (i3 < 0) {
                return;
            }
            l[] lVarArr = this.a;
            if (lVarArr == null || (length = lVarArr.length) == 0) {
                int i4 = i3 > l2 ? i3 : l2;
                if (h.c(this, i, i3, -1)) {
                    try {
                        if (this.a == lVarArr) {
                            this.a = new l[i4];
                            i3 = i4 - (i4 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i3;
                    }
                } else {
                    continue;
                }
            } else {
                if (l2 <= i3 || length >= 1073741824) {
                    return;
                }
                if (lVarArr == this.a) {
                    if (h.c(this, i, i3, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                        m(lVarArr, null);
                    }
                }
            }
        }
    }

    static l p(l lVar) {
        l lVar2 = null;
        l lVar3 = null;
        while (lVar != null) {
            l lVar4 = new l(lVar.a, lVar.b, lVar.c);
            if (lVar3 == null) {
                lVar2 = lVar4;
            } else {
                lVar3.d = lVar4;
            }
            lVar = lVar.d;
            lVar3 = lVar4;
        }
        return lVar2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j2;
        boolean z;
        boolean z2;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j3 = 0;
        long j4 = 0;
        l lVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j2 = 1;
            if (readObject == null || readObject2 == null) {
                break;
            }
            j4++;
            lVar = new l(i(readObject.hashCode()), readObject, readObject2, lVar);
        }
        if (j4 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j5 = (long) ((j4 / 0.75f) + 1.0d);
        int l2 = j5 >= 1073741824 ? 1073741824 : l((int) j5);
        l[] lVarArr = new l[l2];
        int i2 = l2 - 1;
        while (lVar != null) {
            l lVar2 = lVar.d;
            int i3 = lVar.a;
            int i4 = i3 & i2;
            l k2 = k(lVarArr, i4);
            if (k2 == null) {
                z2 = true;
            } else {
                Object obj2 = lVar.b;
                if (k2.a >= 0) {
                    int i5 = 0;
                    for (l lVar3 = k2; lVar3 != null; lVar3 = lVar3.d) {
                        if (lVar3.a == i3 && ((obj = lVar3.b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        }
                        i5++;
                    }
                    z = true;
                    if (!z || i5 < 8) {
                        z2 = z;
                    } else {
                        long j6 = j3 + 1;
                        lVar.d = k2;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            long j7 = j6;
                            r rVar3 = new r(lVar4.a, lVar4.b, lVar4.c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.d = rVar3;
                            }
                            lVar4 = lVar4.d;
                            rVar2 = rVar3;
                            j6 = j7;
                        }
                        h(lVarArr, i4, new q(rVar));
                        j3 = j6;
                    }
                } else if (((q) k2).e(i3, obj2, lVar.c) == null) {
                    j3 += j2;
                }
                z2 = false;
            }
            j2 = 1;
            if (z2) {
                j3++;
                lVar.d = k2;
                h(lVarArr, i4, lVar);
            }
            lVar = lVar2;
        }
        this.a = lVarArr;
        this.sizeCtl = l2 - (l2 >>> 2);
        this.baseCount = j3;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i2 = 1;
        int i3 = 0;
        while (i2 < 16) {
            i3++;
            i2 <<= 1;
        }
        int i4 = 32 - i3;
        int i5 = i2 - 1;
        n[] nVarArr = new n[16];
        for (int i6 = 0; i6 < 16; i6++) {
            nVarArr[i6] = new n();
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("segments", nVarArr);
        putFields.put("segmentShift", i4);
        putFields.put("segmentMask", i5);
        objectOutputStream.writeFields();
        l[] lVarArr = this.a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a = pVar.a();
                if (a == null) {
                    break;
                }
                objectOutputStream.writeObject(a.b);
                objectOutputStream.writeObject(a.c);
            }
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject((Object) null);
    }

    public void clear() {
        l k2;
        l[] lVarArr = this.a;
        long j2 = 0;
        loop0: while (true) {
            int i2 = 0;
            while (lVarArr != null && i2 < lVarArr.length) {
                k2 = k(lVarArr, i2);
                if (k2 == null) {
                    i2++;
                } else {
                    int i3 = k2.a;
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (k2) {
                        try {
                            if (k(lVarArr, i2) == k2) {
                                for (l lVar = i3 >= 0 ? k2 : k2 instanceof q ? ((q) k2).f : null; lVar != null; lVar = lVar.d) {
                                    j2--;
                                }
                                h(lVarArr, i2, null);
                                i2++;
                            }
                        } finally {
                        }
                    }
                }
            }
            lVarArr = d(lVarArr, k2);
        }
        if (j2 != 0) {
            a(j2, -1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x0112, code lost:
    
        if (r4 == 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0114, code lost:
    
        a(r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0118, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object compute(java.lang.Object r14, java.util.function.BiFunction r15) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f0, code lost:
    
        if (r5 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f2, code lost:
    
        a(1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f7, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object computeIfAbsent(java.lang.Object r12, java.util.function.Function r13) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00aa, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object computeIfPresent(java.lang.Object r14, java.util.function.BiFunction r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto Lbd
            if (r15 == 0) goto Lbd
            int r1 = r14.hashCode()
            int r1 = i(r1)
            j$.util.concurrent.l[] r2 = r13.a
            r3 = 0
            r5 = r0
            r4 = 0
        L12:
            if (r2 == 0) goto Lb7
            int r6 = r2.length
            if (r6 != 0) goto L19
            goto Lb7
        L19:
            int r6 = r6 + (-1)
            r6 = r6 & r1
            j$.util.concurrent.l r7 = k(r2, r6)
            if (r7 != 0) goto L24
            goto Lae
        L24:
            int r8 = r7.a
            r9 = -1
            if (r8 != r9) goto L2e
            j$.util.concurrent.l[] r2 = r13.d(r2, r7)
            goto L12
        L2e:
            monitor-enter(r7)
            j$.util.concurrent.l r10 = k(r2, r6)     // Catch: java.lang.Throwable -> L4b
            if (r10 != r7) goto Lab
            if (r8 < 0) goto L70
            r4 = 1
            r10 = r0
            r8 = r7
        L3a:
            int r11 = r8.a     // Catch: java.lang.Throwable -> L4b
            if (r11 != r1) goto L65
            java.lang.Object r11 = r8.b     // Catch: java.lang.Throwable -> L4b
            if (r11 == r14) goto L4e
            if (r11 == 0) goto L65
            boolean r11 = r14.equals(r11)     // Catch: java.lang.Throwable -> L4b
            if (r11 == 0) goto L65
            goto L4e
        L4b:
            r14 = move-exception
            goto Lb5
        L4e:
            java.lang.Object r5 = r8.c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L59
            r8.c = r5     // Catch: java.lang.Throwable -> L4b
            goto Lab
        L59:
            j$.util.concurrent.l r3 = r8.d     // Catch: java.lang.Throwable -> L4b
            if (r10 == 0) goto L60
            r10.d = r3     // Catch: java.lang.Throwable -> L4b
            goto L63
        L60:
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L63:
            r3 = -1
            goto Lab
        L65:
            j$.util.concurrent.l r10 = r8.d     // Catch: java.lang.Throwable -> L4b
            if (r10 != 0) goto L6a
            goto Lab
        L6a:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L3a
        L70:
            boolean r8 = r7 instanceof j$.util.concurrent.q     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9e
            r4 = r7
            j$.util.concurrent.q r4 = (j$.util.concurrent.q) r4     // Catch: java.lang.Throwable -> L4b
            j$.util.concurrent.r r8 = r4.e     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            j$.util.concurrent.r r8 = r8.b(r1, r14, r0)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            java.lang.Object r5 = r8.c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L8c
            r8.c = r5     // Catch: java.lang.Throwable -> L4b
            goto L9c
        L8c:
            boolean r3 = r4.f(r8)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L9b
            j$.util.concurrent.r r3 = r4.f     // Catch: java.lang.Throwable -> L4b
            j$.util.concurrent.l r3 = p(r3)     // Catch: java.lang.Throwable -> L4b
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L9b:
            r3 = -1
        L9c:
            r4 = 2
            goto Lab
        L9e:
            boolean r6 = r7 instanceof j$.util.concurrent.m     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto La3
            goto Lab
        La3:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L4b
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch: java.lang.Throwable -> L4b
            throw r14     // Catch: java.lang.Throwable -> L4b
        Lab:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L12
        Lae:
            if (r3 == 0) goto Lb4
            long r14 = (long) r3
            r13.a(r14, r4)
        Lb4:
            return r5
        Lb5:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            throw r14
        Lb7:
            j$.util.concurrent.l[] r2 = r13.e()
            goto L12
        Lbd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a = pVar.a();
                if (a == null) {
                    break;
                }
                Object obj2 = a.c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    final l[] d(l[] lVarArr, l lVar) {
        l[] lVarArr2;
        int i2;
        if (!(lVar instanceof g) || (lVarArr2 = ((g) lVar).e) == null) {
            return this.a;
        }
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (true) {
            if (lVarArr2 != this.b || this.a != lVarArr || (i2 = this.sizeCtl) >= 0 || (i2 >>> 16) != numberOfLeadingZeros || i2 == numberOfLeadingZeros + 1 || i2 == 65535 + numberOfLeadingZeros || this.transferIndex <= 0) {
                break;
            }
            if (h.c(this, i, i2, i2 + 1)) {
                m(lVarArr, lVarArr2);
                break;
            }
        }
        return lVarArr2;
    }

    public final Set entrySet() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f = eVar2;
        return eVar2;
    }

    public final boolean equals(Object obj) {
        Object value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l a = pVar.a();
            if (a == null) {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
            Object obj3 = a.c;
            Object obj4 = map.get(a.b);
            if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                break;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        a(1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b9, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00a5, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.Object f(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.f(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a = pVar.a();
            if (a == null) {
                return;
            } else {
                biConsumer.accept(a.b, a.c);
            }
        }
    }

    final Object g(Object obj, Object obj2, Object obj3) {
        int length;
        int i2;
        l k2;
        boolean z;
        Object obj4;
        r b;
        l p;
        Object obj5;
        int i3 = i(obj.hashCode());
        l[] lVarArr = this.a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (k2 = k(lVarArr, (i2 = (length - 1) & i3))) == null) {
                break;
            }
            int i4 = k2.a;
            if (i4 == -1) {
                lVarArr = d(lVarArr, k2);
            } else {
                synchronized (k2) {
                    try {
                        if (k(lVarArr, i2) == k2) {
                            z = true;
                            if (i4 >= 0) {
                                l lVar = null;
                                l lVar2 = k2;
                                while (true) {
                                    if (lVar2.a != i3 || ((obj5 = lVar2.b) != obj && (obj5 == null || !obj.equals(obj5)))) {
                                        l lVar3 = lVar2.d;
                                        if (lVar3 == null) {
                                            break;
                                        }
                                        lVar = lVar2;
                                        lVar2 = lVar3;
                                    }
                                }
                                obj4 = lVar2.c;
                                if (obj3 != null && obj3 != obj4 && (obj4 == null || !obj3.equals(obj4))) {
                                    obj4 = null;
                                } else if (obj2 != null) {
                                    lVar2.c = obj2;
                                } else if (lVar != null) {
                                    lVar.d = lVar2.d;
                                } else {
                                    p = lVar2.d;
                                    h(lVarArr, i2, p);
                                }
                            } else if (k2 instanceof q) {
                                q qVar = (q) k2;
                                r rVar = qVar.e;
                                if (rVar != null && (b = rVar.b(i3, obj, null)) != null) {
                                    obj4 = b.c;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            b.c = obj2;
                                        } else if (qVar.f(b)) {
                                            p = p(qVar.f);
                                            h(lVarArr, i2, p);
                                        }
                                    }
                                }
                                obj4 = null;
                            } else if (k2 instanceof m) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                        z = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        return r1.c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = i(r0)
            j$.util.concurrent.l[] r1 = r4.a
            r2 = 0
            if (r1 == 0) goto L4e
            int r3 = r1.length
            if (r3 <= 0) goto L4e
            int r3 = r3 + (-1)
            r3 = r3 & r0
            j$.util.concurrent.l r1 = k(r1, r3)
            if (r1 == 0) goto L4e
            int r3 = r1.a
            if (r3 != r0) goto L2c
            java.lang.Object r3 = r1.b
            if (r3 == r5) goto L29
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L29:
            java.lang.Object r5 = r1.c
            return r5
        L2c:
            if (r3 >= 0) goto L37
            j$.util.concurrent.l r5 = r1.a(r5, r0)
            if (r5 == 0) goto L36
            java.lang.Object r2 = r5.c
        L36:
            return r2
        L37:
            j$.util.concurrent.l r1 = r1.d
            if (r1 == 0) goto L4e
            int r3 = r1.a
            if (r3 != r0) goto L37
            java.lang.Object r3 = r1.b
            if (r3 == r5) goto L4b
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L4b:
            java.lang.Object r5 = r1.c
            return r5
        L4e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    public final int hashCode() {
        l[] lVarArr = this.a;
        int i2 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a = pVar.a();
                if (a == null) {
                    break;
                }
                i2 += a.c.hashCode() ^ a.b.hashCode();
            }
        }
        return i2;
    }

    public final boolean isEmpty() {
        return j() <= 0;
    }

    final long j() {
        c[] cVarArr = this.c;
        long j2 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.value;
                }
            }
        }
        return j2;
    }

    public Set keySet() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.d = iVar2;
        return iVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00dd, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object merge(java.lang.Object r18, java.lang.Object r19, java.util.function.BiFunction r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public Object put(Object obj, Object obj2) {
        return f(obj, obj2, false);
    }

    public void putAll(Map map) {
        o(map.size());
        for (Map.Entry entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        return f(obj, obj2, true);
    }

    public Object remove(Object obj) {
        return g(obj, null, null);
    }

    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, null, obj2) == null) ? false : true;
    }

    public final Object replace(Object obj, Object obj2) {
        if (obj == null) {
            throw null;
        }
        if (obj2 != null) {
            return g(obj, obj2, null);
        }
        throw null;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return g(obj, obj3, obj2) != null;
    }

    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a = pVar.a();
            if (a == null) {
                return;
            }
            Object obj = a.c;
            Object obj2 = a.b;
            do {
                Object apply = biFunction.apply(obj2, obj);
                apply.getClass();
                if (g(obj2, apply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    public int size() {
        long j2 = j();
        if (j2 < 0) {
            return 0;
        }
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j2;
    }

    public String toString() {
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l a = pVar.a();
        if (a != null) {
            while (true) {
                Object obj = a.b;
                Object obj2 = a.c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a = pVar.a();
                if (a == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public Collection values() {
        s sVar = this.e;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.e = sVar2;
        return sVar2;
    }
}
