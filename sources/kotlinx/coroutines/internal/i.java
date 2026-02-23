package kotlinx.coroutines.internal;

import G8.H;
import G8.S;
import G8.V;
import G8.d0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class i extends H implements Runnable, V {
    public final H d;
    public final int e;
    public final /* synthetic */ V f;
    public final n g;
    public final Object h;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public i(H h, int i) {
        this.d = h;
        this.e = i;
        V v = h instanceof V ? (V) h : null;
        this.f = v == null ? S.a() : v;
        this.g = new n(false);
        this.h = new Object();
    }

    public void c0(o8.g gVar, Runnable runnable) {
        if (f0(runnable) || !g0()) {
            return;
        }
        this.d.c0(this, this);
    }

    public final boolean f0(Runnable runnable) {
        this.g.a(runnable);
        return this.runningWorkers >= this.e;
    }

    public final boolean g0() {
        synchronized (this.h) {
            if (this.runningWorkers >= this.e) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r1 = r4.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r4.g.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = k8.q.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.n r2 = r4.g
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            o8.h r3 = o8.h.a
            G8.K.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            G8.H r2 = r4.d
            boolean r2 = r2.d0(r4)
            if (r2 == 0) goto L2
            G8.H r0 = r4.d
            r0.c0(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.h
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.n r2 = r4.g     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            k8.q r2 = k8.q.a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.i.run():void");
    }

    public d0 t(long j, Runnable runnable, o8.g gVar) {
        return this.f.t(j, runnable, gVar);
    }
}
