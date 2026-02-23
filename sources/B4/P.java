package b4;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p extends IOException {
    public final int a;

    public p(int i) {
        this.a = i;
    }

    public static boolean a(IOException iOException) {
        while (iOException != null) {
            if ((iOException instanceof p) && ((p) iOException).a == 2008) {
                return true;
            }
            iOException = iOException.getCause();
        }
        return false;
    }

    public p(String str, int i) {
        super(str);
        this.a = i;
    }

    public p(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }

    public p(Throwable th, int i) {
        super(th);
        this.a = i;
    }
}
