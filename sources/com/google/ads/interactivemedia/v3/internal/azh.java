package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class azh {
    public azh() {
    }

    public static aze a(ExecutorService executorService) {
        if (executorService instanceof aze) {
            return (aze) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new azg((ScheduledExecutorService) executorService) : new ayc(executorService);
    }

    @SafeVarargs
    public static ayt b(azd... azdVarArr) {
        return new ayt(avo.n(azdVarArr));
    }

    public static Object c(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        if (!future.isDone()) {
            throw new IllegalStateException(atp.b("Future was expected to be done: %s", future));
        }
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static void d(azd azdVar, ayr ayrVar, Executor executor) {
        atp.k(ayrVar);
        azdVar.g(new ays(azdVar, ayrVar), executor);
    }

    public static void e(Future future, Class cls) throws Exception {
        ayy.b(future, cls);
    }

    public static int f(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public azh(byte[] bArr) {
        this();
    }
}
