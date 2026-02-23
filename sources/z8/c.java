package z8;

import java.io.Serializable;
import kotlin.jvm.internal.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class c {
    public static final a a = new a(null);
    public static final c c = r8.b.a.b();

    public static final class a extends c implements Serializable {
        public a() {
        }

        public int b(int i) {
            return c.a().b(i);
        }

        public int c() {
            return c.a().c();
        }

        public int d(int i, int i2) {
            return c.a().d(i, i2);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final /* synthetic */ c a() {
        return c;
    }

    public abstract int b(int i);

    public abstract int c();

    public int d(int i, int i2) {
        int c2;
        int i3;
        int i4;
        d.b(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i4 = b(d.c(i5));
            } else {
                do {
                    c2 = c() >>> 1;
                    i3 = c2 % i5;
                } while ((c2 - i3) + (i5 - 1) < 0);
                i4 = i3;
            }
            return i + i4;
        }
        while (true) {
            int c3 = c();
            if (i <= c3 && c3 < i2) {
                return c3;
            }
        }
    }
}
