package d4;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static final byte[] a = {0, 0, 0, 1};
    public static final String[] b = {"", "A", "B", "C"};

    public static String a(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static List b(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        StringBuilder sb = new StringBuilder(k0.D("hvc1.%s%d.%X.%c%d", b[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(z ? 'H' : 'L'), Integer.valueOf(i4)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i5])}));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        byte[] bArr2 = a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    public static int e(byte[] bArr, int i) {
        int length = bArr.length - a.length;
        while (i <= length) {
            if (g(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Pair f(byte[] bArr) {
        boolean z;
        M m = new M(bArr);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 3;
            if (i3 >= bArr.length) {
                z = false;
                break;
            }
            if (m.K() == 1 && (bArr[i3] & 240) == 32) {
                z = true;
                break;
            }
            m.U(m.f() - 2);
            i2++;
        }
        a.b(z, "Invalid input: VOL not found.");
        L l = new L(bArr);
        l.r((i2 + 4) * 8);
        l.r(1);
        l.r(8);
        if (l.g()) {
            l.r(4);
            l.r(3);
        }
        if (l.h(4) == 15) {
            l.r(8);
            l.r(8);
        }
        if (l.g()) {
            l.r(2);
            l.r(1);
            if (l.g()) {
                l.r(79);
            }
        }
        a.b(l.h(2) == 0, "Only supports rectangular video object layer shape.");
        a.a(l.g());
        int h = l.h(16);
        a.a(l.g());
        if (l.g()) {
            a.a(h > 0);
            for (int i4 = h - 1; i4 > 0; i4 >>= 1) {
                i++;
            }
            l.r(i);
        }
        a.a(l.g());
        int h2 = l.h(13);
        a.a(l.g());
        int h3 = l.h(13);
        a.a(l.g());
        l.r(1);
        return Pair.create(Integer.valueOf(h2), Integer.valueOf(h3));
    }

    public static boolean g(byte[] bArr, int i) {
        if (bArr.length - i <= a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    public static Pair h(byte[] bArr) {
        M m = new M(bArr);
        m.U(9);
        int H = m.H();
        m.U(20);
        return Pair.create(Integer.valueOf(m.L()), Integer.valueOf(H));
    }

    public static boolean i(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    public static byte[][] j(byte[] bArr) {
        if (!g(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = e(bArr, i + a.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            int intValue2 = (i2 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i2] = bArr3;
            i2++;
        }
        return bArr2;
    }
}
