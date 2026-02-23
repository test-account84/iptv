package l8;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g extends f {
    public static List b(Object[] objArr) {
        kotlin.jvm.internal.l.e(objArr, "<this>");
        List a = i.a(objArr);
        kotlin.jvm.internal.l.d(a, "asList(this)");
        return a;
    }

    public static byte[] c(byte[] bArr, byte[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.l.e(bArr, "<this>");
        kotlin.jvm.internal.l.e(destination, "destination");
        System.arraycopy(bArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static final Object[] d(Object[] objArr, Object[] destination, int i, int i2, int i3) {
        kotlin.jvm.internal.l.e(objArr, "<this>");
        kotlin.jvm.internal.l.e(destination, "destination");
        System.arraycopy(objArr, i2, destination, i, i3 - i2);
        return destination;
    }

    public static /* synthetic */ byte[] e(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return c(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return d(objArr, objArr2, i, i2, i3);
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.l.e(bArr, "<this>");
        e.a(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        kotlin.jvm.internal.l.d(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static Object[] h(Object[] objArr, int i, int i2) {
        kotlin.jvm.internal.l.e(objArr, "<this>");
        e.a(i2, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i2);
        kotlin.jvm.internal.l.d(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void i(int[] iArr, int i, int i2, int i3) {
        kotlin.jvm.internal.l.e(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static void j(Object[] objArr, Object obj, int i, int i2) {
        kotlin.jvm.internal.l.e(objArr, "<this>");
        Arrays.fill(objArr, i, i2, obj);
    }

    public static /* synthetic */ void k(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        i(iArr, i, i2, i3);
    }

    public static /* synthetic */ void l(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        j(objArr, obj, i, i2);
    }
}
