package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public /* synthetic */ r(A.a aVar, int i, long j) {
        this.a = aVar;
        this.c = i;
        this.d = j;
    }

    public final void run() {
        A.a.a(this.a, this.c, this.d);
    }
}
