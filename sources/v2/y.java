package V2;

import O2.z0;
import P2.v0;
import V2.o;
import V2.w;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface y {
    public static final y a;
    public static final y b;

    public interface b {
        public static final b a = new z();

        void release();
    }

    static {
        a aVar = new a();
        a = aVar;
        b = aVar;
    }

    int a(z0 z0Var);

    void b(Looper looper, v0 v0Var);

    o c(w.a aVar, z0 z0Var);

    b d(w.a aVar, z0 z0Var);

    void prepare();

    void release();

    public class a implements y {
        public int a(z0 z0Var) {
            return z0Var.p != null ? 1 : 0;
        }

        public o c(w.a aVar, z0 z0Var) {
            if (z0Var.p == null) {
                return null;
            }
            return new E(new o.a(new W(1), 6001));
        }

        public /* synthetic */ b d(w.a aVar, z0 z0Var) {
            return x.a(this, aVar, z0Var);
        }

        public /* synthetic */ void prepare() {
            x.b(this);
        }

        public /* synthetic */ void release() {
            x.c(this);
        }

        public void b(Looper looper, v0 v0Var) {
        }
    }
}
