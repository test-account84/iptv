package d;

import d.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ z.a a;
    public final /* synthetic */ Runnable c;

    public /* synthetic */ y(z.a aVar, Runnable runnable) {
        this.a = aVar;
        this.c = runnable;
    }

    public final void run() {
        z.a.a(this.a, this.c);
    }
}
