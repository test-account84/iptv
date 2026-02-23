package L;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {

    public static class a implements Executor {
        public final Handler a;

        public a(Handler handler) {
            this.a = (Handler) O.h.f(handler);
        }

        public void execute(Runnable runnable) {
            if (this.a.post((Runnable) O.h.f(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
