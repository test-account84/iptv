package J5;

import J5.p;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class h implements p.c {
    public final /* synthetic */ o a;
    public final /* synthetic */ Callable b;
    public final /* synthetic */ long c;
    public final /* synthetic */ TimeUnit d;

    public /* synthetic */ h(o oVar, Callable callable, long j, TimeUnit timeUnit) {
        this.a = oVar;
        this.b = callable;
        this.c = j;
        this.d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return o.a(this.a, this.b, this.c, this.d, bVar);
    }
}
