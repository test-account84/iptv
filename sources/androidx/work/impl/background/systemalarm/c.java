package androidx.work.impl.background.systemalarm;

import Q0.k;
import Z0.p;
import a1.n;
import a1.r;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.d;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c implements V0.c, R0.b, r.b {
    public static final String k = k.f("DelayMetCommandHandler");
    public final Context a;
    public final int c;
    public final String d;
    public final d e;
    public final V0.d f;
    public PowerManager.WakeLock i;
    public boolean j = false;
    public int h = 0;
    public final Object g = new Object();

    public c(Context context, int i, String str, d dVar) {
        this.a = context;
        this.c = i;
        this.e = dVar;
        this.d = str;
        this.f = new V0.d(context, dVar.f(), this);
    }

    public void a(String str) {
        k.c().a(k, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        g();
    }

    public void b(List list) {
        g();
    }

    public final void c() {
        synchronized (this.g) {
            try {
                this.f.e();
                this.e.h().c(this.d);
                PowerManager.WakeLock wakeLock = this.i;
                if (wakeLock != null && wakeLock.isHeld()) {
                    k.c().a(k, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.i, this.d}), new Throwable[0]);
                    this.i.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(String str, boolean z) {
        k.c().a(k, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z)}), new Throwable[0]);
        c();
        if (z) {
            Intent f = a.f(this.a, this.d);
            d dVar = this.e;
            dVar.k(new d.b(dVar, f, this.c));
        }
        if (this.j) {
            Intent a = a.a(this.a);
            d dVar2 = this.e;
            dVar2.k(new d.b(dVar2, a, this.c));
        }
    }

    public void e() {
        this.i = n.b(this.a, String.format("%s (%s)", new Object[]{this.d, Integer.valueOf(this.c)}));
        k c = k.c();
        String str = k;
        c.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.i, this.d}), new Throwable[0]);
        this.i.acquire();
        p h = this.e.g().q().B().h(this.d);
        if (h == null) {
            g();
            return;
        }
        boolean b = h.b();
        this.j = b;
        if (b) {
            this.f.d(Collections.singletonList(h));
        } else {
            k.c().a(str, String.format("No constraints for %s", new Object[]{this.d}), new Throwable[0]);
            f(Collections.singletonList(this.d));
        }
    }

    public void f(List list) {
        if (list.contains(this.d)) {
            synchronized (this.g) {
                try {
                    if (this.h == 0) {
                        this.h = 1;
                        k.c().a(k, String.format("onAllConstraintsMet for %s", new Object[]{this.d}), new Throwable[0]);
                        if (this.e.e().j(this.d)) {
                            this.e.h().b(this.d, 600000L, this);
                        } else {
                            c();
                        }
                    } else {
                        k.c().a(k, String.format("Already started work for %s", new Object[]{this.d}), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void g() {
        synchronized (this.g) {
            try {
                if (this.h < 2) {
                    this.h = 2;
                    k c = k.c();
                    String str = k;
                    c.a(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.d}), new Throwable[0]);
                    Intent g = a.g(this.a, this.d);
                    d dVar = this.e;
                    dVar.k(new d.b(dVar, g, this.c));
                    if (this.e.e().g(this.d)) {
                        k.c().a(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.d}), new Throwable[0]);
                        Intent f = a.f(this.a, this.d);
                        d dVar2 = this.e;
                        dVar2.k(new d.b(dVar2, f, this.c));
                    } else {
                        k.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.d}), new Throwable[0]);
                    }
                } else {
                    k.c().a(k, String.format("Already stopped work for %s", new Object[]{this.d}), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
