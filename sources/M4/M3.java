package M4;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m3 implements Runnable {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ t3 c;

    public m3(t3 t3Var, AtomicReference atomicReference) {
        this.c = t3Var;
        this.a = atomicReference;
    }

    public final void run() {
        synchronized (this.a) {
            try {
                try {
                    this.a.set(Double.valueOf(this.c.a.z().k(this.c.a.B().s(), m1.Q)));
                } finally {
                    this.a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
