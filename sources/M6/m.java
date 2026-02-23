package M6;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class m {
    public final int[] a = new int[4];
    public final StringBuilder b = new StringBuilder();

    public static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(x6.p.class);
        enumMap.put(x6.p.ISSUE_NUMBER, Integer.valueOf(str));
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
        for (int i3 = 0; i3 < 2 && i < l; i3++) {
            int j = p.j(aVar, iArr2, i, p.h);
            sb.append((char) ((j % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (j >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                i = aVar.k(aVar.j(i));
            }
        }
        if (sb.length() != 2) {
            throw x6.k.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i2) {
            return i;
        }
        throw x6.k.a();
    }

    public x6.o b(int i, D6.a aVar, int[] iArr) {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int a = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map c = c(sb2);
        float f = i;
        x6.o oVar = new x6.o(sb2, null, new x6.q[]{new x6.q((iArr[0] + iArr[1]) / 2.0f, f), new x6.q(a, f)}, x6.a.UPC_EAN_EXTENSION);
        if (c != null) {
            oVar.g(c);
        }
        return oVar;
    }
}
