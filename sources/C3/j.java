package C3;

import B3.C;
import C3.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ h.c a;
    public final /* synthetic */ C.b c;

    public /* synthetic */ j(h.c cVar, C.b bVar) {
        this.a = cVar;
        this.c = bVar;
    }

    public final void run() {
        h.c.c(this.a, this.c);
    }
}
