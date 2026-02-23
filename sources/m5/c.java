package M5;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c implements b, a {
    public final e a;
    public final int b;
    public final TimeUnit c;
    public CountDownLatch e;
    public final Object d = new Object();
    public boolean f = false;

    public c(e eVar, int i, TimeUnit timeUnit) {
        this.a = eVar;
        this.b = i;
        this.c = timeUnit;
    }

    public void a(String str, Bundle bundle) {
        synchronized (this.d) {
            try {
                L5.f.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.e = new CountDownLatch(1);
                this.f = false;
                this.a.a(str, bundle);
                L5.f.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.e.await(this.b, this.c)) {
                        this.f = true;
                        L5.f.f().i("App exception callback received from Analytics listener.");
                    } else {
                        L5.f.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    L5.f.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
