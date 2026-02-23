package K3;

import android.os.HandlerThread;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ HandlerThread a;

    public /* synthetic */ r(HandlerThread handlerThread) {
        this.a = handlerThread;
    }

    public final void run() {
        this.a.quit();
    }
}
