package d3;

import O2.l1;
import java.io.EOFException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class l {
    public static void a(boolean z, String str) {
        if (!z) {
            throw l1.a(str, null);
        }
    }

    public static boolean b(j jVar, byte[] bArr, int i, int i2, boolean z) {
        try {
            return jVar.d(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int c(j jVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int p = jVar.p(bArr, i + i3, i2 - i3);
            if (p == -1) {
                break;
            }
            i3 += p;
        }
        return i3;
    }

    public static boolean d(j jVar, byte[] bArr, int i, int i2) {
        try {
            jVar.m(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(j jVar, int i) {
        try {
            jVar.q(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
