package V2;

import V2.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ w.a a;
    public final /* synthetic */ w c;
    public final /* synthetic */ int d;

    public /* synthetic */ s(w.a aVar, w wVar, int i) {
        this.a = aVar;
        this.c = wVar;
        this.d = i;
    }

    public final void run() {
        w.a.d(this.a, this.c, this.d);
    }
}
