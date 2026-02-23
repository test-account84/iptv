package l1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements Executor {
    public final Handler a = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
