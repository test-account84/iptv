package M6;

import java.util.Arrays;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class k implements x6.m {
    public static float e(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void f(D6.a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int l = aVar.l();
        if (i >= l) {
            throw x6.k.a();
        }
        boolean z = !aVar.h(i);
        while (i < l) {
            if (aVar.h(i) == z) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != l) {
                throw x6.k.a();
            }
        }
    }

    public static void g(D6.a aVar, int i, int[] iArr) {
        int length = iArr.length;
        boolean h = aVar.h(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.h(i) != h) {
                length--;
                h = !h;
            }
        }
        if (length >= 0) {
            throw x6.k.a();
        }
        f(aVar, i + 1, iArr);
    }

    public x6.o a(x6.c cVar) {
        return b(cVar, null);
    }

    public x6.o b(x6.c cVar, Map map) {
        try {
            return d(cVar, map);
        } catch (x6.k e) {
            if (map == null || !map.containsKey(x6.e.TRY_HARDER) || !cVar.e()) {
                throw e;
            }
            x6.c f = cVar.f();
            x6.o d = d(f, map);
            Map d2 = d.d();
            int i = 270;
            if (d2 != null) {
                x6.p pVar = x6.p.ORIENTATION;
                if (d2.containsKey(pVar)) {
                    i = (((Integer) d2.get(pVar)).intValue() + 270) % 360;
                }
            }
            d.h(x6.p.ORIENTATION, Integer.valueOf(i));
            x6.q[] e2 = d.e();
            if (e2 != null) {
                int c = f.c();
                for (int i2 = 0; i2 < e2.length; i2++) {
                    e2[i2] = new x6.q((c - e2[i2].d()) - 1.0f, e2[i2].c());
                }
            }
            return d;
        }
    }

    public abstract x6.o c(int i, D6.a aVar, Map map);

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        r3 = r22.b(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e0, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final x6.o d(x6.c r22, java.util.Map r23) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M6.k.d(x6.c, java.util.Map):x6.o");
    }

    public void reset() {
    }
}
