package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ Exception c;

    public /* synthetic */ v(A.a aVar, Exception exc) {
        this.a = aVar;
        this.c = exc;
    }

    public final void run() {
        A.a.b(this.a, this.c);
    }
}
