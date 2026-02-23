package O5;

import android.os.Process;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d implements Runnable {
    public abstract void a();

    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
