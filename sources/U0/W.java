package u0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class w implements Executor {
    public final /* synthetic */ Handler a;

    public /* synthetic */ w(Handler handler) {
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
