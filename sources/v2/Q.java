package V2;

import V2.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ w.a a;
    public final /* synthetic */ w c;
    public final /* synthetic */ Exception d;

    public /* synthetic */ q(w.a aVar, w wVar, Exception exc) {
        this.a = aVar;
        this.c = wVar;
        this.d = exc;
    }

    public final void run() {
        w.a.e(this.a, this.c, this.d);
    }
}
