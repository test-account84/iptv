package M4;

import android.os.Handler;
import com.google.android.gms.internal.measurement.zzby;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o {
    public static volatile Handler d;
    public final G2 a;
    public final Runnable b;
    public volatile long c;

    public o(G2 g2) {
        com.google.android.gms.common.internal.r.m(g2);
        this.a = g2;
        this.b = new n(this, g2);
    }

    public static /* bridge */ /* synthetic */ void a(o oVar, long j) {
        oVar.c = 0L;
    }

    public final void b() {
        this.c = 0L;
        f().removeCallbacks(this.b);
    }

    public abstract void c();

    public final void d(long j) {
        b();
        if (j >= 0) {
            this.c = this.a.a().a();
            if (f().postDelayed(this.b, j)) {
                return;
            }
            this.a.d().r().b("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean e() {
        return this.c != 0;
    }

    public final Handler f() {
        Handler handler;
        if (d != null) {
            return d;
        }
        synchronized (o.class) {
            try {
                if (d == null) {
                    d = new zzby(this.a.c().getMainLooper());
                }
                handler = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
