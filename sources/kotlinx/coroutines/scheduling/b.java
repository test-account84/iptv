package kotlinx.coroutines.scheduling;

import G8.H;
import G8.n0;
import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class b extends n0 implements Executor {
    public static final b e = new b();
    public static final H f = m.d.e0(z.f("kotlinx.coroutines.io.parallelism", B8.h.c(64, z.a()), 0, 0, 12, null));

    public void c0(o8.g gVar, Runnable runnable) {
        f.c0(gVar, runnable);
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void execute(Runnable runnable) {
        c0(o8.h.a, runnable);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
