package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l {
    public static final long a = z.g("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    public static final int b = z.f("kotlinx.coroutines.scheduler.core.pool.size", B8.h.c(z.a(), 2), 1, 0, 8, null);
    public static final int c = z.f("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
    public static final long d = TimeUnit.SECONDS.toNanos(z.g("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
    public static g e = e.a;
    public static final i f = new j(0);
    public static final i g = new j(1);
}
