package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public /* synthetic */ z(A.a aVar, long j, int i) {
        this.a = aVar;
        this.c = j;
        this.d = i;
    }

    public final void run() {
        A.a.e(this.a, this.c, this.d);
    }
}
