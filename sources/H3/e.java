package h3;

import O2.l1;
import d3.w;
import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e {
    public final w a;

    public static final class a extends l1 {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    public e(w wVar) {
        this.a = wVar;
    }

    public final boolean a(M m, long j) {
        return b(m) && c(m, j);
    }

    public abstract boolean b(M m);

    public abstract boolean c(M m, long j);
}
