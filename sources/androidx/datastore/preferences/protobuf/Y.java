package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class y {
    public static final Charset a = Charset.forName("UTF-8");
    public static final Charset b = Charset.forName("ISO-8859-1");
    public static final byte[] c;
    public static final ByteBuffer d;
    public static final h e;

    public interface a {
        boolean a(int i);
    }

    public interface b extends List, RandomAccess {
        void k();

        boolean t();

        b w(int i);
    }

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        d = ByteBuffer.wrap(bArr);
        e = h.h(bArr);
    }

    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i, int i2) {
        int i3 = i(i2, bArr, i, i2);
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public static int f(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return q0.m(bArr);
    }

    public static Object h(Object obj, Object obj2) {
        return ((O) obj).b().a((O) obj2).r();
    }

    public static int i(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, a);
    }
}
