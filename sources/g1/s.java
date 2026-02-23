package g1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class s implements ThreadFactory {
    public final ThreadFactory a = Executors.defaultThreadFactory();
    public final AtomicInteger b = new AtomicInteger(1);

    public s(d dVar) {
    }

    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.b;
        Thread newThread = this.a.newThread(runnable);
        newThread.setName("PlayBillingLibrary-" + atomicInteger.getAndIncrement());
        return newThread;
    }
}
