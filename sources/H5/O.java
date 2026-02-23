package H5;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.internal.firebase-auth-api.zzg;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o {
    public static A4.a h = new A4.a("TokenRefresher", "FirebaseAuth:");
    public final A5.f a;
    public volatile long b;
    public volatile long c;
    public long d;
    public HandlerThread e;
    public Handler f;
    public Runnable g;

    public o(A5.f fVar) {
        h.f("Initializing TokenRefresher", new Object[0]);
        A5.f fVar2 = (A5.f) com.google.android.gms.common.internal.r.m(fVar);
        this.a = fVar2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.e = handlerThread;
        handlerThread.start();
        this.f = new zzg(this.e.getLooper());
        this.g = new n(this, fVar2.o());
        this.d = 300000L;
    }

    public static /* bridge */ /* synthetic */ A4.a a() {
        return h;
    }

    public final void b() {
        this.f.removeCallbacks(this.g);
    }

    public final void c() {
        h.f("Scheduling refresh for " + (this.b - this.d), new Object[0]);
        b();
        this.c = Math.max((this.b - C4.h.c().a()) - this.d, 0L) / 1000;
        this.f.postDelayed(this.g, this.c * 1000);
    }

    public final void d() {
        int i = (int) this.c;
        this.c = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * this.c : i != 960 ? 30L : 960L;
        this.b = C4.h.c().a() + (this.c * 1000);
        h.f("Scheduling refresh for " + this.b, new Object[0]);
        this.f.postDelayed(this.g, this.c * 1000);
    }
}
