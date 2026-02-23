package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ Object c;
    public final /* synthetic */ long d;

    public /* synthetic */ s(A.a aVar, Object obj, long j) {
        this.a = aVar;
        this.c = obj;
        this.d = j;
    }

    public final void run() {
        A.a.d(this.a, this.c, this.d);
    }
}
