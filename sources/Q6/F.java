package q6;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class f implements Runnable {
    public /* synthetic */ h a;
    public /* synthetic */ Intent c;
    public /* synthetic */ TaskCompletionSource d;

    public /* synthetic */ f(h hVar, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.a = hVar;
        this.c = intent;
        this.d = taskCompletionSource;
    }

    public final void run() {
        this.a.g(this.c, this.d);
    }
}
