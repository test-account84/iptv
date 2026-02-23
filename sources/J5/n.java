package J5;

import J5.p;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ Callable a;
    public final /* synthetic */ p.b c;

    public /* synthetic */ n(Callable callable, p.b bVar) {
        this.a = callable;
        this.c = bVar;
    }

    public final void run() {
        o.d(this.a, this.c);
    }
}
