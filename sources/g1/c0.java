package g1;

import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ Future a;
    public final /* synthetic */ Runnable c;

    public /* synthetic */ c0(Future future, Runnable runnable) {
        this.a = future;
        this.c = runnable;
    }

    public final void run() {
        Future future = this.a;
        if (future.isDone() || future.isCancelled()) {
            return;
        }
        Runnable runnable = this.c;
        future.cancel(true);
        zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
        if (runnable != null) {
            runnable.run();
        }
    }
}
