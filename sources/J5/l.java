package J5;

import J5.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ o a;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ p.b d;

    public /* synthetic */ l(o oVar, Runnable runnable, p.b bVar) {
        this.a = oVar;
        this.c = runnable;
        this.d = bVar;
    }

    public final void run() {
        o.k(this.a, this.c, this.d);
    }
}
