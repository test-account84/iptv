package l1;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements ThreadFactory {
    public final int a;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public void run() {
            try {
                Process.setThreadPriority(f.a(f.this));
            } catch (Throwable unused) {
            }
            this.a.run();
        }
    }

    public f(int i) {
        this.a = i;
    }

    public static /* synthetic */ int a(f fVar) {
        return fVar.a;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(new a(runnable));
    }
}
