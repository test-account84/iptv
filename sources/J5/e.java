package J5;

import J5.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ p.b c;

    public /* synthetic */ e(Runnable runnable, p.b bVar) {
        this.a = runnable;
        this.c = bVar;
    }

    public final void run() {
        o.h(this.a, this.c);
    }
}
