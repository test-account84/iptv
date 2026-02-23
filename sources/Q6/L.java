package q6;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class l implements Callable {
    public /* synthetic */ Context a;
    public /* synthetic */ Intent b;

    public /* synthetic */ l(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public final Object call() {
        return n.d(this.a, this.b);
    }
}
