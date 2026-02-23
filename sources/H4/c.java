package h4;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends Thread {
    public final WeakReference a;
    public final long c;
    public final CountDownLatch d = new CountDownLatch(1);
    public boolean e = false;

    public c(a aVar, long j) {
        this.a = new WeakReference(aVar);
        this.c = j;
        start();
    }

    public final void a() {
        a aVar = (a) this.a.get();
        if (aVar != null) {
            aVar.e();
            this.e = true;
        }
    }

    public final void run() {
        try {
            if (this.d.await(this.c, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
