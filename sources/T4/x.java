package t4;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.cast.zzdy;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x {
    public static final b f = new b("RequestTracker");
    public static final Object g = new Object();
    public final long a;
    public v d;
    public Runnable e;
    public long c = -1;
    public final Handler b = new zzdy(Looper.getMainLooper());

    public x(long j) {
        this.a = j;
    }

    public static /* synthetic */ void a(x xVar) {
        synchronized (g) {
            try {
                if (xVar.c == -1) {
                    return;
                }
                xVar.h(15, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(long j, v vVar) {
        v vVar2;
        long j2;
        Object obj = g;
        synchronized (obj) {
            vVar2 = this.d;
            j2 = this.c;
            this.c = j;
            this.d = vVar;
        }
        if (vVar2 != null) {
            vVar2.a(j2);
        }
        synchronized (obj) {
            try {
                Runnable runnable = this.e;
                if (runnable != null) {
                    this.b.removeCallbacks(runnable);
                }
                w wVar = new w(this);
                this.e = wVar;
                this.b.postDelayed(wVar, this.a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(int i) {
        return h(2002, null);
    }

    public final boolean d(long j, int i, Object obj) {
        synchronized (g) {
            try {
                long j2 = this.c;
                if (j2 == -1 || j2 != j) {
                    return false;
                }
                g(i, obj, String.format(Locale.ROOT, "request %d completed", new Object[]{Long.valueOf(j)}));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        boolean z;
        synchronized (g) {
            z = this.c != -1;
        }
        return z;
    }

    public final boolean f(long j) {
        boolean z;
        synchronized (g) {
            long j2 = this.c;
            z = false;
            if (j2 != -1 && j2 == j) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0015, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r4, java.lang.Object r5, java.lang.String r6) {
        /*
            r3 = this;
            t4.b r0 = t4.x.f
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.a(r6, r1)
            java.lang.Object r6 = t4.x.g
            monitor-enter(r6)
            t4.v r0 = r3.d     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L17
            long r1 = r3.c     // Catch: java.lang.Throwable -> L15
            r0.b(r1, r4, r5)     // Catch: java.lang.Throwable -> L15
            goto L17
        L15:
            r4 = move-exception
            goto L33
        L17:
            r4 = -1
            r3.c = r4     // Catch: java.lang.Throwable -> L15
            r4 = 0
            r3.d = r4     // Catch: java.lang.Throwable -> L15
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L15
            java.lang.Runnable r5 = r3.e     // Catch: java.lang.Throwable -> L25
            if (r5 != 0) goto L27
        L23:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L25
            goto L2f
        L25:
            r4 = move-exception
            goto L31
        L27:
            android.os.Handler r0 = r3.b     // Catch: java.lang.Throwable -> L25
            r0.removeCallbacks(r5)     // Catch: java.lang.Throwable -> L25
            r3.e = r4     // Catch: java.lang.Throwable -> L25
            goto L23
        L2f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L15
            return
        L31:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L25
            throw r4     // Catch: java.lang.Throwable -> L15
        L33:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L15
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.x.g(int, java.lang.Object, java.lang.String):void");
    }

    public final boolean h(int i, Object obj) {
        synchronized (g) {
            try {
                long j = this.c;
                if (j == -1) {
                    return false;
                }
                g(i, null, String.format(Locale.ROOT, "clearing request %d", new Object[]{Long.valueOf(j)}));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
