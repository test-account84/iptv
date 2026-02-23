package M6;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class n {
    public static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    public final int[] a = new int[4];
    public final StringBuilder b = new StringBuilder();

    public static int c(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == c[i2]) {
                return i2;
            }
        }
        throw x6.k.a();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 48
            if (r2 == r3) goto L4d
            r3 = 53
            if (r2 == r3) goto L4a
            r3 = 57
            java.lang.String r4 = ""
            if (r2 == r3) goto L15
            goto L4f
        L15:
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r1 = -1
            goto L3e
        L1f:
            java.lang.String r1 = "99991"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L28
            goto L1d
        L28:
            r1 = 2
            goto L3e
        L2a:
            java.lang.String r1 = "99990"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L33
            goto L1d
        L33:
            r1 = 1
            goto L3e
        L35:
            java.lang.String r3 = "90000"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L3e
            goto L1d
        L3e:
            switch(r1) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r4 = "$"
            goto L4f
        L4d:
            java.lang.String r4 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r0)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L6e
            java.lang.String r1 = "0"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.concat(r5)
            goto L72
        L6e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L72:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: M6.n.e(java.lang.String):java.lang.String");
    }

    public static Map f(String str) {
        String e;
        if (str.length() != 5 || (e = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(x6.p.class);
        enumMap.put(x6.p.SUGGESTED_PRICE, e);
        return enumMap;
    }

    public final int a(D6.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int l = aVar.l();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && i < l; i3++) {
            int j = p.j(aVar, iArr2, i, p.h);
            sb.append((char) ((j % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (j >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                i = aVar.k(aVar.j(i));
            }
        }
        if (sb.length() != 5) {
            throw x6.k.a();
        }
        if (d(sb.toString()) == c(i2)) {
            return i;
        }
        throw x6.k.a();
    }

    public x6.o b(int i, D6.a aVar, int[] iArr) {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int a = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map f = f(sb2);
        float f2 = i;
        x6.o oVar = new x6.o(sb2, null, new x6.q[]{new x6.q((iArr[0] + iArr[1]) / 2.0f, f2), new x6.q(a, f2)}, x6.a.UPC_EAN_EXTENSION);
        if (f != null) {
            oVar.g(f);
        }
        return oVar;
    }
}
