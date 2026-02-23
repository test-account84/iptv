package z3;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ n a;
    public final /* synthetic */ IOException c;

    public /* synthetic */ l(n nVar, IOException iOException) {
        this.a = nVar;
        this.c = iOException;
    }

    public final void run() {
        n.c(this.a, this.c);
    }
}
