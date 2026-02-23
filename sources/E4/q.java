package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ C c;

    public /* synthetic */ q(A.a aVar, C c) {
        this.a = aVar;
        this.c = c;
    }

    public final void run() {
        A.a.f(this.a, this.c);
    }
}
