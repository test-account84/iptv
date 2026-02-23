package a1;

import Q0.t;
import androidx.work.impl.WorkDatabase;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m implements Runnable {
    public static final String e = Q0.k.f("StopWorkRunnable");
    public final R0.j a;
    public final String c;
    public final boolean d;

    public m(R0.j jVar, String str, boolean z) {
        this.a = jVar;
        this.c = str;
        this.d = z;
    }

    public void run() {
        boolean o;
        WorkDatabase q = this.a.q();
        R0.d o2 = this.a.o();
        Z0.q B = q.B();
        q.c();
        try {
            boolean h = o2.h(this.c);
            if (this.d) {
                o = this.a.o().n(this.c);
            } else {
                if (!h && B.g(this.c) == t.RUNNING) {
                    B.d(t.ENQUEUED, this.c);
                }
                o = this.a.o().o(this.c);
            }
            Q0.k.c().a(e, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.c, Boolean.valueOf(o)}), new Throwable[0]);
            q.r();
            q.g();
        } catch (Throwable th) {
            q.g();
            throw th;
        }
    }
}
