package c1;

import a1.k;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements c1.a {
    public final k a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final Executor c = new a();

    public class a implements Executor {
        public a() {
        }

        public void execute(Runnable runnable) {
            b.this.d(runnable);
        }
    }

    public b(Executor executor) {
        this.a = new k(executor);
    }

    public Executor a() {
        return this.c;
    }

    public void b(Runnable runnable) {
        this.a.execute(runnable);
    }

    public k c() {
        return this.a;
    }

    public void d(Runnable runnable) {
        this.b.post(runnable);
    }
}
