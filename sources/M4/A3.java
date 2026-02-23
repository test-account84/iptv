package M4;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a3 implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ t3 c;

    public a3(t3 t3Var, long j) {
        this.c = t3Var;
        this.a = j;
    }

    public final void run() {
        this.c.z(this.a, true);
        this.c.a.L().S(new AtomicReference());
    }
}
