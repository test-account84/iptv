package U5;

import java.util.concurrent.CountDownLatch;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ CountDownLatch c;

    public /* synthetic */ d(e eVar, CountDownLatch countDownLatch) {
        this.a = eVar;
        this.c = countDownLatch;
    }

    public final void run() {
        e.b(this.a, this.c);
    }
}
