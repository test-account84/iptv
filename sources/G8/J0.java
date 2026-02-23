package G8;

import G8.i0;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class j0 extends h0 {
    public abstract Thread r0();

    public void s0(long j, i0.b bVar) {
        Q.i.D0(j, bVar);
    }

    public final void t0() {
        Thread r0 = r0();
        if (Thread.currentThread() != r0) {
            c.a();
            LockSupport.unpark(r0);
        }
    }
}
