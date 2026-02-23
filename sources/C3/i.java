package C3;

import B3.C;
import C3.h;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ h.c a;
    public final /* synthetic */ C.b c;
    public final /* synthetic */ IOException d;

    public /* synthetic */ i(h.c cVar, C.b bVar, IOException iOException) {
        this.a = cVar;
        this.c = bVar;
        this.d = iOException;
    }

    public final void run() {
        h.c.d(this.a, this.c, this.d);
    }
}
