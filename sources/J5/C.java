package J5;

import J5.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class c implements p.c {
    public final /* synthetic */ o a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ long c;
    public final /* synthetic */ TimeUnit d;

    public /* synthetic */ c(o oVar, Runnable runnable, long j, TimeUnit timeUnit) {
        this.a = oVar;
        this.b = runnable;
        this.c = j;
        this.d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return o.l(this.a, this.b, this.c, this.d, bVar);
    }
}
