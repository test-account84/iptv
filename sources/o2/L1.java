package O2;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class l1 extends IOException {
    public final boolean a;
    public final int c;

    public l1(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.a = z;
        this.c = i;
    }

    public static l1 a(String str, Throwable th) {
        return new l1(str, th, true, 1);
    }

    public static l1 b(String str, Throwable th) {
        return new l1(str, th, true, 0);
    }

    public static l1 c(String str, Throwable th) {
        return new l1(str, th, true, 4);
    }

    public static l1 d(String str, Throwable th) {
        return new l1(str, th, false, 4);
    }

    public static l1 e(String str) {
        return new l1(str, null, false, 1);
    }

    public String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.a + ", dataType=" + this.c + "}";
    }
}
